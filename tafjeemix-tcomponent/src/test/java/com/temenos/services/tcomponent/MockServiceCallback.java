package com.temenos.services.tcomponent;

import com.temenos.soa.services.T24ServiceCallBack;
import com.temenos.soa.services.data.T24UserDetails;
import com.temenos.soa.services.data.UserDetails;

public class MockServiceCallback implements T24ServiceCallBack {

	@Override
	public UserDetails getUserDetails() {
		// oh dear, why do we have to use the T24UserDetails?
		return new T24UserDetails();
	}

	@Override
	public void setUserDetails(UserDetails arg0) {
		// TODO Auto-generated method stub

	}

}
