# Shopper Personalized Data API
There are two interfaces to this API:
1. Internal API that enables uploading products metadata and shopper-products relations
2. External API that enables querying shopper's data

Pre-requisites:
1. Java 8
2. MySql Database\
Tables are created upon application start-up

Environment Variables:
1. MYSQL_URL
2. MYSQL_USERNAME
3. MYSQL_PASSWORD

Build and Run:
1. ./gradlew clean build -x test
2. java -jar build/libs/shoppers-data-0.0.1-SNAPSHOT.jar -DMYSQL_URL=`<db url>` -DMYSQL_USERNAME=`<db username>` -DMYSQL_PASSWORD=`<db pw>`

Documentation:
http://localhost:8080/swagger-ui/index.html#/