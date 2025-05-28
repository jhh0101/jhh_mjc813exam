package com.mjc.studyjava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankApplication bankApplication = new BankApplication();
        Scanner sc = new Scanner(System.in);

        
        while (true){
            System.out.println("---------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("---------------------------------------------");
            System.out.print("선택 > ");
            String num = sc.nextLine();
            if("1".equals(num)){
                System.out.println("--------------");
                System.out.println("계좌생성");
                System.out.println("--------------");
                System.out.print("계좌번호 : ");
                String accountNumber = sc.nextLine();
                System.out.print("계좌주 : ");
                String accountName = sc.nextLine();
                System.out.print("초기입금액 : ");
                int money = sc.nextInt();
                sc.nextLine();
                bankApplication.addAccount(accountNumber, accountName, money);
                System.out.println("결과 : 계좌가 생성되었습니다.");
            }
            else if("2".equals(num)){
                System.out.println("--------------");
                System.out.println("계좌목록");
                System.out.println("--------------");
                bankApplication.printAccounts();
            }
            else if("3".equals(num)){
                System.out.println("--------------");
                System.out.println("예금");
                System.out.println("--------------");
                System.out.print("계좌번호 : ");
                String accountNumber = sc.nextLine();
                System.out.print("예금액 : ");
                int money = sc.nextInt();
                sc.nextLine();
                bankApplication.deposit(accountNumber, money);
                System.out.println("결과 : 입금이 성공되었습니다.");
            }
            else if("4".equals(num)){
                System.out.println("--------------");
                System.out.println("출금");
                System.out.println("--------------");
                System.out.print("계좌번호 : ");
                String accountNumber = sc.nextLine();
                System.out.print("출금액 : ");
                int money = sc.nextInt();
                sc.nextLine();
                bankApplication.draw(accountNumber, money);
                System.out.println("결과 : 출금이 성공되었습니다.");
            }
            else if("5".equals(num)){
                System.out.println("프로그램 종료.");
                break;
            }
        }
    }
}
