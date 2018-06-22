package io.nebulas.notify_platform;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import io.nebulas.notify_platform.dao.EmailRecordDao;
import io.nebulas.notify_platform.domain.model.EmailRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by Keqi Huang on 2018/6/19.
 */
@Component
public class EmailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRecordDao emailRecordDao;

    @Autowired
    private EmailService emailService;

    @Value("${mail.fromMail.addr}")
    private String from;

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            emailRecordDao.add(to, from, subject, content, 1);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            emailRecordDao.add(to, from, subject, content, 0);
            logger.error("发送简单邮件时发生异常！", e);
        }
    }

    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
            emailRecordDao.add(to, from, subject, content, 1);
            logger.info("html邮件发送成功");
        } catch (MessagingException e) {
            emailRecordDao.add(to, from, subject, content, 0);
            logger.error("发送html邮件时发生异常！", e);
        }
    }

    public void sendHtmlMailByExecutorPoor(String receivers, String subject, String content) {
        ExecutorService executorService= Executors.newFixedThreadPool(50); //五十个线程

        for (int i = 0; i < receivers.split("\n").length; i++) {
            String tmpTo = receivers.split("\n")[i];
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    emailService.sendHtmlMail(tmpTo, subject, content);
                }
            });
        }
    }

}
