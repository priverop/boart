//package es.boart.configuration;
//
//import java.util.Properties;
// 
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
// 
//@Configuration
//@ComponentScan(basePackages = "es.boart")
//public class MailConfiguration {
//     
//    //Put Other Application configuration here.
//     
//    @Bean
//    public JavaMailSender getMailSender(){
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//         
//        //Using gmail
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("boarturjc@gmail.com");
//        mailSender.setPassword("boarturjc4");
//         
//        Properties javaMailProperties = new Properties();
//        javaMailProperties.put("mail.smtp.starttls.enable", "true");
//        javaMailProperties.put("mail.smtp.auth", "true");
//        javaMailProperties.put("mail.transport.protocol", "smtp");
//        javaMailProperties.put("mail.debug", "true");//Prints out everything on screen
//         
//        mailSender.setJavaMailProperties(javaMailProperties);
//        return mailSender;
//    }
//}