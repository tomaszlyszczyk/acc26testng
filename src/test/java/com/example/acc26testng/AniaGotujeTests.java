package com.example.acc26testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AniaGotujeTests extends BaseTest {
    @Test
    public void Ania1() throws InterruptedException {
        System.out.println("Thread Id: " +  Thread.currentThread().getId());
        getDriver().navigate().to("https://aniagotuje.pl/");
        Thread.sleep(10000);
    }

    @Test
    public void Ania2() throws InterruptedException {
        System.out.println("Thread Id: " +  Thread.currentThread().getId());
        getDriver().navigate().to("https://aniagotuje.pl/");
        Thread.sleep(10000);
    }

    @Test
    public void Ania3() throws InterruptedException {
        System.out.println("Thread Id: " +  Thread.currentThread().getId());
        getDriver().navigate().to("https://aniagotuje.pl/");
        Thread.sleep(10000);
    }
}