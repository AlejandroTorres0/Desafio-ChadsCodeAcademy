import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private List<Prueba> listaPruebas;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        listaPruebas = new ArrayList<Prueba>();
    }

    public Prueba getPrueba(int numero_prueba) { return listaPruebas.get(numero_prueba); }

    public void agregarPrueba(Prueba prueba) { listaPruebas.add(prueba); }

    @Override
    public String toString() {
        return "'" + nombre + "' "
                + listaPruebas;
    }
    
    public void generarNotasFaltantes() {
        int suma = listaPruebas.getFirst().getPuntaje() + listaPruebas.get(2).getPuntaje();
        Prueba prueba4 = new Prueba(0);
        listaPruebas.add(prueba4);
        if (listaPruebas.get(1).getPuntaje() < 60) {
            prueba4.setPuntaje(100);
        }
        else {
            prueba4.setPuntaje(listaPruebas.getFirst().getPuntaje() + 10); //Le sumo +10 a la nota 4 para que se cumpla el progreso.
        }

        Prueba prueba5 = new Prueba(0);
        listaPruebas.add(prueba5);
        if (suma > 150) {
            prueba5.setPuntaje(95);
        }
        else {
            prueba5.setPuntaje(70);
        }
    }

    public void aproboTodas() {
        int aprobadas = 0;
        for (Prueba prueba : listaPruebas) {
            if (prueba.aprobado()) {
                aprobadas++;
            }
        }
        if (aprobadas == listaPruebas.size()) {
            System.out.printf("Aprobaste todas. ¡Backend Sensei! %n");
        }
        else if (aprobadas > 0) {
            System.out.printf("Algunas aprobadas. Sos un refactor en progreso. %n");
        }
        else {
            System.out.printf("No aprobaste ninguna. ¡Sos un clon de frontend! %n");
        }
    }

    public void mayorSalto() {
        int mayorSalto = 0;
        int posPruebaAnterior = 0;
        int posPruebaActual = 0;

        for (int i = 1; i < listaPruebas.size(); i++) {
            int puntajeActual = listaPruebas.get(i).getPuntaje();
            int puntajeAnterior = listaPruebas.get(i - 1).getPuntaje();

            int salto = Math.abs(puntajeActual - puntajeAnterior);

            if (salto > mayorSalto) {
                mayorSalto = salto;
                posPruebaAnterior = i - 1;
                posPruebaActual = i;
            }
        }

        System.out.printf("El mayor salto de puntos de '" + nombre + "' fue de " + mayorSalto + " puntos %n");
        System.out.printf("Y fue entre la prueba %d y la prueba %d.%n", posPruebaAnterior + 1, posPruebaActual + 1);
    }

    public int saltosAcumulados() {
        int saltosAcum = 0;
        int salto = 0;
        Prueba pruebaAnt = null;
        for (Prueba prueba: listaPruebas) {
            if (!(pruebaAnt == null)) {
                salto = prueba.getPuntaje() - pruebaAnt.getPuntaje();
            }
            saltosAcum =  saltosAcum + salto;
            pruebaAnt = prueba;
        }
        return saltosAcum;
    }

    public double promedio() {
        int sumaPuntajes = 0;
        for(Prueba prueba: listaPruebas) {
            sumaPuntajes = sumaPuntajes + prueba.getPuntaje();
        }
        return (double) sumaPuntajes / listaPruebas.size();
    }

    public void evaluacionFinal() {
        int sumaPuntajes = 0;
        for(Prueba prueba: listaPruebas) {
            sumaPuntajes = sumaPuntajes + prueba.getPuntaje();
        }
        if (sumaPuntajes >= 450 ) {
            System.out.printf(nombre + " es un Stone Chad definitivo 💪%n");
        }
        else if (sumaPuntajes >= 350) {
            System.out.printf(nombre + " es un Chad%n");
        }
        else if (sumaPuntajes >= 250) {
            System.out.printf(nombre + " es un Soft Chad%n");
        }
        else {
            System.out.printf(nombre + " es un Normie total 😢%n");
        }
    }

    public void mostrarNotasOrdenadas() {
        List<Prueba> listaOrdenada = new ArrayList<>(listaPruebas);

        int n = listaOrdenada.size();
        boolean intercambiado;

        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (listaOrdenada.get(j).getPuntaje() < listaOrdenada.get(j + 1).getPuntaje()) {

                    Prueba temporal = listaOrdenada.get(j);
                    listaOrdenada.set(j, listaOrdenada.get(j + 1));
                    listaOrdenada.set(j + 1, temporal);
                    intercambiado = true;
                }
            }
            if (!intercambiado) {
                break;
            }
        }

        System.out.printf("Notas del alumno " + nombre + "%n");
        System.out.println(listaOrdenada.toString());
    }

    public void progreso() {
        boolean progresivo = true;
        int notaAnterior = 0;
        for (int i = 0; i < listaPruebas.size(); i++) {
            if (!(listaPruebas.get(i).getPuntaje() > notaAnterior)) {
                progresivo = false;
                break;
            }

            notaAnterior = listaPruebas.get(i).getPuntaje();
        }
        if (progresivo) {
            System.out.printf("El estudiante " + nombre + " tiene un ¡Nivel PROGRESIVO! es un Stone Chad en crecimiento 📈%n");
        }
    }
}
