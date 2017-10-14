package com.classtypes;

public class StaticClassesExample {
	
	private int notAccessibleInStaticContext = 5;
	
	private static int accessibleInStaticContext = 6;

	public static class StaticNested{
		private int one = 1;
		
		private static int staticOne = 1;
		
		public int tryToAccessOuterClassVars(){
			StaticClassesExample e = new StaticClassesExample();
			
			//return notAccessibleInStaticContext; --Does Not Compile
			//return e.notAccessibleInStaticContext; --Legal because it has an object instance
			return accessibleInStaticContext;
		}
		
		public int getOne(){
			return this.one;
		}
	}
	
	
	public int getStaticNestedStuff(){
		StaticNested s = new StaticNested();
		int i = StaticNested.staticOne;
		i = s.one;
		return i;
	}
	
	
	
}
