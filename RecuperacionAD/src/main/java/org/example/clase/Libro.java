package org.example.clase;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "libros")
public class Libro implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private Long id;

    @Column( name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column( name = "año")
    private String año;
    @Column( name = "genero")
    private String genero;
    @Column( name = "idioma")
    private String idioma;
    @Column( name = "sinopsis")

    private String sinopsis;
    @Column( name = "created")

    private Date created;

    public Libro(){

    }

    public Libro(Long id, String titulo, String autor, String año, String genero, String idioma, String sinopsis, Date created) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.genero = genero;
        this.idioma = idioma;
        this.sinopsis = sinopsis;
        this.created = created;
    }

    public Libro(String titulo, String autor, String año, String genero, String idioma, String sinopsis, Date created) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.genero = genero;
        this.idioma = idioma;
        this.sinopsis = sinopsis;
        this.created = created;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", año='" + año + '\'' +
                ", genero='" + genero + '\'' +
                ", idioma='" + idioma + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", created=" + created +
                '}';
    }
}
