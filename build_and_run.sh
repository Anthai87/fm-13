#####

#CustomerService
cd CustomerMicroService
./build.sh 
cd ..

#PaymentService
cd PaymentMicroService
./build.sh 
cd ..
#reportService
cd ReportMicroService
./build.sh 
cd ..
#tokenService
cd TokenMicroService
./build.sh 
cd ..

#MerchantService
cd MerchantMicroService
./build.sh 
cd ..


docker-compose -f docker-compose.yml up -d --build --force-recreate 

cd EndToEndTests
mvn test

docker image prune -f


