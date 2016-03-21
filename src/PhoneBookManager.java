import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {
	private static Scanner scanner = new Scanner(System.in);

	private static PhoneBookManager manager;

	private HashSet<PhoneInfo> hsPhoneInfo; 

	private PhoneBookManager(){
		hsPhoneInfo = new HashSet<PhoneInfo>();
	}

	public static PhoneBookManager getInstanace(){
		if(manager == null)
			manager = new PhoneBookManager();

		return manager;
	}

	public void showMenu(){
		int nSelect = 0;

		do{
			try{
				System.out.println("�����ϼ���...");
				System.out.println("1. ������ �Է�");
				System.out.println("2. ������ �˻�");
				System.out.println("3. ������ ����");
				System.out.println("4. ������ ���");
				System.out.println("5. ���α׷� ����");
				System.out.print("�Է�: ");


				nSelect = scanner.nextInt();
				scanner.nextLine(); // fflush


				if(( nSelect < 1) || (nSelect > 5))
					throw new MenuChoiceException();
				switch(nSelect){

				//Add Phone Info
				case MENU_SELECT.INPUT:
					addPhoneInfo();
					break;


					//Find Phone Info	
				case MENU_SELECT.SEARCH: 
					findPhoneInfo();
					break;


					//Remove Phone Info	
				case MENU_SELECT.DELETE: 
					removePhoneInfo();
					break;


					//Show All Phone Info	
				case MENU_SELECT.SHOW:	
					showAllPhoneInfo();
					break;


					// Halt the Program
				case MENU_SELECT.HALT:	
					break;

				default:
					break;
				}
			}
			catch(MenuChoiceException e){
				System.out.println(e.getMessage());
				continue;
			}


		}while(nSelect != 5);
	}

	private PhoneInfo findPhoneInfo(){
		PhoneInfo toFind = null;
		String name;

		System.out.print("Name for find: ");
		name = scanner.nextLine();
		System.out.println("");

		// find the name
		Iterator<PhoneInfo> itr = hsPhoneInfo.iterator();
		while(itr.hasNext()){
			toFind = itr.next();
			if(toFind.getName().compareTo(name) == 0)
				break;
			else
				toFind = null;
		}

		if(toFind != null)
		{
			toFind.showPhoneInfo();
			System.out.println("");
		}
		else
		{
			System.out.println("[ã���� �ϴ� �����Ͱ� �����ϴ�.");
		}
		
		return toFind;
	}

	private boolean addPhoneInfo() throws MenuChoiceException{
		int choose;
		PhoneInfo toAdd = null;

		System.out.println("1. �Ϲ�, 2. ����, 3. ȸ��");
		System.out.print("����>>");
		choose = scanner.nextInt();
		
		scanner.nextLine(); //fflush
		System.out.println("");
		
		if((choose < 0) || (choose > 3))
			throw new MenuChoiceException();

		toAdd = ReadData(choose);
		
		if(hsPhoneInfo.add( toAdd ))
			System.out.println("[�߰��Ǿ����ϴ�.]");
		else
			System.out.println("[�ߺ��� �������Դϴ�.]");
		System.out.println("");
		
		return true;
	}

	private boolean removePhoneInfo(){
		PhoneInfo toDelete;

		toDelete = findPhoneInfo();
	
		if(toDelete != null)
		{
			hsPhoneInfo.remove(toDelete);
			System.out.println("[�����Ǿ����ϴ�] \n");
			return true;
		}
		
		return false;
	}

	public void showAllPhoneInfo(){

		PhoneInfo pInfo;
		Iterator<PhoneInfo> itr = hsPhoneInfo.iterator();
		
		while(itr.hasNext())
		{
			pInfo = itr.next();
			pInfo.showPhoneInfo();
		}
		System.out.println("[�� ����Ÿ: " + hsPhoneInfo.size() + "]"); //fix
		System.out.println("");
	}

	private PhoneInfo ReadData(int nInput_select){

		PhoneInfo pInfo = null;

		String		name;
		String		phoneNumber;
		String		major;
		String		company;
		int			year;

		System.out.print("Name: ");
		name = scanner.nextLine();

		System.out.print("phoneNumber: ");
		phoneNumber = scanner.nextLine();

		switch(nInput_select){

		case READ_SELECT.NORMAL: // normal
			pInfo = new PhoneInfo(name, phoneNumber);
			break;

		case READ_SELECT.UNIV: // Univ
			System.out.print("major: ");
			major = scanner.nextLine();

			System.out.print("year: ");
			year = scanner.nextInt();
			scanner.nextLine(); //fflush

			pInfo = new PhoneUnivInfo(name, phoneNumber, major, year);

			break;

		case READ_SELECT.COMP: // Company
			System.out.print("company: ");
			company = scanner.nextLine();

			pInfo = new PhoneCompanyInfo(name, phoneNumber, company);

			break;

		default:
			break;
		}

		return pInfo;
	}

}
