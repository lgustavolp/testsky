package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	private By clicarFechar = By.cssSelector("button[data-gtm=\"3\"]");
	
	private By menuProgramacao = By.xpath("//*[@id=\"main-menu\"]/div[2]/div[2]/ul[1]/li[3]/a");
		
	private By textoPrograma = By.cssSelector("#schedules-container > div.virtual-list > div:nth-child(3) > div > div > div:nth-child(1) > div.channel-program-list > div > div > div > div:nth-child(3) > div > div > h2");
	
	private By horaPrograma = By.xpath("//*[@id=\"schedules-container\"]/div[4]/div[3]/div/div/div[1]/div[2]/div/div/div/div[3]/div/div[1]/div[2]/div[1]");
		
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selecMenuProgram() {
		
		//Fechar modal inicial
		driver.findElement(clicarFechar).click();
		
		//Clicar no Menu Programacao
		driver.findElement(menuProgramacao).click();
		
	}
	
	public String pegarTituloPrograma() {
		return driver.findElement(textoPrograma).getText();

	}
	
	public String pegarHoraPrograma() {
		return driver.findElement(horaPrograma).getText();

	}
	
	public ModalProgram clicarProgramacao() {
		driver.findElement(textoPrograma).click();
		return new ModalProgram(driver);
	}
	

}
