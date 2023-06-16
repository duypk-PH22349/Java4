package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChucVu;
import model.CuaHang;
import repository.CuaHangRepository;


import java.io.IOException;
import java.util.List;
import java.util.UUID;


@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/delete",
        "/cua-hang/detail",
        "/cua-hang/update",
        "/cua-hang/view-update",


})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<CuaHang> ctch = cuaHangRepository.getAll();
            request.setAttribute("listHienThi", ctch);
            request.getRequestDispatcher("/view/cua-hang/hien-thi.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getById(id);
            request.setAttribute("cuaHang", cuaHang);
            request.getRequestDispatcher("/view/cua-hang/detail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getById(id);
            cuaHangRepository.delete(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getById(id);
            request.setAttribute("cuaHang", cuaHang);
            request.getRequestDispatcher("/view/cua-hang/update.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang ch = new CuaHang();
            ch.setMa(ma);
            ch.setTen(ten);
            ch.setDiaChi(diaChi);
            ch.setThanhPho(thanhPho);
            ch.setQuocGia(quocGia);
            cuaHangRepository.add(ch);
            response.sendRedirect("/cua-hang/hien-thi");
        }else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang ch = new CuaHang(id, ma, ten, diaChi,thanhPho,quocGia);
            cuaHangRepository.update(ch);
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }
}
