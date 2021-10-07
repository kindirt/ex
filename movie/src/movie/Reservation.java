package movie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.Scanner;

public class Reservation {

	
	public void ticket(int seats[][]) {
		File file = new File("src/reservation.txt");
		try(ObjectOutputStream oout =
				new ObjectOutputStream(new FileOutputStream(file))){
				
		Scanner scan = new Scanner(System.in);
		System.out.println("===스크린===");
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0; j < 10 ; j++) {
			    if(seats[i][j]==0) {
			    	System.out.print("□");
			    }else {
			    	System.out.print("■");
			    }
			}
			System.out.println();
		}
		System.out.println("이름을 입력하세요");
		String name = scan.next();
		while(true) {
			System.out.println("앞에서 몇 번째 좌석을 고르시겠습니까?");
			int first = scan.nextInt();
			System.out.println("왼쪽에서 몇 번째 좌석을 고르시겠습니까?");
			int second = scan.nextInt();
			if(second>10) {
				System.out.println("다시 입력해주세요");
			}
			if(seats[first][second] != 0) {
				System.out.println("이미 예약된 좌석입니다.");
			}
			Member member = new Member(name, first, second);
			oout.writeObject(member);
			break;
		}
		System.out.println("성공적으로 예매 되었습니다");
		 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void ticketList() {
		File file = new File("src/reservation.txt");
		try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file))){
			Member member = (Member)oin.readObject();
			System.out.println(member.getName()+"의 좌석은"+member.getFirst()+"행"+member.getSecond()+"줄 입니다.");
			System.out.println("감사합니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void ticketCancel() {
		Scanner scan = new Scanner(System.in);
		System.out.println("예약 취소");
		System.out.println("이름을 입력해주세요.");
		String name = scan.next();
		if(name.equals(name)) {
			
		}
	}
}
