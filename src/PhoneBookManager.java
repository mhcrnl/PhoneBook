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
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 데이터 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("입력: ");
			
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
			if(name.compareTo(arPhoneInfo[i].getName()) == 0){
				nIdx = i;
				break;
			}
		}
		
		if(nIdx != -1){
			System.out.println("[ 검색된 데이터 ]");
			arPhoneInfo[nIdx].showPhoneInfo();
		}
		
		return nIdx;
	}
	
	private boolean addPhoneInfo(){
		int choose;
		
		if(nCurIdx >= 100)
			return false;
		
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택>>");
		choose = scanner.nextInt();
		scanner.nextLine(); //fflush
		
		arPhoneInfo[nCurIdx] = ReadData(choose);
		nCurIdx++;
		
		
		System.out.println("추가되었습니다.");
		
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
			if(arPhoneInfo[i].getName().compareTo(name) == 0)
			{
				// delete
				for(int j=i; j<nCurIdx-1; j++){
					arPhoneInfo[j] = arPhoneInfo[j+1];
				}
				
				nCurIdx--;
				System.out.println("삭제되었습니다.");
				
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
		
		System.out.println("총 데이타: " + nCurIdx);
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
		
		
		case 1: // normal
			pInfo = new PhoneInfo(name, phoneNumber);
			break;
			
		case 2: // Univ
			System.out.print("major: ");
			major = scanner.nextLine();
			
			System.out.print("year: ");
			year = scanner.nextInt();
			scanner.nextLine(); //fflush
			
			pInfo = new PhoneUnivInfo(name, phoneNumber, major, year);
			
			break;
			
		case 3: // Company
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
