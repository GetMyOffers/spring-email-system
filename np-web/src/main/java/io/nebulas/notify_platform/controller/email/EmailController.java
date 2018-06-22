package io.nebulas.notify_platform.controller.email;


import io.nebulas.notify_platform.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by Keqi Huang on 2018/6/14.
 */
@RequestMapping("/email")
@Controller
public class EmailController extends BaseController{

    // @Value("${application.message:Hello World}")
    // private String message = "Hello World";

    @RequestMapping("")
    public ModelAndView welcome(ModelAndView mav) {
        mav.setViewName("email/welcome");
        File file = new File(System.getProperty("user.dir") + "/np-service/src/main/resources/templates/email");

        List<String> fileNames = new ArrayList<>();
        File[] files = file.listFiles();
        for (File f: files)
        {
            fileNames.add(f.getName().split("\\.")[0]);
        }
        mav.addObject("fileNames", fileNames);
        // mav.addObject("message", this.message);
        return mav;
    }
}
