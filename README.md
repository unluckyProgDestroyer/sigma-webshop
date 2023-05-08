# sigma webshop, a fictional webshop

# Technical informations
 - Sessions stored with Redis
 - Entities stored in hsql database.
 - Uploaded image files stored in the file system. You may declare SIGMASHOP_UPLOADPATH environment variable, the default is the root path for upload directory.
 - Route security based on blacklist and Principle of least privilege.
 - Fronted links not yet connected to database routes.
 
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
