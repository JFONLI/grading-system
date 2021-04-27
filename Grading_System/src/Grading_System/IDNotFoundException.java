package Grading_System;

public class IDNotFoundException extends Exception {

	/**
	 * 建立查詢無此ID的例外
	 */
	private static final long serialVersionUID = 1L;
	
	public IDNotFoundException(String ErrorMessage)
	{
		super(ErrorMessage);
	}
	
}
