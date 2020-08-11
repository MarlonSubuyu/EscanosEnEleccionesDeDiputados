import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;

public class MainWindow extends JFrame {
    private JPanel rootMW;
    private JButton Mantenimientos;
    private JButton Movimiento;
    private JButton Procesos;
    private JButton Consultas;
    private JPanel MantenimientosPaneB;
    private JPanel MovimientosPaneB;
    private JPanel ProcesosPaneB;
    private JPanel ConsultasPaneB;
    private JPanel DefaultPaneB;
    private JLabel ImageLabel;
    private JTextField LoginUsuario;
    private JButton GuardarUsuarios;
    private JLabel Usuariostxt;
    private JLabel Passwordtxt;
    private JPasswordField PasswordUsuario;
    private JTextField NombreUsuario;
    private JLabel NombreUsuariotxt;
    private JLabel ApellidosUsuariotxt;
    private JTextField ApellidosUsuarios;
    private JLabel EmailUsuariotxt;
    private JTextField EmailUsuario;
    private JRadioButton Si;
    private JRadioButton No;
    private JLabel NivelAccesotxt;
    private JLabel ErrorLoginUsuario;
    private JLabel ErrorPasswordUsuario;
    private JButton GuardarPartidos;
    private JTextField IdPartido;
    private JLabel IdPartidotxt;
    private JTextField DescripcionPartido;
    private JTextField VotosPartidos;
    private JLabel VotosPartidostxt;
    private JLabel DescripcionPartidotxt;
    private JTextField CrearModificar;
    private JPanel UsuariosJpanel;
    //    TODO estos warnings son porque falta agregarle su toque de edición al tabbedpane, eso lo voy a hacer después
    private JPanel PartidosJpanel;
    private JPanel ProvinciasJpanel;
    private JPanel MunicipiosJpanel;
    private JPanel CircunscripcionesJpanel;
    private JPanel AlianzaJpanel;
    private JPanel RecintosJpanel;
    private JPanel CandidatosJpanel;
    private JPanel ColegiosJpanel;

    public MainWindow() {
        Jmenubar();

        Mantenimientos.setText("Mantenimientos");
        Movimiento.setText("Movimientos");
        Procesos.setText("Procesos");
        Consultas.setText("Consultas");
        GuardarUsuarios.setText("Guardar");
        UsuariosJpanel.setToolTipText("Usuarios");

        MantenimientosUsuarios();
        MantenimientosPartidos();

        Image img = new ImageIcon(getClass().getResource("Icons/PrincipalPictureLogin.png")).getImage();
        ImageLabel.setIcon(new ImageIcon(img));
        add(rootMW);
        setBounds(10, 50, 50, 10);
//        setExtendedState(MAXIMIZED_BOTH);
        setSize(900, 600);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        GuardarUsuarios.setEnabled(false);
        CrearModificar.setEnabled(false);

        MovimientosPaneB.setVisible(false);
        MantenimientosPaneB.setVisible(false);
        ProcesosPaneB.setVisible(false);
        ConsultasPaneB.setVisible(false);
        Mantenimientos.addActionListener(e -> {
            MantenimientosPaneB.setVisible(true);
            MovimientosPaneB.setVisible(false);
            ProcesosPaneB.setVisible(false);
            ConsultasPaneB.setVisible(false);
            //Image Label
            DefaultPaneB.setVisible(false);

        });
        Movimiento.addActionListener(e -> {
            MantenimientosPaneB.setVisible(false);
            MovimientosPaneB.setVisible(true);
            ProcesosPaneB.setVisible(false);
            ConsultasPaneB.setVisible(false);
            //Image Label
            DefaultPaneB.setVisible(false);
        });
        Procesos.addActionListener(e -> {
            MantenimientosPaneB.setVisible(false);
            MovimientosPaneB.setVisible(false);
            ProcesosPaneB.setVisible(true);
            ConsultasPaneB.setVisible(false);
            //Image Label
            DefaultPaneB.setVisible(false);
        });

        Consultas.addActionListener(e -> {
            MantenimientosPaneB.setVisible(false);
            MovimientosPaneB.setVisible(false);
            ProcesosPaneB.setVisible(false);
            ConsultasPaneB.setVisible(true);
            //Image Label
            DefaultPaneB.setVisible(false);
        });

//        Si esta seleccionado administrador
        Si.addActionListener(ea -> GuardarUsuarios.setEnabled(true));
//        No esta seleccionado administrador
        No.addActionListener(ee -> GuardarUsuarios.setEnabled(true));
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }

