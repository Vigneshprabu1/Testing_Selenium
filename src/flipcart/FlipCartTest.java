package flipcart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlipCartTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]//following::input[1]")).sendKeys("8124753024");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]//following::input[2]")).sendKeys("jegadesh5246");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]//following::button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("samsung mobiles");
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.className("_3wU53n"));
		for (int i = 0; i <=1; i++) {
			System.out.println(list.size());
			list.get(i).click();
			Thread.sleep(2000);
			Set<String> window = driver.getWindowHandles();
			Iterator<String> it = window.iterator();
			String parentid = it.next();
			String childid = it.next();
			System.out.println(parentid + "-" + i);
			System.out.println(childid + "-" + i);
			driver.switchTo().window(childid);
			Thread.sleep(5000);
			System.err.println("am switched");
			driver.findElement(By.cssSelector("svg._3oJBMI")).click();
			driver.close();
			driver.switchTo().window(parentid);
			Thread.sleep(7000);
		}
		driver.findElement(By.xpath("//span[contains(text(),'Cart')]")).click();
		System.err.println("am switched to cart");
		Thread.sleep(2000);
		ArrayList<String> a = new ArrayList<String>();
		List<WebElement> list2 = driver
				.findElements(By.xpath("//div[@id='container']//following::div[@class='I8hxu4']"));
		List<WebElement> list1 = driver
				.findElements(By.xpath("//div[@id='container']//following::div[@class='_1Ox9a7']"));
		for (int j = 0; j <= 1; j++) {
			String price = list2.get(j).getText();
			// System.out.println(price);
			String name = list1.get(j).getText();
			// System.out.println(name);
			String product = price + "--" + name;
			a.add(product);
		}
		Collections.sort(a);
		for (int k = 0; k < list2.size(); k++) {
			System.out.println(a.get(k));
		}
	

	}

}

