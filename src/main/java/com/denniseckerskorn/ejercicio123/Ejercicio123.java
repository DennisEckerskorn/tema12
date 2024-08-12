package com.denniseckerskorn.ejercicio123;

import java.io.File;

public class Ejercicio123 {
    public Ejercicio123() {
        /**
         * Ejercicio 01, 02:
         */
        File file = new File("C:\\Users\\Dennis\\tema12\\ficheros");

        if (file.exists() && file.isDirectory()) {
            System.out.println("Existe y es un directorio");
            String[] listaNombres = file.list();

            if (listaNombres != null) {
                for (String nombre : listaNombres) {
                    System.out.println(nombre);
                }
            } else {
                System.out.println("El directorio está vacío...");
            }
        } else {
            System.out.println("No es un directorio o no existe");
        }

        /**
         * Ejercicio 03:
         */
        String nombreCarpeta = file.getName();
        String rutaAbsoluta = file.getAbsolutePath();
        boolean readable = file.canRead();
        boolean writeable = file.canWrite();

        System.out.println(nombreCarpeta);
        System.out.println(rutaAbsoluta);
        System.out.println(readable);
        System.out.println(writeable);
    }

}
