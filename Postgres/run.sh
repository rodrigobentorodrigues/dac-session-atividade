sudo docker stop banco
sudo docker rm banco
sudo docker rmi sessionbean/banco
sudo docker build -t sessionbean/banco .
sudo docker run -p 5433:5432 -d --name banco sessionbean/banco
