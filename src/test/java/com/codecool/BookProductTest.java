package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookProductTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNumOfPages() {
        BookProduct bp = new BookProduct("test", 1000, 50);
        assertNotNull(bp);

        assertEquals(50, bp.getNumOfPages());
    }
}