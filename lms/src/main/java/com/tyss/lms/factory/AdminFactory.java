package com.tyss.lms.factory;

import com.tyss.lms.dao.AdminDAO;
import com.tyss.lms.dao.AdminDAOimpl;
import com.tyss.lms.service.AdminService;
import com.tyss.lms.service.AdminServiceImpl;


public class AdminFactory {
	public static AdminDAO getAdminDAO() {
		return new AdminDAOimpl();	
	}
	public static AdminService getAdminService() {
		return new AdminServiceImpl();
		
	}

}
