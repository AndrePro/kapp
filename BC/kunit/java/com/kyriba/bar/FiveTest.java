package com.kyriba.bar;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class FiveTest {
@Test
    public void emailTest() {
        Five five = new Five();
        five.email = "email";
        Assert.assertEquals("email", five.email);
    }
}