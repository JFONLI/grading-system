package Grading_System;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test function: GradeSystem.ShowGrade(FoundID(ID))
 * test data:
 * 1.ID 985002027
 * 2.ID 985002033
 * 3.ID 986002026
 */

class TestShowGrade {

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
	void TestShowGrade_985002027() throws IDNotFoundException {
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ShowGrade(TestGradeSystem.FoundID("985002027"));
		String Testing = "";
		Testing += "張軒滄\n";
		Testing += "lab01    lab02    lab03    midTerm    FinalExam\n";
		Testing += " 99       94       91        83          99\n";
		
		assertEquals(Testing, Result.toString());
	}
	
	@Test
	void TestShowGrade_985002033() throws IDNotFoundException {
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ShowGrade(TestGradeSystem.FoundID("985002033"));
		String Testing = "";
		Testing += "林宗瑋\n";
		Testing += "lab01    lab02    lab03    midTerm    FinalExam\n";
		Testing += " 90       88       97        91          94\n";
		
		assertEquals(Testing, Result.toString());
	}
	
	@Test
	void TestShowGrade_986002026() throws IDNotFoundException {
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ShowGrade(TestGradeSystem.FoundID("986002026"));
		String Testing = "";
		Testing += "闕裕柏\n";
		Testing += "lab01    lab02    lab03    midTerm    FinalExam\n";
		Testing += " 90       85       89        87          91\n";
		
		assertEquals(Testing, Result.toString());
	}
	


}
