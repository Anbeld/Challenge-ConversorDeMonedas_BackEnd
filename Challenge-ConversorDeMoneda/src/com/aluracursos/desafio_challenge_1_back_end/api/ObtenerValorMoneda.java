package com.aluracursos.desafio_challenge_1_back_end.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ObtenerValorMoneda {
    private ConversionMoneda conversionMoneda;
    private List<String> historialConversionString = new ArrayList<>();
    private List<ConversionMoneda> historialConversionJson = new ArrayList<>();

    public void getHistorialConversion() {
        this.historialConversionString.forEach(System.out::println);
    }

    public void guardarHistorialJson(){
        ManagementJson managementJson = new ManagementJson();
        try {
            managementJson.generarJsonHistorial(this.historialConversionJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void urlPelicula(String codigoMonedaBase, String codigoMonedaDestino, double valorACambiar) {
        String url;

        HttpResponse<String> json;

        url = "https://v6.exchangerate-api.com/v6/fc66c326b86ef61ec7d17c67/latest/" + codigoMonedaBase;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            json = client.send(request, HttpResponse.BodyHandlers.ofString());

            ManagementJson managementJson = new ManagementJson();

            ExchangeRateApi datosAPI = managementJson.valorMonedaConversion(json);

            this.conversionMoneda = new ConversionMoneda(datosAPI, codigoMonedaDestino, valorACambiar);

        } catch (IOException | InterruptedException  e) {
            System.out.println("La moneda no ha sido encontrada: " + e);
        }
    }

    public void convertirMoneda(String nombreMonedaInicial, 
                                String codigoMonedaInicial,
                                String nombreMonedaDestino,
                                String codigoMonedaDestino,
                                double valorACambiar){

        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));

        double valorMonedaCambio = this.conversionMoneda.valorMonedaDestino;
        double valorConvertido;
        valorConvertido = valorMonedaCambio * valorACambiar;

         String mensajeConversion = """
                ----------------------------------------------------
                Ha convertido de %s (%s) a %s (%s).
                El precio actual de un %s es de: %s (%s).
                %s (%s) es igual a %s (%s)
                
                Última actualización: %s
                Próxima actualización: %s
                
                Fecha de consulta: %s
                ----------------------------------------------------
                """.formatted(
                        nombreMonedaInicial,
                        codigoMonedaInicial,
                        nombreMonedaDestino,
                        codigoMonedaDestino,
                        nombreMonedaInicial,
                        formatoMoneda.format(valorMonedaCambio),
                        codigoMonedaDestino,
                        formatoMoneda.format(valorACambiar),
                        codigoMonedaInicial,
                        formatoMoneda.format(valorConvertido),
                        codigoMonedaDestino,
                        this.conversionMoneda.ultimaActualizacion,
                        this.conversionMoneda.proximaActualizacion,
                        this.conversionMoneda.fechaHoraConversion
                        );

        System.out.println(mensajeConversion);

        this.historialConversionString.add(mensajeConversion);

        this.historialConversionJson.add(conversionMoneda);
    }
}
