package TrabajoLaPalabraDelDia;
import java.io.*;
import java.util.*;

public class LaPalabraDelDia {
    public static void main(String[] args) {
        
        try {
            File file = new File("C:\\JuegoPalabra\\Texto1.txt");
            Scanner scanner = new Scanner(file);
            PrintWriter writer = new PrintWriter("C:\\JuegoPalabra\\Texto2.txt" );

            while (scanner.hasNextLine()) {
                String palabra = scanner.nextLine();
                if (palabra.length() == 5) {
                    writer.println(palabra);
                }
            }

            writer.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no se pudo encontrar. ");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo. ");
        }


        try {
            File file = new File("C:\\JuegoPalabra\\Texto2.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<String> palabras = new ArrayList<String>();

            while (scanner.hasNextLine()) {
                palabras.add(scanner.nextLine());
            }

            String palabraSecreta = palabras.get(new Random().nextInt(palabras.size()));
            Juego juego = new Juego(palabraSecreta, palabras);
            juego.jugar();

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
    }
}

class Juego {
	private ArrayList<String> palabras;
    private String palabraSecreta;
    private int intentos;

    public Juego(String palabraSecreta,ArrayList<String> palabras) {
        this.palabraSecreta = palabraSecreta;
        this.intentos = 6;
        this.palabras = palabras;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        
        String intento;
        String jugarDeNuevo;

        do { palabraSecreta = palabras.get(new Random().nextInt(palabras.size())); 
            do {
                System.out.println("Intentos restantes: " + intentos);
                System.out.print("Ingresa tu intento (escribe un 0 para salir): ");
                intento = scanner.nextLine();

                if (intento.equals("0")) {
                	 try {
                         Thread.sleep(1000); 
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                	 System.out.println("Cerrando en 3...");
                	 try {
                         Thread.sleep(1000); 
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                	 System.out.println("Cerrando en 2...");
                	 try {
                         Thread.sleep(1000); 
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                	 System.out.println("Cerrando en 1...");
                	 try {
                         Thread.sleep(1000); 
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                	 System.out.println("Gracias por JUGAR...");
                    break;
                }
                if (!palabras.contains(intento)) {
                    System.out.println("Esa palabra no esta en la lista.");
                    try {
                        Thread.sleep(500); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   
                    continue;
                }

                if (intento.equals(palabraSecreta)) {
                    System.out.println("¡Has ganado!");
                    break;
                } else {
                	
                    mostrarPistas(intento);
                    intentos--;
                    
                }

                if (intentos == 0) {
                    System.out.println("Has perdido. La palabra era: " + palabraSecreta);
                    break;
                }

                try {
                    Thread.sleep(500); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);

            System.out.print("¿Quieres jugar de nuevo? (s/n): ");
            jugarDeNuevo = scanner.nextLine();
            intentos = 6; 
        } while (jugarDeNuevo.equalsIgnoreCase("s"));
    }

    private void mostrarPistas(String intento) {
        StringBuilder pistas = new StringBuilder();
        boolean[] aciertoPosicion = new boolean[5];

        for (int i = 0; i < 5; i++) {
            char c = intento.charAt(i);

            if (c == palabraSecreta.charAt(i)) {
                pistas.append(Character.toUpperCase(c));
                aciertoPosicion[i] = true;
            } else {
                pistas.append('_');
            }
        }

        for (int i = 0; i < 5; i++) {
            if (pistas.charAt(i) == '_') {
                char c = intento.charAt(i);

                for (int j = 0; j < 5; j++) {
                    if (!aciertoPosicion[j] && c == palabraSecreta.charAt(j)) {
                        pistas.setCharAt(i, Character.toLowerCase(c));
                        aciertoPosicion[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println("Pistas: " + pistas.toString());
    }
}