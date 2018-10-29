
package sm.JVG.imagen;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;

/**
 * Clase que agrupa funcionalidades de aplicacion de filtros
 * a imagenes
 * @author Jorge Valenzuela Garcia
 */
public class Filtro{
    
    /**
     * imagen modelo para aplicar los distintos filtros
     */
    private final BufferedImage imagen;

    /**
     * Constructor de la clase Filtro
     * @param img - imagen modelo a la que aplicarles los filtros
     */
    public Filtro (BufferedImage img){
        this.imagen = img;
    }

/**
 * Metodo para emborronar levemente la imagen
 * @return imagen resultado del filtro
 */
    public BufferedImage emborronamiento_Medio(){
        float filtroMedia[] = { 0.1f, 0.1f, 0.1f,   // Matriz de emborronamiento
                                0.1f, 0.2f, 0.1f,   //          Medio
                                0.1f, 0.1f, 0.1f };
        Kernel k = new Kernel(3,3,filtroMedia);
        ConvolveOp cop = new ConvolveOp( k );
        BufferedImage imgOut = null;
        imgOut = cop.filter(imagen,imgOut);
        return imgOut;
    }

/**
 * Metodo para emborronar binomialmente la imagen
 * @return imagen resultado del filtro
 */
    public BufferedImage emborronamiento_Binomial(){
        float filtroBinomial[] =  { 0.0625f, 0.1250f, 0.0625f,   // Matriz de emborronamiento
                                    0.1250f, 0.2500f, 0.1250f,      //          Binomial
                                    0.0625f, 0.1250f, 0.0625f };
        Kernel k = new Kernel(3,3,filtroBinomial);
        ConvolveOp cop = new ConvolveOp( k );
        BufferedImage imgOut = null;
        imgOut = cop.filter(imagen,imgOut);
        return imgOut;
    }

/**
 * Metodo para enfocar mas la imagen
 * @return imagen resultado del filtro
 */
    public BufferedImage enfoque(){
        float filtroEnfoque[] ={ 0f,-1f, 0f,    // Matriz de
                                -1f, 5f,-1f,    //  Enfoque
                                 0f,-1f, 0f };
        Kernel k = new Kernel(3,3,filtroEnfoque);
        ConvolveOp cop = new ConvolveOp( k );
        BufferedImage imgOut = null;
        imgOut = cop.filter(imagen,imgOut);
        return imgOut;
    }


    /**
 * Metodo para resaltar el relieve la imagen
 * @return imagen resultado del filtro
 */
    public BufferedImage relieve(){
        float filtroRelieve[] ={-2f, 0f, 0f,  // Matriz de 
                                 0f, 1f, 0f,  //  Relieve
                                 0f, 0f, 2f };
        Kernel k = new Kernel(3,3,filtroRelieve);
        ConvolveOp cop = new ConvolveOp( k );
        BufferedImage imgOut = null;
        imgOut = cop.filter(imagen,imgOut);
        return imgOut;
    }

/**
 * Metodo para aplicar un filtro laplaciano a la imagen
 * @return imagen resultado del filtro
 */
    public BufferedImage laplaciano(){
        float filtroLaplaciano[] ={ 1f, 1f, 1f,  // Matriz de emborronamiento
                                    1f,-8f, 1f,  //          Medio
                                    1f, 1f, 1f };
        Kernel k = new Kernel(3,3,filtroLaplaciano);
        ConvolveOp cop = new ConvolveOp( k );
        BufferedImage imgOut = null;
        imgOut = cop.filter(imagen,imgOut);
        return imgOut;
    }

/**
 * Metodo para desenfocar levemente la imagen mediante el modelo de Gauss
 * @return imagen resultado del filtro
 */
    public BufferedImage gaussiano(){
        float filtroGaussiano[] ={ 0.0030f, 0.0133f, 0.0219f, 0.0133f, 0.0030f, // Matriz de emborronamiento
                                   0.0133f, 0.0596f, 0.0983f, 0.0596f, 0.0133f,  
                                   0.0219f, 0.0983f, 0.1621f, 0.0983f, 0.0219f,
                                   0.0133f, 0.0596f, 0.0983f, 0.0596f, 0.0133f, 
                                   0.0030f, 0.0133f, 0.0219f, 0.0133f, 0.0030f};
        Kernel k = new Kernel(5,5,filtroGaussiano);
        ConvolveOp cop = new ConvolveOp( k );
        BufferedImage imgOut = null;
        imgOut = cop.filter(imagen,imgOut);
        return imgOut;
    }

    /**
 * Metodo para obtener el negativo de la imagen
 * @return imagen resultado del filtro
 */
    public BufferedImage negativo(){
        byte f[] = new byte[256];
        for (int i=0; i<256; i++)
            f[i] = (byte)(255-i); // Negativo
        ByteLookupTable lt = new ByteLookupTable(0, f);
        LookupOp lop = new LookupOp(lt, null);
        BufferedImage imgOut = null;
        imgOut = lop.filter(imagen,imgOut);
        return imgOut;
    }
    
    
    /**
 * Metodo para transformar la imagen a blanco y negro
 * @return imagen resultado del filtro
 */
    public BufferedImage blanco_Y_Negro(){
        ICC_Profile ip;
        ip = ICC_Profile.getInstance(ColorSpace.CS_GRAY); // Escogemos el colorspace de blanco y negro (CS_GRAY)
        ColorSpace cs = new ICC_ColorSpace(ip);
        ColorConvertOp ccop = new ColorConvertOp(cs,null);
        BufferedImage imgOut = null;
        imgOut = ccop.filter(imagen,imgOut);
        return imgOut;
    }
}
