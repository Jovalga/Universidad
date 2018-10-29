


module ModeloQytetet
  class Calle < Casilla
  
  attr_accessor :num_hoteles, :num_casas, :titulo
  
  def initialize(numero_casilla, cost, tituloP)
    super(numero_casilla,TipoCasilla::CALLE ,cost)
    
    @titulo = tituloP
    @num_hoteles = 0
    @num_casas = 0
    
    if @titulo != nil
      @titulo.casilla = self
    end
  end
  
    
  def calcular_valor_hipoteca
    
      hipoteca_base = @titulo.hipoteca_base
      
       cantidad_recibida = hipoteca_base + (@num_casas * 0.5 * hipoteca_base + @num_hoteles * hipoteca_base)
      
      return cantidad_recibida
    end
    
    def cancelar_hipoteca
      
      @titulo.hipotecada = false
      cantidad_pagar = calcular_valor_hipoteca * 1.1
      
      return cantidad_pagar
    end
    
    def cobrar_alquiler
      
      coste_alquiler_base = @titulo.alquiler_base
      coste_alquiler = (coste_alquiler_base + (@num_casas * 0.5 + @num_hoteles * 2))
      @titulo.cobrar_alquiler(coste_alquiler)
      
      return coste_alquiler
    end
    
    def edificar_casa
      
      nuevo_num = @num_casas + 1
      @num_casas = nuevo_num
      coste_edificar_casas = @titulo.precio_edificar
      
      return coste_edificar_casas
    end
    
    def edificar_hotel
      nuevo_num = @num_hoteles + 1
      @num_hoteles = nuevo_num
      @num_casas = 0
      coste_edificar_hotel = @titulo.precio_edificar
      
      return coste_edificar_hotel
    end
    
    def esta_hipotecada
      return @titulo.hipotecada
    end
    
    
    def get_coste_hipoteca
      return calcular_valor_hipoteca
    end
    
   
    def get_precio_edificar
      coste_edificar_casa = @titulo.precio_edificar
      
      return coste_edificar_casa
    end
    
    def hipotecar
      @titulo.hipotecada = true
      cantidad_recibida = calcular_valor_hipoteca
      
      return cantidad_recibida
    end
    
    def precio_total_comprar
      
    end
    
    def propietario_encarcelado
      encarcelado = @titulo.propietario_encarcelado
      
      return encarcelado
    end
    
    def se_puede_edificar_casa(factor)
      return @num_casas < 4 * factor
    end
    
    def se_puede_edificar_hotel(factor)
      return @num_hoteles < (4 * factor) && @num_casas == 4 * factor
    end
    
     def tengo_propietario
      tengo_propietario = @titulo.tengo_propietario
      
      return tengo_propietario
    end
    
    def vender_titulo
      precio_compra = @coste + (@num_casas + @num_hoteles) * @titulo.precio_edificar
      precio_venta = precio_compra + @titulo.factor_revalorizacion * precio_compra
      
      @titulo.propietario = nil
      @num_hoteles = 0
      @num_casas = 0
      
      return precio_venta
    end
    
    def asignar_propietario(jugador)
      @titulo.propietario = jugador
      
      return @titulo
    end
    
    def asignar_titulo_propiedad
      
    end
    
    
    def to_s
      if @titulo.nil?
        puts "NumeroCasilla: #{@numero_casilla} \n Tipo: #{@tipo}"
      else
        puts "NumeroCasilla: #{@numero_casilla} \n Coste: #{@coste} \n NumHoteles #{@num_hoteles} \n NumCasas: #{@num_casas} \n Tipo: #{@tipo} \n Titulo:"
        puts @titulo.to_s
      end
    end

    
end
end