    public void MantenimientosUsuarios() {
        String Usuarios = System.getProperty("user.dir") + "\\src\\Archivos\\Usuarios.txt";
        File Archivo = new File(Usuarios);
        FileException(Archivo);

        Usuariostxt.setText("Usuario *");
        Passwordtxt.setText("Password *");
        NombreUsuariotxt.setText("Nombre del usuario *");
        ApellidosUsuariotxt.setText("Apellidos del usuario *");
        EmailUsuariotxt.setText("Email del usuario");
        NivelAccesotxt.setText("¿Administrador? *");
        ErrorLoginUsuario.setText("");
        ErrorPasswordUsuario.setText("");
        Si.setText("Sí");
        No.setText("No");

        GuardarUsuarios.addActionListener(e -> {
            String Login_Usuario = LoginUsuario.getText();
            String Pass_Usuario = String.valueOf(PasswordUsuario.getPassword());
            int Nivel_Acceso;
            String Nombre_Usuario = NombreUsuario.getText();
            String Apellidos_Usuarios = ApellidosUsuarios.getText();
            String Email_Usuario = EmailUsuario.getText();
            if (Si.isSelected()) {
                Nivel_Acceso = 0;
            } else {
                Nivel_Acceso = 1;
            }

            try {
                ErrorLoginUsuario.setText("");
                ErrorPasswordUsuario.setText("");
                boolean verificadordecamposiguales = false;
                if (Login_Usuario.equals("") || Pass_Usuario.equals("") || Nombre_Usuario.equals("") || Apellidos_Usuarios.equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos");
                } else {
                    if (Email_Usuario.equals("") || Email_Usuario.equals("NO-MAIL")) {
                        Email_Usuario = "NO-MAIL";
                    }
                    ArrayList<String> Lista = new ArrayList<>();
                    String delimitador = "\\s*;\\s*";
                    Scanner scan = new Scanner(Archivo);
                    scan.useDelimiter(delimitador);
                    scan.useDelimiter(delimitador);
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
                        if (Login_Usuario.equals(USER) || Pass_Usuario.equals(PASS)) {
                            if (Login_Usuario.equals(USER) && Pass_Usuario.equals(PASS)) {
                                ErrorLoginUsuario.setText("Utilice otro nombre de usuario");
                                ErrorLoginUsuario.setForeground(Color.red);
                                ErrorPasswordUsuario.setText("Utilice otra contraseña");
                                ErrorPasswordUsuario.setForeground(Color.red);
                            } else if (Login_Usuario.equals(USER)) {
                                ErrorLoginUsuario.setText("Utilice otro nombre de usuario");
                                ErrorLoginUsuario.setForeground(Color.red);
                            } else {
                                ErrorPasswordUsuario.setText("Utilice otra contraseña");
                                ErrorPasswordUsuario.setForeground(Color.red);
                            }
                            verificadordecamposiguales = true;
                        } else {
                            System.out.println("Buscando...");
                        }
                        scan.nextLine();
                    }
                    scan.close();
//                    while (scan.hasNext()) {
//                        for(int i=0;i<5; i++){
//                            u[i] = scan.next();
//                            System.out.println(i);
//                        }
//                        if(Login_Usuario.equals(u[0]) || Pass_Usuario.equals(u[1])) {
//                            if(Login_Usuario.equals(u[0])){
//                                ErrorLoginUsuario.setText("Utilice otro nombre de usuario");
//                                ErrorLoginUsuario.setForeground(Color.red);
//                            } else {
//                                ErrorPasswordUsuario.setText("Utilice otra contraseña");
//                                ErrorPasswordUsuario.setForeground(Color.red);
//                            }
//                            verificadordecamposiguales = true;
//                        } else {
//                            System.out.println("Buscando...");
//                        }
//                        scan.nextLine();
//                    }
                    if (!verificadordecamposiguales) {
                        try {
                            FileWriter Writer = new FileWriter(Archivo, true);
                            Writer.write(Login_Usuario + ";" + Pass_Usuario + ";" + Nivel_Acceso + ";" + Nombre_Usuario + ";" + Apellidos_Usuarios + ";" + Email_Usuario + ";" + "\r\n");
//                Writer.write(Pass_Usuario);
//                Writer.write(Nivel_Acceso);
                            Writer.close();
                            JOptionPane.showMessageDialog(null, "Ha registrado exitosamente al usuario");
                        } catch (IOException w) {
                            System.out.println("Ha ocurrido un error al escribir el archivo" + Archivo);
                        }
                    }
                }
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

    }

    public void MantenimientosPartidos() {
        String Partido = System.getProperty("user.dir") + "\\src\\Archivos\\Partido.txt";
        File Archivo = new File(Partido);
        String tempPartido = System.getProperty("user.dir") + "\\src\\Archivos\\tempPartido.txt";
        File tempArchivo = new File(tempPartido);
        String delimitador = "\\s*;\\s*";
        FileException(Archivo);

        IdPartidotxt.setText("Id del partido *");
        DescripcionPartidotxt.setText("Descripción del partido *");
        VotosPartidostxt.setText("Votos del partido");
        GuardarPartidos.setText("Guardar");
        final boolean[] igual = {false};
        getValor(delimitador, Archivo);
        IdPartido.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (getValor(delimitador, Archivo).contains(IdPartido.getText())) {
                    System.out.println("Modificando");
                    CrearModificar.setText("Modificando...");
                    igual[0] = true;
                } else {
                    System.out.println("Creando");
                    CrearModificar.setText("Creando...");
                    igual[0] = false;
                }
            }
        });

