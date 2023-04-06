import java.util.Random;

class Board
{
	private int[] pinakas;
	private String[] pinakas2;
	private boolean t;
	private int k;
	private int m;
	public Board(int arithmosN)
	{
		Random ran = new Random();
		pinakas=new int[2*arithmosN] ;
		String[] pinakas2=new String[2*arithmosN] ;// pinakas2 paralilos me ton pinaka opou * klisto filo  opou 0 anoikto filo 
		for (int i=0;i<2*arithmosN; i++)
		{
			pinakas2[i]="*";// xrisimopoiw  enan paralilo pinaka wste na mporw na elenxw poies kartes einai anigmenes kai poies oxi
			if (i<arithmosN)
			{
				pinakas[i]=i;
			}
			else
			{
				if (i>arithmosN)
				{
					t= false;
					while (t==false)// auto edw to kanw dioti den thelw na mou dinei dio kai tris fores to idio noumero thelw mono mia fora ena apo ta noumera 0-9 kanw diladi elenxo
					{
						k= ran.nextInt(arithmosN);
						t=true;
						for (int m=arithmosN;m<i ;m++)
						{
							
							if (pinakas[m]==k)
							{
								t=false;
							}
						}
					}
					
					pinakas[i] = k;
				}
				else 
				{
					pinakas[i] = ran.nextInt(arithmosN);
				}
			}
		//	System.out.print(pinakas[i]+" ");
			 
		}	
	}
	public void print(int thesi1, int thesi2)
	{
		for (int i=0; i<pinakas.length; i++)
		{
			if (pinakas2[i]!="*"^pinakas[i]==pinakas[thesi1]^pinakas[i]==pinakas[thesi2])
			{
				System.out.print(pinakas[i]+",");
			}
			else 
			{
				System.out.print((i+1)+"pinakas2[i]");
			}
		}
		System.out.print("\n");
		if (pinakas[thesi1]!=pinakas[thesi2])
		{
			delay(5);
			System.out.print("\r");
			for (int i=0;i<pinakas.length; i++)
			{
				if (pinakas2[i]!="*")
				{
					System.out.print(pinakas[i]+",");
				}
				else 
				{
					System.out.print((i+1)+"pinakas[i]");
				}
			}
		}
	}
	private static void delay(int i) 
	{
		try 
		{
			Thread.currentThread().sleep(1*i);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	public boolean checkPositions (int thesi1 , int thesi2)
	{
		if (pinakas[thesi1]==pinakas[thesi2])
		{
			pinakas2[thesi1]="0";// ayto to kanw gia na kserw poies theseis ston pinaka einai anoiktes kai poies oxi 
			pinakas2[thesi2]="0";
			return true;
		}
		else 
		{
			return false;
		}
	}
	public int getRandomPosition()
	{
		Random  rand = new Random();
		m=rand.nextInt(pinakas.length-1);
		t=false;
		while (t=false)
		{
			if (pinakas2[m]=="*")
			{
				m=rand.nextInt(pinakas.length-1);
			}
			else
			{
				t=true;
			}
		}
		return m;
	}
	public int getcard(int thesi)
	{
		return pinakas[thesi];
	}
	public boolean allOpen()
	{
		for (int i=0; i < pinakas.length;i++)
		{
			if (pinakas2[i]!="*")
			{
				return false;
			}
		}
		return true;
	}
}
class ComputerPlayer
{
	private int[] pinakastheseon;
	private String[] pinakastheseon2;
	private int pontoip;
	private int arithmostheseon;
	private boolean tim;
	private int thesi0;
	private int thesi1;
	public ComputerPlayer(int arithmostheseon)
	{
		this.arithmostheseon=arithmostheseon;
		 pinakastheseon=new int[this.arithmostheseon];
		 pinakastheseon2=new String[this.arithmostheseon];
		 pontoip=0;
		 for (int i=0; i<this.arithmostheseon; i++)
		 {
			 pinakastheseon2[i]="*";
		 }
	}
	public void play(Board board)
	{
		thesi0=board.getRandomPosition();
		pinakastheseon[thesi0]=board.getcard(thesi0);
		for (int k=0; k<arithmostheseon; k++)
		{
			if (board.checkPositions(thesi0,k)&&thesi0!=k)
			{
				pinakastheseon2[thesi0]="0";
				pinakastheseon2[k]="0";
				pontoip=pontoip+1;
				tim=true;
				thesi1=k;
			}
		}
		if (tim!=true)
		{
			thesi1=board.getRandomPosition();
			pinakastheseon[thesi1]=board.getcard(thesi1);
			if (board.checkPositions(thesi0,thesi1))
			{
				
				pinakastheseon2[thesi1]="0";
				pinakastheseon2[thesi0]="0";
				pontoip=pontoip+1;
			}
		}
		board.print(thesi0, thesi1);
	}
	public int getPontoi()
	{
		return pontoip;
	}
}

















public class ASK2 
{
	public static void main(String[] args)
	{
		Board paok=new Board(10);
		
	}
}
