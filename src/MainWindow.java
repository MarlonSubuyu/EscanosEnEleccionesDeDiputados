import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;

import static javax.swing.RowFilter.regexFilter;

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
    private JButton GuardarProvincias;
    private JTextField IdProvincia;
    private JTextField NombreProvincia;
    private JLabel IdProvinciatxt;
    private JLabel NombreProvinciatxt;
    private JTextField CrearModificarProvincias;
    private JButton GuardarMunicipios;
    private JTextField IdMunicipio;
    private JTextField NombreMunicipio;
    private JTextField IdProvinciaMunicipio;
    private JTextField CrearModificarMunicipios;
    private JLabel IdMunicipiotxt;
    private JLabel NombreMunicipiotxt;
    private JLabel IdProvinciaMunicipiotxt;
    private JTextField SearchUsuarios;
    private JTable UsuariosTable;
    private JTable PartidosTable;
    private JTextField SearchPartidos;
    private JTextField SearchProvincias;
    private JTable ProvinciasTable;
    private JTextField SearchMunicipios;
    private JTable MunicipiosTable;
    private JButton btnAceptarCircunscripciones;
    private JTextField NombreCircunscripcion;
    private JTextField IdProvinciaCircuns;
    private JTextField IdMunicipioCircuns;
    private JTextField CrearCircunscripcion;
    private JTextField IdCircunscripcion;
    private JTextField CantCandidatos;

    public MainWindow() {

        Jmenubar();

        Mantenimientos.setText("Mantenimientos");
        Movimiento.setText("Movimientos");
        Procesos.setText("Procesos");
        Consultas.setText("Consultas");
        GuardarUsuarios.setText("Guardar");
        ArrayList<String> ListaUsuarios = new ArrayList<>();
        ArrayList<String> ListaMunicipios = new ArrayList<>();

        MantenimientosUsuarios(ListaUsuarios);
        MantenimientosPartidos();
        MantenimientosProvincias();
        MantenimientosMunicipios(ListaMunicipios);
        MantenimientosCircunscripciones();
        //Leer archivos
        LeerUsuarios();
        LeerPartidos();
        LeerProvincias();
        LeerMunicipios();

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
        CrearModificarProvincias.setEnabled(false);
        CrearModificarMunicipios.setEnabled(false);

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

    public void MantenimientosUsuarios( ArrayList<String> ListaUsuarios ) {
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
                    ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                    JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos", null, JOptionPane.INFORMATION_MESSAGE, list);
                } else {
                    if (Email_Usuario.equals("") || Email_Usuario.equals("NO-MAIL")) {
                        Email_Usuario = "NO-MAIL";
                    }
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
                        ListaUsuarios.add(USER);
                        ListaUsuarios.add(PASS);
                        ListaUsuarios.add(LEVEL);
                        ListaUsuarios.add(NAME);
                        ListaUsuarios.add(APELLIDO);
                        ListaUsuarios.add(EMAIL);
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
                        }
                        scan.nextLine();
                    }
                    scan.close();
                    if (!verificadordecamposiguales) {
                        try {
                            FileWriter Writer = new FileWriter(Archivo, true);
                            Writer.write(Login_Usuario + ";" + Pass_Usuario + ";" + Nivel_Acceso + ";" + Nombre_Usuario + ";" + Apellidos_Usuarios + ";" + Email_Usuario + ";" + "\r\n");
                            Writer.close();
                            ImageIcon edit = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                            JOptionPane.showMessageDialog(null, "Ha registrado exitosamente al usuario", null, JOptionPane.INFORMATION_MESSAGE, edit);
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
        String MODELO = "0" + ";" + "0" + ";" + "0" + ";" + "\r\n";
        getValor(delimitador, Archivo, MODELO);
        IdPartido.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (getValor(delimitador, Archivo, MODELO).contains(IdPartido.getText())) {
                    CrearModificar.setText("Modificando...");
                    igual[0] = true;
                } else {
                    CrearModificar.setText("Creando...");
                    igual[0] = false;
                }
            }
        });

        GuardarPartidos.addActionListener(e -> {
            String Id_PartidoString = IdPartido.getText();
            String Descripcion_Partido = DescripcionPartido.getText();
            String Votos_PartidosString = VotosPartidos.getText();

//            ErrorLoginUsuario.setText("");
//            ErrorPasswordUsuario.setText("");

            if (Id_PartidoString.equals("") || Descripcion_Partido.equals("")) {
                ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos", null, JOptionPane.INFORMATION_MESSAGE, list);
            } else if (igual[0]) {
                String nCadena = (Id_PartidoString + ";" + Descripcion_Partido + ";" + Votos_PartidosString + ";"); //+ "\r\n" Se agrego en el siguiente metodo
                ModificaDatos(nCadena, Id_PartidoString, Archivo, tempArchivo);
                ImageIcon edit = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                JOptionPane.showMessageDialog(null, "Partido modificado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, edit);
                IdPartido.setText(null);
                DescripcionPartido.setText(null);
                VotosPartidos.setText(null);
            } else {
                try {
                    int Id_Partido = Integer.parseInt(Id_PartidoString);
                    int Votos_Partidos = Integer.parseInt(Votos_PartidosString);
                    FileWriter Writer = new FileWriter(Partido, true);
                    Writer.write(Id_Partido + ";" + Descripcion_Partido + ";" + Votos_Partidos + ";" + "\r\n");
                    ImageIcon create = new ImageIcon(getClass().getResource("Icons/create.png"));
                    JOptionPane.showMessageDialog(null, "Partido creado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, create);
                    Writer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (NumberFormatException n) {
                    ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                    JOptionPane.showMessageDialog(null, "Id del partido debe ser un numero entero \nVotos del partido debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                }
                IdPartido.setText(null);
                DescripcionPartido.setText(null);
                VotosPartidos.setText(null);
            }
        });

    }

    public void MantenimientosProvincias() {
        String Provincia = System.getProperty("user.dir") + "\\src\\Archivos\\Provincia.txt";
        File Archivo = new File(Provincia);
        String tempProvincia = System.getProperty("user.dir") + "\\src\\Archivos\\tempProvincia.txt";
        File tempArchivo = new File(tempProvincia);
        String delimitador = "\\s*;\\s*";
        FileException(Archivo);
        IdProvinciatxt.setText("Id de la provincia *");
        NombreProvinciatxt.setText("Nombre de la provincia *");
        GuardarProvincias.setText("Guardar");

        final boolean[] igual = {false};
        String MODELO = "0" + ";" + "0" + ";" + "\r\n";
        getValor(delimitador, Archivo, MODELO);
        IdProvincia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (getValor(delimitador, Archivo, MODELO).contains(IdProvincia.getText())) {
                    CrearModificarProvincias.setText("Modificando...");
                    igual[0] = true;
                } else {
                    CrearModificarProvincias.setText("Creando...");
                    igual[0] = false;
                }
            }
        });

        GuardarProvincias.addActionListener(e -> {
            String Id_ProvinciaString = IdProvincia.getText();
            String Nombre_Provincia = NombreProvincia.getText();
            if (Id_ProvinciaString.equals("") || Nombre_Provincia.equals("")) {
                ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos", null, JOptionPane.INFORMATION_MESSAGE, list);
            } else if (igual[0]) {
                String nCadena = (Id_ProvinciaString + ";" + Nombre_Provincia + ";"); //+ "\r\n" Se agrego en el siguiente metodo
                ModificaDatos(nCadena, Id_ProvinciaString, Archivo, tempArchivo);
                ImageIcon edit = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                JOptionPane.showMessageDialog(null, "Provincia modificada exitosamente", null, JOptionPane.INFORMATION_MESSAGE, edit);
                IdProvincia.setText(null);
                NombreProvincia.setText(null);
            } else {
                try {
                    int Id_Provincia = Integer.parseInt(Id_ProvinciaString);
                    FileWriter Writer = new FileWriter(Provincia, true);
                    Writer.write(Id_Provincia + ";" + Nombre_Provincia + ";" + "\r\n");
                    ImageIcon create = new ImageIcon(getClass().getResource("Icons/create.png"));
                    JOptionPane.showMessageDialog(null, "Provincia creada exitosamente", null, JOptionPane.INFORMATION_MESSAGE, create);
                    Writer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (NumberFormatException n) {
                    ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                    JOptionPane.showMessageDialog(null, "Id de la provincia debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                }
                IdProvincia.setText(null);
                NombreProvincia.setText(null);
            }
        });

    }

    private void MantenimientosMunicipios( ArrayList<String> ListaMunicipios ) {
//        System.out.println("Mantenimiento muni");
//        new MantenimientosMUNICIPIOS(GuardarMunicipios, IdMunicipio, NombreMunicipio, IdProvinciaMunicipio, CrearModificarMunicipios, IdMunicipiotxt, NombreMunicipiotxt, IdProvinciaMunicipiotxt);
        String Municipio = System.getProperty("user.dir") + "\\src\\Archivos\\Municipios.txt";
        File Archivo = new File(Municipio);
        String Provincia = System.getProperty("user.dir") + "\\src\\Archivos\\Provincia.txt";
        File LeerArchivo = new File(Provincia); //Leer archivo es para leer el Id_provincia que se usa para verificar si el dato introducido existe en el archivo
        String tempMunicipio = System.getProperty("user.dir") + "\\src\\Archivos\\tempPartido.txt";
        File tempArchivo = new File(tempMunicipio);
        String delimitador = "\\s*;\\s*";
        FileException(Archivo);

        IdMunicipiotxt.setText("Id del municipio *");
        NombreMunicipiotxt.setText("Descripción del municipio *");
        IdProvinciaMunicipiotxt.setText("Id de la provincia *");
        GuardarMunicipios.setText("Guardar");
        final boolean[] igual = {false};
        String MODELO = "0" + ";" + "0" + ";" + "0" + ";" + "\r\n";
        getValor(delimitador, Archivo, MODELO);
        IdMunicipio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (getValor(delimitador, Archivo, MODELO).contains(IdMunicipio.getText())) {
                    CrearModificarMunicipios.setText("Modificando...");
                    igual[0] = true;
                } else {
                    CrearModificarMunicipios.setText("Creando...");
                    igual[0] = false;
                }
            }
        });

        GuardarMunicipios.addActionListener(e -> {
            String Id_MunicipioString = IdMunicipio.getText();
            String Nombre_Municipio = NombreMunicipio.getText();
            String Id_Provincia_MunicipioString = IdProvinciaMunicipio.getText();

//            ErrorLoginUsuario.setText("");
//            ErrorPasswordUsuario.setText("");

            if (Id_MunicipioString.equals("") || Nombre_Municipio.equals("") || Id_Provincia_MunicipioString.equals("")) {
                ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos", null, JOptionPane.INFORMATION_MESSAGE, list);
            } else if (igual[0]) {
                boolean verificador = false;
                try {

                    Scanner scan = new Scanner(LeerArchivo);
                    scan.useDelimiter(delimitador);
                    scan.useDelimiter(delimitador);

                    while (scan.hasNext()) {
                        String ID = scan.next();
                        String PROVINCIA = scan.next();
                        ListaMunicipios.add(ID);
                        ListaMunicipios.add(PROVINCIA);
                        if (Id_Provincia_MunicipioString.equals(ID)) {
                            verificador = true;
                        }
                        scan.nextLine();
                    }
                    scan.close();
                } catch (IOException ex) {
                    ex.getStackTrace();
                }
                if (verificador) { //Si la provincia existe podemos pasar a registrar los datos
                    String nCadena = (Id_MunicipioString + ";" + Nombre_Municipio + ";" + Id_Provincia_MunicipioString + ";"); //+ "\r\n" Se agrego en el siguiente metodo
                    ModificaDatos(nCadena, Id_MunicipioString, Archivo, tempArchivo);
                    ImageIcon edit = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                    JOptionPane.showMessageDialog(null, "Municipio modificado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, edit);
                    IdMunicipio.setText(null);
                    NombreMunicipio.setText(null);
                } else {
                    ImageIcon advertencia = new ImageIcon(getClass().getResource("Icons/AdvertenciaVacio.png"));
                    JOptionPane.showMessageDialog(null, "¡El municipio no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                }
                IdProvinciaMunicipio.setText(null);
            } else {

                boolean verificador = false;
                try {
                    Scanner scan = new Scanner(LeerArchivo);
                    scan.useDelimiter(delimitador);
                    scan.useDelimiter(delimitador);

                    while (scan.hasNext()) {
                        String ID = scan.next();
                        String PROVINCIA = scan.next();
                        ListaMunicipios.add(ID);
                        ListaMunicipios.add(PROVINCIA);
                        if (Id_Provincia_MunicipioString.equals(ID)) {
                            verificador = true;
                        }
                        scan.nextLine();
                    }
                    scan.close();
                } catch (IOException ex) {
                    ex.getStackTrace();
                }
                if (verificador) { //Si la provincia existe podemos pasar a registrar los datos
                    try {
                        int Id_Partido = Integer.parseInt(Id_MunicipioString);
                        int Votos_Partidos = Integer.parseInt(Id_Provincia_MunicipioString);
                        FileWriter Writer = new FileWriter(Municipio, true);
                        Writer.write(Id_Partido + ";" + Nombre_Municipio + ";" + Votos_Partidos + ";" + "\r\n");
                        ImageIcon create = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                        JOptionPane.showMessageDialog(null, "Municipio creado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, create);
                        Writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (NumberFormatException n) {
                        ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                        JOptionPane.showMessageDialog(null, "Id del municipio debe ser un numero entero \nId de la provincia debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                    }
                    IdMunicipio.setText(null);
                    NombreMunicipio.setText(null);
                } else {
                    ImageIcon advertencia = new ImageIcon(getClass().getResource("Icons/AdvertenciaVacio.png"));
                    JOptionPane.showMessageDialog(null, "¡El municipio no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                }
                IdProvinciaMunicipio.setText(null);
            }
        });
    }

    private void MantenimientosCircunscripciones() {

        String Municipio = System.getProperty("user.dir") + "\\src\\Archivos\\Municipios.txt";
        File LeerArchvioMunicipio = new File(Municipio);
        String Provincia = System.getProperty("user.dir") + "\\src\\Archivos\\Provincia.txt";
        File LeerArchivo = new File(Provincia); //Leer archivo es para leer el Id_provincia que se usa para verificar si el dato introducido existe en el archivo
        String Circunscripciones = System.getProperty("user.dir") + "\\src\\Archivos\\Circunscripciones.txt";
        File Archivo = new File(Circunscripciones);
        String tempCircunscripciones = System.getProperty("user.dir") + "\\src\\Archivos\\tempCircunscripciones.txt";
        File tempArchivo = new File(tempCircunscripciones);
        String delimitador = "\\s*;\\s*";
        FileException(Archivo);

        final boolean[] igual = {false};
        String MODELO = "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "\r\n";
        getValor(delimitador, Archivo, MODELO);
        IdCircunscripcion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e ) {
                super.keyReleased(e);
                if (getValor(delimitador, Archivo, MODELO).contains(IdCircunscripcion.getText())) {
                    CrearCircunscripcion.setText("Modificando...");
                    igual[0] = true;
                } else {
                    CrearCircunscripcion.setText("Creando...");
                    igual[0] = false;
                }
            }
        });

        btnAceptarCircunscripciones.addActionListener(e -> {
            String Id_CircunscripcionString = IdCircunscripcion.getText();
            String Nombre_Circunscripcion = NombreCircunscripcion.getText();
            String Id_Provincia_Circuns = IdProvinciaCircuns.getText();
            String Id_Municipio_Circuns = IdMunicipioCircuns.getText();
            String Cant_Candidatos = CantCandidatos.getText();
            int[] Id_Municipio_CircunsArray;

            if (Id_CircunscripcionString.equals("") || Nombre_Circunscripcion.equals("")) {
                ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos", null, JOptionPane.INFORMATION_MESSAGE, list);
            } else if (igual[0]) {
                boolean verificador = false;
                boolean verificadorMunicipio = false;
                int IdMunicipiosCircunscripcion = Integer.parseInt(Id_Municipio_Circuns);
                try {
                    ArrayList<String> Lista = new ArrayList<>();
                    Scanner scan = new Scanner(LeerArchivo);
                    scan.useDelimiter(delimitador);

                    while (scan.hasNext()) {
                        String ID = scan.next();
                        String PROVINCIA = scan.next();
                        Lista.add(ID);
                        Lista.add(PROVINCIA);
                        if (Id_Provincia_Circuns.equals(ID)) {
                            verificador = true;
                        }

                        scan.nextLine();
                    }
                    scan.close();
                    ArrayList<String> ListaMunicipios = new ArrayList<>();

                    Scanner entrada = new Scanner(LeerArchvioMunicipio);
                    entrada.useDelimiter(delimitador);

                    while (entrada.hasNext()) {
                        String ID = entrada.next();
                        ListaMunicipios.add(ID);
                        if (Id_Municipio_Circuns.equals(ID)) {
                            verificador = true;
                        }
                        entrada.nextLine();
                    }
                    Id_Municipio_CircunsArray = new int[ListaMunicipios.size()];
                    for (int i = 0; i < ListaMunicipios.size(); i++) {
                        Id_Municipio_CircunsArray[i] = Integer.parseInt(ListaMunicipios.get(i));
                        if (Id_Municipio_CircunsArray[i] == IdMunicipiosCircunscripcion) {
                            verificadorMunicipio = true;
                        }

                    }
                } catch (IOException ex) {
                    ex.getStackTrace();
                }
                if (verificador && verificadorMunicipio) { //Si la provincia existe podemos pasar a registrar los datos
                    String nCadena = (Id_CircunscripcionString + ";" + Nombre_Circunscripcion + ";" + Id_Provincia_Circuns + ";" + Id_Municipio_Circuns + ";" + Cant_Candidatos + ";"); //+ "\r\n" Se agrego en el siguiente metodo
                    ModificaDatos(nCadena, Id_CircunscripcionString, Archivo, tempArchivo);
                    ImageIcon edit = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                    JOptionPane.showMessageDialog(null, "Circunscripción modificada exitosamente", null, JOptionPane.INFORMATION_MESSAGE, edit);
                    IdCircunscripcion.setText(null);
                } else {
                    ImageIcon advertencia = new ImageIcon(getClass().getResource("Icons/AdvertenciaVacio.png"));
                    // JOptionPane.showMessageDialog(null, "¡El ID de la provincia no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    if (!verificador && !verificadorMunicipio) {
                        JOptionPane.showMessageDialog(null, " ¡El ID de la provincia y el ID del municipio no existen!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    } else if (!verificadorMunicipio) {
                        JOptionPane.showMessageDialog(null, "¡El del municipio no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡El ID de la provincia no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    }
                }
                IdProvinciaMunicipio.setText(null);
            } else {
                boolean verificador = false;
                boolean verificadorMunicipio = false;
                int IdMunicipiosCircunscripcion = 0;
                try {
                    try {
                        IdMunicipiosCircunscripcion = Integer.parseInt(Id_Municipio_Circuns);
                    } catch (NumberFormatException n) {
                        ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                        JOptionPane.showMessageDialog(null, "Id del municipio debe ser un numero entero \nId de la provincia debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                    }


                    ArrayList<String> Lista = new ArrayList<>();
                    Scanner scan = new Scanner(LeerArchivo);
                    scan.useDelimiter(delimitador);
                    scan.useDelimiter(delimitador);

                    while (scan.hasNext()) {
                        String ID = scan.next();
                        String PROVINCIA = scan.next();
                        Lista.add(ID);
                        Lista.add(PROVINCIA);
                        if (Id_Provincia_Circuns.equals(ID)) {
                            verificador = true;
                        }
                        scan.nextLine();
                    }
                    scan.close();
                    ArrayList<String> ListaMunicipios = new ArrayList<>();

                    Scanner entrada = new Scanner(LeerArchvioMunicipio);
                    entrada.useDelimiter(delimitador);

                    while (entrada.hasNext()) {
                        String ID = entrada.next();
                        ListaMunicipios.add(ID);
                        if (Id_Municipio_Circuns.equals(ID)) {
                            verificador = true;
                        }
                        entrada.nextLine();

                    }
                    Id_Municipio_CircunsArray = new int[ListaMunicipios.size()];
                    for (int i = 0; i < ListaMunicipios.size(); i++) {
                        Id_Municipio_CircunsArray[i] = Integer.parseInt(ListaMunicipios.get(i));
                        if (Id_Municipio_CircunsArray[i] == IdMunicipiosCircunscripcion) {
                            verificadorMunicipio = true;
                        }
                    }
                } catch (IOException ex) {
                    ex.getStackTrace();
                }
                if (verificador && verificadorMunicipio) { //Si la provincia existe podemos pasar a registrar los datos
                    try {
//                        IdMunicipiosCircunscripcion = Integer.parseInt(Id_CircunscripcionString);
//                        int Votos_Partidos = Integer.parseInt(Nombre_Circunscripcion);
                        FileWriter Writer = new FileWriter(Archivo, true);
                        Writer.write(Id_CircunscripcionString + ";" + Nombre_Circunscripcion + ";" + Id_Provincia_Circuns + ";" + Id_Municipio_Circuns + ";" + Cant_Candidatos + ";" + "\r\n");
                        ImageIcon create = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                        JOptionPane.showMessageDialog(null, "Circunscripción creada exitosamente", null, JOptionPane.INFORMATION_MESSAGE, create);
                        Writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (NumberFormatException n) {
                        ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                        JOptionPane.showMessageDialog(null, "Id del municipio debe ser un numero entero \nId de la provincia debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                    }
                    IdMunicipio.setText(null);
                    NombreMunicipio.setText(null);
                } else {
                    ImageIcon advertencia = new ImageIcon(getClass().getResource("Icons/AdvertenciaVacio.png"));
                    // JOptionPane.showMessageDialog(null, "¡El ID de la provincia no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    if (!verificador && !verificadorMunicipio) {
                        JOptionPane.showMessageDialog(null, " ¡El ID de la provincia y el ID del municipio no existen!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    } else if (!verificadorMunicipio) {
                        JOptionPane.showMessageDialog(null, "¡El del municipio no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡El ID de la provincia no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    }
                }
                IdProvinciaMunicipio.setText(null);
            }
        });
    }

    public ArrayList<String> getValor( String delimitador, File Archivo, String MODELO ) {
        FileException(Archivo);

        ArrayList<String> valor = new ArrayList<>();
        try {
            if (Archivo.length() == 0) {
                FileWriter Writer = new FileWriter(Archivo, true);
                Writer.write(MODELO);
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

    public void ModificaDatos(String nCadena, String ID, File Archivo, File tempArchivo) {
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
    }

    public void FileException(File Archivo) {
        try {
            if (Archivo.createNewFile()) {
                System.out.println("El archivo no existe " + getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
            ImageIcon error = new ImageIcon(getClass().getResource("Icons/Error.png"));
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear el archivo: " + Archivo.getName() + "\nCambie la ruta del archivo", null, JOptionPane.INFORMATION_MESSAGE, error);
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

    public void LeerUsuarios() {
        String Usuarios = System.getProperty("user.dir") + "\\src\\Archivos\\Usuarios.txt";
        File Archivo = new File(Usuarios);
        FileException(Archivo);
        try {
            String[] columnsName = {"Usuario", "Password", "Nivel de acceso", "Nombre del usuario", "Apellidos del usuario", "Email del usuario"};
            String delimitador = "\\s*;\\s*";
            Scanner scan = new Scanner(Archivo);
            scan.useDelimiter(delimitador);
            DefaultTableModel model = (DefaultTableModel) UsuariosTable.getModel();
            model.setColumnIdentifiers(columnsName);
            while (scan.hasNext()) {
                String USER = scan.next();
                String PASS = scan.next();
                String LEVEL = scan.next();
                String NAME = scan.next();
                String APELLIDO = scan.next();
                String EMAIL = scan.next();
                String[] DATA = {USER, PASS, LEVEL, NAME, APELLIDO, EMAIL};
                model.addRow(DATA);
                scan.nextLine();
            }

            SearchUsuarios.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased( KeyEvent e ) {
                    super.keyReleased(e);
                    String search = SearchUsuarios.getText().toLowerCase();
                    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model); //DefaultTableModel
                    UsuariosTable.setRowSorter(tr);
                    tr.setRowFilter(regexFilter(search));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer la tabla Usuarios");
        }
    }

    public void LeerPartidos() {
        String Partidos = System.getProperty("user.dir") + "\\src\\Archivos\\Partido.txt";
        File Archivo = new File(Partidos);
        FileException(Archivo);
        try {
            String[] columnsName = {"Id del partido", "Descripción del partido", "Votos del partido"};
            String delimitador = "\\s*;\\s*";
            Scanner scan = new Scanner(Archivo);
            scan.useDelimiter(delimitador);
            DefaultTableModel model = (DefaultTableModel) PartidosTable.getModel();
            model.setColumnIdentifiers(columnsName);
            while (scan.hasNext()) {
                String ID = scan.next();
                String DESCRIPCION = scan.next();
                String VOTOS = scan.next();
                String[] DATA = {ID, DESCRIPCION, VOTOS};
                model.addRow(DATA);
                scan.nextLine();
            }

            SearchPartidos.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased( KeyEvent e ) {
                    super.keyReleased(e);
                    String search = SearchPartidos.getText().toLowerCase();
                    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model); //DefaultTableModel
                    PartidosTable.setRowSorter(tr);
                    tr.setRowFilter(regexFilter(search));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer la tabla Partidos");
        }
    }

    public void LeerProvincias() {
        String Provincias = System.getProperty("user.dir") + "\\src\\Archivos\\Provincia.txt";
        File Archivo = new File(Provincias);
        FileException(Archivo);
        try {
            String[] cabecera = {"Id de la provincia", "Nombre de la provincia"};
            String delimitador = "\\s*;\\s*";
            Scanner scan = new Scanner(Archivo);
            scan.useDelimiter(delimitador);
            DefaultTableModel model = (DefaultTableModel) ProvinciasTable.getModel();
            model.setColumnIdentifiers(cabecera);
            while (scan.hasNext()) {
                String ID = scan.next();
                String NOMBRE = scan.next();
                String[] DATA = {ID, NOMBRE};
                model.addRow(DATA);
                scan.nextLine();
            }

            SearchProvincias.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased( KeyEvent e ) {
                    super.keyReleased(e);
                    String search = SearchProvincias.getText().toLowerCase();
                    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model); //DefaultTableModel
                    ProvinciasTable.setRowSorter(tr);
                    tr.setRowFilter(regexFilter(search));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer la tabla Provincias");
        }
    }

    public void LeerMunicipios() {
        String Municipios = System.getProperty("user.dir") + "\\src\\Archivos\\Municipios.txt";
        File Archivo = new File(Municipios);
        FileException(Archivo);
        try {
            String[] cabecera = {"Id del municipio", "Descripción del municipio", "Id de la provincia"};
            String delimitador = "\\s*;\\s*";
            Scanner scan = new Scanner(Archivo);
            scan.useDelimiter(delimitador);
            DefaultTableModel model = (DefaultTableModel) MunicipiosTable.getModel();
            model.setColumnIdentifiers(cabecera);
            while (scan.hasNext()) {
                String ID = scan.next();
                String DESCRIPCION = scan.next();
                String PROVINCIA = scan.next();
                String[] DATA = {ID, DESCRIPCION, PROVINCIA};
                model.addRow(DATA);
                scan.nextLine();
            }

            SearchMunicipios.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased( KeyEvent e ) {
                    super.keyReleased(e);
                    String search = SearchMunicipios.getText().toLowerCase();
                    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model); //DefaultTableModel
                    MunicipiosTable.setRowSorter(tr);
                    tr.setRowFilter(regexFilter(search));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer la tabla Provincias");
        }
    }
}