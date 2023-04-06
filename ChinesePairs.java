
import java.util.Random;
import java.util.Scanner;
class Board
{
	private int[] pinakas;
	private boolean[] pinakas2;
	private int arithmostheseon;
	private boolean t;
	private int k;
	private int m;
	public Board(int arithmosN)
	{
		this.arithmostheseon=2*arithmosN;
		Random ran = new Random();
		pinakas=new int[this.arithmostheseon] ;
		pinakas2=new boolean[this.arithmostheseon] ;// pinakas2 paralilos me ton pinaka opou * klisto filo  opou 0 anoikto filo 
		for (int i=0;i<this.arithmostheseon; i++)
		{
			pinakas2[i]=false;// xrisimopoiw  enan paralilo pinaka wste na mporw na elenxw poies kartes einai anigmenes kai poies oxi
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
			//System.out.print(pinakas[i]+" ");
			 
		}	
	}
	public void print(int thesi1, int thesi2)
	{
			//anoigw kai tis thesis ston pinaka2 apo katw afou einai ises oi duo thesis 
			pinakas2[thesi1]=true;
			pinakas2[thesi2]=true;
			for (int i=0; i<this.arithmostheseon; i++)
			{
				//System.out.print(pinakas2[i]);
				if ((pinakas2[i]==true))
				{
					System.out.print("|"+i+" "+pinakas[i]+"|"+",");
				}
				else 
				{
					System.out.print("|"+(i)+" "+"*"+"|"+",");
				}
			}
		if (pinakas[thesi1]!=pinakas[thesi2])
		{
			delay(5);
			System.out.print("\r");
			System.out.print("den brethike zeugari ");			
			pinakas2[thesi1]=false;// edw ksana klinw tis thesis efou oi thesi1 kai thesi2 den htan isi 
			pinakas2[thesi2]=false;
			for (int i=0;i<this.arithmostheseon; i++)//printarw to teliko apotelesma me tis kartes 
			{
				if (pinakas2[i]!=false)
				{
					System.out.print("|"+i+" "+pinakas[i]+"|"+", ");
				}
				else 
				{
					System.out.print("|"+(i)+" "+"*"+"|"+", ");
				}
			}
		}
		
	}
	private static void delay(int sec) 
	{
		try 
		{
			Thread.currentThread().sleep(1000*sec);
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
		m=rand.nextInt(this.arithmostheseon);
		t=false;
		while (t==false)// enas elenxos gia na min mou dinei tis idies thesis ... dld na min mou dwsei mia fora  0 1 kai meta ksana dwsei 0 1 ...
		{
			if (pinakas2[m]==true)
			{
				m=rand.nextInt(this.arithmostheseon);
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
	public boolean getcard2(int thesi)
	{
		return pinakas2[thesi];
	}
	public boolean allOpen()
	{
		for (int i=0; i < this.arithmostheseon;i++)
		{
			if (pinakas2[i]==false)
			{
				return false;
			}
		}
		return true;
	}
	public int getArithmosN()
	{
		return this.arithmostheseon;
	}
}
class ComputerPlayer
{
	private int[] pinakastheseon;
	private boolean[] pinakastheseon2;
	private int pointscomputer;
	private int arithmostheseon;
	private boolean tim;
	private int thesi0;
	private int thesi1;
	private int thesi3;
	private int thesi4;
	public ComputerPlayer(int arithmostheseon)
	{
		this.arithmostheseon=2*arithmostheseon;
		pinakastheseon=new int[this.arithmostheseon];
		pinakastheseon2=new boolean[this.arithmostheseon];
		pointscomputer=0;
		for (int i=0; i<this.arithmostheseon; i++)
		{
			pinakastheseon2[i]=false;
		}
	}
	public void play(Board board)
	{
		thesi3=HumanPlayer.getcard();//xrisi tis sinartis pou exw balei wste na enimerwnete o upologistis gia pies kartes exei anoiksei kai o pektis 
		pinakastheseon2[thesi3]=true;
		pinakastheseon[thesi3]=board.getcard(thesi3);
		thesi4=HumanPlayer.getcard1();// to idio kai edw
		pinakastheseon2[thesi4]=true;
		pinakastheseon[thesi4]=board.getcard(thesi4);
		tim=false;
		
		thesi0=board.getRandomPosition();
		
		pinakastheseon2[thesi0]=true;
		pinakastheseon[thesi0]=board.getcard(thesi0);
		for (int k=0; k<this.arithmostheseon; k++)
		{	
			if (pinakastheseon2[k]==true)// enas elenxos gia na min stelnei kai elenxei kai tis klistes kartes pou stin ousia den exei dei o ipologistis 
			{
				if (board.checkPositions(thesi0,k)&&thesi0!=k)
				{
					System.out.print("brethike zeugari \n");
					//pinakastheseon2[thesi0]=true;
					pinakastheseon2[k]=true;
					pointscomputer=pointscomputer+1;
					tim=true;
					thesi1=k;
				}
			}
		}
		if (tim==false)// ean den mpei stin proti epanalipsi prepei na ksana dialeksi tixea afou den exei dei tin idia karta stin ousia 
		{
			thesi1=board.getRandomPosition();
			while (pinakastheseon2[thesi1]==true)
			{
				thesi1=board.getRandomPosition();
			}
			pinakastheseon[thesi1]=board.getcard(thesi1);
			if (board.checkPositions(thesi0,thesi1))// edw den xreiazomaste pleon epanalipsi exoume tis dio kartes pou theloume 
			{
				System.out.print("brethike zeugari \n"); 
				pointscomputer=pointscomputer+1;
			}
		}
		pinakastheseon2[thesi1]=true;
		board.print(thesi0, thesi1);
	}
	public int getPointsComputer()
	{
		return pointscomputer;
	}
}
class HumanPlayer
{
	private static int thesi3;
	private static int thesi4;
	private boolean t;
	private int pointsplayer;
	public void play(Board board1)
	{
		Scanner dwse=new Scanner(System.in);
		System.out.print("dwse 2 theseis diaforetikes : \n");
		thesi3=dwse.nextInt();
		thesi4=dwse.nextInt();
		t=false;
		while (t==false)
		{
			if (thesi3==thesi4||thesi3>=board1.getArithmosN()||thesi4>=board1.getArithmosN()||board1.getcard2(thesi3)==true||board1.getcard2(thesi4)==true)// elenxos gia na min dwsei o xristis idio arithmo h thesis pou exei ksna dwsei 
			{
				System.out.print("edwses 2 idies theseis ,h thesi pou exeis ksana dwsei, h den eiparxei tetoia thesi \n");
				System.out.print("dwse 2 theseis diaforetikes : \n");
				thesi3=dwse.nextInt();
				thesi4=dwse.nextInt();
			}
			else
			{
				t=true;
			}
		}
		if (board1.checkPositions(thesi3, thesi4))
		{
			System.out.print("brethike zeugari \n"); 
			pointsplayer=pointsplayer+1;
		}
		board1.print(thesi3,thesi4);
	}
	public int  getPointsPlayer()
	{
		return pointsplayer;
	}
	public static int getcard()// auto mou xreiazete gia ton upologistei oste na gnwrizei ti kartes exei anoiksei o pektis 
	{
		return thesi3;
	}
	public static int getcard1()// to idio kai edw 
	{
		return thesi4;
	}
}

public class ChinesePairs 
{
	public static void main(String[] args)
	{
		Scanner input =new Scanner(System.in);
		int x;
		int pointsC;
		int pointsP;
		String t;
		t="yes";
		while(t.equals("yes")||t.equals("YES")||t.equals("y")||t.equals("Y"))//epanalipsi gia to ean o pektis thelei na arxisei kai allo pexnidi 
		{
			pointsC=0;
			pointsP=0;
			x=0;
			while (x==0)// elenxos gia na min  mou dwsei 0 zeugaria 
			{
				System.out.print("dwse ton arithmo ton zeugariwn pou thes na pekseis : ");
				x=input.nextInt();
			}
			Board board=new Board(x);
			HumanPlayer Manplayer=new HumanPlayer();
			ComputerPlayer Computer= new ComputerPlayer(x);
			while(pointsP+pointsC!=x)// otan oi pontoi tou paikti +tous pontous tou computer ginoun x prepei na stamtisei gt den exei pleon na anoiksei alles kartes 
			{
					Manplayer.play(board);		
					System.out.print("\n oi pontoi sou einai : ");
					pointsP=Manplayer.getPointsPlayer();
					System.out.print(pointsP+"\n");	
				if (pointsP+pointsC<x)// aparetitos elenxos dioti xtipaei sfalma stin periptwsi pou eimaste 9 zeugaria anoikta enw exoume dwsei 10 ... o pektis to briskei ara o computer den mporei na peksei
				{
					Computer.play(board);
					System.out.print("\n oi pontoi tou ComputerPlayer einai : ");
					pointsC=Computer.getPointsComputer();
					System.out.print(pointsC+"\n");
				}
				
			}
			if (pointsC>pointsP)
			{
				System.out.print("EXASES \n");
			}
			else if (pointsC<pointsP)
			{
				System.out.print("KERDISES \n");
			}
			else
			{
				System.out.print("ISOPALIA \n");
			}
			System.out.print("thes na arxiseis neo pexnidi ? 'yes' or 'no' : ");
			t=input.next();
		}

	}
}