package com.aluracursos.desafio_challenge_1_back_end.main;

import com.aluracursos.desafio_challenge_1_back_end.diccionarios.EleccionMonedas;
import com.aluracursos.desafio_challenge_1_back_end.api.ObtenerValorMoneda;

import java.util.Scanner;

public class Main {
    public static int verificarEleccionUsuario(){
        Scanner scanner = new Scanner(System.in);
        int eleccionUsuario = 0;
        try {
            eleccionUsuario = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("El valor ingresado no es un número");
            eleccionUsuario = 0;
        } finally {
            return eleccionUsuario;
        }
    }

    public static double verificarValorACambiar(){
        Scanner scanner = new Scanner(System.in);
        double eleccionUsuario = 0;
        try {
            eleccionUsuario = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("El valor ingresado no es un número");
            eleccionUsuario = 0;
        } finally {
            return eleccionUsuario;
        }
    }

    public static void main(String[] args) {
        EleccionMonedas moneda = new EleccionMonedas();
        ObtenerValorMoneda search = new ObtenerValorMoneda();

        int eleccionMonedaInicial;
        int eleccionMonedaDestino;
        double valorACambiar = 0;

        moneda.codigoMoneda("src/com/aluracursos/desafio_challenge_1_back_end/csv/MonedasPaisesMundial.txt");

        moneda.monedaBase();
        eleccionMonedaInicial = verificarEleccionUsuario();

        while (eleccionMonedaInicial != moneda.getContadorFormatoOutput()){
            if(!(eleccionMonedaInicial <= 0)  && !(moneda.getContadorFormatoOutput() < eleccionMonedaInicial)){
                if (eleccionMonedaInicial == (moneda.getContadorFormatoOutput() -1 )){
                    boolean destino = false;

                    while(!destino){
                        destino = moneda.buscarPorCodigo(false, eleccionMonedaInicial);
                    }
                    eleccionMonedaInicial = 0;
                }
                moneda.monedaDestino(eleccionMonedaInicial);
                eleccionMonedaDestino = verificarEleccionUsuario();

                while (eleccionMonedaDestino != moneda.getContadorFormatoOutput()){
                    if (!(eleccionMonedaDestino <= 0)  && !(moneda.getContadorFormatoOutput() < eleccionMonedaDestino)){
                        if (eleccionMonedaDestino == (moneda.getContadorFormatoOutput() -1 )){
                            boolean destino = false;

                            while(!destino){
                                destino = moneda.buscarPorCodigo(true, eleccionMonedaInicial);
                            }
                            eleccionMonedaDestino = 0;
                        }

                        moneda.valorACambiar(eleccionMonedaDestino);
                        valorACambiar = verificarValorACambiar();

                        search.urlPelicula(moneda.getCodigoMonedaInical(), moneda.getCodigoMonedaDestino(), valorACambiar);
                        search.convertirMoneda(moneda.getNombreMonedaInical(),
                                moneda.getCodigoMonedaInical(),
                                moneda.getNombreMonedaDestino(),
                                moneda.getCodigoMonedaDestino(),
                                valorACambiar);

                        break;

                    }else {
                        System.out.println("Seleccione una opción válida");
                        moneda.monedaDestino(eleccionMonedaInicial);
                        eleccionMonedaDestino = verificarEleccionUsuario();
                    }
                }
                String mensajePostConversion = """
                        Digite la opción que prefiera:
                        1. Realizar otra conversión
                        2. Historial de conversion
                        3. Cerrar programa
                        """;
                System.out.println(mensajePostConversion);
                eleccionMonedaInicial = verificarEleccionUsuario();
                while (true){
                    if (eleccionMonedaInicial == 1){
                        moneda.monedaBase();
                        eleccionMonedaInicial = verificarEleccionUsuario();
                        break;
                    } else if (eleccionMonedaInicial == 2) {
                        search.getHistorialConversion();
                        System.out.println(mensajePostConversion);
                        eleccionMonedaInicial = verificarEleccionUsuario();
                    } else if (eleccionMonedaInicial == 3) {
                        eleccionMonedaInicial = moneda.getContadorFormatoOutput();
                        break;
                    } else {
                        System.out.println("Seleccione una opción válida");
                        System.out.println(mensajePostConversion);
                        eleccionMonedaInicial = verificarEleccionUsuario();
                    }
                }
            } else {
                System.out.println("Seleccione una opción válida");
                moneda.monedaBase();
                eleccionMonedaInicial = verificarEleccionUsuario();
            }
        }

        search.guardarHistorialJson();

        System.out.println("""
                Gracias por utilizar el Conversor de Monedas
                El programa ha finalizado
                """);
    }

}
