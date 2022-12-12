package org.omni.api.tests;

import org.omni.api.helpers.PriceServiceHelper;
import org.omni.api.model.Price;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestGETPrice {

    private PriceServiceHelper priceServiceHelper;

    @BeforeClass
    public void init(){
        priceServiceHelper = new PriceServiceHelper();

    }

    @Test
    public void testGetPrice(){
        List<Price> priceList = priceServiceHelper.getPrice();
        assertNotNull(priceList,"Price should not be empty");
        assertFalse(priceList.isEmpty(),"Price List is not True");

    }

}
