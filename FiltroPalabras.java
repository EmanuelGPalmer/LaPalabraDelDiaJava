package TrabajoLaPalabraDelDia;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FiltroPalabras {
 public static void main(String[] args) {
     ArrayList<String> palabras = new ArrayList<>();
     try {
       
         Scanner sc = new Scanner(new File("C:\\JuegoPalabra\\Texto1.txt"));
         while (sc.hasNext()) {
             
             String palabra = sc.next();
             
             if (palabra.length() == 5) {
                 
                 palabras.add(palabra);
             }
         }
        
         sc.close();
     } catch (FileNotFoundException e) {
         System.out.println("No se pudo leer el archivo .txt");
     }
     try {
         PrintWriter pw = new PrintWriter(new File("C:\\JuegoPalabra\\Texto2.txt"));
         for (String palabra : palabras) {
             pw.print(palabra + " ");
         }
         
         pw.close();
     } catch (FileNotFoundException e) {
         
         System.out.println("No se pudo crear el archivo txt de destino");
     }
 	}
 
}