# Quick Cart POS System

Welcome to the Quick Cart POS System, a Java Swing project with Maven.

## Setup Database

1. Download mysql server
2. Add MySQL Connector/ J Driverto the ```services``` part of your IDE
3. Execute the [databaseSchema.sql](./databaseSchema.sql) on your mysql server
4. Username: root
5. Password: root123

## Setup and Run Project

1. Clone the repository: ```git clone https://github.com/RahimAbbas55/SCD-Term-Project.git```
2. Open the project in any java compiler like net beans, intelliJ, etc
3. Download the jar file pdfbox-3.0.0.jar from https://pdfbox.apache.org/download.html and add to ```src/man/resources```
4. Add the following dependencies in ```pom.xml``` 
    - com.google.api-client 1.32.1
    - com.google.oauth-client 1.32.1
    - com.google.auth 0.22.0
    - org.apache.pdfbox 2.0.30
    - com.itextpdf 5.5.13
    - com.google.apis v4-rev581-1.25.0
    - mysql 8.0.23
    - com.stripe 20.100.0
    - org.jfree 1.5.4
    - com.sun.mail 1.6.2
5. Build and run the project
