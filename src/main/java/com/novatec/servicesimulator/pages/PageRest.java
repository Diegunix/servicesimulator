package com.novatec.servicesimulator.pages;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class PageRest extends CustomComponent implements View {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "REST";
    static String data = "Sin Datos";
    final VerticalLayout layout = new VerticalLayout();

    public PageRest() {
    }

    public static void setData(String value) {
        data = value;
    }
    
     @Override
    public void enter(ViewChangeEvent event) {
        Button buttonBack = new Button("Back"); 
        
        buttonBack.addClickListener(e -> {
            getUI().getNavigator().navigateTo(PageMain.NAME);
        });
        Label lblData = new Label(data);
        layout.addComponents(buttonBack, lblData);
        layout.setMargin(true);
        layout.setSpacing(true);
        setCompositionRoot(layout);
    }

}
