sandbox-tafjeemix
=================

A simple experiment to mix TAFJ components with regular JEE components.

# Overview

This projects contains one EJB (Top) that calls both the TAFJ component and the JEE component.  It uses
the same datasource and commits the work in one transaction.


## Building

$ mvn clean install


## Running the example

Deploy the tafjeemix-ear in an application server (tested with JBoss AS7).  The application server should have a 
datasource called 'java:jboss/datasources/DefaultDS' bound.  See tafjeemix-demoejb/src/main/resources/META-INF/persistence.xml

Using a web browser you can view:
http://localhost:8080/demo (shows a little jsf webapp of mock Students/Courses)
http://localhost:8080/tafjeemix/foo?firstname=Me&lastname=Too (directly calls the Top EJB and adds a Student)

