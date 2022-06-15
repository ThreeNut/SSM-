package controler;

import dao.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 模拟登录
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
