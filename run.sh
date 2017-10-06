mvn clean install
cd Postgres
sh run.sh
cd ../
sudo docker stop app
sudo docker rm app
sudo docker rmi sessionbean/app
sudo docker build -t sessionbean/app .
sudo docker run -p 8080:8080 -d --name app --link banco:host-banco sessionbean/app
