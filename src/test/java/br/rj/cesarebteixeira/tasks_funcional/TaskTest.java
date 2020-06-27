package br.rj.cesarebteixeira.tasks_funcional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class TaskTest {
	public WebDriver acessarAplicacao() throws MalformedURLException {
		
		
	//	WebDriver  driver = new ChromeDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.25.150:4444/wd/hub"), cap);
		//o qual recebe dois parametros (1 (//Clients should connect to )- onde está o hub >devemos olhar no cmd para pegar o caminho)
		// 2- cap > é o segundo paramentro(capabilities) que as informações do browser que eu devo usar
		driver.navigate().to("http://localhost:8001/tasks");		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() throws MalformedURLException {
		
		//usamos o método acima para fatorar o driver
		//usamos o try abaixo para que o comando quit pudesse ser executado
		//usamos o comando finally para que caso o try execute os comandos com suscesso ou não, o comando quit seja executado
		
		WebDriver driver = acessarAplicacao();
		try {
		
		//clicar bptao ADD todo
			driver.findElement(By.id("addTodo")).click();
		
		//escrever descrição da task
		driver.findElement(By.id("task")).sendKeys("teste selenium");
		//escrever data
		driver.findElement(By.id("dueDate")).sendKeys("20/10/2020");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
	
		//validar mensagem de sucesso
		String mensagem = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", mensagem);
		} finally	 {
			    
		//FECHAR BROWSER
		driver.quit();
		}
	}


	@Test
	public void naoDeveSalvarTarefaSemDescricao() throws MalformedURLException {
		
		//usamos o método acima para fatorar o driver
		//usamos o try abaixo para que o comando quit pudesse ser executado
		//usamos o comando finally para que caso o try execute os comandos com suscesso ou não, o comando quit seja executado
		
		WebDriver driver = acessarAplicacao();
		try {
		
		//clicar bptao ADD todo
			driver.findElement(By.id("addTodo")).click();
		
		//escrever descrição da task
		
		//escrever data
		driver.findElement(By.id("dueDate")).sendKeys("20/10/2020");
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
	
		//validar mensagem de sucesso
		String mensagem = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", mensagem);
		} finally	 {
			    
		//FECHAR BROWSER
		driver.quit();
		}
	}
	@Test
	public void deveSalvarTarefaSemData() throws MalformedURLException {
		
		//usamos o método acima para fatorar o driver
		//usamos o try abaixo para que o comando quit pudesse ser executado
		//usamos o comando finally para que caso o try execute os comandos com suscesso ou não, o comando quit seja executado
		
		WebDriver driver = acessarAplicacao();
		try {
		
		//clicar bptao ADD todo
			driver.findElement(By.id("addTodo")).click();
		
		//escrever descrição da task
		driver.findElement(By.id("task")).sendKeys("teste selenium");
		//escrever data
		
		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
	
		//validar mensagem de sucesso
		String mensagem = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", mensagem);
		} finally	 {
			    
		//FECHAR BROWSER
		//driver.quit();
		}
	}	
		@Test
		public void deveSalvarTarefaComDataPassada() throws MalformedURLException {
			
			//usamos o método acima para fatorar o driver
			//usamos o try abaixo para que o comando quit pudesse ser executado
			//usamos o comando finally para que caso o try execute os comandos com suscesso ou não, o comando quit seja executado
			
			WebDriver driver = acessarAplicacao();
			try {
			
			//clicar bptao ADD todo
			driver.findElement(By.id("addTodo")).click();
			
			//escrever descrição da task
			driver.findElement(By.id("task")).sendKeys("teste selenium");
			//escrever data
			driver.findElement(By.id("dueDate")).sendKeys("20/10/2010");
			
			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();
		
			//validar mensagem de sucesso
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", mensagem);
			} finally	 {
				
			//FECHAR BROWSER
			driver.quit();
			}
		}

}
