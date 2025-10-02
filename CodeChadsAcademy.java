public class ChadsCodeAcademy {
	public static void main(String[] args) {	
        int[][] alumnos = {
            {80, 70, 59, 0, 0},  // Alumno 1: [Nota 1, Nota 2, Nota 3]
            {60, 90, 75, 0, 0},  // Alumno 2
            {35, 20, 15, 0, 0},  // Alumno 3
            {90, 100, 60, 0, 0}  // Alumno 4
        };

		//1
		for (int i = 0; i < alumnos.length; i++) {
			calcularNotasFaltantes(alumnos[i]);
		}
	
		//Muestra todas las notas 
		for (int i = 0; i < alumnos.length; i++) {
			System.out.printf("Alumno %d%n", i + 1);
			for (int j = 0; j < alumnos[i].length; j++) {
				System.out.println(alumnos[i][j]);
			}
			System.out.printf("%n");
		}

		//2.1 Verificar si aprobó todas, tomo solo 1 alumno
		int[] notasAlumno = alumnos[1]; //Alumno 2
		materiasAprobadas(notasAlumno);

		//2.2 Mayor incosistencia , tomo otro alumno
		notasAlumno = alumnos[3]; //Alumno 4
		int saltosAcum = sacarAlumnoRegularYEmitirMayorSalto(notasAlumno, true);

		//2.3 Progreso 
		notasAlumno = alumnos[0]; //Alumno 1
		progreso(notasAlumno);

		//2.4 Notas ordenadas 
		notasAlumno = alumnos[3];
		ordenarBurbuja(notasAlumno);
		for (int i = 0; i < notasAlumno.length; i++) {
			System.out.println(notasAlumno[i]);
		}

		//2.5 
		notasAlumno = alumnos[2];
		float promedio_t = sacarPromedioYEmitirTitulo(notasAlumno, true); 

		//6
		ranking(alumnos);
	}
		//1era parte
		public static void calcularNotasFaltantes(int[] notas) {
			if (notas[1] >= 60) {
				notas[3] = notas[1];
			}
			else {
				notas[3] = 100;
			}

			int notaExamenUnoYDos = notas[0] + notas[2];
			
			if (notaExamenUnoYDos > 150) {
				notas[4] = 95;
			}
			else {
				notas[4] = 70;
			}
		}

		//2.1
		public static void materiasAprobadas(int[] notas) {
			int materiasAprobadas = 0; 
			for (int i = 0; i < notas.length; i++) {
				if (notas[i] >= 60) materiasAprobadas = materiasAprobadas + 1;
			}

			if (materiasAprobadas == notas.length) {
				System.out.printf("Resultado: Aprobaste todas. ¡Backend Sensei!%n");
			}
			else {
				if  (materiasAprobadas > 0) { 
					System.out.printf("Resultado: Algunas aprobadas. Sos un refactor en progreso.%n");
				}
				else {
					System.out.printf("Resultado: No aprobaste ninguna. ¡Sos un clon de frontend!%n");
				}
			}
		}


		//2.2
		public static int sacarAlumnoRegularYEmitirMayorSalto(int[] notas, boolean emitirMayorSalto) { 
			int mayorSalto = 0;
			int mayorSaltoPosicion1 = 0; 
			int mayorSaltoPosicion2 = 1; 
			int notaAnterior = 0;
			int saltosAcum = 0; 
			for (int i = 0; i < notas.length; i++) { 
				int salto;
				salto = notas[i] - notaAnterior;

				saltosAcum = saltosAcum + salto; 

				if ((i > 0) && (mayorSalto < salto)) {
					mayorSalto = salto;
					mayorSaltoPosicion1 = i - 1; 
					mayorSaltoPosicion2 = i;
				}

				notaAnterior = notas[i];
			}
			if (emitirMayorSalto) {
				System.out.printf("Mayor salto fue de %d puntos entre la prueba %d y la prueba %d%n",
				mayorSalto, 
				mayorSaltoPosicion1 + 1, 
				mayorSaltoPosicion2 + 1);
			}

			return saltosAcum;
		}

		//2.3
		public static void progreso(int[] notas) { 
			boolean progresivo = true;
			int notaAnterior = 0; 	
			for (int i = 0; i < notas.length; i++) {
				if (!(notas[i] > notaAnterior)) {
					progresivo = false; 
					break;
				} 

				notaAnterior = notas[i];
			}
			if (progresivo) {
				System.out.printf("¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento 📈%n");
			}
		}

		//2.4
		public static void ordenarBurbuja(int[] array) {
			int n = array.length;
			boolean intercambiado;
			for (int i = 0; i < n - 1; i++) {
				intercambiado = false;
				for (int j = 0; j < n - 1 - i; j++) {
					if (array[j] < array[j + 1]) {
						int temporal = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temporal;
						intercambiado = true; 
					}
				}
				if (!intercambiado) {
					break;
				}
			}
		}

		//2.5 
		public static float sacarPromedioYEmitirTitulo(int[] notas, boolean emitirTitulo) {
			int notasAcumuladas = 0;
			for (int i = 0; i < notas.length; i++) {
				notasAcumuladas = notasAcumuladas + notas[i];
			}
			float promedio = (float) notasAcumuladas / notas.length;

			if (emitirTitulo) {
				if (notasAcumuladas >= 450 ) {
					System.out.printf("Stone Chad definitivo 💪%n");
				}
				else if ((notasAcumuladas >= 350) && (notasAcumuladas <= 499)) {
					System.out.printf("Chad%n");
				}
				else if ((notasAcumuladas >= 250) && (notasAcumuladas <= 349)) {
					System.out.printf("Soft Chad%n");
				}
				else {
					System.out.printf("Normie total 😢%n");
				}
			}
			return promedio; 
		}
		

		//2.6
		public static void ranking(int[][] alumnos) {
			float promedioMasAlto = 0;
			int alumnoConMayorPromedio = 0;

			int peorRendimientoPrueba3 = Integer.MAX_VALUE;
			int alumnoPeorRendimientoPrueba3 = 0;

			int saltosDelMasRegular = Integer.MAX_VALUE;
			int alumnoMasRegular = 0;	
			for (int i = 0; i < alumnos.length; i++) {
				float promedio = sacarPromedioYEmitirTitulo(alumnos[i], false);
				if (promedio > promedioMasAlto) {
					promedioMasAlto = promedio;
					alumnoConMayorPromedio = i + 1;	
				}

				int rendimientoPrueba3 = alumnos[i][2];
				if (peorRendimientoPrueba3 > rendimientoPrueba3) {
					peorRendimientoPrueba3 = rendimientoPrueba3;
					alumnoPeorRendimientoPrueba3 = i + 1;
				}	

				int saltosDelAlumno = sacarAlumnoRegularYEmitirMayorSalto(alumnos[i], false); 
				if (saltosDelMasRegular > saltosDelAlumno) {
					saltosDelMasRegular = saltosDelAlumno;
					alumnoMasRegular = i + 1;
				}
				
			}
			System.out.printf("El alumno con mayor promedio fue el alumno %d con %f de promedio%n", 
					alumnoConMayorPromedio, 
					promedioMasAlto);
			
			System.out.printf("El alumno con el peor rendimiento en la prueba 3 fue el Alumno %d con %d puntos%n", 
					alumnoPeorRendimientoPrueba3, 
					peorRendimientoPrueba3);

			System.out.printf("El alumno más regular fue el alumno %d%n", alumnoMasRegular);
		}
}