
public class PhoneCompanyInfo extends PhoneInfo{
	
	private String		company; // ȸ��
	
	
	
	public PhoneCompanyInfo(String name, String phoneNumber, String company){
		super(name, phoneNumber);
		
		this.company = company;
	}
	
	public void showPhoneInfo(){
		super.showPhoneInfo();
		
		System.out.print("company: ");
		System.out.println(company);
	
	}
}
