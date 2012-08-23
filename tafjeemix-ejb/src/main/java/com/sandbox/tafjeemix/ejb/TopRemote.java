package com.sandbox.tafjeemix.ejb;

import javax.ejb.Remote;

@Remote
public interface TopRemote {

	public String go(String firstName, String lastName);

}
