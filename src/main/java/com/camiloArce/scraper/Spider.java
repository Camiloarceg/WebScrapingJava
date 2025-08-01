package com.camiloArce.scraper;

import com.camiloArce.model.Articulo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class Spider {

    public List<Articulo> ejecutar(String url) throws IOException {
        // Conectarse a la URL con cabeceras y User-Agent para evitar bloqueos (403)
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .referrer("http://www.google.com")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Accept", "text/html")
                .timeout(10000) // 10 segundos
                .get();

        // Extraer artículos con el parser
        return Parser.extraerArticulos(document);
    }
}
