package creational.factory;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 20/05/25
 */

/**
 * Cross-Platform UI Component Creation
 * Problem Statement:
 * Your application needs to support multiple operating systems (Windows, macOS, Linux). Each OS requires a different implementation of UI components like buttons and checkboxes. You want a flexible way to instantiate the correct components at runtime without tightly coupling the code to platform-specific classes.
 *
 * Solution via Factory Pattern:
 * Use a factory to create UI components based on the operating system, abstracting away the creation logic from the client code.
 */

interface OS {
    void load();
}

class Windows implements OS {
    @Override
    public void load() {
        System.out.println("Loading component for windows");
    }
}

class Linux implements OS {
    @Override
    public void load() {
        System.out.println("Loading component for Linux");
    }
}

class MacOS implements OS {
    @Override
    public void load() {
        System.out.println("Loading component for Mac OS");
    }
}

class UiFactory {

    public static OS getComponent(String os) {
        if (os.equalsIgnoreCase("windows")) {
            return new Windows();
        } else if (os.equalsIgnoreCase("linux")) {
            return new Linux();
        } else if (os.equalsIgnoreCase("macos")) {
            return new MacOS();
        }
        throw new IllegalArgumentException("Unsupported operating system:" + os);
    }
}

class ComponentService {
    public void renderComponent(String os) {
        OS platform = UiFactory.getComponent(os);
        platform.load();
    }
}

public class OsComponentManagement {
    public static void main(String[] args) {
        ComponentService service = new ComponentService();
        service.renderComponent("macos");
        service.renderComponent("linux");
        service.renderComponent("windows");
        service.renderComponent("Unknown");
    }
}
