package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomListTest {

    /**
     * create a mocklist for my citylist
     * @return Mock CustomList
     */
    public CustomList MockCityList() {
        return new CustomList(null, new ArrayList<>());
    }

    /**
     * Create a Mock city
     * @return Mock City
     */
    public City MockCity() {
        return new City("Edmonton", "AB");
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void testAddCity() {
        CustomList list = MockCityList();
        int listSize = list.getCount();
        City city = MockCity();
        list.addCity(city);
        assertEquals(list.getCount(), listSize + 1);
    }

    /**
     * Test hasCity method.
     * Call true and false and empty (false).
     */
    @Test
    public void testHasCity() {
        CustomList list = MockCityList();
        City city = MockCity();
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(new City("Saskatoon", "SK")));
    }

    /**
     * Test deleteCity method.
     * Add city to the list and delete it.
     */
    @Test
    public void testDeleteCity() {
        CustomList list = MockCityList();
        City city = MockCity();
        list.addCity(city);
        int listSize = list.getCount();
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
        assertEquals(list.getCount(), listSize - 1);
    }

    /**
     * Test exception thrown by deleteCity when
     * the city is not in the list.
     */
    @Test
    public void testDeleteException() {
        CustomList list = MockCityList();
        list.addCity(MockCity());
        City city = new City("NotInList", "NA");
        int listSize = list.getCount();
        assertThrows(IllegalArgumentException.class, () -> list.deleteCity(city));
        assertEquals(list.getCount(), listSize);
    }

}
