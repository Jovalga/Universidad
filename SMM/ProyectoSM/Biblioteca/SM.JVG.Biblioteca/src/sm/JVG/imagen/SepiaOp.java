
package sm.JVG.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImagePixelIterator;
/**
 * Clase para aplicar el efecto Sepia a una imagen
 * @author Jorge Valenzuela Garcia
 */
public class SepiaOp extends sm.image.BufferedImageOpAdapter {
   
    /**
     * Constructor de la clase SepiaOp
     */
    public SepiaOp(){
    }
    
    /**
     * Metodo que pixel a pixel cambia la imagen aplicandole un filtro sepia.
     * @param src - imagen original a la que aplicarle los filtros
     * @param dest - imagen que obtendra los resultados de aplicar el filtro sepia
     * @return imagen con el filtro sepia aplicado
     */
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null){
            dest = createCompatibleDestImage(src, null);
        }
        BufferedImagePixelIterator.PixelData pixel;
        BufferedImagePixelIterator.PixelData pixelDest; // Variable para guardar el resultado y no modificar los valores de pixel
        WritableRaster destRaster = dest.getRaster();   // Creamos el raster de la imagen dest para aplicar los pixeles nuevos
        
        for(BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) {
            pixel = it.next();
            pixelDest = it.next(); // Hacemos que pixelDest tambien coja el valor del pixel it de la imagen src
            
            //sepiaR = min(255 , 0.393·R + 0.769·G + 0.189·B);
            pixelDest.sample[0] = (int) ((0.393 * pixel.sample[0] + 0.769*pixel.sample[1] + 0.189*pixel.sample[2]));   // Resultado % 255 para que el valor siempre este comprendido entre 0 y 255
            if (pixelDest.sample[0] > 255)  // Si el valor de R es mayor que 255 truncamos a 255 el valor que recibe
                pixelDest.sample[0] = 255;
         
            //sepiaG = min(255, 0.349·R + 0.686·G + 0.168·B);
            pixelDest.sample[1] = (int) ((0.349 * pixel.sample[0] + 0.686 * pixel.sample[1] + 0.168 * pixel.sample[2]));   // Resultado % 255 para que el valor siempre este comprendido entre 0 y 255
            if (pixelDest.sample[1] > 255)  // Si el valor de R es mayor que 255 truncamos a 255 el valor que recibe
                pixelDest.sample[1] = 255;
            
            //sepiaB = min(255, 0.272·R + 0.534·G + 0.131·B);
            pixelDest.sample[2] = (int) ((0.272 * pixel.sample[0] + 0.534 * pixel.sample[1] + 0.131 * pixel.sample[2]));   // Resultado % 255 para que el valor siempre este comprendido entre 0 y 255
            if (pixelDest.sample[2] > 255)  // Si el valor de R es mayor que 255 truncamos a 255 el valor que recibe
                pixelDest.sample[2] = 255;
            
            destRaster.setPixel(pixelDest.col, pixelDest.row, pixelDest.sample);
        }
        return dest;
    }
}
