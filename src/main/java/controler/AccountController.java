package controler;

import dao.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IService;

import java.util.List;

/**
 * web层
 *
 * @date 2019/11/27 16:05
 */

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IService service;

    @RequestMapping("/findAll")
    public ModelAndView findA() {
        List<Account> account = service.findAll();
        System.out.println(account + "-------------------------------------------------");
        ModelAndView mv = new ModelAndView();
        mv.addObject("item", account);
        mv.setViewName("show");
        return mv;
    }
}
