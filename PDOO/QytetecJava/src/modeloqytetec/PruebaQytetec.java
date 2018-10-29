package modeloqytetec;

import java.util.ArrayList;

/**
 * @author Jorge Valenzuela García
 */
public class PruebaQytetec {
    
    private static ArrayList<Sorpresa> mazo = new ArrayList();
    
    private static void inicializarSorpresas(){

        //Introducimos las cartas en el mazo        
        mazo.add(new Sorpresa("Tus influencias con la política te absuelven"
                + " de tus delitos" , 13 , TipoSorpresa.SALIRCARCEL));   
        mazo.add(new Sorpresa("Una réplica del huracán Irma te manda a la"
                + " casilla de salida", 1 , TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("No has sido rápido y te han pillado montando un"
                + " referendum ilegal. Vas a la cárcel" , 9 , TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("La liga anti-superstición te manda de viaje"
                + " a la casilla 13", 13 , TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("Felicidades, hoy es el dia de tu no cumpleaños,"
                + " recibes un regalo de todos", 200 , TipoSorpresa.PORJUGADOR));        
        mazo.add(new Sorpresa("Han descubierto que no es el día de tu"
                + " cumpleaños, les devuelves su dinero", 50 , TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Cae del cielo un "
                + " maletín...", 100 , TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Cae del cielo un un cobrador del"
                + " FRAC...", -100 , TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Te han pillado sirviendo comida de perro en"
                + " las cocinas de tus hoteles. Sanidad te cruje", -200 , TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("Tus contactos políticos han aumentado el valor"
                + " de tus hoteles", 300 , TipoSorpresa.PORCASAHOTEL));
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          TipoSorpresa tipo_sorpresa = TipoSorpresa.IRACASILLA;          
          /*
          // Inicializamos las sorpresas y las sacamos por pantalla
          inicializarSorpresas();
          for(Sorpresa sor : mazo){
              System.out.println(sor.toString());
          }*/
          
          //Probamos si la clase Sorpresa esta correctamente implementada
          Sorpresa sorpresa = new Sorpresa("Probando", 10, tipo_sorpresa);
          System.out.println(sorpresa.toString());
          
          //Probamos si la clase TituloPropiedad esta correctamente implementada
          TituloPropiedad titulo = new TituloPropiedad("Granada",10, (float) 0.50 ,4 ,5);
          System.out.println(titulo.toString());
          
          // Probamos la clase Casilla
          OtraCasilla casilla = new OtraCasilla(0, TipoCasilla.JUEZ);
          Calle calle = new Calle(1, 100, titulo);
          System.out.println("Para la casilla sin titulo:");
          System.out.println(casilla.toString());
          System.out.println("\nPara la casilla con titulo:");
          System.out.println(calle.toString());
          
          // Probamos la clase Jugador
          System.out.println("Para el jugador:");
          Jugador jugador = new Jugador("Jorge");
          System.out.println(jugador.toString());
          
          //Probamos la clase Tablero
          Tablero tablero = new Tablero();
          System.out.println("Para el tablero: \n");
          System.out.println(tablero.toString());
          
          // Probamos la clase dado
          Dado dado = Dado.getInstance();
          System.out.println("Para el dado:");
          System.out.println(dado.toString());
          
          // Probamos la clase Qytetet
          Qytetet juego = Qytetet.getInstance();
          System.out.println(juego.toString());
          
          
}
    
}
