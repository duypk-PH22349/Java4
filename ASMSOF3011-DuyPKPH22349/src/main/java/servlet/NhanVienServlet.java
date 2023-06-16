package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NhanVien;

import repository.NhanVienRepository;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/delete",
        "/nhan-vien/detail",
        "/nhan-vien/update",
        "/nhan-vien/view-update",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<NhanVien> ctnv = nhanVienRepository.getAll();
            request.setAttribute("listHienThi", ctnv);
            request.getRequestDispatcher("/view/nhan-vien/hien-thi.jsp").forward(request, response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getById(id);
            nhanVienRepository.delete(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getById(id);
            request.setAttribute("nhanVien", nhanVien);
            String ngaySinh = simpleDateFormat.format(nhanVien.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/view/nhan-vien/detail.jsp").forward(request, response);
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getById(id);
            request.setAttribute("nhanVien", nhanVien);
            String ngaySinh = simpleDateFormat.format(nhanVien.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/view/nhan-vien/update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(uri.contains("hien-thi")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh;
            try{
                ngaySinh =  simpleDateFormat.parse(request.getParameter("ngaySinh"));
            }catch (ParseException e){
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String trangThai = request.getParameter("trangThai");
            nhanVienRepository.add(new NhanVien(ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, trangThai));
            response.sendRedirect("/nhan-vien/hien-thi");
        }else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh;
            try{
                ngaySinh =  simpleDateFormat.parse(request.getParameter("ngaySinh"));
            }catch (ParseException e){
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String trangThai = request.getParameter("trangThai");
            nhanVienRepository.update(new NhanVien(id,ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, trangThai));
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}
