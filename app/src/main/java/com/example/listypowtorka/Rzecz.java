package com.example.listypowtorka;

public class Rzecz {
    private String nazwa;
    private Boolean czyWykonane;
    private Byte priorytet;

    public Rzecz(String nazwa, Byte priorytet) {
        this.nazwa = nazwa;
        this.priorytet = priorytet;
        czyWykonane = false;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Boolean getCzyWykonane() {
        return czyWykonane;
    }

    public Byte getPriorytet() {
        return priorytet;
    }

    public void setCzyWykonane(Boolean czyWykonane) {
        this.czyWykonane = czyWykonane;
    }

    @Override
    public String toString() {
        return
                "Zadanie: " + nazwa + '\n' +
                "priorytet: " + priorytet;
    }
}
