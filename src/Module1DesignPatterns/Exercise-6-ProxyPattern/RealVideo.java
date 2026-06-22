public class RealVideo implements Video {
    private String fileName;

    public RealVideo(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading video from remote server: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying video: " + fileName);
    }
}
