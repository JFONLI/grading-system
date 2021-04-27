package Grading_System;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test function: GradeSystem.ShowRank(FoundID(ID))
 * test data:
 * 1.ID 985002027
 * 2.ID 985002038
 * 3.ID 985002507
 */

class TestShowRank {

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
	void TestShowRank_985002027() throws IDNotFoundException {
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ShowRank(TestGradeSystem.FoundID("985002027"));
		
		String Testing = "";
		Testing += "張軒滄 第10名\n";
		assertEquals(Testing, Result.toString());
	}
	
	@Test
	void TestShowRank_985002038() throws IDNotFoundException {
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ShowRank(TestGradeSystem.FoundID("985002038"));
		
		String Testing = "";
		Testing += "吳德毅 第21名\n";
		assertEquals(Testing, Result.toString());
	}
	
	@Test
	void TestShowRank_985002507() throws IDNotFoundException {
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ShowRank(TestGradeSystem.FoundID("985002507"));
		
		String Testing = "";
		Testing += "李明遠 第11名\n";
		assertEquals(Testing, Result.toString());
	}

}
