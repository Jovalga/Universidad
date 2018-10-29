
package sm.JVG.graficos;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Clase que hereda de Figura con la funcionalidad
 * de representar un punto.
 * @author Jorge Valenzuela Garcia
 */
public class JVGPunto extends Figura {
    
    /**
     * Contructor de la clase JVGPunto
     * @param p . punto donde se creara el punto
     */
    public JVGPunto (Point p){
        this.geometria = new Line2D.Float(p,p);
    }


    @Override
    /**
     * Metodo para mover el punto actual al punto pasado como parámetro.
     * @param p - punto destino del punto.
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
     * Metodo para saber si el punto contiene al punto p
     * @param p - punto a comprobar.
     * @return true si el punto esta cerca del punto en al menos 3, false para lo contrario
     */
    public boolean contiene(Point p){
       Line2D l = (Line2D)geometria;
       return l.ptLineDist(p) < 3;
    }

    @Override
     /**
     * Metodo para actualizar la forma actual del punto.
     * @param p1 - punto inicial que tendra el punto
     * @param p2 - punto final que tendra el punto
     */
    public void update(Point p1, Point p2){
        Line2D l = (Line2D)geometria;
        l.setLine(p1,p1);}
}
