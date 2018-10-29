
#include "permutacion.h"


void Permutacion::GenerarSiguiente(int nivel,unsigned int pos){
 
  datos[pos][nivel]=datos[pos][nivel]+1;
   
}


bool Permutacion::PosiblePermutacion(int nivel,unsigned int pos){
  for (int i=0;i<nivel;i++)
    if (datos[pos][nivel]==datos[pos][i])
      return false;
    
  return  nivel<(int)datos[pos].size()-1;
}


bool Permutacion::EsPermutacion( int nivel,unsigned int pos){
  for ( int i=0;i<nivel;i++)
    if (datos[pos][nivel]==datos[pos][i])
      return false;
  return nivel==(int)datos[pos].size()-1 ;
}


bool Permutacion::MasHermanos(  int nivel,unsigned int pos){
   return nivel>=0 && datos[pos][nivel]<datos[pos].size();  
}  


Permutacion::Permutacion(unsigned int n,int numero_generar){
  unsigned int total = numero_generar;
  if (numero_generar==-1){
    total =1;
    for (unsigned int i=2;i<=n;i++)
	total*=i;
  }
  
  
  datos= vector<vector<unsigned int> >(total,vector<unsigned int>(n,0));
 
  int nivel=0;
  unsigned int pos=0;   
  do{
       GenerarSiguiente(nivel,pos); 
       
       if (EsPermutacion(nivel,pos)){
	 
	 if (pos<datos.size()-1)
	  datos[pos+1]=datos[pos];
         pos++;

       }	
       if (pos<total && PosiblePermutacion(nivel,pos)) 
           nivel=nivel+1;
       else{
          while (nivel>=0 && pos<total && !MasHermanos(nivel,pos)  ){
	      datos[pos][nivel]=0; 
              nivel=nivel-1;
         }
       } 
   
   }while (nivel>=0 && pos<total);    
   
}  



unsigned int Permutacion::NumeroPermutacionesPosibles()const{
  int total=1;
  int n= datos[0].size();
  for (int i=2;i<=n;i++)
    total*=i;
  return total;
}  



bool Permutacion::GeneraSiguiente(){
  
  int nivel=(int)datos[0].size()-1;
  unsigned int pos=0;
  while (nivel>=0  && !MasHermanos(nivel,pos)  ){
	      datos[pos][nivel]=0; 
              nivel=nivel-1;
  }
  if (nivel<0) return false;
  
  do{
       GenerarSiguiente(nivel,pos); 
       
       if (EsPermutacion(nivel,pos)){
	  return true;
         
       }	
       if ( PosiblePermutacion(nivel,pos)) 
           nivel=nivel+1;
       else{
          while (nivel>=0  && !MasHermanos(nivel,pos)  ){
	      datos[pos][nivel]=0; 
              nivel=nivel-1;
         }
       } 
   
   }while (nivel>=0 );   
   return false;
}   
