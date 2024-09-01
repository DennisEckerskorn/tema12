package com.denniseckerskorn.tema12.ejercicio05;

import java.io.File;
import java.io.IOException;

public class GestionArchivos {
    private File file;

    public GestionArchivos(String ruta) {
        file = new File(ruta);
    }

    /**
     * Crea un archivo en el directorio especificado.
     * Si el directorio no existe, se crea automáticamente.
     * Luego se intenta crear el archivo en ese directorio.
     * Si el archivo ya existe o hay un problema al crearlo, se maneja la excepción y se devuelve false.
     *
     * @param directorio ruta donde se va a crear el archivo
     * @param archivo    nombre del archivo que se va a crear (incluyendo la extensión)
     * @return devuelve true si el archivo se ha creado correctamente, de lo contrario devuelve false
     */
    public boolean crearArchivo(String directorio, String archivo) {
        file = new File(directorio);
        if (!file.exists()) {
            if (!file.mkdir()) {
                return false;
            }
        }

        if (file.isDirectory()) {
            File newFile = new File(directorio, archivo);
            try {
                if (newFile.createNewFile()) {
                    return true;
                } else {
                    return false;
                }
            } catch (IOException ioe) {
                System.out.println("Error al crear al archivo " + ioe.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Metodo que permite listar los archivos de un directorio especificio.
     * Muestra el nombre, tipo, tamaño en bytes y permisos de escritura/lectura.
     * TODO: De momento lo muestra en pantalla, se modificzara para que devuelva un String más adelante.
     *
     * @param directorio la ruta del directorio a comprobar
     */
    public void listarDirectorio(String directorio) {
        File dir = new File(directorio);
        if (dir.exists() && dir.isDirectory()) {
            File[] listaArchivos = dir.listFiles();
            if (listaArchivos != null && listaArchivos.length > 0) {
                for (File file : listaArchivos) {
                    String tipo = file.isDirectory() ? "d" : "f";
                    long size = file.length();
                    String permisos = (file.canRead() ? "r" : "-") + (file.canWrite() ? "w" : "-");
                    System.out.println(file.getName() + " " + tipo + " " + size + " bytes " + permisos);
                }
            } else {
                System.out.println("El directorio está vacio");
            }
        } else {
            System.out.println("El directorio no existe o está vacío");
        }
    }

    public void verInfo(String directorio, String archivo) {

    }
}
