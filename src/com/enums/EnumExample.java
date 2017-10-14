package com.enums;

public enum EnumExample {
	
	WINTER{
		public void play(){
			System.out.println("sledding!");
		}
		public void stupid(){
			System.out.println("winter is stupid");
		}
	}, SPRING{
		public void play(){
			System.out.println("gardening!");
		}
		public void stupid(){
			System.out.println("spring is stupid");
		}
	}, SUMMER{
		public void play(){
			System.out.println("pool time!");
		}
		
		public void stupid(){
			System.out.println("summer is stupid");
		}
	}, FALL{
		public void play(){
			System.out.println("eat pumpkin donuts!");
		}
		
		protected void stupid(){
			System.out.println("fall is stupid");
		}
	};
	
	public static final int CONSTANT = 4;
	
	public abstract void play();
	
	protected abstract void stupid();
	
	public void print(){
		System.out.println(CONSTANT);
	}
	
}
