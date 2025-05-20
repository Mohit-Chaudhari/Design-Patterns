package creational.abstractfactory;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 20/05/25
 */

/**
 * Cross-Platform UI Toolkit (Extended to Full UI Family)
 * Original (Factory): Creating platform-specific buttons or checkboxes.
 * Abstract Factory Use Case:
 * You now want to create entire families of UI components (e.g., Button, Checkbox, Window, Scrollbar) that are
 * consistent with a platform's look and feel. Each platform (Windows, macOS, Linux) has its own UI factory that
 * returns the correct set of components.
 *
 * Abstract Factory:
 *
 * UIFactory (abstract) → createButton(), createCheckbox(), createWindow()
 *
 * WindowsUIFactory, MacUIFactory, LinuxUIFactory
 */

// interfaces
interface Component {
    void render();
}

interface OS {
    void load();
}


// implementations
class Button implements Component {
    @Override
    public void render() {
        System.out.println("rendering Button on UI");
    }
}

class Checkbox implements Component {
    @Override
    public void render() {
        System.out.println("rendering Checkbox on UI");
    }
}

class Window implements Component {
    @Override
    public void render() {
        System.out.println("rendering window on UI");
    }
}

class ScrollBar implements Component {
    @Override
    public void render() {
        System.out.println("rendering Scroll bar on UI");
    }
}

class Windows implements OS {
    @Override
    public void load() {
        System.out.print("Loading windows operating system and ");
    }
}

class Linux implements OS {
    @Override
    public void load() {
        System.out.print("Loading linux operating system and ");
    }
}

class Mac implements OS {
    @Override
    public void load() {
        System.out.print("Loading mac operating system and ");
    }
}

// abstract factory

interface UIFactory {
    OS load();
    Component render(String type);
}

// concrete factories

class ComponentFactory {
    public static Component getComponent(String type) {
        if (type.equalsIgnoreCase("button")) {
            return new Button();
        } else if (type.equalsIgnoreCase("Checkbox")) {
            return new Checkbox();
        } else if (type.equalsIgnoreCase("Window")) {
            return new Window();
        } else if (type.equalsIgnoreCase("ScrollBar")) {
            return new ScrollBar();
        }
        throw new IllegalArgumentException("Unsupported ui component: " + type);
    }
}

class WindowsUIFactory implements UIFactory {
    @Override
    public OS load() {
        return new Windows();
    }

    @Override
    public Component render(String type) {
        return ComponentFactory.getComponent(type);
    }
}

class MacUIFactory implements UIFactory {
    @Override
    public OS load() {
        return new Mac();
    }

    @Override
    public Component render(String type) {
        return ComponentFactory.getComponent(type);
    }
}

class LinuxUIFactory implements UIFactory {
    @Override
    public OS load() {
        return new Linux();
    }

    @Override
    public Component render(String type) {
        return ComponentFactory.getComponent(type);
    }
}

class ComponentRenderingService {

    private final OS os;

    private final Component component;

    public ComponentRenderingService(UIFactory factory, String component) {
        this.os = factory.load();
        this.component = factory.render(component);
    }

    public void render() {
        this.os.load();
        this.component.render();
    }
}

public class CrossPlatformUIToolkit {
    public static void main(String[] args) {
        ComponentRenderingService windows =
                new ComponentRenderingService(new WindowsUIFactory(), "button");
        ComponentRenderingService linux =
                new ComponentRenderingService(new LinuxUIFactory(), "scrollbar");
        ComponentRenderingService mac =
                new ComponentRenderingService(new MacUIFactory(), "Checkbox");

        windows.render();
        linux.render();
        mac.render();
    }
}
