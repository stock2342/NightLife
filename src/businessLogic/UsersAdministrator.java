package businessLogic;

import data.Costumer;
import data.Establishment;
import data.User;

import java.io.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class UsersAdministrator {
    private String usersDataFileName;
    private String usersCredentialsFileName;

    public UsersAdministrator(String usersDataFileName, String usersCredentialsFileName) {
        this.usersDataFileName = usersDataFileName;
        this.usersCredentialsFileName = usersCredentialsFileName;
    }

    public void saveUsersData(User users) throws IOException {
        FileWriter myWriterData = null;
        FileWriter myWriterCredentials = null;
        try {
            myWriterData = new FileWriter(this.usersDataFileName, true);
            myWriterCredentials = new FileWriter(this.usersCredentialsFileName, true);
            BufferedWriter bfWriterData = new BufferedWriter(myWriterData);
            BufferedWriter bfWriterCredentials = new BufferedWriter(myWriterCredentials);
            bfWriterData.write(users.toString() + "\n");
            bfWriterCredentials.write(users.getEmail() + ", " + users.getPassword() + "\n");
            bfWriterData.close();
            bfWriterCredentials.close();
            System.out.println("Datos guardados satisfactoriamente");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(myWriterData != null){
                try{
                    myWriterData.close();
                    myWriterCredentials.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    /*public Map setCredentialsDictionary(String email, String password, String credentialsFileName){
        //TODO
    }
    public boolean verifyCredentials(String email, String password){
        //TODO
    }*/

    public User readData(String email, String password){
        File myFile = new File(this.usersDataFileName);
        Scanner sc;
        User u = null;
        try{
            sc = new Scanner(myFile);
            while(sc.hasNext()){
                String line = sc.nextLine();
                Scanner s = new Scanner(line).useDelimiter(",");
                String emailRecorded = s.next().trim();
                String passwordRecorded = s.next().trim();
                if(emailRecorded.equals(email) && passwordRecorded.equals(password)){
                    String name = s.next().trim();
                    String numberPhone = s.next().trim();
                    String typeOfUser = s.next().trim();
                    switch(typeOfUser){
                        case("costumer"):
                            String userName = s.next().trim();
                            LocalDate birthDate = LocalDate.parse(s.next().trim());
                            String idNumber = s.next().trim();
                            u = new Costumer(name, numberPhone, emailRecorded, passwordRecorded, userName, birthDate, idNumber);
                            break;
                        case("establishment"):
                            String cityName = s.next().trim();
                            String typeOfEstablishment = s.next().trim();
                            u = new Establishment(name, numberPhone, emailRecorded, passwordRecorded, cityName, typeOfEstablishment);
                            break;
                    }
                }
            }
            sc.close();
        }catch (FileNotFoundException e) {
            System.err.println("No se encontro el archivo " + this.usersDataFileName);
            e.printStackTrace();
        }
        return u;
    }

}
