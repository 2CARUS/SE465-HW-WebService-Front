/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se465.webservice.ui;

/**
 *
 * @author ckopp
 */
public class UIController {

    private UIFrame mainFrame;
    private UIFrame currentFrame;

    private UIController() {
    }

    public static UIController getInstance() {
        return UIControllerHolder.INSTANCE;
    }

    /**
     * Takes in two AbstractFrames (which are jFrames) and disposes the first
     * one and renders the second one
     *
     * @param previousFrame
     * @param nextFrame
     */
    public void displayNextFrame(UIFrame previousFrame, UIFrame nextFrame) {
        this.currentFrame = nextFrame;
        previousFrame.conceal();
        nextFrame.render();
    }

    /**
     * Sets the mainUI attribute of the UIController class
     *
     * @param mainMenuUI
     */
    public void setMain(UIFrame mainMenuUI) {
        this.mainFrame = mainMenuUI;
    }

    /**
     * Starts the UI at the mainUI frame
     */
    public void startUI() {
        this.currentFrame = mainFrame;
        this.mainFrame.render();
    }

    public void closeCurrentFrame() {
        currentFrame.conceal();
    }

    public UIFrame getCurrentFrame() {
        return currentFrame;
    }

    private static class UIControllerHolder {

        private static final UIController INSTANCE = new UIController();
    }
}
