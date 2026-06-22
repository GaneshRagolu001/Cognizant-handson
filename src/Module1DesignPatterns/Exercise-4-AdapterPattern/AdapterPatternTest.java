public class AdapterPatternTest {

    public static void main(String[] args) {



        Printer inkJet = new InkJetPrinterAdapter(new InkJetPrinter());
        inkJet.print("Project Report.pdf");

        System.out.println();

        Printer laser = new LaserPrinterAdapter(new LaserPrinter());
        laser.print("Financial Statement.xlsx");

        System.out.println();

        System.out.println("--- Batch Printing Job ---");

        Printer[] printers = {
            new InkJetPrinterAdapter(new InkJetPrinter()),
            new LaserPrinterAdapter(new LaserPrinter())
        };

        String[] docs = { "Resume.docx", "Presentation.pptx" };

        for (int i = 0; i < printers.length; i++) {
            printers[i].print(docs[i]);
        }


    }
}
