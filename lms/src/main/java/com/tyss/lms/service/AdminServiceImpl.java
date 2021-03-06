package com.tyss.lms.service;

import com.tyss.lms.dao.AdminDAO;
import com.tyss.lms.dto.AdminBean;
import com.tyss.lms.dto.Book;
import com.tyss.lms.factory.AdminFactory;

public class AdminServiceImpl implements AdminService {

	private AdminDAO dao=AdminFactory.getAdminDAO();

	public boolean register(AdminBean admn) {
		return dao.register(admn);
	}

	public AdminBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	public boolean addBook(Book book) {
		return dao.addBook(book);
	}

	public boolean delete(Book book) {
		return dao.delete(book);
	}

	public Book search(String bookName) {
		return dao.search(bookName);
	}

	public boolean issueBook(int matricNo, String bookTitle) {
		return dao.issueBook(matricNo, bookTitle);
	}

	public boolean update(String bookTitle) {
		return dao.update(bookTitle);
	}

}
