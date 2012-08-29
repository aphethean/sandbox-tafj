package com.temenos.services.tcomponent;

import static org.junit.Assert.*;

import org.junit.Test;

import com.temenos.services.tcomponent.data.Student;
import com.temenos.soa.services.data.ResponseDetails;
import com.temenos.soa.services.tafj.TAFJSessionProperties;

public class TComponentTest {

	@Test
	public void testSuccess() {
		TAFJSessionProperties properties = new TAFJSessionProperties();
		// mandatory property...
		properties.addSessionProperty("OFS_SOURCE", "GCS");
		TComponentImpl component = new TComponentImpl(properties);
		component.setServiceCallBack(new MockServiceCallback());
		ResponseDetails responseDetails = new ResponseDetails();
		component.doStuff("Oxford", new Student("Aaron"), responseDetails);

		// debug
		printResponseDetails(responseDetails);
		
		assertEquals("T24TComponentImpl.doStuff", responseDetails.getServiceName());
		assertEquals("SUCCESS", responseDetails.getReturnCode());
	}

	private void printResponseDetails(ResponseDetails responseDetails) {
		System.out.println(responseDetails);
		for (int i = 0; i < responseDetails.getResponses().length; i++) {
			System.out.println(responseDetails.getResponses()[i]);
		}
	}
	
	@Test
	public void testFailure() {
		TAFJSessionProperties properties = new TAFJSessionProperties();
		// mandatory property...
		properties.addSessionProperty("OFS_SOURCE", "GCS");
		TComponentImpl component = new TComponentImpl(properties);
		component.setServiceCallBack(new MockServiceCallback());
		ResponseDetails responseDetails = new ResponseDetails();
		component.doStuff("Oxford", new Student("Guy"), responseDetails);

		// debug
		printResponseDetails(responseDetails);

		assertEquals("T24TComponentImpl.doStuff", responseDetails.getServiceName());
		assertEquals("FAILURE", responseDetails.getReturnCode());
	}

}
