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

            }
        } while (option != 7)
    }
}
