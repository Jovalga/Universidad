#include "../include/voraz_maximodatos.h"
#include <iostream>
#include <fstream>
#include <vector>	// Para vector
#include <chrono>	// Para medir tiempos

using namespace std;
using namespace std::chrono;


void seleccion(const vector<int> &secuencia, int suma, vector<int> & subsecuencia){
	vector <int> resultado;
	vector <int> usada = secuencia;

	int n = secuencia.size();	// Numero de elementos de la secuencia
	int mayor; 			// Sera el numero mayor que no sobrepase la suma. Buscamos asi la optimizacion
	int acumulacion = 0;		// Es el valor entero que va aculumando la suma de los valores enteros que vayamos eligiendo
	int posicion;			// Sera la posicion donde este el mayor valor, es decir, el valor que pase a acumularse
	
	while ((acumulacion < suma   or
		acumulacion != suma) and
		usada.size() > 0){ // Mientras la acumulacion de valores (suma) sea menor que el resultado o distinto del mismo...
			mayor = -1; // Antes de recorrer el vector pasamos a mayor -1, se supone que siempre tratamos con enteros positivos 
			for (int i = 0; i < n; i++){ // Creamos este bucle para encontrar el mayor elemento de secuencia que no sobrepase a suma
				if (mayor < usada[i] and usada[i] <= suma and acumulacion+usada[i] <= suma){
					mayor = usada[i];
					posicion = i;
				}
			}
			if (mayor != -1){	// Si es distinto de menos 1 quiere decir que ha encontrado un nuevo valor para la solucion
				acumulacion = mayor + acumulacion;	// Guardamos en acumulacion la suma de la anterior acumulacion con mayor
				subsecuencia.push_back(usada[posicion]);// Añadimos a la subsecuencia el valor encontrado
				usada.erase(usada.begin()+posicion);	// Borramos ese valor de usada ya que lo hemos contado ya para la suma
				n--;					// Para actualizar la informacion del bucle
			}
			else{			// Si esto ocurre es porque no se encuentran mas valores para la solucion y ya estamos en el caso mas cercano a la solucion
				acumulacion = suma+1;	// Hacemos esto para que salga del while
				cerr << "No se ha encontrado solucion" << endl;
			}
	}


}

/**
	@brief: Metodo que explica la correcta llamada al programa. Hay que pasar dos argumentos más. El fichero de texto plano donde esta la secuencia de valores enteros y el valor entero que queremos que sume el subconjunto que encontremos. 
*/
void sintaxis(){
	cout << "Por favor, pase como segundo argumento el nombre del archivo de texto plano que incluye los numeros a usar. Y como tercer argumento el resultado de la suma. Deber ser un numero positivo" << endl;
}



int main(int argc, char * argv[]){
	
	// HACEMOS COMPROBACIONES DE LOS VALORES INTRODUCIDOS
	// AL LLAMAR AL PROGRAMA
	if (argc != 3){
		sintaxis();
		return -1;
	}

	int suma = atoi(argv[2]);

	if (suma <= 0){
		cout << "Valor introducido negativo" << endl;
		return -1;
	}

	string archivo = argv[1];

	// FIN COMPROBACION
	// PASAMOS A LEER EL ARCHIVO SECUENCIA.TXT

	vector <int> secuencia;
	ifstream fichero; // Abrimos el archivo que nos han pasado por argumento
	fichero.open(archivo);
	if (fichero)
		cerr << "Archivo leido" << endl;
	else {
		cerr << "Error al leer el fichero" << endl;
		return -1;
	}

	int valor;
	while(!fichero.eof()){
		fichero >> valor;
		secuencia.push_back(valor);
	}

	fichero.close();

	for (int i = 0; i < secuencia.size(); i++)
		cerr << secuencia[i] << endl;

	// UNA VEZ TENEMOS TODO LEIDO PASAMOS A LLAMAR AL METODO SELECCION
	
	vector<int> subsecuencia;
	seleccion(secuencia, suma, subsecuencia);

	cerr << "El resultado es: " << endl;
	for (int i = 0; i < subsecuencia.size(); i++)
		cerr << subsecuencia[i] << endl;

	
	


}
