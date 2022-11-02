package game.nodo;

import game.personaje.Jugador;

public class NodoInicial extends Nodo{

    public NodoInicial(int id){
        super(id);
    }

    /*
    Funcion para interactuar con el nodo inicial.
    En esta interaccion no ocurre nada. Solo se muestra por consola el contexto de la historia.

    @param jugador (Jugador): jugador que interactua con el nodo. Se utiliza para mostrar su nombre en la historia
     */
    public void interactuar(Jugador jugador){
        System.out.println("Eres un joven de un pequenio pueblo perdido en la historia. A este pueblo le llaman Emond's Field. Un pueblo campesino dedicado a producir tabaco y lana.\n" +
                "El dia de hoy es muy especial, porque es tu cumpleanios. Cumples 19 anios. Pero este es el dia en el que todo cambio. El dia que toda tu realidad cambia\n" +
                "Tu padre, Tam al'Thor, heroe de guerra en la guerra de los Aiel, te cuenta QUIEN REALMENTE eres.\n\n" +
                "Durante la guerra de los Aiel, en la ultima batalla, la batalla de las murallas de Tar Valon, Tam se encontraba en la base de la Montania del Dragon.\n" +
                "En este lugar, Tam encuentra a una mujer con un bebe. La mujer esta muriendo por una herida en el estomago. La mujer antes de morir, le entrega el bebe a Tam y una bolsa pesada.\n" +
                "La bolsa contiene 7 objetos con forma de plato blanco y negro, y un martillo. Justo antes de morir, la madre dice:\n" +
                "Este es mi hijo. Su nombre es " + jugador.getNombre() + ". El es El Dragon. Su destino es desruir a Shai'tan. Cuando el momento sea correcto, debera luchar contra la oscuridad.\n" +
                "Y despues de Tarmon Gai'don (la ultima batalla), debera morir. Eso es lo que dice la profecia.\n\n" +
                "Cuando escuchas esto comienzas a sentir el miedo. Tu no eres un guerrero. Solo eres un grajero. Tu no puedes ser El Dragon. Car'a'Carn. Coramoor. El salvador de la rueda del tiempo. Eres solo un campesino\n" +
                "Tam se levanta y de un baul saca una bolsa. De ella, saca los 7 platos y el martillo. Y dice:\n" +
                "Estos son los sellos de la prision de Shai'tan. Son estos sellos que lo mantienen enserrado. Cuando llegues a Tarmon Gai'don, deberas destruir los sellos para enfrentarlo. Para ello, utilizaras el martillo.\n" +
                "Mah'alleinir, el ultimpo martillo creado con saidin. Es el unico objeto capaza de destruir los sellos. Yo no puedo ir contigo en este viaje. Pero te dare un ultimo regalo antes de partir.\n" +
                "Del mismo baul, saca una espada. Pero no cualquier espada. Heron Marked blade. Espada de un maestro. Tam dice: \n" +
                "Esta es mi espada. La gane en la guerra de los Aiel. Ahora es tuya. Utilizala con cuidado.\n\n" +
                "Dias despues, ya juntaste lo necesario para el viaje y estas listo para comenzar. Para comenzar el vieje para derrotar a Shai'tan, y salvar la rueda del tiempo.");
    }
    public String getType(){
        return "Inicio";
    }
}
