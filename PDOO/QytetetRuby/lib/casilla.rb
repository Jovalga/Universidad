#encoding :UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module ModeloQytetet
  class Casilla
    attr_reader :coste, :tipo
    attr_accessor :num_hoteles, :num_casas, :titulo, :numero_casilla
    

    def initialize(numero_casilla, tipo, cost)
      @numero_casilla = numero_casilla
      @coste = cost
      @tipo = tipo
      
      
    end
    
    def self.iniciar_casilla(numero_casilla, tipo)
      if (tipo == TipoCasilla::IMPUESTO)
        new(numero_casilla, tipo, 200)
      else
        new(numero_casilla, tipo, 0)
      end
    end
    
    
    
    def soy_edificable
      if (@tipo == TipoCasilla::CALLE)
        return true
      else
        return false
      end
    end
    
   
    
    def to_s
      if (@tipo == TipoCasilla::CALLE)
        "Numero casilla: #{@numero_casilla}\n Coste: #{@coste}\n Numero Hoteles: #{@num_hoteles}\n Numero Casas: #{@num_casas}\n Tipo: #{@tipo}\n Título propiedad: #{@titulo}"
      else
        "Numero casilla: #{@numero_casilla}\n Tipo: #{@tipo}" + (@tipo == TipoCasilla::IMPUESTO ? "\n Coste: #{@coste}" : "")

      end
    end
    
    
  end
end
