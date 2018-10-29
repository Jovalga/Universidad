#include "abb.h"
#include <string>
#include <sstream>
#include <cstdlib>
#include <vector>
#include <cstdlib>  // Para generación de números pseudoaleatorios
#include <chrono>// Recursos para medir tiempos
using namespace std;
using namespace std::chrono;

void ListarAbb(ABB<int> &ab_bus){
  ABB<int>::nodo n;
 
 for (n=ab_bus.begin(); n!=ab_bus.end(); ++n){}
	  
}

void sintaxis(){
	cout << "Por favor introduzca solo como unico argumento el tamaño del arbol\n";
}


int main(int argc, char * argv[]){

if (argc != 2){
	sintaxis();    
	return 1;}
	
  int tam = atoi(argv[1]);     // Tamaño del vector
  if (tam<=0){
	sintaxis();
    return 0;}



 vector<int>v;
 int a;

//////////////////////////////*****************////////////


  
  // Generación de valores aleatorios

  int valor;
  srand(time(0));             // Inicialización del generador de números pseudoaleatorios
  for (int i=0; i<tam; i++){  // Recorrer vector
 	valor = rand() % 100;
   	v.push_back(valor);
  }

///////////////////********************////////////

 ABB<int>ab_bus;
 
//////////////////// A ANALIZAR ////////////////////////////
high_resolution_clock::time_point start,//punto de inicio
                                  end; //punto de fin
 duration<double> tiempo_transcurrido;  //objeto para medir la duracion de end 						   // y start
  
 start = high_resolution_clock::now(); //iniciamos el punto de inicio
 
 for (int i=0; i<v.size(); i++){
	   ab_bus.Insertar(v[i]);
 }
 ListarAbb(ab_bus);
  
 end = high_resolution_clock::now(); //anotamos el punto de de fin 
 //el tiempo transcurrido es
 tiempo_transcurrido  = duration_cast<duration<double> >(end - start);

  // Mostramos resultados
  cout << tam << "\t" <<tiempo_transcurrido.count() << endl;



///////////////////////////////////////////////////////////////////////

//int x;

//cout<<endl<<"Dime un elemento a borrar: ";
//while (cin>>x){
//if (ab_bus.Buscar(x)){
//	  cout<<endl<<x<<" esta"<<endl;
//	  ab_bus.Borrar(x);
//}
//else{ cout<<"El elemento "<<x<<" no esta"<<endl;
//}
//ListarAbb(ab_bus);
//}

 
}
