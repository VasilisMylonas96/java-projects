
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
class User
{
	private String name;
	private String age;
	private String location;
	private ArrayList<User> friend =new ArrayList<User>();
	public User(String name,String age,String location)
	{
		this.name=name;
		this.age=age;
		this.location=location;
	}
	public String toString()
	{
		return"name: "+name+"\n"+"age: "+age+"\n"+"location: "+location;
	}
	public void Friend(User other)
	{
		this.friend.add(other);
		other.friend.add(this);
	}
	public ArrayList<User> getArrayList()
	{
		return friend ;
	}
	public String getName()
	{
		return name;
	}
	public String getAge()
	{
		return age;
	}
	public String getLocation()
	{
		return location;
	}
}
class Node
{
	private String name1="";
	private String name2="";
	private String name3="";
	private User user;
	private Node node;
	public Node(String name,String age,String location)
	{
		user=new User(name,age,location);
		node=new Node(name1,name2,name3);
		name1=name;
		name2=age;
		name3=location;
	}
	public User getUser()
	{
		return user;
	}
	public Node getNode()
	{
		return node;
	}
}
class SocialNetwork
{
	private HashMap<String,User> myMap;
	private String string1;
	private String string2;
	private String string3;
	private String string4;
	private String string5;
	public SocialNetwork()
	{
		HashMap<String,User> myMap= new HashMap<String,User>();
	}
	public void readUsers(String name)
	{
		Scanner inputReader = null;
		try
		{
		inputReader =new Scanner(new FileInputStream("name.txt"));
		}
		catch(FileNotFoundException e)
		{
		System.out.println("File name.txt was not found");
		System.out.println("or could not be opened.");
		}
		
		while (inputReader.hasNext())
		{
			string1=inputReader.next( );
			string2=inputReader.next( );
			string3=inputReader.next( );
			Node node =new Node (string1,string2,string3);
			myMap.put(string1,node.getUser());
		}
		
	}
	public void readNetwork(String name1)
	{
		Scanner inputReader = null;
		try
		{
		inputReader =new Scanner(new FileInputStream("name1.txt"));
		}
		catch(FileNotFoundException e)
		{
		System.out.println("File name1.txt was not found");
		System.out.println("or could not be opened.");
		}
		while (inputReader.hasNext())
		{
			string4=inputReader.next( );
			string5=inputReader.next( );
			myMap.get(string4).Friend(myMap.get(string5));
		}
	}
	private String pathToString(Node node)
	{

		String s1 ="";
		for (int i=0;i<myMap.size();i++)
		{
			s1=s1+node.getUser().toString();
		}
		return s1;
	}
	public void computeShortestPath(String name,String name1)
	{
		int n1;
		int n=0;
		int i=0;
		int max=0;
		int max1=0;
		List<Node> names = new ArrayList<Node>();
		User pinakas[]=new User[myMap.size()-1];
		HashSet<Integer> mySet= new HashSet<Integer>();
		ArrayList<User> friend=new ArrayList<User>();
		friend=myMap.get(name).getArrayList();
		for(User x: friend)
		{
			if (x==myMap.get(name1))
			{
				n=1;
			}
		}
		if (n!=1||name.equals(name1))
		{
			System.out.print("den uparxei monomati");
			System.exit(0);
		}
		
		for (String string: myMap.keySet() )
		{
			pinakas[i]=myMap.get(string);
			i++;
		}
		for (int k=1;k<myMap.size();k++)
		{
			for(int j=0;j<myMap.size();j=j+k)
			{
				if (pinakas[j]==myMap.get(name1))
				{
					n1=j;
					max++;
					break ;
				}
				max++;
				
			}
			if (max>max1)
			{
				max1=max;
			}
			max=0;
			if (pinakas[n]==myMap.get(name1))
			{
				break ;
			}
		}
		mySet.add(max1);
		for (int k1=1;k1<myMap.size();k1=k1+myMap.size()/max1)
		{
			Node node=new Node(pinakas[k1].getName(),pinakas[k1].getAge(),pinakas[k1].getLocation());
			names.add(node);
		}
		for (int k1=1;k1<myMap.size();k1=k1+myMap.size()/max1)
		{
			Node node=new Node(pinakas[k1].getName(),pinakas[k1].getAge(),pinakas[k1].getLocation());
			names.remove(node);
			System.out.print(pathToString(node));
		}

}
public class ShortestPaths
{
	public void main(String[] args,String name,String name1)
	{
		String s1;
		String s2;
		String s3="nai";
		SocialNetwork SNW=new SocialNetwork();
		SNW.readUsers(name);
		SNW.readNetwork(name1);
		Scanner input=new Scanner(System.in);
		while (s3.equals("nai")||s3.equalsIgnoreCase("NAI"))
		{
			System.out.println("dwse mou dio onomata");
			s1=input.next();
			s2=input.next();
			SNW.computeShortestPath(s1,s2);
     		System.out.println("thes na sinexiseis ?");
     		s3=input.next();
		}
	}
}
}
