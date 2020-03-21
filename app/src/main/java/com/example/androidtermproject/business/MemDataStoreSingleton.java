package com.example.androidtermproject.business;

public class MemDataStoreSingleton {

    private MemDataStoreSingleton() {
    }

    private static MemDataStoreSingleton instance;

    public static MemDataStoreSingleton getInstance() {
        if (instance != null) {
            instance = new MemDataStoreSingleton();
        }
        return instance;
    }
}
