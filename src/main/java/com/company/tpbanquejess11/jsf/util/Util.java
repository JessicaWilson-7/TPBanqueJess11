/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.tpbanquejess11.jsf.util;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;

/**
 *
 * @author USER
 */
public class Util {

    public static void message(String messageDetail, String messageResume,
            FacesMessage.Severity severite, String clientId) {
        FacesMessage msg
                = new FacesMessage(severite, messageResume, messageDetail);
        FacesContext.getCurrentInstance().addMessage(clientId, msg);
    }

    public static void message(String messageDetail, String messageResume,
            FacesMessage.Severity severite) {
        FacesMessage msg
                = new FacesMessage(severite, messageResume, messageDetail);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void messageErreur(String messageDetail, String messageResume) {
        message(messageDetail, messageResume, FacesMessage.SEVERITY_ERROR);
    }

    public static void messageErreur(String message) {
        message(message, message, FacesMessage.SEVERITY_ERROR);
    }

    public static void messageErreur(String messageDetail, String messageResume, String clientId) {
        message(messageDetail, messageResume, FacesMessage.SEVERITY_ERROR, clientId);
    }

    public static void messageInfo(String messageDetail, String messageResume) {
        message(messageDetail, messageResume, FacesMessage.SEVERITY_INFO);
    }

    public static void messageInfo(String message) {
        message(message, message, FacesMessage.SEVERITY_INFO);
    }

    public static void addFlashMessage(FacesMessage message) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Flash flash = facesContext.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        facesContext.addMessage(null, message);
    }

    public static void addFlashErrorMessage(String message) {
        FacesMessage msg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        addFlashMessage(msg);
    }

    public static void addFlashInfoMessage(String message) {
        FacesMessage msg
                = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
        addFlashMessage(msg);
    }
}
