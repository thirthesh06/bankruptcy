package utility;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.a2j.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Capture_screenshot extends TestBase {

	
	public static void ashot(String name) throws IOException {
		WebDriver dr = null;
		Screenshot myScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(dr);
        ImageIO.write(myScreenshot.getImage(),"PNG",new File("./Screenshot/"+name+"a.png"));
	}
	
	public static void takeshot(String name) {
		
		TakesScreenshot dr = null;
		TakesScreenshot scrshot=((TakesScreenshot)dr);
		 File srcfile =scrshot.getScreenshotAs(OutputType.FILE);
	}
	
	
}
