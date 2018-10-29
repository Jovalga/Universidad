
package sm.JVG.graficos;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 * Clase que hereda de Figura con la funcionalidad
 * de representar una elipse.
 * @author Jorge Valenzuela Garcia
 */
public class JVGElipse extends Figura {
    /**
     * Contructor de la clase JVGElipse
     * @param p1 - Punto inicial de la diagonal de la elipse
     * @param p2 - Punto final de la diagonal de la elipse
     */
    public JVGElipse(Point p1, Point p2){
        geometria = new Ellipse2D.Float();
        ((Ellipse2D)geometria).setFrameFromDiagonal(p1, p2);
    }

    @Override
    /**
     * Metodo para mover la elipse al punto pasado como parámetro.
     * @param p - punto destino de la elipse.
     */
    public void setLocation(Point p){
        Ellipse2D e = (Ellipse2D) geometria;
        Dimension dim = new Dimension ((int)e.getWidth(), (int)e.getHeight());
        e.setFrame(p, dim);
    }

    @Override
     /**
     * Metodo para saber si la elipse contiene al punto p.
     * @param p - punto a comprobar
     * @return true si el punto esta dentro de la elipse, false para lo contrario
     */
    public boolean contiene(Point p) {
        Ellipse2D e = (Ellipse2D) geometria;
        return e.contains(p);
    }

    @Override
     /**
     * Metodo para actualizar la forma actual de la elipse.
     * @param p1 - punto inicial de la diagonal de la elipse
     * @param p2 - punto final de la diagonal de la elipse
     */
    public void update(Point p1, Point p2) {
        Ellipse2D e = (Ellipse2D)geometria;
        e.setFrameFromDiagonal(p1, p2);
    }
}
