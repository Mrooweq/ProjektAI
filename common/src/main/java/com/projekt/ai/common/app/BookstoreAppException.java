package com.projekt.ai.common.app;

/**
 * Created by Lenovo on 2017-12-04.
 */
public class BookstoreAppException extends RuntimeException {
    private String msg;

    public BookstoreAppException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
