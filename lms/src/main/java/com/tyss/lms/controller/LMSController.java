package com.tyss.lms.controller;

import java.util.List;
import java.util.Scanner;

import com.tyss.lms.dao.AdminDAO;
import com.tyss.lms.dao.StudentDAO;
import com.tyss.lms.dto.AdminBean;
import com.tyss.lms.dto.Book;
import com.tyss.lms.dto.StudentInformation;
import com.tyss.lms.factory.AdminFactory;
import com.tyss.lms.factory.StudentFactory;
import com.tyss.lms.service.AdminService;
import com.tyss.lms.service.StudentService;

public class LMSController {

	private static String publisherName;
	private static int copyrightyear;

	public static void main(String[] args) {

		Scanner scanner= new Scanner(System.in);
		StudentService service=StudentFactory.getStudentService();
		StudentDAO studentdao=StudentFactory.getStudentDAO();
		AdminDAO admindao=AdminFactory.getAdminDAO();
		AdminService adminservice=AdminFactory.getAdminService();


		while(true) {
			System.out.println("Student Login");
			System.out.println("Press 1 to Register");
			System.out.println("Press 2 to Login");
			System.out.println("Press 3 to Search the Book");
			System.out.println("Press 10 to book borrow");
			System.out.println("Press 11 to return the book");
			System.out.println("Press 12 to update the book");
			System.out.println("Admin Login");
			System.out.println("Enter 4 to Login Admin ");	
			System.out.println("Enter 5 to Admin Register ");
			System.out.println("Enter 6 to Add Admin Book");
			System.out.println("Enter 7 to search Admin book");
			System.out.println("Enter 8 to delete the book");
			System.out.println("Enter 9 to issue the book");
			
			int choice=scanner.nextInt();
			
			switch(choice) {
			case 1: System.out.println("Enter User Name");
			String regusername=scanner.next();
			System.out.println("Enter Password");
			String regpassword=scanner.next();
			System.out.println("Enter First Name");
			String regfirstname=scanner.next();
			System.out.println("Enter Last Name");
			String reglastname=scanner.next();
			System.out.println("Enter Matri No");
			int regmatrino=scanner.nextInt();
			System.out.println("Enter Department");
			String regdepartment=scanner.next();
			System.out.println("Enter Level");
			String reglevel=scanner.next();

			StudentInformation studentinformation=new StudentInformation();
			studentinformation.setUsername(regusername);
			studentinformation.setPassword(regpassword);
			studentinformation.setFirstname(regfirstname);
			studentinformation.setLastname(reglastname);
			studentinformation.setMatrino(regmatrino);
			studentinformation.setDepartment(regdepartment);
			studentinformation.setLevel(reglevel);

			boolean check=service.register(studentinformation);
			if(check) {
				System.out.println("Registered");
			}else {
				System.out.println("Email already exists");
			}
			break;

			case 2:
				System.out.println("Enter User");
				String userName=scanner.next();
				System.out.println("Enter Password");
				String password=scanner.next();
				try {
					StudentInformation authStudentInformation=service.auth(userName, password);
					System.out.println("Logged In");

				}catch(Exception e) {
					//e.printStackTrace();
					System.out.println("Invalid Credentials");
				}
				break;


			case 3:
				System.out.println("Select the required Book");
				String bookTitle=scanner.next();
				Book book=new Book();
				try {
					Book bookbean=service.searchbyBookName(bookTitle) ;
					if(bookbean!=null) {
						System.out.println(bookbean.getBookTitle()+"Book is available");
					}

				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Book is not available");
				}
				break;
				
			case 10:
				System.out.println("select the required book to be borrowed");
				String bookBorrow=scanner.next();
				Book bookborrow=new Book();
				try {
					boolean bookbean=service.bookBorrow(bookBorrow);
					if(bookborrow!=null) {
						System.out.println(bookborrow.getBookTitle()+"Book can be borrowed");
					}
					
				}catch(Exception e) {
					System.out.println("Book is not borrowed");
				}
					break;
					
			case 11:
				System.out.println("Select the book to be returned");
				int matricNo=scanner.nextInt();
				StudentInformation bookreturn=new StudentInformation();
				try {
					boolean bookReturn=service.bookReturn(matricNo);
					if(bookreturn!=null) {
						System.out.println(bookreturn.getMatrino()+"Book can be returned");
						
						
					}
					
				}catch(Exception e) {
					System.out.println("Book is already returned");
				}
				break;
				
			case 12:
				System.out.println("Select the book to be updated");
				String booktitle=scanner.next();
				Book bookUpdate=new Book();
				try {
					boolean bookupdate=service.update(booktitle);
					if(bookUpdate!=null) {
						System.out.println(bookUpdate.getBookTitle()+"Book is updated");
					}
				}catch(Exception e) {
					System.out.println("Book is already updated");
				}

				break;
				
			case 4:
				System.out.println("Enter email");
				String adminemail=scanner.next();
				System.out.println("Enter password");
				String adminpassword=scanner.next();
				try {
					AdminBean adminbean=adminservice.auth(adminemail, adminpassword);
					System.out.println("Logged in");

				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Book is not available");
				}	
				break;

			case 5:
				System.out.println("Enter name");
				String regname=scanner.next();
				System.out.println("Enter id");
				int regid=scanner.nextInt();
				System.out.println("Enter email");
				String regEmail=scanner.next();
				System.out.println("Enter password");
				String regpasword=scanner.next();
				System.out.println("Enter phone no");
				long regno=scanner.nextLong();


				AdminBean adminbean=new AdminBean();
				adminbean.setName(regname);
				adminbean.setAid(regid);
				adminbean.setEmail(regEmail);
				adminbean.setPassword(regpasword);
				adminbean.setPhone(regno);

				boolean checkadmin=adminservice.register(adminbean);
				if(checkadmin) {
					System.out.println("Registered");
				}else {
					System.out.println("Email already exists");
				}
				break;

			case 6:
				Book bookbean=new Book();
				System.out.println("How many bookes needed");
				int bookneeded=scanner.nextInt();
				int count=0;
				while(bookneeded!=0) {
					System.out.println("Enter the book Title to add");
					String bookTitle1=scanner.next();
					bookbean.setBookTitle(bookTitle1);
					System.out.println("Enter the caregory");
					String category=scanner.next();
					bookbean.setCategory(category);
					System.out.println("Enter the Author");
					String author=scanner.next();
					bookbean.setAuthor(author);
					System.out.println("Enter the copies");
					int copies=scanner.nextInt();
					bookbean.setCopies(copies);
					System.out.println("Enter the BookPub");
					String bookPub=scanner.next();
					bookbean.setBookPub(bookPub);
					System.out.println("Enter the Publisher name");
					String publisherName=scanner.next();
					bookbean.setPublisherName(publisherName);
					System.out.println("Enter copy rigth year");
					int copyrightyear=scanner.nextInt();
					bookbean.setCopyrightyear(copyrightyear);
					adminservice.addBook(bookbean);
					count++;
					System.out.println(count+"Book is added");
					bookneeded--;

				}
				break;
			case 7:
				System.out.println("Select the required Book");
				String searchbookTitle=scanner.next();

				try {
					Book searchbook=adminservice.search(searchbookTitle);
					System.out.println(searchbook.getBookTitle()+"Book is available");
				}
				catch(Exception e) {
					//e.printStackTrace();
					System.out.println("Book is not available");
				}

				break;

			case 8:
				System.out.println("Enter the book name to delete");
				String searchbook=scanner.next();
				try {
					Book bookdelete=adminservice.search(searchbook);
					adminservice.delete(bookdelete);
					System.out.println("Succesfully deleted");

				}catch(Exception e) {
					System.out.println("No book found");

				}

				break;

			case 9:
				System.out.println("Enter Student Matric No");
				int matricNo1=scanner.nextInt();
				System.out.println("Enter the book title to issue the book");
				String bookmatric=scanner.next();
				try {
					boolean check2=adminservice.issueBook(matricNo1, bookmatric);
					if(check2) {
						System.out.println("Book issued succesfully");
					}
				}catch(Exception e) {
					System.out.println("Student Matric is invalid");

				}
				break;

			default:System.out.println("Invalid credentials");
			break;

			}

		}

	}

}
