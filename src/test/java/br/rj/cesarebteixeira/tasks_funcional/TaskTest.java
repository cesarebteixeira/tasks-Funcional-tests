package br.rj.cesarebteixeira.tasks_funcional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TaskTest {
	public WebDriver acessarAplicacao() {
		WebDriver  driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		
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
	public void naoDeveSalvarTarefaSemDescricao() {
		
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
	public void deveSalvarTarefaSemData() {
		
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
		public void deveSalvarTarefaComDataPassada() {
			
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
