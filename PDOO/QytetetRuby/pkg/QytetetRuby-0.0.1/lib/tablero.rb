require_relative "sorpresa"
require_relative "tipo_sorpresa"
require_relative "casilla"
require_relative "titulo_propiedad"
require_relative "tipo_casilla"

module ModeloQytetet
  class Tablero
    def initialize
      inicializar
    end
    
    attr_reader :carcel
    
    def to_s
      @casillas.each do |i|
        puts i.to_s
      end
      puts "Carcel:"
      puts @carcel.to_s
    end
    
    def es_casilla_carcel(numero_casilla)
      if numero_casilla == @carcel.num_casilla
        return true
      else
        return false
      end
    end
    
    def obtener_casilla_numero(numero_casilla)
      devolver = @casillas[numero_casilla]
      return devolver
    end
    
    def obtener_nueva_casilla(casilla, desplazamiento)
      inicio = casilla.num_casilla
      fin = (inicio + desplazamiento) % 20
      devolver = @casillas[fin]
      return devolver
    end
    
    private
    def inicializar
      @casillas = Array.new
      @titulos = Array.new
      
      @titulos << TituloPropiedad.new("Minas_morgul", 50, 0, 0, 700);
      @titulos << TituloPropiedad.new("Erebor", 75, 0, 0, 650);
      @titulos << TituloPropiedad.new("Rivendel", 55, 0, 0, 350);
      @titulos << TituloPropiedad.new("Gondolin", 80, 0, 0, 400);
      @titulos << TituloPropiedad.new("Bree", 0, 90, 0, 575);
      @titulos << TituloPropiedad.new("Hobbiton", 60, 0, 0, 375);
      @titulos << TituloPropiedad.new("Mithlond", 75, 0, 0, 425);
      @titulos << TituloPropiedad.new("Umbar", 0, 90, 0, 475);
      @titulos << TituloPropiedad.new("Osgiliath", 95, 0, 0, 500);
      @titulos << TituloPropiedad.new("Nogrod", 0, 60, 0, 550);
      @titulos << TituloPropiedad.new("Minas_Tirith", 85, 0, 0, 600);
      @titulos << TituloPropiedad.new("Esgaroth", 65, 0, 0, 650);
        
      @casillas << Casilla.no_titulo(0, TipoCasilla::SALIDA)
      @casillas << Casilla.titulo(1, 50, @titulos[0])
      @casillas << Casilla.no_titulo(2, TipoCasilla::IMPUESTO)
      @casillas << Casilla.titulo(3, 100, @titulos[1])
      @casillas << Casilla.no_titulo(4, TipoCasilla::SORPRESA)
      @casillas << Casilla.titulo(5, 200, @titulos[2])      
      @casillas << Casilla.no_titulo(6, TipoCasilla::PARKING)
      @casillas << Casilla.titulo(7, 150, @titulos[3])
      @casillas << Casilla.titulo(8, 50, @titulos[4])
      @casillas << Casilla.no_titulo(9, TipoCasilla::SORPRESA)
      @casillas << Casilla.titulo(10, 150, @titulos[5])        
      @carcel = Casilla.no_titulo(11, TipoCasilla::CARCEL)
      @casillas << @carcel
      @casillas << Casilla.titulo(12, 100, @titulos[6])
      @casillas << Casilla.titulo(13, 200, @titulos[7])
      @casillas << Casilla.no_titulo(14, TipoCasilla::SORPRESA)
      @casillas << Casilla.titulo(15, 50, @titulos[8])
      @casillas << Casilla.titulo(16, 150, @titulos[9])
      @casillas << Casilla.no_titulo(17, TipoCasilla::JUEZ)
      @casillas << Casilla.titulo(18, 50, @titulos[10])
      @casillas << Casilla.titulo(19, 75, @titulos[11])
      
      @titulos[0].casilla = @casillas[1]
      @titulos[1].casilla = @casillas[3]
      @titulos[2].casilla = @casillas[5]
      @titulos[3].casilla = @casillas[7]
      @titulos[4].casilla = @casillas[8]
      @titulos[5].casilla = @casillas[10]
      @titulos[6].casilla = @casillas[12]
      @titulos[7].casilla = @casillas[13]
      @titulos[8].casilla = @casillas[15]
      @titulos[9].casilla = @casillas[16]
      @titulos[10].casilla = @casillas[18]
      @titulos[11].casilla = @casillas[19]
      
    end
    
  end
end
