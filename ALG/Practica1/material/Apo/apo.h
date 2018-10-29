#ifndef _APO_H
#define _APO_H
#include <iostream>
#include <cassert>
#include <algorithm>
using namespace std;
/**
  @file APO.H
  @doc T.D.A APO
  - Definicion
	  Una instancia \a a del T.D.A APO sobre un dominio T
	  es un arbol binario con etiquetas T y orden parcial que
	  consiste en que la etiqueta de un nodo es menor o igual
	  que la de sus descendientes. Para poder gestionarlo el tipo T
	  debe tener definida la operacion < 
  
*/

template <class T>


class APO{
	  private:
		    T *vector; /*!< zona de memoria para almacenar los nodos del arbol binario (APO) */
		    int nelementos;/*!< Numero de nodos del apo*/
		    int reservados; /*!<capacidad del vector*/
			
		    /**
		      @brief Copia de un APO
		      @param ap : apo fuente
		    */
		    void Copiar(const APO<T> &ap);
		    
		    /** 
		      @brief borrado de un APO
		      @note: libera toda las memoria asociada a vector dejando nelementos a cero y reservados a 0
		     */
		     void Borrar();
		     
		    
		    /** 
		      @brief Reasigna nueva memoria al vector 
		      @note: Mantiene los elementos n>nelementos (en caso de que n < nelementos se pierden datos)
		     */
		     void resize(int n);
		     
	  public:
		    
		  /**
		    @brief Constructor por defecto
		    
		  */
		  APO(int tam=1);

		  /**
		    @brief Constructor por copia
		    
		   */
		   APO(const APO & a);
		   
		   /**
		     @brief Destructor
		    */
		   ~APO();
		   
		   /**
		    @brief Operador de asignación
		    @param a: apo fuente
		    */
		   APO<T> & operator=(const APO &a);
		   
		   /**
		    @brief Devuelve el minimo del APO
		    @pre El APO debe tener al menos un elemento
		    */
		   const T & minimo()const;
		   
		 
		   /**
		    @brief Borrar el minimo del APO
		    */
		   void borrar_minimo();
		   
		   /**
		     @brief Inserta un nuevo elemento en el APO
		     @param e: nuevo elemento a insertar
		    */
		   void insertar(const T & e);
		   
		   /**
		      @brief Devuelve si el APO está vacío. 
		      @note true si es vacío y false en caso contrario
		     */
		   bool vacio()const;
		   
		   /**
		      @brief Elimina todos los elementos del APO
		    */
		   void clear();
		   
		   /**
		      @brief Devuelve el numero de elementos del APO
		    */
		   unsigned int size() const{ return nelementos;}
		   
		   
		   /**
		      @brief Lectura de un APO
		      @param is: flujo de entrada
		      @param ap: apo que se modifica con la lectura hecha del flujo
		      @pre el tipo T tiene que tener definido el operador de entrada
		   */
		   template <class U>
		   friend istream &operator>>(istream & is, APO<U>&ap);
		   
		   /**
		      @brief Escritura  de un APO
		      @param os: flujo de salida
		      @param ap: arbol que se escribe sobre el flujo de salida
		      @pre el tipo T tiene que tener definido el operador de salida
		   */
		   template <class U>
		   friend ostream &operator<<(ostream & os, const APO<U>&ap);
		   
		   

};
#include "apo.tpp"
#endif
		   
		   
			       
		     