package Grading_System;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing Case
 * 1.ID:962001044 return 1
 * 2.ID:966002031 return 5
 * 3.ID:995002901 return 62
 * 
 */

class TestFoundID {

	private GradeSystem testGradeSystem = null;
	@BeforeEach
	void setUp() throws Exception {
		testGradeSystem = new GradeSystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		testGradeSystem = null;
	}

	@Test
	void TestFoundID962001044() throws IDNotFoundException {
		assertEquals(1, testGradeSystem.FoundID("962001044"));
	}
	
	@Test
	void TestFoundID966002031() throws IDNotFoundException {
		assertEquals(5, testGradeSystem.FoundID("966002031"));
	}
	
	@Test
	void TestFoundID995002901() throws IDNotFoundException {
		assertEquals(62, testGradeSystem.FoundID("995002901"));
	}

}
