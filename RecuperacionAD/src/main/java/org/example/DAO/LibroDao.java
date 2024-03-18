package org.example.DAO;

import org.example.clase.Libro;

import java.util.List;

public interface LibroDao {
    List<Libro> getAll();

    Libro insertarLibro (Libro var1);

    void modificarLibro(Long var1);
}
