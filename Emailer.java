class Email
{
	private String sender;
	private String recipient;
	private String text;
	public Email(String sender,String recipient,String text)
	{
		this.sender=sender;
		this.recipient=recipient;
		this.text=text;
	}
	public void read()
	{
		System.out.print("From : "+this.sender+"\n"+"to : "+this.recipient+"\n"+this.text+"\n");
		
	}
	public Email forward(String recipient)
	{
		Email email=new Email(this.recipient,recipient,this.text);
		return email;
	}
	public String getSender()
	{
		return this.sender;
	}
	public String getRecipient()
	{
		return this.recipient;
	}
	public String getText()
	{
		return this.text;
	}
}

class RichEmail extends Email 
{
	private String attachment;
	public RichEmail(String sender,String recipient,String text,String namefile)
	{
		super(sender,recipient,text);
		this.attachment=namefile;
	} 
	public void read ()	
	{
		System.out.print("From : "+getSender()+"\n"+"to : "+getRecipient()+"\n"+getText()+"\n"+"<"+this.attachment+">"+"\n");
	}
	public Email forward(String recipient)
	{
		RichEmail richemail=new RichEmail(getRecipient(),recipient,getText(),this.attachment);
		return richemail;
	}
	public void saveAttachment(String namedirectory)
	{
		System.out.print(namedirectory+"/"+this.attachment);
	}
	public String getAttachment()
	{
		return this.attachment;
	}
	
}

public class Emailer
{
	public static void main(String[]
args)
	{
		Email[] email=new Email[2];
		email[0]=new Email("Andreas Theofilopoulos","Basilis Mylonas","Geia sou basili"+"\n");
		email[1]=new RichEmail("Andreas Theofilopoulos","Basilis Mylonas","Geia sou basili","fotografies diakopon"+"\n");
		readEmails(email);
		RichEmail fwdEmail = (RichEmail) email[1].forward("Andreas Theofilopoulos");
		fwdEmail.read();	
		fwdEmail.saveAttachment("My documents");
		System.out.print(fwdEmail.getAttachment());
	}
	public static void readEmails(Email[] email)
	{
		email[0].read();
		email[1].read();
	}
}
