package com.sandbox.tafjeemix.ejb;

import javax.ejb.Local;

@Local
public interface TopLocal {

	public String go(String firstName, String lastName);

}
