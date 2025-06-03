package com.mjc813.calender;

import java.util.Calendar;

public class CalenderEx {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.print(cal.get(Calendar.YEAR)+".");
        System.out.print(cal.get(Calendar.MONTH)+1+".");
        System.out.print(cal.get(Calendar.DAY_OF_MONTH)+".");
        int week = cal.get(Calendar.DAY_OF_WEEK);
        switch (week){
            case 1:
                System.out.println("일");
                break;
            case 2:
                System.out.println("월");
                break;
            case 3:
                System.out.println("화");
                break;
            case 4:
                System.out.println("수");
                break;
            case 5:
                System.out.println("목");
                break;
            case 6:
                System.out.println("금");
                break;
            default:
                System.out.println("토"); // 일,월,화 순서 1부터 시작
                break;
        }
        int am_pm = cal.get(Calendar.AM_PM);
        if(am_pm == 0){
            System.out.print("오전 ");
        } else if (am_pm == 1) {
            System.out.print("오후 ");
        }
        System.out.print(cal.get(Calendar.HOUR)+":");
        System.out.print(cal.get(Calendar.MINUTE)+":");
        System.out.print(cal.get(Calendar.SECOND));
    }
}
