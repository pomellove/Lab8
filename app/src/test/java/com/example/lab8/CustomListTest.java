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
}
