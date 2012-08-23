package com.sandbox.tafjeemix.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.sandbox.tafjeemix.demoejb.SchoolDao;
import com.sandbox.tafjeemix.demojar.Person;
import com.sandbox.tafjeemix.demojar.Student;

/**
 * Session Bean implementation class Top
 */
@Stateless
@LocalBean
public class Top implements TopRemote, TopLocal {

	@EJB
	private SchoolDao schoolDao;


    /**
     * Default constructor. 
     */
    public Top() {
        // TODO Auto-generated constructor stub
    }

    public String go(String firstName, String lastName) {
    	
    	// Add a new Person
    	Person p = schoolDao.save(new Student(firstName, lastName));
    	
    	// Add a record in jBC component (or abort, which should also rollback the added Person)
    	
    	
    	return "hello " + firstName + lastName + " (" + p.getId() + ")";
    }
}
