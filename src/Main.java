import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("Uso della classe Propreties");
        Properties properties= new Properties();

        // la classe properties deve appoggiarsi ad un file da leggere e scriver le proprietà
        // nella forma --> key:values
        // il file deve essere caricato nell oggetto properties

        try {
            InputStream inputStream =new FileInputStream("dati.properties");
            properties.load(inputStream); // caricato il file

            // metodi per leggere e scrivere le coppie chiave valore nel file
            // estraggo il valore della chiave con il metodo getProperties("stringa chiave")
            System.out.println("la capitale dell'italia è: "+properties.getProperty("italia"));
            System.out.println("la capitale della francia è: "+properties.getProperty("francia"));

            // scriviamo le coppie chiave valore nel file
            // c'è bisogno dell'oggetto su cui scrivere
            OutputStream outputStream= new FileOutputStream("dati.properties",true);
            properties.setProperty("spagna","barcellona");
            properties.setProperty("giappone","tokyo");

            // scrive sul file properties con il metodo store
            properties.store(outputStream,"file aggiornato");

            properties.setProperty("inghilterra","londra");
            properties.store(outputStream,"");
            System.out.println("elementi contenuti nel file: "+properties.size());

            // cancello la coppia
            properties.remove("inghilterra");
            properties.store(outputStream,"");
            System.out.println("elementi contenuti nel file: "+properties.size());






        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}