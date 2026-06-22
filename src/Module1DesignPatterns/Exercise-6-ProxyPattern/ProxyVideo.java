public class ProxyVideo implements Video {
    private RealVideo realVideo;
    private String fileName;

    public ProxyVideo(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realVideo == null) {
            realVideo = new RealVideo(fileName);
        }
        realVideo.display();
    }
}
