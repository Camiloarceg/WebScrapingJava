package com.camiloArce.scraper;

import com.camiloArce.model.Articulo;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Articulo> extraerArticulos(Document document) {
        List<Articulo> articulos = new ArrayList<>();

        // Cada libro está dentro de <article class="product_pod">
        Elements libros = document.select("article.product_pod");

        for (Element libro : libros) {
            // Extraer el título (atributo title)
            Element enlace = libro.selectFirst("h3 a");
            String titulo = enlace.attr("title");

            // Extraer el precio (dentro de p.price_color)
            String precio = libro.selectFirst("p.price_color").text();

            // Extraer la URL del libro (atributo href)
            String url = enlace.attr("href");

            // Agregar a la lista
            articulos.add(new Articulo(titulo, precio, url));
        }

        return articulos;
    }
}
