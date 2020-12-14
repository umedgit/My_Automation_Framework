package stepdefinitions;

import pom.Pom_Abstract;
import pom.Pom_AccountPage;
import pom.Pom_LoginPage;

public class Stp_PomPageSwitch {

    private static ThreadLocal<Pom_Abstract> pom_abstract = new ThreadLocal<>();

    public static void setPomPage(String pageName){
        switch (pageName){
            case "Login Page":           pom_abstract.set(new Pom_LoginPage());      break;
            case "Account Home Page":    pom_abstract.set(new Pom_AccountPage());    break;
        }
    }

    public static Pom_Abstract getPomPage(){
        return pom_abstract.get();
    }
}
