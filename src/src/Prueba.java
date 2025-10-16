public class Prueba {
    private int puntaje;

    public Prueba(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return " Prueba " + "puntaje " + puntaje;
    }

    public boolean aprobado() {
        return puntaje >= 60;
    }
}
