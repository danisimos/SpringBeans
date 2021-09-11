package ru.itis.models;

import ru.itis.service.EmailValidator;
import ru.itis.service.PasswordBlackList;

public class SignUpService {
    PasswordBlackList passwordBlackList;
    EmailValidator emailValidator;

    public SignUpService(PasswordBlackList passwordBlackList, EmailValidator emailValidator) {
        this.passwordBlackList = passwordBlackList;
        this.emailValidator = emailValidator;
    }

    public void signUp(String email, String password) {
        if(emailValidator.contains(email)) {
            System.out.println("Email is bad");
        }
        else {
            System.out.println("Email is good");
        }

        if(passwordBlackList.contains(password)) {
            System.out.println("Password is bad");
        }
        else {
            System.out.println("Password is good");
        }
    }
}
