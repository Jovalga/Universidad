#encoding encoding: UTF-8
#puts "Hello World"
require_relative "sorpresa"
require_relative "tipo_sorpresa"
require_relative "tablero"
require_relative "dado"
require_relative "jugador"
require_relative "qytetet"


module ModeloQytetet
  class PruebaQytetet

    #tenemos que hacer el initialize para el mazo?
    #hay que poner self en las funciones? porqué da error llamar self?
    
    
    #def initialize()
    #  @mazo = Array.new
    #end
    
    #attr_accessor:mazo
    
    #ponemos self ya que inicializamos una variable estatica @@
    def self.inicializar_sorpresa     
      @@mazo = Array.new
      @@mazo<< Sorpresa.new("Te han dado una donacion de 150 monedas de oro", 6, TipoSorpresa::PAGARCOBRAR)
      @@mazo<< Sorpresa.new("Te has dejado el carruaje donde no debías, pagas una multa de 150 monedas de oro", 12, TipoSorpresa::PAGARCOBRAR)
      @@mazo<< Sorpresa.new("Te hemos pillado con chanclas y calcetines, lo sentimos, ¡debes ir a la Mordor!", 8, TipoSorpresa::IRACASILLA)
      @@mazo<< Sorpresa.new("La patrulla antisuperstición te lleva a la casilla 13", 10, TipoSorpresa::IRACASILLA)
      @@mazo<< Sorpresa.new("Se te ve con ganas de volver a empezar, vuelve a la casilla de salida", 18, TipoSorpresa::IRACASILLA)
      @@mazo<< Sorpresa.new("Inspección te ha pillado, pagas 50€ por cada propiedad que tengas", 16, TipoSorpresa::PORCASAHOTEL)
      @@mazo<< Sorpresa.new("Has generado muchos beneficios, por cada propiedad cobras 50 monedas de oro", 14, TipoSorpresa::PORCASAHOTEL)
      @@mazo<< Sorpresa.new("Es tu cumpleaños, cada jugador te da 20 monedas de oro", 4, TipoSorpresa::PORJUGADOR)
      @@mazo<< Sorpresa.new("Has perdido una apuesta, debes darle a cada jugador 20 monedas de oro", 2, TipoSorpresa::PORJUGADOR)
      @@mazo<< Sorpresa.new("Escapas de Mordor", 0, TipoSorpresa::SALIRCARCEL)   
    end


    #como hacer una variable array que guarde los datos para hacer un return?
     
    
    def self.mayorCero
      @@mazo.each do |i|  
        if i.valor>0
          puts i
        end
      end
      return nil
    end
    
    def self.tipoIrCasilla
      @@mazo.each do |i|
        if i.tipo==TipoSorpresa::IRACASILLA
          puts i
        end
      end
      return nil  
    end
    
    def self.queSorpresa(tiposorpresa)
      @@mazo.each do |i|
        if i.tipo==tiposorpresa
          puts i
        end
      end
      return nil   
    end
    
    
    def self.main

      ## PRUEBA PARA LAS SORPRESAS
      puts "EMPIEZO SORPRESA\n"
      sorpresa_prueba = Sorpresa.new("Sorpresa de prueba", 100, TipoSorpresa::IRACASILLA)
      puts sorpresa_prueba.to_s
      puts"FIN SORPRESA\n\n"
      
      ## PRUEBA TITULO PROPIEDAD
      puts "EMPIEZO TITULO"
      titulo_prueba = TituloPropiedad.new("titulo_prueba", 10, 1, 1000, 200)
      puts titulo_prueba.to_s
      puts "FIN PRUEBA TITULO\n\n"
      
      ## PRUEBA CASILLA
      puts "EMPIEZO CASILLA SIN TITULO"
      casilla_prueba = Casilla.no_titulo(0, TipoCasilla::JUEZ)
      puts casilla_prueba.to_s
      puts "FIN DE LA CASILLA SIN TITULO\n\n"
      puts "EMPIEZO CASILLA CON TITULO"
      casilla_prueba2= Casilla.titulo(1, 0, titulo_prueba)
      puts casilla_prueba2.to_s
      puts "FIN PRUEBA CASILLA CON TITULO\n\n"
      
      ## PRUEBA PARA JUGADOR
      puts "EMPIEZO JUGADOR"
      jugador_prueba = Jugador.new("Jorge")
      puts jugador_prueba.to_s
      puts "FIN JUGADOR \n\n"
      
      ## PRUEBA TABLERO
      puts "EMPIEZO TABLERO"
      tablero_prueba = Tablero.new
      puts tablero_prueba.to_s
      puts "FIN TABLERO\n\n"
      
      ## PRUEBAS PARA EL DADO
      puts "Prueba para el dado:"
      dado_prueba = Dado.instance
      puts dado_prueba.tirar
      puts "FIN PRUEBA DADO\n"

      ## PRUEBAS PARA QYTETET
      puts "EMPIEZO QYTETET"
      qytetet_prueba = Qytetet.instance
      puts qytetet_prueba.to_s
      puts "FIN PRUEBA QYTETET"
        
      
    end
    

  end
  #PruebaQytetet.main
  
end




#En ruby no se pueden sobrecargar los metodos
#self.new es implicito(el constructor) y tiene tanto argumentos como tenga
#el initialize
#def self.nueva_calle
 #se crean dos nuevos contructores que ninguno se llame new, y new lo 
 #hacemos privado, , y dentro de esos dos metodos (los constructores)
 #private_class_method o private
#end

#metodo de clase lleva self. antes del nombre del metodo
#self.hola(nombre)