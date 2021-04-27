package Grading_System;

public class NoSuchCommandException extends Exception {

	/**
	 * 建立查詢無此ID的例外
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchCommandException(String ErrorMessage)
	{
		super(ErrorMessage);
	}
	
}
