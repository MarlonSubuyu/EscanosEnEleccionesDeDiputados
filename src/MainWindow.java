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
    public JPanel rootMW;
    public JButton Mantenimientos;
    public JButton Movimiento;
    public JButton Procesos;
    public JButton Consultas;
    public JPanel MantenimientosPaneB;
    public JPanel MovimientosPaneB;
    public JPanel ProcesosPaneB;
    public JPanel ConsultasPaneB;
    public JPanel DefaultPaneB;
    public JLabel ImageLabel;
    public JTextField LoginUsuario;
    public JButton GuardarUsuarios;
    public JLabel Usuariostxt;
    public JLabel Passwordtxt;
    public JPasswordField PasswordUsuario;
    public JTextField NombreUsuario;
    public JLabel NombreUsuariotxt;
    public JLabel ApellidosUsuariotxt;
    public JTextField ApellidosUsuarios;
    public JLabel EmailUsuariotxt;
    public JTextField EmailUsuario;
    public JRadioButton Si;
    public JRadioButton No;
    public JLabel NivelAccesotxt;
    public JLabel ErrorLoginUsuario;
    public JLabel ErrorPasswordUsuario;
    public JButton GuardarPartidos;
    public JTextField IdPartido;
    public JLabel IdPartidotxt;
    public JTextField DescripcionPartido;
    public JTextField VotosPartidos;
    public JLabel VotosPartidostxt;
    public JLabel DescripcionPartidotxt;
    public JTextField CrearModificar;
    public JButton GuardarProvincias;
    public JTextField IdProvincia;
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
    public JButton ExisteIdPartidoCandidato;
    public JTextField ExisteNombreRecinto;
    private JButton GuardarMovimientos;
    private JTextField IdColegio;
    private JTextField IdRecintodeColegios;
    private JTextField FechaElecciones;
    private JTextField StatusColegio;
    private JLabel IdRecintotxt;
    private JLabel IdColegiotxt;
    private JLabel FechaEleccionestxt;
    private JLabel StatusColegiotxt;
    private JTextField CrearModificarMovimiento;
    private JTextField NombreRecinto;
    private JTextField IdRecinto;
    private JTextField IdMunicipioRecinto;
    private JTextField DireccionRecinto;
    private JButton btnGuardarRecintos;
    private JTextField CrearModificarRecintos;
    private JButton btnGuardarCandidatos;
    private JTextField IdCandidato;
    private JTextField NombreCandidato;
    private JTextField IdPartidoCandidato;
    private JTextField IdCircunsc;
    private JTextField Totalvotos;
    private JTextField CrearModificarCandidatos;
    private JButton ExisteId_Circunsc;
    private JButton ExisteIdMunicipioRecinto;
    private JButton ExisteIdProvinciaCircunscripcion;
    private JButton ExisteIdMunicipioCircunscripcion;
    private JButton ExisteIdProvinciaMunicipio;
    private JTextField SearchCircunscripciones;
    private JTable CircunscripcionesTable;
    private JTextField SearchCandidatos;
    private JTable CandidatosTable;
    private JTextField SearchRecintos;
    private JTable RecintosTable;

    public MainWindow() {

        Jmenubar();

        Mantenimientos.setText("Mantenimientos");
        Movimiento.setText("Movimientos");
        Procesos.setText("Procesos");
        Consultas.setText("Consultas");
        GuardarUsuarios.setText("Guardar");
        ArrayList<String> ListaUsuarios = new ArrayList<>();

        //Movimientos
        boolean Status_Colegio = false;
        MovimientoColegios(Status_Colegio);

        MantenimientosUsuarios(ListaUsuarios);
        MantenimientosPartidos();
        MantenimientosProvincias();
        MantenimientosMunicipios();
        MantenimientosCircunscripciones();
        MantenimientosRecintos();
        MantenimientosCandidatos();

        CrearUsuariosPane();


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
            //Leer archivos
//            TODO resetear las tablas para actualizar los datos
//            TODO Joseph escribí aquí el nombre de la tabla que creaste y copias esto: .setModel(new DefaultTableModel((Object[][]) null, null));
            UsuariosTable.setModel(new DefaultTableModel((Object[][]) null, null));
            PartidosTable.setModel(new DefaultTableModel((Object[][]) null, null));
            ProvinciasTable.setModel(new DefaultTableModel((Object[][]) null, null));
            MunicipiosTable.setModel(new DefaultTableModel((Object[][]) null, null));
            CircunscripcionesTable.setModel(new DefaultTableModel((Object[][]) null, null));
            CandidatosTable.setModel(new DefaultTableModel((Object[][]) null, null));
            RecintosTable.setModel(new DefaultTableModel((Object[][]) null, null));
            LeerUsuarios();
            LeerPartidos();
            LeerProvincias();
            LeerMunicipios();
            LeerCircunscripciones();
            LeerCandidatos();
            LeerRecintos();
        });

//        Si esta seleccionado administrador
        Si.addActionListener(ea -> GuardarUsuarios.setEnabled(true));
