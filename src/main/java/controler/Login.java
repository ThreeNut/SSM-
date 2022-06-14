package controler;

import dao.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 模拟登录
 * @author ThreeNut
 * @date 2022/6/14 18:48
 */

@Controller
@RequestMapping("/login")
public class Login {

    @RequestMapping("/success")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
}
