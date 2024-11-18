package com.backend.testing;

public class A {

	public A a()
	{
		System.out.println("execute a");
		return new A();
	}
	
	public A b()
	{
		System.out.println("execute b");
		return new A();
	}
	
	public B c()
	{
		System.out.println("execute c");
		return new B();
	}
}
