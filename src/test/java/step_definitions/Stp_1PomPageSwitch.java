package step_definitions;

import pom.Pom_Abstract;
import pom.Pom_AccountPage;
import pom.Pom_LoginPage;
import pom.Pom_MyAddressesPage;

public class Stp_1PomPageSwitch {

    private static ThreadLocal<Pom_Abstract> pom_abstract = new ThreadLocal<>();

    public static void setPomPage(String pageName){
        switch (pageName){
            case "Login Page":              pom_abstract.set(new Pom_LoginPage());          break;
            case "My Account Page":         pom_abstract.set(new Pom_AccountPage());        break;
            case "My Addresses Page":       pom_abstract.set(new Pom_MyAddressesPage());    break;
        }
    }

    public static Pom_Abstract getPomPage(){
        return pom_abstract.get();
    }
}
