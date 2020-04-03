package com.tyss.lms.service;

import com.tyss.lms.dto.Book;
import com.tyss.lms.dto.StudentInformation;

public interface StudentService {
	
	StudentInformation auth(String username, String password);
	boolean register(StudentInformation info);
	Book searchbyBookName(String bookName);
	boolean bookBorrow(String bookTitle);
	boolean bookReturn(int matricno);
	boolean accountCreation(int matricno);
	boolean update(String bookTitle);

}
