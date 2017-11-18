package com.designpatterns;

public class BuilderPattern {

	private final int id;
	private final String name;
	
	private BuilderPattern(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	private BuilderPattern(BuilderPatternBuilder builder){
		this.id = builder.id;
		this.name = builder.name;
	}
	
	public static class BuilderPatternBuilder{
		
		private int id;
		private String name;
		
		public BuilderPatternBuilder setId(int id) {
			this.id = id;
			return this;
		}
		public BuilderPatternBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public BuilderPattern build2(){
			return new BuilderPattern(this);
		}
		
		public BuilderPattern build(){
			return new BuilderPattern(this.id, this.name);
		}
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	
	@Override
	public String toString() {
		return "BuilderPattern [id=" + id + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		//BuilderPatternBuilder MUST be a static class in order to be accessible in this way
		//if it is not, it needs to have an instance of BuilderPattern to get an instance of its builder 
		//this defeats the purpose
		BuilderPattern b = new BuilderPatternBuilder().setId(1).setName("Sridhar").build();
		
		System.out.println(b.getId());
		System.out.println(b.getName());
		//b.id = 2; will not compile because id is final
	}
}
