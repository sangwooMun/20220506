package co.project;

import java.util.Scanner;

import co.project.Hamburger.Hamburger;


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
//    	System.out.print(ham.getbreads(scanner.nextInt()));
//    	System.out.print(ham.getpattys(scanner.nextInt()));
//    	System.out.print(ham.getpattys(scanner.nextInt()));
//    	System.out.print(ham.getpattys(scanner.nextInt()));
//    	System.out.print(ham.getpattys(scanner.nextInt()));
//    	System.out.print(ham.getpattys(scanner.nextInt()));
//    	System.out.print(ham.getbreads(scanner.nextInt()));
//    	System.out.println(ham.getbreads(scanner.nextInt()));
    	
//    	String num = ham.getbreads(scanner.nextInt());
//    	System.out.println(num);
    }
}
