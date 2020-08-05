package com.kyriba.bar;

import org.junit.Assert;
import org.junit.Test;

public class FiveTestNew {

    @Test
    public void emailTest() {
        Five five = new Five();
        five.email = "email";
        Assert.assertEquals("email", five.email);
    }
}