import javax.swing.*;

public class Login extends JFrame {
    private JPanel root;
    private JButton IniciarSesion;
    private JTextField UsuarioInput;
    private JPasswordField PasswordInput;
    private JLabel Usuariotxt;
    private JLabel Contrasenatxt;
    private JLabel Logintxt;

    public Login() {
//        SetText
        Usuariotxt.setText("Usuario");
        Contrasenatxt.setText("Contraseña");
        Logintxt.setText("Login");
        IniciarSesion.setText("Iniciar Sesión");
//        Inicialización
        add(root);
        setBounds(10, 50, 50, 10);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
//        ActionListener (Cuando el usuario presione el botón se realizarán estas acciones)
        IniciarSesion.addActionListener(e -> {
            try {
                String Usuario = UsuarioInput.getText();
                String Password = String.valueOf(PasswordInput.getPassword());
                if (Usuario.equals("") || Password.equals("")) {
                    JOptionPane.showMessageDialog(null, "No puede dejar los campos vacios");
                }
//                TODO crear un archivo para los usuarios
                else if (Usuario.equals("Marlon") && Password.equals("123")) {
                    JOptionPane.showMessageDialog(null, "Ha ingresado exitosamente");
//                    TODO crear un frame cuando sea exitoso el login
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    UsuarioInput.setText(null);
                    PasswordInput.setText(null);
                }
            } catch (NullPointerException w) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error interno, inténtelo nuevamente");
                UsuarioInput.setText(null);
                PasswordInput.setText(null);
            }

        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new Login();
    }
}
