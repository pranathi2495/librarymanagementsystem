package com.tyss.lms.dao;


import java.util.List;

import com.tyss.lms.dto.Book;
import com.tyss.lms.dto.StudentInformation;

public interface StudentDAO {

	StudentInformation auth(String username, String password);
	boolean register(StudentInformation studentinfo);
	Book searchbyBookName(String bookName);
	boolean bookBorrow(String bookTitle);
	boolean bookReturn(int matricno);
	boolean accountCreation(int matricno);
	boolean update(String bookTitle);





}
