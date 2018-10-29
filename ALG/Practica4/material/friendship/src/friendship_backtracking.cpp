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


	void getSecuencia(const Apermutacion & P, int & personas){	// Modificamos el metodo MuestraSecuencia
  		Apermutacion::const_iterator it;				// y guardamos en un vector <int>
										// las personas afectadas en la permutacion								
  		for (it=P.begin();it!=P.end();++it)
			personas++;	
	}


/**	
	@brief Metodo que nos devuelve la cota inferior, siendo la cota inferior
		la discrepancia minima entre las personas de una secuencia dada
	@param usados: vector<int> que contiene las personas que ya han sido emparejadas para la busqueda esta cota
	@param persona: persona que vamos a comparar con el resto
	@param personas: numero de personas totales incluidas en la secuencia
	@param npre: numero de preguntas de la secuencia
	@param secuencia: secuencia de tamaño personas*npre, que incluye las respuestas de todos las personas del grupo
*/
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



/** @brief Metodo que nos realiza por la técnica backtracking las parejas con menor discrepancia
	@param nper: el numero de personas del archivo.txt pasado como parametro
	@param npre: numero de preguntas hechas a cada persona
	@param secuencia: numero de elementos npre*nper 
*/
void backTracking(int nper, int npre, vector<int> secuencia){

	Apermutacion P(nper);
  	cout << "El numero total de secuencias sin restricciones extras: " << P.NumeroSecuenciasPosibles()<<endl;
	
	int diferencia = 0;
	int diferenciaTotal = 0;
	int discrepancia = 0;
	int discrepanciaAnterior = numeric_limits<int>::max();
	int discrepanciaAcumulada = 0;
	int discrepanciaMinima = numeric_limits<int>::max(); // Esta sera la cota inferior
	int nodos = 0;
	vector<duration<double>>tiempos;
	duration<double> tiempo_medio;
	duration<double> tiempo;
	
	Apermutacion::const_iterator it;	// Iterador para P
	int personas = 0;			// Numero de personas que tenemos en la permutacion actual
	vector<int> parejas;			// Vector para guardar a las parejas escogidas por el algoritmo
	int persona; 				// int para representar a una persona en si
	int persona2;				// int para representar a una persona en si distinta

	do{

	high_resolution_clock::time_point start, end;
 	duration<double> tiempo_transcurrido;
  
 	start = high_resolution_clock::now(); //iniciamos el punto de inicio


		getSecuencia(P,personas);	// Cogemos las personas involucradas

	if (personas % 2 == 0){ // Asi nos aseguramos que estamos comprobando 1, 2 o 3 parejas

		// Hallamos la discrepancia de esta permutacion
		for ( int i = 0; i < personas; i+=2){
			persona  = P[i]-1; 	// Hay que restarle uno para que la persona sea a partir de 0 y encaje
			persona2 = P[i+1]-1;	// con la estructura secuencia, la cual parte de 0

			for (int p = 0; p < npre; p++){
				diferencia = secuencia[(persona*npre)+p] - secuencia[(persona2*npre)+p];
					
				if (diferencia < 0) // Pasamos a valor absoluto
					diferencia = -diferencia;
				
				diferenciaTotal += diferencia;
			}
				discrepancia = discrepancia + diferenciaTotal;
				diferenciaTotal = 0;
		}

		// Como estamos en el caso del backtracking simple, simplemente
		// esperamos a que todas las parejas aparezcan en la permutacion
		if (personas == nper){

			// Si tenemos mejor discrepancia en este conjunto de parejas
			// pasamos a guardarlas en el vector parejas
			if (discrepanciaAnterior > discrepancia){
				discrepanciaAnterior = discrepancia;
				parejas.clear(); // Limpiamos las parejas que podria haber antes					
				for ( int j = 0; j < personas; j++)
					parejas.push_back(P[j]);
			}
		}
	}

	discrepancia = 0;
	personas = 0;
	nodos++;

 	end = high_resolution_clock::now(); //anotamos el punto de de fin 
	tiempo_transcurrido  = duration_cast<duration<double> >(end - start);
	tiempos.push_back(tiempo_transcurrido);

  	}while (P.GeneraSiguienteProfundidad());

				
	cout << "Nodos explorados: " << nodos << endl;
	for (int z = 0; z < parejas.size(); z++){
		cout << "Pareja de: " << parejas[z] << " es: " << parejas[z+1] << endl;
		z++;
	}
	cout << "Discrepancia: " << discrepanciaAnterior << endl;
	


	for(int i = 0 ; i < tiempos.size(); i++){
		tiempo += tiempos[i];
	}
	tiempo_medio = tiempo / tiempos.size();
  	cout << "Tiempo medio por nodo: " << tiempo_medio.count() << endl;
}

////////////////////////////////////////////////////************************************************************************//////////////////////////////////////





