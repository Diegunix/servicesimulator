package com.novatec.servicesimulator.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class CallUrl {

    public CallUrl() {
    }

    public static String callPostUrl(String url) {
        Client client = ClientBuilder.newBuilder().newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request();
        Response response = builder.post(null);
        return response.readEntity(String.class);
}

}
