#ifndef __PERMU__H
#define __PERMU__H
#include <vector>
#include <iostream>
using namespace std;
/**
   @brief T.D.A. Permutacion
   
   \b Definición:
   Una instancia \e a del tipo de dato abstracto Permutacion  sobre un dominio de enteros
   genera secuencias de valores no repetidos de 1 a n. Cada una de las secuencias se corresponden
   con una permutación de n elementos.
   
   Para poder usar el tipo de dato Permutacion se debe incluir el fichero
   
   <tt>\#include Permutacion.h</tt>
   
   El espacio requerido para el almacenamiento es O(n), donde n es la longitud de cada permutación
   
   @author Rosa Mª Rodríguez Sánchez
   @date 4 de Febrero de 2015
*/



class Permutacion{
  private:
     vector< vector<unsigned int> > datos; //< objeto para almacenar todas las permutaciones
    
    /** @brief Genera la siguiente permutacion hasta el nivel del momento
    *   @param nivel: el nivel por el que va la generacion dela permutacion
    *   @param pos: posicion en datos.
    */  
     void GenerarSiguiente( int nivel,unsigned int);

    /** @brief Comprueba si la secuencia dada hasta el nivel+1 es prefijo de una permutacion
     * @param nivel: el nivel por el que va la generacion dela permutacion
     *  @param pos: posicion en datos.
     * @return true si la secuencia actual de datos hasta nivel es una posible permutacion
     *         false en caso contrario
     * 
     */      
     bool PosiblePermutacion(int nivel,unsigned int pos);
     
     
    /** @brief Comprueba si la secuencia, ya con n elementos  dada es una permutación 
     * @param nivel: el nivel por el que va la generacion dela permutacion
     *  @param pos: posicion en datos.
     * @return true si la secuencia actual de datos es permutacion
     *         false en caso contrario
     * 
     */      
     
     bool EsPermutacion( int nivel,unsigned int pos);
     
    
     /** @brief Comprueba si la secuencia, de longitud nivel+1, se le puede poner valores diferentes en la posicion nivel.
     * @return true si se puede generar un prefijo de permutación de longitud nivel+1
     *         false en caso contrario
     * 
     */      
     bool MasHermanos( int nivel,unsigned int pos);
     
     
     
   public:
    
    /** @brief Constructor por defecto.
    * @note inicializa datos con su contructor y nivel lo pone a 0
    */ 
    Permutacion(){ }
   
   /** @brief Constructor con parametros
    * @param n : longitud de la permutacion
    * @param numero_generar: se generan tantas como diga este numero si numero_generar es menor que el maximo y mayor que 0 o el máximo posible si numero_generar es -1.  
    * @note inicializa datos con capacidad n y todos los valores inicializados a 0
    */ 
   
    Permutacion(unsigned int n,int numero_generar=-1);
   
    /** @brief Devuelve el numero de permutaciones almacenadas en el objeto

    */ 
   
    unsigned int NumeroPermutaciones()const{ return datos.size();}
    
    /** @brief Devuelve el numero de permutaciones posibles que se
     * pueden generar.
    */ 
   
    unsigned int NumeroPermutacionesPosibles()const;
    /** @brief Clase iterator Recorre las permutaciones almacenadas
     * */
  
    /** @brief Genera la siguiente permutación a la ultima y modifica esta
     ** La ultima permutacion se supone que esta en la posicion 0 y ahi es donde
     * se coloca la nueva
     * @pre al menos datos tiene que tener capacidad para almacenar un vector de 		tamaño n
     **/
    
    bool GeneraSiguiente();
    
    class iterator{
    private:
       vector<vector<unsigned int> >::iterator it;
       vector< vector<unsigned int> >::iterator final;
       vector< vector<unsigned int> >::iterator comienzo;
    public:
        iterator (){ }
        iterator & operator++(){
	    if (it==final) return *this;
	    else ++it;
	    return *this;
	}
	
	iterator & operator --(){
	  if (it==comienzo){
	    it=final;
	    return *this;
	  }
	  else --it;
	  return *this;
	}
	
	bool operator ==(const iterator & i)const{
	   return (i.it==it);
	}
	bool operator !=(const iterator & i)const{
	   return (i.it!=it);
	}  
	
	const vector<unsigned int> & operator*()const {
	   return *it;
	}
	friend class Permutacion;
    };
    
    
    
    class const_iterator{
    private:
       vector<vector<unsigned int> >::const_iterator it;
       vector< vector<unsigned int> >::const_iterator final;
       vector< vector<unsigned int> >::const_iterator comienzo;
    public:
        const_iterator (){ }
        
        const_iterator & operator++(){
	    if (it==final) return *this;
	    else ++it;
	    return *this;
	}
	
	const_iterator & operator --(){
	  if (it==comienzo){
	    it=final;
	    return *this;
	  }
	  else --it;
	  return *this;
	}
	
	bool operator ==(const const_iterator & i)const{
	   return (i.it==it);
	}
	bool operator !=(const const_iterator & i)const {
	   return (i.it!=it);
	}  
	
	const vector<unsigned int> & operator*()const {
	   return *it;
	}
	friend class Permutacion;
    };
    
    
    
    
    
    
    
    iterator begin(){
	iterator i;
	i.it=datos.begin();
	i.final = datos.end();
	i.comienzo = datos.begin();
	return i;
    }
    iterator end(){
        iterator i;
	i.it=datos.end();
	i.final = datos.end();
	i.comienzo = datos.begin();
	return i;
    }
    
    
    const_iterator begin()const{
	const_iterator i;
	i.it=datos.begin();
	i.final = datos.end();
	i.comienzo = datos.begin();
	return i;
    }
    const_iterator end()const{
        const_iterator i;
	i.it=datos.end();
	i.final = datos.end();
	i.comienzo = datos.begin();
	return i;
    }
};
#endif
	
	
	