# Extended MVC Architecture(Layered) Employee Management System Insteller

### FAQ

#### 1. How do I run this project?

Simple just clone the project first and then import the project into the IntelliJ IDEA.

#### 2. Do I need to add libraries?

Yes, this project doesn't ship any dependencies with it. 
This project depends on [`jfoenix`](https://mvnrepository.com/artifact/com.jfoenix/jfoenix/8.0.10) and
[`mysql-connector-java`](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.21). Make sure to add them  to your module's dependencies list.  

#### 3. How can I reproduce the DB for this Demo?

You can find the Application Properties script [here](resources/application.properties).
You can find the database script [here](src/db/DBScript). Don't execute everything blindly.

#### 4. Language & Technologies

- [x] Java
- [x] JavaFX 
- [x] Extended MVC Architecture(Layered) 
- [x] SQL

- [x] According to the SOLID principles and "Dependency Injection" with well normalized database using SQL include this project.
- [x] Design Patterns,
  - [x] Singleton Design Pattern Using for DBConnection.
  - [x] Facade Design Pattern.
  - [x] Adapter Design Pattern.
  - [x] Factory Design Pattern.
  - [x] DAO Design Pattern.
  - [x] DTO Design Pattern. 

#### 5. What should I need to do with this project?
 
Once you have imported this project into the IntelliJ IDEA, 
go to **View** > **Tool Windows** > **TODO**. It will open up the TODO window where you can find what you have to do with this project and where you have to do it.
Following functions are included in this project.
- [x] Employee Management
  - [x] Saving Employee
  - [x] Updating Employee
  - [x] Deleting Employee
  - [x] Show Employee
  
- [x] Login Management
 
- [x] User Management

- [x] Registration Management

- [x] Profile Management


#### 6. Use the following table records in order to login with different access privileges.

- [1] You're run to the system first of all you will be appear main form and you can login to the
system and register to the system as you wish.

- [2] Login to the system.
- [x] SELECT * FROM login;
+---------+----------+-------------------------------+------------+
| loginId | userType | email                         | password   |
+---------+----------+-------------------------------+------------+
|       1 | Admin    | SulakkanaDisanayake@gmail.com | admin@1234 |
|       2 | User     | SurangaDeSilva@gmail.com      | user@1234  |
+---------+----------+-------------------------------+------------+

-[2] You're loginas an "Admin", After you appear Home Form, 
-[x] Click on "NEW EMPLOYEE" button automatically generate new Employee ID, then insert employee
details and click on the "SAVE" button Successfully save empl0yee in to the database.

-[x] Now you click on the table row, Automatically show you're inserted employee details in the
suitable columns, After you can update employee details click on the "UPDATE" button
Successfully update employee in to the database. 

-[x] Click on the "DELETE" button you can delete employee in the database.

- [MENTION THIS: THIS SYSTEM STILL UNDER TO THE CONSTRUCTION]


Learn to create good README.md files. All the best. Drop me a message if you have any questions.
 
IMP: This will be removed soon, so make sure to download it.