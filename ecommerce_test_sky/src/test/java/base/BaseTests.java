package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

import pages.HomePage;

public class BaseTests {
	
	private static WebDriver driver;
	protected HomePage homePage;
	
	@BeforeAll
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver","D:\\webdrivers\\chromedriver\\85\\chromedriver.exe");
		
		//Executar com a janela maximizada
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeEach
	public void carregarPaginaInicial() {
		driver.get("https://www.sky.com.br/");
		homePage = new HomePage(driver);
	}
	
	public void capturarTela(String nomeTeste, String item) {
		var camera = (TakesScreenshot) driver;
		File capturaDeTela = camera.getScreenshotAs(OutputType.FILE);
		try {
			Files.move(capturaDeTela, new File("./resources/screenshots/" + nomeTeste + "_" + item + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterAll
	public static void finalizar() {
		driver.quit();
	}

}
