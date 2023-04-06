import java.util.Scanner;
class Geometric
{
	private int basi;
	private int mikos;
	private int ar;
	private int[] pinakas2;
	public Geometric()
	{
		this.ar=1;
		this.mikos=10;
		this.basi=2;
		pinakas2= new int[mikos];
		pinakas2[0]=1;
		for(int i= 1; i< mikos; i= i+1)
		{
			for(int k= 1; k<i; k= k+1)
			{
				ar=ar*basi;
				
			}
			pinakas2[i]=ar ;
			ar=1;
		}
	}
	public Geometric(int basi ,int mikos)
	{
		this.basi=basi;
		this.mikos=mikos;
		this.ar=1;
		pinakas2= new int[mikos];
		pinakas2[0]=1;
		for(int i= 1; i<mikos; i= i+1)
		{
			for(int k= 1; k<=i; k= k+1)
			{
				ar=ar*basi;
				
			}
			pinakas2[i]=ar ;
			ar=1;
		}
		
	}
	public void print()
	{
		System.out.print("<< ");
		for(int i=0; i< mikos; i= i+1)
		{
			System.out.print(pinakas2[i]+" ");
		}	
		System.out.print(">>");
	}
	public boolean equals(Geometric other)
	{
		for(int i=0; i< mikos; i= i+1)
		{
			if (this.pinakas2[i]!=other.pinakas2[i])
				{
					return false;
				}
		}
		return true;
	}
	public  int[] multiplyWith(Geometric other)
	{
		if (10==(other.pinakas2).length)
		{
			for(int i=0; i< mikos; i= i+1)
			{
				other.pinakas2[i]=other.pinakas2[i]*this.pinakas2[i];
				//System.out.print(" "+other.pinakas2[i]+" ");
			}	
		}
		
		return other.pinakas2;
	}
	
}

class GeometricTest
{
	public static void main(String args[])
	{
		Geometric geometriki=new Geometric(2,10);
		Scanner dwse = new Scanner(System.in);
		System.out.println("dwse mia bash");
		int bash=dwse.nextInt();
		System.out.println("dwse enan ektheth");
		int ektheths=dwse.nextInt();
		Geometric geometriki1=new Geometric(bash,ektheths);
		geometriki.print();
		geometriki1.print();
		if  (bash!=2 ||ektheths!=10)
		{
			System.out.print("different");
		}		
		else if (geometriki.equals(geometriki1)&& ektheths==10)
		{
			System.out.print("same");
		}
		
		geometriki.multiplyWith(geometriki1);
	}
}