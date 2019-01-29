package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersistentStoreTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllProducts() {

        PersistentStore ps = new PersistentStore();
        assertNotNull(ps.getAllProducts());
        int before = ps.getAllProducts().size();
        ps.storeBookProduct("t",1,1);
        int after = ps.getAllProducts().size();
        assertEquals(before + 1, after);
    }

    @Test
    void storeCDProduct() {
        PersistentStore ps = new PersistentStore();
        assertNotNull(ps.getAllProducts());
        int before = ps.getAllProducts().size();

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        ps.storeCDProduct(randomUUIDString,1,1);
        int after = ps.getAllProducts().size();
        assertEquals(before + 1, after);

        boolean res = false;
        for (Product p : ps.getAllProducts()){
            if (p.getName().equals(randomUUIDString)){
                res = true;
                break;
            }
        }

        assertTrue(res);



    }

    @Test
    void storeBookProduct() {
        PersistentStore ps = new PersistentStore();
        assertNotNull(ps.getAllProducts());
        int before = ps.getAllProducts().size();

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        ps.storeBookProduct(randomUUIDString,1,1);
        int after = ps.getAllProducts().size();
        assertEquals(before + 1, after);

        boolean res = false;
        for (Product p : ps.getAllProducts()){
            if (p.getName().equals(randomUUIDString)){
                res = true;
                break;
            }
        }

        assertTrue(res);
    }

    @Test
    void loadProducts() {

        PersistentStore ps = new PersistentStore();
        assertNotNull(ps.getAllProducts());
        int before = ps.getAllProducts().size();
        ps.storeBookProduct("t",1,1);
        int after = ps.getAllProducts().size();
        assertEquals(before + 1, after);
    }
}