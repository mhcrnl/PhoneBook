import java.util.Scanner;

public class PhoneBookManager {
	final private int MAX_CNT = 100;
	
	static Scanner scanner = new Scanner(System.in);
	
	private PhoneInfo[] arPhoneInfo;
	private int nCurIdx;
	
	public PhoneBookManager(){
		arPhoneInfo = new PhoneInfo[MAX_CNT];
		nCurIdx = 0;
	}
	
	public void showMenu(){
		int nSelect;
		
		do{
			System.out.println("�����ϼ���...");
			System.out.println("1. ������ �Է�");
			System.out.println("2. ������ �˻�");
			System.out.println("3. ������ ����");
			System.out.println("4. ������ ���");
			System.out.println("5. ���α׷� ����");
			System.out.print("�Է�: ");
			
			nSelect = scanner.nextInt();
			scanner.nextLine(); // fflush
			
			
			switch(nSelect){
			
			//Add Phone Info
			case 1:
				addPhoneInfo();
				break;
				
				
			//Find Phone Info	
			case 2: 
				findPhoneInfo();
				break;
				
				
			//Remove Phone Info	
			case 3: 
				removePhoneInfo();
				break;
				
				
			//Show All Phone Info	
			case 4:	
				showAllPhoneInfo();
				break;
			
			
			// Halt the Program
			case 5:	
				break;
				
			default:
				break;
			}
		}while(nSelect != 5);
	}
	
	private int findPhoneInfo(){
		String name;
		
		int nIdx = -1;
		
		System.out.print("Name for find: ");
		name = scanner.nextLine();
		
		// find the name
		for(int i=0; i<nCurIdx; i++){
			if(name.compareTo(arPhoneInfo[i].toString()) == 0){
				nIdx = i;
				break;
			}
		}
		
		if(nIdx != -1){
			System.out.println("[ �˻��� ������ ]");
			arPhoneInfo[nIdx].showPhoneInfo();
		}
		
		return nIdx;
	}
	
	private boolean addPhoneInfo(){
		
		if(nCurIdx >= 100)
			return false;
		
		arPhoneInfo[nCurIdx] = ReadData();
		
		nCurIdx++;
		System.out.println("�߰��Ǿ����ϴ�.");
		
		return true;
	}
	
	private boolean removePhoneInfo(){
		String name;
		
		if(nCurIdx <= 0)
			return false;
		
		// 1. input name for delete
		System.out.print("input Name for delete: ");
		name = scanner.nextLine();
		
		// 2. find the name
		for(int i=0; i<nCurIdx; i++){
			
			// 2-1 . if found the name
			if(arPhoneInfo[i].toString().compareTo(name) == 0)
			{
				// delete
				for(int j=i; j<nCurIdx-1; j++){
					arPhoneInfo[j] = arPhoneInfo[j+1];
				}
				
				nCurIdx--;
				System.out.println("�����Ǿ����ϴ�.");
				
				return true;
			}
		}
		
		return false;
	}
	
	public void showAllPhoneInfo(){
		
		for(int i=0; i<nCurIdx; i++){
			
			arPhoneInfo[i].showPhoneInfo();
			System.out.println("");
		}
		
		System.out.println("�� ����Ÿ: " + nCurIdx);
	}
	
	private PhoneInfo ReadData(){
		
		String name;
		String phoneNumber;
		String birthday;
		
		
		System.out.print("Name: ");
		name = scanner.nextLine();
		
		System.out.print("phoneNumber: ");
		phoneNumber = scanner.nextLine();
		
		System.out.print("birthday: ");
		birthday = scanner.nextLine();
		
		return new PhoneInfo(name, phoneNumber, birthday);
	}
	
}
