package Gluecode;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition
{
WebDriver driver;

@Given("User launch chrome browser")
public void user_launch_chrome_browser() {
    

	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();    // driver=111222
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	driver.manage().window().maximize() ;	



}
@Then("User launch application URL{string}")
public void user_launch_application_url_https_opensource_demo_orangehrmlive_com_web_index_php_auth_login(String TestURL) {

	driver.get(TestURL);


}
@Then("User enters username as {string} and password as {string}")
public void user_enters_username_as_and_password_as(String UserName1, String PassWord1) {

	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UserName1);
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PassWord1);
	driver.findElement(By.xpath("//button[@type='submit']")).click();



}
@Then("Creating Skills Record1")
public void creating_skills_record1(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	
	List<Map<String,String>>SkillsData=dataTable.asMaps(String.class,String.class);
	
	System.out.println("Number of rows:"+SkillsData.size());
	
	for(int i=0;i<SkillsData.size();i++) {
		
	System.out.println(SkillsData.get(i).get("SkillName"));
	
	System.out.println(SkillsData.get(i).get("SkillDescr"));
	
	String SkillName=SkillsData.get(i).get("SkillName");
	
	String SkillDescription=SkillsData.get(i).get("SkillDescr");
	
	System.out.println("________________________");
	
	driver.findElement(By.xpath("//span[text()='Admin']")).click();
	driver.findElement(By.xpath("//span[text()='Qualifications ']")).click();
	driver.findElement(By.xpath("//a[text()='Skills']")).click();
	driver.findElement(By.xpath("//button[text()=' Add ']")).click();
	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(SkillName);
	driver.findElement(By.xpath("//textarea[ @placeholder='Type description here']")).sendKeys(SkillDescription);
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[text()=' Save ']")).click();

	}
	
}
	
     



@Then("Create Job Record")
public void create_job_record(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	
	List<List<String>>JobsData=dataTable.cells();
	
	System.out.println("Number of rows:"+JobsData.size());
	
	for (int i=0;i<JobsData.size();i++) {
		
	System.out.println(JobsData.get(i).get(0));
	
	String JobTitle=JobsData.get(i).get(0);
	
	String JobDescription=JobsData.get(i).get(1);
	
	String JobNote=JobsData.get(i).get(2);
	
	System.out.print("________________________");
	
	driver.findElement(By.xpath("//span[text()='Admin']")).click(); //Admin
	driver.findElement(By.xpath("//span[text()='Job ']")).click(); //Jobs
	driver.findElement(By.xpath("//a[text()='Job Titles']")).click(); //Job Titles
	
	Thread.sleep(5000); 
	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click(); //Add button
	
	
	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(JobTitle);
	driver.findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys(JobDescription);
	driver.findElement(By.xpath("//textarea[@placeholder='Add note']")).sendKeys(JobNote);
	
	
	Thread.sleep(5000); //execution will be passed for 5 seconds
		
	driver.findElement(By.xpath("//button[@type='submit']")).click();  //Save

	
	}
	
}
    
	
@Then("Creating Nationality Record1")
public void creating_nationality_record1(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
    
List<Map<String,String>>NationalityData=dataTable.asMaps(String.class,String.class);

System.out.println("Number of rows:"+NationalityData.size());

for(int i=0;i<NationalityData.size();i++) {
	
	System.out.println(NationalityData.get(i).get("NationalityText"));
	
	String NationalityText=NationalityData.get(i).get("NationalityText");
	
	System.out.println("___________________");
	
	driver.findElement(By.xpath("//span[text()='Admin']")).click(); //Admin
	driver.findElement(By.xpath("//a[text()='Nationalities']")).click();//Nationalities
	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click(); //Addbuttonn
	driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(NationalityText);
		
   Thread.sleep(5000);
   driver.findElement(By.xpath("//button[@type='submit']")).click();
}

 





}




@When("Click on logout button")
public void click_on_logout_button() {


	driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
	driver.findElement(By.xpath("//a[text()='Logout']")).click();  


}
@Then("Close Browser")
public void close_browser() {
    
    driver.close();

}
}

