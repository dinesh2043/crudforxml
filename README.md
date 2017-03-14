# Java console application that uses XML parsing for data acquisition from XML file and stores them into MySQL database

This application loads the customer.xml file, then reads xml contents and creats the database table and stores the data into those tables. Complete CRUD operation is implemented in this application. This application consists eight different classes to acomplish the task. The first important class is dbConnection.java, used for database connection with the help of MySql Community server Release Version: 5.5.22 with ODBC Driver and MySql setting for connection string parameters; username "root", password "", port "3306", database "test" and server "localhost". CreateTable.java class is responsible for creating tables. First of all it checks if the table already exists in the database and if it exists then it drops the table and create new ones. CRUD.java is used for insert, read, update and delete operation for SQL query with the help of Customer.java object class. EditCustomer.java class is used to facilitate the process of update operation of CRUD.java class. SAXParserExample.java is responsible for XML parsing to gather the required values and send it to customer object class and use those objects to save it to database. SAParser was used because of its efficiency advantage. At last UserInterface.java class is used to design the console user interface but it would be better to use GUI for better user experience as further development. In this application implementation id is used for customer selection which should be removed and customer selection should be done without using id for better security.

### Following picture illustrates the database schema used for the development of this application.

![img](https://github.com/dinesh2043/crudforxml/blob/master/img1.jpg)

### In the following figure you can see the simple console user interface with the available features.

![img](https://github.com/dinesh2043/crudforxml/blob/master/img2.jpg)

### This is a application output image when the xml file is loaded by the application it looks for the tables if its exists or not. If there is existing table then it drops it and creates new tables and inserts the data into customer, address and contact table.

![img](https://github.com/dinesh2043/crudforxml/blob/master/img3.jpg)

### This application also provides the feature to add new customer information into the datable and it can be seen in the following image.

![img](https://github.com/dinesh2043/crudforxml/blob/master/img4.jpg)

### In the following figure it shows the edit feature implementation of this application.

![img](https://github.com/dinesh2043/crudforxml/blob/master/img5.jpg)

### Following image shows all the existing contents of the database when option 5 was selected 

![img](https://github.com/dinesh2043/crudforxml/blob/master/img7.jpg)

### In the following image you can see the outputs when option 4 is selected to delete a record from the database.

![img](https://github.com/dinesh2043/crudforxml/blob/master/img6.jpg)

### Similarly an individual record can also be selected by choosing the option 6 and providing the id of the customer.

![img](https://github.com/dinesh2043/crudforxml/blob/master/img8.jpg)
