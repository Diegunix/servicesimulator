package com.novatec.servicesimulator.services;

import NET.webserviceX.www.GlobalWeatherLocator;
import NET.webserviceX.www.GlobalWeatherSoap;

public class SoapService {

    public SoapService() {
    }

    public static String getSoap(String country) {
        GlobalWeatherLocator serviceLocator = null;
        GlobalWeatherSoap port = null;
        String countryData = null;
        try {
            serviceLocator = new GlobalWeatherLocator();
            port = serviceLocator.getGlobalWeatherSoap();
            countryData = port.getCitiesByCountry(country);
            System.out.println(countryData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryData;
    }

}
