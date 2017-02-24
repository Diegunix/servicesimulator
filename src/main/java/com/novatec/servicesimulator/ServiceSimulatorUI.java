package com.novatec.servicesimulator;

import javax.servlet.annotation.WebServlet;

import com.novatec.servicesimulator.pages.PageMain;
import com.novatec.servicesimulator.pages.PageRest;
import com.novatec.servicesimulator.pages.PageSoap;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;


@Theme("servicesimulatortheme")
public class ServiceSimulatorUI extends UI {

    private static final long serialVersionUID = 1L;
    Navigator navigator = new Navigator(this, this);
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigator.addView(PageMain.NAME, PageMain.class);
        navigator.addView(PageRest.NAME, PageRest.class);
        navigator.addView(PageSoap.NAME, PageSoap.class);
        navigator.navigateTo(PageMain.NAME);
    }
    
    @WebServlet(urlPatterns = "/*", name = "ServiceSimulatorUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ServiceSimulatorUI.class, productionMode = false)
    public static class ServiceSimulatorUIServlet extends VaadinServlet {

        private static final long serialVersionUID = 1L;
    }
    
    
    
}
