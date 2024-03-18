package org.example.File;

import org.example.clase.Libro;
import org.example.utils.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class LibreriaImporter {
    public static void importar(String archivo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BufferedReader br = null;
        String line = "";
        String separador = ";";

        try (Session session = HibernateConnection.getSesionFactory().openSession()) {
            br = new BufferedReader(new FileReader(archivo));
            Transaction tx = session.beginTransaction();

            while ((line = br.readLine()) != null) {
                String[] datos = line.split(separador);
                if (datos.length >= 6) {
                    Libro libro = new Libro();
                    libro.setTitulo(datos[0]);
                    libro.setAutor(datos[1]);
                    libro.setAño(datos[2]);
                    libro.setGenero(datos[3]);
                    libro.setIdioma(datos[4]);
                    libro.setSinopsis(datos[5]);
                    libro.setId(null);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    libro.setCreated(timestamp);

                    session.save(libro);
                }
            }

            tx.commit();
            System.out.println("Datos importados correctamente a la base de datos.");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
