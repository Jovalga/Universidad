// Metodo Max_Min. Devuelve al par de elementos Max/Min del vector pasado como parametro
pair <int,int> Moda(const vector<int> & v){
		
	vector<int> heterogeneosmenor;
	vector<int> homogeneos;
	vector<int> heterogeneosmayor;
	int pivote;
	pair<int,int> moda;
	pair<int,int> modamenor;
	pair<int,int> modamayor;
	bool encontrada = false;	// Para indicar si ya hemos encontrado la moda

	if (v.size() <= 0){
		moda.first = -1;
		moda.second = -1;
		return moda; 
	}
	else
		pivote = v[0];


	// Creamos los tres conjuntos
	for (int i=0; i < v.size(); i++){
		if(v[i] == pivote){
			homogeneos.push_back(v[i]);			
		}
		else{
			if(v[i] < pivote)
				heterogeneosmenor.push_back(v[i]);	
			else
				heterogeneosmayor.push_back(v[i]);			
		}
	}

	// Una vez dividido el conjunto vamos a ver que conjunto es el mas grande
		
	if(heterogeneosmenor.size() >= heterogeneosmayor.size())
		if(homogeneos.size() >= heterogeneosmenor.size())
			encontrada = true;
	else
		if(homogeneos.size() >= heterogeneosmayor.size())
			encontrada = true;


	// RECURSIVIDAD

	if (encontrada){
		moda.first = pivote;
		moda.second = homogeneos.size();
		return moda;	// Si tenemos la moda devolvemos el pivote (moda.first)
	}			// y su cardinalidad (moda.second), es decir,
				// el elemento de homogeneos y su cardinalidad
	else{
		if (heterogeneosmayor.size() > 0)
			modamayor = Moda(heterogeneosmayor);
		if (heterogeneosmenor.size() > 0)
			modamenor = Moda(heterogeneosmenor);
	}

	// Fin RECURSIVIDAD

	if (modamayor.second > modamenor.second) // Comprobamos que moda es mas comun, es
		return modamayor;		 // decir, comprobamos las cardinalidades
	else
		return modamenor;

}
