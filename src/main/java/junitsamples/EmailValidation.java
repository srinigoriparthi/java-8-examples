package junitsamples;

import java.io.*;

/**
 * EmailValidation
 */
public class EmailValidation {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String email = buf.readLine();
        if(new ValidationBO().validateEmail(email))
            System.out.println("Valid Email");
        else
            System.out.println("Invalid Email");
    }

}
