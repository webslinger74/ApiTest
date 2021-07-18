variable "PATH_TO_PUBLIC_KEY" {
    default = "/var/jenkins_home/.ssh/my_aws.pub" 
}

variable "PATH_TO_PRIVATE_KEY" {
    default = "/var/jenkins_home/.ssh/my_aws"
}

variable "INSTANCE_USERNAME" {
    default = "ec2-user"
}

variable "EC2_AMI_ID" {
  default = "ami-0233c2d874b811deb"   
}
