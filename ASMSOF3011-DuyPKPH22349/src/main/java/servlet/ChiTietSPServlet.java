package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChiTietSP;
import repository.ChiTietSPRepository;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSPServlet", value = {
        "/chitiet-sp/hien-thi",
        "/chitiet-sp/detail",
        "/chitiet-sp/delete",
        "/chitiet-sp/update",
        "/chitiet-sp/view-update",

})

public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
            if(uri.contains("hien-thi")){
            List<ChiTietSP> ctsp = chiTietSPRepository.getAll();
            request.setAttribute("listHienThi", ctsp);
            request.getRequestDispatcher("/view/chitiet-sp/hien-thi.jsp").forward(request, response);
        }else if(uri.contains("delete")){
                UUID id = UUID.fromString(request.getParameter("id"));
                ChiTietSP chiTietSP = chiTietSPRepository.getById(id);
                chiTietSPRepository.delete(chiTietSP);
                response.sendRedirect("/chitiet-sp/hien-thi");
         }else if(uri.contains("detail")){
                UUID id = UUID.fromString(request.getParameter("id"));
                ChiTietSP chiTietSP = chiTietSPRepository.getById(id);
                request.setAttribute("chiTietSP", chiTietSP);
                request.getRequestDispatcher("/view/chitiet-sp/detail.jsp").forward(request, response);
          }else if(uri.contains("view-update")){
                UUID id = UUID.fromString(request.getParameter("id"));
                ChiTietSP chiTietSP = chiTietSPRepository.getById(id);
                request.setAttribute("chiTietSP", chiTietSP);
                request.getRequestDispatcher("/view/chitiet-sp/update.jsp").forward(request, response);

            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            Integer namSX = Integer.parseInt(request.getParameter("namSX"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            float giaNhap = Float.parseFloat(request.getParameter("giaNhap"));
            float giaBan = Float.parseFloat(request.getParameter("giaBan"));
            chiTietSPRepository.add(new ChiTietSP(namSX, moTa, soLuongTon, giaNhap, giaBan));
            response.sendRedirect("/chitiet-sp/hien-thi");
        }else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            Integer namSX = Integer.parseInt(request.getParameter("namSX"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            float giaNhap = Float.parseFloat(request.getParameter("giaNhap"));
            float giaBan = Float.parseFloat(request.getParameter("giaBan"));
            chiTietSPRepository.update(new ChiTietSP(id,namSX, moTa, soLuongTon, giaNhap, giaBan));
            response.sendRedirect("/chitiet-sp/hien-thi");
        }
    }
}
