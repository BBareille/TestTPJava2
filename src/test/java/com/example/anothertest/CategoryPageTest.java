package com.example.anothertest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryPageTest
{
    CategoryFormPage categoryFormPage = new CategoryFormPage();

    @BeforeAll
    public static void setUpAll(){
        Configuration.headless = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

    }

    @Test
    @Order(1)
    public void sendForm(){
        open(this.categoryFormPage.url + "add");

        String newCategoryName = "coucou";
        categoryFormPage.inputName.append(newCategoryName);
        categoryFormPage.buttonValider.click();

        assertTrue(categoryFormPage.lastTr.exists());
        assertNotEquals(categoryFormPage.lastTr.getOwnText(), UUID.randomUUID().toString());
        assertEquals(categoryFormPage.lastTr.getOwnText(), newCategoryName);

    }

    @Test
    @Order(2)
    public void deleteCategory()
    {
        categoryFormPage.removeButton.click();
        assertFalse(categoryFormPage.lastTr.exists());
    }




}

