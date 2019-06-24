/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se465.webservice.logic;

import com.se465.webservice.ui.MainPageUI;
import com.se465.webservice.ui.UIController;

/**
 *
 * @author ckopp
 */
public class InventoryFrontEnd {

    public static void main(String[] args) {

        UIController.getInstance().setMain(new MainPageUI());
        UIController.getInstance().startUI();
    }
}
