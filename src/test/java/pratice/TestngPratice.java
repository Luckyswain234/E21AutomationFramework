package pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngPratice {
	@Test( invocationCount=3,priority = 2)
	
	public void  create()
	{
		Assert.fail();
		System.out.println("create");
	}
	@Test(invocationCount=0)
	public void  modify()
	{
		System.out.println("modify");
	}
	@Test()
	public void  delete()
	{
		System.out.println("delete");
	}
	@Test(dependsOnMethods = "create")
	public void select()
	{
		System.out.println("select");
	}
 // if( invocationCount=0 or -1) then it will not run and (enabled = false) it will also not exicuted
	//between invocationCount and priority ,priority will give more priority.
}
