package tests;

public class VQC_Deceased_Admin extends QCStore {
		public static String State;
		public static String SSN1;
		public static String SSN2;
		public static String SSN3;
		
		public static void Deceased_Admin(String SSN, String AppURL) throws InterruptedException {

			
				
				int lastrow = TestData.getLastRow("Deceased");
				String sheetName = "Deceased";

			
				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					String StoreID = TestData.getCellData(sheetName, "StoreID", row);
				    String Deceased=TestData.getCellData(sheetName, "Deceased", row);
					//String CountofDollarCoins = TestData.getCellData(sheetName, "CountofDollarCoins", row);
					//String BankerPIN = TestData.getCellData(sheetName, "BankerPIN", row);
					if (SSN.equals(RegSSN)) {
						StoreID = TestData.getCellData(sheetName, "StoreID", row);
				
							driver.switchTo().defaultContent();
						   driver.switchTo().frame("topFrame");
						   Thread.sleep(3000);
						  
						   
						   
						   
						   
						   //driver.findElement(By.xpath("//*[@id='500000']")).click();   
						   //driver.findElement(By.partialLinkText("Transactions")).click();   
						   
						   //test.log(LogStatus.PASS, "Clicked on Transactions");
						  
						   
						   
						   
						   
					}
				}
			
		
		}
}

	

	

	
			


