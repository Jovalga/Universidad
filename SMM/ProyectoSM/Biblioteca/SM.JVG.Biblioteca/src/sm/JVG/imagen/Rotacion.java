
package sm.JVG.imagen;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * Clase con la funcionalidad de rotar una imagen
 * @author Jorge Valenzuela Garcia
 */
public class Rotacion{

    /**
     * Imagen modelo a la que aplicarle la rotacion
     */
    private BufferedImage imagen;

    
    /**
     * Constructor de la clase rotacion
     * @param img - Imagen modelo a la que aplicarle la rotacion 
     */
    public Rotacion(BufferedImage img) {
        imagen = img;
    }
   
    /**
     * Metodo que rota la modelo de la clase en tantos grados como se indique en el parametro.
     * @param grados - numero de grados que queremos que gire la imagen
     * @return imagen rotada en los grados indicados en el parametro
     */
    public BufferedImage rotar(double grados){
        double r = Math.toRadians(grados);
        BufferedImage imagenRotada = null;
        Point p = new Point(imagen.getWidth()/2, imagen.getHeight()/2); // Hacemos que rote desde el centro
        AffineTransform at = AffineTransform.getRotateInstance(r,p.x,p.y);
        AffineTransformOp atop;
        atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
        imagenRotada = atop.filter(imagen, imagenRotada);
        return imagenRotada;
    }
}
