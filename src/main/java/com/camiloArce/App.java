package com.camiloArce;

import com.camiloArce.model.Articulo;
import com.camiloArce.scraper.Spider;
import com.camiloArce.utils.JsonWriter;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            // URL a scrapear
            String url = "http://books.toscrape.com/";

            // Ejecutar el spider
            Spider spider = new Spider();
            List<Articulo> articulos = spider.ejecutar(url);

            // Guardar los datos en JSON
            String rutaJson = "data/resultados.json";
            JsonWriter.guardarComoJson(articulos, rutaJson);

            System.out.println("Scraping finalizado. Datos guardados en " + rutaJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
