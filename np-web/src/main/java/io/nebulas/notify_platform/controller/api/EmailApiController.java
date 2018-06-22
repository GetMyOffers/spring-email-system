package io.nebulas.notify_platform.controller.api;


import io.nebulas.notify_platform.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;

import javax.annotation.processing.Processor;

/**
 * created by Keqi Huang on 2018/6/15.
 */
@Slf4j
@RestController
@RequestMapping("/email")
public class EmailApiController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private TemplateEngine templateEngine;

    @PostMapping("/send")
    public void sendEmail(@RequestParam("to") String to,
                          @RequestParam("subject") String subject,
                          @RequestParam("templateType") String templateType) throws Exception{
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "1");
        String emailContent = templateEngine.process("email/" + templateType, context);
        emailService.sendHtmlMailByExecutorPoor(to, subject, emailContent);
    }

}
