package movie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Menu {
	
	public void insertMember() {
		File file = new File("src/member.txt");
		Scanner scan = new Scanner(System.in);
		try {
			FileWriter fileWriter = new FileWriter(file,true);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			if(file.isFile() && file.canWrite()) {
				System.out.println("회원가입을 위해 ID 와 비밀번호를 입력하세요.");
			    System.out.println("ID 입력 : ");
			    Writer id = fileWriter.append(scan.nextLine());   
			    fileWriter.append("\t");
			    System.out.println("비밀번호 입력 : ");
			    Writer pw = fileWriter.append(scan.nextLine());
			    fileWriter.append("\r");
			    System.out.println("회원가입이 완료되었습니다.");
			    if (id.equals(br.readLine()) && pw.equals(br.readLine()) ) {
					System.out.println("회원이 가입되어있습니다.");
				}
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loginMember() {
		int pass= 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("=====로그인=====");
		System.out.println("로그인을 위해 id와 비밀번호를 입력하세요");
		System.out.println("id 입력 :");
		String id = scan.nextLine();
		System.out.println("비밀번호 입력 :");
		String pw = scan.nextLine();
		File file = new File("src/member.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			try {
				while((line = br.readLine()) != null) {
				//	System.out.println(line.indexOf(id)+ "\t" + line.indexOf(pw));
					int passId = line.indexOf(id);
					int passPw = line.indexOf(pw);
					if(passId != -1 && passPw != -1) {
						System.out.println("로그인 성공");
						pass = -1;
					}
				}
				if(pass ==0) {
					System.out.println("로그인 실패");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
