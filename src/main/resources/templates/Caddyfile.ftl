https://${domain!} {
 gzip
 tls ${email!}
 proxy / localhost:${port?c} {
  transparent
 }
}
