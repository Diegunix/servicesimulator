package com.novatec.servicesimulator.pages;

import com.novatec.servicesimulator.services.CallUrl;
import com.novatec.servicesimulator.services.RestService;
import com.novatec.servicesimulator.services.SoapService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PageMain extends CustomComponent implements View {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "MAIN";

    public PageMain() {
    }

    @Override
    public void enter(ViewChangeEvent event) {
        final VerticalLayout layout = new VerticalLayout();

        Button buttonSoap = new Button("Soap Service");
        Button buttonRest = new Button("Rest Service");
        
        Button buttonUpdate = new Button("Update WireMock");

        TextField textCountry = new TextField("Country", "Germany");

        buttonSoap.addClickListener(e -> {
            String data = SoapService.getSoap(textCountry.getValue());
            Notification.show("Soap", "Call a Soap Service", Notification.Type.HUMANIZED_MESSAGE);
            PageSoap.setData(data);
            getUI().getNavigator().navigateTo(PageSoap.NAME);
        });

        buttonRest.addClickListener(e -> {
            String data = RestService.getRest(textCountry.getValue());
            Notification.show("Rest", "Call a Rest Service", Notification.Type.HUMANIZED_MESSAGE);
            PageRest.setData(data);
            getUI().getNavigator().navigateTo(PageRest.NAME);
        });
        
        buttonUpdate.addClickListener(e -> {
            CallUrl.callPostUrl("http://localhost:9898/__admin/mappings/reset");
        });
        
    

        layout.addComponents(textCountry, buttonSoap, buttonRest, buttonUpdate);
        layout.setMargin(true);
        layout.setSpacing(true);

        setCompositionRoot(layout);
    }

}
