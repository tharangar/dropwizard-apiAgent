
Main objective of this project is to make supper easy api server implementation.
# Prelimanary Investigations.
Ref 1:
https://www.gajotres.net/best-available-java-restful-micro-frameworks/
https://www.gajotres.net/best-available-java-restful-micro-frameworks/
https://way2java.com/networking/chat-program-two-way-communication/

https://www.quora.com/Whats-the-best-RESTful-web-framework-to-use-with-Java
Vineet Sinha, Founder of Architexa
Updated Sep 20, 2012
Both Restlet and Spring have great Rest support. However, using their strongest parts require using their using the non-standard APIs.

I would recommend considering the standard - JAX-RS and the reference implementation Jersey: http://jersey.java.net/

Beyond Restlet, Spring, Jersey, there is also RESTEasy and a number of others.

A larger framework that does a lot more than Rest is the Play Framework. If you are starting a project from scratch and don't mind thinking within their constrains, I highly recommend it.

https://jersey.github.io/

# dropwizard
https://www.gajotres.net/best-available-java-restful-micro-frameworks/
https://www.dropwizard.io/1.3.5/docs/getting-started.html

# API security update
https://howtodoinjava.com/jersey/jersey-rest-security/
https://docs.oracle.com/cd/E24329_01/web.1211/e24983/secure.htm#RESTF256

# Introduction

The Dropwizard example application was developed to, as its name implies, provide examples of some of the features
present in Dropwizard.

# Overview

Included with this application is an example of the optional DB API module. The examples provided illustrate a few of
the features available in [Hibernate](http://hibernate.org/), along with demonstrating how these are used from within
Dropwizard.

This database example is comprised of the following classes:

* The `PersonDAO` illustrates using the Data Access Object pattern with assisting of Hibernate.

* The `Person` illustrates mapping of Java classes to database tables with assisting of JPA annotations.

* All the JPQL statements for use in the `PersonDAO` are located in the `Person` class.

* `migrations.xml` illustrates the usage of `dropwizard-migrations` which can create your database prior to running
your application for the first time.

* The `PersonResource` and `PeopleResource` are the REST resource which use the PersonDAO to retrieve data from the database, note the injection
of the PersonDAO in their constructors.

As with all the modules the db example is wired up in the `initialize` function of the `HelloWorldApplication`.

# Start Developments

To start development the project can be downloaded from the github repository.

      git clone https://github.com/tharangar/dropwizard-apiAgent.git
      
Change to the directory
<<<<<<< HEAD
=======

	cd dropwizard-apiAgent/
	
Start maven compile

	mvn compile
	




# Running The Application
>>>>>>> f3689add4a3c29feb28fc99818f1217d4bc387b7

	cd dropwizard-apiAgent
	
To test the example application run the following commands.

* To create the example, package the application usToing [Apache Maven](https://maven.apache.org/) from the root dropwizard directory.


	mvn compile

Installing necessary softwares

        mvn install

Making the package for deployment

        mvn package

# Running The Application

* To setup the h2 database run.

        java -jar target/dw-agent-1.4.0-SNAPSHOT.jar db migrate example.yml

* To run the server run.

        java -jar ./target/dw-agent-1.4.0-SNAPSHOT.jar server example.yml

* To hit the Hello World example (hit refresh a few times).

	http://localhost:8181/hello-world

* To post data into the application.

	curl -H "Content-Type: application/json" -X POST -d '{"fullName":"T2","jobTitle":"TT"}' http://localhost:8181/people
	
	open http://localhost:8080/people
	
* view one person details
  
  open http://localhost:8181/people/1
 
 * Run internal shell command
 
 http://localhost:8181/updateav
 
 * Load a User interface instead of a json output
 
 http://localhost:8181/ui/clam
	
* Further Development ------------------------------------------------------------------------

 If you are using vscode for development
 code . 
 will open the vscode for code editing.
 
 * After code changes you have to package the program again
 mvn package
 
 * After theat run the server again
 
 java -jar ./target/dw-agent-1.4.0-SNAPSHOT.jar server example.yml
