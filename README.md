# sigma webshop, a fictional webshop

# Technical informations
 - The project supports Docker (see details below)
 - Sessions stored with Redis
 - Entities stored in hsql database.
 - Uploaded image files stored in the file system. You may declare SIGMASHOP_UPLOADPATH environment variable, the default is the root path for upload directory.
 - Route security based on blacklist and Principle of least privilege.
 - Frontend links not yet connected to backend routes.
 
 # Implemented features
 - User login, logout. Login page will only appear for unauthenticated users, otherwise redirect on /login route.
 - Role based route security
 - Preloaded test users in memory database.
 - Redis Session.
 - User, Product records in (memory) database.
 - Possibility to upload (in the future only image) file, when adding new product.
 
 # Todo features
 - Restricting upload file formats to jpg and/or png
 - Order handling
 - PDF recipient generation for orders.
 - Order history for customers and option to download recipient.
 - Support users, who can access all orders to help out customers when needed.
 - Sending after restocking out of stock product for subscribers.
 - Storage (inventory) database backend, async communication between storage and resource server.
 - Security: CSRF; prevent SQL injection

# Docker support

## Add the required environment variable(s)

### MAVEN_REPOSITORY_PATH
 This variable stands for a folder where the compiler stores local maven repository dependencies. Keeping the maven repository outside the docker will quicken the compile time by reducing the dependency download time.    

 **Windows powershell:**
 ```
 $env:MAVEN_REPOSITORY_PATH='<YOUR_PATH>'
 ```
 
 **Linux/Mac:**
 ```
 export MAVEN_REPOSITORY_PATH=<YOUR_PATH>
 ```

## Add the optional environment variable(s)

### SIGMASHOP_UPLOADPATH
 **Windows powershell:**
 ```
 $env:SIGMASHOP_UPLOADPATH='<YOUR_PATH>'
 ```
 
 **Linux/Mac:**
 ```
 export SIGMASHOP_UPLOADPATH=<YOUR_PATH>
 ```

## Docker compose

In the root folder of the repository issue the following command:
```
docker compose up
```
This should build up the project environment and expose the 8080 port at localhost.
Try out localhost:8080/ in your browser.

## composeTemplate.bat
There is a composeTemplate.bat file which is almost complete and does almost all the work, your only task is to complete the environment variables as you like.
After you changed the file you can run it and see the results.
If everything goes well you should be able to visit localhost:8080/
