
package interfaztextualqytetet;

import java.util.ArrayList;
import modeloqytetec.Calle;
import modeloqytetec.Casilla;
import modeloqytetec.Jugador;
import modeloqytetec.MetodoSalirCarcel;
import modeloqytetec.Qytetet;
import modeloqytetec.TipoCasilla;

/**
 * @author Jorge
 */
public class ControladorQytetet {
    
    private static Qytetet juego;
    private static Jugador jugador;
    private static Casilla casilla;
    private static VistaTextualQytetet vista = new VistaTextualQytetet();
    
    public static void inicializacionJuego() throws Exception{
        // Le damos valor al atributo Qytetet juego
        juego = Qytetet.getInstance();
        
        // Obtenemos el nombre de los jugadores por pantalla
        ArrayList<String> nombres = vista.obtenerNombreJugadores();
        
        // Inicializamos el juego con los nombres aportados
        juego.inicializarJuego(nombres);
        
        // Le damos valor al jugador actual y su casilla actual        
        jugador = juego.getJugadorActual();
        casilla = jugador.getCasillaActual();

        System.out.println("Empieza el juego\n\n");
    }
    
    public static void desarrolloJuego(){
        boolean finJuego = false;
        int turno = 1; // Contador de turnos
        while(!finJuego){
        
        // Mostrar por pantalla que jugador va a jugar y cual es su posicion
        // de partida, y despues ponerlo a jugar
        vista.mostrar("TURNO: " + Integer.toString(turno));
        vista.mostrar("Turno de:");
        vista.mostrar(jugador.toString());
        vista.mostrar("Casilla actual:");
        vista.mostrar(casilla.toString());
        
        // MOVIMIENTO CARCEL:
        // Si el jugador esta en la cárcel:
        // - Indicamos que el jugador esta en la carcel y le 
        //   damos a elegir entre los métodos de salir de la cárcel
        if(jugador.getEncarcelado()){
            vista.mostrar("Estás en la carcel");
            int opcion = vista.menuSalirCarcel();
            if(opcion == 0){ // Tira el dado
                boolean libertad = juego.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
                if(libertad)
                    vista.mostrar("Has salido de la carcel");
                else
                    vista.mostrar("No has conseguido salir de la carcel");
            }
            else{ // Paga la libertad
                boolean libertad = juego.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
                if(libertad){
                    vista.mostrar("Has pagado tu libertad. Eres libre");
                    vista.mostrar("Te quedas asi: ");
                    vista.mostrar(jugador.toString());
                }
                else
                    vista.mostrar("No tienes suficiente saldo para pagar tu libertad");
            }
        }
        
        else{ // Si no está encarcelado
            // Comprobamos si tiene propiedades y las gestionamos
            if(jugador.tengoPropiedades()){
                vista.mostrar("");
                vista.mostrar("Escoge la casilla que deseas gestionar");
                // Recogemos las casillas que son propidad del jugador y NO estan hipotecadas
                ArrayList<Casilla> propiedadesNo = juego.propiedadesHipotecadasJugador(false);
                ArrayList<Casilla> propiedadesSi = juego.propiedadesHipotecadasJugador(true);
                ArrayList<Casilla> props = new ArrayList();
                ArrayList<String> propsString = new ArrayList();
                Calle calle;
                for(Casilla casilla : propiedadesNo)
                    props.add(casilla);
                for(Casilla casilla : propiedadesSi)
                    props.add(casilla);
                for(Casilla casilla : props){
                    calle = (Calle) casilla;
                    propsString.add(calle.getTitulo().toString());
                }
                int opcionProp = vista.menuElegirPropiedad(propsString);
                Casilla cas = props.get(opcionProp);
                Calle cal = (Calle) cas;
                vista.mostrar("Que deseas hacer en la casilla:" + cal.getTitulo().toString());
                int opcionInmo = vista.menuGestionInmobiliaria();
                
                if(opcionInmo == 0) // Pasar turno
                    vista.mostrar("Pasamos turno");
                
                if(opcionInmo == 1){ // Edificar casa
                    boolean exito = juego.edificarCasa(cas);
                    if(exito)
                        vista.mostrar("Has edificado una casa en: " + cas.toString());
                    else
                        vista.mostrar("NO has edificado una casa en: " + cas.toString());
                }
                
                if(opcionInmo == 2){ // Edificar hotel
                    boolean exito = juego.edificarHotel(cas);
                    if(exito)
                        vista.mostrar("Has edificado un hotel en: " + cas.toString());
                    else
                        vista.mostrar("No has edificado un hotel en: " + cas.toString());
                }
                
                if(opcionInmo == 3){ // Vender propiedad
                    boolean exito = juego.venderPropiedad(cas);
                    if(exito)
                        vista.mostrar("Has vendido tu propiedad: " + cas.toString());
                    else
                        vista.mostrar("NO has podido vender tu propiedad en: " + cas.toString());
                }
                
                if(opcionInmo == 4){ // Hipotecar propiedad
                    boolean exito = juego.hipotecarPropiedad(cas);
                    if(exito)
                        vista.mostrar("Has hipotecado tu propiedad:" + cas.toString());
                    else
                        vista.mostrar("NO has podido hipotecar la propiedad: " + cas.toString());
                }
                
                if(opcionInmo == 5){ // Cancelar hipoteca
                    boolean exito = juego.cancelarHipoteca(cas);
                    if(exito)
                        vista.mostrar("Has cancelado tu hipoteca en: " + cas.toString());
                    else
                        vista.mostrar("NO has podido cancelar tu hipoteca en: " + cas.toString());
                }
                
                else
                    vista.mostrar("Pasamos a lanzar el dado\n");
            }

            
            
            // Una vez acabada la gestion pasamos a movernos
            // MOVIMIENTO DADO
            vista.mostrar("Lanzas el dado: ");
            boolean tienePropietario = juego.jugar();
                        
            if(tienePropietario){
                vista.mostrar("La casilla en la que has caido tiene propietario");
                vista.mostrar(jugador.getCasillaActual().toString());
                vista.mostrar("Te quedas con estas caracteristicas");
                vista.mostrar(jugador.toString());
            }
            else{
                vista.mostrar("Has caido en la casilla:");
                vista.mostrar(jugador.getCasillaActual().toString());
                if(jugador.getCasillaActual().getTipo().equals(TipoCasilla.CALLE)){
                    vista.mostrar("Quieres comprarla?");
                    boolean opcionCompra = vista.elegirQuieroComprar();
                    if(opcionCompra){
                        juego.comprarTituloPropiedad();
                    }
                    vista.mostrar("Finalmente te quedas asi:");
                    vista.mostrar(jugador.toString());
                }
                else{
                    if(jugador.getCasillaActual().getTipo().equals(TipoCasilla.CARCEL))
                        vista.mostrar("Has caido en la carcel, tranquilo, estas de visita... a menos que te haya traido un juez");
                    if(jugador.getCasillaActual().getTipo().equals(TipoCasilla.IMPUESTO))
                        vista.mostrar("Te toca pagar los impuestos");
                    if(jugador.getCasillaActual().getTipo().equals(TipoCasilla.JUEZ))
                        vista.mostrar("Mala suerte, te toca ir a la carcel");
                    if(jugador.getCasillaActual().getTipo().equals(TipoCasilla.SALIDA))
                        vista.mostrar("Cobras por dar una vuelta completa al tablero sin desfallecer");
                    if(jugador.getCasillaActual().getTipo().equals(TipoCasilla.PARKING))
                        vista.mostrar("Has caido en el parking, relájate");
                    if(jugador.getCasillaActual().getTipo().equals(TipoCasilla.SORPRESA)){
                        vista.mostrar("Has caido en una casilla de tipo Sorpresa veamos cual te ha tocado:");
                        vista.mostrar(juego.getCartaActual().toString());
                        juego.aplicarSorpresa(); // Tenemos que aplicar finalmente la sorpresa
                    }
                    vista.mostrar("Finalmente te quedas asi:");
                    vista.mostrar(jugador.toString());
                }
            }
        }
        juego.siguienteJugador();
        jugador = juego.getJugadorActual();
        casilla = jugador.getCasillaActual();
        turno++;
        System.out.println(""); // Dejamos dos espacios en blanco por turno
        System.out.println(""); // para ver mas claramente cada turno
        System.out.println("");
        
        // Comprobacion final,
        // HABRIA QUE ESCRIBIR AQUI LA CONDICION FINAL
        // DE QUE SI UN JUGADOR AL FINALIZAR SU TURNO
        // TIENE SALDO NEGATIVO, SE ACABA EL JUEGO
        // Y SE LLAMA AL METODO OBTENER RANKING
        
        }// Fin while JUEGO
    }
    
    // Metodos privados para simplificar la implementacion
    private static void elegirPropiedad(ArrayList<Casilla> propiedades){
    }
    
    
    public static void main(String[] args) throws Exception{
        inicializacionJuego();
        desarrolloJuego();
    }
}
