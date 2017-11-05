package com.exceptions;

public class ExceptionMadness {

	
	public static void main(String[] args) {
		ExceptionMadness em = new ExceptionMadness();
		
		try{
			em.checkedProblem();
		}catch(CheckedException e){
			e.printStackTrace();
		}finally{
			System.out.println("finally 1");
		}
		
		
		
		try(Library l1 = new Library()){
			throw new UncheckedException("try library exception");
		}finally{
			System.out.println("finally library");
			//this exception swallows the unchecked exception thrown in the try block so it does not display
			//this is also stopping a compilation error for not catching the checked exception thrown by the close method of Library
			throw new UncheckedException("finally library exception"); 
		}
	}
	
	public void checkedProblem() throws CheckedException{
		throw new CheckedException();
	};
	
}

class CheckedException extends Exception{}

class UncheckedException extends RuntimeException{
	
	public UncheckedException(){
		super();
	}

	public UncheckedException(String string) {
		super(string);
	}}

class Library implements AutoCloseable{
	public void close() throws CheckedException{
		System.out.println("Library is closed");
		throw new CheckedException();
	}
}
