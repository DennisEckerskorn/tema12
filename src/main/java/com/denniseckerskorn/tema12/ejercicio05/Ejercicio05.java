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

    /**
     * Menu que permite seleccionar los métodos solicitados.
     */
    private void menu() {
        int option = -1;
        do {
            System.out.println("GESTION DE ARCHIVOS");
            System.out.println("1. Crear archivo");
            System.out.println("2. Listar Directorio");
            System.out.println("3. Ver información");
            System.out.println("4. Leer contenido de un archivo");
            System.out.println("5. Leer archivo binario a hexadecimal");
            System.out.println("0. Salir");
            option = LibIO.requestInt("Seleccione una opción", 0, 5);

            switch (option) {
                case 1:
                    newFile();
                    break;
                case 2:
                    listDirectory();
                    break;
                case 3:
                    viewFileInfo();
                    break;
                case 4:
                    readFile();
                    break;
                case 5:
                    readBinaryToHexa();
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

    /**
     * Método que realiza el proceso de validar y crear la ruta y/o archivo
     */
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

    /**
     * Método que permite ver el contenido de un directorio:
     */
    private void listDirectory() {
        System.out.println("Contenido del directorio:");
        ga.listarDirectorio(rutaDefecto);
    }

    /**
     * Método que permite ver la información de un archivo dentro de un directorio.
     */
    private void viewFileInfo() {
        String nombreArchivo = LibIO.requestString("Introduce el nombre del archivo o directorio:");
        System.out.println("Información:");
        ga.verInfo(rutaDefecto, nombreArchivo.trim());
    }


    /**
     * EJERCICIO 6:
     * Metodo que permite mostrar el contenido de un archivo que existe.
     */
    private void readFile() {
        String nombreArchivo = LibIO.requestString("Introduce el nombre del archivo que quieras leer:");
        //System.out.println("Contenido del archivo:");
        String contenido = ga.viewContentOfFile(rutaDefecto, nombreArchivo);
        if (contenido != null) {
            System.out.println("Contenido:");
            System.out.println(contenido);
        } else {
            System.out.println("No se puede leer el contenido del archivo o el archivo no existe.");
        }
    }

    /**
     * EJERCICIO 7:
     * Método que permite mostrar el contenido de un archivo convertido a hecadecimal.
     */
    private void readBinaryToHexa() {
        String nombreArchivo = LibIO.requestString("Introduce el nombre del archivo binario que quieras convertir a Hexadecimal");
        String contenido = ga.viewContentofBinaryFileToHexa(rutaDefecto, nombreArchivo);
        if (contenido != null) {
            System.out.println("Contenido");
            System.out.println(contenido);
        } else {
            System.out.println("No se puede leer el archivo o no existe");
        }
    }
}
