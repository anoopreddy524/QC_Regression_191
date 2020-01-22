package tests;
import java.awt.List;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestNGMethod;

public class TestListeners implements ISuiteListener {
	
	
	 private long testCount = 0 ; 
	 private java.util.List<ITestNGMethod> testMethods = null;

	 public void setTestCount(long testCount){
	      this.testCount = testCount;
	 }

	 public long getTestCount(){
	     return this.testCount;
	 }
	
	
	
	@Override
	public void onStart(ISuite suite) {
		
		   testMethods  = suite.getAllMethods();
	       this.testCount = testMethods.size();
	       System.out.println(" Test cases currently running :"+testCount);
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}


}