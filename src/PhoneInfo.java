public class PhoneInfo
{
  private String       name;
  private String       phoneNumber;
  private String       birthday;
  
  public PhoneInfo(String name, String phoneNumber){
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.birthday = null;
  }

  public PhoneInfo(String name, String phoneNumber, String birthday){
    this(name, phoneNumber);
    this.birthday = birthday;
  }
  
  public String toString(){
	  
	  return name;
  }

  public void showPhoneInfo(){
    System.out.println("name: "+ name);
    System.out.println("phoneNumber: "+ phoneNumber);
    
    if(birthday != null)
      System.out.println("birthday :"+ birthday);

    System.out.println("");
  }
}