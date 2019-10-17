package com.example.demo;

public interface Service  {
    public Register updateUserByName(String name,Register user) throws UserNotFoundException;
}