void backTrackingPoda(int nper, int npre, vector<int> secuencia){

	Apermutacion P(nper);
	Apermutacion Q(nper);
  	cout << "El numero total de secuencias sin restricciones extras: " << P.NumeroSecuenciasPosibles()<<endl;

	int diferencia = 0;
	int diferenciaTotal = 0;
	int discrepancia = 0;
	int discrepanciaAnterior = numeric_limits<int>::max();
	int discrepanciaAcumulada = 0;
	int cota_inferior = numeric_limits<int>::max();
	int nodos = 0;
	vector<duration<double>>tiempos;
	duration<double> tiempo_medio;
	duration<double> tiempo;
	
	Apermutacion::const_iterator it;	// Iterador para P
	int personas = 0;			// Numero de personas que tenemos en la permutacion actual
	vector<int> parejas;			// Vector para guardar a las parejas escogidas por el algoritmo
	vector<int> usados;			// Vector usado para encontrar la cota inferior de los individuos libres
	int persona; 				// int para representar a una persona en si
	int persona2;				// int para representar a una persona en si distinta
	bool backtrack;


	do{

	high_resolution_clock::time_point start, end;
 	duration<double> tiempo_transcurrido;
  
 	start = high_resolution_clock::now(); //iniciamos el punto de inicio

		getSecuencia(P,personas);	// Cogemos las personas involucradas

	if (personas % 2 == 0){ // Asi nos aseguramos que estamos comprobando 1, 2 o n parejas

		// Hallamos la discrepancia de esta permutacion
		for ( int i = 0; i < personas; i+=2){
			persona  = P[i]-1; 	// Hay que restarle uno para que la persona sea a partir de 0 y encaje
			persona2 = P[i+1]-1;	// con la estructura secuencia, la cual parte de 0

			for (int p = 0; p < npre; p++){
				diferencia = secuencia[(persona*npre)+p] - secuencia[(persona2*npre)+p];
					
				if (diferencia < 0) // Pasamos a valor absoluto
					diferencia = -diferencia;
				
				diferenciaTotal += diferencia;
			}
				discrepancia = discrepancia + diferenciaTotal;
				diferenciaTotal = 0;
		}

		
		// Comprobamos si nos pasamos para podar o no
		
		if (discrepancia > discrepanciaAnterior){
			Q=P;
			backtrack = P.Backtracking();
			if (!backtrack)	// Si no hay exito en el backtrack pasamos devolvemos el valor anterior de la permutacion
				P=Q;
		}
		else{ // Si no nos pasamos
		// Si tenemos mejor discrepancia en este conjunto de parejas
		// pasamos a guardarlas en el vector parejas
			if (discrepanciaAnterior > discrepancia and personas == nper){
				discrepanciaAnterior = discrepancia;
				parejas.clear(); // Limpiamos las parejas que podria haber antes					
				for ( int j = 0; j < personas; j++)
					parejas.push_back(P[j]);
			}
		}
	}

	else{ // Si P%2 != 0, hay que encontrar la cota inferior de el individuo libre de P

		usados.clear();	// Limpiamos usados
		for (int i = 0; i < personas; i++){ // Agregamos a usados a las personas que ya estan en pareja
			if (i == personas-1) // La ultima iteracion sera la persona libre del conjunto			
				persona = P[i]-1;
			else
				usados.push_back(P[i]-1);
		}

		// Llamamos al metodo cotaInferior pasando como parametro las personas usadas, es decir,
		// las que ya hemos comparado en esta permutacion, pasamos la persona libre de la cual
		// queremos hallar la cota inferior, pasamos el numero de preguntas totales, el numero de
		// personas totales y la secuencia con todas las respuestas de todos
		
		cota_inferior = cotaInferior (usados, persona, nper, npre, secuencia);

		if (personas == 1)
			discrepancia = cota_inferior;
		else{
			// Hallamos la discrepancia de esta permutacion
			for ( int i = 0; i < personas; i+=2){
				
				if (i == personas-1) // cuando nos quede la persona libre...
					discrepancia += cota_inferior;
				else{
					persona  = P[i]-1; 	// Hay que restarle uno para que la persona sea a partir de 0 y encaje
					persona2 = P[i+1]-1;	// con la estructura secuencia, la cual parte de 0
	
					for (int p = 0; p < npre; p++){
						diferencia = secuencia[(persona*npre)+p] - secuencia[(persona2*npre)+p];
						
						if (diferencia < 0) // Pasamos a valor absoluto
							diferencia = -diferencia;
					
						diferenciaTotal += diferencia;
					}
					discrepancia = discrepancia + diferenciaTotal;
					diferenciaTotal = 0;
				}
			}
		}
		
		// Comprobamos si nos pasamos para podar o no		
		if (discrepancia > discrepanciaAnterior){
			Q=P;
			backtrack = P.Backtracking();
			if (!backtrack)	// Si no hay exito en el backtrack pasamos devolvemos el valor anterior de la permutacion
				P=Q;
		}
	}

	discrepancia = 0;
	personas = 0;
	nodos++;

	end = high_resolution_clock::now(); //anotamos el punto de de fin 
	tiempo_transcurrido  = duration_cast<duration<double> >(end - start);
	tiempos.push_back(tiempo_transcurrido);

  	}while (P.GeneraSiguienteProfundidad());

				
	cout << "Nodos explorados: " << nodos << endl;
	for (int z = 0; z < parejas.size(); z++){
		cout << "Pareja de: " << parejas[z] << " es: " << parejas[z+1] << endl;
		z++;
	}
	cout << "Discrepancia: " << discrepanciaAnterior << endl;

	for(int i = 0 ; i < tiempos.size(); i++){
		tiempo += tiempos[i];
	}
	tiempo_medio = tiempo / tiempos.size();
  	cout << "Tiempo medio por nodo: " << tiempo_medio.count() << endl;
	
}



/////////////////////////////*******************************************************************/////////////////////////////////////
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
	cout << endl << endl << "Resultados de backtracking simple: " << endl;
	backTracking(nper, npre, secuencia);

	cout << endl << endl << "Resultados de backtracking con poda: " << endl;
	backTrackingPoda(nper, npre, secuencia);


}
