package CarManagement.services;

import CarManagement.utils.FileHandler;
import CarManagement.exceptions.InvalidCredentialsException;
import java.io.*;
import java.util.*;

public class AuthService {
    // validate against users.txt (username,password,role)
    public static String validate(String username, String password) throws InvalidCredentialsException {
        try {
            List<String[]> users = FileHandler.readUsers();
            for (String[] u : users) {
                if (u[0].equalsIgnoreCase(username) && u[1].equals(password)) {
                    return u[2]; // role
                }
            }
        } catch (IOException e) {
        }
        throw new InvalidCredentialsException("Invalid username or password.");
    }
}
