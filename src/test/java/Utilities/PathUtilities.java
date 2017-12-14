
package Utilities;

public class PathUtilities {
    private static String geckoDriverPath = "C:\\seleniumdriver\\geckodriver.exe";
    private static String chromeDriverPath = "C:\\seleniumdriver\\chromedriver.exe";
    private static String iExplorerDriverPath = "C:\\seleniumdriver\\IEDriverServer.exe";
    private static String edgeDriverPath = "C:\\seleniumdriver\\MicrosoftWebDriver.exe";
    private static String excelPath = "C:\\Users\\andres.gomez\\Documents\\NetBeansProjects\\CATest\\testData.xlsx";
    private static String extentRepPath = "C:\\Users\\andres.gomez\\Documents\\Screenshots\\";
    private static String extentConfPath = "C:\\Users\\andres.gomez\\Documents\\NetBeansProjects\\camaven\\src\\test\\resources\\extent-config.xml";
    private static String extentRepPathMac = "/usr/local/reports/ca-maven";
    private static String extentConfPathMac = "/users/qateam/netbeansprojects";
    private static String screenshotFFPath = "C:\\Users\\andres.gomez\\Documents\\Screenshots\\Firefox\\";
    private static String screenshotCHPath = "C:\\Users\\andres.gomez\\Documents\\Screenshots\\Chrome\\";
    private static String screenshotIEPath = "C:\\Users\\andres.gomez\\Documents\\Screenshots\\IExplorer\\";
    private static String screenshotMEPath = "C:\\Users\\andres.gomez\\Documents\\Screenshots\\Edge\\";
    private static String screenshotASPath = "/usr/local/reports/safari/";

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }
    
    public static String getIExplorerDriverPath() {
        return iExplorerDriverPath;
    }
    
    public static String getEdgeDriverPath() {
        return edgeDriverPath;
    }

    public static String getExcelPath() {
        return excelPath;
    }

    public static String getExtentRepPath() {
        return extentRepPath;
    }

    public static String getExtentConfPath() {
        return extentConfPath;
    }
    
    public static String getExtentRepPathMac() {
        return extentRepPathMac;
    }
    public static String getExtentConfPathMac() {
        return extentConfPathMac;
    }

    public static String getScreenshotFFPath() {
        return screenshotFFPath;
    }

    public static String getScreenshotCHPath() {
        return screenshotCHPath;
    }
    
    public static String getScreenshotIEPath() {
        return screenshotIEPath;
    }
    
    public static String getScreenshotMEPath() {
        return screenshotMEPath;
    }
    
    public static String getScreenshotASPath() {
        return screenshotASPath;
    }
}
