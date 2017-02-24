package com.novatec.servicesimulator.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestService {
    
    private static final String BASE_URL = "http://www.webservicex.com/globalweather.asmx/GetCitiesByCountry?CountryName=";
    
    public RestService() {
    }
    
    public static String getRest(String country) {
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target(BASE_URL+country);
        Invocation.Builder builder = target.request();
        Response response = builder.get();
        return response.readEntity(String.class);
}
}
