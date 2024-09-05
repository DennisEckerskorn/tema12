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
            System.out.println("Solo se debe especificar 1 argumento");
            for(String arg : args) {
                System.out.println(arg);
            }
        }

        String fileName = args[0];
        File file = new File(fileName);

        FileViewer fw = new FileViewer();
        String contentFile = fw.viewContentOfFile(file);

        if (contentFile != null && !contentFile.isEmpty()) {
            System.out.println(contentFile);
        } else {
            System.out.println("El archivo no existe o está vacío.");
        }
    }
}