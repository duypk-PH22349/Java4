package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DongSP;
import model.MauSac;
import repository.MauSacRepository;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/delete",
        "/mau-sac/update",
        "/mau-sac/view-update",

        "/mau-sac/detail",

})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<MauSac> dsms = mauSacRepository.getAll();
            request.setAttribute("listHienThi", dsms);
            request.getRequestDispatcher("/view/mau-sac/hien-thi.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getById(id);
            request.setAttribute("mauSac", mauSac);
            request.getRequestDispatcher("/view/mau-sac/detail.jsp").forward(request, response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getById(id);
            mauSacRepository.delete(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getById(id);
            request.setAttribute("mauSac", mauSac);
            request.getRequestDispatcher("/view/mau-sac/update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac ms = new MauSac();
            ms.setMa(ma);
            ms.setTen(ten);
            mauSacRepository.add(ms);
            response.sendRedirect("/mau-sac/hien-thi");
        }else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac ms = new MauSac(id, ma,ten);
            mauSacRepository.update(ms);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }
}
