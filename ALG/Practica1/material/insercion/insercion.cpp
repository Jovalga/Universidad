#include <iostream>
#include <cstdlib>  // Para generación de números pseudoaleatorios
#include <chrono>// Recursos para medir tiempos
using namespace std;
using namespace std::chrono;



// Con este metodo insertamos un valor dado dentro del vector pasado como
// parametro. Damos por sentado que el vector pasado esta ya ordenado
void insercion(int *v, int max){
int temp, j;
	for (int i=1; i<max; i++){
        	  temp = v[i];
        	  j = i - 1;
          	while ( (v[j] > temp) && (j >= 0) ){
	               	v[j+1] = v[j];
	               	j--;
		}
          	v[j+1] = temp;
	}
}

void sintaxis()
{
  cerr << "Sintaxis:" << endl;
  cerr << "  TAM: Tamaño del vector (>0)" << endl;
  cerr << "  El valor a insertar siempre sera mayor que todos los del vector" << endl;
  cerr << "Se genera un vector de tamaño TAM con elementos ordenados en [0,TAM]" << endl;
  exit(EXIT_FAILURE);
}

int main(int argc, char * argv[])
{
  // Lectura de parámetros
  if (argc != 2)
    sintaxis();
  int tam = atoi(argv[1]);     // Tamaño del vector
  if (tam <= 0)
    sintaxis();
  
  // Generación del vector ordenado
  int *v = new int[tam];       // Reserva de memoria +1 para el valor a insertar
  for (int i = 0; i < tam; i++)  // Recorrer vector
    v[i] = i;    // Crear valor [0,tam]
  
 high_resolution_clock::time_point start,//punto de inicio
                                  end; //punto de fin
 duration<double> tiempo_transcurrido;  //objeto para medir la duracion de end 						   // y start
  
 start = high_resolution_clock::now(); //iniciamos el punto de inicio
 
	
  insercion(v,tam); 	// de esta forma forzamos el peor caso
  
 end = high_resolution_clock::now(); //anotamos el punto de de fin 
 //el tiempo transcurrido es
 tiempo_transcurrido  = duration_cast<duration<double> >(end - start);

  // Mostramos resultados
  cout << tam << "\t" <<tiempo_transcurrido.count() << endl;
  
  delete [] v;     // Liberamos memoria dinámica
}
