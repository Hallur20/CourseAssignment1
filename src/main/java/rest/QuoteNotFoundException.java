/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

/**
 *
 * @author hvn15
 */
class QuoteNotFoundException extends Exception {

    public QuoteNotFoundException(String message) {
        super(message);
    }

}
