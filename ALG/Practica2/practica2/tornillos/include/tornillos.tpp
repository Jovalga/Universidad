// Metodo que empareja las tuercas y los tornillos y devuelve la pareja.
void ordenarTornillos( const vector<int> &tornillos, const vector<int> &tuercas, vector<int> &ordenado){
	

	// Creamos los tres conjuntos de datos:
	// mayores que el pivote, menores que el pivote
	// iguales que el pivote
	// El pivote sera la tuerca y tornillo elegidos
	vector<int> tuercas_mayores;
	vector<int> tuercas_menores;
	vector<int> tornillos_mayores;
	vector<int> tornillos_menores;
	
	
	// Cogemos un tornillo al azar y creamos la variable tuerca
	// la cual tendra el valor que sea igual a tornillo (tamaño)
	int tornillo = tornillos[rand() % tornillos.size()];
	int tuerca;
	

	// SI PENSAMOS EN QUE ESTE ALGORITMO ES RECURSIVO, SABEMOS QUE POR EL ORDEN
	// DE LLAMADAS QUE HEMOS PUESTO, LOS MINIMOS SE ASIGANARAN PRIMERO, QUEDANDO
	// POR ULTIMO LAS LLAMADAS A LOS MAXIMOS. SI PASAMOS POR REFERENCIA UN VECTOR
	// RESULTADO DENOMINADO TORNILLOSORDENADOS O TUERCAS ORDENADAS, IRA MODIFICANDOSE
	// DE LA FORMA ANTES DESCRITA, QUEDANDO FINALMENTE TOTALMENTE ORDENADOS


	// Caso base
	if (tornillos.size() == 1){ // Sabemos que tuercas tendra el mismo tamaño que tornillos
		tuerca = tornillo;
		ordenado.push_back(tuerca); // y el mismo valor que tornillo
	}


	else{
	// Dividimos segun el pivote (tornillos al azar) las tuercas en los tres conjuntos
	// antes creados
		for(int i = 0; i < tuercas.size() ; i++ ){
			if (tornillo > tuercas[i])
				tuercas_menores.push_back(tuercas[i]);
	
			else if(tornillo < tuercas[i])
				tuercas_mayores.push_back(tuercas[i]);

			else
				tuerca = tuercas[i]; // Guardamos la tuerca que es igual al tornillo
		}

	
	// Ahora ordenamos los tornillos en mayores y menores a la tuerca
		for(int i = 0; i < tornillos.size() ; i++ ){
			if (tuerca > tornillos[i])
				tornillos_menores.push_back(tornillos[i]);
	
			else if(tuerca < tornillos[i])
				tornillos_mayores.push_back(tornillos[i]);

			else
				tornillo = tornillos[i]; // Guardamos finalmente el tornillo igual a la tuerca
		}
	


	// INICIO RECURSIVIDAD
	
	// Si los vectores tienen mas de un elemento dentro volvemos a llamar a los metodos
	// Finalmente aqui tambien delvolvemos la pareja tuerca tornillo encontrada en esta iteracion
		if (tornillos_menores.size() > 0){ // solo pongo tornillos porque tuercas tiene el mismo tamaño
		// Las menores las ponemos al principio del vector
			ordenarTornillos(tornillos_menores , tuercas_menores, ordenado);
		}
		
		// Una vez estan las mas pequeñas ya insertadas con la condicion y orden anterior
		// pasamos a insertar las propias de esta traza del metodo
		ordenado.push_back(tuerca);

		if ( tornillos_mayores.size() > 0 ){
		// Las mayores las ponemos al final del vector
			ordenarTornillos(tornillos_mayores , tuercas_mayores, ordenado);
		}

	}
	// FIN RECURSIVIDAD


}
