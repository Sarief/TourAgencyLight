/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.commands;

import application.properties.InnerMapping;
import dao.interfaces.DAOFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */
public class SettingsShowHotels implements Command{
    private static final String PROPERTY_NAME = "SettingsShowHotels";
    private static final String ATTRIBUTE_NAME = "Hotels";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String hotelSettings = InnerMapping.getInstance().getProperty(PROPERTY_NAME);
            request.setAttribute(ATTRIBUTE_NAME, DAOFactory.getFactory().getDAOHotel().findAll());
            request.getRequestDispatcher(hotelSettings).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ShowTours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
