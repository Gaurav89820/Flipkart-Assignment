package com.flipkart.utilities;

import org.testng.annotations.DataProvider;

public class Dataprovider {
@DataProvider(name="login credentials")
public static Object[][] getDataFromDataprovider(){
    return new Object[][] {
        { "7999142525", "gaurav89820" }
    }; }
}
