
package sm.JVG.graficos;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Clase que hereda de Figura con la funcionalidad
 * de representar un rectangulo.
 * @author Jorge Valenzuela Garcia
 */
public class JVGRectangulo extends Figura {
    
    
    /**
     * Constructor de la clase JVGRectangulo
     * @param p1 - punto inicial de la diagonal del rectangulo
     * @param p2 - punto final de la diagonal del rectangulo
     */
    public JVGRectangulo(Point p1, Point p2){
        geometria = new Rectangle();
        ((Rectangle)geometria).setFrameFromDiagonal(p1, p2);
    }

    @Override
    /**
     * Metodo para mover el rectangulo al punto pasado como parámetro.
     * @param p - punto destino del rectangulo.
     */
    public void setLocation(Point pos){
        Rectangle r = (Rectangle) geometria;
        r.setLocation(pos);
    }

    @Override
    /**
     * Metodo para saber si el rectangulo contiene al punto p.
     * @param p - punto a comprobar
     * @return true si el punto esta dentro del rectangulo, false para lo contrario
     */
    public boolean contiene(Point p) {
        Rectangle r = (Rectangle)geometria;
        return r.contains(p);
    }

    @Override
    /**
     * Metodo para actualizar la forma actual del rectangulo.
     * @param p1 - punto inicial de la diagonal del rectangulo
     * @param p2 - punto final de la diagonal del rectangulo
     */
    public void update(Point p1, Point p2){
        Rectangle r = (Rectangle)geometria;
        r.setFrameFromDiagonal(p1, p2);
    }
    
}
