package com.brainstation23.automation.test.pages;

public class AutomationTest {
	
	public static void main(String[] args) {
		LoginPage user1 = new LoginPage("imranafccl@gmail.com", "12345");
		user1.setupProperty();
		LoginPage user2 = new LoginPage("imranzfcl@gmail.com", "12345");
		user2.setupProperty();
	};

}
