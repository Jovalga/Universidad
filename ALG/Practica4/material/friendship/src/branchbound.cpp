#include "../include/Apermutacion.h"	
#include "Apermutacion.cpp"		
#include <iostream>
#include <fstream>
#include <vector>	// Para vector
#include <chrono>	// Para medir tiempos
#include <limits>	// Para numeric_limits


using namespace std;
using namespace std::chrono;

template <class T>
ostream & operator<<(ostream &os, const vector<T> & d){
   for (int i=0;i<d.size();i++)
      os<<d[i]<<" ";
   os<<endl;
   return os;
}


int cotaInferior(vector<int> usados, int persona, int personas, int npre, vector<int> secuencia){
	int cota_inferior = numeric_limits<int>::max();
	bool usado = false;
	int discrepancia;
	int diferencia;

	// Bucle para recorrer a todas las personas
	for (int i = 0; i < personas; i++){
			
		if (persona != i){ // Comprobamos que comparemos con la persona en si
			
			for (int z = 0; z < usados.size(); z++) // Vemos si ya estamos usando a esta persona
				if (usados[z] == i)		// Si la persona que vamos a comparar ya esta en i,
					usado = true;		// indicamos que esta usada para no comparar
		
			
			if (!usado){ // Si aun no hemos comparado con esta persona...
				usado = false; // Devolvemos false para la siguiente iteracion
				usados.push_back(i); // Guardamos a i como persona ya comparada

				discrepancia = 0;
					
				// Hallamos la discrepancia
				for ( int p = 0; p < npre; p++){
					diferencia = secuencia[(persona*npre)+p] - secuencia[(i*npre)+p];
				
					if (diferencia < 0) // Pasamos a valor absoluto
						diferencia = -diferencia;

					discrepancia = discrepancia + diferencia;
				}
			
				if (discrepancia < cota_inferior)
					cota_inferior = discrepancia;
				discrepancia = 0;
			}
		}
	}
	return cota_inferior;
}





int cotaSuperior(vector<int> usados, int persona, int personas, int npre, vector<int> secuencia){
	int cota_superior = 0;
	bool usado = false;
	int discrepancia;
	int diferencia;

	// Bucle para recorrer a todas las personas
	for (int i = 0; i < personas; i++){
			
		if (persona != i){ // Comprobamos que comparemos con la persona en si
			
			for (int z = 0; z < usados.size(); z++) // Vemos si ya estamos usando a esta persona
				if (usados[z] == i)		// Si la persona que vamos a comparar ya esta en i,
					usado = true;		// indicamos que esta usada para no comparar
			
			if (!usado){ // Si aun no hemos comparado con esta persona...
				usado = false; // Devolvemos false para la siguiente iteracion
				usados.push_back(i); // Guardamos a i como persona ya comparada

				discrepancia = 0;
					
				// Hallamos la discrepancia
				for ( int p = 0; p < npre; p++){
					diferencia = secuencia[(persona*npre)+p] - secuencia[(i*npre)+p];
				
					if (diferencia < 0) // Pasamos a valor absoluto
						diferencia = -diferencia;

					discrepancia = discrepancia + diferencia;
				}
			
				if (discrepancia > cota_superior)
					cota_superior = discrepancia;
				discrepancia = 0;
			}
		}
	}
	return cota_superior;
}




void getSecuencia(const Apermutacion & P, int & personas){	// Modificamos el metodo MuestraSecuencia
	Apermutacion::const_iterator it;				// y guardamos en un vector <int>
										// las personas afectadas en la permutacion								
  	for (it=P.begin();it!=P.end();++it)
		personas++;
	}




