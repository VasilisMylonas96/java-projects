import java.util.*;
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

class Queue 
{
	private int i=0;//arithmo pou xrisimo stin remove
	private int akereos;
	private Person person;
	private Person person1;
	private Person person2;
	private Person person3;
	private Person person4;
	private Person head;
	private Person tail;
	private int size;
	private Stack<Person> stack=new Stack<Person>();
	private Stack<Person> stack1=new Stack<Person>();
	public Queue()
	{
		
		this.size=0;
	}
	public Queue(Queue other)
	{
		Stack<Person> stack4=new Stack<Person>();
		this.size=other.size;
		this.head=other.head;
		this.tail=other.tail;
		for (int i=0; i<this.size; i++)//foliasmenos constractor gia person
		{
			person2=other.stack.pop();
			this.person=new Person(person2);
			stack4.push(person2);
		}
		for (int i=0; i<this.size; i++)
		{
			person2=stack4.pop();
			this.stack.push(person2);
			other.stack.push(person2);
		}
		
	}
	public void insert(Person person1)
	{
		this.akereos=person1.getAm();
		stack.push(person1);
		
		if (size==0)
		{
			head=person1;
			tail=person1;
		}
		else 
		{
			tail=person1;
		}
		size++;
	}
	public Person  remove ()
	{
		if (size == 0){
			System.out.print("h oura einai adia \n");
			System.exit(-1);
		}
		for (int i =0; i<size;i++)
		{
			stack1.push(stack.pop());
		}
		size--;
		person=stack1.pop();
		this.akereos=person.getAm();//krataw kai ton akereo pou elege h askisi oti krataei akereous 
		for (int i=0; i<size;i++)
		{
			if (i==0)
			{
				person=stack1.pop();
				stack.push(person);
				head=person;//krataw alazw thesi to head etsi opos prepei dld pernei tin thesi tou epomenou stoixeio stin korifi to tail den alazei edw 
			}
			else
			{
				stack.push(stack1.pop());
		
			}
		}
		return person;
	}
	
	public String toString()// paromios tropos me tin foliasmeni tostring pou mathame 
	{		
		String alfarithmitiko="";
		for (int i =0; i<size;i++)
		{
			stack1.push(stack.pop());
		}
		for (int i =0; i<size;i++)
		{
			person1=stack1.pop();
			alfarithmitiko=alfarithmitiko+person1;
			stack.push(person1);
		}
		if (size==0)
		{
			alfarithmitiko="den uparxei kanena antikeimenos tin oura ";
		}
		return alfarithmitiko;
	}	
	public boolean equals(Queue other)
	{
		return this.stack.equals(other.stack)&&this.size==other.size;
	}
	public void merge(Queue other)
	{
		Stack<Person> stack5=new Stack<Person>();
		Stack<Person> stack6=new Stack<Person>();
		for (int i=0; i<other.size; i++)
		{
			person3=other.stack.pop();
			stack5.push(person3);
			stack6.push(person3);
		}
		for (int i=0; i<other.size; i++)
		{
			this.stack.push(stack5.pop());
			other.stack.push(stack6.pop());
		}
	}
	public boolean isEmpty()
	{
		return this.size!=0;
	}
	public int getSize()
	{
		return size;
	}
	
}