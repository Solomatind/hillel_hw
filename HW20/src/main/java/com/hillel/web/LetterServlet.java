package com.hillel.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hillel.service.LetterService;

@WebServlet("/letterServlet")
public class LetterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    LetterService service;

    public LetterServlet() {
        service = new LetterService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append(service.findLetter(request.getParameter("word")));

    }

}
