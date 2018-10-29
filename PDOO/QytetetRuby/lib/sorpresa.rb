module ModeloQytetet
  class Sorpresa
    
    def initialize(texto, valor, tipo)
      @texto = texto
      @valor = valor
      @tipo = tipo
    end
  
    def to_s
      "Texto: #{@texto} \n Valor: #{@valor} \n Tipo #{@tipo}\n"
    end
  
      attr_reader :texto, :tipo, :valor
end

end



