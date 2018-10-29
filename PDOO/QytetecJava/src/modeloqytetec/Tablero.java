
package modeloqytetec;

import java.util.ArrayList;

/**
 * @author Jorge Valenzuela García
 */
public class Tablero {
    private ArrayList<Casilla> casillas;
    private Casilla carcel;
    
    
    // CONSTRUCTORES
    public Tablero(){
        this.inicializar();
        this.carcel = this.casillas.get(11);
    }

    protected boolean esCasillaCarcel(int numeroCasilla){
        if (numeroCasilla == this.carcel.getNumeroCasilla())
            return true;
        else
            return false;
    }
    
    protected Casilla getCarcel(){
        return this.carcel;
    }
    
    protected Casilla obtenerCasillaNumero(int numeroCasilla){
        Casilla devolver = this.casillas.get(numeroCasilla);
        return devolver;
    }
    
    protected Casilla obtenerNuevaCasilla(Casilla casilla, int desplazamiento){
        int inicio = casilla.getNumeroCasilla();
        int fin = (inicio + desplazamiento) % 20;
        Casilla devolver = this.casillas.get(fin);
        return devolver;
    }
    
    private void inicializar(){        
        ArrayList<TituloPropiedad> propiedad = new ArrayList();
        propiedad.add(new TituloPropiedad("Minas morgul", 50, (float) 0.10,  150,    250));
        propiedad.add(new TituloPropiedad("Erebor", 53, (float) 0.10,  250,    300));
        propiedad.add(new TituloPropiedad("Rivendel", 58, (float) 0.11,  350,    325));
        propiedad.add(new TituloPropiedad("Gondolin", 62, (float) 0.12,  375,    350));
        propiedad.add(new TituloPropiedad("Bree", 68, (float) 0.13,  400,    400));
        propiedad.add(new TituloPropiedad("Hobbiton", 70, (float) 0.14,  500,    425));
        propiedad.add(new TituloPropiedad("Mithlond", 75, (float) 0.15,  600,    475));
        propiedad.add(new TituloPropiedad("Umbar", 83, (float) 0.16,  700,    550));
        propiedad.add(new TituloPropiedad("Osgiliath", 87, (float) 0.17,  750,    600));
        propiedad.add(new TituloPropiedad("Nogrod", 90, (float) 0.18,  800,    650));
        propiedad.add(new TituloPropiedad("Minas Tirith", 95, (float) 0.19,  950,    725));
        propiedad.add(new TituloPropiedad("Esgaroth", 100, (float) 0.20,  1000,   750));

        this.casillas = new ArrayList();
        this.casillas.add(new OtraCasilla(0, TipoCasilla.SALIDA));
        this.casillas.add(new Calle(1, 50, propiedad.get(0)));
        this.casillas.add(new OtraCasilla(2, TipoCasilla.IMPUESTO));
        this.casillas.add(new Calle(3, 100, propiedad.get(1)));
        this.casillas.add(new OtraCasilla(4, TipoCasilla.SORPRESA));
        this.casillas.add(new Calle(5, 200, propiedad.get(2)));
        this.casillas.add(new OtraCasilla(6, TipoCasilla.PARKING));
        this.casillas.add(new Calle(7, 150, propiedad.get(3)));
        this.casillas.add(new Calle(8, 50, propiedad.get(4)));
        this.casillas.add(new OtraCasilla(9, TipoCasilla.SORPRESA));
        this.casillas.add(new Calle(10, 150, propiedad.get(5)));
        this.casillas.add(new OtraCasilla(11, TipoCasilla.CARCEL));
        this.casillas.add(new Calle(12, 100, propiedad.get(6)));
        this.casillas.add(new Calle(13, 200, propiedad.get(7)));
        this.casillas.add(new OtraCasilla(14, TipoCasilla.SORPRESA));
        this.casillas.add(new Calle(15, 50, propiedad.get(8)));
        this.casillas.add(new Calle(16, 150, propiedad.get(9)));
        this.casillas.add(new OtraCasilla(17, TipoCasilla.JUEZ));
        this.casillas.add(new Calle(18, 50, propiedad.get(10)));
        this.casillas.add(new Calle(19, 100, propiedad.get(11)));
        
        // Asignamos las casillas a los titulos
        TituloPropiedad titulo;
        titulo = propiedad.get(0);
        titulo.setCasilla(this.casillas.get(1));
        titulo = propiedad.get(1);
        titulo.setCasilla(this.casillas.get(3));
        titulo = propiedad.get(2);
        titulo.setCasilla(this.casillas.get(5));
        titulo = propiedad.get(3);
        titulo.setCasilla(this.casillas.get(7));
        titulo = propiedad.get(4);
        titulo.setCasilla(this.casillas.get(8));
        titulo = propiedad.get(5);
        titulo.setCasilla(this.casillas.get(10));
        titulo = propiedad.get(6);
        titulo.setCasilla(this.casillas.get(12));
        titulo = propiedad.get(7);
        titulo.setCasilla(this.casillas.get(13));
        titulo = propiedad.get(8);
        titulo.setCasilla(this.casillas.get(15));
        titulo = propiedad.get(9);
        titulo.setCasilla(this.casillas.get(16));
        titulo = propiedad.get(10);
        titulo.setCasilla(this.casillas.get(18));
        titulo = propiedad.get(11);
        titulo.setCasilla(this.casillas.get(19));
    } 
    
    
    @Override
    public String toString(){
        String salida = "Tablero: \n";
        for (Casilla casilla : this.casillas){
            salida += casilla.toString() + "\n";
        }
        salida += "Carcel: " + this.getCarcel().toString() + "\n";
        
        return salida;
    }
    
    
    
}