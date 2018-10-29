
require "singleton"

module ModeloQytetet
  class Dado
    include Singleton
    
    def tirar #@ Hacer cast a entero y crear numero random 
      valor = rand(1..6)
      puts "Has lanzado el dado y ha salido: "
      puts valor
      return valor.to_int
    end
    
    def to_s
      puts "Soy un dado"
    end
    
  end
end
