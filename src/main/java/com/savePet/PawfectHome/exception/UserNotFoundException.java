package com.savePet.PawfectHome.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int id) {
        super("User with id " + id + " not exists");
    }
}
