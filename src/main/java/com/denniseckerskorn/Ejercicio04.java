package com.denniseckerskorn;

import java.io.File;
import java.text.SimpleDateFormat;

public class Ejercicio04 {
    public Ejercicio04() {
        File file = new File("C:\\Users\\Dennis\\tema12\\ficheros\\testFile.txt");

        if (file.exists() && file.isFile()) {
            System.out.println("El archivo existe y es un archivo");

            // a) Obtener el nombre del archivo:
            String name = file.getName();
            System.out.println("Nombre del archivo: " + name);

            // b) Obtener la ruta absoluta del archivo:
            String absolutePath = file.getAbsolutePath();
            System.out.println("La ruta absoluta del archivo: " + absolutePath);

            // c) ¿El archivo está oculto?
            boolean isHidden = file.isHidden();
            System.out.println("¿El archivo está oculto? " + isHidden);

            // d) ¿El archivo tiene permisos de lectura?
            boolean isReadable = file.canRead();
            System.out.println("¿El archivo tiene permisos de lectura? " + isReadable);
            // e) ¿El archivo tiene permisos de escritura?
            boolean isWritable = file.canWrite();
            System.out.println("¿El archivo tiene permisos de escritura? " + isWritable);

            // f) Fecha de la última modificación:
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dateMod = sdf.format(file.lastModified());
            System.out.println("La última fecha de modificación: " + dateMod);

            // g) Tamaño del archivo en bytes:
            long size = file.length();
            System.out.println("El tamaño del archivo en bytes: " + size);

        } else {
            System.out.println("El archivo no existe o no es un archivo");
        }


    }
}
