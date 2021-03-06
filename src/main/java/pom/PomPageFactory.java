package pom;

public class PomPageFactory {

    private static ThreadLocal<Abstract_PomPage> pom_abstract = new ThreadLocal<>();

    public static void setPomPage(String pageName){
        switch (pageName){
            case "Login Page":              pom_abstract.set(new Pom_LoginPage());          break;
            case "My Account Page":         pom_abstract.set(new Pom_AccountPage());        break;
            case "My Addresses Page":       pom_abstract.set(new Pom_MyAddressesPage());    break;
        }
    }

    public static Abstract_PomPage getPomPage(){
        return pom_abstract.get();
    }
}
