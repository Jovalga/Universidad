#include <iostream>
#include "permutacion.h"
#include <string>
#include <chrono>	// Para medir tiempos
using namespace std;
using namespace std::chrono;

template <class T>
ostream & operator<<(ostream &os, const vector<T> & d){
   for (int i=0;i<d.size();i++)
      os<<d[i]<<" ";
   os<<endl;
   return os;
}

void MuestraPermutaciones(const Permutacion & P){
  Permutacion::const_iterator it;
  int cnt=1;
  for (it=P.begin();it!=P.end();++it,++cnt)
      cout<<cnt<<"->"<<*it<<endl;
      
}


void ImprimeCadena(const string &c,const Permutacion &P){
  const vector<unsigned int> s= (*(P.begin()));
  
  for (unsigned int i=0;i<s.size();i++)
     cout<<c[s[i]-1];
  cout<<endl;
}


void sintaxis(){
	cout << "Por favor introduzca como argumento la cantidad de elementos para la permutacion\n";
	cout << "El numero de elementos introducido debe ser positivo y mayor que 0\n";
}

int main(int argc , char * argv[]){

if (argc != 2){
	sintaxis();
	return 0;
}

  int tam = atoi(argv[1]);
  

if(tam < 1){
	sintaxis();
	return 0;
}


//////////////////// A ANALIZAR ////////////////////////////
high_resolution_clock::time_point start,//punto de inicio
                                  end; //punto de fin
 duration<double> tiempo_transcurrido;  //objeto para medir la duracion de end 						   // y start
  
 start = high_resolution_clock::now(); //iniciamos el punto de inicio
 
////////////////////////////////////////*******************

  Permutacion P(tam);	// La creacion de las permutaciones es lo que nos interesa

////////////////////////////////////////*******************
  
 end = high_resolution_clock::now(); //anotamos el punto de de fin 
 //el tiempo transcurrido es
 tiempo_transcurrido  = duration_cast<duration<double> >(end - start);

  // Mostramos resultados
  cout << tam << "\t" <<tiempo_transcurrido.count() << endl;



///////////////////////////////////////////////////////////////////////
  
  
  //Leemos una cadena y generamos todas sus permutaciones
  //string cad;
  //cout<<"Dime una palabra:";
  //cin>>cad;
  //Permutacion Otra(cad.size(),1);
  //int cnt=1;
  //do{
    //cout<<cnt<<"-->";
    //ImprimeCadena(cad,Otra);
    //cnt++;
  //}while(Otra.GeneraSiguiente());
}  
  
  
   
  
