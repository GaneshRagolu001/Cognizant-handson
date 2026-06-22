public class ProxyPatternTest {

    public static void main(String[] args) {



        System.out.println("--- Creating ProxyVideo (no loading yet) ---");
        Video video = new ProxyVideo("tutorial.mp4");
        System.out.println("ProxyVideo created. Video NOT loaded yet.\n");

        System.out.println("--- First call to display() ---");
        video.display();
        System.out.println();

        System.out.println("--- Second call to display() (cached) ---");
        video.display();
        System.out.println();

        System.out.println("--- Another ProxyVideo ---");
        Video anotherVideo = new ProxyVideo("movie.mkv");
        System.out.println("ProxyVideo created for movie.mkv.\n");

        System.out.println("--- First call to display() ---");
        anotherVideo.display();
        System.out.println();

        System.out.println("--- Second call to display() (cached) ---");
        anotherVideo.display();


    }
}
