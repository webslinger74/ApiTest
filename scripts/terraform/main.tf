provider "aws" {
  profile = "default
  region = "us-east-2"
}

resource "aws_instance" "server1" {
  ami = "ami-0233c2d874b811deb"
  instance_type= "t2.micro"
  tags = {
    Name = "terraform-example"
}
  key_name = aws_key_pair.stekeyterra.key_name
}

resource "aws_security_group" "instance" {
  name = "terraform-example-instance"
}

resource "aws_key_pair "skekeyterra" {
  key_name = "stekeyterra"
  public_key = file(var.PATH_TO_PUBLIC_KEY)
}
   
