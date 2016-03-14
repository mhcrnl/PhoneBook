public class PhoneInfo
{
  private String       name;
  private String       phoneNumber;
  
  public PhoneInfo(String name, String phoneNumber){
    this.name = name;
    this.phoneNumber = phoneNumber;
  }
  
  public String toString(){
	  String info = "";
	  info += name;
	  info += ", ";
	  info += phoneNumber;
	  info += "\n";
	  
	  return info;
  }
  
  public String getName(){
	  return name;
  }
  public String getNumber(){
	  return phoneNumber;
  }

  public void showPhoneInfo(){
    System.out.println("name: "+ name);
    System.out.println("phoneNumber: "+ phoneNumber);  
  }
}