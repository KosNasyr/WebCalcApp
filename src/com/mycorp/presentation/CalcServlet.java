package com.mycorp.presentation;

import com.mycorp.ejb.CalculationBean;
import com.mycorp.model.CalcLog;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalcServlet", urlPatterns = {"/CalcServlet"})
public class CalcServlet extends HttpServlet {
    @EJB
    CalculationBean calc;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        Double a = Double.parseDouble(request.getParameter("a"));
        Double b = Double.parseDouble(request.getParameter("b"));
        String operator = request.getParameter("op");
        try {
            double result = calc.calculate(a,b, operator);
            calc.createCalculationLog( new CalcLog(a,b,result,operator));
            System.out.println("processRequest.result = " + result);

            request.setAttribute("result",String.valueOf(result));
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    public String getServletInfo() {
        return "Short description";
    }
}
