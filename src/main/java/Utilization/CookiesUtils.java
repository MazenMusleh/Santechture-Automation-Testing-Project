package Utilization;

import GUI.Base.DriverManager;
import org.openqa.selenium.Cookie;

public class CookiesUtils {

    public static String getSessionCookie(String cookieName) {
        Cookie cookie = DriverManager.getDriver().manage().getCookieNamed(cookieName);

        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }
}
