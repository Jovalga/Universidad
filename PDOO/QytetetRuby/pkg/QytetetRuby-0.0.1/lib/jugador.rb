
require_relative "titulo_propiedad"
require_relative "sorpresa"
require_relative "casilla"
require_relative "tipo_casilla"
require_relative "qytetet"

module ModeloQytetet
    
  class Jugador
    def initialize(nombre)
      @encarcelado = false
      @nombre = nombre
      @saldo = 7500
      @casilla_actual = Casilla.no_titulo(0, TipoCasilla::SALIDA)
      @propiedades = Array.new
      @carta_libertad
    end
    
    attr_accessor :casilla_actual, :encarcelado
    attr_writer :carta_libertad
    
    def to_s
      puts "Nombre: #{@nombre} \n Encarcelado: #{@encarcelado} \n Saldo: #{@saldo}"
      puts "|| Casilla Actual:"
      puts @casilla_actual.to_s
      if @propiedades.empty?
        puts "Propiedades: SIN PROPIEDADES"
      else
        puts "|| Propiedades:"
        @propiedades.each do |tit|
          puts tit.to_s
        end
        puts "" #Tengo que poner esto para que el bucle funcione correctamente????
      end
    end
    
    def to_s_nombre
      puts "Nombre: #{@nombre}"
    end
    
    
    def tengo_propiedades
      if @propiedades.empty?
        return false
      else
        return true
      end
    end
    
    
    def actualizar_posicion(casilla)
      if casilla.num_casilla < @casilla_actual.num_casilla
        modificar_saldo(1000) ########### como usar la variable de qytetet saldo salida
      end
      
      tiene_propietario = false
      @casilla_actual = casilla
      
      if casilla.soy_edificable
        if casilla.tengo_propietario
          tiene_propietario = true
          if !casilla.propietario_encarcelado
            modificar_saldo(-casilla.cobrar_alquiler)
          end
        end
        
      end
      if casilla.tipo == TipoCasilla::IMPUESTO
        modificar_saldo(-100) ### Antes casilla.coste. El coste por defecto de una casilla que no es CALLE es -1 de ahi que lo cambie
      end
      return tiene_propietario
    end
    
    
    def comprar_titulo ## Como pasar el objeto this/self
      puedo_comprar = false
      if @casilla_actual.soy_edificable
        if !@casilla_actual.tengo_propietario
          if @casilla_actual.coste <= @saldo
            titulo = @casilla_actual.asignar_propietario(self) ##### Como pasar el objeto this/self
            @propiedades << titulo
            modificar_saldo(-@casilla_actual.coste)
            puedo_comprar = true
          end
        end
      end
      
      return puedo_comprar
    end
    
    
    def devolver_carta_libertad
      devolver = @carta_libertad
      @carta_libertad = nil
      return devolver
    end
    
    
    def ir_a_carcel(casilla)
      @casilla_actual = casilla
      @encarcelado = true
    end

    
    def modificar_saldo(cantidad)
      @saldo = @saldo + cantidad
    end
    
    
    def obtener_capital()
      capital = @saldo
      @propiedades.each do |titulo|
        coste = titulo.casilla.coste
        casas = titulo.casilla.num_casas
        hoteles = titulo.casilla.num_hoteles
        precio = titulo.casilla.get_precio_edificar
        capital = coste + ((casas + hoteles) * precio )
        if titulo.hipotecada
          capital = capital - titulo.hipoteca_base
        end
      end
      
      return capital.to_int;
    end
    
    
    def obtener_propiedades_hipotecadas(hipotecada)
      
      devolver_si = Array.new
      devolver_no = Array.new
      @propiedades.each do |titulo|
        if titulo.hipotecada
          devolver_si.push(titulo)
        else
          devolver_no.push(titulo)
        end
      end
      
        if hipotecada
          return devolver_si
        else
          return devolver_no
        end
              
    end
    
    
    def pagar_cobrar_por_casa_y_hotel(cantidad)
      numero_total = cuantas_casas_hoteles_tengo
      modificar_saldo(cantidad * numero_total)
    end
    
    
    def pagar_libertad(cantidad)
      tengo_saldo = tengo_saldo(cantidad)
      if tengo_saldo
        modificar_saldo(-cantidad)
      end
      return tengo_saldo
    end
    
    
    def puedo_edificar_casa(casilla)
      if es_de_mi_propiedad(casilla)
        return tengo_saldo(casilla.get_precio_edificar)
      end
      return false
    end
    
    
    def puedo_edificar_hotel(casilla)
      if es_de_mi_propiedad(casilla)
        return tengo_saldo(casilla.get_precio_edificar)
      end
      return false
    end
    
    
    def puedo_hipotecar(casilla)
      if es_de_mi_propiedad(casilla)
        return true
      else
        return false
      end
    end
    
    
    def puedo_pagar_hipoteca(casilla)
      if es_de_mi_propiedad(casilla) && @saldo >= casilla.calcular_valor_hipoteca
        return true
      else
        return false
      end
    end
    
    
    def puedo_vender_propiedad(casilla)
      devolver = false
      if es_de_mi_propiedad(casilla)
        if !casilla.esta_hipotecada
          devolver = true
        end
      end
      return devolver
    end
    
    
    def tengo_carta_libertad()
      if @carta_libertad.nil?
        return false
      else
        return true
      end
    end
    
    
    def vender_propiedad(casilla)
      precio_venta = casilla.vender_titulo
      modificar_saldo(precio_venta)
      eliminar_de_mis_propiedades(casilla)
    end
    
    
    
    private
    def cuantas_casas_hoteles_tengo
      total = 0
      @propiedades.each do |titulo|
        total = total + titulo.casilla.num_casas
        total = total + titulo.casilla.num_hoteles
      end
      return total
    end
    
    
    def eliminar_de_mis_propiedades(casilla)  ### Posible errata
      titulo = casilla.titulo                 # Cogemos el titulo de la casilla
      existe = @propiedades.include?(titulo)  # Comprobamos si existe entre las propiedades del jugador
      if existe                               # Si existe...
        @propiedades.delete(titulo)           # Lo borramos del array del propiedades
      end
    end
    
    
    def es_de_mi_propiedad(casilla)   ### Posible errata
      mio = false
      @propiedades.each do |ti|
        if casilla.titulo.eql?(ti) ## Funciona?
          mio = true
        end
      end
      return mio
    end
    
    
    def tengo_saldo(cantidad)
      if @saldo >= cantidad
        return true
      else
        return false
      end
    end
    
  end
end
