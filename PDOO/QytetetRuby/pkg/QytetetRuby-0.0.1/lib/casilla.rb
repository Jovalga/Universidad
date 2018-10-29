require_relative "titulo_propiedad"
require_relative "tipo_casilla"

module ModeloQytetet
  class Casilla
    
    private_class_method :new # Hacemos privado el constructor
        
    def initialize(numCasilla, coste, numHoteles, numCasas, tipo, titulo)
      @num_casilla = numCasilla
      @coste = coste
      @num_hoteles = numHoteles
      @num_casas = numCasas
      @tipo = tipo
      @titulo = titulo
    end
    
    attr_reader :num_casilla, :coste, :tipo
    attr_accessor :num_hoteles, :num_casas, :titulo
    
    def self.titulo(numCasilla, coste, titulo)
      new(numCasilla, coste, 0, 0, TipoCasilla::CALLE, titulo)
    end
    
    def self.no_titulo(numCasilla, tipo)
      new(numCasilla, 0, 0, 0, tipo, nil)
    end
    
    def to_s
      if @titulo.nil?
        puts "NumeroCasilla: #{@num_casilla} \n Tipo: #{@tipo}"
      else
        puts "NumeroCasilla: #{@num_casilla} \n Coste: #{@coste} \n NumHoteles #{@num_hoteles} \n NumCasas: #{@num_casas} \n Tipo: #{@tipo} \n Titulo:"
        puts @titulo.to_s
      end
    end
    
    def asignar_propietario(jugador)
      @titulo.propietario = jugador
      return @titulo
    end
    
    
    def calcular_valor_hipoteca() # Falta hacer un cast int de cantidad_recibida ¿to_int?
      hipo_base = @titulo.hipoteca_base
      cantidad_recibida = hipo_base + ((@num_casas * 0.5 * hipo_base) + (@num_hoteles * 2 * hipo_base))
      return cantidad_recibida.to_int
    end
    
    
    def cancelar_hipoteca()
      @titulo.hipotecada = false
      cantidad_recibida = calcular_valor_hipoteca
      return cantidad_recibida.to_int;
    end
    
    
    def cobrar_alquiler() ### Hacer un cast int a coste_alquiler ¿to_int?
      coste_alquiler_base = @titulo.alquiler_base
      coste_alquiler = coste_alquiler_base + (@num_casas * 0.5) + (@num_hoteles * 2)
      @titulo.cobrar_alquiler(coste_alquiler)
      return coste_alquiler.to_int
    end
    
    
    def edificar_casa()
      @num_casas = @num_casas + 1
      return @titulo.precio_edificar
    end
    
    
    def edificar_hotel()
      @num_hoteles = @num_hoteles + 1
      return @titulo.precio_edificar
    end
    
    
    def esta_hipotecada()
      if @titulo.hipotecada
        return true
      else
        return false
      end
    end
    
    
    def get_coste_hipoteca() #### usar calcular_valor_hipoteca???
      puts "No implementado"
    end
    
    
    def get_precio_edificar()
      return @titulo.precio_edificar
    end
    
    
    def hipotecar()
      @titulo.hipotecada = true
      cantidad_recibida = calcular_valor_hipoteca
      return cantidad_recibida
    end
    
    
    def precio_total_comprar() #########
      puts "No implementado"
    end
    
    def propietario_encarcelado()
      return @titulo.propietario_encarcelado
    end
    
    def se_puede_edificar_casa()
      return @num_casas <4
    end
    
    def se_puede_edificar_hotel()
      return num_hoteles < 4
    end
    
    def soy_edificable()
      if @tipo == TipoCasilla::CALLE
        return true
      else
        return false
      end
    end
      
    def tengo_propietario()
      return @titulo.tengo_propietario
    end
    
    def vender_titulo()  
      @titulo.propietario = nil
      @num_casas = 0
      @num_hoteles = 0
      precio_compra = @coste + ((@num_casas + @num_hoteles) * @titulo.precio_edificar)
      precio_venta = precio_compra + (@titulo.factor_revalorizacion * precio_compra)
      return precio_venta
    end
    
    
    private
    def asignar_titulo_propiedad() ########
      puts "No implementado"
    end
    
  end
end
