!#/bin/bash

echo "apt install docker starting"
sudo yum update
sudo yum install -y docker
echo "docker installed"
service docker start
echo "docker daemon started"
sudo docker build -t some-content-nginx ../.
docker run --name some-nginx -d -p 8080:80 some-content-nginx
