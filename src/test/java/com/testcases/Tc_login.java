package com.testcases;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.Baseclass;
import com.pages.Page_login;

public class Tc_login {
	Baseclass base = new Baseclass();

	@BeforeTest

	public void url_launch() {
		try {

			base.setup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void login() throws InterruptedException {
		Page_login lg = new Page_login(base.getdriver());
		lg.login();
		base.teardown();
	}
}
