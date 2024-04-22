package com.aluracursos.desafio_challenge_1_back_end.api;

import java.util.LinkedHashMap;

public record ExchangeRateApi(
        String time_last_update_utc,
        String time_next_update_utc,
        LinkedHashMap<String, Double> conversion_rates,
        String base_code
        ) {}
