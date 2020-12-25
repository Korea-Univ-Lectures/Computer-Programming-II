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
		System.out.print("������ ���õ� ���ڸ� �Է��Ͽ� ����� ��������: ");
		
		while(true) {
			try {
				input=sc1.nextInt();
				
				if(input<0||input>range) 
					System.out.println("������ ���õ� ���ڸ� �Է��ϼ���!");
				
				else break;
			}
			catch(InputMismatchException e){
				System.out.println("������ ���õ� ���ڸ� �Է��ϼ���!");
				sc1.next();
			}
		}
		
		return input;
		}

	int getAccount(Scanner sc1) {
		int input=0;
		System.out.print("�ڿ����� �ݾ��� �Է����ּ���: ");
		
		while(true) {
			try {
				input=sc1.nextInt();
				
				if(input<0) 
					System.out.println("�ڿ����� �ݾ��� �Է��ϼ���!");
				else break;
			}
			catch(InputMismatchException e){
				System.out.println("�ڿ����� �ݾ��� �Է��ϼ���!");
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
			System.out.println("   <����ȭ��>   ");
			System.out.println("--------------");
			System.out.println("|1: ���Ա��      |");
			System.out.println("|2: ������      |");
			System.out.println("|3: �ݾ�Ȯ��      |");
			System.out.println("|0: ���α׷� ����|");
			System.out.println("--------------");
			input = i1.getInt(3,sc);
			
			if(input==1) {
				System.out.println("   <���Լ���>   ");
				System.out.println("--------------");
				System.out.println("|1: �뵷����      |");
				System.out.println("|2: �˹ټ���      |");
				System.out.println("|3: ���бݼ���   |");
				System.out.println("|4: ��Ÿ����      |");
				System.out.println("|0: �ڷΰ���      |");
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
				System.out.println("   <���⼱��>   ");
				System.out.println("--------------");
				System.out.println("|1: ��������      |");
				System.out.println("|2: �ĺ�����      |");
				System.out.println("|3: �к�����      |");
				System.out.println("|4: ��Ÿ����      |");
				System.out.println("|0: �ڷΰ���      |");
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
				
				System.out.println("�뵷\t�˹�\t���б�\t��Ÿ\t�Ѽ���");
				for(j=0;j<5;j++) banking[0][j].printBank();
				System.out.println("\n����\t�ĺ�\t�к�\t��Ÿ\t������");
				for(j=0;j<5;j++) banking[1][j].printBank();
				System.out.println("\n�� ���� �ڻ�: "+account);
			}
			else if(input==0) break;
		}
		sc.close();
	}
}