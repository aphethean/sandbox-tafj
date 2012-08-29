sandbox-tafjeemix
=================

A simple experiment to mix TAFJ components with regular JEE components.

# Overview

This projects contains one EJB (Top) that calls both the TAFJ component and the JEE component.  It uses
the same datasource and commits the work in one transaction.

Currently the example is split into two main examples until we are able to successfully combine the TAFJ components and JEE components.

## The main example

The main example is just a few vanilla JEE 6 components.

### Building the main example

This example uses maven to build and package a JEE 6 compliant enterprise application.

	$ cd tafjeemix-parent
	$ mvn clean install

### Running the main example

Deploy the tafjeemix-ear in an application server (tested with JBoss AS7).  The application server should have a 
datasource called 'java:jboss/datasources/DefaultDS' bound.  See tafjeemix-demoejb/src/main/resources/META-INF/persistence.xml

Using a web browser you can view.

	http://localhost:8080/demo (shows a little jsf webapp of mock Students/Courses)
	http://localhost:8080/tafjeemix/foo?firstname=Me&lastname=Too (directly calls the Top EJB and adds a Student)


## TComponent example

The tafjeemix-tcomponent example uses the component framework (currently apigen) to create a Java & jBC interface from a UML model.  We then call the jBC 
implementation (via the Java interface) from a simple JUnit4 test.

### Installing dependencies for tafjeemix-tcomponent

We want to use maven to compile our tcomponent jar into a project.  Therefore we need to 
install our dependencies in the local maven repository as we don't publish these dependencies currently.

(NB - be sure to set TAFJ_HOME first)
<pre>
	mvn install:install-file -DgroupId=com.temenos -DartifactId=tafj-common -Dversion=dev -Dpackaging=jar -Dfile=%TAFJ_HOME%/lib/TAFJCommon.jar -DgeneratePom=true
	mvn install:install-file -DgroupId=com.temenos -DartifactId=tafj-core -Dversion=dev -Dpackaging=jar -Dfile=%TAFJ_HOME%/lib/TAFJCore.jar -DgeneratePom=true
	mvn install:install-file -DgroupId=com.temenos -DartifactId=tafj-locking -Dversion=dev -Dpackaging=jar -Dfile=%TAFJ_HOME%/lib/TAFJLocking.jar -DgeneratePom=true
	mvn install:install-file -DgroupId=com.temenos -DartifactId=tafj-collectorclient -Dversion=dev -Dpackaging=jar -Dfile=%TAFJ_HOME%/lib/T24CollectorClient.jar -DgeneratePom=true
	mvn install:install-file -DgroupId=com.temenos -DartifactId=tafc-jremote -Dversion=dev -Dpackaging=jar -Dfile=%TAFJ_HOME%/lib/jremote.jar -DgeneratePom=true
	mvn install:install-file -DgroupId=com.temenos -DartifactId=component-framework -Dversion=dev -Dpackaging=jar -Dfile=./tafjeemix-tcomponent/lib/tComponentFramework.jar -DgeneratePom=true
</pre>

### Building tafjeemix-tcomponent

This example uses an ant build task to call apigen and the TAFJ compiler (as this was already available), but we then use
maven to compile & package the generated jBC, Java, and TAFJ generated Java into a simple jar.  The JUnit test (the main
execution of this example) is run during the test phase.

	$ cd tafjeemix-tcomponent
	$ mvn clean install


