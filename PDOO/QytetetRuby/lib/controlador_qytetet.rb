# encoding: utf-8

require_relative "qytetet"
require_relative "vista_textual_qytetet"
require_relative "metodo_salir_carcel"
require_relative "tipo_casilla"
require_relative "tipo_sorpresa"

module InterfazTextualQytetet
  class ControladorQytetet
    #include ModeloQytetet
    
    def initialize
    end
    
    def self.inicializacion_juego
      @vista = InterfazTextualQytetet::VistaTextualQytetet.new
      puts "Se ha creado la vista"
      @juego = ModeloQytetet::Qytetet.instance
      puts "Se ha creado el objeto qytetet"
      
      nombres = Array.new
      nombres = @vista.obtener_nombre_jugadores
      
      @juego.inicializar_juego(nombres)
      @jugador = @juego.jugador_actual
      @casilla = @jugador.casilla_actual

      @vista.mostrar("EMPIEZA EL JUEGO")
      @vista.mostrar(@juego.to_s)
      @vista.esperar
    end
    
    def self.desarrollo_juego
      fin_juego = false
      turno = 1
      while(!fin_juego)
        # Mostrar por pantalla que jugador va a jugar y cual es su posicion
        # de partida, y despues ponerlo a jugar
        @vista.mostrar("TURNO:");
        @vista.mostrar(turno)
        @vista.mostrar("Turno de:");
        @vista.mostrar(@jugador.to_s);
        @vista.mostrar("Casilla actual:");
        @vista.mostrar(@casilla.to_s);
        
        # MOVIMIENTO CARCEL:
        # Si el jugador esta en la cárcel:
        # - Indicamos que el jugador esta en la carcel y le 
        #   damos a elegir entre los métodos de salir de la cárcel
        if @jugador.encarcelado
          @vista.mostrar("Estas en la carcel")
          opcion = @vista.menu_salir_carcel
          if opcion == 0
            libertad = @juego.intentar_salir_carcel(ModeloQytetet::MetodoSalirCarcel::TIRANDODADO)
            if libertad
              @vista.mostrar("Has conseguido salir de la carcel")
            else
              @vista.mostrar("NO has conseguido salir de la carcel")
            end
          else
            libertad = @juego.intentar_salir_carcel(ModeloQytetet::MetodoSalirCarcel::PAGANDOLIBERTAD)
            if libertad
              @vista.mostrar("Has conseguido salir de la carcel")
            else
              @vista.mostrar("NO has conseguido salir de la carcel")
            end
          end
        
          
        ## Si no esta encarcelado el jugador pasamos al movimiento
        else
          # Si el jugador tiene propiedades, las gestionamos
          if @jugador.tengo_propiedades
            @vista.mostrar("Escoge la casilla que deseas gestionar:")
            propiedades_no = @juego.propiedades_hipotecadas_jugador(false)
            propiedades_si = @juego.propiedades_hipotecadas_jugador(true)
            props_casillas = Array.new
            props_string = Array.new
            
            propiedades_no.each { |propiedad_no|
              props_casillas.push(propiedad_no)
            }
            
            propiedades_si.each { |propiedad_si|
              props_casillas.push(propiedad_si)
            }
            
            props_casillas.each { |prop|
              props_string.push(prop.titulo.nombre)
            }
            
            opcion_prop = @vista.menu_elegir_propiedad(props_string)
            cas = props_casillas[opcion_prop]
            @vista.mostrar("Que desea hacer en la casilla:")
            @vista.mostrar(cas.to_s)
            opcion_inmo = @vista.menu_gestion_inmobiliaria
            if opcion_inmo == 0
              @vista.mostrar("Pasamos turno")
            end
            if opcion_inmo == 1
              exito = @juego.edificar_casa(cas)
              if exito
                @vista.mostrar("Se ha edificado una casa")
              else
                @vista.mostrar("NO se ha podido edificar la casa")
              end
            end
            if opcion_inmo == 2
              exito = @juego.edificar_hotel(cas)
              if exito
                @vista.mostrar("Has edificado un hotel")
              else
                @vista.mostrar("NO se ha podido edificar un hotel")
              end
            end
            if opcion_inmo == 3
              exito = @juego.vender_propiedad(cas)
              if exito
                @vista.mostrar("Has vendido la propiedad")
              else
                @vista.mostrar("No has podido vender la propiedad")
              end
            end
            if opcion_inmo == 4
              exito = @juego.hipotecar_propiedad(cas)
              if exito
                @vista.mostrar("Has hipotecado la propiedad")
              else
                @vista.mostrar("NO has podido hipotecar la propiedad")
              end
            end
            if opcion_inmo == 5
              exito = @juego.cancelar_hipoteca(cas)
              if exito
                @vista.mostrar("Has cancelado la hipoteca de la propiedad")
              else
                @vista.mostrar("NO has podido cancelar la hipoteca de la propiedad")
              end
            end
            
          end
          
          
          # MOVIMIENTO DADO
          puts "Vas a lanzar el dado"
          tiene_propietario = @juego.jugar
          if tiene_propietario
            @vista.mostrar("La casilla en la que has caido tiene propietario")
            @vista.mostrar(@jugador.casilla_actual.to_s)
            @vista.mostrar("Te quedas con estas caracteristicas")
            @vista.mostrar(@jugador.to_s)
          else
            @vista.mostrar("Has caido en la casilla: ")
            @vista.mostrar(@jugador.casilla_actual.to_s)
            
            # Si la casilla en la que caemos es de tipo calle mostramos
            # el menu para saber si la queremos comprar o no
            if @jugador.casilla_actual.tipo.eql?(ModeloQytetet::TipoCasilla::CALLE)
              @vista.mostrar("Quieres comprarla?")
              opcion_compra = @vista.elegir_quiero_comprar
              if opcion_compra
                exito = @juego.comprar_titulo_propiedad
                if exito
                  @vista.mostrar("Has comprado la propiedad")
                else
                  @vista.mostrar("NO has comprado la propiedad")
                end
              end
              @vista.mostrar("Al final del turno te quedas asi:")
              @vista.mostrar(@jugador.to_s)
              
            ## Si la casilla en la que caemos no es de tipo calle, comprobamos
            ## de que tipo es
            else
              if @jugador.casilla_actual.tipo.eql?(ModeloQytetet::TipoCasilla::CARCEL)
                @vista.mostrar("Has caido en la carcel, tranquilo, estas de visita... a menos que te haya traido un juez")
              end
              if @jugador.casilla_actual.tipo.eql?(ModeloQytetet::TipoCasilla::IMPUESTO)
                @vista.mostrar("Te toca pagar los impuestos")
              end
              if @jugador.casilla_actual.tipo.eql?(ModeloQytetet::TipoCasilla::JUEZ)
                @vista.mostrar("El juez te manda a la carcel")
              end
              if @jugador.casilla_actual.tipo.eql?(ModeloQytetet::TipoCasilla::SALIDA)
                @vista.mostrar("Has dado un vuelta sin desfallecer, eso se merece una recompensa")
              end
              if @jugador.casilla_actual.tipo.eql?(ModeloQytetet::TipoCasilla::PARKING)
                @vista.mostrar("Estas en el parking, relajate") 
              end
              if @jugador.casilla_actual.tipo.eql?(ModeloQytetet::TipoCasilla::SORPRESA)
                @vista.mostrar("Has caido en una casilla de tipo sorpresa, veamos cual te ha tocado...")
                @vista.mostrar(@juego.carta_actual.to_s)
                @vista.mostrar("Vamos a aplicar sorpresa")
                @juego.aplicar_sorpresa
              end
              @vista.mostrar("Finalmente te quedas asi:")
              @vista.mostrar(@jugador.to_s)
            end
          end        
        
        end
          
          
        @juego.siguiente_jugador
        @jugador = @juego.jugador_actual;
        @casilla = @jugador.casilla_actual;
        turno = turno +1;
        @vista.mostrar("FIN DEL TURNO")
        @vista.esperar
      end # Fin de while del juego, de momento bucle infinito
    end
    
    
    
    def self.main
      inicializacion_juego
      desarrollo_juego
    end
    
    ControladorQytetet.main
    
  end
end