package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Prime {
	
	Scanner input;
	
	long minimum;
	long maximum;
	int mode;
	
	ArrayList<Long> primes;
	
	boolean running = false;
	
	public Prime() {
		System.out.println(" __________________________________");
		System.out.println("|    P R I M E  N U M B E R S      |");
		System.out.println("|                                  |");
		System.out.println("|   range | random | pos | check   |");
		System.out.println("|     0   |    1   |  2  |   3     |");
		System.out.println("\\__________________________________/");
		input 	= new Scanner(System.in);
		primes 	= new ArrayList<Long>();
		
		try {
			mode 	= input.nextInt();
		} catch(Exception e) {
			System.out.println("Please input a positive integer.");
			return;
		};
		
		switch(mode) {
		case 0: range(); 		 break;
		case 1: randomNumber();  break;
		case 2: pos(); 			 break;
		case 3: check();		 break;
		
		default: System.out.println("Please input one of the numbers shown on the screen.");
		}
		
		running = true;
	}
	
	private void range() {
		minimum = input.nextLong();
		maximum = input.nextLong();
		
		loop(minimum, maximum);
		for(long i : primes)
			System.out.println(i);
	}
	
	private void randomNumber() {
		long number = (long) Math.floor(Math.random() * 1000000000);
		if(isPrime(number)) {
			System.out.println(number);
			return;
		}
		else {
			randomNumber();
			return;
		}
	}
	
	private void pos() {
		long index = input.nextLong();
		pos(0, 10000, index);
	}
	
	private void pos(long min, long max, long index) {
		loop(min, max);
		if(primes.size() >= index) {
			System.out.println(primes.get((int) index));
			return;
		}
		else {
			pos(min + 10000, max + 10000, index);
			return;
		}
	}
	
	private void check() {
		long num = input.nextLong();
		if(isPrime(num))
			System.out.println(num + " is a prime");
		else {
			System.out.println(num + " is not a prime");
		}
	}
	
	private void loop(long min, long max) {
		if(max <= min)
			return;
		
		for(long i = min; i <= max; i++) {
			if(isPrime(i))
				primes.add(i);
		}
	}
	
	private boolean isPrime(long num) {
		long half = Math.floorDiv(num, 2);
		
		for(int i = 2; i <= half; i++) {
			if(num % i == 0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		new Prime();
	}
}
