package com.denniseckerskorn.ejercicio05;

import java.io.File;
import java.io.IOException;

public class GestionArchivos {
    private File file;

    public GestionArchivos() {
        file = null;
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

    public void listarDirectorio(String directorio) {

    }

    public void verInfo(String directorio, String archivo) {

    }
}
