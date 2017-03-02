package com.novatec.servicesimulator.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestService {
    
    private static final String BASE_URL_WEATHER = "http://www.webservicex.com/globalweather.asmx/GetCitiesByCountry?CountryName=";
    private static final String BASE_URL_CURRENCY = "http://www.webservicex.com/country.asmx/GetCurrencyByCountry?CountryName=";
    
    
    public RestService() {
    }
    
    public static String getWeatherRest(String country) {
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target(BASE_URL_WEATHER+country);
        Invocation.Builder builder = target.request();
        Response response = builder.get();
        return response.readEntity(String.class);
}
    
    public static String getCurrencyRest(String country) {
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target(BASE_URL_CURRENCY+country);
        Invocation.Builder builder = target.request();
        Response response = builder.get();
        return response.readEntity(String.class);
}
}
