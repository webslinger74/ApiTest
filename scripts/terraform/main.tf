provider "aws" {
  profile = "default"     // this picks up the ./aws/credentials file
  region = "us-east-2"
}

resource "aws_eip" "lb" {
  vpc = true
  }

resource "aws_eip_association" "eip_assoc" {
  instance_id = aws_instance.server1.id
  allocation_id = aws_eip.lb.id
}

resource "aws_instance" "server1" {
  ami = "ami-0233c2d874b811deb"
  instance_type= "t2.micro"
  tags = {
    Name = "terraform-example"
}
  security_groups = ["${aws_security_group.ingress-all-test.name}"]
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

resource "aws_security_group" "ingress-all-test" {
  name = "terraform-example-instance"
  ingress {
    cidr_blocks = [
      "0.0.0.0/0"
      ]
    from_port = 22
    to_port = 22
    protocol = "tcp"
}
  egress {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_key_pair" "aws-key" {
  key_name = "my_aws"
  public_key = file(var.PATH_TO_PUBLIC_KEY)
}
   
