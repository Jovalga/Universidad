// Metodo Max_Min. Devuelve al par de elementos Max/Min del vector pasado como parametro
pair<int,int> Max_Min(const vector<int> & v){
	
	pair<int,int> par; 	// Declaramos la variable pair
	int max;		// Declaramos nuestra variable max para guardar el maximo
	int min;		// Declaramos nuestra variable min para guardar el minimo
	vector<int> izquierda;	// Declaramos el vector que contendra una mitad
	pair<int,int> pderecha;	// Declaramos el par max-min del vector de la derecha
	vector<int> derecha;	// Declaramos el vector que contedra la otra mitad
	pair<int,int> pizquierda;// Declaramos el par max-min del vector izquierda
	

	if (v.size() == 1){
		par.first = v[0];
		par.second = par.first;
		return par;
	}

	else{		
		// Hallamos la mitad y dividimos el vector en dos
		int mitad = v.size()/2;
	
		for (int i = 0; i < mitad; i++)
			izquierda.push_back(v[i]);

		for(int j = mitad; j < v.size() ; j++)
			derecha.push_back(v[j]);


		// Recursivamente hallamos el par minimo y maximo de los vectores divididos
		pderecha = Max_Min(derecha);
		pizquierda = Max_Min(izquierda);
	

		// Para el maximo
		if (pderecha.first > pizquierda.first)
			max = pderecha.first;
		else
			max = pizquierda.first;
		
		// Para el minimo
		if (pderecha.second < pizquierda.second)
			min = pderecha.second;
		else
			min = pizquierda.second;

		par.first = max;
		par.second = min;

		return par;
	}
}
