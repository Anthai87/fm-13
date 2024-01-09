#####

#CustomerService
cd CustomerMicroService
./build.sh 
cd ..

#PaymentService
cd PaymentMicroService
./build.sh 
cd ..

docker compose -f docker-compose.yml up -d --build --force-recreate 

cd EndToEndTests
mvn test


