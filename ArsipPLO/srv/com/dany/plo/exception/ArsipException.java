/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dany.plo.exception;

/**
 *
 * @author Dany Candra
 */
public class ArsipException extends Exception {

    /**
     * Creates a new instance of <code>ViewException</code> without detail
     * message.
     */
    public ArsipException() {
    }

    /**
     * Constructs an instance of <code>ViewException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ArsipException(String msg) {
        super(msg);
    }
}
