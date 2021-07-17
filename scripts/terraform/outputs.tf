output "public_ip_address" {
    value = aws_instance.server1.public_ip
}


output "needed_for_ansible" {
    value = local.someVariable
}

