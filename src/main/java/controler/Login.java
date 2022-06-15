package controler;

import dao.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 模拟登录
 * -------------  springMVC 数据绑定------------
 * @ RequestParam
 * 有时候前端请求中参数名和后台控制器类方法中的形参名不一样，
 * 这就会导致后台无法正确绑定并接收到前端请求的参数。
 * 为此，Spring MVC提供了@RequestParam注解来进行间接数据绑定。
 *-------------------------------------------
 * 如果 入参格式为json风格 需要添加注解 @RequestBody
 * 出参为json风格 需要添加            @ResponseBody
 * ------------------------------------------
 * RESTful 风格  Representational State Transfer
 *  @ PathVariable("id")注解则用于接收并绑定请求参数
 *
 * @author ThreeNut
 * @date 2022/6/14 18:48
 */

@Controller
@RequestMapping("/index")
public class Login {

    /**
     * 用户登录
     * @return 登录页面
     */
    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(Account account, Model model, HttpSession httpsession){
        System.out.println(account);
        String name = account.getName();
        Integer id = account.getId();
        if (name != null && id != null && name.equals("zou") && id == 1){
            httpsession.setAttribute("USER_SESSION", account);
            return "show";
        }
        model.addAttribute("msg", "用户名或者id错误");
        return "login";
    }

    @GetMapping("/main")
    public String toMain(){
        return "main";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpsession){
        httpsession.removeAttribute("USER_SESSION");
        return "login";
    }
}
