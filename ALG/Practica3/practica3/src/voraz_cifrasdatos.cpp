#include "../include/voraz_cifrasdatos.h"
#include <iostream>
#include <fstream>
#include <vector>	// Para vector
#include <limits>	// Para numeric_limits

using namespace std;


void seleccion(const vector<int> &secuencia, int suma_final, vector<int> & subsecuencia){
	vector <int> usada = secuencia;
	cerr << "Llamado metodo seleccionar" << endl;

	int n = secuencia.size();	// Numero de elementos de la secuencia
	int cercano = numeric_limits<int>::max(); // Sera el numero mas cercano a la suma. Buscamos asi la optimizacion
	int cercano_anterior = numeric_limits<int>::max();
	int acumulacion = 0;		// Es el valor entero que va aculumando la suma, resta, multiplicacion o dividision de los valores enteros que vayamos eligiendo
	int posicion;			// Sera la posicion donde este el mayor valor, es decir, el valor que pase a acumularse
	int suma;
	int resta;
	int multi;
	int division = numeric_limits<int>::max();
	bool su = false;
	bool re = false;
	bool mu = false;
	bool di = false;
	bool encontrado = false;
	
			for (int i = 0; i < n and !encontrado; i++){
				suma = acumulacion + usada[i];		// Hacemos todas las operaciones por el valor
				resta = acumulacion - usada[i];		// que vamos acumulando para despues comprobar
				multi = acumulacion * usada[i];		// cual de ellos es el mas cercano al valor suma_final
				if ( acumulacion % usada[i] == 0 and acumulacion >= usada[i])	
					division = acumulacion / usada[i];
				else	  					// Siempre que no se pueda le asignamos valor maximo
					division = numeric_limits<int>::max();	// para que no haya errores con interaciones anteriores
				

			// Nos quedamos con la diferencia a suma_final, para asi saber luego cual es el mas cercano
				suma = suma_final - suma;
				resta = suma_final - resta;
				multi = suma_final - multi;
				division = suma_final - division;

			// Pasamos a valores absolutos
 				if (suma < 0)
					suma = -suma;
				if (resta < 0)
					resta = -resta;
				if (multi < 0)
					multi = -multi;
				if (division < 0)
					division = -division;

			// Ahora vemos cual de todas ellas es la mas cercana a suma_final
				if (suma < cercano){
					cercano = suma;
					su = true;
					re = false;
					mu = false;
					di = false;
				}
				if (resta < cercano){
					cercano = resta;
					su = false;
					re = true;
					mu = false;
					di = false;
				}
				if (multi < cercano){
					cercano = multi;
					su = false;
					re = false;
					mu = true;
					di = false;
				}
				if (division < cercano){
					cercano = division;
					su = false;
					re = false;
					mu = false;
					di = true;
				}

			// Una vez hemos hallado de nuestras operaciones el valor mas cercano
			// pasamos a comprobar si nos aleja o nos acerca mas al valor buscado

				if (cercano < cercano_anterior){

					if(su){
						cout << "+" << usada[i] << endl;
						acumulacion = acumulacion + usada[i];
					}
					if(re){
						cout << "-" << usada[i] << endl;
						acumulacion = acumulacion - usada[i];
					}
					if(mu){
						cout << "*" << usada[i] << endl;
						acumulacion = acumulacion * usada[i];
					}
					if(di){
						cout << "/" << usada[i] << endl;
						acumulacion = acumulacion / usada[i];
					}
					cout << "Acumulacion: " << acumulacion << endl;
					subsecuencia.push_back(usada[i]);
					usada.erase(usada.begin()+i);
					n--; // Al borrar tenemos que indicar que el tamaño es menor para que el bucle no se salga de memoria
					i--;
					cercano_anterior = cercano;
				}
				su = false;
				re = false;
				mu = false;
				di = false;
				cercano = numeric_limits<int>::max();

				if (acumulacion == suma_final)
					encontrado = true;
			}
			cout << endl;
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

	/* AQUI EL RESULTADO LO MUESTRA EL MISMO METODO
	cerr << "El resultado es: " << endl;
	for (int i = 0; i < subsecuencia.size(); i++)
		cerr << subsecuencia[i] << endl;*/

	
	


}
