/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.JVG.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImagePixelIterator;

/**
 * Clase con la funcionalidad de procesar una imagen
 * y aplicarle el efecto de ExponerRGB
 * @author tales
 */
public class ExponerRGB extends sm.image.BufferedImageOpAdapter{
    
    /**
     * Constructor de la clase ExponerRGB
     */
    public ExponerRGB(){
    }
    
    
    /**
     * Metodo que, para cada pixel, se queda con el valor mayor de R, G o B, es decir,
     * si dentro de un pixel el valor de R es mayor que los de G y B, se respetara
     * el valor de R pero los valores de G y B para ese pixel seran nulos.
     * @param src - imagen original
     * @param dest - imagen la cual tendra el resultado del filtro sobre la imagen original
     * @return imagen con el filtro aplicado
     */
    public BufferedImage filter(BufferedImage src, BufferedImage dest){
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null){
            dest = createCompatibleDestImage(src, null);
        }
        BufferedImagePixelIterator.PixelData pixel;
        WritableRaster destRaster = dest.getRaster();   // Creamos el raster de la imagen dest para aplicar los pixeles nuevos
        
        for(BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();){
            pixel = it.next();
            // Efecto 
            
            if (pixel.sample[0] > pixel.sample[1] && pixel.sample[0] > pixel.sample[2]){
                pixel.sample[0] = 255;
                pixel.sample[1] = 0;
                pixel.sample[2] = 0;
            }
            else{
            
                if (pixel.sample[1] > pixel.sample[0] && pixel.sample[1] > pixel.sample[2]){
                    pixel.sample[0] = 0;
                    pixel.sample[2] = 0;
                    pixel.sample[1] = 255;
                }
                else{
                    if (pixel.sample[2] > pixel.sample[0] && pixel.sample[2] > pixel.sample[1]){
                    pixel.sample[0] = 0;
                    pixel.sample[1] = 0;
                    pixel.sample[2] = 255;
                    }
                    else{   // Si tuviesen el mismo nivel en algun pixel le asignamos un valor nulo
                        pixel.sample[0] = 0;
                        pixel.sample[1] = 0;
                        pixel.sample[2] = 0;
                    }
                }
            }
            destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
        }
        return dest;
    }
    
    
}
