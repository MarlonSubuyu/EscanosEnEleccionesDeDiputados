import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
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
                System.out.println("El archivo ya existe");
                if (Archivo.length() == 0) {
                    JOptionPane.showMessageDialog(null, "El archivo está vacío");
                    FileWriter Writer = new FileWriter(Archivo, true);
                    Writer.write("0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "\r");
                    Writer.close();
                } else {
                    System.out.println("El archivo no está vacío");
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
            System.out.println("Registrarse");
            Registrarse.addActionListener(i -> {
                String Nivel_Acceso = "0"; //0 (Cero) para el administrador
                sesion(Nivel_Acceso, Archivo);
            });
        });
//        No esta seleccionado administrador
        No.addActionListener(ee -> {
            Registrarse.setEnabled(false);
            IniciarSesion.setEnabled(true);
            System.out.println("Iniciar sesion");
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
                JOptionPane.showMessageDialog(null, "No puede dejar los campos vacios");
            } else {
                Scanner scan = new Scanner(Usuarios);
                ArrayList<String> Lista = new ArrayList<>();

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
//                    System.out.println(u[0] + " " + u[1] + " " + u[2] + " " + u[3] + " " + u[4] + " " + u[5]);
                    if (Usuario.equals(USER) && Password.equals(PASS) && Nivel_Acceso.equals(LEVEL)) {
                        verificador = true;
                    } else {
                        System.out.println("Buscando...");
                    }
                }
                if (verificador) {
                    ImageIcon valida = new ImageIcon(getClass().getResource("Icons/SesionValida.png"));
                    JOptionPane.showMessageDialog(null, new JLabel("Ha ingresado exitosamente", valida, JLabel.LEFT));
                    MainWindow MW = new MainWindow();
                    MW.setVisible(true);
                    dispose();
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

    }
}
