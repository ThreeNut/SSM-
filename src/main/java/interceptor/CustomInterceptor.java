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

    /**
     * 拦截处理程序的执行。在HandlerMapping确定适当的处理程序对象之后调用，但在HandlerAdapter调用处理程序之前调用。
     * DispatcherServlet处理由任意数量的拦截器组成的执行链中的处理程序，处理程序本身位于末尾。使用此方法，每个拦截器可以决定中止执行链，
     * 通常发送HTTP错误或编写自定义响应。 注意：异步请求处理需要特别注意。有关详细信息，请参阅AsyncHandlerInterceptor。
     * 默认实现返回true。 参数: request–当前HTTP请求 response–当前HTTP响应 handler–为类型和/或实例求值选择要执行的处理程序
     * 返回值: 如果执行链应该继续下一个拦截器或处理程序本身，则为true。否则，DispatcherServlet假定该拦截器已经处理了响应本身。
     */
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

    /**
     * 拦截处理程序的执行。在HandlerAdapter实际调用处理程序之后调用，但在DispatcherServlet呈现视图之前调用。
     * 可以通过给定的ModelAndView向视图公开其他模型对象。
     * DispatcherServlet处理由任意数量的拦截器组成的执行链中的处理程序，
     * 处理程序本身位于末尾。使用此方法，每个拦截器可以对执行进行后处理，并按照执行链的相反顺序应用。
     * 注意：异步请求处理需要特别注意。
     * 有关详细信息，请参阅AsyncHandlerInterceptor。
     * 默认实现为空。 参数: request–当前HTTP请求 response–当前HTTP响应 handler–启动异步执行的处理程序（或HandlerMethod），
     * 用于类型和/或实例检查 modelAndView–处理程序返回的modelAndView（也可以为空）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle success!");
    }

    /**
     * 请求处理完成后，即呈现视图后的回调。将在处理程序执行的任何结果上调用，从而允许正确的资源清理。
     * 注意：仅当此拦截器的preHandle方法成功完成并返回true时才会调用！
     *
     * 与postHandle方法一样，该方法将以相反的顺序在链中的每个拦截器上调用，因此第一个拦截器将是最后一个被调用的拦截器。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion success!");
    }

}
