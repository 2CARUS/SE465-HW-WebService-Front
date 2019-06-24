/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se465.webservice.logic;

import kong.unirest.Unirest;

/**
 *
 * @author ckopp
 */
public class NetworkHandler {

    private NetworkHandler() {
    }

    public static NetworkHandler getInstance() {
        return NetworkHandlerHolder.INSTANCE;
    }

    String queryCityInventory(String endpoint) {
        String url = REST_API.URL + endpoint;

        System.out.format("%n%nSending GET HTTP request to the following URL: %s", url);

        String result = Unirest
                .get(url)
                .asString()
                .getBody();

        return result;
    }

    private static class NetworkHandlerHolder {

        private static final NetworkHandler INSTANCE = new NetworkHandler();
    }
}
