package vtiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
	@Test
	public void test() 
	{
		String BROWSER=System.getProperty("browser");
		System.out.println(BROWSER);
	}

}
