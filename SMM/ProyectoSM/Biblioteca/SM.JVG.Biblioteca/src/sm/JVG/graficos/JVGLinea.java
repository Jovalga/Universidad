
package sm.JVG.graficos;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Clase que hereda de Figura con la funcionalidad
 * de representar una linea.
 * @author Jorge Valenzuela Garcia
 */
public class JVGLinea extends Figura {

    /**
     * Constructor de la clase JVGLinea
     * @param p1 - punto inicial de la linea 
     * @param p2 - punto final de la linea
     */
    public JVGLinea(Point p1, Point p2){
        geometria = new Line2D.Float(p1, p2);
    }
    
    
    @Override
    /**
     * Metodo para mover la linea actual al punto pasado como parámetro.
     * @param p - punto destino de la linea.
     */
    public void setLocation(Point p){
        Line2D l = (Line2D)geometria;
        double dx = p.getX() - l.getX1();
        double dy = p.getY() - l.getY1();
        Point2D newp2 = new Point2D.Double(l.getX2() + dx , l.getY2() + dy);
        l.setLine(p,newp2);
    }

    @Override
    /**
     * Metodo para saber si la linea contiene al punto p
     * @param p - punto a comprobar.
     * @return true si el punto esta a 3.0 de la linea o menos, false si esta mas lejos de 3.0
     */
    public boolean contiene(Point p){
        Line2D l = (Line2D)geometria;
        return l.ptLineDist(p) < 3.0;
    }

    @Override
    /**
     * Metodo para actualizar la forma actual de la linea.
     * @param p1 - punto inicial que tendra la linea
     * @param p2 - punto final que tendra la linea
     */
    public void update(Point p1, Point p2) {
        Line2D l = (Line2D)geometria;
        l.setLine(p1,p2);
    }
    
}
