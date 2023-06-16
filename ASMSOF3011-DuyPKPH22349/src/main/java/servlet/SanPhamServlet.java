package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DongSP;
import model.NSX;
import model.SanPham;
import repository.DongSPRepository;
import repository.SanPhamRepository;


import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/delete",
        "/san-pham/update",
        "/san-pham/view-update",

        "/san-pham/detail",

})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<SanPham> ctsp = sanPhamRepository.getAll();
            request.setAttribute("listHienThi", ctsp);
            request.getRequestDispatcher("/view/san-pham/hien-thi.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getById(id);
            request.setAttribute("sanPham", sanPham);
            request.getRequestDispatcher("/view/san-pham/detail.jsp").forward(request, response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getById(id);
            sanPhamRepository.delete(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getById(id);
            request.setAttribute("sanPham", sanPham);
            request.getRequestDispatcher("/view/san-pham/update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sp = new SanPham();
            sp.setMa(ma);
            sp.setTen(ten);
            sanPhamRepository.add(sp);
            response.sendRedirect("/san-pham/hien-thi");
        }else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sp = new SanPham(id, ma, ten);

            sanPhamRepository.update(sp);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }
}
