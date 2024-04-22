package com.moneyconversorchallenge.main;

import com.moneyconversorchallenge.apiusage.ExchangeApi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String showMenu = """
                **********************************
                Bienvenido al conversor de Moneda :)
                Seleccione una de las siguientes opciones:
                                
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real brasileño
                4) Real brasileño =>> Dolar
                5) Dolar =>> Peso colombiano
                6) Peso colombiano ==> Dolar
                7) Salir
                                
                Elija una opcion valida:
                *********************************
                """;

        int option;

        do {
            System.out.println(showMenu);
            option = keyboard.nextInt();

            switch (option) {
                case 1:
                    makeConversion("USD", "ARS");
                    break;
                case 2:
                    makeConversion("ARS", "USD");
                    break;
                case 3:
                    makeConversion("USD", "BRL");
                    break;
                case 4:
                    makeConversion("BRL", "USD");
                    break;
                case 5:
                    makeConversion("USD", "COP");
                    break;
                case 6:
                    makeConversion("COP", "USD");
                    break;
                case 7:
                    System.out.println("Saliendo del programa. Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (option != 7);
    }

    private static void makeConversion(String fromCurrency, String toCurrency) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad a convertir:");
        double amountToConvert = scanner.nextDouble();
        double result = ExchangeApi.conversor(fromCurrency, toCurrency, amountToConvert);
        System.out.println("El resultado de la conversion de " + amountToConvert + " " + fromCurrency
                + " es de: " + result + " " + toCurrency);
    }
}
