package GeneratorCertyfikatow;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Klasa abstrakcyjna odpowiadająca za czytanie zawartości z pliku.
 */
public abstract class MyFileReader{
    /**
     * @param f Plik, z którego będą pobierane dane.
     * @return String - zawartość pliku.
     */
    public static String read(File f){
        StringBuilder builder = new StringBuilder();
        try{
            String l;
            BufferedReader reader = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8));
            while ((l = reader.readLine())!=null){
                builder.append(l).append('\n');
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
        return builder.toString();
    }
}
