
import java.util.Random;
import java.util.Scanner;
class Road
{
	private double kilometer;
	private boolean hasturns;
	private String info;
	private Random random ;
	private double sunk;//suntelestis katanalwsis
	public Road (double kilometer)
	{
		random= new Random();
		this.kilometer=kilometer;
		int k =random.nextInt(2);
		if (k==0)
		{
			hasturns=true;
		}
		else
		{
			hasturns=false;
		}
	}
	public boolean getHasturns()//to xreisimopoio pio katw 
	{
		return hasturns;
	}
	public double getKilometer()//to xreisimopoio pio katw 
	{
		return kilometer;
	}
	public String toString()// epistrefei ean exei h oxi strofes 
	{
		if (hasturns==true)
		{
			info="o dromos exei strofes";
		}
		else
		{
			info= "o dromos exei strofes";
		}
		return info;
	}
	public void updateFactor(double sunk)
	{
		if (hasturns==true)
		{
			sunk=sunk+(10*sunk)/(double)100;
		}
		this.sunk=sunk;
		//System.out.print(sunk);
	}
	public double getSunk()
	{
		return sunk;
	}
	public int getType()
	{
			return 0;
	}
}
class DirtRoad extends Road
{
	private double epb;// epipedo broxis 
	private String info;//to xrisimopoio stin tostring
	public DirtRoad(double kilometer)
	{
		super(kilometer);
		Random random=new Random();
		epb=random.nextInt(11);// mou deinei times apo to 0-10
		epb=epb/10;// tis parapanw timies tis diero me to 10 gia na exw 0-1 times (0.1,0.2-1.0)
	}
	public void updateFactor(double sunk)
	{
		if (getHasturns()==true)
		{
			sunk=sunk+(10*sunk)/(double)100;
		}
		if (epb>=0.8)
		{
			sunk=sunk+(20*sunk)/(double)100;
		}
		else if(epb>=0.5)
		{
			sunk=sunk+(10*sunk)/(double)100;
		}
	}
	public String toString()// epistrefei ean exei h oxi strofes 
	{
		if (getHasturns()==true)
		{
			info ="o dromos exei strofes";
		}
		else
		{
			info = "o dromos den exei strofes";
		}
		if (epb>=0.8)
		{
			info=info+"kai brexei me epipedo broxis megalutero  apo "+0.8+"eos kai "+1;
		}
		else if (epb>=0.5)
		{
			info=info+"kai brexei me epipedo broxis mirkotero apo "+0.8+"alla megalitero apo "+0.5;
		}
		else
		{
			info=info+"kai brexei me epipedo broxis mirkotero apo "+0.5;
		}
		return info;
	}
	public double getEpb()
	{
		return epb;
	}
	public int getType()
	{
		return 1;
	}
}
class RockyRoad extends Road
{
	private int type;
	private String info;
	public RockyRoad(double kilometer)
	{
		super(kilometer);
		Random random=new Random();
		type=random.nextInt(3);
	}
	public void updateFactor(double sunk)
	{
		if (getHasturns()==true)
		{
			sunk=sunk+(10*sunk)/(double)100;
		}
		if (type==2)
		{
			sunk=sunk+(20*sunk)/(double)100;
		}
		else if(type==1)
		{
			sunk=sunk+(10*sunk)/(double)100;
		}
	}
	public String toString()// epistrefei ean exei h oxi strofes 
	{
		if (getHasturns()==true)
		{
			info ="o dromos exei strofes";
		}
		else
		{
			info = "o dromos den exei strofes";
		}
		if (type==2)
		{
			info=info+"kai einai xomatodromos me epipedo anomalou dromou "+2;
		}
		else if (type==1)
		{
			info=info+"kai einai xomatodromos me epipedo anomalou dromou "+1;
		}
		else 
		{
			info=info+"kai einai xomatodromos me epipedo anomalou dromou "+0;
		}
		return info;
	}
	public int getType()
	{
		return 2;
	}
}
abstract class Vehicle
{
	private String name;
	private double time;
	private double kausima;
	public abstract double computeFactor(Road road);
	public Vehicle(String name)
	{
		this.name=name;
	}
	public abstract void  race(Road road,double kausima);
	public void race(Road road)
	{
		time=road.getKilometer()/((kausima/road.getKilometer())/computeFactor(road));
	}
	public void refuel()
	{
		this.kausima=this.kausima +100;
	}
	public double getKausima()
	{
		return kausima;
	}
	public String toString()
	{
		return name+"exei :"+kausima+"kausima";
	}
	public double getTime()
	{
		return time;
	}
}
class Motorcycle extends Vehicle
{
	private double time; 
	public Motorcycle(String name)
	{
		super(name);
	}

	public double computeFactor(Road road)
	{
		if (road.getType()==0)
		{
			return 0.5;
		}
		else if (road.getType()==1)
		{
			return 2;
		}
		else
		{
			return 2.5;
		}
	}
	public void race(Road road,double kausima)
	{
		time=road.getKilometer()/((kausima/road.getKilometer())/computeFactor(road));
	}
}
class Car extends Vehicle
{
	private double time ;
	public Car(String name) 
	{
		super(name);
	}

	public double computeFactor(Road road)
	{
		if (road.getType()==0)
		{
			return 1;
		}
		else if (road.getType()==1)
		{
			return 1.5;
		}
		else
		{
			return 2;
		}
	}
	public void race(Road road,double kausima)
	{
		time=road.getKilometer()/((kausima/road.getKilometer())/computeFactor(road));
	}
}
class Jeep extends Vehicle
{
	private double time ;
	public Jeep(String name) 
	{
		super(name);
	}

