
package sm.JVG.graficos;

import java.awt.Point;
import java.awt.geom.QuadCurve2D;

/**
 * Clase que hereda de Figura con la funcionalidad
 * de representar una curva.
 * @author Jorge Valenzuela Garcia
 */

public class JVGCurva extends Figura{
    
    /**
     * Constructor de la clase JVGCurva
     * @param p1 - punto inicial de la curva
     * @param p2 - punto de control de la curva
     * @param p3 - punto final de la curva
     */
    public JVGCurva(Point p1, Point p2, Point p3){
        geometria = new QuadCurve2D.Float();
        ((QuadCurve2D)geometria).setCurve(p1, p3, p2);
    }

    
    /**
     * Metodo para asignar un valor al punto de control de la curva.
     * @param p - nuevo punto de control de la curva.
     */
    public void asignarCurvatura(Point p){
        QuadCurve2D curva = (QuadCurve2D)geometria;
        curva.setCurve(curva.getX1(), curva.getY1(), p.getX(), p.getY(), curva.getX2(), curva.getY2());
    }
    
    
    @Override
   /**
     * Metodo para mover la curva al punto pasado como parámetro.
     * @param p1 - punto destino de la curva.
     */
    public void setLocation(Point p){
        QuadCurve2D curva = (QuadCurve2D)geometria;
        int nx = p.x - (int)curva.getX1();
        int ny = p.y - (int)curva.getY1();
        curva.setCurve(curva.getX1() + nx , curva.getY1() + ny, curva.getCtrlX()+ nx, curva.getCtrlY()+ ny, curva.getX2()+ nx, curva.getY2() + ny);
        
    }

    @Override
    /**
     * Metodo para saber si la curva contiene al punto p
     * @param p - punto a comprobar.
     * @return true si el punto esta dentro de la curva, false para lo contrario
     */
    public boolean contiene(Point p) {
        QuadCurve2D curva = (QuadCurve2D)geometria;
        return curva.contains(p);
    }

    @Override
    /**
     * Metodo para actualizar la forma actual de la actual.
     * @param p1 - punto inicial de la linea de la curva
     * @param p2 - punto final de la linea de la curva
     */
    public void update(Point p1, Point p2){
        QuadCurve2D curva = (QuadCurve2D) geometria;
        curva.setCurve(curva.getX1(),curva.getY1(),curva.getCtrlX(),curva.getCtrlY(),p2.getX(),p2.getY());
    }
    
    
}
