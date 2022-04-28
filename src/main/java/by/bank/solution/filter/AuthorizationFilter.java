package by.bank.solution.filter;

import by.bank.solution.entity.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter("/bank-solution")
public class AuthorizationFilter implements Filter {

    private static final Map<String, List<Role>> ACCESS = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ACCESS.put("show_fill_user_data", Arrays.asList(Role.USER));
        ACCESS.put("fill_user_data", Arrays.asList(Role.USER));
        ACCESS.put("show_main", Arrays.asList(Role.USER, Role.ADMIN));
        ACCESS.put("show_deposit", Arrays.asList(Role.USER));
        ACCESS.put("make_deposit", Arrays.asList(Role.USER));
        ACCESS.put("show_request_deposit", Arrays.asList(Role.ADMIN));
        ACCESS.put("show_user_profile", Arrays.asList(Role.ADMIN));
        ACCESS.put("show_top_up_balance", Arrays.asList(Role.USER));
        ACCESS.put("top_up_balance", Arrays.asList(Role.USER));
        ACCESS.put("approved_deposit", Arrays.asList(Role.ADMIN));
        ACCESS.put("show_enter_deposit", Arrays.asList(Role.USER));
        ACCESS.put("logout", Arrays.asList(Role.ADMIN, Role.USER));
        ACCESS.put("show_profile", Arrays.asList(Role.USER));
        ACCESS.put("show_clients", Arrays.asList(Role.ADMIN));
        ACCESS.put("delete_user", Arrays.asList(Role.ADMIN));
        ACCESS.put("search_user", Arrays.asList(Role.ADMIN));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String command = request.getParameter("command");

        if (command == null) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("index.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        }

        Role role = (Role) session.getAttribute("role");
        if (role == null) {
            authentication(servletRequest, servletResponse, filterChain, command);
            if (session.getAttribute("login") == null) {
                RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("index.jsp");
                dispatcher.forward(servletRequest, servletResponse);
            }
        } else {
            List<Role> roles = ACCESS.get(command);
            if (roles.contains(role)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("WEB-INF/view/errorPage.jsp");
                request.setAttribute("errorMessage", "not access");
                dispatcher.forward(servletRequest, servletResponse);
            }
        }
    }

    public void authentication(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain, String command) throws ServletException, IOException {
        if (command.equals("show_registration")) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("WEB-INF/view/registration.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        } else if (command.equals("show_login")) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("index.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        } else if (command.equals("registration")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } /*else if (command.equals("login")) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("index.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        }*/ else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }


    @Override
    public void destroy() {

    }
}
