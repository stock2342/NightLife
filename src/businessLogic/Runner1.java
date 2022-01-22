package businessLogic;

import data.Costumer;
import data.Establishment;
import data.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Runner1 {
    public static String readInfo(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }

    public static void main(String[] args) throws IOException {
        int option = 0;
        UsersAdministrator admin = new UsersAdministrator("data.txt", "credentials.txt");
        while(true){
            System.out.println("Por favor, seleccione entre las siguientes opciones: Ustedes es...");
            System.out.print("1. Cliente. \n 2. Establecimiento.\n 3. Salir.\n");
            option = Integer.parseInt(readInfo());
            switch (option) {
                case 1 -> {
                    System.out.println("Por favor ingrese los siguientes datos:");
                    System.out.println("Nombre y Apellidos: ");
                    String name = readInfo();
                    System.out.println("Fecha de nacimiento: ");
                    LocalDate birthdate = LocalDate.parse(readInfo());
                    System.out.println("Número de identificación: ");
                    String idNumber = readInfo();
                    System.out.println("Número de celular: ");
                    String cellNumber = readInfo();
                    System.out.println("Correo electrónico: ");
                    String email = readInfo();
                    System.out.println("Contraseña: ");
                    String password = readInfo();
                    System.out.println("Nombre de usuario: ");
                    String userName = readInfo();
                    System.out.println("A continuación se almacenaran tus datos");
                    User userCostumer = new Costumer(name, cellNumber, email, password, userName, birthdate, idNumber);
                    admin.saveUsersData(userCostumer);
                }
                case 2 -> {
                    System.out.println("Por favor ingrese los siguientes datos:");
                    System.out.println("Nombre del establecimiento: ");
                    String nameEstablishment = readInfo();
                    System.out.println("Ciudad donde se encuentra actualmente: ");
                    String cityName = readInfo();
                    System.out.println("Número de celular: ");
                    String cellNumberEstablishment = readInfo();
                    System.out.println("Tipo de establecimiento: ");
                    String establishmentType = readInfo();
                    System.out.println("Correo electrónico: ");
                    String emailEstablishment = readInfo();
                    System.out.println("Contraseña: ");
                    String passwordEstablishment = readInfo();
                    System.out.println("A continuación se almacenaran tus datos");
                    User userEstablishment = new Establishment(nameEstablishment, cellNumberEstablishment, emailEstablishment, passwordEstablishment, cityName, establishmentType);
                    admin.saveUsersData(userEstablishment);
                }
                case 3 -> System.exit(0);
                default -> System.out.println("Has seleccionado una opción incorrecta");
            }
        }

    }
}
