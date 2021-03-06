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
public class SettingsShowRoomPage implements Command{
    
    private static final String PROPERTY_NAME = "SettingsShowRoomPage";
    private static final String ATTRIBUTE_NAME = "RoomInfo";
    private static final String REQUEST_PARAMETER = "id";
    

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter(REQUEST_PARAMETER));
            if(id<0){
               id = 0;
            }
            String hotelRoomSettings = InnerMapping.getInstance().getProperty(PROPERTY_NAME);
            request.setAttribute(ATTRIBUTE_NAME, DAOFactory.getFactory().getDAOHotelRoom().find(id));
            request.getRequestDispatcher(hotelRoomSettings).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ShowTours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
