package businessLogic;

import data.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    public void setCredentialsDictionary(String email, String password){
        //TODO
    }
    public void verifyCredentials(String email, String password){
        //TODO
    }
    public void readData(String email, String password){
        //TODO
    }

}
