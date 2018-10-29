SRC = src
INC = include
OBJ = obj
BIN = bin
CXX = g++
CPPFLAGS = -Wall -pg  -I$(INC) -c -std=c++11


all:	
	$(CXX) $(CPPFLAGS) $(SRC)/prueba_APermutacion.cpp -o $(OBJ)/prueba_APermutacion.o
	$(CXX) -o $(BIN)/prueba_APermutacion  $(OBJ)/prueba_APermutacion.o
	$(CXX) $(CPPFLAGS) $(SRC)/friendship_voraz.cpp -o $(OBJ)/friendship_voraz.o
	$(CXX) -o $(BIN)/friendship_voraz  $(OBJ)/friendship_voraz.o
	$(CXX) $(CPPFLAGS) $(SRC)/friendship_backtracking.cpp -o $(OBJ)/friendship_backtracking.o
	$(CXX) -o $(BIN)/friendship_backtracking  $(OBJ)/friendship_backtracking.o
	$(CXX) $(CPPFLAGS) $(SRC)/friendship_branchbound.cpp -o $(OBJ)/friendship_branchbound.o
	$(CXX) -o $(BIN)/friendship_branchbound  $(OBJ)/friendship_branchbound.o

# ************ Generación de documentación ******************
documentacion:
	doxygen doc/doxys/Doxyfile

# ************ Compilación de módulos ************	

$(OBJ)/Apermutacion.o: $(SRC)/Apermutacion.cpp $(INC)/Apermutacion.h
	$(CXX) $(CPPFLAGS) $(SRC)/Apermutacion.cpp -o $(OBJ)/Apermutacion.o

$(BIN)/fiendship_voraz: $(OBJ)/friendship_voraz.o
	$(CXX) -o $(BIN)/friendship_voraz  $(OBJ)/friendship_voraz.o

$(OBJ)/friendship_voraz.o: $(SRC)/friendship_voraz.cpp
	$(CXX) $(CPPFLAGS) $(SRC)/friendship_voraz.cpp -o $(OBJ)/friendship_voraz.o

$(BIN)/fiendship_backtracking: $(OBJ)/friendship_backtracking.o
	$(CXX) -o $(BIN)/friendship_backtracking  $(OBJ)/friendship_backtracking.o

$(OBJ)/friendship_backtracking.o: $(SRC)/friendship_backtracking.cpp
	$(CXX) $(CPPFLAGS) $(SRC)/friendship_backtracking.cpp -o $(OBJ)/friendship_backtracking.o	




# ************ Limpieza ************
clean :
	-rm $(OBJ)/* $(SRC)/*~ $(INC)/*~ ./*~

mrproper : clean
	-rm $(BIN)/* doc/html/*
