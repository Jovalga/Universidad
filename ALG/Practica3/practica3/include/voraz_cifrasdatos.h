#ifndef _VORAZ_CIFRASDATOS__
#define _VORAZ_CIFRASDATOS__
#include <iostream>
#include <fstream>
#include <vector>	// Para vector

using namespace std;



/**	@brief: Método que selecciona de un vector de enteros un subconjunto de ellos, cuyo resultado según los operandos +,-,*,/ elegidos es igual al parámetro suma_final.
*	@param secuencia: Conjunto de enteros.
*	@param suma_final: valor entero que busca ser el resultado de las operaciones del subconjunto elegido del conjunto secuencia.
*	@param subsecuencia: es el subconjunto resultado, cuyos elementos con los operadores seleccionados da como resultado el parámetro suma_final.
*/
void seleccion(const vector<int> &secuencia, int suma_final, vector<int> & subsecuencia);

#endif
