package com.company;

public class Main {

    public static void ReverseNumber(int num){
        int RNum=0;
        int count=0;

        do{
            int rem=num%10;
            RNum=(RNum*10)+rem;
            num/=10;
            count++;
         }while (num>0);

        System.out.println(RNum);
    }

    public static void main(String[] args) {
	// write your code here
        ReverseNumber(123456);
    }
}
