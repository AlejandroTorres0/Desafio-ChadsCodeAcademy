public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Pedro");
        Prueba prueba1 = new Prueba(80);
        Prueba prueba2 = new Prueba(88);
        Prueba prueba3 = new Prueba(89);
        estudiante1.agregarPrueba(prueba1);
        estudiante1.agregarPrueba(prueba2);
        estudiante1.agregarPrueba(prueba3);
        estudiante1.generarNotasFaltantes();

        Estudiante estudiante2 = new Estudiante("Sofia");
        Prueba prueba11 = new Prueba(35);
        Prueba prueba21 = new Prueba(26);
        Prueba prueba31 = new Prueba(29);
        estudiante2.agregarPrueba(prueba11);
        estudiante2.agregarPrueba(prueba21);
        estudiante2.agregarPrueba(prueba31);
        estudiante2.generarNotasFaltantes();

        Estudiante estudiante3 = new Estudiante("Agustin");
        Prueba prueba12 = new Prueba(56);
        Prueba prueba22 = new Prueba(76);
        Prueba prueba32 = new Prueba(89);
        estudiante3.agregarPrueba(prueba12);
        estudiante3.agregarPrueba(prueba22);
        estudiante3.agregarPrueba(prueba32);
        estudiante3.generarNotasFaltantes();

        Estudiante estudiante4 = new Estudiante("Pepe");
        Prueba prueba13 = new Prueba(61);
        Prueba prueba23 = new Prueba(73);
        Prueba prueba33 = new Prueba(43);
        estudiante4.agregarPrueba(prueba13);
        estudiante4.agregarPrueba(prueba23);
        estudiante4.agregarPrueba(prueba33);
        estudiante4.generarNotasFaltantes();

        CodeChadsAcademy codeChadsAcademy = new CodeChadsAcademy();
        codeChadsAcademy.agregarEstudiante(estudiante1);
        codeChadsAcademy.agregarEstudiante(estudiante2);
        codeChadsAcademy.agregarEstudiante(estudiante3);
        codeChadsAcademy.agregarEstudiante(estudiante4);

        //2.1 Verificar si aprobó todas
        codeChadsAcademy.mostrarAproboTodasTodos();

        //2.2 Mayor incosistencia , tomo otro alumno
        codeChadsAcademy.mayoresSaltos();

        //2.3 Progreso
        codeChadsAcademy.mostrarProgresoTodos();

        //2.4 Mostrar notas ordenadas
        codeChadsAcademy.mostrarNotasOrdenadasTodos();

        //2.5 Evaluación final por nivel
        codeChadsAcademy.evaluarTodos();

        //2.6 "Ranking" de 4 alumnos
        codeChadsAcademy.generarRanking();
    }

}
