package Grading_System;

import java.io.IOException;

/**
 * 創建UI
 * 處理ID輸入錯誤狀況 (Catch IDNotFoundException)
 * 處理指令輸入錯誤狀況 (Catch NoSuchCommandException)
 */

public class Main {
	public static void main(String[] args) throws NoSuchCommandException
	{
		try {
			new UI();
		}
		catch(IDNotFoundException e)
		{
			System.out.println("ID錯了!");
		}
		catch(NoSuchCommandException e)
		{
			System.out.println("指令錯了!");
		}

	}
	
}
