package interceptor;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 拦截器1
 * @author ThreeNut
 * @date 2022/6/14 17:19
 */
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException {
        System.out.println("preHandle success !");
        HttpSession session = request.getSession();
        Object user_session = session.getAttribute("USER_SESSION");
        if (!ObjectUtils.isEmpty(user_session)) {
            return true;
        }
        request.setAttribute("msg", "你还未登录!");
        request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle success!");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion success!");
    }

}
