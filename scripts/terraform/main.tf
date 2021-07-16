provider "aws" {
  profile = "default"     // this picks up the ./aws/credentials file
  region = "us-east-2"
}

resource "aws_instance" "server1" {
  ami = "ami-0233c2d874b811deb"
  instance_type= "t2.micro"
  tags = {
    Name = "terraform-example"
}
  key_name = aws_key_pair.aws-key.key_name
  provisioner "file" {
    source = "script.sh"
    destination = "/tmp/script.sh"
}

  provisioner "remote-exec" {
    inline = [
    "chmod +x /tmp/script.sh",
    "sudo /tmp/script.sh"
]
}
  connection {
    type = "ssh"
    host = aws_instance.server1.public_ip
    user = var.INSTANCE_USERNAME
    private_key = file(var.PATH_TO_PRIVATE_KEY)
}
}

# resource "aws_security_group" "instance" {
#   name = "terraform-example-instance"
# }

resource "aws_key_pair" "aws-key" {
  key_name = "aws-key"
  public_key = file(var.PATH_TO_PUBLIC_KEY)
}
   
