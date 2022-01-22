package businessLogic;

import data.User;

import java.io.IOException;
import java.util.Scanner;

public class Runner2 {
    public static String readInfo(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }

    public static void main(String[] args) throws IOException {
        UsersAdministrator admin =new UsersAdministrator("data.txt", "credentials.txt");
        System.out.println("Ingrese sus datos: ");
        System.out.println("Correo electrónico: ");
        String email = readInfo();
        System.out.println("Contraseña: ");
        String password = readInfo();
        User u = admin.readData(email, password);
        System.out.println(u.toString());
    }
}
