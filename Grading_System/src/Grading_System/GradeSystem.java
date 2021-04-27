package Grading_System;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeSystem {
	
	/**
	 * @DataArray 創建ArrayList其裡面每個元素為Class Person
	 * @weights 創建並初始化權重
	 */
	private ArrayList<Person> DataArray = new ArrayList<Person>();
	private int []weights = {10,10,10,30,40};
	
	/**
	 * 因DataArray為private 故寫一程式來讀取
	 * @return DataArray
	 */
	public ArrayList<Person> GetDataArray()
	{
		return DataArray;
	}
	
	/**
	 * 因weights為private 故寫一程式來讀取
	 * @return
	 */
	public int[] GetWeights() {
		return weights;
	}
	
	/**
	 * 建構GradeSystem讀取txt中的資料
	 * @br 用BufferReader和FileReader讀進資料暫存處
	 * @line 將br拆解成行來讀取
	 * @temp 為Class Person 將line讀取到的資料存進去
	 * @DataArray 所有人資料儲存處，將temp依序放進其中
	 */
	public GradeSystem()
	{
		//File filename = new File("input.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			String line;
			//ArrayList<Person> DataArray = new ArrayList<Person>();
			while (br.ready()){
				line = br.readLine();
				String []parts = line.split(" ");
				Person temp = new Person();
				temp.ID = parts[0];
				temp.Name = parts[1];
				temp.grades = new int[5];
				for(int i=0; i<5; i++)
					temp.grades[i] = Integer.valueOf(parts[i+2]);
				DataArray.add(temp);
			
			}
			
			br.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("FILE NOT FOUND");
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	/**
	 * 讀取ID並找到此ID擁有者在DataArray中的位置
	 * @param ID 需要查詢的ID
	 * @return 回傳此ID擁有者在DataArray中的位置
	 * @throws IDNotFoundException 查詢不到此ID
	 * 
	 * Example: someObject.FoundID(962001044); return 15
	 * Time estimate: O(n)
	 */
	public int FoundID(String ID) throws IDNotFoundException
	{
	
		for (int i=0; i<DataArray.size(); i++)
			if (DataArray.get(i).ID.equals(ID))
				return i;	
		
		throw new IDNotFoundException("");
	}
	
	/**
	 * 接收輸入ID查詢並顯示此ID擁有者的成績
	 * @ID 輸入的ID
	 * @index 接受FoundID的回傳值
	 * @throws IDNotFoundException 查詢不到此ID
	 * Example: someObject.ShowGrade();
	 * Time estimate: O(n)
	 */
	
	public void ShowGrade(int index) throws IDNotFoundException
	{
		System.out.print(DataArray.get(index).Name+"\n");
		System.out.print("lab01    lab02    lab03    midTerm    FinalExam\n");
		System.out.print(" "+DataArray.get(index).grades[0]+"      ");
		System.out.print(" "+DataArray.get(index).grades[1]+"      ");
		System.out.print(" "+DataArray.get(index).grades[2]+"       ");
		System.out.print(" "+DataArray.get(index).grades[3]+"         ");
		System.out.print(" "+DataArray.get(index).grades[4]+"\n");
	}
	
	/**
	 * 計算每個人的總分並存進DataArray中
	 * @sum 總分暫存
	 * Example: someObject.GradeSum();
	 * Time estimate: O(n);
	 */
	
	private void GradeSum()
	{	
		int sum;
		for (int i=0; i<DataArray.size(); i++)	
		{	
			sum = 0;
			for(int j=0; j<5;j++)
				sum += DataArray.get(i).grades[j]*weights[j];
			DataArray.get(i).sum = sum;
		}
	}
	
	/**
	 * 依DataArray中的Sum(總分)來進行排名排序
	 * @param index ID擁有者在DataArray中的位置
	 * @compare ID擁有者的總分作為比較依據
	 * @rank 排名暫存
	 * @return 回傳此擁有者的排名
	 * @throws IDNotFoundException 查詢不到此ID
	 * 
	 * 搭配FoundID(ID)進行使用
	 * Example: someObject.Rank(FoundID(962001044); return rank;
	 * Time estimate: O(n)
	 */
	
	private int Rank(int index)
	{
		GradeSum();
		int rank = 1;
		int compare = DataArray.get(index).sum;;
		
		for(int i=0; i<DataArray.size(); i++)
			if(compare < DataArray.get(i).sum)
				rank++;
			
		return rank;
	}
	
	/**
	 * 接收輸入ID查詢並顯示此ID擁有者的排名
	 * @ID 輸入的ID
	 * @index 接受FoundID的回傳值
	 * @rank 接受Rank的回傳值
	 * @throws IDNotFoundException 查詢不到此ID
	 * Example: someObject.ShowRank();
	 * Time estimate: O(1)
	 */
	
	public void ShowRank(int index)
	{
		int rank = Rank(index);
		
		System.out.print(DataArray.get(index).Name+" 第" + rank+"名\n");
		
	}
	
	/**
	 * 計算總權重數
	 * @sum 總權重暫存
	 * @return 回傳權重總數
	 * Example: someObject.TotalWeights(); return 總權重數;
	 * Time estimate: O(n)
	 */
	
	private int TotalWeights()
	{
		int sum = 0;
		for (int i=0; i<5; i++)
			sum += weights[i];
		
		return sum;
	}
	
	/**
	 * 接收輸入ID查詢並顯示此ID擁有者的平均成績
	 * @ID 輸入的ID
	 * @index 接受FoundID的回傳值
	 * @average 平均暫存，最後除以TotalWeights()(總權重數)
	 * @throws IDNotFoundException 查詢不到此ID
	 * Example: someObject.ShowAverage();
	 * Time estimate: O(n)
	 */
	
	public void ShowAverage(int index) throws IDNotFoundException
	{
		float average = 0;
		
		for (int i=0; i<5; i++)
			average += DataArray.get(index).grades[i]*weights[i];
		
		average = average/TotalWeights();
		
		System.out.print(DataArray.get(index).Name+"的平均成績為 " + average + "分(為加權平均)\n");
	}
	
	/**
	 * 改變成績所佔權重，並在最後讓使用者確定是否改變權重
	 * @throws NoSuchCommandException 
	 * @throws IOException 
	 * @OldWeights 記錄舊的權重
	 * @Change 接受使用者輸入指令決定是否改變權重
	 * Example: someObject.ChangeWeights();
	 * Time estimate: O(n);
	 */
	
	public void ChangeWeights() throws NoSuchCommandException
	{
		
		int []OldWeights= {0,0,0,0,0};
		
			
		System.out.print("舊配分 : lab1 "+weights[0]+"% lab2 "+weights[1]+"% lab3 "+weights[2]+"% mid-term "+weights[3]+"% final exam "+weights[4]+"%\n");
		for (int i=0; i<5; i++)
			OldWeights[i] = weights[i];
		
		GetNewWeights();
		
		System.out.print("以上正確嗎? Y(Yes)或N(No) ");

		String Change = scanner.nextLine();
		switch (Change)
		{
			case "Y":
				System.out.print("完成變更\n");
				break;
			case "N":
				for (int i=0; i<5; i++)
					weights[i] = OldWeights[i];
				System.out.print("已取消變更\n");
				break;
			default:
				throw new NoSuchCommandException("");
				
		}
		
	}
	
	/**
	 * 讀取新的權重並印出
	 */
	
	private void GetNewWeights()
	{
		int input[] = new int[5];
		System.out.print("輸入新配分\n");
		System.out.print("lab1 ");
		input[0] = Integer.parseInt(scanner.nextLine());
		System.out.print("lab2 ");
		input[1] = Integer.parseInt(scanner.nextLine());
		System.out.print("lab3 ");
		input[2] = Integer.parseInt(scanner.nextLine());
		System.out.print("mid-term ");
		input[3] = Integer.parseInt(scanner.nextLine());
		System.out.print("final exam ");
		input[4] = Integer.parseInt(scanner.nextLine());
		this.weights = input;
		System.out.print("請確認新配分 : lab1 "+weights[0]+"% lab2 "+weights[1]+"% lab3 "+weights[2]+"% mid-term "+weights[3]+"% final exam "+weights[4]+"%\n");
	}
	
	/**
	 * 創建一個scanner供全部function使用
	 */
	private Scanner scanner = new Scanner(System.in);
	
}
