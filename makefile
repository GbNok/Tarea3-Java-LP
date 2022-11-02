JC=javac
SP=-sourcepath
CP=-cp
JVM=java

.PHONY: run compile clean

run: compile
	$(JVM) $(CP) out src/JavaQuest.java

compile: out/JavaQuest out/Item out/Mapa out/RandomNumber out/Nodo out/Personaje out/Jugador
	

out/JavaQuest: src/JavaQuest.java | out_dir
	$(JC) $(SP) src/ -d out $^

out/Item: src/game/Item.java | out_dir
	$(JC) $(SP) src/ -d out $^

out/Mapa: src/game/Mapa.java | out_dir
	$(JC) $(SP) src/ -d out $^

out/RandomNumber: src/game/RandomNumber.java | out_dir
	$(JC) $(SP) src/ -d out $^

out/Nodo: src/game/nodo/Nodo*  | out_dir
	$(JC) $(SP) src/ -d out $^

out/Personaje: src/game/personaje/Personaje.java | out_dir
	$(JC) $(SP) src/ -d out $^

out/Jugador: src/game/personaje/Jugador.java | out_dir
	$(JC) $(SP) src/ -d out $^

clean: 
	rm -rf out

out_dir:
	mkdir -p out