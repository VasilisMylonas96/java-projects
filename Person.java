
class Person
{
	private String name;
	private int AM;
	private Person per=null;
	
	public Person(String name, int AM){
		this.name = name;
		this.AM = AM;
	}			
	public Person (Person other)
	{
		this.name= other.name;
		this.AM=other.AM;
		
	}
	public String getName()
	{
		return this.name;
	}
	public int getAm()
	{
		return this.AM;
	}
	public Person getper()
	{
		return per;
	}
	
	public String toString()
	{
		return("( name "+this.name+", AM "+this.AM+" )");
	}

}