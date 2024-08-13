package com.denniseckerskorn;

import com.denniseckerskorn.ejercicio05.GestionArchivos;

public class Main {
    public static void main(String[] args) {
        // Ejercicio01_02 ejercicio0102 = new Ejercicio01_02();
        // Ejercicio04 ejercicio04 = new Ejercicio04();
        GestionArchivos ga = new GestionArchivos();
        String ruta = "C:\\Users\\Dennis\\tema12\\ficheros";

        if (ga.crearArchivo(ruta, "tr5.txt")) {
            System.out.println("El archivo se ha creado correctamente ");
        } else {
            System.out.println("No se ha podido crear al archivo");
        }
    }
}