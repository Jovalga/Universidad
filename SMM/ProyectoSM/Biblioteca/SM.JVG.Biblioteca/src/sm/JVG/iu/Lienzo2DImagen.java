package sm.JVG.iu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.JVG.graficos.Figura;
import sm.image.BufferedImagePixelIterator;

/**
 * Clase que hereda de Lienzo2D que amplia sus funcionalidades
 * para poder trabajar con imagenes.
 * @author Jorge Valenzuela Garcia
 */

public class Lienzo2DImagen extends Lienzo2D{
    
    /**
     * Variable para almacenar la imagen que contendra el lienzo
     */
    private BufferedImage img;      // Variable de tipo Imagen de la clase
    
    /**
     * Metodo para asignarle una nueva imagen al lienzo
     * @param img - imagen que queremos asignar
     */
    public void setImage(BufferedImage img){
        this.img = img;
        if(img != null){
            this.setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));    // Si hay imagen se redimensionara el componente actual (Lienzo2DImagen) al tamaño de dicha imagen
            this.setAreaVisible(img.getWidth(),img.getHeight());
        }
    }
    
    /**
     * Metodo para asignarle una imagen completamente blanca al lienzo
     * @param img - imagen a asignar
     */
    public void setImageNueva(BufferedImage img){
    this.img = img;
        if(img != null){
            this.setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));    // Si hay imagen se redimensionara el componente actual (Lienzo2DImagen) al tamaño de dicha imagen
            this.setAreaVisible(img.getWidth(),img.getHeight());
            BufferedImagePixelIterator.PixelData pixel;
            WritableRaster imgRaster = img.getRaster();   // Creamos el raster de la imagen img para aplicar los pixeles nuevos
        
        // La imagen es completamente negra al crearla, asi que vamos a recorrer
        // todos sus pixeles cambiandoles el valor por blanco
            for(BufferedImagePixelIterator it = new BufferedImagePixelIterator(img); it.hasNext();) {
                pixel = it.next();
                pixel.sample[0] = 255;  // Asignamos blanco a todos
                pixel.sample[1] = 255;  // los pixeles
                pixel.sample[2] = 255;  
                imgRaster.setPixel(pixel.col, pixel.row, pixel.sample);
            }
        }
    }
    
    /**
     * Metodo que nos devuelve la imagen actual del lienzo
     * @return imagen actual del lienzo
     */
    public BufferedImage getImage(){
        return img;
    }
    
    
    /**
     * Metodo que nos devulve la imagen actual del lienzo junto a las formas que hayamos dibujado
     * @param drawVector - true si queremos que pinte las formas sobre la imagen, false para lo contrario
     * @return imagen actual del lienzo junto a las formas dibujadas
     */
    public BufferedImage getImage(boolean drawVector){
        if (drawVector){
            Graphics2D g2d = img.createGraphics();  // Creamos el Graphics2D para pintar sobre la imagen
        
    // Con este bucle conseguimos pintar encima de la imagen las Figuras guardadas hasta ahora
            for (Figura figura:vFiguras)
                figura.pintate(g2d);
            return img;
        }
        else
            return getImage();
    }
    
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img!=null){
            Graphics g2d = (Graphics2D)g;
            g2d.drawImage(img,0,0, this);
        }
    }
}
