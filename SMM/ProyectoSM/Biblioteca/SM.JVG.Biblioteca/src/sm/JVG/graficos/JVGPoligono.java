
package sm.JVG.graficos;

import java.awt.Point;
import java.awt.Polygon;

/**
 * Clase que hereda de Figura con la funcionalidad
 * de representar un poligono.
 * @author Jorge Valenzuela Garcia
 */
public class JVGPoligono extends Figura{
    
    /**
     * Constructor de la clase JVGPoligono.
     * @param p - punto del primer vertice del poligono
     */
    public JVGPoligono (Point p){
        geometria = new Polygon();
        ((Polygon)geometria).addPoint(p.x, p.y);
    }
    
    /**
     * Metodo para añadir un vertice mas al poligono actual.
     * @param p - punto a añadir al poligono
     */
    public void addVertice(Point p){
        Polygon poly = (Polygon)geometria;
        poly.addPoint(p.x, p.y);
    }

    @Override
    /**
     * Metodo para mover el poligono al punto pasado como parámetro.
     * @param p - punto destino del poligono.
     */
    public void setLocation(Point p){
        Polygon poly = (Polygon)geometria;
        int nx = p.x - poly.getBounds().x;
        int ny = p.y - poly.getBounds().y;

        poly.translate(nx,ny);
    }

    @Override
    /**
     * Metodo para saber si el poligono contiene al punto p.
     * @param p - punto a comprobar
     * @return true si el punto esta dentro del poligono, false para lo contrario
     */
    public boolean contiene(Point p){
        Polygon poligono = (Polygon)geometria;
        return poligono.contains(p);
    }

    @Override
    /**
     * Metodo para actualizar la forma actual del poligono.
     * @param p1 - punto inicial donde quedara el poligono
     * @param p2 - punto final donde quedara el poligono
     */
    public void update(Point p1, Point p2) {
        Polygon poligono = (Polygon)geometria;
        poligono.xpoints[poligono.npoints-1] = (int) p2.getX();
        poligono.ypoints[poligono.npoints-1] = (int) p2.getY();
    }


}
