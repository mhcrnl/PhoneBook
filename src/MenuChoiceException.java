
public class MenuChoiceException extends Exception{

	public MenuChoiceException(){
		super("잘못된 메뉴 선택");
		
		System.out.println("잘못된 메뉴의 선택입니다");
	}
}
