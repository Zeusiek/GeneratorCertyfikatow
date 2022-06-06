package GeneratorCertyfikatow;

import GeneratorCertyfikatow.Dokument.Uczestnik;
import com.itextpdf.text.DocumentException;

import java.io.File;
import java.io.IOException;


public class Main{
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) throws DocumentException, IOException{
        File file = new File("certyfikaty");
        File[] files = file.listFiles();
        if(files != null && files.length != 0)
            for (File value: files)
                value.delete();

        String[] strings = MyFileReader.read(new File("test.txt")).split("\n");
        for (String string: strings){
            String[] a = string.split("/");
            new Uczestnik(a[0], a[1]);
        }
        files = file.listFiles();
        blockFile(files);
    }
    /**
     * Blokowanie nadpisywania pliku.
     * @param files
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void blockFile(File[] files){
        if(files!=null)
            for (File f: files){
                f.setWritable(false);
                f.setReadOnly();
            }
    }
}
