package Grading_System;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test function: GradeSystem()
 * test data:
 * 1.Check Whether DataArray is Null
 * 2.Check DataArray's size
 * 3.Check initial weights
 */

class TestGradeSystem {

	private GradeSystem TestGradeSystem = null;
	@BeforeEach
	void setUp() throws Exception {
		TestGradeSystem = new GradeSystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		TestGradeSystem = null;
	}

	@Test
	void test() {
		assertNotNull(TestGradeSystem.GetDataArray());
		assertEquals(TestGradeSystem.GetDataArray().size(), 63, 0);
		int [] test = {10,10,10,30,40};
		assertArrayEquals(TestGradeSystem.GetWeights(), test);
	}

}
