package sy.util;
  
import java.util.List;  
  





import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailSender;  
import org.springframework.mail.SimpleMailMessage;  
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
  
/** 
 * 
 * @author
 * @date 2015-9-23 
 */  
public class MailUtil {  
    private MailSender mailSender;  
    private SimpleMailMessage simpleMailMessage;  
    
    private JavaMailSenderImpl javaMailSender;
   

	// private MimeMessage mimeMessage;
    private MimeMessageHelper mimeMessageHelper;
    //private SimpleMailMessage simpleMailMessage;  
      
    //Spring 依赖注入  
    public void setMailSender(MailSender mailSender) {  
        this.mailSender = mailSender;  
    }  
    //Spring 依赖注入  
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {  
    	this.simpleMailMessage = simpleMailMessage;  
    }  
     
    
    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
/*    public void setMimeMessage(MimeMessage mailMessage) {
		this.mimeMessage = mailMessage;
	}*/

	public void setMimeMessageHelper(MimeMessageHelper mimeMessageHelper) {
		this.mimeMessageHelper = mimeMessageHelper;
	}

    /** 
     * 单发 
     * 
     * @param recipient 收件人 
     * @param subject 主题 
     * @param content 内容 
     */  
    public void send(String recipient,String subject,String content){  
        simpleMailMessage.setTo(recipient);  
        simpleMailMessage.setSubject(subject);  
        simpleMailMessage.setText(content);  
        mailSender.send(simpleMailMessage);  
    }  
      
    /** 
     * 群发 
     * 
     * @param recipients 收件人 
     * @param subject 主题 
     * @param content 内容 
     */  
    public void send(List<String> recipients,String subject,String content){  
        simpleMailMessage.setTo(recipients.toArray(new String[recipients.size()]));  
        simpleMailMessage.setSubject(subject);  
        simpleMailMessage.setText(content);  
        mailSender.send(simpleMailMessage);  
    }
    
    public void sendMime(String recipient,String subject,String content) throws MessagingException{
    	mimeMessageHelper.setTo(recipient);  
    	mimeMessageHelper.setSubject(subject);  
    	mimeMessageHelper.setText(content,true);  
    	javaMailSender.send(mimeMessageHelper.getMimeMessage()); 
    }
}  
