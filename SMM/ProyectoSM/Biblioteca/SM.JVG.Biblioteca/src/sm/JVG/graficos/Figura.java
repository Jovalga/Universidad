
package sm.JVG.graficos;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;

/**
 * Clase abstracta con la funcionalidad de pintar
 * figuras geometricas junto a sus atributos como color, o trazo
 * entre otros.
 * @author Jorge Valenzuela Garcia
 */
public abstract class Figura{
    
    //Atributos
    /**
     * Geomtria de la figura
     */
    Shape geometria;
    /**
     * Color de la figura
     */
    private Color color = Color.BLACK;
    /**
     * Grosor de la figura
     */
    private Stroke stroke = new BasicStroke(1.0f);
    /**
     * Degradado de la figura
     */
    private GradientPaint degradado = new GradientPaint(0,0,Color.BLACK,300,0,Color.WHITE);
    /**
     * Render de la figura
     */
    private RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    /**
     * Transparencia de la figura
     */
    private Composite transparencia = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f);
        
    /**
     * Atributo para saber si activar o no el degradado de la figura
     */
    private boolean activo_degradado = false;
    /**
     * Atributo para saber si activar o no el relleno de la figura
     */
    private boolean relleno = false;

    
    /**Metodo para asignar color a la figura.
     * @param color - sera el color que tendra la figura
    **/
    public void setColor (Color color){
        this.color = color;
    }
    
    /**
     * Metodo para asignar un degradado a la figura.
     * @param degradado - GradientPaint que sera asignado a la figura
     **/
    public void setDegradado(GradientPaint degradado){
        this.degradado = degradado;
    }
    
    /**
     * Metodo para asignar un grosor a la figura.
     * @param stroke - Stroke que indica el grosor que sera asignado a la figura
     */
    public void setStroke (Stroke stroke){
        this.stroke = stroke;
    }

    
    /**
     * Metodo para asignar un RenderingHints a la figura.
     * @param render - RenderingHints que se asignara la figura
     */
    public void setRender (RenderingHints render){
        this.render = render;
    }
    
    /**
     * Metodo para asignar un nuevo valor de transparencia a la figura.
     * @param transparencia - variable de tipo Composite que se asignara a la figura
     */
    public void setTransparencia (Composite transparencia){
        this.transparencia = transparencia;
    }
    
    /**
     * Metodo para activar el degradado de la figura cuando se vata a pintar.
     * @param decision - true si queremos que tenga degradado, false para lo contrario
     */
    public void activarDegradado(boolean decision){
        this.activo_degradado = decision;
    }
    
    /**
     * Metodo para activar el relleno de la figura cuando se vaya a pintar.
     * @param decision - true si queremos que tenga relleno, false para lo contrario
     */
    public void activarRelleno(boolean decision){
        this.relleno = decision;
    }
    
    /**
     * Metodo para pintar la figura con sus atributos actuales.
     * @param g2d - contexto de gráficos en el que pintar
     */
    public void pintate (Graphics2D g2d){   
        if (this.activo_degradado)                  // Dependiendo de si esta el gradient activo o no 
                    //paint;
            g2d.setPaint(this.degradado);           // pintaremos la figura con el degradado o
        else                                        // con el color plano
            g2d.setPaint(this.color);
        g2d.setStroke(this.stroke);                 // atributos con los que se guardó
        g2d.setComposite(this.transparencia);         // el Shape que se esta pintando
        g2d.setRenderingHints(this.render);         // actualmente
        if (this.relleno)
            g2d.fill(this.geometria);
        g2d.draw(this.geometria);
    }
    
    /**
     * Metodo para obtener el rectangulo que rodea a la figura
     * @return rectangulo de tipo Rectangle que rodea a la figura
     */
    public Rectangle getBoundingBox(){
        Rectangle box = this.geometria.getBounds();
        return box;
    }
        
    /**
     * Metodo para actualizar la forma actual de la figura.
     * @param p1 - punto inicial que tendra la figura
     * @param p2 - punto final que tendra la figura
     */
    abstract public void update(Point p1, Point p2);
    
    /**
     * Metodo para mover la figura actual al punto pasado como parámetro.
     * @param p1 - punto destino de la figura.
     */
    abstract public void setLocation(Point p1);
    
    /**
     * Metodo para saber si la figura contiene al punto p
     * @param p - punto a comprobar.
     * @return true si el punto esta dentro de la figura, false para lo contrario
     */
    abstract public boolean contiene(Point p);
    
}
