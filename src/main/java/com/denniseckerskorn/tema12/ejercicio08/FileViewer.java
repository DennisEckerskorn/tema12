package com.denniseckerskorn.tema12.ejercicio08;

import java.io.*;

public class FileViewer {

    public String viewContentOfFile(File file) {
        if (file.exists() && file.isFile()) {
            StringBuilder content = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
            } catch (FileNotFoundException fnfe) {
                return "Error: Archivo no encontrado - " + file.getAbsolutePath();
            } catch (IOException ioe) {
                return "Error al leer el archivo: " + ioe.getMessage();
            }
            return content.toString();
        } else {
            return "Error: El archivo no existe o no es un archivo válido - " + file.getAbsolutePath();
        }
    }
}
