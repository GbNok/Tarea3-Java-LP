# Tarea 3 - Java

Gabriel Escalona - 202173610-7

## Correr programa
### Versiones utilizadas  

#### Java
openjdk 19 

#### Javac
javac 11.0.16.1

### Compiar

Compila los archivos del proyecto y los agrega a la carpeta out

```sh
make compile
```


### Correr

Corre el archivo src/JavaQuest.java utilizando los archivos .class en la carpeta out

Se puede correr el programa sin compilar antes ya que make run compila el programa y lo corre
```sh
make run
```

### Limpiar

Borra la carpeta out que contiene los archivos .class

```sh
make clean
```

## Caracteristicas de el juego

- El nombre del jugador no puede tener espacios
- Las acciones son en base a ingresar numeros. Que accion realiza cada numero depende del momento


### Tienda

Cada nodo tienda tiene 7 items. 6 De esos items son siempre los mismos. El otro item es un item aleatorio
La cantidad de dinero es limitada. No se puede conseguir dinero de ninguna forma.

### Combate

El combate es por turnos. En cada turno se tira una moneda para ver quien ataca primero.
Despues de atacar, se verifica que el enemigo siga vivo. Si muere, se acaba el turno y la pelea
Si el que defiende tiene defensa, TODO el danio sera bloqueado por la defensa hasta que no tenga defensa

### Eventos

Para los eventos se selecciona un evento aleatorio de un grupo de eventos
Los eventos se pueden repetir

### Historia

La histaria esta basada en la saga de libros de The Wheel of Time.
Los Personajes son de la saga pero la historia es una modificacion de ella. 
La historia no es la misma que la de los libros, pero de igual forma el juego contiene spoilers de los libros.