
import java.util.ArrayList;
import java.util.Scanner;
class User
{
	private int s1;
	private String s;
	private String name;
	private Wall wall1;
	private ArrayList<User> userArray;
	public User(String name)
	{
		wall1=new Wall(this);
		this.name=name;
		userArray= new ArrayList<User>();
		userArray.add(this);
	}
	public void befriend(User other)
	{
		other.userArray.add(this);
		this.userArray.add(other);
	}
	public void post(String keimeno)
	{
		Post post1=new Post(this,keimeno);
		for (int i=0;i<userArray.size();i++)//post ston eauto tou kai stous filous tou 
		{
			userArray.get(i).getWall1().addPost(post1);
		}
	}
	public String toString()
	{
		return this.name;

	}
	public Wall getWall1()
	{
		return wall1;
	}
	public void Comment(String s ,int i)
	{
		Post post2 =new Post(this,s);
		wall1.addComment(i, post2);
	}
	public void visitWall()
	{
		Scanner input=new Scanner(System.in);
		wall1.display();
		System.out.print(this.name+" Ean theleis na fugeis na postareis h na sxoliaseis  (exit -e)h(post - p)h(comment - c) \n");
		s = input.nextLine();
		while (!(s.equals("e")||s.equals("p")||s.equals("c")))//elxnos gia na dwsei swsto grama 
		{
			System.out.print("mh egiri timi \n");
			System.out.print("Ean theleis na fugeis na postareis h na sxoliaseis  (exit -e)h(post - p)h(comment - c) \n");
			s = input.next();
		}
		if (s.equals("p"))
		{
			System.out.print("dwse koimeno gia post \n");
			s = input.nextLine();
			this.post(s);
		}
		else if (s.equals("c"))
		{
			if (wall1.getPostArray1().size()>0)//elenxos gia to ean uparxei estw ena post
			{
				System.out.print("dwse keimeno gia comment kai noumero post \n");
				s = input.nextLine();
				s1=input.nextInt();
				while (s1>=this.userArray.size()-1)// elenxos  gia na min dinei lathos noumera
				{
					System.out.print("mi egiro noumero post dwse ksana \n");
					s1=input.nextInt();
				}
				Comment(s,s1);
			}
			else
			{
				System.out.print("den uparxei post \n");
				visitWall();
			}
		}
	}
	
}
class Post
{
	private String k;// xrisimopoihte sthn toString
	private String keimeno;
	private User user1;
	private ArrayList<Post> CommentArray;
	public Post(User user1,String keimeno)
	{
		CommentArray= new ArrayList<Post>();
		this.user1=user1;
		this.keimeno=keimeno;
	}
	public void addComment(Post p)
	{
		CommentArray.add(p);
	}
	public User getUser1()
	{
		return this.user1;
	}
	public String toString()
	{
		k=" ";
		if (CommentArray.size()==0)
		{
			k=k+this.user1.toString()+": "+keimeno+"\n";
			return k;
		}
		else
		{
			k=k+this.user1.toString()+": "+keimeno+"\n"+"Comments: \n";
			for (int i=0;i<CommentArray.size();i++)
			{
				k=k+CommentArray.get(i);
			}
			return k;
		}
	}
}
class Wall
{
	private User user1;
	private ArrayList<Post> postArray1;
	public Wall(User user1)
	{
		postArray1=new ArrayList<Post>();
		this.user1=user1;
	}
	public void addPost(Post post)
	{
		postArray1.add(post);
	}
	public void addComment(int i,Post p)
	{
		if (postArray1.size()>=i)
		{
			postArray1.get(i).addComment(p);
		}
	}
	public ArrayList<Post> getPostArray1()
	{
		return postArray1;
	}
	public void display()
	{
		System.out.print("Wall for user "+this.user1.toString()+"\n");
		int k=postArray1.size()-1;
		for (int i=0;i<postArray1.size();i++)// epanalipsi gia tin emfanisi tou tixou 
		{
			System.out.print(k+". "+postArray1.get(k).toString());
			k--;
		}
	}
}
public class SocialNework 
{
	public static void main(String[] args)
	{
		User user1=new User("basilis");
		User user2=new User("andreas");
		User user3=new User("simos");
		User user4=new User("marika");
		user1.befriend(user2);
		user1.befriend(user3);
		user2.befriend(user3);
		user4.befriend(user2);
		for (int i=0;i<100;i++) // epilegw na ginete h epenalipsi 100 fores
		{
			user1.visitWall();
			user2.visitWall();
			user3.visitWall();
			user4.visitWall();
		}
	}
}