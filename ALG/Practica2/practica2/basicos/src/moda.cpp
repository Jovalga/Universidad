#include "moda.h"
#include <iostream>
#include <chrono>	// Para medir tiempos
#include <utility>	// Para pair
#include <vector>	// Para vector
#include <cstdlib>  	// Para generación de números pseudoaleatorios
using namespace std;
using namespace std::chrono;




void sintaxis(){
	cout << "Error: Pase como unico argumento el tamaño del vector\n";
}


int main(int argc , char * argv[]){
	
if (argc != 2){
	sintaxis();
	return 0;
}

int tam = atoi(argv[1]);     // Tamaño del vector
	if (tam <= 0){
		sintaxis();
		return 0;
	}


	vector<int> v;
  	int valor;
  	srand(time(0));             // Inicialización del generador de números pseudoaleatorios
  	for (int i=0; i<tam; i++){  // Recorrer vector
 		valor = rand() % 100;
   		v.push_back(valor);
	}


// Ya tenemos nuestro vector, ahora pasamos a ver cuento tarda el metodo Max_Min

//////////////////// A ANALIZAR ////////////////////////////

high_resolution_clock::time_point start,//punto de inicio
                                  end; //punto de fin
 duration<double> tiempo_transcurrido;  //objeto para medir la duracion de end 						   // y start
  
 start = high_resolution_clock::now(); //iniciamos el punto de inicio
 

	pair<int,int> moda = Moda(v);

  
 end = high_resolution_clock::now(); //anotamos el punto de de fin 
 //el tiempo transcurrido es
 tiempo_transcurrido  = duration_cast<duration<double> >(end - start);

  // Mostramos resultados
  cout << tam << "\t" <<tiempo_transcurrido.count() << endl;


	return 0;
}
