package usm.inf.lp.tarea.personaje;

public class Personaje {
    String nombre;
    int dinero;
    int hpActual;
    int hpTotal;
    int danio;
    int defensa;
    public Personaje(String nombre){
        this.nombre = nombre;
    }

    public void combate(Personaje p) {
        System.out.println("DIE!!!!");
    }

    public static class Builder{
        private String nombre;
        public Personaje build(){
            return new Personaje(nombre);
        }
        public Builder withNombre(String nombre){
            this.nombre = nombre;
            return this;
        }
    }
}