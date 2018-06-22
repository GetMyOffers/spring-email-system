package io.nebulas.notify_platform.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by Keqi Huang on 2018/6/15.
 */
public class BaseController {
    @Value("${page.base.url}")
    private String pageBaseUrl;

    public void setBaseInfo(ModelAndView mav) {
        mav.addObject("pageBaseUrl", pageBaseUrl);
    }
}
