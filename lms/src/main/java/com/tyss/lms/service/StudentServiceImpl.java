package com.tyss.lms.service;

import com.tyss.lms.dao.StudentDAO;
import com.tyss.lms.dto.Book;
import com.tyss.lms.dto.StudentInformation;
import com.tyss.lms.factory.StudentFactory;

public class StudentServiceImpl  implements StudentService{
	
	private StudentDAO dao=StudentFactory.getStudentDAO();
	
	public StudentInformation auth(String username, String password) {
		return dao.auth(username, password);
	}

	public boolean register(StudentInformation studentinfo) {
		return dao.register(studentinfo);
	}

	public Book searchbyBookName(String bookName) {
		return dao.searchbyBookName(bookName);
	}

	public boolean bookBorrow(String bookTitle) {
		return dao.bookBorrow(bookTitle);
	}

	public boolean bookReturn(int matricno) {
		return dao.bookReturn(matricno);
	}

	public boolean accountCreation(int matricno) {
		return dao.accountCreation(matricno);
	}

	public boolean update(String bookTitle) {
		return dao.update(bookTitle);
	}
	

}