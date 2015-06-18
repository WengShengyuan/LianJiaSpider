package util.mail;

public class MailTestClass {
	
	static String senderMail = "senderAccount@163.com";
	static String password = "senderAccountPassword";
	
	static String receiverMail = "receiverMail";
	
	public static void main(String[] args) throws Exception {  
		 
		 MailSender sender = new MailSender(senderMail, password);
		 
		 Mail mail = new Mail();
		 mail.setSubject("testSubject");
		 mail.setContent("testContent");
		 
		 sender.send(receiverMail, mail);
		 
		 
	 }

}
