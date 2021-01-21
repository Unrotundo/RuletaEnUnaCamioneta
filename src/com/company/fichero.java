package ejemplosmetodos;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class fichero {
    public static void main(String[] args) {

        String texto="Hola";
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("prueba.txt");
            pw = new PrintWriter(fichero);

            //Aquí el código de la ruleta


            System.out.println("lo que me da la gana");
            pw.println(texto);
            pw.println("lo que me da gana");

            pw.println("-----------------");
            pw.println("otra cosa");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
