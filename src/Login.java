import javax.swing.*;
import java.awt.*;
import java.io.*;
//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

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
        String Usuarios = System.getProperty("user.dir") + "\\src\\Archivos\\Usuarios.txt";
        File Archivo = new File(Usuarios);

        try {
            if (Archivo.createNewFile()) {
                System.out.println("Archivo creado: " + Archivo.getName());
            } else {
                if (Archivo.length() == 0) {
                    ImageIcon advertencia = new ImageIcon(getClass().getResource("Icons/Advertencia.png"));
                    JOptionPane.showMessageDialog(null, "Archivo vacío", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    FileWriter Writer = new FileWriter(Archivo, true);
                    Writer.write("0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "\r");
                    Writer.close();
                }
            }
            System.out.println("Esta es la dirección donde se guarda el archivo: " + System.getProperty("user.dir") + "\\src\\Archivos\\Usuarios.txt" + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear el archivo: " + Archivo.getName() + "\nCambie la ruta del archivo");
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
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        IniciarSesion.setEnabled(false);
        Registrarse.setEnabled(false);

//        Si esta seleccionado administrador
        Si.addActionListener(ea -> {
            Registrarse.setEnabled(true);
            IniciarSesion.setEnabled(false);
            Registrarse.addActionListener(i -> {
                String Nivel_Acceso = "0"; //0 (Cero) para el administrador
                sesion(Nivel_Acceso, Archivo);
            });
        });
//        No esta seleccionado administrador
        No.addActionListener(ee -> {
            Registrarse.setEnabled(false);
            IniciarSesion.setEnabled(true);
            IniciarSesion.addActionListener(i -> {
                String Nivel_Acceso = "1"; //1 (Uno) para usuarios normales
                sesion(Nivel_Acceso, Archivo);
            });
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Login();
        // MainWindow MW = new MainWindow();
        //MW.setVisible(true);
        /*FileWriter Usuarios = new FileWriter(new File("C:\\Users\\eddys\\Desktop\\Usuarios.txt"));
        String title = "Marlon 123";
        Usuarios.write(title);
        Usuarios.close();*/
    }

    public void sesion(String Nivel_Acceso, File Usuarios) {
        try {
            String Usuario = UsuarioInput.getText();
            String Password = String.valueOf(PasswordInput.getPassword());
            if (Usuario.equals("") || Password.equals("")) {
                ImageIcon error = new ImageIcon(getClass().getResource("Icons/AdvertenciaVacio.png"));
                JOptionPane.showMessageDialog(null, "No puede dejar los campos vacios", null, JOptionPane.INFORMATION_MESSAGE, error);
            } else {
                Scanner scan = new Scanner(Usuarios);
                LinkedList<String> Lista = new LinkedList<>();

                String delimitador = "\\s*;\\s*";
                scan.useDelimiter(delimitador);
                boolean verificador = false;
                while (scan.hasNext()) {
                    String USER = scan.next();
                    String PASS = scan.next();
                    String LEVEL = scan.next();
                    String NAME = scan.next();
                    String APELLIDO = scan.next();
                    String EMAIL = scan.next();
                    Lista.add(USER);
                    Lista.add(PASS);
                    Lista.add(LEVEL);
                    Lista.add(NAME);
                    Lista.add(APELLIDO);
                    Lista.add(EMAIL);
                    scan.nextLine();
                    if (Usuario.equals(USER) && Password.equals(PASS) && Nivel_Acceso.equals(LEVEL)) {
                        verificador = true;
                    }
                }
                if (verificador) {
                    ImageIcon valida = new ImageIcon(getClass().getResource("Icons/SesionValida.png"));
                    JOptionPane.showMessageDialog(null, "Sesión válida", null, JOptionPane.INFORMATION_MESSAGE, valida);
                    MainWindow MW = new MainWindow();
                    MW.setVisible(true);
                    dispose();
                } else {
                    ImageIcon denegada = new ImageIcon(getClass().getResource("Icons/SesionDenegada.png"));
                    JOptionPane.showMessageDialog(null, "Sesión inválida", null, JOptionPane.INFORMATION_MESSAGE, denegada);
                }
                scan.close();
            }
        } catch (NullPointerException | IOException w) {
            ImageIcon error = new ImageIcon(getClass().getResource("Icons/Error.png"));
            JOptionPane.showMessageDialog(null, "Ocurrio un error interno, inténtelo nuevamente", null, JOptionPane.INFORMATION_MESSAGE, error);
            UsuarioInput.setText(null);
            PasswordInput.setText(null);
        }

    }
}
