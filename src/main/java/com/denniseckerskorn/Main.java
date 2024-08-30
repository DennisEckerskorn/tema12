package com.denniseckerskorn;

import com.denniseckerskorn.ejercicio05.GestionArchivos;

public class Main {
    public static void main(String[] args) {
        // Ejercicio01_02 ejercicio0102 = new Ejercicio01_02();
        // Ejercicio04 ejercicio04 = new Ejercicio04();
        String ruta = "/Users/dennis/Documents/pruebasFicherosTema12";
        GestionArchivos ga = new GestionArchivos(ruta);

        if (ga.crearArchivo(ruta, "tr3.txt")) {
            System.out.println("El archivo se ha creado correctamente ");
            ga.listarDirectorio(ruta);
        } else {
            System.out.println("No se ha podido crear al archivo");
        }
    }
}