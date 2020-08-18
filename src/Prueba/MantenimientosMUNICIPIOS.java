//import javax.swing.*;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;

//public class MantenimientosMUNICIPIOS{
//    public MantenimientosMUNICIPIOS(JButton GuardarMunicipios, JTextField IdMunicipio, JTextField NombreMunicipio, JTextField IdProvinciaMunicipio, JTextField CrearModificarMunicipios, JLabel IdMunicipiotxt, JLabel NombreMunicipiotxt, JLabel IdProvinciaMunicipiotxt){
//        String Partido = System.getProperty("user.dir") + "\\src\\Archivos\\Partido.txt";
//        File Archivo = new File(Partido);
//        String tempPartido = System.getProperty("user.dir") + "\\src\\Archivos\\tempPartido.txt";
//        File tempArchivo = new File(tempPartido);
//        String delimitador = "\\s*;\\s*";
//        FileException(Archivo);
//
//        IdMunicipiotxt.setText("Id del partido *");
//        NombreMunicipiotxt.setText("Descripción del partido *");
//        IdProvinciaMunicipiotxt.setText("Votos del partido");
//        GuardarMunicipios.setText("Guardar");
//        final boolean[] igual = {false};
//        String MODELO = "0" + ";" + "0" + ";" + "0" + ";" + "\r\n";
//        getValor(delimitador, Archivo, MODELO);
//        IdMunicipio.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                super.keyReleased(e);
//                if (getValor(delimitador, Archivo, MODELO).contains(IdMunicipio.getText())) {
//                    CrearModificarMunicipios.setText("Modificando...");
//                    igual[0] = true;
//                } else {
//                    CrearModificarMunicipios.setText("Creando...");
//                    igual[0] = false;
//                }
//            }
//        });
//
//        GuardarMunicipios.addActionListener(e -> {
//            String Id_MunicipioString = IdMunicipio.getText();
//            String Nombre_Municipio = NombreMunicipio.getText();
//            String Id_Provincia_MunicipioString = IdProvinciaMunicipio.getText();
//
////            ErrorLoginUsuario.setText("");
////            ErrorPasswordUsuario.setText("");
//
//            if (Id_MunicipioString.equals("") || Nombre_Municipio.equals("")) {
//                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos");
//            } else if (igual[0]) {
//                String nCadena = (Id_MunicipioString + ";" + Nombre_Municipio + ";" + Id_Provincia_MunicipioString + ";"); //+ "\r\n" Se agrego en el siguiente metodo
//                ModificaDatos(nCadena, Id_MunicipioString, Archivo, tempArchivo);
//                JOptionPane.showMessageDialog(null, "Se ha modificado exitosamente al usuario");
//                IdMunicipio.setText(null);
//                NombreMunicipio.setText(null);
//                IdProvinciaMunicipio.setText(null);
//            } else {
//                try {
//                    int Id_Partido = Integer.parseInt(Id_MunicipioString);
//                    int Votos_Partidos = Integer.parseInt(Id_Provincia_MunicipioString);
//                    FileWriter Writer = new FileWriter(Partido, true);
//                    Writer.write(Id_Partido + ";" + Nombre_Municipio + ";" + Votos_Partidos + ";" + "\r\n");
//                    JOptionPane.showMessageDialog(null, "Se ha creado exitosamente el usuario");
//                    Writer.close();
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//                catch (NumberFormatException n){
//                    JOptionPane.showMessageDialog(null, "Id del partido debe ser un numero entero \nVotos del partido debe ser un numero entero");
//                }
//                IdMunicipio.setText(null);
//                NombreMunicipio.setText(null);
//                IdProvinciaMunicipio.setText(null);
//            }
//        });
//    }
//}