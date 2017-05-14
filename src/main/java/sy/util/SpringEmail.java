package sy.util;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
 
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
 
public class SpringEmail {
 
    private JavaMailSenderImpl mailSender=null;
    //邮件用户名
    private String userName="";
    //发送邮箱名称
    private String from="@163.com";
    //接收邮箱名称
    private String to="@qq.com";
 
    public SpringEmail()
    {
        this.mailSender = new JavaMailSenderImpl();
        //邮箱smtp服务器
        mailSender.setHost("smtp.163.com");
        mailSender.setPort(25);
        mailSender.setUsername(this.userName);
        //邮箱密码
        mailSender.setPassword("xxxx");
    }
 
    //普通文本Email
    public void sendPureMail() {
        SimpleMailMessage message = new SimpleMailMessage();
 
        String spitterName = "这里是标题（纯文本）";
        message.setFrom(this.from);
        message.setTo(this.to);
        message.setSubject("这里是标题!");
        message.setText("这里是内容");
        this.mailSender.send(message);
    }
 
    //带多个附件的Email
    public void sendMailWithAttachment() throws MessagingException {
 
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
 
        helper.setFrom(this.from);
        helper.setTo(this.to);
        helper.setSubject("这里是标题(带多个附件）!");
        helper.setText("这里是内容(带附件）");
 
        //添加两个附件（附件位置位于java-->resources目录)，可根据需要添加或修改
        ClassPathResource image = new ClassPathResource("/coupon.jpg");
        ClassPathResource PDF = new ClassPathResource("/Rop Reference.pdf");
        helper.addAttachment("Coupon.png", image);
        helper.addAttachment("Rop Reference.pdf", PDF);
 
        this.mailSender.send(message);
    }
 
    //带附件的HTML格式的Email
    public void sendMailHtmlWithAttachment() throws MessagingException {
 
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true,"GBK"); //解决乱码问题
 
        helper.setFrom(this.from);
        helper.setTo(this.to);
        helper.setSubject("这里是标题(Html带附件）!");
        //设置META解决乱码问题
        helper.setText("<html><META http-equiv=Content-Type content='text/html; charset=GBK'><body><img src='cid:Coupon'>" +
                "<h4>" + "测试乱码" + " says...</h4>" +
                "<i>" + "测试乱码2" + "</i>" +
                "</body></html>", true);
 
        //图片嵌入到html文件中
        ClassPathResource couponImage = new ClassPathResource("/coupon.jpg");
        helper.addInline("Coupon", couponImage);
 
        //图片作为附件发送
        ClassPathResource couponImage2 = new ClassPathResource("/coupon.jpg");
        helper.addAttachment("Coupon.png", couponImage2);
 
 
        this.mailSender.send(message);
    }
 
    public static void main(String[] args) throws MessagingException{
        System.out.println("开始发送邮件");
 
        SpringEmail email=new SpringEmail();
        //email.sendPureMail();
        //email.sendMailWithAttachment();
        email.sendMailHtmlWithAttachment();
 
        System.out.println("邮件发送成功");
    }
}