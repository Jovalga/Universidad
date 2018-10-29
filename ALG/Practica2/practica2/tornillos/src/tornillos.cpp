#include "tornillos.h"
#include <iostream>
#include <chrono>	// Para medir tiempos
#include <vector>	// Para vector
#include <cstdlib>  	// Para generación de números pseudoaleatorios
#include <algorithm>	// Para usar nextpermutation
using namespace std;
using namespace std::chrono;




// Metodo para informar del correcto uso del programa. (Insercion de parametros)
void sintaxis(){
	cout << "Error: Introduzca como argumento el tamaño del vector de tuercas/tornillos" << endl;
}


int main (int argc, char * argv[]){

	// Comprogamos que nos pasan como unico argumento el tamaño del vector
	if (argc != 2 ){
		sintaxis();
		return 0;
	}

	// Comprobamos que el tamaño del vector es mayor que 0
	int tam = atoi(argv[1]);     // Tamaño del vector
	if (tam <= 0){
		sintaxis();
		return 0;
	}

	
	// Creamos el vector de tornillos
	vector<int> tornillos;
  	srand(time(0));
	for (int i=0; i<tam; i++)  // Recorrer vector
   		tornillos.push_back(i);

	// Creamos el vector tuercas haciendo una permutacion del vector tornillos
	vector<int> tuercas;

	// Recorremos todos los tornillos y aleatoriamente los ponemos al inicio o al
	// final de tuercas, de esta manera los desordenamos
	for (int j = 0; j < tornillos.size() ; j++){
		if(rand() % 2 == 0)
			tuercas.push_back(j);
		else
			tuercas.insert(tuercas.begin(), j);
	}


	/*// Para mostrar las tuerca desordenadas
	for (int k = 0; k < tuercas.size() ; k++)
		cout << "Tuercas: " << tuercas[k] << endl;
	*/

	// Creamos el vector que tendrá ordenadas las tuercas (coincidiendo con los tornillos)
	vector <int> tuercas_ordenadas;


// Ya tenemos nuestros vectores, ahora pasamos a ver cuento tarda el metodo ordenarTornillos

//////////////////// A ANALIZAR ////////////////////////////

high_resolution_clock::time_point start,//punto de inicio
                                  end; //punto de fin
 duration<double> tiempo_transcurrido;  //objeto para medir la duracion de end 						   // y start
  
 start = high_resolution_clock::now(); //iniciamos el punto de inicio
 

	ordenarTornillos(tornillos,tuercas,tuercas_ordenadas);
	/*for (int i = 0; i < tuercas_ordenadas.size(); i++)
		cout << "Tuercas ordenadas: " << tuercas_ordenadas[i] << endl;*/


 end = high_resolution_clock::now(); //anotamos el punto de de fin 
 //el tiempo transcurrido es
 tiempo_transcurrido  = duration_cast<duration<double> >(end - start);

  // Mostramos resultados
  cout << tam << "\t" <<tiempo_transcurrido.count() << endl;


	return 0;


}





