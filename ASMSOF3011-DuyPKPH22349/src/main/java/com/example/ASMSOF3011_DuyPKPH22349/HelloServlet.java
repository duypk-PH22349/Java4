package com.example.ASMSOF3011_DuyPKPH22349;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "ASM-SOF3011.03";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        out.println("Họ và tên: Phạm Khương Duy" + "<br>");
        out.println("Mã sinh viên: PH22349" + "<br>");
        out.println("ASM-SOF3011.03" + "<br>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}