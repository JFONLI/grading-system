package Grading_System;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegrationTest {
	
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
	void test() throws IDNotFoundException, NoSuchCommandException{
		System.setIn(new ByteArrayInputStream("975002021\n".getBytes()));
		//System.setIn(new ByteArrayInputStream("975002021\n".getBytes()));
		UI ui = new UI();
		
		String Testing = "";
		Testing += "輸入ID或Q?\n";
		
		Testing += "Welcome 楊祺賢\n";
		Testing += "輸入指令:\n";
		Testing += "1) G 顯示成績\n";
		Testing += "2) R 顯示排名\n";
		Testing += "3) A 顯示平均\n";
		Testing += "4) W 更新配分\n";
		Testing += "5) E 離開選單\n";
		Testing += "輸入指令:\n";
		
		Testing += "楊祺賢\n";
		Testing += "lab01    lab02    lab03    midTerm    FinalExam\n";
		Testing += " 81       97       90        82          84\n";
		
		Testing += "楊祺賢 第60名\n";
		
		Testing += "楊祺賢的平均成績為 85.0分(為加權平均)\n";
		
		Testing += "輸入ID或Q?\n";
		Testing += "結束了\n";
		
		assertEquals(Testing, Result.toString());
	}

}
