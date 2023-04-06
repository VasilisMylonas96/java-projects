import java.util.Scanner;
class RevEngine
{
	private boolean status=false;
	
	public void start()
	{
		status=true;
	}
	public void stop()
	{
		status=false;
	}
	public void printState()
	{
		if (status==true)
		{
			System.out.println("The engine is on");
		}
		else if (status==false)
		{
			System.out.println("The engine is off");
		}
	}

	int rpm=1000;
	
	public void changeRev(int strof)
	{
		rpm+=strof;
		if (rpm>=1000 && rpm<=8000)
		{
			boolean flag=true;
		}
		else if (rpm<1000 || rpm>8000)
		{
			boolean flag=false;
		}
	}
	public void printSate()
	{
			System.out.println("the rpm is: "+rpm);
	}
}

public class TestRevEngine
{
	public static void main(String args[])
	{
		boolean status=false;
		RevEngine slowEngine=new RevEngine();
		slowEngine.start();
		RevEngine fastEngine=new RevEngine();
		fastEngine.start();
		Scanner dwse = new Scanner(System.in);
		System.out.println("give the number of rpm ");
		int strof=dwse.nextInt();
		int strof1=strof;
		int strof2=2*strof;
		slowEngine.changeRev(strof1);
		fastEngine.changeRev(strof2);
		if (strof1 <=7000 && strof2<=7000)
		{
			System.out.println("Successful rev modification");
		}
	}

}