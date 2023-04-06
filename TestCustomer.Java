
class Invoice
{	
	private double xp;
	private int afm;
	public Invoice( int afm,double xp)
	{
		this.afm=afm;
		this.xp=xp;
	}
	public int getAfm()
	{
		return afm;
	}
	public double getXp()
	{
		return xp;
	}
	public String toString( )
	{
	 String k=this.afm + ":" + this.xp+'�';
	 return k;
	}
}
class Customer
{
	private Invoice afmxp;
	private double xp;
	private int afm;
	public Customer(int afm)
	{
		this.afm=afm;
		xp=0;
	}
	public double Charge(double poso)
	{
		xp=xp+poso;
		return xp;
	}
	public double Charge(Invoice afmxp)
	{
		int afm1=afmxp.getAfm();
		if (afm1==this.afm)
		{
			xp=xp+afmxp.getXp();
		}
		return xp;
	}
	public String toString( )
	{
	 String m=this.afm + ":" + this.xp+'�';
	 return m;
	}
}
class TestCustomer {
	public static void main(String[] args)
	{
		Customer myCustomer=new Customer(112233778);
		myCustomer.Charge(100);
		Invoice mCustomer =new Invoice(112233778,150);
		System.out.println(mCustomer);
		myCustomer.Charge(mCustomer);
		System.out.println(myCustomer);
	}
}

