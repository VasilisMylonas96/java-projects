
import java.util.ArrayList;
class TransactionRecord
{
		private Customer Customer1;
		private Provider Provider1;
		private int posotPe;
		private double sunoloko;
		public TransactionRecord(Customer Customer3,Provider Provider4,int posotPe)
		{
			this.Provider1=Provider4;
			this.Customer1=Customer3;
			this.posotPe=posotPe;	
		}
		
		public Provider getProvider1()
		{
			return Provider1;
		}
		public Customer getCustomer1()
		{
			return Customer1;
		}
		public void  setposotPe(int posotita)
		{
			this.posotPe=posotita;
		}
		public int  getposotPe(int posotita)
		{
			return this.posotPe;
		}
}
class Provider
{
	private int afmpro;
	private double esoda;
	private double timpol;
	private double posotita;
	private TransactionRecord[] myArray=new TransactionRecord[2];
	public Provider (int afmpro,double timpol,double posotita)
	{	
		this.afmpro=afmpro;
		this.timpol=timpol;
		this.posotita=posotita;
		this.esoda=0;
	}
	public void   takeOrder(TransactionRecord TransactionRecord1)
	{
		this.esoda=this.timpol*this.posotita;
		myArray[TransactionRecord1.getCustomer1().getAfmpel()]=esoda;
	}
	public void cancelTransaction(TransactionRecord TransactionRecord1)
	{
		myArray[TransactionRecord1.getCustomer1().getAfmpel()]=null;
		
	}
        public completeTransaction(TransactionRecord TransactionRecord1)
	{
		if (this.posotita<TransactionRecord1.getposotPe())
		{
			System.out.println("den uparxei emparkis posotita");
			return false;
		}
		else
		{
			this.posotita=this.posotita-TransactionRecord1.setposotPe();
			this.esoda=this.esoda+TransactionRecord1.setposotPe()*this.timipol;
			return true;		
		}
	}
	public int getAfmpro()
	{
		return this.afmpro;
	}
	public String toString ()
	{
		String st="Provider"+this.afmpro+":"+"quantity"+this.posotita+":"+"income"+this.esoda;
		return st;
	}
}
	
class Customer
{
	private	int afmpel;
	private double xrimata;
	public Customer(int afmpel, double kefalaioxp)
	{
		this.afmpel=afmpel;
		this.xrimata=xrimata;
	}
	public void makeOrder(Provider provider1,int posotita)
	{
		TransactionRecord TransactionRecord1=new TransactionRecord(this,provider1,posotita);
		TransactionRecord1.setposotPe(posotita);
		
	}
	public boolean completeTransaction(Provider provider1)// den prolabame na to oloklirosoume
	{
		if (this.xrimata
	}
	public int getAfmpel()
	{
		return this.afmpel;
	}
	public String toString ()
	{
		String st="Customer"+this.afmpel+":"+"cash"this.xrimata;
		return st;
	}
}

class Transaction
{
	public static void main(String[] args){
		Provider p0 = new Provider(0,10,10); // (AFM, price, quantity)
		Provider p1 = new Provider(1,5, 20);
		Customer c0 = new Customer(0,110);  // (AFM, cash)
		Customer c1 = new Customer(1,200);
		//Ο c0 κάνει παραγγελία στον p0 για 10 αντικείμενα
		//Ο c1 κάνει παραγγελία στον p0 για 5 αντικείμενα
		//Ο c0 κάνει παραγγελία στον p1 για 4 αντικείμενα
		//Ο c1 κάνει παραγγελία στον p1 για 10 αντικείμενα
		//Όλοι οι πελάτες επιχειρούν να ολοκληρώσουν τις συναλλαγές τους 
		System.out.println(c0);
		System.out.println(c1);
		System.out.println(p0);
		System.out.println(p1);	
	}
}
