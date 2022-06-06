package GeneratorCertyfikatow.Dokument;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;

/**
 * Klasa abstrakcyjna odpowiadająca za podstawowe części generowania pliku.
 * Przechowuje dokument, imię i nazwisko uczestnika oraz ścieżkę finalnego pliku.
 */
public abstract class Generator{
    public Document document = new Document(PageSize.A4);
    protected PdfWriter writer;
    protected String CERT_STRING;
    protected String fullName;

    /**
     * @param fullName Imię i nazwisko uczestnika.
     */
    public Generator(String fullName){
        this.fullName = fullName;
    }

    /**
     * Skaluje tło do rozmiarów pliku.
     * @param image - obraz, który ma być przeskalowany.
     * @return Image -- obiekt obrazu, który ma być umieszczony jako tło.
     */
    protected Image resizeImage(Image image){
        //image.scaleAbsolute(document.getPageSize());
        image.scalePercent(24);
        image.setAbsolutePosition(0,0);
        image.setDpi(300,300);
        return image;
    }

    /**
     * @return Font -- czcionka, którą będą zapisane napisy.
     */
    protected Font font(){
        try{
            BaseFont baseFont = BaseFont.createFont("BAHNSCHRIFT.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 30, Font.BOLD);
            font.setColor(246, 232, 216);
            return font;
        } catch(DocumentException | IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * @param name Imię i nazwisko uczestnika.
     * @return Paragraph -- obiekt paragrafu, który będzie w pliku.
     */
    protected Paragraph name(String name){
        return name(name, 200);
    }

    /**
     * @param name - Imię i nazwisko uczestnika.
     * @param top - Odległość od górnej krawędzi dokumentu.
     * @return Paragraph -- obiekt paragrafu, który będzie w pliku.
     */
    protected Paragraph name(String name, float top){
        name = name.toUpperCase().trim();
        Font font = font();
        font.setSize(35);
        Paragraph paragraph = new Paragraph(name, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingBefore(top);
        return paragraph;
    }

    public void setCERT_STRING(String CERT_STRING){
        this.CERT_STRING = CERT_STRING;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getCERT_STRING(){
        return CERT_STRING;
    }
    public String getFullName(){
        return fullName;
    }
}
