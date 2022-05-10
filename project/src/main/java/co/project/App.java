package co.project;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner(System.in);
//    	UserService dao = new UserServiceImpl();
//    	List<User> list = new ArrayList<User>();
//    	list = dao.userInfoList();
//    	
//    	for(User us : list) {
//    		us.toString();
//    	}
    	
    	Menu menu = new Menu();
    	menu.run();
//    	Hamburger ham = new Hamburger();
//    	System.out.println(ham.getpattys(scanner.nextInt()));
    }
}
