import javax.swing.*;
//import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
//import java.awt.event.*;

public class Login extends JFrame {
    private JPanel root;
    private JButton IniciarSesion;
    private JButton Registrarse;
    private JTextField UsuarioInput;
    private JPasswordField PasswordInput;
    private JLabel Usuariotxt;
    private JLabel Contrasenatxt;
    private JLabel Logintxt;
    private JRadioButton No;
    private JRadioButton Si;
    private JLabel Administrador;

    public Login() {
//        File
        String dir = "C:\\Users\\eddys\\Desktop\\Usuarios.txt";
        File Usuarios = new File(dir);
        try {
            if (Usuarios.createNewFile()) {
                System.out.println("Archivo creado: " + Usuarios.getName());
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear el archivo: " + Usuarios.getName() + "\nCambie la ruta del archivo");
        }
//        SetText
        Usuariotxt.setText("Usuario");
        Contrasenatxt.setText("Contraseña");
        Logintxt.setText("Login");
        IniciarSesion.setText("Iniciar Sesión");
        Administrador.setText("¿Es administrador?");
        Registrarse.setText("Registrarse");
        Si.setText("Sí");
        No.setText("No");
//        Inicialización
        add(root);
        setBounds(10, 50, 50, 10);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        IniciarSesion.setEnabled(false);
        Registrarse.setEnabled(false);

//        Si esta seleccionado administrador
        Si.addActionListener(ea -> {
            Registrarse.setEnabled(true);
            IniciarSesion.setEnabled(false);
            System.out.println("Registrarse");
            Registrarse.addActionListener(i -> {
                try {
                    String Usuario = UsuarioInput.getText();
                    String Password = String.valueOf(PasswordInput.getPassword());
                    String Nivel_Acceso = "0"; //0 (Cero) para el administrador
                    if (Usuario.equals("") || Password.equals("")) {
                        JOptionPane.showMessageDialog(null, "No puede dejar los campos vacios");
                    } else {
                        Scanner scan = new Scanner(Usuarios);
                        String a;
                        String b;
                        String c;
                        boolean verificador = false;
                        while (scan.hasNext()) {
                            a = scan.next();
                            b = scan.next();
                            c = scan.next();
                            System.out.println(a + " " + b + " " + c);
                            if (Usuario.equals(a) && Password.equals(b) && Nivel_Acceso.equals(c)) {
                                verificador = true;
                            } else {
                                System.out.println("Buscando...");
                            }
                        }
                        if (verificador) {
                            JOptionPane.showMessageDialog(null, "Ha ingresado exitosamente");
//                    TODO crear un frame cuando sea exitoso el login
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
//                            UsuarioInput.setText(null);
//                            PasswordInput.setText(null);
                        }
                        scan.close();
                    }
                } catch (NullPointerException | IOException w) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error interno, inténtelo nuevamente");
                }
            });
        });
//        No esta seleccionado administrador
        No.addActionListener(ee -> {
            Registrarse.setEnabled(false);
            IniciarSesion.setEnabled(true);
            System.out.println("Iniciar sesion");
            IniciarSesion.addActionListener(i -> {
                try {
                    String Usuario = UsuarioInput.getText();
                    String Password = String.valueOf(PasswordInput.getPassword());
                    String Nivel_Acceso = "1"; //1 (Uno) para usuarios normales
                    if (Usuario.equals("") || Password.equals("")) {
                        JOptionPane.showMessageDialog(null, "No puede dejar los campos vacios");
                    } else {
                        Scanner scan = new Scanner(Usuarios);
                        String a;
                        String b;
                        String c;
                        boolean verificador = false;
                        while (scan.hasNext()) {
                            a = scan.next();
                            b = scan.next();
                            c = scan.next();
                            System.out.println(a + " " + b + " " + c);
                            if (Usuario.equals(a) && Password.equals(b) && Nivel_Acceso.equals(c)) {
                                verificador = true;
                            } else {
                                System.out.println("Buscando...");
                            }
                        }
                        if (verificador) {
                            JOptionPane.showMessageDialog(null, "Ha ingresado exitosamente");
//                    TODO crear un frame cuando sea exitoso el login
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                        }
                        scan.close();
                    }
                } catch (NullPointerException | IOException w) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error interno, inténtelo nuevamente");
                    UsuarioInput.setText(null);
                    PasswordInput.setText(null);
                }

            });
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Login();
        /*FileWriter Usuarios = new FileWriter(new File("C:\\Users\\eddys\\Desktop\\Usuarios.txt"));
        String title = "Marlon 123";
        Usuarios.write(title);
        Usuarios.close();*/

    }
}
