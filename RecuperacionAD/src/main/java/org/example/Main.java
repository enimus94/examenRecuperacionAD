package org.example;

import org.example.File.LibreriaImporter;
import org.example.clase.Libro;
import org.example.implementacionDAO.LibroDaoImplement;

import java.sql.Date;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "libreria.csv";
        LibreriaImporter.importar(rutaArchivo);
        LibroDaoImplement libroDao = new LibroDaoImplement();

        // Obtener todos los libros
        System.out.println("Obteniendo todos los libros:");
        List<Libro> listaLibros = libroDao.getAll();
        for (Libro libro : listaLibros) {
            System.out.println(libro);
        }

        // Insertar un nuevo libro
        Libro nuevoLibro = new Libro("Nuevo Título", "Nuevo Autor", "2024", "Género", "Idioma", "Sinopsis", new Date(18-03-2024));
        System.out.println("\nInsertando nuevo libro:");
        libroDao.insertarLibro(nuevoLibro);
        System.out.println("Libro insertado correctamente.");

        // Modificar el libro con ID 3
        Long idLibroAModificar = 3L;
        System.out.println("\nModificando libro con ID " + idLibroAModificar + ":");
        libroDao.modificarLibro(idLibroAModificar);
        System.out.println("Libro con ID " + idLibroAModificar + " modificado correctamente.");
    }


    }
