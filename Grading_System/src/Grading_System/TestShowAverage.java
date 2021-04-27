package Grading_System;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test function: GradeSystem.ShowAverage(FoundID(ID))
 * test data:
 * 1.ID 985002504
 * 2.ID 985002039
 * 3.ID 975002069
 */

class TestShowAverage {

	private ByteArrayOutputStream Result = null;
	@BeforeEach
	void setUp() throws Exception {
		Result = new ByteArrayOutputStream();
		System.setOut(new PrintStream(Result));
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setIn(System.in);
	}

	@Test
	void TestShowAverage_985002504() throws IDNotFoundException {
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ShowAverage(TestGradeSystem.FoundID("985002504"));
		
		String Testing = "";
		Testing += "張婉庭的平均成績為 90.6分(為加權平均)\n";
		assertEquals(Testing, Result.toString());
	}
	
	@Test
	void TestShowAverage_985002039() throws IDNotFoundException {
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ShowAverage(TestGradeSystem.FoundID("985002039"));
		
		String Testing = "";
		Testing += "曾裕庭的平均成績為 93.5分(為加權平均)\n";
		assertEquals(Testing, Result.toString());
	}
	
	@Test
	void TestShowAverage_975002069() throws IDNotFoundException {
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ShowAverage(TestGradeSystem.FoundID("975002069"));
		
		String Testing = "";
		Testing += "練俊民的平均成績為 91.7分(為加權平均)\n";
		assertEquals(Testing, Result.toString());
	}

}
