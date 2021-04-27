package Grading_System;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * test function: GradeSystem.ChangeWeights()
 * test data:
 * 1.NewWeights = {10 20 30 40 50} And Press Yes
 * 2.NewWeights = {10 20 30 40 50} But Press No
 */

class TestChangeWeights {

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
	void TestChangeWeights_Yes() throws NoSuchCommandException, IOException {
		System.setIn(new ByteArrayInputStream("10\n20\n30\n40\n50\nY\n".getBytes()));
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ChangeWeights();
		
		
		String Testing = "";
		Testing += "舊配分 : lab1 10% lab2 10% lab3 10% mid-term 30% final exam 40%\n";
		Testing += "輸入新配分\n";
		Testing += "lab1 ";
		Testing += "lab2 ";
		Testing += "lab3 ";
		Testing += "mid-term ";
		Testing += "final exam ";
		Testing += "請確認新配分 : lab1 10% lab2 20% lab3 30% mid-term 40% final exam 50%\n";
		Testing += "以上正確嗎? Y(Yes)或N(No) ";
		
		Testing += "完成變更\n";
		
		assertEquals(Testing, Result.toString());
	}
	
	@Test
	void TestChangeWeights_No() throws NoSuchCommandException, IOException {
		System.setIn(new ByteArrayInputStream("10\n20\n30\n40\n50\nN\n".getBytes()));
		GradeSystem TestGradeSystem = new GradeSystem();
		TestGradeSystem.ChangeWeights();
		
		
		String Testing = "";
		Testing += "舊配分 : lab1 10% lab2 10% lab3 10% mid-term 30% final exam 40%\n";
		Testing += "輸入新配分\n";
		Testing += "lab1 ";
		Testing += "lab2 ";
		Testing += "lab3 ";
		Testing += "mid-term ";
		Testing += "final exam ";
		Testing += "請確認新配分 : lab1 10% lab2 20% lab3 30% mid-term 40% final exam 50%\n";
		Testing += "以上正確嗎? Y(Yes)或N(No) ";
		
		Testing += "已取消變更\n";
		
		assertEquals(Testing, Result.toString());

	}

}
