package campodetreinamento;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dsl {
	
	 private WebDriver driver;
	 
	 public Dsl(WebDriver driver){
		 this.driver = driver;
	 }
	 
	 /****  Areas de textos  ****/
	 
	 public void escrever(By locator, String texto) {
		 driver.findElement(locator).clear(); // limpa e escreve 
		 driver.findElement(locator).sendKeys(texto);
	 }
	 
	 // para não precisar colocar o ID
	 public void escrever(String id , String texto) {
		escrever(By.id(id), texto);
	 }
	 
	 //todos os metodos são void porque não tem retorno , quando espero um retorno esse pode ser String Boolean etc
	 public String obtervalorinput(String id) {
		 return driver.findElement(By.id(id)).getAttribute("value");
	 }
	 
	 public String obtervalortexto(String texto) {
		 return driver.findElement(By.id(texto)).getText();	
	 }
	 
	 /**** Areas de Radio , clicks ****/
	 
	 public void clickradio(String Id) {
		 driver.findElement(By.id(Id)).click();
	 }
	 
	 public void clickcheck(String Id) {
		 driver.findElement(By.id(Id)).click();
	 }
	 
	 public void click_botao(String button) {
		driver.findElement(By.xpath("//input[@value='"+button+"']")).click();
	 }
	    
	 
	//obter retorno do objeto selecionado
	 
	 public Boolean verificarvalorselecionado(String Id) {
		 return driver.findElement(By.id(Id)).isSelected();
				
	 }
	
	 /**** Area de Select *****/
	 
	 
	 public void selecionarcombo(String Id, String Valor) {
		    WebElement elemento  = driver.findElement(By.id(Id));
		 	Select sel_combo = new Select(elemento);
		 	sel_combo.selectByVisibleText(Valor);
	 }
	 
	public void deselecionarcombo(String Id, String Valor) {
	    WebElement elemento  = driver.findElement(By.id(Id));
		Select sel_combo = new Select(elemento);
    	sel_combo.deselectByVisibleText(Valor);
		
	}
	 
	public String obtervalorcombo(String Id) {
		WebElement elemento  = driver.findElement(By.id(Id));
		Select sel_combo = new Select(elemento);
		return sel_combo.getFirstSelectedOption().getText();
		
	}	
	
	/**** varreu o valor da lista
	 * armazena as opções do Select 
	 * vai percorrer todos os elementos da Lista 
	 *  ****/
	
	public List<String> obtervalorlista(String Id){
		WebElement elemento  = driver.findElement(By.id(Id));
		Select sel_list = new Select(elemento);
	    List<WebElement> allSelectionOptions = sel_list.getAllSelectedOptions();
	    List<String> valores = new ArrayList<String>();
	    for(WebElement opcao: allSelectionOptions) {
	    	valores.add(opcao.getText());
	    }
	    return valores;
		
	 
	}
	
	
	public int obterqtdeopcoescombo(String Id) {
		WebElement elemento  = driver.findElement(By.id(Id));
		Select sel_list = new Select(elemento);
		List<WebElement> opcao = sel_list.getOptions();
		return opcao.size();
		
	}
	
	public boolean verificarstringcombo(String Id, String valor) {
		WebElement elemento  = driver.findElement(By.id(Id));
		Select sel_list = new Select(elemento);
	    List<WebElement> options = sel_list.getOptions();
	    for(WebElement opcao: options) {
	    	if( opcao.getText().equals(opcao)) {
	    		return true;
	    	}
	    }
	    	
	return false;
}
	
	
	/******* area de alerta ****/
	
	public String alertaobtertexto() {
		Alert alerta = driver.switchTo().alert();
		return alerta.getText();
	}
	
	public String alertaobtertextoeaceitar() {
		Alert alerta_aceita = driver.switchTo().alert();
		String valor = alerta_aceita.getText();
		alerta_aceita.accept();
		return valor;
	}
	
	public String alertaobtertextoenegar() {
		Alert alerta_nega = driver.switchTo().alert();
		String valor = alerta_nega.getText();
		alerta_nega.dismiss();
		return valor;
	}
	
	public void alertaescrever(String texto) {
		Alert alerta_escrever = driver.switchTo().alert();
		alerta_escrever.sendKeys(texto);
		alerta_escrever.accept();
	}
	
	
	/****Area de Frames e Janelas ****/
	 
	public void entrar_frame(String Id) {
		driver.switchTo().frame(Id);
	}
	
	public void sair_frame() {
		driver.switchTo().defaultContent();
	}
	
	public void trocar_frame(String Id) {
		driver.switchTo().window(Id);
	}
	
	 
	    public void Interagir_Tabela(int indicebusca, int indiceinteracao, String valorbusca, String valor, String acao) {
	     String xpath = "//tbody/tr[td["+ indicebusca + "]='" + valorbusca + "']/td["+ indiceinteracao + "]/input";
	     WebElement tabela = driver.findElement(By.xpath(xpath));
	     
	     switch(acao) {
	     case "click":tabela.click(); break;
	     case "escrever":tabela.sendKeys(valor); break;
	     default:System.out.println("Ação Inválida");
	     
	     }
	    }
	    
/**case "validarclick":tabela.isSelected(); break;
case "validartexto":tabela.getAttribute("value"); break; ****/
	
}