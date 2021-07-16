variable "PATH_TO_PUBLIC_KEY" {
    default = "/var/jenkins_home/.ssh/my_aws.pub" 
}

variable "PATH_TO_PRIVATE_KEY" {
    default = "/var/jenkins_home/.ssh/my_aws"
}

variable "INSTANCE_USERNAME" {
    default = "jenkins"
}
