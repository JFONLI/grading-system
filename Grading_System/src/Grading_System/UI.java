package Grading_System;

import java.io.IOException;
import java.util.Scanner;

public class UI {
	
	/**
	 * 創建GradeSystem
	 */
	
	private GradeSystem gradesystem;
	private Scanner scanner = new Scanner(System.in);
	private Scanner scan = new Scanner(System.in);
	private String ID;
	
	/**
	 * 創建UI
	 * 1.建立GradeSystem
	 * 2.呼叫ShowMenu()建立主選單
	 * 3.允許使用者輸入指令
	 * 4.使用DecideCmd(choose)處理使用者的指令
	 * @choose 接收使用者輸入的指令
	 * @throws IDNotFoundException 查詢不到此ID
	 * Example: UI();
	 * @throws NoSuchCommandException 
	 * @throws IOException 
	 */
	
	public UI() throws IDNotFoundException, NoSuchCommandException{
			this.gradesystem = new GradeSystem();
			System.out.print("輸入ID或Q?\n");
			String FirstCmd = scanner.nextLine();
			switch(FirstCmd)
			{
				case "Q":
					System.out.print("結束了\n");
					System.exit(0);
					break;
				default:
					ID = FirstCmd;
					Menu(ID);
					
			}
	}
	
	
	
	/**
	 * 顯示主選單
	 * Example: someObject.ShowMenu();
	 * Time estimate: O(1)
	 */
	
	public void ShowMenu()
	{
		System.out.print("輸入指令:\n");
		System.out.print("1) G 顯示成績\n");
		System.out.print("2) R 顯示排名\n");
		System.out.print("3) A 顯示平均\n");
		System.out.print("4) W 更新配分\n");
		System.out.print("5) E 離開選單\n");
	}
	
	/**
	 * 顯示主選單，可輸入ID或是Q(退出)
	 * @throws IDNotFoundException 查詢不到此ID
	 * @throws NoSuchCommandException 錯誤指令
	 * @throws IOException 
	 */
	private void FirstPage() throws IDNotFoundException, NoSuchCommandException
	{
		System.out.print("輸入ID或Q?\n");
		String FirstCmd = scanner.nextLine();
		switch(FirstCmd)
		{
			case "Q":
				System.out.print("結束了\n");
				System.exit(0);
				break;
			default:
				Menu(FirstCmd);
		}
	}
	/**
	 * 顯示歡迎畫面並顯示主選單
	 * @param ID 需要查詢的ID(用以顯示名字)
	 * @throws IDNotFoundException 查詢不到此ID
	 * @throws NoSuchCommandException 錯誤指令
	 * @throws IOException 
	 */
	
	private void Menu(String ID) throws IDNotFoundException, NoSuchCommandException
	{
		int index = gradesystem.FoundID(ID);
		System.out.print("Welcome " + gradesystem.GetDataArray().get(index).Name+"\n");
		ShowMenu();
		
		while(true)
		{
			//String choose = scanner.nextLine();
			String choose = "G";
			DecideCmd(choose, index);
		}
	}
	
	/**
	 * 處理使用者的指令
	 * 
	 * @param choose 使用者輸入的指令
	 * @throws IDNotFoundException 查詢不到此ID
	 * Example: someObject.DecideCmd(1); 秀出使用者全部的成績
	 * Time estimate: O(1)
	 * @throws NoSuchCommandException 
	 * @throws IOException 
	 */
	
	private void DecideCmd(String choose, int index) throws IDNotFoundException, NoSuchCommandException
	{
		switch (choose)
		{
			case "G":
				gradesystem.ShowGrade(index);
				break;
			case "R":
				gradesystem.ShowRank(index);
				break;
			case "A":
				gradesystem.ShowAverage(index);
				break;
			case "W":
				gradesystem.ChangeWeights();
				break;
			case "E":
				FirstPage();
			default:
				throw new NoSuchCommandException("QQ");
		}

	}
	
	
}
