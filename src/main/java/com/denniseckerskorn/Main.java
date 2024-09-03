package com.denniseckerskorn;

import com.denniseckerskorn.tema12.ejercicio05.Ejercicio05;
import com.denniseckerskorn.tema12.ejercicio05.GestionArchivos;
import com.denniseckerskorn.tema12.ejercicio08.FileViewer;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Ejercicio01_02 ejercicio0102 = new Ejercicio01_02();
        // Ejercicio04 ejercicio04 = new Ejercicio04();
        // Ejercicio05 ejercicio05 = new Ejercicio05();
        if (args.length != 1) {
            System.out.println("Uso: java com.denniseckerskorn.Main <ruta-al-archivo>");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        FileViewer fw = new FileViewer();
        String contentFile = fw.viewContentOfFile(file);

        if (contentFile != null) {
            System.out.println(contentFile);
        } else {
            System.out.println("No se puede leer el archivo o está vacio.");
        }
    }
}