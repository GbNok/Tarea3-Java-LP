package game.personaje;

public class Personaje {
    String nombre;
    int dinero;
    int hpActual;
    int hpTotal;
    int danio;
    int defensa;

    public Personaje(String nombre, int dinero, int hpActual, int hpTotal, int danio, int defensa) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.hpActual = hpActual;
        this.hpTotal = hpTotal;
        this.danio = danio;
        this.defensa = defensa;
    }

    public void combate(Personaje enemy) {
        while (enemy.hpActual > 0 || this.hpActual > 0){
            if (enemy.defensa > 0){
                enemy.defensa = ((enemy.defensa * 10) - this.danio) / 10;
            }else{
                enemy.hpActual = enemy.hpActual - this.danio;
            }

            if (this.defensa > 0){
                this.defensa = ((this.defensa * 10) - enemy.danio) / 10;
            }else{
                this.hpActual = this.hpActual - enemy.danio;

            }
            this.hpActual = (this.hpActual + enemy.defensa * 10) - enemy.danio;
        }
        if (enemy.hpActual < 0){
            System.out.printf("%s muere %s gana\n", enemy.nombre, this.nombre);
        }else{
            System.out.printf("%s muere %s gana\n", this.nombre, enemy.nombre);
        }
    }
}