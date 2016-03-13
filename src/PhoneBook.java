import java.util.Scanner;

public class PhoneBook {
	
static Scanner scanner = new Scanner(System.in);
	
	public static void showMenu(){
		int nSelectMenu;
		
		do{
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 프로그램 종료");
			System.out.print("선택: ");
			nSelectMenu = scanner.nextInt();
			scanner.nextLine();	// fflush				
			
			if(nSelectMenu == 1)
				readData();
			
		} while(nSelectMenu != 2);
		
	}
	public static void readData(){
		String name;
		String phonenumber;
		String birthday;
		PhoneInfo CPhoneInfo;
		
		System.out.print("이름: ");
		name = scanner.nextLine();
		
		System.out.print("전화번호: ");
		phonenumber = scanner.nextLine();
		
		System.out.print("생년월일: ");
		birthday = scanner.nextLine();
		
		CPhoneInfo = new PhoneInfo(name, phonenumber, birthday);
		CPhoneInfo.showPhoneInfo();
	}
	
	public static void main(String[] args) {
		PhoneBook.showMenu();
	}

}