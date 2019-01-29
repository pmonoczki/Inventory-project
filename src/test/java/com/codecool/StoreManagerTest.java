package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.PresentationDirection;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class StoreManagerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void addStorage() {
        PersistentStore ps = new PersistentStore();
        StoreManager sm = new StoreManager();


        try {
            sm.listProducts();
            assertTrue(false);
        } catch (NoStorageException e) {
            assertTrue(true);
        }

        sm.addStorage(ps);
        try {
            sm.listProducts();
            assertTrue(true);
        } catch (NoStorageException e) {
            assertTrue(false);
        }



    }

    @Test
    void getTotalPrice() {
    }

    @Test
    void addCDProduct() {

        PersistentStore ps = new PersistentStore();
        StoreManager sm = new StoreManager();


        try {

            sm.addStorage(ps);

            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();

            sm.addCDProduct(randomUUIDString,1,1);

            assertTrue(sm.listProducts().contains(randomUUIDString));


        } catch (NoStorageException e) {
            assertTrue(false);
        }
    }

    @Test
    void addBookProduct() {

        PersistentStore ps = new PersistentStore();
        StoreManager sm = new StoreManager();


        try {

            sm.addStorage(ps);

            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();

            sm.addBookProduct(randomUUIDString,1,1);

            assertTrue(sm.listProducts().contains(randomUUIDString));


        } catch (NoStorageException e) {
            assertTrue(false);
        }
    }


}