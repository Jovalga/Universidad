
package sm.JVG.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImagePixelIterator;

/**
 * Clase con la funcionalidad de crear una Umbralizacion a traves
 * de una imagen
 * @author Jorge Valenzuela Garcia
 */
    public class UmbralizacionOp extends sm.image.BufferedImageOpAdapter{

        /**
         * Variable para almacenar el umbral limite que aplicaremos a la imagen
         */
    private int umbral;
    
    /**
     * Constructor de la clase UmbralizacionOp
     * @param umbral - valor del umbral limite
     */
    public UmbralizacionOp(int umbral) {
        this.umbral = umbral;
    }
    
    /**
     * Metodo que, a partir de un umbral dado, divide entre tres la suma de sus valores RGB marcando asi aquellos
     * que superen el umbral establecido.
     * @param src - imagen original a la que aplicarle el filtro
     * @param dest - imagen a la que aplicarle el filtro de umbralizacion
     * @return imagen con el filtro de umbralizacion aplicado
     */
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (src == null){
            throw new NullPointerException("src image is null");
        }
        if (dest == null){
            dest = createCompatibleDestImage(src, null);
        }
        BufferedImagePixelIterator.PixelData pixel;
        WritableRaster destRaster = dest.getRaster();   // Creamos el raster de la imagen dest para aplicar los pixeles nuevos
        int intensidadMedia;                         // Variable para guardar la media de los componentes RGB
        
        for(BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();){
            pixel = it.next();
            
            // Umbralizacion
            intensidadMedia = (int) ((pixel.sample[0] + pixel.sample[1] + pixel.sample[2])/3);   
            if (intensidadMedia > umbral){   // Si el valor de la intensidad recogida es mayor que el umbral
                                             // el pixel recibe 255 en sus tres componentes [R,G,B]
                pixel.sample[0] = 255;  // Componente R
                pixel.sample[1] = 255;  // Componente G
                pixel.sample[2] = 255;  // Componente B
                intensidadMedia = 0;         // Le volvemos a dar 0
            }
            else{
                pixel.sample[0] = 0;  // Componente R
                pixel.sample[1] = 0;  // Componente G
                pixel.sample[2] = 0;  // Componente B
                intensidadMedia = 0;         // Le volvemos a dar 0
            }
            intensidadMedia = 0;
            destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
        }
        return dest;
    }
}
