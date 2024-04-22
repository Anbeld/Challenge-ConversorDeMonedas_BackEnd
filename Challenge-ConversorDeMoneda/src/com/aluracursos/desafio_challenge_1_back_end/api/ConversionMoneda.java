package com.aluracursos.desafio_challenge_1_back_end.api;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Locale;

public class ConversionMoneda {
    String fechaHoraConversion;
    String monedaBase;
    String monedaDestino;
    String valorAConvertir;
    double valorMonedaDestino;
    String monedaConvertida;
    String ultimaActualizacion;
    String proximaActualizacion;
    LinkedHashMap<String, Double> valoresDeConversion;

    public ConversionMoneda(ExchangeRateApi datosApi, String codigoMonedaDestino, double valorACambiar) {
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        this.fechaHoraConversion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm-ss"));
        this.monedaBase = datosApi.base_code();
        this.monedaDestino = codigoMonedaDestino;
        this.valorAConvertir = valorACambiar + " " +this.monedaBase;
        this.ultimaActualizacion = datosApi.time_last_update_utc();
        this.proximaActualizacion = datosApi.time_next_update_utc();
        this.valorMonedaDestino = datosApi.conversion_rates().get(codigoMonedaDestino);
        this.monedaConvertida = "%.2f (%s) es igual a %s (%s)"
                .formatted(valorACambiar,
                        this.monedaBase,
                        formatoMoneda.format(valorACambiar * this.valorMonedaDestino),
                        this.monedaDestino);
    }

}
