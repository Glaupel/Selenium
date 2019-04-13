package campodetreinamento;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testeweb {
	
	private static WebDriver driver;
	Dsl DSL ;
	
	
	@Before
	public void Begin() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		driver = new ChromeDriver(op);
		driver.get("C:\\Users\\gpelaquin\\Desktop\\campo-treinamento\\componentes.html");
	    DSL = new  Dsl(driver);
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}

	@Test
	public void testeNomeSobrenome() throws Exception {

		//WebElement nome = driver.findElement(By.name("elementosForm:nome"));
		//nome.sendKeys("Glaucia");
		DSL.escrever("elementosForm:nome", "Glaucia");
		Assert.assertEquals("Glaucia",DSL.obtervalorinput("elementosForm:nome"));
		

		//WebElement sobrenome = driver.findElement(By.id("elementosForm:sobrenome"));
		//sobrenome.sendKeys("Pelaquin");
		
		DSL.escrever("elementosForm:sobrenome", "Pelaquin");
		DSL.obtervalortexto("elementosForm:sobrenome");
		Assert.assertEquals("Pelaquin", DSL.obtervalorinput("elementosForm:sobrenome"));
     
	}

	@Test
	public void testSexo() throws Exception {

	//	WebElement sexo = driver.findElement(By.id("elementosForm:sexo:0"));
		//sexo.click();
			
		DSL.clickradio("elementosForm:sexo:1");
		Assert.assertTrue(DSL.verificarvalorselecionado("elementosForm:sexo:1"));
				

		Thread.sleep(5000);

	}
	
	@Test
	public void testeescolaridadeeesporte() {
	 // WebElement escolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
	 // Select sel_escolaridade = new Select(escolaridade);
	 // sel_escolaridade.selectByValue("mestrado");
		
	 // WebElement esportes = driver.findElement(By.id("elementosForm:esportes"));
	 // Select sel_esportes = new Select(esportes);
	 // sel_esportes.selectByValue("Karate");
	
	  
	 // sel_esportes.selectByValue("Corrida");
	 // Assert.assertEquals("mestrado", sel_escolaridade);
	  
	  // criar o elemento com o valor 
		DSL.selecionarcombo("elementosForm:escolaridade", "Mestrado");
		Assert.assertEquals("Mestrado", DSL.obtervalorcombo("elementosForm:escolaridade"));
		
		DSL.selecionarcombo("elementosForm:esportes", "Karate");
		DSL.selecionarcombo("elementosForm:esportes", "Futebol");
		DSL.selecionarcombo("elementosForm:esportes", "Natacao");
		Assert.assertEquals(5, DSL.obterqtdeopcoescombo("elementosForm:esportes"));
		Assert.assertTrue(DSL.verificarstringcombo("elementosForm:esportes","Natacao"));
		DSL.selecionarcombo("elementosForm:esportes", "Futebol");
	
	}
	@Test
	public void alert() {
		DSL.click_botao("Prompt");
		DSL.alertaescrever("5");
		Assert.assertEquals("Era 5?", DSL.alertaobtertextoeaceitar());
		Assert.assertEquals(":D", DSL.alertaobtertextoeaceitar());
	}
	
	@Test
	public void trocadejanelasimples() throws Exception {
	    DSL.click_botao("Abrir Popup");
	    DSL.trocar_frame("Popup");
	    DSL.escrever(By.tagName("textarea"), "Deu Certo ?");
	    driver.close();
	    DSL.trocar_frame("");
	    DSL.escrever(By.tagName("textarea"), "E agora ?");
	   
	    Thread.sleep(15000);
	}
	
	@Test
	public void testejaneladificil() throws Exception {
	  DSL.click_botao("Abrir Popup do Mal");
	  System.out.println(driver.getWindowHandle());
	  System.out.println(driver.getWindowHandles());
	  DSL.trocar_frame((String) driver.getWindowHandles().toArray()[1]);
	  DSL.escrever(By.tagName("textarea"), "Deu Certo ?");
	  DSL.trocar_frame((String) driver.getWindowHandles().toArray()[1]);
	  DSL.escrever(By.tagName("textarea"), "E AGORA?");
	  
	  Thread.sleep(15000);
	}
    @Test
	public void iframe() throws Exception {
		DSL.entrar_frame("frame1");
		DSL.click_botao("Dentro do Frame");
		String msg = DSL.alertaobtertextoeaceitar();
		Assert.assertEquals("Frame OK!", msg);
		DSL.sair_frame();
		DSL.escrever("elementosForm:nome", msg);
		Thread.sleep(15000);
				
	}
    
    @Test
    public void buttondelay() {
    	DSL.click_botao("Resposta Demorada");
    	DSL.escrever(By.id("novoCampo"),"que demora");
    }
	
    @Test
    public void buttondelayExplicita() {
    	DSL.click_botao("Resposta Demorada");
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
    	DSL.escrever(By.id("novoCampo"),"que demora");
    }
	
   @Test
   
   public void tabela() throws Exception {
	   DSL.Interagir_Tabela(1,4,"Doutorado","", "click");
	   DSL.Interagir_Tabela(2,6,"Mestrado", "Glaucia", "escrever");
	   Thread.sleep(15000);
   }
   
   
   
	@After
	public void TearDown() {
		driver.quit();
	}
}
