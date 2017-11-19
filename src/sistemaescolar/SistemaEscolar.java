/*
 * The MIT License
 *
 * Copyright 2017 Gustavo-A Salazar.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package sistemaescolar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gustavo-A Salazar
 */
public class SistemaEscolar {

    private static ArrayList<Profesor> profesores = new ArrayList<>();
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private static final String RUTA_BASE = "D:\\Projects_NetBeans\\SistemaEscolar\\src\\recursos\\";
    private static final String ESTUDIANTES = RUTA_BASE + "Estudiantes.txt";
    private static final String PROFESORES = RUTA_BASE + "Profesores.txt";
    private static final String ASIGNATURAS = RUTA_BASE + "Asignaturas.txt";
    private static boolean regresar = true, menuEstudiante = true, menuProfesor = true, menuAdmin = true;

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Scanner entrada = new Scanner(System.in);
        while (regresar) {
            System.out.print("¡Bienvenido al Sistema Escolar!\n");
            System.out.print("Eliga una opción:\n1.Administrador\n2.Profesor\n3.Estudiante\n4.Salir\nIngrese el número correspondiente:");
            int privilegio = entrada.nextInt();
            File archivoProfesores, archivoEstudiantes, archivoAsignaturas;
            FileInputStream fiStream;
            ObjectInputStream objetoIn;
            int id;
            menuAdmin = true;
            menuProfesor = true;
            menuEstudiante = true;
            switch (privilegio) {
                case 1:
                    archivoProfesores = new File(PROFESORES);
                    archivoEstudiantes = new File(ESTUDIANTES);
                    archivoAsignaturas = new File(ASIGNATURAS);
                    if (archivoProfesores.exists()) {
                        //Cargamos el archivo Profesores.txt
                        fiStream = new FileInputStream(archivoProfesores);
                        objetoIn = new ObjectInputStream(fiStream);
                        profesores = (ArrayList<Profesor>) objetoIn.readObject();
                        objetoIn.close();

                    }
                    if (archivoEstudiantes.exists()) {
                        //Cargamos el archivo Estudiantes.txt
                        fiStream = new FileInputStream(archivoEstudiantes);
                        objetoIn = new ObjectInputStream(fiStream);
                        estudiantes = (ArrayList<Estudiante>) objetoIn.readObject();
                        objetoIn.close();
                    }
                    if (archivoAsignaturas.exists()) {
                        //Cargamos el archivo Estudiantes.txt
                        fiStream = new FileInputStream(archivoAsignaturas);
                        objetoIn = new ObjectInputStream(fiStream);
                        asignaturas = (ArrayList<Asignatura>) objetoIn.readObject();
                        objetoIn.close();
                    }
                    while (menuAdmin) {
                        int opcion;
                        System.out.print("\n¡Bienvenido Administrador!\n¿Qué desea hacer?");
                        System.out.print("\n1.Agregar Profesor\n2.Agregar Estudiante\n3.Agregar Asignatura\n4.Mostrar Profesores\n5.Mostrar Estudiantes\n6.Mostrar Asignaturas\n7.Guardar cambios\n8.Regresar al menú anterior\nIngrese el número correspondiente:");
                        opcion = entrada.nextInt();
                        String nombre;
                        String materia;
                        switch (opcion) {
                            case 1:
                                System.out.print("\nIngrese el primer nombre del Profesor: ");
                                nombre = entrada.next();
                                System.out.print("\nIngrese el segundo nombre del Profesor: ");
                                nombre = nombre +" "+ entrada.next();
                                System.out.print("\nIngrese el primer apellido del Profesor: ");
                                nombre = nombre +" "+ entrada.next();
                                System.out.print("\nIngrese el segundo apellido del Profesor: ");
                                nombre = nombre +" "+ entrada.next();
                                System.out.print("\nIngrese el nombre de la materia que imparte: ");
                                materia = entrada.next();
                                if (profesores.isEmpty()) {
                                    profesores.add(new Profesor(0, nombre, materia));
                                } else {
                                    profesores.add(new Profesor(profesores.size() - 1, nombre, materia));
                                }
                                break;
                            case 2:
                                System.out.print("\nIngrese el primer nombre del Estudiante: ");
                                nombre = entrada.next();
                                System.out.print("\nIngrese el segundo nombre del Estudiante: ");
                                nombre = nombre +" "+ entrada.next();
                                System.out.print("\nIngrese el primer apellido del Estudiante: ");
                                nombre = nombre +" "+ entrada.next();
                                System.out.print("\nIngrese el segundo apellido del Estudiante: ");
                                nombre = nombre +" "+ entrada.next();
                                if (estudiantes.isEmpty()) {
                                    estudiantes.add(new Estudiante(0, nombre));
                                } else {
                                    estudiantes.add(new Estudiante(estudiantes.size() - 1, nombre));
                                }
                                break;
                            case 3:
                                System.out.print("\nIngrese el nombre de la Asignatura: ");
                                nombre = entrada.next();
                                asignaturas.add(new Asignatura(nombre));
                                break;
                            case 4:
                                System.err.println("Lista de Profesores");
                                for (int i = 0; i < profesores.size(); i++) {
                                    System.out.println(profesores.get(i).getId() + " " + profesores.get(i).getNombreCompleto() + " " + profesores.get(i).getMateriaQueimparte());
                                }
                                break;
                            case 5:
                                System.err.println("Lista de Estudiantes");
                                for (int i = 0; i < estudiantes.size(); i++) {
                                    System.out.println(estudiantes.get(i).getId() + " " + estudiantes.get(i).getNombreCompleto());
                                }
                                break;
                            case 6:
                                System.err.println("Lista de Asignaturas");
                                for (int i = 0; i < asignaturas.size(); i++) {
                                    System.out.println(asignaturas.get(i).getNombre());
                                }
                                break;
                            case 7:
                                guardarArchivo(PROFESORES, "Profesores");
                                guardarArchivo(ESTUDIANTES, "Estudiantes");
                                guardarArchivo(ASIGNATURAS, "Asignaturas");
                                break;
                            case 8:
                                menuAdmin = false;
                                break;
                            default:
                                System.out.println("\nLa opción seleccionada no existe.");
                        }
                    }
                    break;
                case 2:
                    archivoProfesores = new File(PROFESORES);
                    archivoEstudiantes = new File(ESTUDIANTES);
                    if (!archivoEstudiantes.exists() | !archivoProfesores.exists()) {
                        System.out.println("Debe iniciar como Administrador para poder agregar Profesores y Estudiantes al sistema.");
                        break;
                    }
                    //Cargamos el archivo Profesores.txt
                    fiStream = new FileInputStream(archivoProfesores);
                    objetoIn = new ObjectInputStream(fiStream);
                    profesores = (ArrayList<Profesor>) objetoIn.readObject();
                    objetoIn.close();
                    //Cargamos el archivo Estudiantes.txt
                    fiStream = new FileInputStream(archivoEstudiantes);
                    objetoIn = new ObjectInputStream(fiStream);
                    estudiantes = (ArrayList<Estudiante>) objetoIn.readObject();
                    objetoIn.close();
                    System.out.print("\nIngrese su ID: ");
                    id = entrada.nextInt();
                    while (menuProfesor) {
                        int opcion;
                        System.out.print("\n¡Bienvenido profesor " + profesores.get(id).getNombreCompleto() + "!\n¿Qué desea hacer?");
                        System.out.print("\n1.Calificar\n2.Guardar cambios\n3.Regresar al menú anterior\nIngrese el número correspondiente:");
                        opcion = entrada.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.print("\nIngrese el ID del estudiante: ");
                                int idEstudiante = entrada.nextInt();
                                if (idEstudiante > estudiantes.size() - 1) {
                                    System.out.println("\nNo existe tal Estudiante con id=" + idEstudiante);
                                    break;
                                }
                                System.out.print("\nIngrese la calificación del estudiante: ");
                                int calificacionEstudiante = entrada.nextInt();
                                estudiantes.get(idEstudiante).setCalificacion(calificacionEstudiante);
                                break;
                            case 2:
                                guardarArchivo(ESTUDIANTES, "Estudiantes");
                                break;
                            case 3:
                                menuProfesor = false;
                                break;
                            default:
                                System.out.println("\nLa opción seleccionada no existe.");
                        }
                    }
                    break;
                case 3:
                    archivoEstudiantes = new File(ESTUDIANTES);
                    if (!archivoEstudiantes.exists()) {
                        System.out.println("No existen Estudiantes inscritos. Debe iniciar como Administrador para poder agregar estudiantes al sistema.");
                        break;
                    }
                    //Cargamos el archivo Estudiantes.txt
                    fiStream = new FileInputStream(archivoEstudiantes);
                    objetoIn = new ObjectInputStream(fiStream);
                    estudiantes = (ArrayList<Estudiante>) objetoIn.readObject();
                    objetoIn.close();
                    System.out.print("\nIngrese su ID: ");
                    id = entrada.nextInt();
                    while (menuEstudiante) {
                        int opcion;
                        System.out.print("\n¡Bienvenido " + estudiantes.get(id).getNombreCompleto() + "!\n¿Qué desea hacer?");
                        System.out.print("\n1.Inscribirme\n2.Retirarme\n3.Solicitar ausencia\n4.Guardar cambios\n5.Regresar al menú anterior\nIngrese el número correspondiente.");
                        opcion = entrada.nextInt();
                        switch (opcion) {
                            case 1:
                                estudiantes.get(id).setInscrito(true);
                                break;
                            case 2:
                                estudiantes.get(id).setRetirado(true);
                                break;
                            case 3:
                                estudiantes.get(id).setSolicitarAusencia("EnProgreso");
                                break;
                            case 4:
                                FileOutputStream FOStream = new FileOutputStream(archivoEstudiantes);
                                ObjectOutputStream ObjetoOut = new ObjectOutputStream(FOStream);
                                ObjetoOut.writeObject(estudiantes);
                                ObjetoOut.flush();
                                ObjetoOut.close();
                                break;
                            case 5:
                                menuEstudiante = false;
                                break;
                            default:
                                System.out.println("\nLa opción seleccionada no existe.");
                        }
                    }
                    break;
                case 4:
                    regresar = false;
                    break;
                default:
                    System.out.println("\nLa opción seleccionada no existe.");
            }
        }
        System.exit(0);
    }

    public static boolean guardarArchivo(String ruta, String archivo) throws IOException {
        if (ruta.equals("")) {
            return false;
        }
        FileOutputStream FOStream = new FileOutputStream(ruta);
        ObjectOutputStream ObjetoOut = new ObjectOutputStream(FOStream);
        switch (archivo) {
            case "Asignaturas":
                ObjetoOut.writeObject(asignaturas);
                break;
            case "Profesores":
                ObjetoOut.writeObject(profesores);
                break;
            case "Estudiantes":
                ObjetoOut.writeObject(estudiantes);
                break;
            default:
                System.out.println("ERROR - No se puede guardar tal Campo");
        }
        ObjetoOut.flush();
        ObjetoOut.close();
        return true;
    }

    public static boolean cargarArchivo(String ruta, String archivo) throws IOException, ClassNotFoundException {
        if (ruta.equals("")) {
            return false;
        }
        FileInputStream fiStream = new FileInputStream(ruta);
        ObjectInputStream objetoIn = new ObjectInputStream(fiStream);
        switch (archivo) {
            case "Asignaturas":
                asignaturas = (ArrayList<Asignatura>) objetoIn.readObject();
                break;
            case "Profesores":
                profesores = (ArrayList<Profesor>) objetoIn.readObject();
                break;
            case "Estudiantes":
                estudiantes = (ArrayList<Estudiante>) objetoIn.readObject();
                break;
            default:
                System.out.println("ERROR - No se puede cargar tal Archivo");
        }
        objetoIn.close();
        return true;
    }
}
