package com.example.lab8;

//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Richmond", "BC");

        list.addCity(city);
        assertTrue(list.hasCity(city));

        City unlistedCity = new City("Surrey", "BC");
        assertFalse(list.hasCity(unlistedCity));
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Banff", "AB");

        list.addCity(city);
        assertTrue(list.hasCity(city));

        list.deleteCity(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        assertEquals(0, list.countCities());

        City city1  = new City("Toronto", "ON");
        list.addCity(city1);
        City city2 = new City("Ottawa", "ON");
        list.addCity(city2);
        assertEquals(2, list.countCities());

        list.deleteCity(city1);
        assertEquals(1, list.countCities());
    }
}
