package com.codecool;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

class CDProductTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getNumOfTracks() {
        CDProduct cdp = new CDProduct("test", 1000, 12);
        assertNotNull(cdp);

        assertEquals(12, cdp.getNumOfTracks());

    }
}