import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejemplo1 {

    public String GuardarDatos(String codigo, String nombre, String apellido, String edad) throws
            IOException {
        String Mensaje1 = null;
        File F1 = new File("e:archivoCte.txt");
        BufferedWriter escribir = null;
        escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(F1,
                true), StandardCharsets.UTF_8));

        try {
            if (!F1.exists()) {
                F1.createNewFile();
            }

            escribir.write(codigo + ";" + nombre + ";" + apellido + ";" + edad + "\n");
            escribir.close();
        } catch (Exception ex) {
            Mensaje1 = ("Error al grabar Archivo " + ex);
        }

        return (Mensaje1);
    } //Fin metodo guardarDatos

    public ArrayList LeerDatos(String codigo) throws FileNotFoundException,
            UnsupportedEncodingException, IOException {
        boolean encontrado = false;
        int cod = Integer.parseInt(codigo);
        ArrayList<String> ArrayListArchivo = new ArrayList<String>();

        File F1 = new File("e:archivoCte.txt");

        try {
            if (!F1.exists()) {
                F1.createNewFile();
            }
            Scanner s = new Scanner(F1);
            while (s.hasNextLine() && !encontrado) {
                String linea = s.nextLine();
                Scanner sl = new Scanner(linea);
                sl.useDelimiter("\\s*;\\s*");
                int codigoArc = Integer.parseInt(sl.next());

                if (cod == codigoArc) {
                    encontrado = true;
                    String nombre = sl.next();
                    String apellido = sl.next();
                    String edad = sl.next();
                    ArrayListArchivo.add("1");
                    ArrayListArchivo.add(nombre);
                    ArrayListArchivo.add(apellido);
                    ArrayListArchivo.add(edad);
                }
 /*else
 ArrayListArchivo.add("0");*/

            } // fin while

            s.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Error al leer Archivo " + e1);
            //e1.printStackTrace();
        }


        return (ArrayListArchivo);


    } // Fin metodo LeerDatos

    public void ModificaDatos(String codigo, String nombre, String apellido, String edad) {
        boolean encontrado = false;
        File fNuevo = new File("e:archivoCte1.txt");
        File fAntiguo = new File("e:archivoCte.txt");
        String aCadena = (codigo + ";" + nombre + ";" + apellido + ";" + edad);
        String nCadena = (codigo + ";" + nombre + ";" + apellido + ";" + edad);
        int cod = Integer.parseInt(codigo);

        // Declaro un nuevo buffer de lectura
        //BufferedReader br;
        try {
            if (fAntiguo.exists()) {
                // br = new BufferedReader(new FileReader(fAntiguo));
                String linea;
                Scanner s = new Scanner(fAntiguo);
                while (s.hasNextLine()) {
                    linea = s.nextLine();
                    Scanner sl = new Scanner(linea);
                    sl.useDelimiter("\\s*;\\s*");
                    int codigoArc = Integer.parseInt(sl.next());
                    if (cod == codigoArc) {
                        Escribir(fNuevo, nCadena);
                    } else {
                        Escribir(fNuevo, linea);
                    }

                } // fin while

                // Cierro el buffer de lectura
                s.close();
                // Capturo el nombre del fichero antiguo
                String nAntiguo = fAntiguo.getName();
                // Borro el fichero antiguo
                borrar(fAntiguo);
                //Renombro el fichero auxiliar con el nombre del fichero antiguo
                fNuevo.renameTo(new File(nAntiguo));
            } else {
                System.out.println("Fichero no Existe");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    } //Fin metodo modifica datos

    // metodo escribir registro
    public void Escribir(File fFichero, String cadena) {
        // Declaramos un buffer de escritura
        BufferedWriter bw;
        try {
            // Comprobamos si el archivo no existe y si es asi creamos uno nuevo.
            if (!fFichero.exists()) {
                fFichero.createNewFile();
            }
            // Luego de haber creado el archivo procedemos a escribir dentro de el.
            bw = new BufferedWriter(new FileWriter(fFichero, true));
            bw.write(cadena + "\r\n");
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    } // fin metedo escribir archivo
    // metodo Borrar

    public void borrar(File Ffichero) {
        try {
            // Comprovamos si el fichero existe de ser así procedemos a borrar el archivo
            if (Ffichero.exists()) {
                Ffichero.delete();
                System.out.println("Ficherro Borrado");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    } // fin metodo borrar
    // tiempo de pausa
//    public void Delay(long milis)
//    {
//        try {
//            Thread.sleep(milis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    } // fin metodo delay
} // fin clase Manejo de Archivos
