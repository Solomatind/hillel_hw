package com.hillel.web.locale;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

@WebServlet("/locale")
public class ChangeLocale extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ChangeLocale() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String locale = (String) request.getParameter("language");
        Config.set(request.getSession(), Config.FMT_LOCALE, locale);
        response.sendRedirect(request.getHeader("Referer"));
    }

}
