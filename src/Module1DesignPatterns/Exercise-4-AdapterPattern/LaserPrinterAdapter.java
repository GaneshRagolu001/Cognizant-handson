public class LaserPrinterAdapter implements Printer {
    private LaserPrinter laserPrinter;

    public LaserPrinterAdapter(LaserPrinter laserPrinter) {
        this.laserPrinter = laserPrinter;
    }

    @Override
    public void print(String document) {
        laserPrinter.printLaser(document);
    }
}
