package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CuaHang;
import model.DongSP;
import repository.DongSPRepository;


import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {
        "/dong-sp/hien-thi",
        "/dong-sp/delete",
        "/dong-sp/update",
        "/dong-sp/view-update",
        "/dong-sp/detail",

})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<DongSP> dsdsp = dongSPRepository.getAll();
            request.setAttribute("listHienThi", dsdsp);
            request.getRequestDispatcher("/view/dong-sp/hien-thi.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = dongSPRepository.getById(id);
            request.setAttribute("dongSp", dongSP);
            request.getRequestDispatcher("/view/dong-sp/detail.jsp").forward(request, response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = dongSPRepository.getById(id);
            dongSPRepository.delete(dongSP);
            response.sendRedirect("/dong-sp/hien-thi");
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = dongSPRepository.getById(id);
            request.setAttribute("dongSp", dongSP);
            request.getRequestDispatcher("/view/dong-sp/update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP();
            dongSP.setMa(ma);
            dongSP.setTen(ten);
            dongSPRepository.add(dongSP);
            response.sendRedirect("/dong-sp/hien-thi");
        }else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP(id, ma, ten);
            dongSPRepository.update(dongSP);
            response.sendRedirect("/dong-sp/hien-thi");
        }
    }
}
