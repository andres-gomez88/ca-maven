
package Utilities;

public class PathUtilities {
    private static String geckoDriverPath = "C:\\seleniumdriver\\geckodriver.exe";
    private static String chromeDriverPath = "C:\\seleniumdriver\\chromedriver.exe";
    private static String excelPath = "C:\\Users\\User\\Documents\\NetBeansProjects\\CATest\\testData.xlsx";
    private static String extentRepPath = "C:\\Users\\User\\Documents\\Screenshots\\";
    private static String extentConfPath = "C:\\Users\\User\\Documents\\NetBeansProjects\\camaven\\src\\test\\resources\\extent-config.xml";
    private static String screenshotFFPath = "C:\\Users\\User\\Documents\\Screenshots\\Firefox\\";
    private static String screenshotCHPath = "C:\\Users\\User\\Documents\\Screenshots\\Chrome\\";

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public static String getChromeDriverPath() {
        return chromeDriverPath;
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

    public static String getScreenshotFFPath() {
        return screenshotFFPath;
    }

    public static String getScreenshotCHPath() {
        return screenshotCHPath;
    }


}
