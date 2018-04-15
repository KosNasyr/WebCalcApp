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
import java.util.List;

@WebServlet(name = "CalcLogServlet", urlPatterns = {"/CalculationLog"})
public class CalcLogServlet extends HttpServlet {
    @EJB
    CalculationBean calc;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<CalcLog> list = calc.getCalcLog();

        for (CalcLog cr : list) {
            System.out.println("list " + cr.getId()+"/" + cr.getParam1()+"/" + cr.getParam2()
                    +"/" + cr.getResult()+"/" + cr.getOperation()+"/" + cr.getCreationDateAsString());
        }

        request.setAttribute("logs", list);
        request.getRequestDispatcher("calculationLog.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
