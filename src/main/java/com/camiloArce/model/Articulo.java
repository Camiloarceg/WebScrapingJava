package com.camiloArce.model;

public class Articulo {
    private String titulo;
    private String precio;
    private String url;

    public Articulo(String titulo, String precio, String url) {
        this.titulo = titulo;
        this.precio = precio;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPrecio() {
        return precio;
    }

    public String getUrl() {
        return url;
    }
}

