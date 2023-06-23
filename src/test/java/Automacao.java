import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;

public class Automacao{
    @Test

    public void pesquisarGoogle() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src\\drive\\chromedriver.exe"); //abrir o chrome

        WebDriver navegador = new ChromeDriver();

        navegador.get("https://google.com.br");//indica site para o chrome

        navegador.findElement(By.xpath("//*[@id=\"APjFqb\"]")).click();//procurar o campo de busca do google (caixa de texto)
        navegador.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Ntt Data", Keys.ENTER);//entra com o texto NTTDATA e clica enter

        navegador.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[1]/div/a/h3")).click();//clicar no link da nttdata


        navegador.findElement(By.xpath("//*[@id=\"navbarLevel0Collapse\"]/div[2]/ul/li[2]/a")).click();//clicar no menu carreer
        navegador.findElement(By.xpath("//*[@id=\"collapseRight1\"]/ul/li[2]/a")).click();//clicar em job opportunities

        String abaAtual = navegador.getWindowHandle(); // realizar a troca de aba
        Thread.sleep(7000); //tempo de espera
            for (String windowHandle : navegador.getWindowHandles()){ //troca de aba
                if (!abaAtual.contentEquals(windowHandle)){
                    navegador.switchTo().window(windowHandle);
                    break;
                }
            }
        Thread.sleep(7000);//tempo de espera e entrar no modo iframe
            WebElement modoframe = navegador.findElement(By.xpath("//iframe[@title='Cookie Banner']"));
            navegador.switchTo().frame(modoframe);
            navegador.findElement(By.xpath("//button[@class='intro-banner-btn save-consents evSpAcceptBtn']")).click(); //aceitar cookies
            navegador.switchTo().defaultContent(); //sair do modo iframe

            navegador.findElement(By.xpath("//input[@name='sGlobal']")).click(); //clicar no campo texto
            navegador.findElement(By.xpath("//input[@name='sGlobal']")).sendKeys("Pessoa Engenheira de dados", Keys.ENTER); //inserir a busca






    }
}
