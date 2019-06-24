/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se465.webservice.logic;

import com.se465.webservice.ui.MainPageUI;
import com.se465.webservice.ui.ResultsUI;
import com.se465.webservice.ui.UIController;
import com.se465.webservice.ui.UIFrame;

/**
 *
 * @author ckopp
 */
public class Facade {

    private UIFrame currentFrame;

    private Facade() {
    }

    public static Facade getInstance() {
        return FacadeHolder.INSTANCE;
    }

    public int receiveCity(String city) {
        String store_endpoint = null;
        if (this.validateCity(city)) {
            if (city.equals(LOCATION_CODES.MPLS)) {
                store_endpoint = REST_API.MPLS;
            } else if (city.equals(LOCATION_CODES.STPL)) {
                store_endpoint = REST_API.STPL;
            }

            this.displayResponse(NetworkHandler.getInstance().queryCityInventory(store_endpoint));
            return LOGIC_CODES.SUCCESS;
        }

        return LOGIC_CODES.ERROR;

        //To change body of generated methods, choose Tools | Templates.
    }

    private boolean validateCity(String city) {
        return (city.equals(LOCATION_CODES.MPLS) || city.equals(LOCATION_CODES.STPL));
    }

    private void displayResponse(String result) {

        // Format response nicely
        result = result
                .replace(',', '\n')
                .replace('[', '\n')
                .replace(']', '\n')
                .replace('}', '\n')
                .replace('{', '\n');

        System.out.format("%n%nResponse body from the previous GET HTTP request: %s", result);

        new ResultsUI(result).render();
    }

    public void currentFrame(UIFrame frame) {
        this.currentFrame = frame;
    }

    private static class FacadeHolder {

        private static final Facade INSTANCE = new Facade();
    }
}
