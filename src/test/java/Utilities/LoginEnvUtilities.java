
package Utilities;

public class LoginEnvUtilities {
    private static String email = "andres.gomez@reflexionhealth.com";
    private static String email2 = "andres.gomez+extra@reflexionhealth.com";
    private static String email3 = "andres.gomez+testmaint@reflexionhealth.com";
    private static String pass = "Reflexion1";
    private static String pre = "https://prerelease-wc.prod.reflexionhealth.com";
    private static String test = "https://test-wc.test.reflexionhealth.com";
    private static String testmaint = "https://test-maint-wc.test.reflexionhealth.com";
    private static String dev = "https://dev-wc.dev.reflexionhealth.com";
    
    public static String finalEnvironment() {
        return pre;
    }
    
    public static String finalEmail() {
        return email;
    }
    
    public static String finalPass() {
        return pass;
    }       
}
