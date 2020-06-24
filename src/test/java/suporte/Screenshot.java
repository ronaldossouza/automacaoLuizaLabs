package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    public static void tirar(WebDriver driver, String arquivo){
        File screeshot =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try {
    FileUtils.copyFile(screeshot, new File(arquivo));
} catch (Exception e){
    System.out.println("Houve um problema ao copiar arquivo para a pasta: " + e.getMessage());
}
    }

}
