#ifndef _PD_MAXIMODATOS__
#define _PD_MAXIMODATOS__
#include <iostream>
#include <fstream>
#include <vector>	// Para vector

using namespace std;



/**	@brief: Método que selecciona de un vector de enteros un subconjunto de ellos, cuyo resultado es igual al parámetro suma o al menos el resultado mas cercano.
*	@param secuencia: Conjunto de enteros.
*	@param suma: valor entero que busca ser el resultado de la suma del subconjunto elegido del conjunto secuencia.
*	@param subsecuencia: es el subconjunto resultado, cuya suma da como resultado el parámetro suma.
*/
void seleccion(const vector<int> &secuencia, int suma, vector<int> & subsecuencia);


#endif
