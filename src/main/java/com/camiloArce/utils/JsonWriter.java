package com.camiloArce.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.camiloArce.model.Articulo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {

    public static void guardarComoJson(List<Articulo> articulos, String rutaArchivo) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(articulos, writer);
        }
    }
}
