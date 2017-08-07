/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Admin
 */
public class Screenshot {
    private static String filePathFF = "C:\\Users\\User\\Documents\\Screenshots\\Firefox\\";
    private static String filePathCH = "C:\\Users\\User\\Documents\\Screenshots\\Chrome\\";
    private static String finalPath = null;
    
    public static String takeScreenshotFF(String fileName, WebDriver driver) throws IOException, InterruptedException {
        Thread.sleep(2000);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        finalPath = filePathFF + fileName + ".png";
        FileUtils.copyFile(screenshot, new File(finalPath));        
        return finalPath;        
    }
    
    public static String takeScreenshotCH(String fileName, WebDriver driver) throws IOException, InterruptedException {
        Thread.sleep(2000);
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        finalPath = filePathCH + fileName + ".png";
        FileUtils.copyFile(screenshot, new File(finalPath));        
        return finalPath;
    }
}
