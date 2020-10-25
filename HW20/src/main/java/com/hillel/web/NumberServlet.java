package com.hillel.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hillel.service.NumberService;

@WebServlet("/numberServlet")
public class NumberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    NumberService service;

    public NumberServlet() {
        service = new NumberService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sortedNumbers = service.sortArray(request.getParameter("arrayNumbers"));
        response.getWriter().append(sortedNumbers);
    }

}
