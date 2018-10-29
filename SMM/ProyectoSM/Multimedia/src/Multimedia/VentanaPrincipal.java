package Multimedia;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import sm.JVG.imagen.ExponerRGB;
import sm.JVG.imagen.Filtro;
import sm.JVG.imagen.Rotacion;
import sm.JVG.imagen.SepiaOp;
import sm.JVG.imagen.UmbralizacionOp;
import sm.image.BlendOp;
import sm.image.LookupTableProducer;
import sm.image.SubtractionOp;
        
/**
 * Clase que hereda de JFrame interfaz del programa Multimedia,
 * encargada de mandar los mensajes
 * adecuados a las ventanas internas que posea.
 * @author Jorge Valenzuela Garcia
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Constructor de la clase VentanaPrincipañ
     */
    public VentanaPrincipal() {
        initComponents();
        this.setSize(1000, 700);                // 1000,700 sera al tamaño inicial    
        punto.setSelected(true);                // Iniciamos con el punto seleccionado
        this.grosor.setValue(1.0f);             // Hacemos que el spinner empiece en 1
        this.transparenciaDeslizador.setEnabled(false);        
    }
    //Creamos el atributo color para poder mandarselo a la clase lienzo
    /**
     * Color inicial al iniciar la ventana
     */
    Color color = Color.BLACK;
    /**
     * Color de degradado de la VentanaPrincipal
     */
    Color color_degradado = Color.WHITE;
    /**
     * Margen acumulativo para que cada vez que
     * abramos una nueva ventana interna, se
     * coloque al lado de la anterior
     */
    int margen = 0;
    /**
     * Imagen para contener la original frente
     * a la realizacion de efectos sobre imagenes
     */
    BufferedImage imagenOrg;
    /**
     * Imagen para contener la original frente
     * a la realizacion de efectos sobre imagenes
     */
    BufferedImage imagenOrg2;
    /**
     * Vector de offsets para aplicar a las imagenes
     * con alpha activo
     */
    float[] vOffsets = new float[4];
    /**
     * Vector de los ScaleFactors para el brillo
     */
    float[] vScaleFactors = {1.0F, 1.0F, 1.0F, 1.0F};
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotonosHerramientas = new javax.swing.ButtonGroup();
        grupoColoresPrincipales = new javax.swing.ButtonGroup();
        grupoColoresDegradados = new javax.swing.ButtonGroup();
        estadoLabel = new javax.swing.JLabel();
        Panel1 = new javax.swing.JPanel();
        barraDibujo = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonAbrir = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        punto = new javax.swing.JToggleButton();
        linea = new javax.swing.JToggleButton();
        rectangulo = new javax.swing.JToggleButton();
        elipse = new javax.swing.JToggleButton();
        curva = new javax.swing.JToggleButton();
        poligono = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        botonEditar = new javax.swing.JToggleButton();
        botonAlisar = new javax.swing.JToggleButton();
        botonTransparencia = new javax.swing.JToggleButton();
        transparenciaDeslizador = new javax.swing.JSlider();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        LabelCoorPrincipal = new javax.swing.JLabel();
        colorNegro = new javax.swing.JToggleButton();
        colorBlanco = new javax.swing.JToggleButton();
        colorRojo = new javax.swing.JToggleButton();
        colorAzul = new javax.swing.JToggleButton();
        colorAmarillo = new javax.swing.JToggleButton();
        colorVerde = new javax.swing.JToggleButton();
        colorMagenta = new javax.swing.JToggleButton();
        colorCyan = new javax.swing.JToggleButton();
        botonRelleno = new javax.swing.JToggleButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        degradado = new javax.swing.JCheckBox();
        colorDegradadoNegro = new javax.swing.JToggleButton();
        colorDegradadoBlanco = new javax.swing.JToggleButton();
        colorDegradadoRojo = new javax.swing.JToggleButton();
        colorDegradadoAzul = new javax.swing.JToggleButton();
        colorDegradadoAmarillo = new javax.swing.JToggleButton();
        colorDegradadoVerde = new javax.swing.JToggleButton();
        colorDegradadoMagenta = new javax.swing.JToggleButton();
        colorDegradadoCyan = new javax.swing.JToggleButton();
        degradado_vertical = new javax.swing.JCheckBox();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        LabelGrosor = new javax.swing.JLabel();
        grosor = new javax.swing.JSpinner();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        botonInterlineado = new javax.swing.JCheckBox();
        barraAudioVideo = new javax.swing.JToolBar();
        botonAudioGrabar = new javax.swing.JButton();
        botonCapturar = new javax.swing.JButton();
        Panel2 = new javax.swing.JPanel();
        barraImagen = new javax.swing.JToolBar();
        Brillo = new javax.swing.JLabel();
        botonBrillo = new javax.swing.JSlider();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        Filtro = new javax.swing.JLabel();
        botonFiltro = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        botonContrasteNormal = new javax.swing.JButton();
        botonContrasteIluminar = new javax.swing.JButton();
        botonContrasteOscurecer = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        botonSepia = new javax.swing.JButton();
        botonExponerRGB = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        rotacion = new javax.swing.JLabel();
        botonRotacion = new javax.swing.JSlider();
        botonRot90 = new javax.swing.JButton();
        botonRot180 = new javax.swing.JButton();
        botonRot270 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        Escala = new javax.swing.JLabel();
        botonEscalaAumentar = new javax.swing.JButton();
        botonEscalaDisminuir = new javax.swing.JButton();
        barraImagen2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        botonSuma = new javax.swing.JButton();
        botonResta = new javax.swing.JButton();
        botonBinario = new javax.swing.JSlider();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        umbralizacion = new javax.swing.JLabel();
        botonUmbralizacion = new javax.swing.JSlider();
        escritorio = new javax.swing.JDesktopPane();
        menuPrincipal = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        abrir = new javax.swing.JMenuItem();
        guardar = new javax.swing.JMenuItem();
        verMenu = new javax.swing.JMenu();
        verBarraEstado = new javax.swing.JCheckBoxMenuItem();
        verBarraDibujo = new javax.swing.JCheckBoxMenuItem();
        verBarraImagen = new javax.swing.JCheckBoxMenuItem();
        verBarraAudioVideo = new javax.swing.JCheckBoxMenuItem();
        imagenMenu = new javax.swing.JMenu();
        botonDuplicar = new javax.swing.JMenuItem();
        grabarAudioMenu = new javax.swing.JMenu();
        grabarAudio = new javax.swing.JMenuItem();
        ayudaMenu = new javax.swing.JMenu();
        acercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        estadoLabel.setText("Barra de estado");
        estadoLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        estadoLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                estadoLabelMouseMoved(evt);
            }
        });
        getContentPane().add(estadoLabel, java.awt.BorderLayout.SOUTH);

        Panel1.setLayout(new java.awt.BorderLayout());

        barraDibujo.setRollover(true);
        barraDibujo.setToolTipText("");

        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/nuevo.png"))); // NOI18N
        botonNuevo.setToolTipText("Nuevo");
        botonNuevo.setFocusable(false);
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });
        barraDibujo.add(botonNuevo);

        botonAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/abrir.png"))); // NOI18N
        botonAbrir.setToolTipText("Abrir");
        botonAbrir.setFocusable(false);
        botonAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirActionPerformed(evt);
            }
        });
        barraDibujo.add(botonAbrir);

        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/guardar.png"))); // NOI18N
        botonGuardar.setToolTipText("Guardar");
        botonGuardar.setFocusable(false);
        botonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        barraDibujo.add(botonGuardar);
        barraDibujo.add(jSeparator1);

        grupoBotonosHerramientas.add(punto);
        punto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/punto.png"))); // NOI18N
        punto.setToolTipText("Punto");
        punto.setActionCommand("Punto");
        punto.setFocusable(false);
        punto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        punto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        punto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntoActionPerformed(evt);
            }
        });
        barraDibujo.add(punto);

        grupoBotonosHerramientas.add(linea);
        linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/linea.png"))); // NOI18N
        linea.setToolTipText("Linea");
        linea.setActionCommand("Linea");
        linea.setFocusable(false);
        linea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        linea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        linea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineaActionPerformed(evt);
            }
        });
        barraDibujo.add(linea);

        grupoBotonosHerramientas.add(rectangulo);
        rectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/rectangulo.png"))); // NOI18N
        rectangulo.setToolTipText("Cuadrado");
        rectangulo.setActionCommand("Rectangulo");
        rectangulo.setFocusable(false);
        rectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectanguloActionPerformed(evt);
            }
        });
        barraDibujo.add(rectangulo);

        grupoBotonosHerramientas.add(elipse);
        elipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/elipse.png"))); // NOI18N
        elipse.setToolTipText("Elipse");
        elipse.setActionCommand("Elipse");
        elipse.setFocusable(false);
        elipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        elipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        elipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elipseActionPerformed(evt);
            }
        });
        barraDibujo.add(elipse);

        grupoBotonosHerramientas.add(curva);
        curva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/linea-curva.png"))); // NOI18N
        curva.setToolTipText("Curva");
        curva.setFocusable(false);
        curva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        curva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        curva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curvaActionPerformed(evt);
            }
        });
        barraDibujo.add(curva);

        grupoBotonosHerramientas.add(poligono);
        poligono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/poligono.png"))); // NOI18N
        poligono.setToolTipText("Poligono");
        poligono.setFocusable(false);
        poligono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        poligono.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        poligono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poligonoActionPerformed(evt);
            }
        });
        barraDibujo.add(poligono);
        barraDibujo.add(jSeparator2);

        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/seleccion.png"))); // NOI18N
        botonEditar.setToolTipText("Editar/Mover");
        botonEditar.setFocusable(false);
        botonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });
        barraDibujo.add(botonEditar);

        botonAlisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/alisar.png"))); // NOI18N
        botonAlisar.setToolTipText("Alisar");
        botonAlisar.setFocusable(false);
        botonAlisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAlisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonAlisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlisarActionPerformed(evt);
            }
        });
        barraDibujo.add(botonAlisar);

        botonTransparencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/transparencia.png"))); // NOI18N
        botonTransparencia.setToolTipText("Transparencia");
        botonTransparencia.setFocusable(false);
        botonTransparencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonTransparencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonTransparencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTransparenciaActionPerformed(evt);
            }
        });
        barraDibujo.add(botonTransparencia);

        transparenciaDeslizador.setMaximum(10);
        transparenciaDeslizador.setToolTipText("Valor Transparencia");
        transparenciaDeslizador.setValue(0);
        transparenciaDeslizador.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                transparenciaDeslizadorStateChanged(evt);
            }
        });
        barraDibujo.add(transparenciaDeslizador);
        barraDibujo.add(jSeparator3);

        LabelCoorPrincipal.setText("Color");
        barraDibujo.add(LabelCoorPrincipal);

        colorNegro.setBackground(new java.awt.Color(0, 0, 0));
        grupoColoresPrincipales.add(colorNegro);
        colorNegro.setToolTipText("Negro");
        colorNegro.setFocusable(false);
        colorNegro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorNegro.setMaximumSize(new java.awt.Dimension(20, 20));
        colorNegro.setMinimumSize(new java.awt.Dimension(20, 20));
        colorNegro.setOpaque(true);
        colorNegro.setPreferredSize(new java.awt.Dimension(20, 20));
        colorNegro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorNegroActionPerformed(evt);
            }
        });
        barraDibujo.add(colorNegro);

        colorBlanco.setBackground(new java.awt.Color(255, 255, 255));
        grupoColoresPrincipales.add(colorBlanco);
        colorBlanco.setToolTipText("Blanco");
        colorBlanco.setFocusable(false);
        colorBlanco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorBlanco.setMaximumSize(new java.awt.Dimension(20, 20));
        colorBlanco.setMinimumSize(new java.awt.Dimension(20, 20));
        colorBlanco.setOpaque(true);
        colorBlanco.setPreferredSize(new java.awt.Dimension(20, 20));
        colorBlanco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorBlancoActionPerformed(evt);
            }
        });
        barraDibujo.add(colorBlanco);

        colorRojo.setBackground(new java.awt.Color(255, 0, 0));
        grupoColoresPrincipales.add(colorRojo);
        colorRojo.setToolTipText("Rojo");
        colorRojo.setFocusable(false);
        colorRojo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorRojo.setMaximumSize(new java.awt.Dimension(20, 20));
        colorRojo.setMinimumSize(new java.awt.Dimension(20, 20));
        colorRojo.setOpaque(true);
        colorRojo.setPreferredSize(new java.awt.Dimension(20, 20));
        colorRojo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorRojoActionPerformed(evt);
            }
        });
        barraDibujo.add(colorRojo);

        colorAzul.setBackground(new java.awt.Color(0, 0, 255));
        grupoColoresPrincipales.add(colorAzul);
        colorAzul.setToolTipText("Azul");
        colorAzul.setFocusable(false);
        colorAzul.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorAzul.setMaximumSize(new java.awt.Dimension(20, 20));
        colorAzul.setMinimumSize(new java.awt.Dimension(20, 20));
        colorAzul.setOpaque(true);
        colorAzul.setPreferredSize(new java.awt.Dimension(20, 20));
        colorAzul.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorAzulActionPerformed(evt);
            }
        });
        barraDibujo.add(colorAzul);

        colorAmarillo.setBackground(new java.awt.Color(255, 255, 0));
        grupoColoresPrincipales.add(colorAmarillo);
        colorAmarillo.setToolTipText("Amarillo");
        colorAmarillo.setFocusable(false);
        colorAmarillo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorAmarillo.setMaximumSize(new java.awt.Dimension(20, 20));
        colorAmarillo.setMinimumSize(new java.awt.Dimension(20, 20));
        colorAmarillo.setOpaque(true);
        colorAmarillo.setPreferredSize(new java.awt.Dimension(20, 20));
        colorAmarillo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorAmarilloActionPerformed(evt);
            }
        });
        barraDibujo.add(colorAmarillo);

        colorVerde.setBackground(new java.awt.Color(0, 255, 0));
        grupoColoresPrincipales.add(colorVerde);
        colorVerde.setToolTipText("Verde");
        colorVerde.setFocusable(false);
        colorVerde.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorVerde.setMaximumSize(new java.awt.Dimension(20, 20));
        colorVerde.setMinimumSize(new java.awt.Dimension(20, 20));
        colorVerde.setOpaque(true);
        colorVerde.setPreferredSize(new java.awt.Dimension(20, 20));
        colorVerde.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorVerdeActionPerformed(evt);
            }
        });
        barraDibujo.add(colorVerde);

        colorMagenta.setBackground(new java.awt.Color(255, 0, 255));
        grupoColoresPrincipales.add(colorMagenta);
        colorMagenta.setToolTipText("Magenta");
        colorMagenta.setFocusable(false);
        colorMagenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorMagenta.setMaximumSize(new java.awt.Dimension(20, 20));
        colorMagenta.setMinimumSize(new java.awt.Dimension(20, 20));
        colorMagenta.setOpaque(true);
        colorMagenta.setPreferredSize(new java.awt.Dimension(20, 20));
        colorMagenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorMagenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorMagentaActionPerformed(evt);
            }
        });
        barraDibujo.add(colorMagenta);

        colorCyan.setBackground(new java.awt.Color(0, 255, 255));
        grupoColoresPrincipales.add(colorCyan);
        colorCyan.setToolTipText("Cyan");
        colorCyan.setFocusable(false);
        colorCyan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorCyan.setMaximumSize(new java.awt.Dimension(20, 20));
        colorCyan.setMinimumSize(new java.awt.Dimension(20, 20));
        colorCyan.setOpaque(true);
        colorCyan.setPreferredSize(new java.awt.Dimension(20, 20));
        colorCyan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorCyan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorCyanActionPerformed(evt);
            }
        });
        barraDibujo.add(colorCyan);

        botonRelleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/rellenar.png"))); // NOI18N
        botonRelleno.setToolTipText("Rellenar");
        botonRelleno.setFocusable(false);
        botonRelleno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRelleno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonRelleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRellenoActionPerformed(evt);
            }
        });
        barraDibujo.add(botonRelleno);
        barraDibujo.add(jSeparator12);

        degradado.setText("Degradado");
        degradado.setToolTipText("Activar/Desactivar Degradado");
        degradado.setFocusable(false);
        degradado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        degradado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        degradado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degradadoActionPerformed(evt);
            }
        });
        barraDibujo.add(degradado);

        colorDegradadoNegro.setBackground(new java.awt.Color(0, 0, 0));
        grupoColoresDegradados.add(colorDegradadoNegro);
        colorDegradadoNegro.setToolTipText("Degradar a Negro");
        colorDegradadoNegro.setFocusable(false);
        colorDegradadoNegro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorDegradadoNegro.setMaximumSize(new java.awt.Dimension(20, 20));
        colorDegradadoNegro.setMinimumSize(new java.awt.Dimension(20, 20));
        colorDegradadoNegro.setOpaque(true);
        colorDegradadoNegro.setPreferredSize(new java.awt.Dimension(20, 20));
        colorDegradadoNegro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorDegradadoNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorDegradadoNegroActionPerformed(evt);
            }
        });
        barraDibujo.add(colorDegradadoNegro);

        colorDegradadoBlanco.setBackground(new java.awt.Color(255, 255, 255));
        grupoColoresDegradados.add(colorDegradadoBlanco);
        colorDegradadoBlanco.setToolTipText("Degradar a Blanco");
        colorDegradadoBlanco.setFocusable(false);
        colorDegradadoBlanco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorDegradadoBlanco.setMaximumSize(new java.awt.Dimension(20, 20));
        colorDegradadoBlanco.setMinimumSize(new java.awt.Dimension(20, 20));
        colorDegradadoBlanco.setOpaque(true);
        colorDegradadoBlanco.setPreferredSize(new java.awt.Dimension(20, 20));
        colorDegradadoBlanco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorDegradadoBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorDegradadoBlancoActionPerformed(evt);
            }
        });
        barraDibujo.add(colorDegradadoBlanco);

        colorDegradadoRojo.setBackground(new java.awt.Color(255, 0, 0));
        grupoColoresDegradados.add(colorDegradadoRojo);
        colorDegradadoRojo.setToolTipText("Degradar a Rojo");
        colorDegradadoRojo.setFocusable(false);
        colorDegradadoRojo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorDegradadoRojo.setMaximumSize(new java.awt.Dimension(20, 20));
        colorDegradadoRojo.setMinimumSize(new java.awt.Dimension(20, 20));
        colorDegradadoRojo.setOpaque(true);
        colorDegradadoRojo.setPreferredSize(new java.awt.Dimension(20, 20));
        colorDegradadoRojo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorDegradadoRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorDegradadoRojoActionPerformed(evt);
            }
        });
        barraDibujo.add(colorDegradadoRojo);

        colorDegradadoAzul.setBackground(new java.awt.Color(0, 0, 255));
        grupoColoresDegradados.add(colorDegradadoAzul);
        colorDegradadoAzul.setToolTipText("Degradar a Azul");
        colorDegradadoAzul.setFocusable(false);
        colorDegradadoAzul.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorDegradadoAzul.setMaximumSize(new java.awt.Dimension(20, 20));
        colorDegradadoAzul.setMinimumSize(new java.awt.Dimension(20, 20));
        colorDegradadoAzul.setOpaque(true);
        colorDegradadoAzul.setPreferredSize(new java.awt.Dimension(20, 20));
        colorDegradadoAzul.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorDegradadoAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorDegradadoAzulActionPerformed(evt);
            }
        });
        barraDibujo.add(colorDegradadoAzul);

        colorDegradadoAmarillo.setBackground(new java.awt.Color(255, 255, 0));
        grupoColoresDegradados.add(colorDegradadoAmarillo);
        colorDegradadoAmarillo.setToolTipText("Degradar a Amarillo");
        colorDegradadoAmarillo.setFocusable(false);
        colorDegradadoAmarillo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorDegradadoAmarillo.setMaximumSize(new java.awt.Dimension(20, 20));
        colorDegradadoAmarillo.setMinimumSize(new java.awt.Dimension(20, 20));
        colorDegradadoAmarillo.setOpaque(true);
        colorDegradadoAmarillo.setPreferredSize(new java.awt.Dimension(20, 20));
        colorDegradadoAmarillo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorDegradadoAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorDegradadoAmarilloActionPerformed(evt);
            }
        });
        barraDibujo.add(colorDegradadoAmarillo);

        colorDegradadoVerde.setBackground(new java.awt.Color(0, 255, 0));
        grupoColoresDegradados.add(colorDegradadoVerde);
        colorDegradadoVerde.setToolTipText("Degradar a Verde");
        colorDegradadoVerde.setFocusable(false);
        colorDegradadoVerde.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorDegradadoVerde.setMaximumSize(new java.awt.Dimension(20, 20));
        colorDegradadoVerde.setMinimumSize(new java.awt.Dimension(20, 20));
        colorDegradadoVerde.setOpaque(true);
        colorDegradadoVerde.setPreferredSize(new java.awt.Dimension(20, 20));
        colorDegradadoVerde.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorDegradadoVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorDegradadoVerdeActionPerformed(evt);
            }
        });
        barraDibujo.add(colorDegradadoVerde);

        colorDegradadoMagenta.setBackground(new java.awt.Color(255, 0, 255));
        grupoColoresDegradados.add(colorDegradadoMagenta);
        colorDegradadoMagenta.setToolTipText("Degradar a Magenta");
        colorDegradadoMagenta.setFocusable(false);
        colorDegradadoMagenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorDegradadoMagenta.setMaximumSize(new java.awt.Dimension(20, 20));
        colorDegradadoMagenta.setMinimumSize(new java.awt.Dimension(20, 20));
        colorDegradadoMagenta.setOpaque(true);
        colorDegradadoMagenta.setPreferredSize(new java.awt.Dimension(20, 20));
        colorDegradadoMagenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorDegradadoMagenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorDegradadoMagentaActionPerformed(evt);
            }
        });
        barraDibujo.add(colorDegradadoMagenta);

        colorDegradadoCyan.setBackground(new java.awt.Color(0, 255, 255));
        grupoColoresDegradados.add(colorDegradadoCyan);
        colorDegradadoCyan.setToolTipText("Degradar a Cyan");
        colorDegradadoCyan.setFocusable(false);
        colorDegradadoCyan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorDegradadoCyan.setMaximumSize(new java.awt.Dimension(20, 20));
        colorDegradadoCyan.setMinimumSize(new java.awt.Dimension(20, 20));
        colorDegradadoCyan.setOpaque(true);
        colorDegradadoCyan.setPreferredSize(new java.awt.Dimension(20, 20));
        colorDegradadoCyan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorDegradadoCyan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorDegradadoCyanActionPerformed(evt);
            }
        });
        barraDibujo.add(colorDegradadoCyan);

        degradado_vertical.setText("Degradado Vertical");
        degradado_vertical.setToolTipText("Activar/Desactivar Degradado Vertical");
        degradado_vertical.setFocusable(false);
        degradado_vertical.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        degradado_vertical.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        degradado_vertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degradado_verticalActionPerformed(evt);
            }
        });
        barraDibujo.add(degradado_vertical);
        barraDibujo.add(jSeparator11);

        LabelGrosor.setText("Grosor");
        barraDibujo.add(LabelGrosor);

        grosor.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), Float.valueOf(1.0f)));
        grosor.setToolTipText("Grosor");
        grosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                grosorStateChanged(evt);
            }
        });
        barraDibujo.add(grosor);
        barraDibujo.add(jSeparator13);

        botonInterlineado.setText("Interlineado");
        botonInterlineado.setToolTipText("Activar/Desactivar Interlineado");
        botonInterlineado.setFocusable(false);
        botonInterlineado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonInterlineado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonInterlineado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInterlineadoActionPerformed(evt);
            }
        });
        barraDibujo.add(botonInterlineado);

        Panel1.add(barraDibujo, java.awt.BorderLayout.NORTH);

        barraAudioVideo.setRollover(true);

        botonAudioGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/record24x24.png"))); // NOI18N
        botonAudioGrabar.setToolTipText("Grabar Audio");
        botonAudioGrabar.setFocusable(false);
        botonAudioGrabar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAudioGrabar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonAudioGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAudioGrabarActionPerformed(evt);
            }
        });
        barraAudioVideo.add(botonAudioGrabar);

        botonCapturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/apps-screenshot-metro-icon.png"))); // NOI18N
        botonCapturar.setToolTipText("Realizar una captura");
        botonCapturar.setFocusable(false);
        botonCapturar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCapturar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCapturarActionPerformed(evt);
            }
        });
        barraAudioVideo.add(botonCapturar);

        Panel1.add(barraAudioVideo, java.awt.BorderLayout.SOUTH);

        Panel2.setLayout(new java.awt.BorderLayout());

        barraImagen.setRollover(true);

        Brillo.setText("Brillo");
        barraImagen.add(Brillo);

        botonBrillo.setMaximum(200);
        botonBrillo.setMinimum(-200);
        botonBrillo.setToolTipText("Nivel Brillo");
        botonBrillo.setValue(0);
        botonBrillo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                botonBrilloStateChanged(evt);
            }
        });
        botonBrillo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                botonBrilloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                botonBrilloFocusLost(evt);
            }
        });
        barraImagen.add(botonBrillo);
        barraImagen.add(jSeparator5);

        Filtro.setText("Filtro");
        barraImagen.add(Filtro);

        botonFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emborronamiento Medio", "Emborronamiento Binomial", "Enfoque", "Relieve", "Detector de fronteras Laplaciano", "Filtro Gaussiano", "Negativo", "Blanco y Negro" }));
        botonFiltro.setToolTipText("Filtros");
        botonFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFiltroActionPerformed(evt);
            }
        });
        barraImagen.add(botonFiltro);
        barraImagen.add(jSeparator4);

        botonContrasteNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/contraste.png"))); // NOI18N
        botonContrasteNormal.setToolTipText("Contraste Normal");
        botonContrasteNormal.setFocusable(false);
        botonContrasteNormal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonContrasteNormal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonContrasteNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasteNormalActionPerformed(evt);
            }
        });
        barraImagen.add(botonContrasteNormal);

        botonContrasteIluminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/iluminar.png"))); // NOI18N
        botonContrasteIluminar.setToolTipText("Iluminar");
        botonContrasteIluminar.setFocusable(false);
        botonContrasteIluminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonContrasteIluminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonContrasteIluminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasteIluminarActionPerformed(evt);
            }
        });
        barraImagen.add(botonContrasteIluminar);

        botonContrasteOscurecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/oscurecer.png"))); // NOI18N
        botonContrasteOscurecer.setToolTipText("Oscurecer");
        botonContrasteOscurecer.setFocusable(false);
        botonContrasteOscurecer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonContrasteOscurecer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonContrasteOscurecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContrasteOscurecerActionPerformed(evt);
            }
        });
        barraImagen.add(botonContrasteOscurecer);
        barraImagen.add(jSeparator6);

        botonSepia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/sepia.png"))); // NOI18N
        botonSepia.setToolTipText("Sepia");
        botonSepia.setFocusable(false);
        botonSepia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSepia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonSepia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSepiaActionPerformed(evt);
            }
        });
        barraImagen.add(botonSepia);

        botonExponerRGB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/rojo-verde-azul-tres-circulos-rgb-simbolo.png"))); // NOI18N
        botonExponerRGB.setToolTipText("Exponer RGB predominante de la imagen");
        botonExponerRGB.setFocusable(false);
        botonExponerRGB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonExponerRGB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonExponerRGB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExponerRGBActionPerformed(evt);
            }
        });
        barraImagen.add(botonExponerRGB);
        barraImagen.add(jSeparator7);

        rotacion.setText("Rotacion");
        barraImagen.add(rotacion);

        botonRotacion.setMaximum(360);
        botonRotacion.setToolTipText("Nivel Rotacion");
        botonRotacion.setValue(0);
        botonRotacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                botonRotacionStateChanged(evt);
            }
        });
        botonRotacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                botonRotacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                botonRotacionFocusLost(evt);
            }
        });
        barraImagen.add(botonRotacion);

        botonRot90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/rotacion90.png"))); // NOI18N
        botonRot90.setToolTipText("Girar 90º");
        botonRot90.setFocusable(false);
        botonRot90.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRot90.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonRot90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRot90ActionPerformed(evt);
            }
        });
        barraImagen.add(botonRot90);

        botonRot180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/rotacion180.png"))); // NOI18N
        botonRot180.setToolTipText("Girar 180º");
        botonRot180.setFocusable(false);
        botonRot180.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRot180.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonRot180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRot180ActionPerformed(evt);
            }
        });
        barraImagen.add(botonRot180);

        botonRot270.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/rotacion270.png"))); // NOI18N
        botonRot270.setToolTipText("Girar 270º");
        botonRot270.setFocusable(false);
        botonRot270.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonRot270.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonRot270.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRot270ActionPerformed(evt);
            }
        });
        barraImagen.add(botonRot270);
        barraImagen.add(jSeparator8);

        Escala.setText("Escala");
        barraImagen.add(Escala);

        botonEscalaAumentar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/aumentar.png"))); // NOI18N
        botonEscalaAumentar.setToolTipText("Aumentar");
        botonEscalaAumentar.setFocusable(false);
        botonEscalaAumentar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEscalaAumentar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEscalaAumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEscalaAumentarActionPerformed(evt);
            }
        });
        barraImagen.add(botonEscalaAumentar);

        botonEscalaDisminuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/disminuir.png"))); // NOI18N
        botonEscalaDisminuir.setToolTipText("Disminuir");
        botonEscalaDisminuir.setFocusable(false);
        botonEscalaDisminuir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEscalaDisminuir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEscalaDisminuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEscalaDisminuirActionPerformed(evt);
            }
        });
        barraImagen.add(botonEscalaDisminuir);

        Panel2.add(barraImagen, java.awt.BorderLayout.NORTH);

        barraImagen2.setRollover(true);

        jLabel1.setText("Binarias");
        barraImagen2.add(jLabel1);

        botonSuma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/suma.png"))); // NOI18N
        botonSuma.setToolTipText("Suma");
        botonSuma.setFocusable(false);
        botonSuma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonSuma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSumaActionPerformed(evt);
            }
        });
        barraImagen2.add(botonSuma);

        botonResta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/iconos/resta.png"))); // NOI18N
        botonResta.setToolTipText("Resta");
        botonResta.setFocusable(false);
        botonResta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonResta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestaActionPerformed(evt);
            }
        });
        barraImagen2.add(botonResta);

        botonBinario.setMaximum(10);
        botonBinario.setToolTipText("Mezcla de Imagenes");
        botonBinario.setValue(0);
        botonBinario.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                botonBinarioStateChanged(evt);
            }
        });
        botonBinario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                botonBinarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                botonBinarioFocusLost(evt);
            }
        });
        barraImagen2.add(botonBinario);
        barraImagen2.add(jSeparator10);

        umbralizacion.setText("Umbralizacion");
        barraImagen2.add(umbralizacion);

        botonUmbralizacion.setMaximum(255);
        botonUmbralizacion.setToolTipText("Umbralizacion");
        botonUmbralizacion.setValue(0);
        botonUmbralizacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                botonUmbralizacionStateChanged(evt);
            }
        });
        botonUmbralizacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                botonUmbralizacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                botonUmbralizacionFocusLost(evt);
            }
        });
        barraImagen2.add(botonUmbralizacion);

        Panel2.add(barraImagen2, java.awt.BorderLayout.SOUTH);

        escritorio.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                escritorioMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1335, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Panel2.add(escritorio, java.awt.BorderLayout.CENTER);

        Panel1.add(Panel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(Panel1, java.awt.BorderLayout.CENTER);

        archivoMenu.setText("Archivo");

        nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        archivoMenu.add(nuevo);

        abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        archivoMenu.add(abrir);

        guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        archivoMenu.add(guardar);

        menuPrincipal.add(archivoMenu);

        verMenu.setText("Ver");

        verBarraEstado.setSelected(true);
        verBarraEstado.setText("Ver Barra de Estado");
        verBarraEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBarraEstadoActionPerformed(evt);
            }
        });
        verMenu.add(verBarraEstado);

        verBarraDibujo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        verBarraDibujo.setSelected(true);
        verBarraDibujo.setText("Ver Barra de Dibujo");
        verBarraDibujo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBarraDibujoActionPerformed(evt);
            }
        });
        verMenu.add(verBarraDibujo);

        verBarraImagen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        verBarraImagen.setSelected(true);
        verBarraImagen.setText("Ver Barra de Imagen");
        verBarraImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBarraImagenActionPerformed(evt);
            }
        });
        verMenu.add(verBarraImagen);

        verBarraAudioVideo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        verBarraAudioVideo.setSelected(true);
        verBarraAudioVideo.setText("Ver Barra Audio/Video");
        verBarraAudioVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBarraAudioVideoActionPerformed(evt);
            }
        });
        verMenu.add(verBarraAudioVideo);

        menuPrincipal.add(verMenu);

        imagenMenu.setText("Imagen");

        botonDuplicar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        botonDuplicar.setText("Duplicar");
        botonDuplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDuplicarActionPerformed(evt);
            }
        });
        imagenMenu.add(botonDuplicar);

        menuPrincipal.add(imagenMenu);

        grabarAudioMenu.setText("Audio");

        grabarAudio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        grabarAudio.setText("Grabar Audio");
        grabarAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarAudioActionPerformed(evt);
            }
        });
        grabarAudioMenu.add(grabarAudio);

        menuPrincipal.add(grabarAudioMenu);

        ayudaMenu.setText("Ayuda");

        acercaDe.setText("Acerca de");
        acercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaDeActionPerformed(evt);
            }
        });
        ayudaMenu.add(acercaDe);

        menuPrincipal.add(ayudaMenu);

        setJMenuBar(menuPrincipal);
        menuPrincipal.getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Asignamos al lienzo de la ventana activa la forma del punto
     * @param evt 
     */
    private void puntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntoActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            vi.getLienzo().setBoton(vi.getLienzo().formaPunto);
        }
    }//GEN-LAST:event_puntoActionPerformed

    /**
     * Asignamos al lienzo de la ventana activa la forma de la linea
     * @param evt 
     */
    private void lineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineaActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            vi.getLienzo().setBoton(vi.getLienzo().formaLinea);
        }
    }//GEN-LAST:event_lineaActionPerformed

    /**
     * Asignamos al lienzo de la ventana activa la forma del rectangulo
     * @param evt 
     */
    private void rectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectanguloActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            vi.getLienzo().setBoton(vi.getLienzo().formaRectangulo);
        }
    }//GEN-LAST:event_rectanguloActionPerformed

    /**
     * Asignamos al lienzo de la ventana activa la forma de la elipse
     * @param evt 
     */
    private void elipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elipseActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            estadoLabel.setText("Elipse");
            vi.getLienzo().setBoton(vi.getLienzo().formaElipse);
        }
    }//GEN-LAST:event_elipseActionPerformed

    /**
     * Asignamos al lienzo de la ventana activa el grosor con el que deseamos pintar
     * @param evt 
     */
    private void grosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_grosorStateChanged
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            Float valor = (Float)this.grosor.getValue();
            vi.getLienzo().setStroke(valor);
            vi.getLienzo().repaint();
        }
        
    }//GEN-LAST:event_grosorStateChanged

    /**
     * Ejecuta el codigo de nuevoActionPerformed(evt)
     * @param evt 
     */
    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        this.nuevoActionPerformed(evt);
    }//GEN-LAST:event_botonNuevoActionPerformed

    /**
     * Ejecuta el codigo de abrirActionPerformed(evt)
     * @param evt 
     */
    private void botonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirActionPerformed
        this.abrirActionPerformed(evt);
    }//GEN-LAST:event_botonAbrirActionPerformed

    /**
     * Ejectura el codigo de guardarActionPerformed(evt)
     * @param evt 
     */
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        this.guardarActionPerformed(evt);
    }//GEN-LAST:event_botonGuardarActionPerformed

    /**
     * Asignamos al lienzo de la ventana activa que queremos activar la edicion
     * @param evt 
     */
    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            vi.getLienzo().activarEditar(botonEditar.isSelected());
        }
    }//GEN-LAST:event_botonEditarActionPerformed

    /**
     * Asignamos al lienzo de la ventana activa si queremos alisar o no
     */
    private void botonAlisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlisarActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            vi.getLienzo().activarAntialiasing(botonAlisar.isSelected());
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_botonAlisarActionPerformed

    /**
     * Asignamos al lienzo de la ventana activa si queremos transparencia o no
     */
    private void botonTransparenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTransparenciaActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            if (botonTransparencia.isSelected()){
                vi.getLienzo().setTransparencia((float)transparenciaDeslizador.getValue()/10);
                transparenciaDeslizador.setEnabled(true);
            }
            else{
                vi.getLienzo().setTransparencia(1f);
                transparenciaDeslizador.setEnabled(false);
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_botonTransparenciaActionPerformed

    /**
     * Asignamos al lienzo de la ventana activa si queremos rellenar las figuras o no
     */
    private void botonRellenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRellenoActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            vi.getLienzo().activarRelleno(botonRelleno.isSelected());
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_botonRellenoActionPerformed

        /**
         * A raiz del filtro seleccionado aplica el efecto correspondiente
         * a la imagen que tenga el lienzo de la VentanaInterna activa
         * @param evt 
         */
    private void botonFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFiltroActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            BufferedImage imgOriginal = vi.getLienzo().getImage();
            if(imgOriginal != null){
                switch (botonFiltro.getSelectedIndex()){ // getSelectedIndex retorna el indice del elemento seleccionado
                    case 0:
                        try{
                            Filtro filtro = new Filtro(imgOriginal);
                            BufferedImage imgOut = filtro.emborronamiento_Medio();
                            vi.getLienzo().setImage(imgOut);
                            vi.getLienzo().repaint();
                        }
                        catch(IllegalArgumentException e){
                            System.err.println(e.getLocalizedMessage());
                        }
                        break;
                        
                    case 1:
                        try{
                            Filtro filtro = new Filtro(imgOriginal);
                            BufferedImage imgOut = filtro.emborronamiento_Binomial();
                            vi.getLienzo().setImage(imgOut);
                            vi.getLienzo().repaint();
                        }
                        catch(IllegalArgumentException e){
                            System.err.println(e.getLocalizedMessage());
                        }
                        break;
                    
                    case 2:
                        try{
                            Filtro filtro = new Filtro(imgOriginal);
                            BufferedImage imgOut = filtro.enfoque();
                            vi.getLienzo().setImage(imgOut);
                            vi.getLienzo().repaint();
                        }
                        catch(IllegalArgumentException e){
                            System.err.println(e.getLocalizedMessage());
                        }
                        break;    
                        
                    case 3:
                        try{
                            Filtro filtro = new Filtro(imgOriginal);
                            BufferedImage imgOut = filtro.relieve();
                            vi.getLienzo().setImage(imgOut);
                            vi.getLienzo().repaint();
                        }
                        catch(IllegalArgumentException e){
                            System.err.println(e.getLocalizedMessage());
                        }
                        break;
                        
                    case 4:
                        try{
                            Filtro filtro = new Filtro(imgOriginal);
                            BufferedImage imgOut = filtro.laplaciano();
                            vi.getLienzo().setImage(imgOut);
                            vi.getLienzo().repaint();
                        }
                        catch(IllegalArgumentException e){
                            System.err.println(e.getLocalizedMessage());
                        }
                        break;
                        
                    case 5:
                        try{
                            Filtro filtro = new Filtro(imgOriginal);
                            BufferedImage imgOut = filtro.gaussiano();
                            vi.getLienzo().setImage(imgOut);
                            vi.getLienzo().repaint();
                        }
                        catch(IllegalArgumentException e){
                            System.err.println(e.getLocalizedMessage());
                        }
                        break;
                    
                    case 6:
                        try{
                            Filtro filtro = new Filtro(imgOriginal);
                            BufferedImage imgOut = filtro.negativo();
                            vi.getLienzo().setImage(imgOut);
                            vi.getLienzo().repaint();
                        }
                        catch(Exception e){
                            System.err.println("Error");
                        }
                        break;
                    
                    case 7:
                        try{
                            Filtro filtro = new Filtro(imgOriginal);
                            BufferedImage imgOut = filtro.blanco_Y_Negro();
                            vi.getLienzo().setImage(imgOut);
                            vi.getLienzo().repaint();
                        }
                        catch(Exception e){
                            System.err.println("Error");
                        }
                        break;    
                        
                    default:
                        break;
                }
            }
        }
    }//GEN-LAST:event_botonFiltroActionPerformed

    /**
     * Cambia el brillo de la imagen del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonBrilloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_botonBrilloStateChanged
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            int valor = this.botonBrillo.getValue();
            BufferedImage imgSource = imagenOrg; // Usamos siempre la imagen original para que no se vaya reusando la temporal
            if(imgSource!=null){
                try{
                    if (imgSource.getColorModel().hasAlpha()){
                        vOffsets[0] = valor;
                        vOffsets[1] = valor;
                        vOffsets[2] = valor;
                        vOffsets[3] = 0;    // Para el canal Alpha
                        RescaleOp rop = new RescaleOp(vScaleFactors, vOffsets, null);
                        BufferedImage imgdest = rop.filter(imgSource, null);
                        vi.getLienzo().setImage(imgdest);
                        vi.getLienzo().repaint();
                    }
                    else{
                        RescaleOp rop = new RescaleOp(1.0F, valor, null);
                        BufferedImage imgdest = rop.filter(imgSource, null);
                        vi.getLienzo().setImage(imgdest);
                        vi.getLienzo().repaint();
                    }
                }
                catch(IllegalArgumentException e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_botonBrilloStateChanged

    /**
     * Cuando el brillo gana el foco guardamos la imagen original del lienzo en la VentanaPrincipal
     * @param evt 
     */
    private void botonBrilloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonBrilloFocusGained
        // Cuando el deslizador del brillo gana el foco le asignamos a la imagen original la imagen actual del lienzo
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            imagenOrg = vi.getLienzo().getImage();
        }
    }//GEN-LAST:event_botonBrilloFocusGained

    /**
     * Cuando el brillo pierde el foco la imagen de la VentanaPrincipal pasa a ser nula
     * @param evt 
     */
    private void botonBrilloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonBrilloFocusLost
        // Cuando el deslizador pierde el foco le asignamos null a la imagen original que tiene la ventana
        imagenOrg = null;
        this.botonBrillo.setValue(0);
        repaint();
        
    }//GEN-LAST:event_botonBrilloFocusLost

    /**
     * Aplica mas contraste a la imagen del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonContrasteNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContrasteNormalActionPerformed
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImage();
            if(imgSource!=null){
                try{
                    double m = 128;
                    double e = 4.0;
                    double Max = (1.0/(1.0+Math.pow(m/255.0,e)));
                    double K = 255.0/Max;
                    byte lt[] = new byte[256];
                    lt[0]=0;
                    for (int l=1; l<256; l++){
                        lt[l] = (byte)(K*(1.0/(1.0+Math.pow(m/(float)l,e))));
                    }
                    ByteLookupTable slt = new ByteLookupTable(0,lt);
                    LookupOp lop = new LookupOp(slt, null);
                    BufferedImage imgdest = imgSource;  // Imagen origen y destino iguales
                    lop.filter( imgSource,imgdest );
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }
                catch(Exception e){
                    System.err.println("Error");
                }
            }
        }    
    }//GEN-LAST:event_botonContrasteNormalActionPerformed

    /**
     * Aplica mas iluminacion a la imagen del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonContrasteIluminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContrasteIluminarActionPerformed
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImage();
            if(imgSource!=null){
                try{
                    int type = LookupTableProducer.TYPE_LOGARITHM;
                    LookupTable lt = LookupTableProducer.createLookupTable(type);
                    LookupOp lop = new LookupOp(lt, null);
                    // Imagen origen y destino iguales
                    lop.filter( imgSource , imgSource);
                    vi.repaint();
                }
                catch(Exception e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_botonContrasteIluminarActionPerformed

    /**
     * Oscurece la imagen del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonContrasteOscurecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContrasteOscurecerActionPerformed
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null){
            BufferedImage imgSource = vi.getLienzo().getImage();
            if(imgSource!=null){
                try{
                    int type = LookupTableProducer.TYPE_POWER;
                    LookupTable lt = LookupTableProducer.createLookupTable(type);
                    LookupOp lop = new LookupOp(lt, null);
                    // Imagen origen y destino iguales
                    lop.filter( imgSource , imgSource);
                    vi.repaint();
                }
                catch(Exception e){
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_botonContrasteOscurecerActionPerformed

    /**
     * Rotamos 90º la imagen del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonRot90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRot90ActionPerformed
    VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImage();
            if(imgSource!=null){
                try{
                    Rotacion rotacion90 = new Rotacion(imgSource);
                    BufferedImage imgdest = rotacion90.rotar(90);
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }
                catch(Exception e){
                    System.err.println("Error");
                }
            }
        }
    }//GEN-LAST:event_botonRot90ActionPerformed

    /**
     * Rotamos 180º la imagen del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonRot180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRot180ActionPerformed
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImage();
            if(imgSource!=null){
                try{
                    Rotacion rotacion180 = new Rotacion(imgSource);
                    BufferedImage imgdest = rotacion180.rotar(180);
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }
                catch(Exception e){
                    System.err.println("Error");
                }
            }
        }
    }//GEN-LAST:event_botonRot180ActionPerformed

    /**
     * Rotamos 270º la imagen del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonRot270ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRot270ActionPerformed
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImage();
            if(imgSource!=null){
                try{
                    Rotacion rotacion270 = new Rotacion(imgSource);
                    BufferedImage imgdest = rotacion270.rotar(270);
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }
                catch(Exception e){
                    System.err.println("Error");
                }
            }
        }
    }//GEN-LAST:event_botonRot270ActionPerformed

    /**
     * Rotamos la imagen del lienzo de la VentanaInterna activa tantos grados como
     * se indique en el componente
     * @param evt 
     */
    private void botonRotacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_botonRotacionStateChanged
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null){
            BufferedImage imgSource = imagenOrg;
            int valor = botonRotacion.getValue();
            if(imgSource!=null){
                try{
                    Rotacion rotacion_total = new Rotacion(imgSource);
                    BufferedImage imgdest = rotacion_total.rotar(valor);
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }
                catch(Exception e){
                    System.err.println("Error");
                }
            }
        }
    }//GEN-LAST:event_botonRotacionStateChanged

    /**
     * Aumentamos de tamaño la imagen del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonEscalaAumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEscalaAumentarActionPerformed
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImage();
            int valor = botonRotacion.getValue();
            if(imgSource!=null){
                try{
                    AffineTransform at = AffineTransform.getScaleInstance(1.25,1.25);   // Aumentamos 1.25 de ancho y 1.25 de alto
                    AffineTransformOp atop;
                    atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
                    BufferedImage imgdest = null;
                    imgdest = atop.filter(imgSource, imgdest);
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }
                catch(Exception e){
                    System.err.println("Error");
                }
            }
        }
    }//GEN-LAST:event_botonEscalaAumentarActionPerformed

    /**
     * Disminuimos el tamaño de la imagen del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonEscalaDisminuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEscalaDisminuirActionPerformed
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null) {
            BufferedImage imgSource = vi.getLienzo().getImage();
            int valor = botonRotacion.getValue();
            if(imgSource!=null){
                try{
                    AffineTransform at = AffineTransform.getScaleInstance(0.75,0.75);   // Aumentamos 1.25 de ancho y 1.25 de alto
                    AffineTransformOp atop;
                    atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
                    BufferedImage imgdest = null;
                    imgdest = atop.filter(imgSource, imgdest);
                    vi.getLienzo().setImage(imgdest);
                    vi.getLienzo().repaint();
                }
                catch(Exception e){
                    System.err.println("Error");
                }
            }
        }
    }//GEN-LAST:event_botonEscalaDisminuirActionPerformed

    /**
     * Cuando el boton de rotacion gana el foco, la imagen de la VentanaPrincipal recibe la imagen
     * del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonRotacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonRotacionFocusGained
        // Cuando el boton de rotacion gana el foco asignamos a la imagen de la ventana activa la imagen actual del lienzo
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            imagenOrg = vi.getLienzo().getImage();
        }
    }//GEN-LAST:event_botonRotacionFocusGained

    /**
     * Cuando el boton de la rotacion pierde el foco le asignamos null
     * a la imagen de la VentanaPrincipal
     * @param evt 
     */
    private void botonRotacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonRotacionFocusLost
        // Cuando pierde el foco el boton del brillo le asignamos a la imagen de la ventana null
        imagenOrg = null;
        repaint();
    }//GEN-LAST:event_botonRotacionFocusLost

    /**
     * 
     * @param evt 
     */
    private void escritorioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escritorioMouseMoved
        /*VentanaInterna vi = (VentanaInterna) escritorio.getSelectedFrame();
        if (vi != null && vi instanceof VentanaInterna)
            estadoLabel.setText(vi.getValorPixel_RGB());*/
    }//GEN-LAST:event_escritorioMouseMoved

    /**
     * Se aplica el efecto Sepia a la imagen del lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void botonSepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSepiaActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            try{
                BufferedImage imgOrigen = vi.getLienzo().getImage();
                BufferedImage imgDest = null;   // La inicializamos a null para en el metodo filter de la clase
                                                // SepiaOp hacerla compatible con imgOrigen
                SepiaOp filtroSepia = new SepiaOp();    // Creamos el filtro Sepia
                imgDest = filtroSepia.filter(imgOrigen, imgDest); // Aplicamos el filtro Sepia a las imagenes
                vi.getLienzo().setImage(imgDest);
                vi.getLienzo().repaint();
            }
            catch(Exception e){
                System.err.println("Error al usar filtro sepia");
            }
        }
    }//GEN-LAST:event_botonSepiaActionPerformed

    /**
     * Se sumaran las imagenes de los lienzos de la VentanaInterna activa y la
     * VentanaInterna anteriormente activa. La nueva imagen se mostrara en
     * una nueva VentanaInterna
     * @param evt 
     */
    private void botonSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSumaActionPerformed
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null) {
            VentanaInterna viNext = (VentanaInterna) escritorio.selectFrame(false); // Ventana anterior
            if (viNext != null) {
                BufferedImage imgRight = vi.getLienzo().getImage();
                BufferedImage imgLeft = viNext.getLienzo().getImage();
                if (imgRight != null && imgLeft != null) {
                    try {
                        BlendOp op = new BlendOp(imgLeft);
                        BufferedImage imgdest = op.filter(imgRight, null);
                        vi = new VentanaInterna();
                        vi.getLienzo().setImage(imgdest);
                        vi.setLocation(margen%300, margen%300);     // Cada vez que iniciamos una nueva ventana la creamos
                        margen = margen + 20;                       // al lado de la anterior para que no se superpongan
                        this.escritorio.add(vi);
                        vi.setVisible(true);
                    }
                    catch (IllegalArgumentException e){
                        System.err.println("Error: "+e.getLocalizedMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_botonSumaActionPerformed

    /**
     * Se restaran las imagenes de los lienzos de la VentanaInterna activa y la
     * VentanaInterna anteriormente activa. La nueva imagen se mostrara en
     * una nueva VentanaInterna
     * @param evt 
     */
    private void botonRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaActionPerformed
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null) {
            VentanaInterna viNext = (VentanaInterna) escritorio.selectFrame(false); // Ventana anterior
            if (viNext != null) {
                BufferedImage imgRight = vi.getLienzo().getImage();
                BufferedImage imgLeft = viNext.getLienzo().getImage();
                if (imgRight != null && imgLeft != null){
                    try {
                        SubtractionOp op = new SubtractionOp(imgLeft);
                        BufferedImage imgdest = op.filter(imgRight, null);
                        vi = new VentanaInterna();          // Se crea una nueva ventana con el resultado
                        vi.getLienzo().setImage(imgdest);
                        vi.setLocation(margen%300, margen%300);     // Cada vez que iniciamos una nueva ventana la creamos
                        margen = margen + 20;                       // al lado de la anterior para que no se superpongan
                        this.escritorio.add(vi);
                        vi.setVisible(true);
                    }
                    catch (IllegalArgumentException e){
                        System.err.println("Error: "+e.getLocalizedMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_botonRestaActionPerformed

    /**
     * Se mezclaran las imagenes de los lienzos de la VentanaInterna activa y la
     * VentanaInterna anteriormente activa en el nivel que indique el componente.
     * La nueva imagen se mostrara en una nueva VentanaInterna.
     * @param evt 
     */
    private void botonBinarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_botonBinarioStateChanged
            if (imagenOrg != null && imagenOrg2 != null){
                try{
                    BlendOp op = new BlendOp(imagenOrg2,(float) botonBinario.getValue()/10);      // El constructor de la clase permite pasar directamente el alpha sin
                                                                                              // tener que llamar a setAlpha
                    BufferedImage imgdest = op.filter(imagenOrg, null);
                    VentanaInterna viMezcla = (VentanaInterna) escritorio.getSelectedFrame();
                    viMezcla.getLienzo().setImage(imgdest);
                    viMezcla.getLienzo().repaint();
                    }
                    catch (IllegalArgumentException e){
                        System.err.println("Error: "+e.getLocalizedMessage());
                    }
                }       
    }//GEN-LAST:event_botonBinarioStateChanged

    /**
     * Cuando el botonBinario gana el foco las dos imagenes que posee la VentanaPrincipal
     * recibiran las imagenes del lienzo de la VentanaInterna activa y la VentanaInterna anteriormente
     * activa respectivamente
     * @param evt 
     */
    private void botonBinarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonBinarioFocusGained
        // Cuando el deslizador de binario gane el foco saldra la nueva ventana con la imagen mezclada
        // Ademas las imagenes de Frame recibiran las de estas ventanas
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null){
            VentanaInterna viNext = (VentanaInterna) escritorio.selectFrame(false); // Ventana anterior
            if (viNext != null){
                try{
                    imagenOrg = vi.getLienzo().getImage();        // Cogemos la imagen original de la ventana
                    imagenOrg2 = viNext.getLienzo().getImage();    // Cogemos la imagen original de la ventana anterior
                // Ahora es importante poner el lanzamiento de la nueva imagen ya que asi si no tenemos dos imagenes previas
                // no se lanzara la ventana mezcla
                    VentanaInterna viMezcla = new VentanaInterna();
                    this.escritorio.add(viMezcla);                  // La añadimos al escritorio    
                    margen = margen + 100;
                    viMezcla.setLocation(margen%300, margen%300);   // Cada vez que sale una nueva ventana la creamos
                                               // al lado de la anterior para que no se superpongan
                    viMezcla.setTitle("Mezcla");                    // A esta ventana de nombre le asignamos Mezcla
                    viMezcla.setVisible(true);                      // La hacemos visible
                    //viNext.setSelected(true);
                    //vi.setSelected(true);
                }
                catch(IllegalArgumentException e){
                    System.err.println("Error: "+e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_botonBinarioFocusGained

    private void botonBinarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonBinarioFocusLost
        //botonBinario.setValue(0);   // Devolvemos al valor a 0
        //imagenOrg = null;           // Le damos null a las imagenes del frame
        //imagenOrg2 = null;
        /*NO PODEMOS USAR EL FOCUS LOST EN ESTA OPERACION DEBIDO A QUE
        AL CREARSE UNA VENTANA INTERNA NUEVA PASA A EJECUTARSE ESTE CODIGO (FOCUSLOST),
        ES DECIR, LO NORMAL SERIA FOCUSGAIN - OPERACION - FOCUSLOST, PERO ES ESTE CASO
        EL FOCUS LOST SE PRODUCE AL TERMINAR EL FOCUSGAIN, POR TANTO TENEMOS QUE 
        DEJARLO SIN EJECUTAR*/
    }//GEN-LAST:event_botonBinarioFocusLost

    /**
     * Ejecutamos la operacion de Umbralizacion sobre la imagen del lienzo
     * de la VentanaInterna activa en el nivel que indique el componente
     * @param evt 
     */
    private void botonUmbralizacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_botonUmbralizacionStateChanged
        // Cuando el deslizador cambia el valor tendremos que modificar el valor del umbral
        VentanaInterna vi = (VentanaInterna) (escritorio.getSelectedFrame());
        if (vi != null){           
                try{
                    UmbralizacionOp umbral = new UmbralizacionOp(botonUmbralizacion.getValue());
                    BufferedImage src = this.imagenOrg;
                    BufferedImage dest = null;  // La inicializamos a null para hacerlas comparibles
                                                // dentro del metodo
                    dest = umbral.filter(src, dest);
                    //imagenOrg = vi.getLienzo().getImage();        // Cogemos la imagen original de la ventana
                    vi.getLienzo().setImage(dest);
                    vi.getLienzo().repaint();
                }
                catch(IllegalArgumentException e){
                    System.err.println("Error: "+e.getLocalizedMessage());
                }
            }
    }//GEN-LAST:event_botonUmbralizacionStateChanged

    /**
     * Cuando el botonUmbralizacion gane el foco la imagen de la VentanaPrincipal recibira
     * la imagen del lienzo de la VentanaInterna activa.
     * @param evt 
     */
    private void botonUmbralizacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonUmbralizacionFocusGained
        VentanaInterna vi = (VentanaInterna) escritorio.getSelectedFrame();
        if (vi != null)
            this.imagenOrg = vi.getLienzo().getImage();
    }//GEN-LAST:event_botonUmbralizacionFocusGained

    /**
     * El valor del botonUmbralizacion volvera a ser 0
     * @param evt 
     */
    private void botonUmbralizacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonUmbralizacionFocusLost
        //this.imagenOrg = null;
        botonUmbralizacion.setValue(0);
    }//GEN-LAST:event_botonUmbralizacionFocusLost

    /**
     * Asignamos al lienzo de la VentanaInterna activa la forma de la curva
     * @param evt 
     */
    private void curvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curvaActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            vi.getLienzo().setBoton(vi.getLienzo().formaCurva);
        }
    }//GEN-LAST:event_curvaActionPerformed

    /**
     * Le indicamos al lienzo de la VentanaInterna activa que deseamos o no pintar con interlineado
     * @param evt 
     */
    private void botonInterlineadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInterlineadoActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            vi.getLienzo().activarInterlineado(botonInterlineado.isSelected());
            vi.getLienzo().repaint();
        }    
    }//GEN-LAST:event_botonInterlineadoActionPerformed

    /**
     * Le indicamos al lienzo de la VentanaInterna activa que deseamos pintar
     * las figuras con relleno degradado
     * @param evt 
     */
    private void degradadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degradadoActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            else{
                vi.getLienzo().activarDegradado(false);
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_degradadoActionPerformed

    /**
     * Le indicamos al lienzo de la VentanaInterna activa que deseamos que el 
     * relleno degradado sea en direccion vertical
     * @param evt 
     */
    private void degradado_verticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degradado_verticalActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            if (degradado.isSelected()){
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_degradado_verticalActionPerformed

    /**
     * Le indicamos al lienzo de la VentanaInterna activa el nivel de transparencia
     * que deseamos para pintar
     * @param evt 
     */
    private void transparenciaDeslizadorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_transparenciaDeslizadorStateChanged
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            vi.getLienzo().setTransparencia( transparenciaDeslizador.getValue()/10.0f);
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_transparenciaDeslizadorStateChanged

    /**
     * Creamos una nueva VentanaInterna con el lienzo completamente en blanco
     * y de tamaño el indicado en el dialogo del JOptionPane
     * @param evt 
     */
    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        int alto = 0;
        int ancho = 0;
        boolean error = false;
        JTextField textoAncho = new JTextField();
        JTextField textoAlto = new JTextField();
        Object[] mensaje = {"Introduzca las dimensiones (alto y ancho) de la nueva imagen a crear:"
            + " \n\n(El valor mínimo es 300)", "", "\nAlto:", textoAlto, "Ancho:", textoAncho};
        Object opciones[] = {"Aceptar", "Cancelar"};

        do{
            int resp = JOptionPane.showOptionDialog(null, mensaje, "Nueva", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, mensaje);
            if((resp == JOptionPane.NO_OPTION) || (resp == JOptionPane.CLOSED_OPTION)){
                error = true;
                break;
            }
            else{
                try{
                    alto = Integer.parseInt(textoAlto.getText());   // Pasamos los string a enteros
                    ancho = Integer.parseInt(textoAncho.getText());
                    error = false;              // Si tiene exito error pasa a ser false
                }
                catch(Exception ex){
                    System.err.println("Error al leer los datos");
                }

                if ((alto < 300) || (ancho < 300)){
                    error = true;   // Si el valor introducido es mayor que el tamaño del escritorio o menor que el minimo
                }                       // que es 300, volvera a pedir los datos
            }
        }
        while (error == true);

        if (error == false){
            VentanaInterna vi = new VentanaInterna();
            vi.setTitle("Nueva");
            vi.setSize(ancho, alto);
            escritorio.add(vi);
            vi.setLocation(margen%300, margen%300);     // Cada vez que iniciamos una nueva ventana la creamos
            margen = margen + 20;                       // al lado de la anterior para que no se superpongan
            punto.setSelected(true);                    //
            linea.setSelected(false);                   // Reseteamos la opción y lo
            rectangulo.setSelected(false);              // volvemos a poner en punto
            elipse.setSelected(false);                  //
            curva.setSelected(false);
            botonTransparencia.setSelected(false);
            botonAlisar.setSelected(false);
            botonEditar.setSelected(false);
            botonRelleno.setSelected(false);
            degradado.setSelected(false);
            degradado_vertical.setSelected(false);
            transparenciaDeslizador.setEnabled(false);
                                                      // Creamos una nueva imagen
            BufferedImage img = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);    // y la incorporamos al lienzo
            vi.getLienzo().setImageNueva(img);
            vi.getLienzo().setAreaVisible(img.getWidth(), img.getHeight()); // Asignamos este area para el clip
            vi.setVisible(true);
        }
    }//GEN-LAST:event_nuevoActionPerformed

    /**
     * Creamos una nueva VentanaInterna si el archivo escogido en el dialogo es de imagen
     * Creamos una nueva VentanaInternaAudio si el archivo escogido en el dialogo es de audio
     * Creamos una nueva VentanaInternaJMFPlayer si el archivo escogido en el dialogo es de video
     * @param evt 
     */
    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION){
            try{
                File f = dlg.getSelectedFile();
                String ext = f.getName().substring(f.getName().indexOf(".")+1); // Cogemos la extension del archivo
                if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("gif")){
                    BufferedImage img = ImageIO.read(f);
                    VentanaInterna vi = new VentanaInterna();
                    vi.setLocation(margen%300, margen%300);     // Cada vez que iniciamos una nueva ventana la creamos
                    margen = margen + 20;                       // al lado de la anterior para que no se superpongan
                    vi.getLienzo().setImage(img);
                    vi.getLienzo().setAreaVisible(img.getWidth(), img.getHeight());
                    this.escritorio.add(vi);
                    vi.setTitle(f.getName());
                    vi.setVisible(true);
                    punto.setSelected(true);                    //
                    linea.setSelected(false);                   // Reseteamos la opción y lo
                    rectangulo.setSelected(false);              // volvemos a poner en punto
                    elipse.setSelected(false);                  //
                    curva.setSelected(false);
                    botonTransparencia.setSelected(false);
                    botonAlisar.setSelected(false);
                    botonEditar.setSelected(false);
                    botonRelleno.setSelected(false);
                    degradado.setSelected(false);
                    degradado_vertical.setSelected(false);
                    transparenciaDeslizador.setEnabled(false);
                }
                else{
                    if (ext.equalsIgnoreCase("wav")){
                        VentanaInternaAudio vi = new VentanaInternaAudio(f);
                        vi.setLocation(margen%300, margen%300);     // Cada vez que iniciamos una nueva ventana la creamos
                        margen = margen + 20;                       // al lado de la anterior para que no se superpongan
                        this.escritorio.add(vi);
                        vi.setTitle(f.getName());
                        vi.setVisible(true);
                    }
                    else{
                        if (ext.equalsIgnoreCase("avi") || ext.equalsIgnoreCase("mpg") || ext.equalsIgnoreCase("mkv") || ext.equalsIgnoreCase("mp4") || ext.equalsIgnoreCase("wmv")){
                            VentanaInternaJMFPlayer vi = VentanaInternaJMFPlayer.getInstance(f);
                            if (vi != null){    // Si no ha habido ningun error y vi != null, proseguimos
                                vi.setLocation(margen%300, margen%300);
                                margen = margen + 20;
                                this.escritorio.add(vi);
                                vi.setTitle(f.getName());
                                vi.setMaximum(true);
                                //vi.setSize(escritorio.getWidth(), escritorio.getHeight()); // Para evitar que la ventana sea mas grande de lo que debe ajustamos su tamaño
                                vi.setVisible(true);
                            }
                        }
                    }
                }
            }
            catch(Exception ex){
                System.err.println("Error al leer el archivo");
            }
        }
    }//GEN-LAST:event_abrirActionPerformed

    /**
     * Sla ventana activa es de tipo VentanaInterna, guardaremos la imagen de su
     * lienzo en un archivo especificado en el dialogo
     * @param evt 
     */
    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        VentanaInterna vi=(VentanaInterna) escritorio.getSelectedFrame();
        if (vi != null && vi instanceof VentanaInterna){
            JFileChooser dlg = new JFileChooser();
            FileNameExtensionFilter filtro_jpg = new FileNameExtensionFilter(".jpg", "jpg");
            FileNameExtensionFilter filtro_png = new FileNameExtensionFilter(".png", "png");
            FileNameExtensionFilter filtro_gif = new FileNameExtensionFilter(".gif", "gif");

            dlg.setFileFilter(filtro_jpg);
            dlg.setFileFilter(filtro_png);
            dlg.setFileFilter(filtro_gif);

            int resp = dlg.showSaveDialog(this);
            if (resp == JFileChooser.APPROVE_OPTION){
                try {
                    BufferedImage img = vi.getLienzo().getImage(true);
                    if (img != null){
                        File f = new File(dlg.getSelectedFile().getAbsolutePath()+dlg.getFileFilter().getDescription());//dlg.getSelectedFile();
                        ImageIO.write(img, dlg.getFileFilter().getDescription().substring(1), f);
                        vi.setTitle(f.getName());
                    }
                }
                catch (Exception ex){
                    System.err.println("Error al guardar la imagen");
                }
            }
        }
    
    }//GEN-LAST:event_guardarActionPerformed

    /**
     * Creamos una nueva VentanaInterna a partir de otra con la misma imagen y
     * formas
     * @param evt 
     */
    private void botonDuplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDuplicarActionPerformed
        VentanaInterna vi = new VentanaInterna();   // Creamos la nueva ventana interna
        BufferedImage dest;         // Esta sera la imagen duplicada
        VentanaInterna viActiva;
        viActiva = (VentanaInterna)escritorio.getSelectedFrame();
        if (viActiva != null){
            try{
                dest = viActiva.getLienzo().getImage(true); // Recogemos la imagen del lienzo activo          
                escritorio.add(vi);                         // Ahora procedemos a asignar la nueva ventana activa (la duplicada)
                vi.setLocation(margen%300, margen%300);     // Cada vez que iniciamos una nueva ventana la creamos
                margen = margen + 20;                       // al lado de la anterior para que no se superpongan
                vi.setVisible(true);
                punto.setSelected(true);                    //
                linea.setSelected(false);                   // Reseteamos la opción y lo
                rectangulo.setSelected(false);              // volvemos a poner en punto
                elipse.setSelected(false);                  //
                botonTransparencia.setSelected(false);
                botonAlisar.setSelected(false);
                botonEditar.setSelected(false);
                botonRelleno.setSelected(false);
                degradado.setSelected(false);
                degradado_vertical.setSelected(false);
                transparenciaDeslizador.setEnabled(false);

                vi.getLienzo().setImage(dest);               // y la incorporamos al lienzo
                vi.setTitle(viActiva.getTitle()+" Duplicada" );
            }
            catch(Exception e){
                System.err.println("Error al duplicar");
            }   
        }
    }//GEN-LAST:event_botonDuplicarActionPerformed

    /**
     * Vemos u ocultamos la barra de herramientas correspondiente al dibujo
     * @param evt 
     */
    private void verBarraDibujoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBarraDibujoActionPerformed
        if (verBarraDibujo.isSelected())
            this.barraDibujo.setVisible(true);
        else
            this.barraDibujo.setVisible(false);
    }//GEN-LAST:event_verBarraDibujoActionPerformed

    /**
     * Vemos u ocultamos la/s barra/s de herramientas correspondiente a
     * las operaciones sobre imagenes
     * @param evt 
     */
    private void verBarraImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBarraImagenActionPerformed
        if (verBarraImagen.isSelected()){
            this.barraImagen.setVisible(true);
            this.barraImagen2.setVisible(true);
        }
        else{
            this.barraImagen.setVisible(false);
            this.barraImagen2.setVisible(false);
        }
    }//GEN-LAST:event_verBarraImagenActionPerformed

    /**
     * Vemos u ocultamos la barra de herramientas relacionada con
     * el video y el audio
     * @param evt 
     */
    private void verBarraAudioVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBarraAudioVideoActionPerformed
        if (verBarraAudioVideo.isSelected())
            this.barraAudioVideo.setVisible(true);
        else
            this.barraAudioVideo.setVisible(false); 
    }//GEN-LAST:event_verBarraAudioVideoActionPerformed

    /**
     * Le asignamos al lienzo de la VentanaInterna activa la forma del
     * poligono
     * @param evt 
     */
    private void poligonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poligonoActionPerformed
        VentanaInterna vi;
        vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            vi.getLienzo().setBoton(vi.getLienzo().formaPoligono);
        }
    }//GEN-LAST:event_poligonoActionPerformed

    /**
     * Si la ventana activa es de tipo VentanaInternaGrabacion lanzara
     * el dialogo para seleccionar donde queremos guardar el audio
     * que vamos a grabar y seguidamente comenzara a grabar
     * @param evt 
     */
    private void grabarAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarAudioActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showSaveDialog(this);
        if (resp == JFileChooser.APPROVE_OPTION){
            try{
                File f = new File(dlg.getSelectedFile().getAbsolutePath() + ".wav"); // Guardamos el archivo como wav             
                VentanaInternaGrabacion vi = new VentanaInternaGrabacion(f);
                escritorio.add(vi);
                vi.setLocation(margen%300, margen%300);
                margen = margen + 20;
                vi.setVisible(true);
            }
            catch (Exception ex){
                System.err.println("Error al guardar la direccion de la grabacion");
            }
        }
            
            
    }//GEN-LAST:event_grabarAudioActionPerformed

    /**
     * Ejecuta el metodo grabarAudioActionPerformed(evt)
     * @param evt 
     */
    private void botonAudioGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAudioGrabarActionPerformed
        this.grabarAudioActionPerformed(evt);
    }//GEN-LAST:event_botonAudioGrabarActionPerformed

    private void estadoLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estadoLabelMouseMoved
    }//GEN-LAST:event_estadoLabelMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
    }//GEN-LAST:event_formMouseMoved

    /**
     * Le asignamos como color principal el NEGRO al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorNegroActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            this.color = Color.BLACK;
            vi.getLienzo().setColor(this.color);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorNegroActionPerformed

    /**
     * Le asignamos como color principal el BLANCO al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorBlancoActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            this.color = Color.WHITE;
            vi.getLienzo().setColor(this.color);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorBlancoActionPerformed

    /**
     * Le asignamos como color principal el ROJO al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorRojoActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            this.color = Color.RED;
            vi.getLienzo().setColor(this.color);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorRojoActionPerformed

    /**
     * Le asignamos como color principal el AZUL al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorAzulActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            this.color = Color.BLUE;
            vi.getLienzo().setColor(this.color);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorAzulActionPerformed

    /**
     * Le asignamos como color principal el VERDE al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorVerdeActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            this.color = Color.GREEN;
            vi.getLienzo().setColor(this.color);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorVerdeActionPerformed

    /**
     * Le asignamos como color principal el MAGENTA al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorMagentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorMagentaActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            this.color = Color.MAGENTA;
            vi.getLienzo().setColor(this.color);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorMagentaActionPerformed

    /**
     * Le asignamos como color principal el CYAN al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorCyanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorCyanActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            this.color = Color.CYAN;
            vi.getLienzo().setColor(this.color);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorCyanActionPerformed

    /**
     * Le asignamos como color principal el AMARILLO al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorAmarilloActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            this.color = Color.YELLOW;
            vi.getLienzo().setColor(this.color);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorAmarilloActionPerformed

    /**
     * Le asignamos como color de degradado el NEGRO al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorDegradadoNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorDegradadoNegroActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi!=null){
            color_degradado = Color.BLACK;
            vi.getLienzo().setColorDegradado(color_degradado);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorDegradadoNegroActionPerformed

    /**
     * Le asignamos como color de degradado el BLANCO al lienzo de la VentanaInterna activa
     */
    private void colorDegradadoBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorDegradadoBlancoActionPerformed
         VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi!=null){
            color_degradado = Color.WHITE;
            vi.getLienzo().setColorDegradado(color_degradado);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorDegradadoBlancoActionPerformed

    /**
     * Le asignamos como color de degradado el ROJO al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorDegradadoRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorDegradadoRojoActionPerformed
         VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi!=null){
            color_degradado = Color.RED;
            vi.getLienzo().setColorDegradado(color_degradado);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorDegradadoRojoActionPerformed

    /**
     * Le asignamos como color de degradado el AZUL al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorDegradadoAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorDegradadoAzulActionPerformed
         VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi!=null){
            color_degradado = Color.BLUE;
            vi.getLienzo().setColorDegradado(color_degradado);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorDegradadoAzulActionPerformed

    /**
     * Le asignamos como color de degradado el AMARILLO al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorDegradadoAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorDegradadoAmarilloActionPerformed
         VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi!=null){
            color_degradado = Color.YELLOW;
            vi.getLienzo().setColorDegradado(color_degradado);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorDegradadoAmarilloActionPerformed

    /**
     * Le asignamos como color de degradado el VERDE al lienzo de la VentanaInterna activa
     * @param evt 
     */
    private void colorDegradadoVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorDegradadoVerdeActionPerformed
         VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi!=null){
            color_degradado = Color.GREEN;
            vi.getLienzo().setColorDegradado(color_degradado);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorDegradadoVerdeActionPerformed

    /**
     * Le asignamos como color de degradado el MAGENTA al lienzo de la VentanaInterna activa
     */
    private void colorDegradadoMagentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorDegradadoMagentaActionPerformed
         VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi!=null){
            color_degradado = Color.MAGENTA;
            vi.getLienzo().setColorDegradado(color_degradado);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorDegradadoMagentaActionPerformed

    /**
     * Le asignamos como color de degradado el CYAN al lienzo de la VentanaInterna activa
     */
    private void colorDegradadoCyanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorDegradadoCyanActionPerformed
         VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi!=null){
            color_degradado = Color.CYAN;
            vi.getLienzo().setColorDegradado(color_degradado);
            if (degradado.isSelected()){
                vi.getLienzo().activarDegradado(true);
                vi.getLienzo().setDegradado(color_degradado, degradado_vertical.isSelected());
            }
            vi.getLienzo().repaint();
        }
    }//GEN-LAST:event_colorDegradadoCyanActionPerformed

    /**
     * Mostramos un mensaje informativo indicando como Titulo "Informacion"
     * y en el mensaje indicamos desarrollador del programa y version
     * @param evt 
     */
    private void acercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeActionPerformed
        JOptionPane.showMessageDialog(
                this,"Programa multimedia \nDesarrollado por: Jorge Valenzuela Garcia\nVersion 1.0"
                    , "Información",
                    JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_acercaDeActionPerformed

    /**
     * Aplicamos sobre la imagen del lienzo de la VentanaInterna activa el
     * efecto de exponerRGB
     * @param evt 
     */
    private void botonExponerRGBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExponerRGBActionPerformed
        VentanaInterna vi = (VentanaInterna)escritorio.getSelectedFrame();
        if (vi != null){
            try{
                BufferedImage imgOrigen = vi.getLienzo().getImage();
                BufferedImage imgDest = null;   // La inicializamos a null para en el metodo filter de la clase
                                                // SepiaOp hacerla compatible con imgOrigen
                ExponerRGB exponer = new ExponerRGB();
                imgDest = exponer.filter(imgOrigen, imgDest); // Aplicamos el filtro a imgDest
                vi.getLienzo().setImage(imgDest);
                vi.getLienzo().repaint();
            }
            catch(Exception e){
                System.err.println("Error al usar filtro ajedrez");
            }
        }
    }//GEN-LAST:event_botonExponerRGBActionPerformed

    /**
     * Realizamos una captura del reproductor de video y
     * lo abrimos como imagen de una nueva VentanaInterna
     * @param evt 
     */
    private void botonCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCapturarActionPerformed
        VentanaInternaJMFPlayer viP = (VentanaInternaJMFPlayer)escritorio.getSelectedFrame();
        if (viP != null){
            try{
                BufferedImage captura;
                captura = viP.getFrame();
                VentanaInterna vi = new VentanaInterna();
                escritorio.add(vi);
                vi.getLienzo().setImage(captura);
                vi.setVisible(true);
            }
            catch(Exception e){
                System.err.println("Error capturando" + e.toString()
                );
            }
        }
    }//GEN-LAST:event_botonCapturarActionPerformed

    /**
     * Vemos u ocultmos la barra de estado
     * @param evt 
     */
    private void verBarraEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBarraEstadoActionPerformed
        if (verBarraEstado.isSelected())
            this.estadoLabel.setVisible(true);
        else
            this.estadoLabel.setVisible(false);
    }//GEN-LAST:event_verBarraEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Brillo;
    private javax.swing.JLabel Escala;
    private javax.swing.JLabel Filtro;
    private javax.swing.JLabel LabelCoorPrincipal;
    private javax.swing.JLabel LabelGrosor;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JMenuItem abrir;
    private javax.swing.JMenuItem acercaDe;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JToolBar barraAudioVideo;
    private javax.swing.JToolBar barraDibujo;
    private javax.swing.JToolBar barraImagen;
    private javax.swing.JToolBar barraImagen2;
    private javax.swing.JButton botonAbrir;
    private javax.swing.JToggleButton botonAlisar;
    private javax.swing.JButton botonAudioGrabar;
    private javax.swing.JSlider botonBinario;
    private javax.swing.JSlider botonBrillo;
    private javax.swing.JButton botonCapturar;
    private javax.swing.JButton botonContrasteIluminar;
    private javax.swing.JButton botonContrasteNormal;
    private javax.swing.JButton botonContrasteOscurecer;
    private javax.swing.JMenuItem botonDuplicar;
    private javax.swing.JToggleButton botonEditar;
    private javax.swing.JButton botonEscalaAumentar;
    private javax.swing.JButton botonEscalaDisminuir;
    private javax.swing.JButton botonExponerRGB;
    private javax.swing.JComboBox<String> botonFiltro;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JCheckBox botonInterlineado;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JToggleButton botonRelleno;
    private javax.swing.JButton botonResta;
    private javax.swing.JButton botonRot180;
    private javax.swing.JButton botonRot270;
    private javax.swing.JButton botonRot90;
    private javax.swing.JSlider botonRotacion;
    private javax.swing.JButton botonSepia;
    private javax.swing.JButton botonSuma;
    private javax.swing.JToggleButton botonTransparencia;
    private javax.swing.JSlider botonUmbralizacion;
    private javax.swing.JToggleButton colorAmarillo;
    private javax.swing.JToggleButton colorAzul;
    private javax.swing.JToggleButton colorBlanco;
    private javax.swing.JToggleButton colorCyan;
    private javax.swing.JToggleButton colorDegradadoAmarillo;
    private javax.swing.JToggleButton colorDegradadoAzul;
    private javax.swing.JToggleButton colorDegradadoBlanco;
    private javax.swing.JToggleButton colorDegradadoCyan;
    private javax.swing.JToggleButton colorDegradadoMagenta;
    private javax.swing.JToggleButton colorDegradadoNegro;
    private javax.swing.JToggleButton colorDegradadoRojo;
    private javax.swing.JToggleButton colorDegradadoVerde;
    private javax.swing.JToggleButton colorMagenta;
    private javax.swing.JToggleButton colorNegro;
    private javax.swing.JToggleButton colorRojo;
    private javax.swing.JToggleButton colorVerde;
    private javax.swing.JToggleButton curva;
    private javax.swing.JCheckBox degradado;
    private javax.swing.JCheckBox degradado_vertical;
    private javax.swing.JToggleButton elipse;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JMenuItem grabarAudio;
    private javax.swing.JMenu grabarAudioMenu;
    private javax.swing.JSpinner grosor;
    private javax.swing.ButtonGroup grupoBotonosHerramientas;
    private javax.swing.ButtonGroup grupoColoresDegradados;
    private javax.swing.ButtonGroup grupoColoresPrincipales;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenu imagenMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToggleButton linea;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem nuevo;
    private javax.swing.JToggleButton poligono;
    private javax.swing.JToggleButton punto;
    private javax.swing.JToggleButton rectangulo;
    private javax.swing.JLabel rotacion;
    private javax.swing.JSlider transparenciaDeslizador;
    private javax.swing.JLabel umbralizacion;
    private javax.swing.JCheckBoxMenuItem verBarraAudioVideo;
    private javax.swing.JCheckBoxMenuItem verBarraDibujo;
    private javax.swing.JCheckBoxMenuItem verBarraEstado;
    private javax.swing.JCheckBoxMenuItem verBarraImagen;
    private javax.swing.JMenu verMenu;
    // End of variables declaration//GEN-END:variables

}
