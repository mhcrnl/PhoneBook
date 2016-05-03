
public class PhoneUnivInfo extends PhoneInfo{
	
	private String 		major; // ����
	private int 		year; // �г�
	
	public PhoneUnivInfo(String name, String phoneNumber, String major, int year){
		super(name, phoneNumber);
		
		this.major = major;
		this.year = year;
	}
	
	public void showPhoneInfo(){
		super.showPhoneInfo();
		
		System.out.print("major: ");
		System.out.println(major);
		
		System.out.print("year: ");
		System.out.println(year);
	}
	
	
}
