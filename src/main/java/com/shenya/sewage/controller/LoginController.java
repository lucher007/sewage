package com.shenya.sewage.controller;

import com.shenya.sewage.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class LoginController extends BaseController{

    @RequestMapping("/login")
    public String index(Model model){
        return "login/login";
    }

    /**
     *
     * @Function: loginDeal
     * @Description: 用户登录数据处理
     */
    @RequestMapping("/loginDeal")
    public String loginDeal(String loginname, String password, HttpServletRequest request)  throws Exception{

            request.setAttribute("loginname", loginname);
            request.setAttribute("password", password);

            if (StringUtils.isEmpty(loginname)) {
                request.setAttribute("errortype","loginname");
                request.setAttribute("message","登录账号不能为空");
                return "login/login";
            }

            if(!"admin".equals(loginname)){
                request.setAttribute("errortype","loginname");
                request.setAttribute("message","登录账号不正确");
                return "login/login";
            }

            if (StringUtils.isEmpty(password)) {
                request.setAttribute("errortype","password");
                request.setAttribute("message","登录密码不能为空");
                return "login/login";
            }
            if(!"123456".equals(password)){
                request.setAttribute("errortype","password");
                request.setAttribute("message","登录密码不正确");
                return "login/login";
            }

            // 保存操作员到session中
            request.getSession().setAttribute("Operator", new User());

            return "main/main";

    }

    @RequestMapping("/welcome")
    public String welcome(Model model){
        return "main/welcome";
    }

    /**
     * 重新回到登录界面（SESSION断掉）
     */
    @RequestMapping(value = "/noPermission")
    public String noPermission(HttpSession httpSession, HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        return "mobilebusiness/noPermission";
    }

    /**
     * 退出系统
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession, HttpServletRequest request, Model model) throws UnsupportedEncodingException {

        //清空操作员
        httpSession.setAttribute("MobileOperator", null);

        return "mobilebusiness/login";
    }

}
