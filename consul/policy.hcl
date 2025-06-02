acl = {
  policy = "write"
  description = "Allow managing intentions"
  rules = <<EOF
service {
  policy = "write"
}
node {
  policy = "read"
}
EOF
}
