import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		close:while(true) {
			System.out.println("당신의 성별을 입력하세요\n 1. 남성 / 2. 여성 / 3. 종료");
			System.out.print("입력 : ");
			
			int gender = scan.nextInt();
			
			switch(gender) {
			
			case 1:
				System.out.println("당신의 성별은 남성이군요.\n");
				break;
				
			case 2:
				System.out.println("당신의 성별은 여성이군요.\n");
				break;
			
			case 3:
				break close;
				
			default :
				System.out.println("1, 2 또는 3 중에서 입력해주세요.\n");
			}
		}
	}
}
