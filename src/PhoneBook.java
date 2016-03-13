import java.util.Scanner;

public class PhoneBook {
	
static Scanner scanner = new Scanner(System.in);
	
	public static void showMenu(){
		int nSelectMenu;
		
		do{
			System.out.println("�����ϼ���...");
			System.out.println("1. ������ �Է�");
			System.out.println("2. ���α׷� ����");
			System.out.print("����: ");
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
		
		System.out.print("�̸�: ");
		name = scanner.nextLine();
		
		System.out.print("��ȭ��ȣ: ");
		phonenumber = scanner.nextLine();
		
		System.out.print("�������: ");
		birthday = scanner.nextLine();
		
		CPhoneInfo = new PhoneInfo(name, phonenumber, birthday);
		CPhoneInfo.showPhoneInfo();
	}
	
	public static void main(String[] args) {
		PhoneBook.showMenu();
	}

}