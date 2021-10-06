package movie;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] seats = new int[3][10];
		
		Menu menu = new Menu();
		Reservation rsv = new Reservation();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("=====환영합니다=====");
		System.out.println("1.회원가입 2.로그인");
		int num = scan.nextInt();
		if (num == 1) {
			menu.insertMember();
			menu.loginMember();
		}else {
			menu.loginMember();			
		}
		
		while(true) {
			System.out.println("===============");
		    System.out.println("1.예매 2.예매 내역 출력 3.예매 취소 4.나가기");
		    int number = scan.nextInt();
		    switch (number) {
			case 1: {
				rsv.ticket(seats);	
				break;
			}
			case 2: {
				rsv.ticketList();
				break;
			}
			case 3: {
				
			}
			case 4: {
				System.out.println("=====감사합니다=====");
				System.exit(0);
			}
			default:
				System.out.println("====잘못입력하셨습니다===");
				break;
			}			
		}
	}
}
