package com.dao;

public class Test {
	int a;

	public static void main(String[] args) {
		Test s=new Test();
		s.a();
		s.b();
		s.c();
		System.out.println(s.a);
	}
	void a(){
		a++;
	}
	void b(){
		a++;
	}
	void c(){
		a++;
	}
}
