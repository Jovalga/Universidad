#encoding: utf-8

require "singleton"
require_relative "metodo_salir_carcel"
require_relative "dado"
require_relative "tablero"
require_relative "casilla"
require_relative "jugador"
require_relative "sorpresa"
require_relative "tipo_sorpresa"
require_relative "tipo_casilla"
require_relative "titulo_propiedad"

module ModeloQytetet
  class Qytetet
    include Singleton
    
      @@MAX_JUGADORES = 4
      @@MAX_CARTAS = 10
      @@MAX_CASILLAS = 20
      @@PRECIO_LIBERTAD = 2000
      @@SALDO_SALIDA = 1000
    
    def initialize
      @dado = Dado.instance
      @carta_actual
      @jugador_actual
      @tablero
      @mazo
      @jugadores
    end
    
    attr_reader :carta_actual, :jugador_actual, :SALDO_SALIDA
    
    def to_s
      #puts "Metodo aun no implementado debido a la falta de datos para una correcta inicializacion"
      puts "Maximo de jugadores: #{@@MAX_JUGADORES}"
      puts "Maximo de cartas: #{@@MAX_CARTAS}"
      puts "Maximo de casillas: #{@@MAX_CASILLAS}"
      puts "Precio de libertad: #{@@PRECIO_LIBERTAD}"
      puts "Saldo de salida: #{@@SALDO_SALIDA}"
      # puts "Aun faltan los atributos de instancia, que por falta de datos no se pueden terminar de inicilizar correctamente"
    end
    
    
    def aplicar_sorpresa
      tiene_propietario = false
      puts @carta_actual.tipo.to_s
      tipo_carta = @carta_actual.tipo
      case tipo_carta        
      when TipoSorpresa::PAGARCOBRAR
        @jugador_actual.modificar_saldo(@carta_actual.valor)
        @mazo << @carta_actual
        
      when TipoSorpresa::IRACASILLA
        numero_casilla = @carta_actual.valor
        es_carcel = @tablero.es_casilla_carcel(numero_casilla)
        if es_carcel
          encarcelar_jugador
        else
          nueva_casilla = @tablero.obtener_casilla_numero(numero_casilla)
          tiene_propietario = @jugador_actual.actualizar_posicion(nueva_casilla)
        end
        @mazo << @carta_actual
        
      when TipoSorpresa::PORCASAHOTEL
        @jugador_actual.pagar_cobrar_por_casa_y_hotel(@carta_actual.valor)
        @mazo << @carta_actual
        
      when TipoSorpresa::PORJUGADOR
        @jugadores.each do |jug|
          if !jug.eql?(@jugador_actual)
            jug.modificar_saldo(@carta_actual.valor)
            @jugador_actual.modificar_saldo(-@carta_actual.valor)
          end
        end
        @mazo << @carta_actual

      when TipoSorpresa::SALIRCARCEL
        @jugador_actual.carta_libertad = @carta_actual
      end

      return tiene_propietario
    end
    
    
    
    def cancelar_hipoteca(casilla)
      cancelar = false
      if casilla.soy_edificable
        if casilla.esta_hipotecada
          if @jugador_actual.puedo_pagar_hipoteca(casilla)
            cancelar = true
            cantidad_recibida = casilla.cancelar_hipoteca
            @jugador_actual.modificar_saldo(-cantidad_recibida)
          end
        end
      end
      return cancelar
    end
    
    
    
    def comprar_titulo_propiedad()
      @jugador_actual.comprar_titulo
    end
    
    
    
    def edificar_casa(casilla)
      puedo_edificar = false
      if casilla.soy_edificable
        if casilla.se_puede_edificar_casa
          if @jugador_actual.puedo_edificar_casa(casilla)
            coste_edificar_casa = casilla.edificar_casa
            @jugador_actual.modificar_saldo(-coste_edificar_casa)
            puedo_edificar = true
          end
        end
      end
      
      return puedo_edificar
    end
    
    
    
    def edificar_hotel(casilla)
      puedo_edificar = false
      if casilla.soy_edificable
        if casilla.se_puede_edificar_hotel
          if @jugador_actual.puedo_edificar_hotel(casilla)
            coste_edificar_hotel = casilla.edificar_hotel
            @jugador_actual.modificar_saldo(-coste_edificar_hotel)
            puedo_edificar = true
          end
        end
      end
      
      return puedo_edificar
    end
    
    
    
    def hipotecar_propiedad(casilla)
      puedo_hipotecar_propiedad = false
      if casilla.soy_edificable
        if !casilla.esta_hipotecada
          if @jugador_actual.puedo_hipotecar(casilla)
            puedo_hipotecar_propiedad = true
            cantidad_recibida = casilla.hipotecar
            @jugador_actual.modificar_saldo(cantidad_recibida)
          end
        end
      end
      
      return puedo_hipotecar_propiedad
    end
    
    
    
    def inicializar_juego(nombres)
      inicializar_jugadores(nombres)
      inicializar_cartas_sorpresa
      inicializar_tablero
      salida_jugadores
    end
    
    
    
    def intentar_salir_carcel(metodo)
      libre = false
      
      if metodo == MetodoSalirCarcel::TIRANDODADO
        valor_dado = @dado.tirar
        if valor_dado > 5
          libre = true
        end
      else
        tengo_saldo = @jugador_actual.pagar_libertad(@@PRECIO_LIBERTAD)
        if tengo_saldo
          libre = true
        end
      end
      
      if libre
        @jugador_actual.encarcelado = false
      end
      return libre
    end
    
    
    
    def jugar()
      valor_dado = @dado.tirar
      casilla_posicion = @jugador_actual.casilla_actual
      nueva_casilla = @tablero.obtener_nueva_casilla(casilla_posicion, valor_dado)
      tiene_propietario = @jugador_actual.actualizar_posicion(nueva_casilla)
      if !nueva_casilla.soy_edificable
        if nueva_casilla.tipo.eql?(TipoCasilla::JUEZ)
          encarcelar_jugador
        else
          if nueva_casilla.tipo.eql?(TipoCasilla::SORPRESA)
            @carta_actual = @mazo[0]
            @mazo.shift
          end
        end
      end
      
      return tiene_propietario
    end
    
    
    
    def obtener_ranking ## Aun sin implementar
      puts "No implementado"
    end
    
    
    
    def propiedades_hipotecadas_jugador(hipotecadas)  ### Posible error
      devolver = Array.new
      lista_propiedades = @jugador_actual.obtener_propiedades_hipotecadas(hipotecadas)
      lista_propiedades.each { |propiedad| 
        devolver.push(propiedad.casilla)}
      return devolver
    end
    
    
    
    def siguiente_jugador ### Posible error
      numero_jugadores = @jugadores.size
      numero_jugador = @jugadores.index(@jugador_actual)
      if (numero_jugador == numero_jugadores -1) ## Si es el ultimo jugador
        @jugador_actual = @jugadores[0]
      else
        @jugador_actual = @jugadores[numero_jugador +1]
      end  
    end
    
    
    
    def vender_propiedad(casilla)
      puedo_vender = false
      if casilla.soy_edificable
        puedo_vender = @jugador_actual.puedo_vender_propiedad(casilla)
        if puedo_vender
          @jugador_actual.vender_propiedad(casilla)
        end
      end
      return puedo_vender
    end
    
    
    
    
    private
    def encarcelar_jugador
      if !@jugador_actual.tengo_carta_libertad()
        carcel = @tablero.carcel
        @jugador_actual.ir_a_carcel(carcel)
      else
        carta = @jugador_actual.devolver_carta_libertad
        @mazo << carta
      end
    end
    
    
    
    def inicializar_cartas_sorpresa 
      @mazo = Array.new
      @mazo << Sorpresa.new("Te han dado una donacion de 150 monedas de oro", 150, TipoSorpresa::PAGARCOBRAR)
      @mazo << Sorpresa.new("Te has dejado el carruaje donde no debias, pagas una multa de 150 monedas de oro", -150, TipoSorpresa::PAGARCOBRAR)
      @mazo << Sorpresa.new("Te hemos pillado con chanclas y calcetines, lo sentimos, debes ir a Mordor!", 11, TipoSorpresa::IRACASILLA)
      @mazo << Sorpresa.new("La patrulla antisuperstición te lleva a la casilla 13", 13, TipoSorpresa::IRACASILLA)
      @mazo << Sorpresa.new("Se te ve con ganas de volver a empezar, vuelve a la casilla de salida", 0, TipoSorpresa::IRACASILLA)
      @mazo << Sorpresa.new("Inspección te ha pillado, pagas 50€ por cada propiedad que tengas", -50, TipoSorpresa::PORCASAHOTEL)
      @mazo << Sorpresa.new("Has generado muchos beneficios, por cada propiedad cobras 50 monedas de oro", 50, TipoSorpresa::PORCASAHOTEL)
      @mazo << Sorpresa.new("Es tu cumpleaños, cada jugador te da 20 monedas de oro", 20, TipoSorpresa::PORJUGADOR)
      @mazo << Sorpresa.new("Has perdido una apuesta, debes darle a cada jugador 20 monedas de oro", -20, TipoSorpresa::PORJUGADOR)
      @mazo << Sorpresa.new("Escapas de Mordor", 0, TipoSorpresa::SALIRCARCEL)
    end
      
    
    
    def inicializar_jugadores(nombres)
      if nombres.size >= 2 and nombres.size <= @@MAX_JUGADORES
        @jugadores = Array.new
        nombres.each do |nombre|
          @jugadores << Jugador.new(nombre)
        end
      else
        puts "Los jugadores tienen que estar en entre 2 y #{@@MAX_JUGADORES} "
      end
    end
    
    
    
    def inicializar_tablero
      @tablero = Tablero.new
    end
    
    
    
    def salida_jugadores ### Posible error
      @jugadores.each do |jug|  ## Ponemos a todos los jugadores en la casilla 0
        jug.casilla_actual = @tablero.obtener_casilla_numero(0)
      end
      posicion = rand(0..@jugadores.size-1)
      @jugador_actual = @jugadores[posicion.to_int]
    end
    
    
    
  end
end
