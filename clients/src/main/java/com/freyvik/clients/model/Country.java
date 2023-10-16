package com.freyvik.clients.model;

public class Country {

    private String name;
    private String capital;
    private int population;
    private String flag;

    public Country(String name, String capital, int population, String flag) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.flag = flag;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
}
