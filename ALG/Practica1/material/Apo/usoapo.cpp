#include "apo.h"
#include <iostream>
#include <chrono>// Recursos para medir tiempos
using namespace std;
using namespace std::chrono;


void sintaxis(){
	cout << "Por favor introduzca solo como unico argumento el tamaño del arbol\n";
}



int main(int argc, char * argv[]){

if (argc != 2){
	sintaxis();    
	return 1;
}
	
  int tam = atoi(argv[1]);     // Tamaño del vector
  if (tam<=0){
	sintaxis();
    return 0;}
	  

APO<int>ap_int;	// Declaracion APO
int elemento;	// Delcaracion elemento para ir añadiendo al APO

//Creamos el arbol con tantos elementos como indique la variable tam
for(int i=0; i < tam; i++){
  srand(time(0));             // Inicialización del generador de números pseudoaleatorios
  elemento = rand() % 100;;
  ap_int.insertar(elemento);
}


//////////////////// A ANALIZAR ////////////////////////////
high_resolution_clock::time_point start,//punto de inicio
                                  end; //punto de fin
 duration<double> tiempo_transcurrido;  //objeto para medir la duracion de end 						   // y start
  
 start = high_resolution_clock::now(); //iniciamos el punto de inicio


//**************** CODIGO **********************
// Lo ideal seria usar  cout << ap_int ya que lo automatiza pero no funciona
//correctamente ya que los que muestra ese cout se mete dentro del documento
// tiempos.dat, por lo que voy simplemente a llamar a los metodos
// correspondientes

ap_int.minimo();
ap_int.borrar_minimo();

//**************** FIN CODIGO ****************************
  
 end = high_resolution_clock::now(); //anotamos el punto de de fin 
 //el tiempo transcurrido es
 tiempo_transcurrido  = duration_cast<duration<double> >(end - start);

  // Mostramos resultados
  cout << tam << "\t" <<tiempo_transcurrido.count() << endl;


}	  
