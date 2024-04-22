package com.aluracursos.desafio_challenge_1_back_end.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ManagementJson {
    public void generarJsonHistorial(List<ConversionMoneda> historial) throws IOException {
        String fechaHistorialConversion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH-mm-ss"));
        String urlHistorial = "src/com/aluracursos/desafio_challenge_1_back_end/historial/historialConversiones-" +
                fechaHistorialConversion +
                ".json";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        FileWriter writer = new FileWriter(urlHistorial, true);
        writer.write(gson.toJson(historial));
        writer.close();
    }

    public ExchangeRateApi valorMonedaConversion(HttpResponse<String> json){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        return gson.fromJson(json.body(), ExchangeRateApi.class);
    }
}
