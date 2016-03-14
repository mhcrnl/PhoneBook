import java.util.Scanner;

public class PhoneBookManager {
	
	static Scanner scanner = new Scanner(System.in);
	
	private PhoneInfo[] arPhoneInfo;
	private int nCurIdx;
	
	public PhoneBookManager(){
		arPhoneInfo = new PhoneInfo[100];
		nCurIdx = 0;
	}
	
	public int findPhoneInfo(){
		int nIdx = -1;
		
		return nIdx;
	}
	
	public boolean addPhoneInfo(){
		
		if(nCurIdx >= 100)
			return false;
		
		arPhoneInfo[nCurIdx++] = ReadData();
		return true;
	}
	
	public boolean removePhoneInfo(){
		String name;
		
		if(nCurIdx <= 0)
			return false;
		
		// 1. input name for delete
		System.out.print("input name for delete");
		name = scanner.nextLine();
		
		// 2. find the name
		for(int i=0; i<nCurIdx; i++){
			
			// 2-1 . if found the name
			if(arPhoneInfo[i].toString() == name)
			{
				// delete
				for(int j=i; j<nCurIdx-1; j++){
					arPhoneInfo[j] = arPhoneInfo[j+1];
				}
				
				nCurIdx--;
				
				return true;
			}
		}
		
		return false;
	}
	
	public PhoneInfo ReadData(){
		
		PhoneInfo user;
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
