#####

#CustomerService
cd CustomerMicroService
./build.sh 
cd ..

#PaymentService
cd PaymentMicroService
./build.sh 
cd ..

docker-compose up -d
cd EndToEndTests
mvn test


