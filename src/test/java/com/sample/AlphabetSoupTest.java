package com.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by RAJESH on 3/19/2019.
 */
public class AlphabetSoupTest {

    private AlphabetSoupIntr alphabetSoup = null;

    @Before
    public void setUp() throws Exception {
        alphabetSoup = new AlphabetSoupImpl();
    }

    @After
    public void tearDown() throws Exception {
        alphabetSoup = null;

    }

    @Test
    public void testAlphabetSoupMessageNull() {

        assertFalse(alphabetSoup.isMessageFound(null, "TEst"));
    }

    @Test
    public void testAlphabetSoupBowlNull() {

        assertFalse(alphabetSoup.isMessageFound("TEST", null));
    }

    @Test
    public void testAlphabetSoupMessageEmpty() {

        assertFalse(alphabetSoup.isMessageFound(" ", "TEstdd"));
    }

    @Test
    public void testAlphabetSoupBowlEmpty() {

        assertFalse(alphabetSoup.isMessageFound("TEST", ""));
    }

    @Test
    public void testAlphabetSoupBowlHaveMessageLetters() {
        String msg = "Hi Java";
        String bowl = "avaJiHdsafdasf";
        assertTrue("Message can't be constructed from the letter bowl", alphabetSoup.isMessageFound(msg, bowl));
    }

    @Test
    public void testAlphabetSoupBowlHaveNotMessageLetters() {
        String msg = "Hi Java 8";
        String bowl = "avaJiHdsafdasf";
        assertFalse("Message can be constructed from the letter bowl", alphabetSoup.isMessageFound(msg, bowl));
    }
}