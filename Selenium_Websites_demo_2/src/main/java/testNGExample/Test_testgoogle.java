package testNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_testgoogle {

	@Test
	public void testgoogle() {
		Assert.assertTrue(false); // change to true 
		System.out.println("Google is working fine");
	}
}


/*
 * 
In the testng.xml file, the suite name is Test_app. Therefore, in the test-output, there is a folder called Test_app. Expand that to get a file called testng-failed.xml 

to rerun failed test cases in TestNG. Go back to Test_testgoogle, change the assert value to true and rerun the testng-failed.xml file. This will execute only the failed test case with the correct output. In order to cross-check, execute the original testng.xml file and check if all the test cases are working as expected.



*/