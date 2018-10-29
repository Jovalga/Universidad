#include "../include/PD_maximodatos.h"
#include <iostream>
#include <fstream>
#include <vector>	// Para vector
#include <limits>	// Para numeric_limits

using namespace std;


void seleccion(const vector<int> &secuencia, int suma, vector<int> & subsecuencia){

	vector<int> usados = secuencia;
	int n = secuencia.size();

// Lo primero es ordenar los valores de la secuencia
	int aux, posicion;
	int menor = numeric_limits<int>::max();

	for (int i = 0; i < n; i++){
		for (int j = i; j < n; j++){
			if (menor > usados[j]){
				menor = usados[j];
				posicion = j;
			}
		}
		aux = usados[i];
		usados[i] = menor;
		usados[posicion] = aux;
		menor = numeric_limits<int>::max();
	}



// Pasamos a crear la tabla

	int tabla[n][suma+1];

	for(int i = 0; i < n; i++){
		tabla[i][0] = 0; // La primera columna
	}

	// Rellenamos tabla
	for(int i = 0; i < n; i++){
		for (int j = 1; j<=suma; j++){
			
			int v1;						//
			if ( i-1 < 0)					// Si no se
				v1 = numeric_limits<int>::max();	//   coge
			else						//
				v1 = tabla[i-1][j];			//

			int v2;						//
			if (j - usados[i] < 0)				// Si se 
				v2 = numeric_limits<int>::max();	// coge
			else						//
				v2 = tabla[i][j-usados[i]] +1;		//
					
			tabla[i][j] = min(v1,v2);
		}				
	}


	// Obtenemos la solucion
	
	int i = n-1;
	int j = suma;

	while( i >= 0 and j>0 ){

		int v1;
		if (i-1 <= 0)
			v1 = numeric_limits<int>::max();
		else
			v1 = tabla[i-1][j];
			
		int v2;
		if(j-usados[i] < 0)
			v2 = numeric_limits<int>::max();
		else
			v2 = tabla[i][j-usados[i]] +1;

		// Añadimos solucion a subsecuencia
		if (tabla[i][j] == v2){				
			subsecuencia.push_back(usados[i]);
			j = j-usados[i];
			i = i-1;
		}		
		else
			i = i-1;
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

	for (int i = 0; i < secuencia.size(); i++)
		cerr << secuencia[i] << endl;

	// UNA VEZ TENEMOS TODO LEIDO PASAMOS A LLAMAR AL METODO SELECCION
	
	vector<int> subsecuencia;
	seleccion(secuencia, suma, subsecuencia);

	cerr << "El resultado es: " << endl;
	for (int i = 0; i < subsecuencia.size(); i++)
		cerr << subsecuencia[i] << endl;

	
	


}
