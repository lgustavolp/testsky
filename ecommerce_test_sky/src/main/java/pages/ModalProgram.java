package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalProgram {
	
	private WebDriver driver;
	
	private By tituloProgramaModal = By.cssSelector("#modal > div > div.sky-modal-container > div > div > div.sky-modal-program-container > div > div.sky-modal-program-description > div.sky-modal-program-title > h2");
	
	private By horaProgramaModal = By.cssSelector("#modal > div > div.sky-modal-container > div > div > div.sky-modal-program-container > div > div.sky-modal-program-description > div.sky-modal-program-date-time > span");
	
	public ModalProgram(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String pegarTituloProgramaModal() {
		return driver.findElement(tituloProgramaModal).getText();

	}
	
	public String pegarHoraProgramaModal() {
		return driver.findElement(horaProgramaModal).getText();

	}

}
