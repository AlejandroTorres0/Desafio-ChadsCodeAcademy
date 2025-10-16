import java.util.ArrayList;
import java.util.List;

public class CodeChadsAcademy {

    private List<Estudiante> listaEstudiantes;

    public CodeChadsAcademy() {
        this.listaEstudiantes = new ArrayList<Estudiante>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        this.listaEstudiantes.add(estudiante);
    }

    public void generarRanking() {
        double promedioMasAlto = 0;
        Estudiante estudiantePromedioMasAlto = null;


        int peorRendimientoPrueba3 = Integer.MAX_VALUE;
        Estudiante estudiantePeorRendimientoPrueba3 = null;

        int saltosDelMasRegular = Integer.MAX_VALUE;
        Estudiante estudianteMasRegular = null;

        for (Estudiante estudiante: listaEstudiantes) {
            double promedio = estudiante.promedio();
            if (promedio > promedioMasAlto) {
                promedioMasAlto = promedio;
                estudiantePromedioMasAlto = estudiante;
            }

            Prueba prueba3 = estudiante.getPrueba(2);
            int rendimientoPrueba3 = prueba3.getPuntaje();
            if (peorRendimientoPrueba3 > rendimientoPrueba3) {
                peorRendimientoPrueba3 = rendimientoPrueba3;
                estudiantePeorRendimientoPrueba3 = estudiante;
            }

            int saltosAcum = estudiante.saltosAcumulados();
            if (saltosDelMasRegular > saltosAcum) {
                saltosDelMasRegular = saltosAcum;
                estudianteMasRegular = estudiante;
            }

        }
        System.out.printf("El alumno con mayor promedio fue el alumno " + estudiantePromedioMasAlto + " con %f de promedio%n",
                promedioMasAlto);

        System.out.printf("El alumno con el peor rendimiento en la prueba 3 fue el estudiante " + estudiantePeorRendimientoPrueba3 + "con %d puntos%n",
                peorRendimientoPrueba3);

        System.out.printf("El alumno más regular fue el alumno "+ estudianteMasRegular + "%n");
    }

    public void evaluarTodos() {
        for (Estudiante estudiante: listaEstudiantes) {
            estudiante.evaluacionFinal();
        }
    }

    public void mayoresSaltos() {
        for (Estudiante estudiante: listaEstudiantes) {
            estudiante.mayorSalto();
        }
    }

    public void mostrarNotasOrdenadasTodos() {
        System.out.printf("Notas ordenadas de mayor a menor %n");
        for (Estudiante estudiante: listaEstudiantes) {

            estudiante.mostrarNotasOrdenadas();
        }
    }

    public void mostrarProgresoTodos() {
        for (Estudiante estudiante: listaEstudiantes) {
            estudiante.progreso();
        }
    }

    public void mostrarAproboTodasTodos() {
        for (Estudiante estudiante: listaEstudiantes) {
            estudiante.aproboTodas();
        }
    }
}
