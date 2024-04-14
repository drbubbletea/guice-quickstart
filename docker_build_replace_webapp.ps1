# build the webapp module and replace it in the Docker Compose group
./mvnw clean package -Pproduction -f ./tb-webapp/pom.xml

docker-compose up -d --no-deps --build webapp