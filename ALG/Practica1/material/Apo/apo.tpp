
/*****
 Funcion de Abstraccion
_________________________
   Sea ap un apo sobre el tipo T. Diremos que el subarbol a partir
de la posicion i es un APO si:
   - Si <= i <nelementos tiene como elemento raíz ap.vector[i] y como
     subarbol izquierda y derecha los situados a partir de i*2+1 i*2+2.

   El arbol ap del conjunto de valores en la repesentación se aplica la 
condición anterior a partir de la posicion 0.
	  
 Invariante de la representacion
_________________________________
    - ap.nelementos<=ap.reservados
    - ap.vector apunta a una zona de memoria capa de alojar a reservados
      elementos de tipo T   
    - para todo i,j tal que 0<=i <j<ap.nelementos  y además j=2*i+1 o j=2*i+2 
      entonces a.vector[i] <=a.vector[j] 


*/
template <class T>
void APO<T>::Copiar(const APO<T> &ap){
	  
	  if (ap.vector!=0){
		    reservados = ap.reservados;
		    nelementos = ap.nelementos;
		    vector = new T[reservados];
		    for (int i=0;i<nelementos;i++)
			      vector[i]=ap.vector[i];
	  }
	  else{
		    vector =0;
		    reservados=0;
		    nelementos=0;
	  }
}

template <class T>
void APO<T>::Borrar(){
	  delete []vector;
	  nelementos =0;
	  reservados=0;
}

template <class T>
void APO<T>::resize(int n){
     T * aux = new T[n];
     int min = (n<nelementos)?n:nelementos;
     for (int i=0;i<min;i++)
	  aux[i]=vector[i]; 
     reservados = n;
     nelementos = min;
     delete[]vector;
     vector =aux;
}

template <class T>
APO<T>::APO(int tam){
	  reservados = tam;
	  nelementos=0;
	  vector = new T[reservados];
}

template <class T>
APO<T>::APO(const APO & a){
	  Copiar(a);
}


template <class T>
APO<T>::~APO(){
	  Borrar();
}

template <class T>
APO<T> & APO<T>::operator=(const APO &a){
	  if (this!=&a){
		    Borrar();
		    Copiar(a);
	  }
          return *this;
}

template <class T>
const T & APO<T>::minimo()const{
	   assert(nelementos>0);
	   return vector[0];
}
template <class T>
void APO<T>::borrar_minimo(){
	  vector[0]=vector[nelementos-1];
	  nelementos--;
	  if (nelementos>1){
		//posicion del elemento en el ultimo nivel mas a la drch   
		int ultimo = nelementos-1;
	        int pos=0;
		bool acabar = false;
		while (pos<=(ultimo-1)/2 && !acabar){ // hasta el penúltimo nivel
		    int pos_min;
		    if (2*pos+1 ==ultimo)
			      pos_min= 2*pos+1;
		    else if (vector[2*pos+1]<vector[2*pos+2])
			      pos_min= 2*pos+1;
			  else 
			      pos_min = 2*pos+2;
		    if (vector[pos_min]<vector[pos]){
			      swap(vector[pos],vector[pos_min]);
			      pos=pos_min;
		    }
		    else acabar = true;
		 }
	    }
	    if (nelementos<reservados /4) resize(reservados/2);	    
}
template <class T>
void APO<T>::insertar(const T & e){
	  if (reservados==nelementos) resize(2*reservados);
	  

	  int pos = nelementos;
	  nelementos ++;
	  vector[pos]=e;
	  //reordenamos
	  while (pos>0 && (vector[pos]<vector[(pos-1)/2])){ //mientras que el padre sea mayor que los hijos
		    swap(vector[pos],vector[(pos-1)/2]);
		    pos = (pos-1)/2;
	  }
}


template <class T>
bool APO<T>::vacio()const{ return nelementos==0;}


template <class T>
void APO<T>::clear(){
	  Borrar();
}

template <class U>
istream &operator>>(istream & is, APO<U>&ap){
	  U e;
	  APO<U> aux;
	  while (is>>e){
		    aux.insertar(e);
	  }
	  ap = aux;
	  return is;
}
template <class U>
ostream &operator<<(ostream & os, const APO<U>&ap){
	  APO<U>aux(ap);
	  for (int i=0;i<ap.nelementos;i++){
		    os<<aux.minimo()<< " ";
		    aux.borrar_minimo();
	  }
	  return os;
}
		    
		    
