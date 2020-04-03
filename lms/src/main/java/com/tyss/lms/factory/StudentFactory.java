package com.tyss.lms.factory;

import com.tyss.lms.dao.StudentDAO;
import com.tyss.lms.dao.StudentDAOImpl;
import com.tyss.lms.service.StudentService;
import com.tyss.lms.service.StudentServiceImpl;

public class StudentFactory {
	
	public static StudentDAO getStudentDAO() {
		return new StudentDAOImpl();	
	}
	public static StudentService getStudentService() {
		return new StudentServiceImpl();
		
	}

}
