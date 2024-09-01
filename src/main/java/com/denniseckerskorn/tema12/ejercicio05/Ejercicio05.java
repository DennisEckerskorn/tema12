package com.denniseckerskorn.tema12.ejercicio05;

import com.denniseckerskorn.lib.LibIO;

public class Ejercicio05 {
    private GestionArchivos ga;
    private String rutaDefecto;

    public Ejercicio05() {
        rutaDefecto = "/Users/dennis/Documents/pruebasFicherosTema12";
        ga = new GestionArchivos(rutaDefecto);
        menu();
    }

    private void menu() {
        int option = -1;
        do{
            System.out.println("GESTION DE ARCHIVOS");
            System.out.println("1. Crear archivo");
            System.out.println("2. Listar Directorio");
            System.out.println("3. Ver información");
            System.out.println("0. Salir");
            option = LibIO.requestInt("Seleccione una opción", 0, 4);

            switch (option) {
                case 1:
                    newFile();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (option != 0);
    }

    private void newFile() {
        System.out.println("La ruta por defecto es: " + rutaDefecto);
        String nombreArchivo = LibIO.requestString("Introduce el nombre del archivo con su extensión:");
        if (ga.crearArchivo(rutaDefecto, nombreArchivo.trim())) {
            System.out.println("El archivo se ha creado correctamente");
            //ga.listarDirectorio(rutaDefecto);
        } else {
            System.out.println("No se ha podido crear al archivo");
        }
    }
}
