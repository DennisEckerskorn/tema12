package com.denniseckerskorn.tema12.ejercicio05;

import java.io.*;
import java.util.Objects;

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

    /**
     * Metodo que permite recibir 2 parámetros, el directorio padre y el archivo que específico que cuelga de ese directorio.
     * Si el directorio y el archivo existen muestra la información del archivo especificado.
     * TODO: Adaptar método para que devuelva un String con el resultado, para no usar println...
     *
     * @param directorio Directorio padre
     * @param archivo    Archivo que está dentro del directorio padre
     */
    public void verInfo(String directorio, String archivo) {
        File dir = new File(directorio, archivo);
        if (dir.exists()) {
            String nameDir = dir.getName();
            String absolutePath = dir.getAbsolutePath();
            boolean canWrite = dir.canWrite();
            boolean canRead = dir.canRead();
            long size = dir.length();
            boolean isDir = dir.isDirectory();
            boolean isFile = dir.isFile();
            System.out.println("Nombre: " + nameDir + ", ruta absoluta: " + absolutePath + ", escribir: " + canWrite +
                    ", leer: " + canRead + ", tamanyo: " + size + ", es carpeta: " + isDir + ", es archivo: " + isFile);
        } else {
            System.out.println("El archivo o directorio no existe");
        }
    }

    /**
     * EJERCICIO 6:
     * Método que lee el contenido de un archivo y lo devuelve como una cadena de texto.
     *
     * @param directory La ruta del directorio donde se encuentra el archivo.
     * @param file      El nombre del archivo que se va a leer.
     * @return El contenido del archivo como una cadena de texto, o null si el archivo no existe,
     * no es un archivo regular, o si ocurre un error durante la lectura.
     * @throws FileNotFoundException Si el archivo no se encuentra.
     * @throws IOException           Si ocurre un error al leer el archivo.
     */

    public String viewContentOfFile(String directory, String file) {
        File dir = new File(directory, file);
        if (dir.exists() && dir.isFile()) {
            StringBuilder fileContent = new StringBuilder();
            try
                    (FileReader fr = new FileReader(dir);
                     BufferedReader br = new BufferedReader(fr)) {

                String line;
                while ((line = br.readLine()) != null) {
                    fileContent.append(line).append("\n");
                }
            } catch (FileNotFoundException fnfe) {
                System.out.println("File not found: " + fnfe.getMessage());
                return null;
            } catch (IOException io) {
                System.out.println("Read file error: " + io.getMessage());
                return null;
            }
            return fileContent.toString();
        } else {
            return null;
        }
    }

    /**
     * EJERCICIO 7:
     * Método que permite leer los bytes de un archivo cualquiera y los convierte a su representación en hexadecimal.
     * Cada byte se representa por dos dígitos hexadecimales y los bytes se agrupan en pares.
     * Se agrega un espacio entre cada par de bytes y un salto de línea después de 16 bytes (8 pares).
     *
     * @param directory Directorio donde se encuentra el archivo que se va a leer.
     * @param file      Nombre del archivo que se va a leer desde el directorio especificado.
     * @return Una cadena con el contenido del archivo en formato hexadecimal o null si no se puede leer,
     * si el archivo está vacío o si ocurre un error de E/S.
     */
    public String viewContentofBinaryFileToHexa(String directory, String file) {
        File binaryFile = new File(directory, file);
        if (binaryFile.exists() && binaryFile.isFile()) {
            StringBuilder fileContent = new StringBuilder();
            try (FileInputStream fis = new FileInputStream(binaryFile)) {
                int byteRead;
                int counter = 0;

                while ((byteRead = fis.read()) != -1) {
                    fileContent.append(String.format("%02X", byteRead));
                    counter++;
                    if (counter % 2 == 0) {
                        fileContent.append(" ");
                    }
                    if (counter % 16 == 0) {
                        fileContent.append("\n");
                    }
                }
            } catch (FileNotFoundException fnfe) {
                return fnfe.getMessage();
            } catch (IOException ioe) {
                return ioe.getMessage();
            }
            return fileContent.toString();
        } else {
            return null;
        }
    }

    public File getFile() {
        return file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GestionArchivos that = (GestionArchivos) o;
        return Objects.equals(file, that.file);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(file);
    }

}
