import static Inputs.Inputs.*;

public class Menu {


    public static void menu() {

    }

    public void inicio() {
      int opcion;
       do {
         opcion = inputInt("""
                 | 1 | Listar el nombre de todos los estudiantes
                 | 2 | Obtener la edad promedio de los estudiantes.
                 | 3 | Listar los nombres de los grados junto con la cantidad de estudiantes inscritos en cada grado.
                 | 4 | Obtener el nombre de los estudiantes que pertenecen al turno de la mañana.
                 | 5 | Contar la cantidad total de salones asignados a cada grupo
                 | 6 | Contar la cantidad de cursos por grado para estudiantes mayores de 25 años.
                 | 7 | Encontrar los nombres de los cursos que no tienen estudiantes inscritos
                 | 8 | Obtener el nombre y la edad de los estudiantes que están en un grupo específico
                 | 9 |  Listar los nombres de los salones junto con los grupos y grados asignados
                 | 10 | Obtener la cantidad total de estudiantes por turno en el colegio
                 | 11 | Encontrar los nombres de los profesores que imparten asignaturas en salones específicos.
                 | 12 | Obtener el nombre de los estudiantes y las asignaturas asociadas, incluyendo los profesores responsables.
                 | 13 | Listar los nombres de los grados junto con la cantidad de asignaturas impartidas por profesores en esos grados.
                 | 14 | Encontrar los estudiantes mayores de 28 años y las asignaturas que toman, junto con el profesor asignado.
                 | 15 | Obtener el nombre de los cursos y la cantidad de profesores que podrían impartirlos, cruzando datos de ambas bases.
                 | 16 | Listar los salones y los profesores que imparten asignaturas en ellos, relacionando estudiantes y asignaturas
                 | 0 | Salir
                 
                 """);

           switch (opcion) {
               case 1 -> listarNombresEstudiantes();
               case 2 -> edadaPromedioEstudiantes();
               case 3 -> listarGradosYNumeroEstudiantes();
               case 4 -> estudiantesTurnoManana();
               case 5 -> salonesPorGrupo();
               case 6 -> cursosParaMayores();
               case 7 -> cursosVacios();
               case 8 -> nombreYEdadEstudiantesPorGrupo();
               case 9 -> listarSalonesGtuposYGrados();
               case 10 -> totalEstudiantesPorTurno();
               case 11 -> profesoresPorSalones();
               case 12 -> nombreEstudianteConAsignaturaYProfesores();
               case 13 -> nombresGradosYCantidadAsignaturas();
               case 14 -> estudiantesMyores28AsiganturasYProfesores();
               case 15 -> cursosYPosiblesProfesores();
               case 16 -> salonesYnoseqcarjos();
               case 0 -> System.out.println("Adios.");

           }

        }while (opcion != 0);


    }
}
