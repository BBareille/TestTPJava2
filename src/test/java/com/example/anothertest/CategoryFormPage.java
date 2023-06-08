package com.example.anothertest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CategoryFormPage
{
    public String url = "http://localhost:8080/category/";
    public SelenideElement inputName = $("input[id='name']");
    public SelenideElement buttonValider = $("button[class*='btn-primary']");

    public SelenideElement lastTr =  $("html > body > div:nth-of-type(3) > table > tbody > tr:last-of-type > td:nth-of-type(1)");
    public SelenideElement removeButton =  $("button[class='btn btn-danger']").lastChild();

}