	public double computeFactor(Road road)
	{
		if (road.getType()==0)
		{
			return 1.3;
		}
		else if (road.getType()==1)
		{
			return 1.5;
		}
		else
		{
			return 1.8;
		}
	}
	public void race(Road road,double kausima)
	{
		time=road.getKilometer()/((kausima/road.getKilometer())/computeFactor(road));
	}
}
class RaceTrack
{
	private int pinakasP[];//pinakas autokinitwn 
	private int pinakasM[];// pinakas metron
	private int ar=0;// to xrismopoio sto reachedEnd
	private int sinolo;// tin xrisimopoio stin print 
	private Random random ;
	public RaceTrack(int arithmosP)
	{
		random= new Random();
		int pinakasP[]=new int[arithmosP];
		int pinakasM[]=new int[arithmosP];
		for (int i=0;i<arithmosP;i++)
		{
			pinakasP[i]=random.nextInt(3);
			pinakasM[i]=50+random.nextInt(51);
		}
	}
	public int nextSegment()
	{
		return pinakasP[ar];
	}
	public int getPinakasM()
	{
		return pinakasM[ar];
	}
	public boolean reachedEnd()
	{

		ar=ar+1;
		if (ar==pinakasP.length)
		{
			return true;
		}
		return false;
	}
	public void print ()
	{
		for (int i=0; i<pinakasM.length;i++)
		{
			sinolo=sinolo+pinakasM[i];
		}
		System.out.print("exoun na treksoun akoma "+sinolo+"metra");
	}
}
class RaceParticipants
{
	private Vehicle pinakasO[];
	private int MAX1;
	private double max;
	private double kausima;
	private int k;//to xrisimopoio pio katw 
	public RaceParticipants()
	{
		Scanner input =new Scanner(System.in);
		Vehicle pianakasO[]=new Vehicle[4];
		pinakasO[0]=new Motorcycle("Motorcycle");
		pinakasO[1]=new Car("Car");
		pinakasO[2]=new Jeep("Jeep");
		System.out.print("theleis 1.Motorcycle \n  2.Car \n 3.Jeep");
		int k=input.nextInt();
		while (k!=3 || k!=2 || k!=1)
		{
			System.out.print("mi egiri timi");
			System.out.print("theleis 1.Motorcycle \n  2.Car \n 3.Jeep");
			k=input.nextInt();
		}
		if (k==1)
		{
			pinakasO[3]=new Motorcycle("Motorcycle");
		}
		else if(k==2)
		{
			pinakasO[3]=new Car("Car");
		}
		else
		{
			pinakasO[3]=new Jeep("Jeep");
		}
	}
	public void pista(int arithmos,double metra)
	{
		Scanner input1=new Scanner(System.in);
		Road road = new Road(metra);
		DirtRoad dirtRoad=new DirtRoad(metra);
		RockyRoad rockyRoad=new RockyRoad(metra);
		for (int i=0;i<=pinakasO.length;i++)
		{
			pinakasO[i].refuel();
		}
		if (arithmos==0)
		{
			for (int i=0;i<=pinakasO.length;i++)
			{
				if (i <=2)
				{
					pinakasO[i].race(road);
				}
				else
				{
					System.out.print("ta diathesima kausima sou einai "+pinakasO[i].getKausima()+"litra posa thes na xrisimopoihshs");
					kausima=input1.nextDouble();
					pinakasO[i].race(road,kausima);
				}
				pinakasO[i].toString();
				pinakasO[i].refuel();
			}
		}
		else if (arithmos==1)
		{
			for (int i=0;i<=pinakasO.length;i++)
			{
				if (i <=2)
				{
					pinakasO[i].race(dirtRoad);
				}
				else
				{
					System.out.print("ta diathesima kausima sou einai "+pinakasO[i].getKausima()+"litra posa thes na xrisimopoihshs");
					kausima=input1.nextDouble();
					pinakasO[i].race(dirtRoad,kausima);
				}
				pinakasO[i].toString();
				pinakasO[i].refuel();
			}
		}
		else
		{
			for (int i=0;i<=pinakasO.length;i++)
			{
				if (i <=2)
				{
					pinakasO[i].race(rockyRoad);
				}
				else
				{
					System.out.print("ta diathesima kausima sou einai "+pinakasO[i].getKausima()+"litra posa thes na xrisimopoihshs");
					kausima=input1.nextDouble();
					pinakasO[i].race(rockyRoad,kausima);
				}
				pinakasO[i].toString();
				pinakasO[i].refuel();
			}
		}
		for (int i=0;i<=pinakasO.length;i++)
		{
			if (pinakasO[i].getTime()>max)
			{
				max=pinakasO[i].getTime();
				MAX1=i;
			}
		}
		if (MAX1==0)
		{
			System.out.print("o nikitis einai h Motorcycle me xrono "+max+"lepta");
		}
		else if (MAX1==1)
		{
			System.out.print("o nikitis einai to Car me xrono "+max+"lepta");
		}
		else
		{
			System.out.print("o nikitis einai to Jeep me xrono "+max+"lepta");
		}
	}
	
	
}
public class RacingGame  
{
	public static void main(String[] args)
	{
		RaceTrack raceTrack=new RaceTrack(10);
		raceTrack.print();
		RaceParticipants raceParticipants=new RaceParticipants();
		raceParticipants.pista(raceTrack.nextSegment(),raceTrack.getPinakasM());
		
	}
}
//to programma den prolaba na to oloklirwsw eutasa mexri tin main ... den eixa xrono gia na elenksw pws douleuei