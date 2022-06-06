package GeneratorCertyfikatow.Dokument;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Klasa służąca do generowania certyfikatu dla uczestnika.
 * @author Mateusz Targoński
 * @see Generator
 */
public class Uczestnik extends Generator{
    /**
     * @param fullName - Imię i nazwisko uczestnika.
     * @param commission - Nazwa komisji, w której był uczestnik
     * @throws IOException
     * @throws DocumentException
     */
    public Uczestnik(String fullName, String commission) throws IOException, DocumentException{
        super(fullName);
        this.CERT_STRING = "certyfikaty/"+fullName+"- Komisja "+commission.toLowerCase().trim()+".pdf";
        this.writer = PdfWriter.getInstance(document,
                new FileOutputStream(CERT_STRING));
        this.document.open();
        this.document.setMargins(0,0,0,0);
        this.document.addAuthor("Mateusz Targoński");
        this.document.addTitle("Certyfikat - Kongres Młodzieży");
        String IMAGE_PATH = "certyfikatKongresTEST.png";
        this.document.add(super.resizeImage(Image.getInstance(IMAGE_PATH)));
        this.document.add(this.name(super.fullName));
        this.document.add(this.commission(commission));
        this.document.addCreator("Generator Certyfikatów - Kongres Młodzieży - Mateusz Targoński");
        this.document.addLanguage("Polish");
        this.document.close();
    }

    /**
     * Generuje Paragraph dla nazwy komisji w pliku.
     * @param name - nazwa komisji
     * @return Paragraph - nazwa komisji.
     */
    protected Paragraph commission(String name){
        name = name.toUpperCase().trim();
        Paragraph paragraph = new Paragraph(name, font());
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingBefore(66);
        return paragraph;
    }
}
