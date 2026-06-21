package Module1DesignPatterns;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Hello world");
        Logger logger2 = Logger.getInstance();
        logger2.log("Hello ganesh");

        if(logger1 == logger2){
            System.out.println("Only one instance is created");
        }else{
            System.out.println("Multiple logger instances are created");
        }
    }
}
