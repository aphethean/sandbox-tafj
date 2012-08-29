sandbox-tafjeemix
=================

A simple experiment to mix TAFJ components with regular JEE components.

# Overview

This projects contains one EJB (Top) that calls both the TAFJ component and the JEE component.  It uses
the same datasource and commits the work in one transaction.


## Building

We must install our dependencies in the local maven repository as we don't publish these dependencies currently
mvn install:install-file -DgroupId=com.temenos -DartifactId=tafj-common -Dversion=dev -Dpackaging=jar -Dfile=./dependencies/TAFJCommon.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.temenos -DartifactId=tafj-core -Dversion=dev -Dpackaging=jar -Dfile=./dependencies/TAFJCore.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.temenos -DartifactId=tafj-locking -Dversion=dev -Dpackaging=jar -Dfile=./dependencies/TAFJLocking.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.temenos -DartifactId=tafj-collectorclient -Dversion=dev -Dpackaging=jar -Dfile=./dependencies/T24CollectorClient.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.temenos -DartifactId=component-framework -Dversion=dev -Dpackaging=jar -Dfile=./dependencies/tComponentFramework.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.temenos -DartifactId=tafc-jremote -Dversion=dev -Dpackaging=jar -Dfile=./dependencies/jremote.jar -DgeneratePom=true

$ cd tafjeemix-parent
$ mvn clean install


## Running the example

Deploy the tafjeemix-ear in an application server (tested with JBoss AS7).  The application server should have a 
datasource called 'java:jboss/datasources/DefaultDS' bound.  See tafjeemix-demoejb/src/main/resources/META-INF/persistence.xml

Using a web browser you can view:
http://localhost:8080/demo (shows a little jsf webapp of mock Students/Courses)
http://localhost:8080/tafjeemix/foo?firstname=Me&lastname=Too (directly calls the Top EJB and adds a Student)

