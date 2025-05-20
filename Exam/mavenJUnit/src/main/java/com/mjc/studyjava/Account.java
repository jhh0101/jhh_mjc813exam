package com.mjc.studyjava;

public class Account {
//    Account : 속성{ 계좌번호(accountNumber), 계좌주(accountName), 금액(money) }
//    동작{ 생성자(계좌번호,계좌주), addMoney(금액), subMoney(금액) }
    private String accoutNumber;
    private String accountName;
    private int balance;

    /**
     * Account 비기본 생성자 (계좌번호, 계좌주)
     * @param accountNumber
     * @param accountName
     */
    public Account(String accountNumber, String accountName) {
        this(accountNumber, accountName, 0);
    }

    /**
     * Account 비기본 생성자 (계좌번호, 계좌주, 초기금액)
     * @param accountNumber
     * @param accountName
     * @param balance
     */
    public Account(String accountNumber, String accountName, int balance) {
        this.accoutNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    /**
     * m 을 금액에 더한다.
     * @param m
     */
    void addMoney(int m) {
       this.balance = this.balance + m;
    }
    /**
     * m 을 금액에서 뺀다.
     * @param m
     */
    void subMoney(int m) {
        this.balance = this.balance - m;
    }

    /**
     * 계좌번호 정보를 가져온다.
     * @return
     */
    public String getAccountNumber() {
        return this.accoutNumber;
    }
    /**
     * 계좌번호 정보를 저장한다.
     * @param accountNumber
     */
    public void setAccoutNumber(String accountNumber) {
        this.accoutNumber = accoutNumber;
    }

    /**
     * 계좌주 정보를 가져온다.
     * @return
     */
    public String getAccountName() {
        return this.accountName;
    }
    /**
     * 계좌주 정보를 저장한다.
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 금액 정보를 가져온다.
     * @return
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * 금액 정보를 저장한다.
     * @param balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
