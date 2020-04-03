package com.tyss.lms.service;

import com.tyss.lms.dto.AdminBean;
import com.tyss.lms.dto.Book;

public interface AdminService {
	
	boolean register(AdminBean admn);
	AdminBean auth(String email, String password);
	boolean addBook(Book book);
	boolean delete(Book book);
	Book search(String bookName);
	boolean issueBook(int matricNo, String bookTitle);
	boolean update(String bookTitle);

}
