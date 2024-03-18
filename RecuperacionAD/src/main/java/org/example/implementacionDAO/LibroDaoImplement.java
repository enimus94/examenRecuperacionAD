package org.example.implementacionDAO;


import org.example.DAO.LibroDao;
import org.example.clase.Libro;
import org.example.utils.HibernateConnection;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LibroDaoImplement implements LibroDao {
    private static final Logger log = Logger.getLogger(LibroDao.class.getName());
    public LibroDaoImplement(){

    }
    @Override
    public List<Libro> getAll() {
        ArrayList<Libro> out = new ArrayList();
        new ArrayList();
        org.hibernate.Session s = HibernateConnection.getSesionFactory().openSession();

        try {
            Query<Libro> q = s.createQuery("FROM Libro", Libro.class);

            try {
                out = (ArrayList<Libro>) q.getResultList();
                log.info("Lista de clientes obtenida con exito");
            } catch (Exception var7) {
                log.severe(var7.getMessage());
            }
        } catch (Throwable var8) {
            if (s != null) {
                try {
                    s.close();
                } catch (Throwable var6) {
                    var8.addSuppressed(var6);
                }
            }

            throw var8;
        }

        if (s != null) {
            s.close();
        }

        return out;

    }

    @Override
    public Libro insertarLibro(Libro libro) {
        Libro libronuevo = libro;
        try {
                org.hibernate.Session s = HibernateConnection.getSesionFactory().openSession();

                try {
                    Transaction t = s.beginTransaction();
                    s.persist(libronuevo);
                    t.commit();
                } catch (Throwable var7) {
                    if (s != null) {
                        try {
                            s.close();
                        } catch (Throwable var6) {
                            var7.addSuppressed(var6);
                        }
                    }

                    throw var7;
                }

                if (s != null) {
                    s.close();
                }
            } catch (Exception var8) {
                System.out.println("FALLO AL HACER TRANSACCIÓN");
            }

            return libro;


    }

    @Override
    public void modificarLibro(Long id) {
        org.hibernate.Session s = HibernateConnection.getSesionFactory().openSession();
        try {
            Libro libroPersistente = (Libro) s.get(Libro.class, id);
            Transaction t = s.beginTransaction();
            s.remove(libroPersistente);
            t.commit();
        } catch (Throwable var6) {
            if (s != null) {
                try {
                    s.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }
            }

            throw var6;
        }

        if (s != null) {
            s.close();
        }


    }


}
