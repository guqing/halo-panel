version: '2'
services:

  nginx:
    restart: always
    image: nginx
    container_name: nginx
    ports:
      - 80:80
      - 443:443
    volumes:
      - /etc/nginx/conf.d:/etc/nginx/conf.d
      - /etc/nginx/vhost.d:/etc/nginx/vhost.d
      - /usr/share/nginx/html:/usr/share/nginx/html
      - /etc/nginx/certs:/etc/nginx/certs:ro

  halo:
    restart: always
    image: ruibaby/halo
    container_name: halo
    ports:
      - 8090:8090
    environment:
      - VIRTUAL_PORT=8090
      - VIRTUAL_HOST=${host!}  # 你的博客地址（务必修改）
      - LETSENCRYPT_HOST=${host!} # 你的博客地址 （务必修改）
      - LETSENCRYPT_EMAIL=${email!} # 证书所有者的邮箱，快过期时会提醒（务必修改）
      - MAX_UPLOAD_SIZE=10m
      - JVM_XMS=256m
      - JVM_XMX=256m
    volumes:
      - ~/.halo:/root/.halo

  docker-gen:
    restart: always
    image: jwilder/docker-gen
    container_name: docker-gen
    volumes:
      - /var/run/docker.sock:/tmp/docker.sock:ro
      - /etc/nginx/nginx.tmpl:/etc/docker-gen/templates/nginx.tmpl:ro
    volumes_from:
      - nginx
    entrypoint: /usr/local/bin/docker-gen -notify-sighup nginx -watch -wait 5s:30s
      /etc/docker-gen/templates/nginx.tmpl /etc/nginx/conf.d/default.conf

  letsencrypt-nginx-proxy-companion:
    restart: always
    image: jrcs/letsencrypt-nginx-proxy-companion
    container_name: letsencrypt-nginx-proxy-companion
    volumes_from:
      - nginx
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock:ro
      - /etc/nginx/certs:/etc/nginx/certs:rw
    environment:
      - NGINX_DOCKER_GEN_CONTAINER=docker-gen