//        No esta seleccionado administrador
        No.addActionListener(ee -> GuardarUsuarios.setEnabled(true));
    }

    public static void main( String[] args ) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }

    public void CrearUsuariosPane() {
//        TODO Crear el apartado para solo mostrar los usuarios
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

    public void MantenimientosMunicipios() {
        String Municipio = System.getProperty("user.dir") + "\\src\\Archivos\\Municipios.txt";
        File Archivo = new File(Municipio);
        String Provincia = System.getProperty("user.dir") + "\\src\\Archivos\\Provincia.txt";
        File LeerProvincia = new File(Provincia); //Leer archivo es para leer el Id_provincia que se usa para verificar si el dato introducido existe en el archivo
        String tempMunicipio = System.getProperty("user.dir") + "\\src\\Archivos\\tempPartido.txt";
        File tempArchivo = new File(tempMunicipio);
        String delimitador = "\\s*;\\s*";
        FileException(Archivo);

        IdMunicipiotxt.setText("Id del municipio *");
        NombreMunicipiotxt.setText("Descripción del municipio *");
        IdProvinciaMunicipiotxt.setText("Id de la provincia *");
        GuardarMunicipios.setText("Guardar");
        final boolean[] igual = {false};
        final boolean[] verificador = {false};
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

        IdProvinciaMunicipio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e ) {
                super.keyReleased(e);
                try {
                    Scanner scan = new Scanner(LeerProvincia);
                    scan.useDelimiter(delimitador);
                    ArrayList<String> Provincia = new ArrayList<>();
                    while (scan.hasNext()) {
                        String ID = scan.next();
                        scan.next();
                        Provincia.add(ID);
                        if (Provincia.contains(IdProvinciaMunicipio.getText())) {
                            verificador[0] = true;
                            ImageIcon exists = new ImageIcon(getClass().getResource("Icons/exists.png"));
                            ExisteIdProvinciaMunicipio.setText("El Id de la Provincia existe");
                            ExisteIdProvinciaMunicipio.setIcon(exists);
                        } else {
                            verificador[0] = false;
                            ImageIcon noexists = new ImageIcon(getClass().getResource("Icons/noexists.png"));
                            ExisteIdProvinciaMunicipio.setText("El ID de la Provincia no existe");
                            ExisteIdProvinciaMunicipio.setIcon(noexists);
                        }
                        scan.nextLine();
                    }
                    scan.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });

        GuardarMunicipios.addActionListener(e -> {
            String Id_MunicipioString = IdMunicipio.getText();
            String Nombre_Municipio = NombreMunicipio.getText();
            String Id_Provincia_MunicipioString = IdProvinciaMunicipio.getText();
            if (Id_MunicipioString.equals("") || Nombre_Municipio.equals("") || Id_Provincia_MunicipioString.equals("")) {
                ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos", null, JOptionPane.INFORMATION_MESSAGE, list);
            } else if (igual[0]) {
                if (verificador[0]) { //Si la provincia existe podemos pasar a registrar los datos
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
                if (verificador[0]) { //Si la provincia existe podemos pasar a registrar los datos
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

    public void MantenimientosCircunscripciones() {
        String Municipio = System.getProperty("user.dir") + "\\src\\Archivos\\Municipios.txt";
        File LeerArchivoMunicipio = new File(Municipio);
        String Circunscripciones = System.getProperty("user.dir") + "\\src\\Archivos\\Circunscripciones.txt";
        File Archivo = new File(Circunscripciones);
        String tempCircunscripciones = System.getProperty("user.dir") + "\\src\\Archivos\\tempCircunscripciones.txt";
        File tempArchivo = new File(tempCircunscripciones);
        String delimitador = "\\s*;\\s*";
        FileException(Archivo);

        final boolean[] igual = {false};
        final boolean[] verificadorMunicipio = {false};
        final boolean[] verificador = {false};
        ArrayList<String> ListaMunicipios = new ArrayList<>();
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

        IdProvinciaCircuns.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e ) {
                super.keyReleased(e);
                try {
                    Scanner scan = new Scanner(LeerArchivoMunicipio);
                    scan.useDelimiter(delimitador);
                    while (scan.hasNext()) {
                        String MUNICIPIO = scan.next();
                        scan.next();
                        String PROVINCIA = scan.next();
                        if (IdProvinciaCircuns.getText().equals(PROVINCIA)) {
                            verificador[0] = true;
                            ListaMunicipios.add(MUNICIPIO);
                            ImageIcon exists = new ImageIcon(getClass().getResource("Icons/exists.png"));
                            ExisteIdProvinciaCircunscripcion.setText("El Id de la Provincia existe");
                            ExisteIdProvinciaCircunscripcion.setIcon(exists);
                        } else {
                            ImageIcon noexists = new ImageIcon(getClass().getResource("Icons/noexists.png"));
                            ExisteIdProvinciaCircunscripcion.setText("El Id de la provincia no existe");
                            ExisteIdProvinciaCircunscripcion.setIcon(noexists);
                            ListaMunicipios.clear();
                        }
                        scan.nextLine();
                    }
                    scan.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });

        IdMunicipioCircuns.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e ) {
                super.keyReleased(e);
                try {
                    int[] Id_Municipio_CircunsArray = new int[ListaMunicipios.size()];
                    int i;
                    for (i = 0; i < ListaMunicipios.size(); i++) {
                        Id_Municipio_CircunsArray[i] = Integer.parseInt(ListaMunicipios.get(i));
                        if (Id_Municipio_CircunsArray[i] == Integer.parseInt(IdMunicipioCircuns.getText())) {
                            verificadorMunicipio[0] = true;
                            ImageIcon exists = new ImageIcon(getClass().getResource("Icons/exists.png"));
                            ExisteIdMunicipioCircunscripcion.setText("El Id del Municipio existe");
                            ExisteIdMunicipioCircunscripcion.setIcon(exists);
                            break;
                        } else {
                            verificadorMunicipio[0] = false;
                            ImageIcon noexists = new ImageIcon(getClass().getResource("Icons/noexists.png"));
                            ExisteIdMunicipioCircunscripcion.setText("El Id del Municipio no existe");
                            ExisteIdMunicipioCircunscripcion.setIcon(noexists);
                        }
                    }
                } catch (NumberFormatException n) {
                    n.getStackTrace();
                }
            }
        });

        btnAceptarCircunscripciones.addActionListener(e -> {
            String Id_CircunscripcionString = IdCircunscripcion.getText();
            String Nombre_Circunscripcion = NombreCircunscripcion.getText();
            String Id_Provincia_Circuns = IdProvinciaCircuns.getText();
            String Id_Municipio_Circuns = IdMunicipioCircuns.getText();
            String Cant_Candidatos = CantCandidatos.getText();

            if (Id_CircunscripcionString.equals("") || Nombre_Circunscripcion.equals("")) {
                ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos", null, JOptionPane.INFORMATION_MESSAGE, list);
            } else if (igual[0]) {
                if (verificador[0] && verificadorMunicipio[0]) { //Si la provincia existe podemos pasar a registrar los datos
                    String nCadena = (Id_CircunscripcionString + ";" + Nombre_Circunscripcion + ";" + Id_Provincia_Circuns + ";" + Id_Municipio_Circuns + ";" + Cant_Candidatos + ";"); //+ "\r\n" Se agrego en el siguiente metodo
                    ModificaDatos(nCadena, Id_CircunscripcionString, Archivo, tempArchivo);
                    ImageIcon edit = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                    JOptionPane.showMessageDialog(null, "Circunscripción modificada exitosamente", null, JOptionPane.INFORMATION_MESSAGE, edit);
                    IdCircunscripcion.setText(null);
                    NombreCircunscripcion.setText(null);
                    IdProvinciaCircuns.setText(null);
                    IdMunicipioCircuns.setText(null);
                    CantCandidatos.setText(null);
                } else {
                    ImageIcon advertencia = new ImageIcon(getClass().getResource("Icons/AdvertenciaVacio.png"));
                    if (!verificador[0] && !verificadorMunicipio[0]) {
                        JOptionPane.showMessageDialog(null, " ¡El ID de la provincia y el ID del municipio no existen!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    } else if (!verificadorMunicipio[0]) {
                        JOptionPane.showMessageDialog(null, "¡El ID del municipio no existe en la provincia!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡El ID de la provincia no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    }
                }
            } else {
                if (verificador[0] && verificadorMunicipio[0]) { //Si la provincia existe podemos pasar a registrar los datos
                    try {
                        int IdMunicipiosCircunscripcion = Integer.parseInt(Id_CircunscripcionString);
                        FileWriter Writer = new FileWriter(Archivo, true);
                        Writer.write(Id_CircunscripcionString + ";" + Nombre_Circunscripcion + ";" + Id_Provincia_Circuns + ";" + IdMunicipiosCircunscripcion + ";" + Cant_Candidatos + ";" + "\r\n");
                        ImageIcon create = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                        JOptionPane.showMessageDialog(null, "Circunscripción creada exitosamente", null, JOptionPane.INFORMATION_MESSAGE, create);
                        Writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (NumberFormatException n) {
                        ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                        JOptionPane.showMessageDialog(null, "Id del municipio debe ser un numero entero \nId de la provincia debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                    }
                    IdCircunscripcion.setText(null);
                    NombreCircunscripcion.setText(null);
                    IdProvinciaCircuns.setText(null);
                    IdMunicipioCircuns.setText(null);
                    CantCandidatos.setText(null);
                } else {
                    ImageIcon advertencia = new ImageIcon(getClass().getResource("Icons/AdvertenciaVacio.png"));
                    if (!verificador[0] && !verificadorMunicipio[0]) {
                        JOptionPane.showMessageDialog(null, " ¡El ID de la provincia y el ID del municipio no existen!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);


                    } else if (!verificadorMunicipio[0]) {
                        JOptionPane.showMessageDialog(null, "¡El ID del municipio no existe en la provincia!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡El ID de la provincia no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                    }
                }
            }
        });
    }

    private void MantenimientosRecintos() {

        String Municipio = System.getProperty("user.dir") + "\\src\\Archivos\\Municipios.txt";
        File LeerArchivoMunicipio = new File(Municipio);
        String Recintos = System.getProperty("user.dir") + "\\src\\Archivos\\Recintos.txt";
        File Archivo = new File(Recintos);
        String tempRecintos = System.getProperty("user.dir") + "\\src\\Archivos\\tempRecintos.txt";
        File tempArchivo = new File(tempRecintos);
        String delimitador = "\\s*;\\s*";
        FileException(Archivo);

        final boolean[] igual = {false};
        final boolean[] verificadorMunicipio = {false};
        String MODELO = "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "\r\n";
        getValor(delimitador, Archivo, MODELO);
        IdRecinto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e ) {
                super.keyReleased(e);
                if (getValor(delimitador, Archivo, MODELO).contains(IdRecinto.getText())) {
                    CrearModificarRecintos.setText("Modificando...");
                    igual[0] = true;
                } else {
                    CrearModificarRecintos.setText("Creando...");
                    igual[0] = false;
                }
            }
        });
        IdMunicipioRecinto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e ) {
                super.keyReleased(e);
                try {
                    Scanner scan = new Scanner(LeerArchivoMunicipio);
                    scan.useDelimiter(delimitador);
                    ArrayList<String> Municipio = new ArrayList<>();
                    while (scan.hasNext()) {
                        String PARTIDO = scan.next();
                        scan.next();
                        scan.next();
                        Municipio.add(PARTIDO);
                        if (Municipio.contains(IdMunicipioRecinto.getText())) {
                            verificadorMunicipio[0] = true;
                            ImageIcon exists = new ImageIcon(getClass().getResource("Icons/exists.png"));
                            ExisteIdMunicipioRecinto.setText("El Id del Municipio del Recinto existe");
                            ExisteIdMunicipioRecinto.setIcon(exists);
                        } else {
                            verificadorMunicipio[0] = false;
                            ImageIcon noexists = new ImageIcon(getClass().getResource("Icons/noexists.png"));
                            ExisteIdMunicipioRecinto.setText("El Id del Municipio del Recinto no existe");
                            ExisteIdMunicipioRecinto.setIcon(noexists);
                        }
                        scan.nextLine();
                    }
                    scan.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });

        btnGuardarRecintos.addActionListener(e -> {
            String Id_RecintoString = IdRecinto.getText();
            String Nombre_Recinto = NombreRecinto.getText();
            String IdMunicipio_Recinto = IdMunicipioRecinto.getText();
            String Direccion_Recinto = DireccionRecinto.getText();

            if (Id_RecintoString.equals("") || Nombre_Recinto.equals("") || IdMunicipio_Recinto.equals("") || Direccion_Recinto.equals("")) {
                ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos", null, JOptionPane.INFORMATION_MESSAGE, list);
            } else if (igual[0]) {
                if (verificadorMunicipio[0]) { //Si la provincia existe podemos pasar a registrar los datos
                    try {
                        int Id_Recinto = Integer.parseInt(Id_RecintoString);
                        String nCadena = (Id_Recinto + ";" + Nombre_Recinto + ";" + IdMunicipio_Recinto + ";" + Direccion_Recinto + ";"); //+ "\r\n" Se agrego en el siguiente metodo
                        ModificaDatos(nCadena, Id_RecintoString, Archivo, tempArchivo);
                        ImageIcon edit = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                        JOptionPane.showMessageDialog(null, "Recinto modificado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, edit);
                        IdRecinto.setText(null);
                        NombreRecinto.setText(null);
                        IdMunicipioRecinto.setText(null);
                        DireccionRecinto.setText(null);
                    } catch (NumberFormatException n) {
                        ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                        JOptionPane.showMessageDialog(null, "Id del recinto debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                    }
                } else {
                    ImageIcon advertencia = new ImageIcon(getClass().getResource("Icons/AdvertenciaVacio.png"));
                    JOptionPane.showMessageDialog(null, "¡El del municipio no existe en la provincia!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                }
            } else {
                if (verificadorMunicipio[0]) { //Si la provincia existe podemos pasar a registrar los datos
                    try {
                        int Id_Recinto = Integer.parseInt(Id_RecintoString);
                        FileWriter Writer = new FileWriter(Archivo, true);
                        Writer.write(Id_Recinto + ";" + Nombre_Recinto + ";" + IdMunicipio_Recinto + ";" + Direccion_Recinto + ";" + "\r\n");
                        ImageIcon create = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                        JOptionPane.showMessageDialog(null, "Recinto creado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, create);
                        Writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (NumberFormatException n) {
                        ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                        JOptionPane.showMessageDialog(null, "Id del recinto debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                    }
                    IdRecinto.setText(null);
                    NombreRecinto.setText(null);
                    IdMunicipioRecinto.setText(null);
                    DireccionRecinto.setText(null);
                } else {
                    ImageIcon advertencia = new ImageIcon(getClass().getResource("Icons/AdvertenciaVacio.png"));
                    JOptionPane.showMessageDialog(null, " ¡El ID del municipio no existe!", null, JOptionPane.INFORMATION_MESSAGE, advertencia);
                }
            }
        });
    }

    private void MantenimientosCandidatos() {

        String Partido = System.getProperty("user.dir") + "\\src\\Archivos\\Partido.txt";
        File LeerArchivoPartido = new File(Partido);
        String Circunscripciones = System.getProperty("user.dir") + "\\src\\Archivos\\Circunscripciones.txt";
        File LeerArchivoCircunscripciones = new File(Circunscripciones);
        String Candidatos = System.getProperty("user.dir") + "\\src\\Archivos\\Candidatos.txt";
        File Archivo = new File(Candidatos);
        String tempCandidatos = System.getProperty("user.dir") + "\\src\\Archivos\\tempCandidatos.txt";
        File tempArchivo = new File(tempCandidatos);
        String delimitador = "\\s*;\\s*";
        FileException(Archivo);

        final boolean[] igual = {false};
        final boolean[] verificadorPartido = {false};
        final boolean[] verificadorCircunscripcion = {false};
        String MODELO = "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "\r\n";
        getValor(delimitador, Archivo, MODELO);
        IdCandidato.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e ) {
                super.keyReleased(e);
                if (getValor(delimitador, Archivo, MODELO).contains(IdCandidato.getText())) {
                    CrearModificarCandidatos.setText("Modificando...");
                    igual[0] = true;
                } else {
                    CrearModificarCandidatos.setText("Creando...");
                    igual[0] = false;
                }
            }
        });
        IdPartidoCandidato.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e ) {
                super.keyReleased(e);
                try {
                    Scanner scan = new Scanner(LeerArchivoPartido);
                    scan.useDelimiter(delimitador);
                    ArrayList<String> Partido = new ArrayList<>();
                    while (scan.hasNext()) {
                        String PARTIDO = scan.next();
                        scan.next();
                        scan.next();
                        Partido.add(PARTIDO);
                        if (Partido.contains(IdPartidoCandidato.getText())) {
                            verificadorPartido[0] = true;
                            ImageIcon exists = new ImageIcon(getClass().getResource("Icons/exists.png"));
                            ExisteIdPartidoCandidato.setText("El Id Partido existe");
                            ExisteIdPartidoCandidato.setIcon(exists);
                        } else {
                            verificadorPartido[0] = false;
                            ImageIcon noexists = new ImageIcon(getClass().getResource("Icons/noexists.png"));
                            ExisteIdPartidoCandidato.setText("El Id Partido no existe");
                            ExisteIdPartidoCandidato.setIcon(noexists);
                        }
                        scan.nextLine();
                    }
                    scan.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        IdCircunsc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e ) {
                super.keyReleased(e);
                try {
                    Scanner scan = new Scanner(LeerArchivoCircunscripciones);
                    scan.useDelimiter(delimitador);
                    ArrayList<String> Circunscripcion = new ArrayList<>();
                    while (scan.hasNext()) {
                        String CIRCUNSCRIPCION = scan.next();
                        scan.next();
                        scan.next();
                        scan.next();
                        scan.next();
                        Circunscripcion.add(CIRCUNSCRIPCION);
                        if (Circunscripcion.contains(IdCircunsc.getText())) {
                            verificadorCircunscripcion[0] = true;
                            ImageIcon exists = new ImageIcon(getClass().getResource("Icons/exists.png"));
                            ExisteId_Circunsc.setText("El Id Circunscripción existe");
                            ExisteId_Circunsc.setIcon(exists);
                        } else {
                            verificadorCircunscripcion[0] = false;
                            ImageIcon noexists = new ImageIcon(getClass().getResource("Icons/noexists.png"));
                            ExisteId_Circunsc.setText("El Id Circunscripción no existe");
                            ExisteId_Circunsc.setIcon(noexists);
                        }
                        scan.nextLine();
                    }
                    scan.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        btnGuardarCandidatos.addActionListener(e -> {
            String IdCandidatoString = IdCandidato.getText();
            String Nombre_Candidato = NombreCandidato.getText();
            String IdPartido_Candidato = IdPartidoCandidato.getText();
            String Id_Circunsc = IdCircunsc.getText();
            String Total_VotosString = Totalvotos.getText();

            if (IdCandidatoString.equals("") || Nombre_Candidato.equals("") || IdPartido_Candidato.equals("") || Id_Circunsc.equals("")) {
                ImageIcon warning = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos", null, JOptionPane.INFORMATION_MESSAGE, warning);
            } else if (igual[0]) {
                if (verificadorPartido[0] && verificadorCircunscripcion[0]) {
                    try {
                        int IdcandidatoInt = Integer.parseInt(IdCandidatoString);
                        int Total_Votos = Integer.parseInt(Total_VotosString);
                        String nCadena = (IdcandidatoInt + ";" + Nombre_Candidato + ";" + IdPartido_Candidato + ";" + Id_Circunsc + ";" + Total_Votos + ";"); //+ "\r\n" Se agrego en el siguiente metodo
                        ModificaDatos(nCadena, IdCandidatoString, Archivo, tempArchivo);
                        ImageIcon edit = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                        JOptionPane.showMessageDialog(null, "Candidato modificado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, edit);
                        IdCandidato.setText(null);
                        NombreCandidato.setText(null);
                        IdPartidoCandidato.setText(null);
                        IdCircunsc.setText(null);
                        Totalvotos.setText(null);
                    } catch (NumberFormatException n) {
                        ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                        JOptionPane.showMessageDialog(null, "Id del candidato debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                    }
                } else {
                    ImageIcon warning = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                    if (!verificadorPartido[0]) {
                        JOptionPane.showMessageDialog(null, "El ID del partido debe existir", null, JOptionPane.INFORMATION_MESSAGE, warning);
                    } else if (!verificadorCircunscripcion[0]) {
                        JOptionPane.showMessageDialog(null, "El ID de la circunscripción debe existir", null, JOptionPane.INFORMATION_MESSAGE, warning);
                    } else {
                        JOptionPane.showMessageDialog(null, "El ID de la circunscripción y el ID del partido deben existir", null, JOptionPane.INFORMATION_MESSAGE, warning);
                    }
                }
            } else {
                if (verificadorPartido[0] && verificadorCircunscripcion[0]) {
                    try {
                        int IdcandidatoInt = Integer.parseInt(IdCandidatoString);
                        int Total_Votos = Integer.parseInt(Total_VotosString);
                        FileWriter Writer = new FileWriter(Archivo, true);
                        Writer.write(IdcandidatoInt + ";" + Nombre_Candidato + ";" + IdPartido_Candidato + ";" + Id_Circunsc + ";" + Total_Votos + ";" + "\r\n");
                        ImageIcon create = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                        JOptionPane.showMessageDialog(null, "Candidato creado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, create);
                        Writer.close();
                        IdCandidato.setText(null);
                        NombreCandidato.setText(null);
                        IdPartidoCandidato.setText(null);
                        IdCircunsc.setText(null);
                        Totalvotos.setText(null);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (NumberFormatException n) {
                        ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                        JOptionPane.showMessageDialog(null, "Id del candidato debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                    }


                } else {
                    ImageIcon warning = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                    if (!verificadorPartido[0]) {
                        JOptionPane.showMessageDialog(null, "El ID del partido debe existir", null, JOptionPane.INFORMATION_MESSAGE, warning);
                    } else if (!verificadorCircunscripcion[0]) {
                        JOptionPane.showMessageDialog(null, "El ID de la circunscripción debe existir", null, JOptionPane.INFORMATION_MESSAGE, warning);
                    } else {
                        JOptionPane.showMessageDialog(null, "El ID de la circunscripción y el ID del partido deben existir", null, JOptionPane.INFORMATION_MESSAGE, warning);
                    }
                }
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
//    todo hacer metodo hondt

    // TODO JTable Joseph, podes copiar cualquiera de los 4 metodos, todos hacen lo mismo

    public void LeerUsuarios() {
        String Usuarios = System.getProperty("user.dir") + "\\src\\Archivos\\Usuarios.txt";
        File Archivo = new File(Usuarios);
        FileException(Archivo);
        try {
            String[] cabecera = {"Usuario", "Password", "Nivel de acceso", "Nombre del usuario", "Apellidos del usuario", "Email del usuario"};
            String delimitador = "\\s*;\\s*";
            Scanner scan = new Scanner(Archivo);
            scan.useDelimiter(delimitador);
            DefaultTableModel model = (DefaultTableModel) UsuariosTable.getModel();
            model.setColumnIdentifiers(cabecera);
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
            String[] cabecera = {"Id del partido", "Descripción del partido", "Votos del partido"};
            String delimitador = "\\s*;\\s*";
            Scanner scan = new Scanner(Archivo);
            scan.useDelimiter(delimitador);
            DefaultTableModel model = (DefaultTableModel) PartidosTable.getModel();
            model.setColumnIdentifiers(cabecera);
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

    public void LeerCircunscripciones() {
        String Circunscripciones = System.getProperty("user.dir") + "\\src\\Archivos\\Circunscripciones.txt";
        File Archivo = new File(Circunscripciones);
        FileException(Archivo);
        try {
            String[] cabecera = {"Id de la circunscripcion", "Nombre de la circunscripcion", "Id de la provincia circunscripcion", "Id del municipio circunscripcion", "Cantidad de candidatos"};
            String delimitador = "\\s*;\\s*";
            Scanner scan = new Scanner(Archivo);
            scan.useDelimiter(delimitador);
            DefaultTableModel model = (DefaultTableModel) CircunscripcionesTable.getModel();
            model.setColumnIdentifiers(cabecera);
            while (scan.hasNext()) {
                String ID = scan.next();
                String NOMBRE = scan.next();
                String PROVINCIA = scan.next();
                String MUNICIPIO = scan.next();
                String CANTIDAD = scan.next();
                String[] DATA = {ID, NOMBRE, PROVINCIA, MUNICIPIO, CANTIDAD};
                model.addRow(DATA);
                scan.nextLine();
            }

            SearchCircunscripciones.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased( KeyEvent e ) {
                    super.keyReleased(e);
                    String search = SearchCircunscripciones.getText().toLowerCase();
                    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model); //DefaultTableModel
                    CircunscripcionesTable.setRowSorter(tr);
                    tr.setRowFilter(regexFilter(search));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer la tabla Circunscripciones");
        }
    }

    public void LeerCandidatos() {
        String Candidatos = System.getProperty("user.dir") + "\\src\\Archivos\\Candidatos.txt";
        File Archivo = new File(Candidatos);
        FileException(Archivo);
        try {
            String[] cabecera = {"Id del Candidato", "Nombre del Candidato", "Id del partido Candidato", "Id de la circunscripcion", "Total de votos"};
            String delimitador = "\\s*;\\s*";
            Scanner scan = new Scanner(Archivo);
            scan.useDelimiter(delimitador);
            DefaultTableModel model = (DefaultTableModel) CandidatosTable.getModel();
            model.setColumnIdentifiers(cabecera);
            while (scan.hasNext()) {
                String ID = scan.next();
                String NOMBRE = scan.next();
                String PARTIDO = scan.next();
                String CRICUNSCRIPCION = scan.next();
                String VOTOS = scan.next();
                String[] DATA = {ID, NOMBRE, PARTIDO, CRICUNSCRIPCION, VOTOS};
                model.addRow(DATA);
                scan.nextLine();
            }

            SearchCandidatos.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased( KeyEvent e ) {
                    super.keyReleased(e);
                    String search = SearchCandidatos.getText().toLowerCase();
                    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model); //DefaultTableModel
                    CandidatosTable.setRowSorter(tr);
                    tr.setRowFilter(regexFilter(search));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer la tabla Candidatos");
        }
    }

    public void LeerRecintos(){
        String Recintos = System.getProperty("user.dir") + "\\src\\Archivos\\Recintos.txt";
        File Archivo = new File(Recintos);
        FileException(Archivo);
        try {
            String[] cabecera = {"Id del Recinto", "Nombre del Recinto", "Id del municipio Recinto", "Dirreccion del Recinto"};
            String delimitador = "\\s*;\\s*";
            Scanner scan = new Scanner(Archivo);
            scan.useDelimiter(delimitador);
            DefaultTableModel model = (DefaultTableModel) RecintosTable.getModel();
            model.setColumnIdentifiers(cabecera);
            while (scan.hasNext()) {
                String ID = scan.next();
                String NOMBRE = scan.next();
                String MUNICIPIO = scan.next();
                String DIRECCION = scan.next();
                String[] DATA = {ID, NOMBRE, MUNICIPIO, DIRECCION};
                model.addRow(DATA);
                scan.nextLine();
            }

            SearchRecintos.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased( KeyEvent e ) {
                    super.keyReleased(e);
                    String search = SearchRecintos.getText().toLowerCase();
                    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model); //DefaultTableModel
                    RecintosTable.setRowSorter(tr);
                    tr.setRowFilter(regexFilter(search));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer la tabla Recintos");
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
            System.out.println("Error al leer la tabla Municipios");
        }
    }

    //TODO MOVIMIENTO DE COLEGIO

    public void MovimientoColegios( boolean Status_Colegio ) {
        String Recinto = System.getProperty("user.dir") + "\\src\\Archivos\\Recintos.txt";
        File LeerArchivoRecinto = new File(Recinto);
        String Colegio = System.getProperty("user.dir") + "\\src\\Archivos\\Colegio.txt";
        File Archivo = new File(Colegio);
        String tempColegio = System.getProperty("user.dir") + "\\src\\Archivos\\tempColegio.txt";
        File tempArchivo = new File(tempColegio);
        String delimitador = "\\s*;\\s*";
        FileException(Archivo);
        IdRecintotxt.setText("Id del Colegio *");
        IdColegiotxt.setText("Id del Recinto *");
        FechaEleccionestxt.setText("Fecha de elecciones *");
        StatusColegiotxt.setText("Status del Colegio");
        GuardarMovimientos.setText("Guardar");


        final boolean[] igual = {false};
        String MODELO = "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "\r\n";
        getValor(delimitador, Archivo, MODELO);
        IdColegio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased( KeyEvent e ) {
                super.keyReleased(e);
                if (getValor(delimitador, Archivo, MODELO).contains(IdColegio.getText())) {
                    CrearModificarMovimiento.setText("Modificando...");
                    igual[0] = true;
                    StatusColegio.setText(String.valueOf(Status_Colegio));
                } else {
                    CrearModificarMovimiento.setText("Creando...");
                    igual[0] = false;
                }
            }
        });
//        if(Archivo.exists()){
//            StatusColegio.setText(String.valueOf(Status_Colegio));
//        } else{
//            System.out.println("El archivo" + Archivo.getName() + "no existe");
//            Movimiento.setEnabled(false);
//        }
        GuardarMovimientos.addActionListener(e -> {
            String Id_Colegio = IdColegio.getText();
            String Id_RecintoString = IdRecintodeColegios.getText();
            //TODO la fecha elecciones debe ser un Calendar porque Date esta deprecado
            String Fecha_Elecciones = FechaElecciones.getText();
            Calendar Calendar = new GregorianCalendar();
            FechaElecciones.setText(String.valueOf(Calendar));
            String NOMBRE;
//            Fecha_Ele.setTime(Fecha_Elecciones);

            if (Id_Colegio.equals("") || Id_RecintoString.equals("") || Fecha_Elecciones.equals("")) {
                ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                JOptionPane.showMessageDialog(null, "Todos los campos marcados con asterisco * deben estar llenos", null, JOptionPane.INFORMATION_MESSAGE, list);
            } else if (igual[0]) {
                try {
//                    ArrayList<String> ListaMunicipios = new ArrayList<>();
                    Scanner scan = new Scanner(LeerArchivoRecinto);
                    scan.useDelimiter(delimitador);

                    while (scan.hasNext()) {
                        String RECINTO = scan.next();
                        NOMBRE = scan.next();
                        scan.next();
                        scan.next();
                        if (Id_RecintoString.equals(RECINTO)) {
                            ExisteNombreRecinto.setText(NOMBRE);
//                            ListaMunicipios.add(MUNICIPIO);
                        } else {
                            ExisteNombreRecinto.setText("Recinto no existe");
                        }
                        scan.nextLine();
                    }
                    scan.close();
//                    Id_Municipio_CircunsArray = new int[ListaMunicipios.size()];
//                    for (int i = 0; i < ListaMunicipios.size(); i++) {
//                        Id_Municipio_CircunsArray[i] = Integer.parseInt(ListaMunicipios.get(i));
//                        if (Id_Municipio_CircunsArray[i] == IdMunicipiosCircunscripcion) {
//                            verificadorMunicipio = true;
//                        }
//                    }
                    int Id_Recinto = Integer.parseInt(Id_RecintoString);
                    String nCadena = (Id_Colegio + ";" + Id_Recinto + ";" + Fecha_Elecciones + ";" + Status_Colegio + ";"); //+ "\r\n" Se agrego en el siguiente metodo
                    ModificaDatos(nCadena, Id_Colegio, Archivo, tempArchivo);
                    ImageIcon edit = new ImageIcon(getClass().getResource("Icons/Edit.png"));
                    JOptionPane.showMessageDialog(null, "Movimiento modificado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, edit);
                } catch (NumberFormatException n) {
                    ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                    JOptionPane.showMessageDialog(null, "Id del recinto debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                IdPartido.setText(null);
                DescripcionPartido.setText(null);
                VotosPartidos.setText(null);
            } else {
                try {
                    Scanner scan = new Scanner(LeerArchivoRecinto);
                    scan.useDelimiter(delimitador);

                    while (scan.hasNext()) {
                        String RECINTO = scan.next();
                        NOMBRE = scan.next();
                        scan.next();
                        scan.next();
                        if (Id_RecintoString.equals(RECINTO)) {
                            ExisteNombreRecinto.setText(NOMBRE);
//                            ListaMunicipios.add(MUNICIPIO);
                        } else {
                            ExisteNombreRecinto.setText("Recinto no existe");
                        }
                        scan.nextLine();
                    }
                    scan.close();
                    int Id_Recinto = Integer.parseInt(Id_RecintoString);
                    FileWriter Writer = new FileWriter(Colegio, true);
                    Writer.write(Id_Colegio + ";" + Id_Recinto + ";" + Fecha_Elecciones + ";" + Status_Colegio + ";" + "\r\n");
                    ImageIcon create = new ImageIcon(getClass().getResource("Icons/create.png"));
                    JOptionPane.showMessageDialog(null, "Movimiento creado exitosamente", null, JOptionPane.INFORMATION_MESSAGE, create);
                    Writer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (NumberFormatException n) {
                    ImageIcon list = new ImageIcon(getClass().getResource("Icons/warninglist.png"));
                    JOptionPane.showMessageDialog(null, "Id del recinto debe ser un numero entero", null, JOptionPane.INFORMATION_MESSAGE, list);
                }
                IdPartido.setText(null);
                DescripcionPartido.setText(null);
                VotosPartidos.setText(null);
            }
        });

    }
}