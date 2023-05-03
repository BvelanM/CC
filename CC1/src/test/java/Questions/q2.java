package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        EdgeOptions ed=new EdgeOptions();
		WebDriver driver= new EdgeDriver(ed);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("product_sort_container")).click();
	    WebElement AZ=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]"));
	    WebElement ZA=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]"));
		if(AZ.isEnabled() && ZA.isEnabled()) {
			System.out.println("The Alpha Filter works");
			AZ.click();
			System.out.println(driver.findElement(By.className("inventory_item_name")).getText());
			driver.findElement(By.className("product_sort_container")).click();
			ZA.click();
			System.out.println(driver.findElement(By.className("inventory_item_name")).getText());
			driver.findElement(By.className("product_sort_container")).click();
			}
		
	    WebElement LH=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]"));
	    WebElement HL=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]"));
			 if(LH.isEnabled() && HL.isEnabled()) {
				 System.out.println("The Price Filter works");
				 LH.click();
					System.out.println(driver.findElement(By.className("inventory_item_name")).getText());
				 driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
				 try {
					Thread.sleep(9000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				 HL.click();
//					System.out.println(driver.findElement(By.className("inventory_item_name")).getText());
			 }
		}
	

}

