
module ModeloQytetet
  class TituloPropiedad
    
    def initialize(nombre, alquiler_base, factor_revalorizacion, hipoteca_base, precio_edificar)
      @nombre = nombre
      @hipotecada = false
      @alquiler_base = alquiler_base
      @factor_revalorizacion = factor_revalorizacion
      @hipoteca_base = hipoteca_base
      @precio_edificar = precio_edificar
      @propietario
      @casilla
    end
      
    attr_reader :alquiler_base, :factor_revalorizacion, :hipoteca_base, :nombre, :precio_edificar
    attr_accessor :hipotecada, :casilla
    attr_writer :propietario
    
    
    def to_s
      puts "Nombre #{@nombre} \n Hipotecada: #{@hipotecada} \n AlquilerBase #{@alquiler_base} \n FactorRevalorizacion #{@factor_revalorizacion} \n HipotecaBase: #{@hipoteca_base} \n PrecioEdificar #{@precio_edificar}"
      
      # Comprobamos que exista una casilla
      if @casilla.nil?
        puts "Casilla: Sin asignar"
      else
        puts "Casilla: #{@casilla.numero_casilla}"
      end
      
      # Comprobamos que exista un propietario
      if @propietario.nil?
        puts "Propietario: Sin asignar"
      else
        puts "Propietario:"
        puts @propietario.to_s_nombre
      end
    end
    
    def cobrar_alquiler(coste)
      @propietario.modificar_saldo(-coste)
    end
    
    def propietario_encarcelado()
      return @propietario.encarcelado
    end
    
    def tengo_propietario()
      if @propitario.nil?
        return false
      else
        return true
      end
     end
    
  end
end
