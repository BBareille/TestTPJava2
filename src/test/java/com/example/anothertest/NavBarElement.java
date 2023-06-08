package com.example.anothertest;

import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class NavBarElement {

    public List<SelenideElement> navBarElements = Arrays.asList(
            $("[href='/training/']"),
            $("[href='/students/']"),
            $("[href='/formers/']")
    );

}
