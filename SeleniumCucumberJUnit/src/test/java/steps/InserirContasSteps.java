package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import static org.junit.Assert.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InserirContasSteps {
    private WebDriver driver;

    @After(order = 1)
    public void screenshot(Scenario cenario) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
//            FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"); Não funciona no windows
            FileUtils.copyFile(file, new File("target/screenshot/"
                    +cenario.getName()
                    + "."
                    +cenario.getLine()
                    +".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After(order = 0)
    public void fecharBrowser(){
        driver.quit();
    }

    @Dado("que estou acessando a aplicação")
    public void que_estou_acessando_a_aplicação() {
        System.setProperty("webdriver.chrome.driver", Util.retornaPathChromeDriver());
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
    }

    @Quando("informo o usuário {string}")
    public void informo_o_usuário(String string) {
        driver.findElement(By.id("email")).sendKeys(string);
    }

    @Quando("a senha {string}")
    public void a_senha(String string) {
        driver.findElement(By.id("senha")).sendKeys(string);
    }

    @Quando("seleciono entrar")
    public void seleciono_entrar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("visualizo a página inicial")
    public void visualizo_a_página_inicial() {
        String texto = driver.findElement(By.xpath("//div[@class = 'alert alert-success']")).getText();
        assertEquals("Bem vindo, karla!", texto);
    }

    @Quando("seleciono Contas")
    public void seleciono_contas() {
        driver.findElement(By.linkText("Contas")).click();
    }

    @Quando("seleciono Adicionar")
    public void seleciono_adicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("informar a conta {string}")
    public void informar_a_conta(String string) {
        driver.findElement(By.id("nome")).sendKeys(string);
    }

    @Quando("seleciono Salvar")
    public void seleciono_salvar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Entao("recebo a mensagem {string}")
    public void recebo_a_mensagem(String string) {
        String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert')]")).getText();
        assertEquals(string, texto);
    }


//    @Entao("recebo a mensagem Informe o nome da conta")
//    public void recebo_a_mensagem_informe_o_nome_da_conta() {
//        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
//        assertEquals("Informe o nome da conta", texto);
//    }

//
//
//    @Dado("que estou acessando a aplicação")
//    public void que_estou_acessando_a_aplicação() {
//        System.setProperty("webdriver.chrome.driver", util.Util.retornaPathChromeDriver());
//        driver = new ChromeDriver();
//        driver.get("https://seubarriga.wcaquino.me");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//    }
//    @Quando("informo o usuário {string}")
//    public void informo_o_usuário(String string) {
//        driver.findElement(By.id("email")).sendKeys(string);
//    }
//    @Quando("a senha {string}")
//    public void a_senha(String string) {
//        driver.findElement(By.id("senha")).sendKeys(string);
//    }
//    @Quando("seleciono entrar")
//    public void seleciono_entrar() {
//        driver.findElement(By.tagName("button")).click();
//    }
//    @Então("visualizo a página inicial")
//    public void visualizo_a_página_inicial() {
//        //String texto = driver.findElement(By.className("alert alert-success")).getText();
//        String texto = driver.findElement(By.xpath("//div[@class = 'alert alert-success']")).getText();
//        assertEquals("Bem vindo, karla!", texto);
//    }
//    @Quando("seleciono Contas")
//    public void seleciono_contas() {
//        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//        driver.findElement(By.linkText("Contas")).click();
//    }
//    @Quando("seleciono Adicionar")
//    public void seleciono_adicionar() {
//        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//        driver.findElement(By.linkText("Adicionar")).click();
//    }
//    @Quando("informo a conta {string}")
//    public void informo_a_conta(String string) {
//        driver.findElement(By.id("nome")).sendKeys(string);
//    }
//    @Quando("seleciono Salvar")
//    public void seleciono_salvar() {
//        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//        driver.findElement(By.tagName("button")).click();
//    }
//    @Então("a conta é inserida com sucesso")
//    public void a_conta_é_inserida_com_sucesso() {
//        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
//        assertEquals("Conta adicionada com sucesso!", texto);
//    }
//
//    @Então("sou notificar que o nome da conta é obrigatório")
//    public void sou_notificar_que_o_nome_da_conta_é_obrigatório() {
//        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
//        assertEquals("Informe o nome da conta", texto);
//    }
//
//    @Então("sou notificado que já existe uma conta com esse nome")
//    public void sou_notificado_que_já_existe_uma_conta_com_esse_nome() {
//       String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
//        assertEquals("Já existe uma conta com esse nome!", texto);
//
//    }
}
