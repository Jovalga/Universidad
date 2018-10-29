SRC = src
INC = include
OBJ = obj
BIN = bin
CXX = g++
CPPFLAGS = -Wall -g  -I$(INC) -c -std=c++11


all:
	$(CXX) $(CPPFLAGS) $(SRC)/voraz_maximodatos.cpp -o $(OBJ)/voraz_maximodatos.o
	$(CXX) -o $(BIN)/voraz_maximodatos  $(OBJ)/voraz_maximodatos.o
	$(CXX) $(CPPFLAGS) $(SRC)/voraz_cifrasdatos.cpp -o $(OBJ)/voraz_cifrasdatos.o
	$(CXX) -o $(BIN)/voraz_cifrasdatos  $(OBJ)/voraz_cifrasdatos.o
	$(CXX) $(CPPFLAGS) $(SRC)/PD_maximodatos.cpp -o $(OBJ)/PD_maximodatos.o
	$(CXX) -o $(BIN)/PD_maximodatos  $(OBJ)/PD_maximodatos.o

# ************ Generación de documentación ******************
#documentacion:
	#doxygen doc/doxys/Doxyfile
	#doxygen include/voraz_maximodatos.h
	#doxygen include/voraz_cifrasdatos.h

# ************ Compilación de módulos ************

$(BIN)/voraz_maximodatos: $(OBJ)/voraz_maximodatos.o
	$(CXX) -o $(BIN)/voraz_maximodatos  $(OBJ)/voraz_maximodatos.o

$(OBJ)/voraz_maximodatos.o: $(SRC)/voraz_maximodatos.cpp $(INC)/voraz_maximodatos.h 
	$(CXX) $(CPPFLAGS) $(SRC)/voraz_maximodatos.cpp -o $(OBJ)/voraz_maximodatos.o

$(BIN)/voraz_cifrasdatos: $(OBJ)/voraz_cifrasdatos.o
	$(CXX) -o $(BIN)/voraz_cifrasdatos  $(OBJ)/voraz_cifrasdatos.o

$(OBJ)/voraz_cifrasdatos.o: $(SRC)/voraz_cifrasdatos.cpp $(INC)/voraz_cifrasdatos.h 
	$(CXX) $(CPPFLAGS) $(SRC)/voraz_cifrasdatos.cpp -o $(OBJ)/voraz_cifrasdatos.o

$(BIN)/PD_maximodatos: $(OBJ)/PD_maximodatos.o
	$(CXX) -o $(BIN)/PD_maximodatos  $(OBJ)/PD_maximodatos.o

$(OBJ)/PD_maximodatos.o: $(SRC)/PD_maximodatos.cpp $(INC)/PD_maximodatos.h 
	$(CXX) $(CPPFLAGS) $(SRC)/PD_maximodatos.cpp -o $(OBJ)/PD_maximodatos.o




# ************ Limpieza ************
clean :
	-rm $(OBJ)/* $(SRC)/*~ $(INC)/*~ ./*~

mrproper : clean
	-rm $(BIN)/* doc/html/*
