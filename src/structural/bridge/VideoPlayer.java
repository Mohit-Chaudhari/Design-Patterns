package structural.bridge;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 24/05/25
 */


// Interface
interface VideoQuality {
    void load(String title);
}


// Concrete classes
class SDQuality implements VideoQuality {
    @Override
    public void load(String title) {
        System.out.println("Streaming " + title + " in SD Quality");
    }
}

class HDQuality implements VideoQuality {
    @Override
    public void load(String title) {
        System.out.print("Streaming " + title + " in HD Quality");
    }
}

class UltraHDQuality implements VideoQuality {
    @Override
    public void load(String title) {
        System.out.print("Streaming " + title + " in UltraHD Quality");
    }
}

// Abstraction

abstract class AbstractVideoPlayer {
    protected VideoQuality quality;

    public AbstractVideoPlayer(VideoQuality quality) {
        this.quality = quality;
    }

    public abstract void play(String title);
}

// Refined abstraction

class WebPlayer extends AbstractVideoPlayer {
    public WebPlayer(VideoQuality quality) {
        super(quality);
    }

    @Override
    public void play(String title) {
        quality.load(title);
        System.out.println(" on Web platform");
    }
}

class MobilePlayer extends AbstractVideoPlayer {
    public MobilePlayer(VideoQuality quality) {
        super(quality);
    }

    @Override
    public void play(String title) {
        quality.load(title);
        System.out.println(" on Mobile platform");
    }
}

public class VideoPlayer {

    public static void main(String[] args) {
        AbstractVideoPlayer web = new WebPlayer(new HDQuality());
        web.play("Inception");

        AbstractVideoPlayer mobile = new MobilePlayer(new UltraHDQuality());
        mobile.play("Sholay");
    }
}
