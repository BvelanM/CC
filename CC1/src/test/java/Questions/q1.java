package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

import com.google.common.base.Verify;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        EdgeOptions ed=new EdgeOptions();
		WebDriver driver= new EdgeDriver(ed);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.manage().window().maximize();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement cartbut=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		cartbut.click();
		WebElement badge=driver.findElement(By.className("shopping_cart_badge"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(badge.isDisplayed()) {
			System.out.println("User is able to add a product to the cart Add to cart ");
			driver.findElement(By.className("shopping_cart_link")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement content=driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]"));
			if (content.isDisplayed()) {
				System.out.println("User can view the contents in the cart");
				driver.findElement(By.id("checkout")).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				WebElement info=driver.findElement(By.className("checkout_info"));
				if(info.isDisplayed()) {
					System.out.println("Your Information is displayed");
					driver.findElement(By.id("first-name")).sendKeys("Tupac");
					driver.findElement(By.id("last-name")).sendKeys("Shakur");
					driver.findElement(By.id("postal-code")).sendKeys("626001");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(By.id("continue")).click();
						if(driver.findElement(By.className("checkout_summary_container")).isDisplayed()) {
							System.out.println("Overview is displayed");
							System.out.println("Product Name : " +driver.findElement(By.className("inventory_item_name")).getText());
							System.out.println("Price : "+driver.findElement(By.className("inventory_item_price")).getText());
							Assert.assertEquals(driver.getTitle(), "Swag Labs");
							Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
							System.out.println("Question 1 Passed");
						}
						else System.out.println("Overview is not displayed");
				}
				else System.out.println("Your Information is not displayed");
			}
			
		}
	}

}
