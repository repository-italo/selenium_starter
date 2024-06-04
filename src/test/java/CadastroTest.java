import org.example.GenerateRandom;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CadastroTest {
    private WebDriver navegador;
    public GenerateRandom generateRandom;
    @BeforeTest
    public void setUp(){
        this.navegador = new ChromeDriver();
        this.navegador.get("https://automationexercise.com/login");

    }
    @Test
    public void chromeTest(){
        this.generateRandom = new GenerateRandom();
        WebElement formSignUp = navegador.findElement(By.className("signup-form"));
        formSignUp.findElement(By.name("name")).sendKeys(generateRandom.name());
        formSignUp.findElement(By.name("email")).sendKeys(generateRandom.email());
        WebElement button = formSignUp.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/button"));
        button.click();
        //Preenchendo formulario de cadastro
        WebElement title = navegador.findElement(By.className("clearfix"));
        title.findElement(By.id("id_gender1")).click();

        WebElement inputPassword = navegador.findElement(By.id("password"));
        inputPassword.sendKeys("12345");

        WebElement formDate = navegador.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[5]/div"));
        formDate.findElement(By.name("days")).sendKeys("3");
        formDate.findElement(By.name("months")).sendKeys("January");
        formDate.findElement(By.name("years")).sendKeys("2001");
        WebElement signUpForm = navegador.findElement(By.id("form"));
        signUpForm.findElement(By.id("newsletter")).click();

        signUpForm.findElement(By.id("optin")).click();

        signUpForm.findElement(By.name("first_name")).sendKeys("memo");
        signUpForm.findElement(By.name("last_name")).sendKeys("honorio");
        signUpForm.findElement(By.name("company")).sendKeys("ifam");
        signUpForm.findElement(By.name("address1")).sendKeys("Rua Honório Gurgel, 23");
        signUpForm.findElement(By.name("address2")).sendKeys("Rua Honório Gurgel, 23");
        signUpForm.findElement(By.name("country")).sendKeys("United States");
        signUpForm.findElement(By.name("state")).sendKeys("Oregon");
        signUpForm.findElement(By.name("city")).sendKeys("Rio de Janeiro");
        signUpForm.findElement(By.name("zipcode")).sendKeys("6900000");
        signUpForm.findElement(By.name("mobile_number")).sendKeys("+559298765678");

        signUpForm.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
    }

    @AfterTest
    public void tearDown(){
        navegador.quit();
    }
}
