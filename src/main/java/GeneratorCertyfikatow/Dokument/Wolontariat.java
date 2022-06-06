package GeneratorCertyfikatow.Dokument;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Klasa służąca do generowania zaświadczenia dla wolontariusza.
 * @author Mateusz Targoński
 * @see Generator
 */
public class Wolontariat extends Generator{

    /**
     * @param fullName - Imię i nazwisko wolontariusza.
     * @throws IOException
     * @throws DocumentException
     */
    public Wolontariat(String fullName) throws IOException, DocumentException{
        super(fullName);
        this.CERT_STRING = "wolontariusz/"+fullName+"- zaświadczenie o wolontariacie.pdf";
        this.writer = PdfWriter.getInstance(document,
                new FileOutputStream(CERT_STRING));
        this.document.open();
        this.document.setMargins(0,0,0,0);
        this.document.addAuthor("Mateusz Targoński");
        this.document.addTitle("Zaświadczenie o wolontariacie - Kongres Młodzieży");
        String IMAGE_PATH = "wolontariatKongresTEST.png";
        this.document.add(resizeImage(Image.getInstance(IMAGE_PATH)));
        this.document.add(super.name(super.fullName, 265));
        this.document.addCreator("Generator Certyfikatów - Kongres Młodzieży - Mateusz Targoński");
        this.document.addLanguage("Polish");
        this.document.close();
    }

}
