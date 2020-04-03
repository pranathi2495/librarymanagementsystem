package com.tyss.lms.db;

import java.util.LinkedList;

import com.tyss.lms.dto.AdminBean;
import com.tyss.lms.dto.Book;
import com.tyss.lms.dto.StudentInformation;

public class DataBase {
	
	
	public static final LinkedList<StudentInformation> USERS=new LinkedList<StudentInformation>();
	
	public static final LinkedList<Book> BOOKS=new LinkedList<Book>();

	
	public static final LinkedList<AdminBean> ADMIN=new LinkedList<AdminBean>();
	

}
