#encoding :UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module ModeloQytetet
  class Especulador < Jugador
    attr_reader :fianza
    
    def initialize(jugador, fianza)
      super(jugador.nombre, jugador.encarcelado, jugador.saldo, jugador.carta_libertad, jugador.propiedades, jugador.casilla_actual, 2)
      @fianza = fianza
    end
    
    def pagar_impuestos(cantidad)
      modificar_saldo(cantidad/2)
    end
    
    def convertirme(fianza)
      return self
    end
    
    def ir_a_carcel(casilla)
      evitar_carcel = pagar_fianza(@fianza)
      
      if (!evitar_carcel)
        @casilla_actual = casilla
        @encarcelado = true
      end
    end
    
    def pagar_fianza(cantidad)
      puede_pagar = false
      
      if (@saldo > @fianza)
        puede_pagar = true
        modificar_saldo(-@fianza)
      end
      
      return puede_pagar
    end

    
    def to_s
      puts "Nombre: #{@nombre} \n Encarcelado: #{@encarcelado} \n Saldo: #{@saldo}"
      puts "Fianza: #{@fianza}"
      puts "Factor especulador: #{@factor_especulador}" 
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
    
    
    protected :pagar_impuestos
    private :pagar_fianza
  end
end
