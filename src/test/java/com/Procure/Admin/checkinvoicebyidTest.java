package com.Procure.Admin;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scm.Procure.pom.AdminHomePage;
import com.scm.Procure.pom.invoicesPage;
import com.scm.genericutils.BaseClass;
@Listeners(com.scm.genericutils.ListenerImplimentation.class)
public class checkinvoicebyidTest extends BaseClass {
	@Test(retryAnalyzer = com.scm.genericutils.RetryImpliClass.class, groups = "regression")
	public void checkinvoicebyid() throws Throwable {

		AdminHomePage a = new AdminHomePage(driver);
		a.InvoiceClick();
		//AssertJUnit.fail();
		invoicesPage i = new invoicesPage(driver);
		String searchval = "invoiceId";
		String expeid = "3";
		i.search(searchval, expeid, driver);

	}
}
