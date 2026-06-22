public class InkJetPrinterAdapter implements Printer {
    private InkJetPrinter inkJetPrinter;

    public InkJetPrinterAdapter(InkJetPrinter inkJetPrinter) {
        this.inkJetPrinter = inkJetPrinter;
    }

    @Override
    public void print(String document) {
        inkJetPrinter.printInkJet(document);
    }
}
