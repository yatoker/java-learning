package com.amadeus.epwr.controller;

import java.io.FileNotFoundException;

public class ExceptionTraining {



    void run() {
        try {
            checkedException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }

    void checkedException() throws FileNotFoundException {

        throw new FileNotFoundException();
    }

    void uncheckedException() {

        throw new RuntimeException();
    }
}
