SRC = src
INC = include
OBJ = obj
BIN = bin
CXX = g++ -std=c++11
CPPFLAGS = -Wall -g  -I$(INC) -c


all: $(BIN)/pruebapermutacion

# ************ Generación de documentación ******************
documentacion:
	doxygen doc/doxys/Doxyfile

# ************ Compilación de módulos ************
$(BIN)/pruebapermutacion: $(OBJ)/permutacion.o $(OBJ)/pruebapermutacion.o
	$(CXX) -o $(BIN)/pruebapermutacion  $(OBJ)/pruebapermutacion.o $(OBJ)/permutacion.o

$(OBJ)/pruebapermutacion.o: $(SRC)/pruebapermutacion.cpp $(INC)/permutacion.h
	$(CXX) $(CPPFLAGS) $(SRC)/pruebapermutacion.cpp -o $(OBJ)/pruebapermutacion.o
$(OBJ)/permutacion.o: $(SRC)/permutacion.cpp $(INC)/permutacion.h
	$(CXX) $(CPPFLAGS) $(SRC)/permutacion.cpp -o $(OBJ)/permutacion.o

# ************ Limpieza ************
clean :
	-rm $(OBJ)/* $(SRC)/*~ $(INC)/*~ ./*~

mrproper : clean
	-rm $(BIN)/* doc/html/*