        GuardarPartidos.addActionListener(e -> {
            String Id_PartidoString = IdPartido.getText();
            int Id_Partido = Integer.parseInt(Id_PartidoString);
            String Descripcion_Partido = DescripcionPartido.getText();
            String Votos_PartidosString = VotosPartidos.getText();
            int Votos_Partidos = Integer.parseInt(Votos_PartidosString);

//            ErrorLoginUsuario.setText("");
//            ErrorPasswordUsuario.setText("");

            if (Id_PartidoString.equals("") || Descripcion_Partido.equals("")) {
                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos");
            } else if (igual[0]) {
                System.out.println("Accediendo al 2ndo if else");
                ModificaDatos(Id_PartidoString, Descripcion_Partido, Votos_PartidosString, Archivo, tempArchivo);
                JOptionPane.showMessageDialog(null, "Se ha modificado exitosamente al usuario");
                IdPartido.setText(null);
                DescripcionPartido.setText(null);
                VotosPartidos.setText(null);
            } else {
                System.out.println("Accediendo al else");
                try {
                    FileWriter Writer = new FileWriter(Partido, true);
                    Writer.write(Id_Partido + ";" + Descripcion_Partido + ";" + Votos_Partidos + ";" + "\r\n");
                    Writer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Se ha creado exitosamente el usuario");
                IdPartido.setText(null);
                DescripcionPartido.setText(null);
                VotosPartidos.setText(null);
            }
        });

    }

    private ArrayList<String> getValor(String delimitador, File Archivo) {
        FileException(Archivo);

        ArrayList<String> valor = new ArrayList<>();
        try {
            if (Archivo.length() == 0) {
                FileWriter Writer = new FileWriter(Archivo, true);
                Writer.write("0" + ";" + "0" + ";" + "0" + ";" + "\r\n");
                Writer.close();
            } else {
                Scanner scan = new Scanner(Archivo);
                scan.useDelimiter(delimitador);
                while (scan.hasNext()) {
                    String ID = scan.next();
                    String DESCRIPCION = scan.next();
                    valor.add(ID);
                    valor.add(DESCRIPCION);
                    scan.nextLine();
                }
                scan.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valor;
    }

    public void ModificaDatos(String ID, String Descripcion, String Votos, File Archivo, File tempArchivo) {
//        TODO ejemplo de ncadena
        String nCadena = (ID + ";" + Descripcion + ";" + Votos + ";"); //+ "\r\n" Se agrego en el siguiente metodo
        int cod = Integer.parseInt(ID);

        try {
            if (Archivo.exists()) {
                String linea;
                Scanner s = new Scanner(Archivo);
                while (s.hasNextLine()) {
                    linea = s.nextLine();
                    Scanner sl = new Scanner(linea);
                    sl.useDelimiter("\\s*;\\s*");
                    int codigoArc = Integer.parseInt(sl.next());
                    if (cod == codigoArc) {
                        Escribir(tempArchivo, nCadena);
                    } else {
                        Escribir(tempArchivo, linea);
                    }
                }
                s.close();
                borrar(Archivo);
                File dump = new File(String.valueOf(Archivo));
                boolean r = tempArchivo.renameTo(dump);
                if (r) {
                    System.out.println("SE PUDO RENOMBRAR EL ARCHIVO");
                } else {
                    System.out.println("HA OCURRIDO UN ERROR AL RENOMBRAR EL ARCHIVO");
                }
            } else {
                System.out.println("Fichero no Existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    } //Fin metodo modifica datos

    // metodo escribir registro
    public void Escribir(File tempArchivo, String nCadena) {
        // Declaramos un buffer de escritura
        BufferedWriter bw;
        try {
            // Comprobamos si el archivo no existe y si es asi creamos uno nuevo.
            if (!tempArchivo.exists()) {
                boolean f = tempArchivo.createNewFile();
                if (f) {
                    System.out.println("Se creo el archivo");
                }
            }
            // Luego de haber creado el archivo procedemos a escribir dentro de el.
            bw = new BufferedWriter(new FileWriter(tempArchivo, true));
            bw.write(nCadena + "\r\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrar(File Archivo) {
        try {
            // Comprovamos si el fichero existe de ser así procedemos a borrar el archivo
            if (Archivo.exists()) {
                boolean archivo = Archivo.delete();
                if (archivo) {
                    System.out.println("Fichero Borrado");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // fin metodo borrar

    public void FileException(File Archivo) {
        try {
            if (Archivo.createNewFile()) {
                System.out.println("Archivo creado: " + Archivo.getName());
            } else {
                System.out.println("El archivo ya existe" + Archivo.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear el archivo: " + Archivo.getName() + "\nCambie la ruta del archivo");
        }
    }

    public void Jmenubar() {
        JMenuBar MenuBar = new JMenuBar();
        setJMenuBar(MenuBar);
        JMenu File = new JMenu();
        JMenuItem CerrarSesion = new JMenuItem();
        File.setText("File");
        CerrarSesion.setText("Cerrar Sesión");
        File.add(CerrarSesion);
        MenuBar.add(File);
        CerrarSesion.addActionListener(e -> {
            Login Login = new Login();
            Login.setVisible(true);
            dispose();
        });
    }
}
