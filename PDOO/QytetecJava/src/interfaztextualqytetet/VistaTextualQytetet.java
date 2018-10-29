
package interfaztextualqytetet;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class VistaTextualQytetet {
    
private static final Scanner in = new Scanner (System.in);
    
public int menuGestionInmobiliaria(){ //ejemplo de men�
     
    this.mostrar("Elige la gestion inmobiliaria que deseas hacer");
    Map<Integer, String> menuGI = new TreeMap();
    menuGI.put(0, "No hacer nada"); // Era "Siguiente Jugador" lo he cambiado para entenderlo yo mejor
    menuGI.put(1, "Edificar casa");
    menuGI.put(2, "Edificar Hotel"); 
    menuGI.put(3, "Vender propiedad ");  	
    menuGI.put(4, "Hipotecar Propiedad"); 
    menuGI.put(5, "Cancelar Hipoteca");
    int salida = this.seleccionMenu(menuGI); // Metodo para controlar la elecci�n correcta en el men� 
    return salida;
 }

    public int menuSalirCarcel(){
        //eleccion de metodo para salir de la carcel.
        this.mostrar("Elige la opcion para salir de la carcel:");
        Map<Integer, String> menuGI = new TreeMap();
        menuGI.put(0, "Tirar el dado");
        menuGI.put(1, "Pagar la libertad ");
        int salida = this.seleccionMenu(menuGI);
        return salida;
    }
  
    public boolean elegirQuieroComprar(){
        // se pide si o no se quiere comprar una propiedad.
        this.mostrar("¿Desea comprar la propiedad?");
        Map<Integer, String> menuGI = new TreeMap();
        menuGI.put(0, "Si");
        menuGI.put(1, "No");
        int salida = this.seleccionMenu(menuGI);
        if(salida == 0)
            return true;
        else
            return false;
    }
 
        
 public int menuElegirPropiedad(ArrayList<String> listaPropiedades){  //numero y nombre de propiedades            
    Map<Integer, String> menuEP = new TreeMap();
    int numeroOpcion=0;
    for(String prop: listaPropiedades) {
        menuEP.put(numeroOpcion, prop); //opcion de menu, numero y nombre de propiedad
        numeroOpcion=numeroOpcion+1;
    }
    int salida=this.seleccionMenu(menuEP); // M�todo para controlar la elecci�n correcta en el men� 
    return salida;
 
   }   

private int seleccionMenu(Map<Integer,String> menu) 
//M�todo para controlar la elecci�n correcta de una opci�n en el men� que recibe como argumento   
{   boolean valido = true; 
    int numero;
    String lectura;
    do { // Hasta que se hace una selecci�n v�lida
      for(Map.Entry<Integer, String> fila : menu.entrySet()) {
            numero = fila.getKey();
            String texto = fila.getValue();
            this.mostrar(numero + " : " + texto);  // n�mero de opci�n y texto
      }
      this.mostrar("\n Elige una opcion: ");
      lectura = in.nextLine();  //lectura de teclado
      valido=this.comprobarOpcion(lectura, 0, menu.size()-1); //m�todo para comprobar la elecci�n correcta
    } while (!valido);
    return Integer.parseInt(lectura);
}

public ArrayList<String> obtenerNombreJugadores() { //m�todo para pedir el nombre de los jugadores
    boolean valido = true; 
    String lectura;
    ArrayList<String> nombres = new ArrayList();
    do{ //repetir mientras que el usuario no escriba un n�mero correcto 
        this.mostrar("Escribe el n�mero de jugadores: (de 2 a 4):");
        lectura = in.nextLine();  //lectura de teclado
        valido=this.comprobarOpcion(lectura, 2, 4); //m�todo para comprobar la elecci�n correcta
    }while (!valido);
    
    for (int i = 1; i <= Integer.parseInt(lectura); i++) { //solicitud del nombre de cada jugador
      this.mostrar("Nombre del jugador " + i + ": ");
      nombres.add (in.nextLine());
    }
    return nombres;
  }

 private boolean comprobarOpcion(String lectura, int min, int max){ 
//m�todo para comprobar que se introduce un entero correcto, usado por seleccion_menu
     boolean valido=true;   
     int opcion;
     try {  
          opcion =Integer.parseInt(lectura);
          if (opcion<min || opcion>max) { // No es un entero entre los v�lidos
               this.mostrar("el numero debe estar entre min y max");
                valido = false;}
        
      } catch (NumberFormatException e) { // No se ha introducido un entero
              this.mostrar("debes introducir un numero");
              valido = false;  
      }
      if (!valido) {
        this.mostrar("\n\n Seleccion erronea. Intentalo de nuevo.\n\n");
      }
      return valido;
   }

    public void mostrar(String texto){ //metodo que muestra en pantalla el string que recibe como argumento
        System.out.println(texto);
    }
 

}
 
// a�adir el siguiente m�todo a ControladorQytetet
//     public Casilla elegirPropiedad(ArrayList<Casilla> propiedades){ 
// //este metodo toma una lista de propiedades y genera una lista de strings, con el numero y nombre de las propiedades
// //luego llama a la vista para que el usuario pueda elegir.
//        vista.mostrar("\tCasilla\tTitulo");
//        int seleccion;
//        ArrayList<String> listaPropiedades= new ArrayList();
//        for ( Casilla casilla: propiedades) {
//                listaPropiedades.add( "\t"+casilla.getNumeroCasilla()+"\t"+casilla.getTituloPropiedad().getNombre()); 
//        }
//        seleccion=vista.menuElegirPropiedad(listaPropiedades);  
//        return propiedades.get(seleccion);
//         }
// 
//}
