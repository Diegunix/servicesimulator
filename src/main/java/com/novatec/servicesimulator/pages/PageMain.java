package com.novatec.servicesimulator.pages;

import com.novatec.servicesimulator.services.RestService;
import com.novatec.servicesimulator.services.SoapService;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
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
        
        final HorizontalLayout layouth = new HorizontalLayout();
        
        final VerticalLayout layoutWeather = new VerticalLayout();
        final VerticalLayout layoutCurrency = new VerticalLayout();
        
        Button buttonWeatherSoap = new Button("Soap Weather Service");
        Button buttonWeatherRest = new Button("Rest Weather Service");
        
        Button buttonCurrencySoap = new Button("Soap Currency Service");
        Button buttonCurrencyRest = new Button("Rest Currency Service");

        TextField textCountry = new TextField("Country", "Germany");

        buttonWeatherSoap.addClickListener(e -> {
            String data = SoapService.getWeatherSoap(textCountry.getValue());
            Notification.show("Soap", "Call a Soap Service", Notification.Type.HUMANIZED_MESSAGE);
            PageSoap.setData(data);
            getUI().getNavigator().navigateTo(PageSoap.NAME);
        });

        buttonWeatherRest.addClickListener(e -> {
            String data = RestService.getWeatherRest(textCountry.getValue());
            Notification.show("Rest", "Call a Rest Service", Notification.Type.HUMANIZED_MESSAGE);
            PageRest.setData(data);
            getUI().getNavigator().navigateTo(PageRest.NAME);
        });
        
        buttonCurrencySoap.addClickListener(e -> {
            String data = SoapService.getCurrencySoap(textCountry.getValue());
            Notification.show("Soap", "Call a Soap Service", Notification.Type.HUMANIZED_MESSAGE);
            PageSoap.setData(data);
            getUI().getNavigator().navigateTo(PageSoap.NAME);
        });
        
        buttonCurrencyRest.addClickListener(e -> {
            String data = RestService.getCurrencyRest(textCountry.getValue());
            Notification.show("Rest", "Call a Rest Service", Notification.Type.HUMANIZED_MESSAGE);
            PageRest.setData(data);
            getUI().getNavigator().navigateTo(PageRest.NAME);
        });
        
    

        layoutWeather.addComponent(buttonWeatherSoap);
        layoutWeather.addComponent(buttonWeatherRest);
        
        layoutCurrency.addComponent(buttonCurrencySoap);
        layoutCurrency.addComponent(buttonCurrencyRest);
        
        layouth.addComponents(layoutWeather, layoutCurrency);
        
        layout.addComponents(textCountry,layouth);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        layoutWeather.setMargin(true);
        layoutWeather.setSpacing(true);
        
        layoutCurrency.setMargin(true);
        layoutCurrency.setSpacing(true);
        
        layouth.setMargin(true);
        layouth.setSpacing(true);

        setCompositionRoot(layout);
    }

}