void branchBound(int nper, int npre, vector<int> secuencia){

	Apermutacion P(nper);
	Apermutacion Q(nper);
  	cout << "El numero total de secuencias sin restricciones extras: " << P.NumeroSecuenciasPosibles()<<endl;

	int diferencia = 0;
	int diferenciaTotal = 0;
	int discrepancia = 0;
	int discrepanciaAnterior = numeric_limits<int>::max();
	int discrepanciaAcumulada = 0;
	int cota_inferior = numeric_limits<int>::max();
	int cota_superior = 0;
	int estimada = numeric_limits<int>::max();
	int estimadatemp = numeric_limits<int>::max();
	vector<int> mejores_nodos;
	int mejor_nodo;
	vector<vector<int>> hijos;
	int level = 0;
	bool usado = false;
	int nodos = 0;
	
	Apermutacion::const_iterator it;	// Iterador para P
	int personas = 0;			// Numero de personas que tenemos en la permutacion actual
	vector<int> parejas;			// Vector para guardar a las parejas escogidas por el algoritmo
	vector<int> usados;			// Vector usado para encontrar la cota inferior de los individuos libres
	int persona; 				// int para representar a una persona en si
	int persona2;				// int para representar a una persona en si distinta
	bool backtrack;


	do{
		
		// Recorremos todos los nodos desde el nivel inicial y vamos guardando el mejor nodo
		for ( int i = 0; i < nper; i++){
	
			for (int j = 0; j < usados.size(); j++){
				if (i == usados[j])
					usado = true;
			}
		
			if (!usado){
			 			
				cota_inferior = cotaInferior(usados, i, nper, npre, secuencia);
				cota_superior = cotaSuperior(usados, i, nper, npre, secuencia);
				estimadatemp = (cota_superior + cota_inferior) /2;

				if (estimada > estimadatemp){
					estimada = estimadatemp;
					mejor_nodo = i;
				}
			}
			usado = false;
		}

		//level = P.GetLevel()+1;
		mejores_nodos.push_back(mejor_nodo);
		usados.push_back(mejor_nodo);
		//Apermutacion P(mejores_nodos, level);
		//hijos = P.GeneraHijos();
		//cerr << "Mejor nodo : " << mejor_nodo << endl;
		//cerr << "Cota estimada : " << estimada << endl;

		cota_inferior = numeric_limits<int>::max();
		cota_superior = 0;
		estimada = numeric_limits<int>::max();


	
  	}while (usados.size() < nper);


	// Una vez hemos hallado los mejores nodos, vemos la discrepancia entre ellos
	discrepancia = 0;
	for (int i = 0; i < nper; i+=2){
		for ( int p = 0; p < npre; p++){
			diferencia = secuencia[(mejores_nodos[i]*npre)+p] - secuencia[(mejores_nodos[i+1]*npre)+p];
					
			if (diferencia < 0) // Pasamos a valor absoluto
				diferencia = -diferencia;

			discrepancia = discrepancia + diferencia;
		}
	}

	for (int i = 0; i < nper; i+=2)
		cout << "Pareja de: " << mejores_nodos[i] << " es: " << mejores_nodos[i+1] << endl;
	cerr << "Discrepancia: " << discrepancia << endl;


	// Una vez tenemos la discrepancia inicial de los primeros nodos pasamos a comprobar con el resto



  	//}while (P.GeneraSiguienteProfundidad());

				
	/*cout << "Nodos explorados: " << nodos << endl;
	for (int z = 0; z < parejas.size(); z++){
		cout << "Pareja de: " << parejas[z] << " es: " << parejas[z+1] << endl;
		z++;
	}
	cout << "Discrepancia: " << discrepanciaAnterior << endl;
	*/
}



void sintaxis(){
	cout << "Pase como unico argumento la direccion del archivo." << endl;
}

int main(int argc, char * argv[]){

	if (argc != 2){
		sintaxis();
		return 0;
	}

	string archivo = argv[1];

	// FIN COMPROBACION
	// PASAMOS A LEER EL ARCHIVO SECUENCIA.TXT

	int nper;
	int npre;
	string frase;
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

	int num = 0;
	while(!fichero.eof()){
		if (num == 0){
			getline(fichero,frase);
			num++;
		}

		if (num == 1){
			fichero >> nper;
			num++;
		}
		if (num == 2){
			fichero >> npre;
			num++;
		}
		else{
			fichero >> valor;
			secuencia.push_back(valor);
		}
	}

	fichero.close();

	cout << "Tenemos " << nper << " personas y " << npre << " preguntas" << endl;

	branchBound(nper, npre, secuencia);


}
