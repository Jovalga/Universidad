package sm.JVG.iu;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import sm.JVG.graficos.Figura;
import sm.JVG.graficos.JVGCurva;
import sm.JVG.graficos.JVGElipse;
import sm.JVG.graficos.JVGLinea;
import sm.JVG.graficos.JVGPoligono;
import sm.JVG.graficos.JVGPunto;
import sm.JVG.graficos.JVGRectangulo;

/**
 * Clase que hereda de JPanel que nos permite dibujar
 * formas geometricas.
 * @author tales
 */
public class Lienzo2D extends javax.swing.JPanel {

    public Lienzo2D() {
        initComponents();
    }
    
    // Opciones
    public static final int formaPunto = 1;
    public static final int formaLinea = 2;
    public static final int formaRectangulo = 3;
    public static final int formaElipse = 4;
    public static final int formaCurva = 5;
    public static final int formaPoligono = 6;
    private int boton = 1;     // Para saber 1-punto / 2-Linea / 3-Rectangulo / 4-Elipse / 5 - Curve / 6 - Trazo / 7 - Poligono
    
    // Atributos de las formas
    /**
     * Color Principal
     */
    private Color color = Color.BLACK;
    /**
     * Color Degradado
     */
    private Color color_degradado = Color.WHITE;
    /**
     * Valor del interlineado para el Stroke
     */
    private final float interlineado[] = {10.0f};
    /**
     * Grosor
     */
    private Stroke stroke = new BasicStroke(1.0f);
    /**
     * Grosor con interlineado
     */
    private Stroke stroke_inter = new BasicStroke(1.0f,BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f,interlineado,0.0f);// Grosor interlineado
    /**
     * Degradado
     */
    private GradientPaint degradado = new GradientPaint(0,0,Color.BLACK,300,0,Color.WHITE);
    /**
     * Render antialiasing
     */
    private RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);      // Render para antialiasing
    /**
     * Transparencia
     */
    private Composite transparencia = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f);
    
    //Booleanas para saber si aplicar unos atributos u otros
    /**
     * Atributo para saber si activar o no el interlienado
     */
    private boolean activo_interlineado = false;
    /**
     * Atributo para saber si activar o no el degradado
     */
    private boolean activo_degradado = false;
    /**
     * Atributo para saber si activar o no el relleno
     */
    private boolean activo_relleno = false;
    /**
     * Atributo para saber si activar o no la edicion
     */
    private boolean editar = false;
    
    /**
     * Atributo para guardar el punto inicial del pressed
     */
    private Point p_inicial = new Point();
    /**
     * Atributo para guardar el punto del dragged y released
     */
    private Point p_final = new Point();
    /**
     * Area para el clip visualizar, comienza siendo 300,300 que 
     * es el minimo que puede medir el lienzo
     */
    private Shape areaVisible = new Rectangle(300,300);
    /**
     * Atributo para guardar la figura que cojamos con el pressed
     * cuando estemos editando
     */
    private Figura figuraSeleccionada = null;
    /**
     * Atributo para guardar el indice de la figura
     * seleccionada durante la edicion
     */
    private int indiceFiguraSeleccionada = -1;
    /**
     * Pasos para calcular las figuras que deban crearse con mas de un paso
     */
    private int pasos = 0;
    /**
     * Caja a pintar cuando estemos editando sobre la figura seleccionada
     */
    private Rectangle BoundingBox = null;

    /**
     * Array de figuras pintadas
     */
    List <Figura> vFiguras = new ArrayList();
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.clip(this.areaVisible);
        
        if (editar && figuraSeleccionada != null){
            // Reemplazamos los valores de la figura por los actuales, y seguidamente añadimos la figura al vector
            // en el lugar que le corresponde
            
            figuraSeleccionada.setColor(color);
            figuraSeleccionada.setDegradado(degradado);
            figuraSeleccionada.setRender(render);
            figuraSeleccionada.setTransparencia(transparencia);
            if (this.activo_interlineado)
                figuraSeleccionada.setStroke(this.stroke_inter);
            else    
                figuraSeleccionada.setStroke(this.stroke);
            figuraSeleccionada.activarDegradado(this.activo_degradado);
            figuraSeleccionada.activarRelleno(this.activo_relleno);
            vFiguras.set(this.indiceFiguraSeleccionada, figuraSeleccionada);
        
            for (Figura figura: vFiguras)
                figura.pintate(g2d);
            // Una vez hemos pintado todo, vamos a pintar el boundingbox encima de la figura seleccionada
            g2d.drawRect(this.BoundingBox.x -4, this.BoundingBox.y -4, this.BoundingBox.width +8, this.BoundingBox.height +8);
            // Esquina superior izquierda: 
            g2d.drawOval(this.BoundingBox.x -6, this.BoundingBox.y -6, 4, 4);
            //Esquina inferior derecha:
            g2d.drawOval(this.BoundingBox.x + this.BoundingBox.width +2, this.BoundingBox.y + this.BoundingBox.height +2,4,4);
            //Esquina inferior izquierda
            g2d.drawOval(this.BoundingBox.x -6, this.BoundingBox.y + this.BoundingBox.height +2, 4,4);
            //Esquina superior derecha
            g2d.drawOval(this.BoundingBox.x + this.BoundingBox.width +2, this.BoundingBox.y -6, 4, 4);
        }
        else{
            for (Figura figura: vFiguras)
                figura.pintate(g2d);
        }
    }

    /**
     * Metodo para asignar un area de visualizacion del lienzo.
     * @param ancho - ancho del area visible
     * @param largo - largo del area visible
     */
    public void setAreaVisible( int ancho, int largo ){
        Point punto = new Point(0,0);
        Rectangle2D area = new Rectangle(punto);
        area.setFrame(0,0,ancho,largo);
        this.areaVisible = area;
    }
    
    
    /**
     * Metodo para asignar un valor al atributo boton.
     * @param boton - valor int para el atributo boton
     */
    public void setBoton (int boton){
        this.boton = boton;
    }
    
   
    /**
     * Metodo para crear las distintas figuras en funcion del boton que este asignado.
     * @param p - punto donde crear la figura
     * @return figura creada
     */
    public Figura crearFigura(Point p){
        Figura figura;
        
        switch (boton){
            case formaPunto:
                JVGPunto punto = new JVGPunto(p);
                figura = punto;
                break;
                
            case formaLinea:
                JVGLinea linea = new JVGLinea(p, p);
                figura = linea;
                break;
                
            case formaRectangulo:
                JVGRectangulo rectangulo = new JVGRectangulo(p, p);
                figura = rectangulo;
                break;
                
            case formaElipse:
                JVGElipse elipse = new JVGElipse(p, p);
                figura = elipse;
                break;
            
            case formaCurva:
                JVGCurva curva = new JVGCurva(p, p, p);
                figura = curva;
                break;
                
            case formaPoligono:
                JVGPoligono poligono = new JVGPoligono(p);
                figura = poligono;
                break;
                
            default:
                JVGPunto puntoo = new JVGPunto(p);
                figura = puntoo;                                       // las anteriores entrara aqui y creara un MiLine2D
                break;
        }
        return figura;
    }
    
    
    /**
     * Metodo que nos devuelve la figura que contenga con al punto p
     * @param p - punto en el que se comprueba si esta dentro de la figura
     * @return figura que contiene a p
     */
    private Figura getSelectedFigura(Point p){
        for(Figura f: vFiguras)
            if(f.contiene(p))
                return f;
        return null;
    }

    
    /**
     * Metodo que asigna un color al atributo color del lienzo
     * @param color - color que queremos asignar
     */
    public void setColor (Color color){
        this.color = color;
    }
    
    /**
     * Metodo que asigna un color de degradado al lienzo
     * @param color - color que queremos asignar
     */
    public void setColorDegradado ( Color color ){
        this.color_degradado = color;
    }
    
    
    /**
     * Metodo que asigna un GradientPaint al atributo degradado del lienzo
     * @param color - color del GradientPaint
     * @param vertical - true si el degradado va a ser vertical, false para horizontal
     */
    public void setDegradado (Color color, boolean vertical){
        if (vertical){
            GradientPaint degradadoPaint = new GradientPaint(this.getWidth()/2,0,this.color,this.getWidth()/2,this.getHeight(),this.color_degradado);
            this.degradado = degradadoPaint;
        }
        else{
            GradientPaint degrad = new GradientPaint(0,0,this.color,this.getWidth(),0,this.color_degradado);
            this.degradado = degrad;
        }
    }
    
    
    /**
     * Metodo que asigna el valor pasado por parametro al interlineado del lienzo
     * @param valor - valor que queremos asignar al interlineado
     */
    public void setInterlineado( Float valor ){
        this.interlineado[0] = valor;
    }
    
    /**
     * Metodo que asigna un stroke basico con el grosor indicado como parametro
     * @param valor - grosor que queremos asignar
     */
    public void setStroke(Float valor){
        Stroke strokeNormal = new BasicStroke(valor);
        this.stroke = strokeNormal;
    }
    
    /**
     * Metodo que asigna un Stroke con interlineado al lienzo
     * @param inter - stroke que queremos asignar
     */
    public void setStrokeInterlineado (Stroke inter){
        Stroke stroke_interlineado = new BasicStroke(1.0f,BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,10.0f,interlineado,0.0f);
        this.stroke_inter = stroke_interlineado;
    }
    
    /**
     * Metodo para asignar al lienzo un nuevo RenderingHints
     * @param render - nuevo render que queremos asignar al lienzo
     */
    public void setRender(RenderingHints render){
        this.render = render;
    }
    
    
    /**
     * Metodo que asigna un nuevo Composite o transparencia al lienzo
     * @param valor - valor de transparencia que queremos asignar
     */
    public void setTransparencia ( float valor ){
        Composite transpar = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,valor);
        this.transparencia = transpar;
    }
    
    
    /**
     * Metodo para activar o no el interlineado del lienzo
     * @param decision - true si queremos activarlo, false para lo contrario
     */
    public void activarInterlineado(boolean decision){
        this.activo_interlineado = decision;
    }
    
    /**
     * Metodo para activar el degradado del lienzo
     * @param decision - true si queremos activarlo, false para lo contrario
     */
    public void activarDegradado(boolean decision){
        this.activo_degradado = decision;
    }
    
    /**
     * Metodo para activar el relleno del lienzo
     * @param decision - true para activarlo, false para lo contrario
     */
    public void activarRelleno(boolean decision){
        this.activo_relleno = decision;
    }
    
    
    /**
     * Metodo para activar el antialiasing
     * @param decision - true si queremos activarlo, false para lo contrario
     */
    public void activarAntialiasing(boolean decision){
        if (decision){
            RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);      // Render para antialiasing
            this.render = antialiasing;
        }
        else{
            RenderingHints antialiasing = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);      // Render para antialiasing
            this.render = antialiasing;
        }
    }
    
    /**
     * Metodo para activar la funcion de editar
     * @param decision true si queremos activarla, false para lo contrario
     */
    public void activarEditar(boolean decision){
        this.editar = decision;
    }
        
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Cogemos el punto donde hemos hecho press
        p_inicial = evt.getPoint();
        
        // La primera comprobacion que hacemos es ver si las figuras que se pintan con mas de
        // dos pasos siguen seleccionadas
        if (!vFiguras.isEmpty() && boton != formaCurva && vFiguras.get(vFiguras.size()-1) instanceof JVGCurva ){
            pasos = 0;
        }
        
        if (!vFiguras.isEmpty() && boton != formaPoligono && vFiguras.get(vFiguras.size()-1) instanceof JVGPoligono ){
            pasos = 0;
        }
        
        
        if (editar){
            this.figuraSeleccionada = this.getSelectedFigura(p_inicial);            // Cogemos la figura seleccionada
            if (figuraSeleccionada != null){
                this.indiceFiguraSeleccionada = vFiguras.indexOf(figuraSeleccionada);   // Cogemos el indice de la figura seleccionada
                this.BoundingBox = this.figuraSeleccionada.getBoundingBox();            // Creamos su BoundingBox
                repaint();
            }
        }
        
        else{
            if (pasos == 0){
                Figura f = crearFigura(p_inicial);
                // Mandamos los atributos actuales del lienzo a la figura
                f.setColor(this.color);
                f.setDegradado(this.degradado);     // pintaremos con el color correspondiente al de la
                if (this.activo_interlineado)
                    f.setStroke(this.stroke_inter);
                else    
                    f.setStroke(this.stroke);
                f.setRender(this.render);
                f.setTransparencia(this.transparencia);
        
              // Ahora mandamos las indicaciones para usar o no usar relleno y que tipo de setPaint
                f.activarDegradado(this.activo_degradado);
                f.activarRelleno(this.activo_relleno);
                vFiguras.add(f);
                // Finalmente llamamos a repaint
                repaint();
            }
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.p_final = evt.getPoint();
        
        if(editar){
            if (figuraSeleccionada != null){
                this.figuraSeleccionada.setLocation(p_final);
                this.BoundingBox = this.figuraSeleccionada.getBoundingBox(); // Para el seguimiento del BoundingBox
            }
        }
        else{
            if (pasos == 0){
                vFiguras.get(vFiguras.size()-1).update(p_inicial , p_final);
                if (vFiguras.get(vFiguras.size()-1) instanceof JVGCurva || vFiguras.get(vFiguras.size()-1) instanceof JVGPoligono)
                pasos++;
            }
            else{
                if (vFiguras.get(vFiguras.size()-1) instanceof JVGPoligono)
                    ((JVGPoligono)vFiguras.get(vFiguras.size()-1)).addVertice(p_final);
                if (vFiguras.get(vFiguras.size()-1) instanceof JVGCurva){
                    ((JVGCurva)vFiguras.get(vFiguras.size()-1)).asignarCurvatura(p_final);
                    this.pasos = 0;
                }
            }
        }
        this.repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.p_final = evt.getPoint();
        
        if(editar){
            if (figuraSeleccionada != null){
                this.figuraSeleccionada.setLocation(p_final);
                this.BoundingBox = this.figuraSeleccionada.getBoundingBox();    // Para el seguimiento del BoundingBox
            }
        }
        else{
            if (pasos == 0){
                vFiguras.get(vFiguras.size()-1).update(p_inicial , p_final);
            }
            else{
                if (vFiguras.get(vFiguras.size()-1) instanceof JVGPoligono)
                    ((JVGPoligono)vFiguras.get(vFiguras.size()-1)).addVertice(p_final);
                if (vFiguras.get(vFiguras.size()-1) instanceof JVGCurva)
                    ((JVGCurva)vFiguras.get(vFiguras.size()-1)).asignarCurvatura(p_final);
            }
        }
            this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // Se ejecutara el siguiete codigo al hacer doble click
      if(evt.getClickCount()==2){
         if (vFiguras.get(vFiguras.size()-1) instanceof JVGPoligono){
            ((JVGPoligono)vFiguras.get(vFiguras.size()-1)).addVertice(evt.getPoint());
            pasos = 0;
         }
      }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}