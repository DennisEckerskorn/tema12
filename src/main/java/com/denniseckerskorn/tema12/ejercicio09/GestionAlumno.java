package com.denniseckerskorn.tema12.ejercicio09;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GestionAlumno {
    private final List<Alumno> alumnos;
    private final File archivo;

    public GestionAlumno(String directorio, String nombreArchivo) {
        this.alumnos = new ArrayList<>();
        this.archivo = new File(directorio, nombreArchivo);
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public File getArchivo() {
        return archivo;
    }

    public boolean addAlumnoToList(Alumno alumno) {
        return alumnos.add(alumno);
    }

    public boolean removeAlumnoFromList(Alumno alumno) {
        for(int i = 0; i < alumnos.size(); i++) {
            if(alumnos.get(i).equals(alumno)) {
                alumnos.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GestionAlumno that = (GestionAlumno) o;
        return alumnos.equals(that.alumnos) && archivo.equals(that.archivo);
    }

    @Override
    public int hashCode() {
        int result = alumnos.hashCode();
        result = 31 * result + archivo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GestionAlumno{" +
                "alumnos=" + alumnos +
                ", archivo=" + archivo +
                '}';
    }
}
