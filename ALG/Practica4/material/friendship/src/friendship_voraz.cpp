#include <iostream>
#include <fstream>
#include <vector>	// Para vector
#include <chrono>	// Para medir tiempos
#include <limits>	// Para numeric_limits

using namespace std;
using namespace std::chrono;


/** @brief Metodo que nos realiza por la técnica voraz las parejas con menor discrepancia
	@param nper: el numero de personas del archivo.txt pasado como parametro
	@param npre: numero de preguntas hechas a cada persona
	@param secuencia: numero de elementos npre*nper 
*/
void vorazGrupo(int nper, int npre, vector<int> secuencia){

	int diferencia;
	int discrepancia = 0;
	int discrepanciaAnterior = numeric_limits<int>::max();
	int discrepanciaAcumulada = 0;
	vector <int> usados;	
	bool usado = false;
	bool usado2 = false;
	int posible_pareja = -1; // Indico -1 como la "no pareja"

	// Cogemos a una persona
	for (int i = 0; i < nper; i++){

		// Comprobamos que no la hayamos escogido ya
		for (int z = 0; z < usados.size(); z++)
			if ( i == usados[z] )
				usado2 = true;

		if (!usado2){

			usado2 = false;
			
			// Comparamos con el resto
			for (int j = 0; j < nper; j++){
				
				// Comprobamos si ya hemos seleccionado a esa persona
				for (int k = 0; k < usados.size(); k++)
					if ( j == usados[k] )
						usado = true;
				
				if (!usado and i != j){
					usado = false;		// Devolvemos a usado el valor de false para la siguiente iteracion
					discrepancia = 0;
					
					// Hallamos la discrepancia
					for ( int p = 0; p < npre; p++){
						diferencia = secuencia[(i*npre)+p] - secuencia[(j*npre)+p];
					
						if (diferencia < 0) // Pasamos a valor absoluto
							diferencia = -diferencia;

						discrepancia = discrepancia + diferencia;
					}
					
					// Una vez hallada la discrepancia entre las dos personas escogidas vemos si
					// la discrepancia es menor que con las anteriores, lo que indicaria poder ser una posible pareja
					if (discrepanciaAnterior > discrepancia){
						discrepanciaAnterior = discrepancia;
						posible_pareja = j;
					}

				} // FIN !USADO
				usado = false;

			} // FIN FOR J

			// Una vez comprobadas todas las discrepancias entre las personas de j guardamos
		
			cout << "La pareja de " << i << " es " << posible_pareja << endl;
			usados.push_back(i);
			usados.push_back(posible_pareja);
			discrepanciaAcumulada = discrepanciaAcumulada + discrepancia;
			posible_pareja = -1;
			discrepanciaAnterior = numeric_limits<int>::max();


		} // FIN !USADO2
		usado2 = false;
	

	}

		cout << "Discrepancia: " << discrepanciaAcumulada << endl;

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


	//////////////////// A ANALIZAR ////////////////////////////

	high_resolution_clock::time_point start,//punto de inicio
                                  end; //punto de fin
 duration<double> tiempo_transcurrido;  //objeto para medir la duracion de end y start
  
 start = high_resolution_clock::now(); //iniciamos el punto de inicio
 

	vorazGrupo(nper, npre, secuencia);

  
 end = high_resolution_clock::now(); //anotamos el punto de de fin 
 //el tiempo transcurrido es
 tiempo_transcurrido  = duration_cast<duration<double> >(end - start);

  // Mostramos resultados
  cout << "Tiempo: " << tiempo_transcurrido.count() << endl;





}
