package com.tyss.lms.dao;

import java.util.List;

import com.tyss.lms.db.DataBase;
import com.tyss.lms.dto.Book;
import com.tyss.lms.dto.StudentInformation;
import com.tyss.lms.exception.BookException;
import com.tyss.lms.exception.StudentException;

public class StudentDAOImpl implements StudentDAO{

	public StudentInformation auth(String username, String password) {
		for(StudentInformation studentinfo:DataBase.USERS) {
			if(studentinfo.getUsername().equals(username) && studentinfo.getPassword().equals(password)) {
				return studentinfo;
			}
		}
		throw new StudentException("Invalid Credentials");

	}

	public boolean register(StudentInformation studentinfo) {
		for(StudentInformation studentinformation: DataBase.USERS) {
			if(studentinformation.getUsername().equals(studentinfo.getUsername())) {
				return false;
			}
		}
		DataBase.USERS.add(studentinfo);
		return true;
	}

	public Book searchbyBookName(String bookName) {
		for(Book book: DataBase.BOOKS) {
			if(book.getBookTitle().equals(bookName)) {
				return book;
			}

		}
		throw new BookException("Book is not available");

	}

	public boolean bookBorrow(String bookTitle) {
		for(Book book: DataBase.BOOKS) {
			if(book.getBookTitle().equals(bookTitle)) {
				return true;

			}

		}
		throw new BookException("Book is not borrowed");
	}

	public boolean bookReturn(int matricno) {
		for(StudentInformation studinfo:DataBase.USERS) {
			if(studinfo.getMatrino()==matricno) {
				return true;
			}
		}
		throw new BookException("Book is already returned");
	}

	public boolean accountCreation(int matricno) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean update(String bookTitle) {
		for(Book book:DataBase.BOOKS) {
			if(book.getBookTitle().equals(bookTitle)) {
				int copies=book.getCopies();
				copies++;
				System.out.println("No of Books available are"+copies);
			}
			
		}
		throw new BookException("Book is already uddated");
	}





}
