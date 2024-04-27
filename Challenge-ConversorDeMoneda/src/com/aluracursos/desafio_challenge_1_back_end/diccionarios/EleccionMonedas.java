package com.aluracursos.desafio_challenge_1_back_end.diccionarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class EleccionMonedas {
    private LinkedHashMap<String, String> codigoANombreMoneda = new LinkedHashMap<>();
    private LinkedHashMap<String, String> codigosMonedasNoSeleccionadas = new LinkedHashMap<>();
    private LinkedHashMap<String, String> monedasMenuInicial = new LinkedHashMap<>();
    private LinkedHashMap<Integer, String> eleccionMonedaInicial = new LinkedHashMap<>();
    private LinkedHashMap<Integer, String> eleccionMonedaDestino = new LinkedHashMap<>();

    private String codigoMonedaInical;
    private String codigoMonedaDestino;

    private int contadorFormatoOutput = 0;

    public int getContadorFormatoOutput() {
        return this.contadorFormatoOutput;
    }

    public String getCodigoMonedaInical() {
        return codigoMonedaInical;
    }

    public String getCodigoMonedaDestino() {
        return codigoMonedaDestino;
    }

    public String getNombreMonedaInical() {
        return this.codigoANombreMoneda.get(codigoMonedaInical);
    }

    public String getNombreMonedaDestino() {
        return this.codigoANombreMoneda.get(codigoMonedaDestino);
    }



    private void monedasIniciales(LinkedHashMap<Integer, String> eleccionMoneda, boolean destino){
        if (!destino) {
            this.monedasMenuInicial.put("ARS", this.codigoANombreMoneda.get("ARS"));
            this.monedasMenuInicial.put("BOB", this.codigoANombreMoneda.get("BOB"));
            this.monedasMenuInicial.put("BRL", this.codigoANombreMoneda.get("BRL"));
            this.monedasMenuInicial.put("CLP", this.codigoANombreMoneda.get("CLP"));
            this.monedasMenuInicial.put("COP", this.codigoANombreMoneda.get("COP"));
            this.monedasMenuInicial.put("EUR", this.codigoANombreMoneda.get("EUR"));
            this.monedasMenuInicial.put("MXN", this.codigoANombreMoneda.get("MXN"));
            this.monedasMenuInicial.put("USD", this.codigoANombreMoneda.get("USD"));

            this.monedasMenuInicial.forEach((clave, valor) -> System.out.println(formatoOutput(clave, valor, eleccionMoneda)));
        } else {
            this.monedasMenuInicial.forEach((clave, valor) -> System.out.println(formatoOutput(clave, valor, eleccionMoneda)));
        }
    }

    public void codigoMoneda(String archivoCSV) {
        this.codigoANombreMoneda.clear();
        this.eleccionMonedaInicial.clear();

        try (FileReader lectorArchivo = new FileReader(archivoCSV);
            BufferedReader lectorLineas = new BufferedReader(lectorArchivo)) {
            String linea;

            while ((linea = lectorLineas.readLine()) != null) {
                String[] valores = linea.split(","); // Dividir la línea por comas
                this.codigoANombreMoneda.put(valores[0], valores[1]);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    public void monedaBase(){
        this.eleccionMonedaInicial.clear();

        this.contadorFormatoOutput = 0;
        System.out.println("""
                ---------------------------------------------------------------------
                Por favor seleccione la moneda desde la que desa realizar el cambio
                
                   Nombre de la moneda     Código
                """);

        monedasIniciales(this.eleccionMonedaInicial, false);

        this.contadorFormatoOutput++;
        System.out.println("%d. Buscar por el código de la moneda".formatted(contadorFormatoOutput));

        this.contadorFormatoOutput++;
        System.out.println("""
                
                %d. Cerrar programa
                
                ---------------------------------------------------------------------
                """.formatted(this.contadorFormatoOutput));
    }

    public void monedaDestino(int eleccionUsuario) {
        this.eleccionMonedaDestino.clear();
        this.codigosMonedasNoSeleccionadas.clear();

        String codigoMoneda = this.eleccionMonedaInicial.get(eleccionUsuario);
        this.codigoMonedaInical = codigoMoneda;

        this.codigosMonedasNoSeleccionadas.putAll(codigoANombreMoneda);
        this.codigosMonedasNoSeleccionadas.remove(codigoMoneda);

        this.monedasMenuInicial.remove(codigoMoneda);

        this.contadorFormatoOutput = 0;
        System.out.println("""
                ---------------------------------------------------------------------
                Convertir de %s (%s) a:
                                
                   Nombre de la moneda     Código
                """.formatted(this.codigoANombreMoneda.get(codigoMoneda), codigoMoneda));

        this.monedasIniciales(this.eleccionMonedaDestino, true);

        this.contadorFormatoOutput++;
        System.out.println("%d. Buscar por el código de la moneda".formatted(contadorFormatoOutput));

        this.contadorFormatoOutput++;
        System.out.println("""
                
                %d. Salir
                
                ---------------------------------------------------------------------
                """.formatted(this.contadorFormatoOutput));
    }

    public boolean buscarPorCodigo(boolean destino, int eleccionUsuario){
        Scanner scanner = new Scanner(System.in);
        String monedaABuscar;

        if (!destino) {
            try {
                System.out.println("""
                        Si desea consultar los códigos puede acceder a: https://www.exchangerate-api.com/docs/supported-currencies.
                        Ingrese el código de la moneda. Ejemplo: USD.
                        """);
                monedaABuscar = scanner.nextLine().substring(0, 3).toUpperCase();

                if (this.codigoANombreMoneda.containsKey(monedaABuscar)) {
                    this.eleccionMonedaInicial.put(0, monedaABuscar);
                    return true;
                } else {
                    System.out.println("Ingrese un código válido");
                    return false;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Ingrese un código válido");
                return false;
            }
        } else {
            try {
                String codigoMoneda = this.eleccionMonedaInicial.get(eleccionUsuario);
                System.out.println("""
                        Si desea consultar los códigos puede acceder a: https://www.exchangerate-api.com/docs/supported-currencies.
                        Ingrese el código de la moneda. Ejemplo: %s.
                        """.formatted(codigoMoneda));
                monedaABuscar = scanner.nextLine().substring(0, 3).toUpperCase();

                if (this.codigoANombreMoneda.containsKey(monedaABuscar) && this.codigosMonedasNoSeleccionadas.containsKey(monedaABuscar)) {
                    this.eleccionMonedaDestino.put(0, monedaABuscar);
                    return true;
                } else if (!this.codigosMonedasNoSeleccionadas.containsKey(monedaABuscar) && this.codigoANombreMoneda.containsKey(monedaABuscar)) {
                    System.out.println("No puede convertir de %s a %s".formatted(monedaABuscar, monedaABuscar));
                    return false;
                } else {
                    System.out.println("Ingrese un código válido");
                    return false;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Ingrese un código válido");
                return false;
            }
        }
    }

    public void valorACambiar(int eleccionUsuario){
        String codigoMoneda = this.eleccionMonedaDestino.get(eleccionUsuario);
        this.codigoMonedaDestino = codigoMoneda;

        System.out.println("""
                Ingrese el valor que desea convertir de %s (%s) a %s (%s)
                """.formatted(
                        this.codigoANombreMoneda.get(getCodigoMonedaInical()),
                        getCodigoMonedaInical(),
                        this.codigoANombreMoneda.get(getCodigoMonedaDestino()),
                        getCodigoMonedaDestino()));
    }


    private String formatoOutput (String clave, String valor, LinkedHashMap<Integer, String> eleccionMoneda){
        this.contadorFormatoOutput++;
        String claveFormato = String.format("%3s", clave);
        String valorFormato = String.format("%-23s", valor);
        eleccionMoneda.put(this.contadorFormatoOutput, clave);
        return  "%d. %s (%s)".formatted(this.contadorFormatoOutput, valorFormato, claveFormato);
    }
}
