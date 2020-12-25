package money;

import java.util.Scanner;
import java.util.InputMismatchException;

class bank{
	int total=0;

	void addBank(int account) {
		this.total+=account;
	}
	
	void printBank() {
		System.out.print(total+"\t");
	}
	
}

class inputs{
	int getInt(int range, Scanner sc1) {
		int input=0;
		System.out.print("위에서 제시된 숫자를 입력하여 명령을 내리세요: ");
		
		while(true) {
			try {
				input=sc1.nextInt();
				
				if(input<0||input>range) 
					System.out.println("위에서 제시된 숫자를 입력하세요!");
				
				else break;
			}
			catch(InputMismatchException e){
				System.out.println("위에서 제시된 숫자를 입력하세요!");
				sc1.next();
			}
		}
		
		return input;
		}

	int getAccount(Scanner sc1) {
		int input=0;
		System.out.print("자연수인 금액을 입력해주세요: ");
		
		while(true) {
			try {
				input=sc1.nextInt();
				
				if(input<0) 
					System.out.println("자연수인 금액을 입력하세요!");
				else break;
			}
			catch(InputMismatchException e){
				System.out.println("자연수인 금액을 입력하세요!");
				sc1.next();
			}
		}
		return input;
	}
}
public class money {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int input;
		int inSelec;
		int outSelec;
		int defSelec;
		int i,j;
		
		inputs i1 = new inputs();
		
		bank banking[][]= new bank[2][5];
		for(i=0;i<2;i++) {
			for(j=0;j<5;j++) {
				banking[i][j]=new bank();
			}
		}
		
		while(true) {
			System.out.println("   <메인화면>   ");
			System.out.println("--------------");
			System.out.println("|1: 수입기록      |");
			System.out.println("|2: 지출기록      |");
			System.out.println("|3: 금액확인      |");
			System.out.println("|0: 프로그램 종료|");
			System.out.println("--------------");
			input = i1.getInt(3,sc);
			
			if(input==1) {
				System.out.println("   <수입선택>   ");
				System.out.println("--------------");
				System.out.println("|1: 용돈수입      |");
				System.out.println("|2: 알바수입      |");
				System.out.println("|3: 장학금수입   |");
				System.out.println("|4: 기타수입      |");
				System.out.println("|0: 뒤로가기      |");
				System.out.println("--------------");
				
				inSelec = i1.getInt(4,sc);
				if(inSelec==1)
					banking[0][0].addBank(i1.getAccount(sc));
				else if(inSelec==2) 
					banking[0][1].addBank(i1.getAccount(sc));
				else if(inSelec==3) 
					banking[0][2].addBank(i1.getAccount(sc));
				else if(inSelec==4) 
					banking[0][3].addBank(i1.getAccount(sc));
			}
			else if(input==2) {
				System.out.println("   <지출선택>   ");
				System.out.println("--------------");
				System.out.println("|1: 교통지출      |");
				System.out.println("|2: 식비지출      |");
				System.out.println("|3: 학비지출      |");
				System.out.println("|4: 기타지출      |");
				System.out.println("|0: 뒤로가기      |");
				System.out.println("--------------");
				
				outSelec = i1.getInt(4,sc);
				if(outSelec==1)
					banking[1][0].addBank(i1.getAccount(sc));
				else if(outSelec==2) 
					banking[1][1].addBank(i1.getAccount(sc));
				else if(outSelec==3) 
					banking[1][2].addBank(i1.getAccount(sc));
				else if(outSelec==4) 
					banking[1][3].addBank(i1.getAccount(sc));
			}
			else if(input==3) {
				int account=0;
				
				banking[0][4].total=banking[0][0].total;
				banking[1][4].total=banking[1][0].total;
				
				for(i=0;i<2;i++) {
					for(j=1;j<4;j++) {
						banking[i][4].total+=banking[i][j].total;
					}
				}
				account+=banking[0][4].total;
				account-=banking[1][4].total;
				
				System.out.println("용돈\t알바\t장학금\t기타\t총수입");
				for(j=0;j<5;j++) banking[0][j].printBank();
				System.out.println("\n교통\t식비\t학비\t기타\t총지출");
				for(j=0;j<5;j++) banking[1][j].printBank();
				System.out.println("\n총 보유 자산: "+account);
			}
			else if(input==0) break;
		}
		sc.close();
	}
}