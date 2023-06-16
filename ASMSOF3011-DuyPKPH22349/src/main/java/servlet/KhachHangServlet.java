package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.KhachHang;
import repository.KhachHangRepository;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/detail",
        "/khach-hang/delete",
        "/khach-hang/view-update",
        "/khach-hang/update",

})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<KhachHang> ctkh = khachHangRepository.getAll();
            request.setAttribute("listHienThi", ctkh);
            request.getRequestDispatcher("/view/khach-hang/hien-thi.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.getById(id);
            request.setAttribute("khachHang", khachHang);
            String ngaySinh = simpleDateFormat.format(khachHang.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/view/khach-hang/detail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.getById(id);
            khachHangRepository.delete(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.getById(id);
            request.setAttribute("khachHang", khachHang);
            String ngaySinh = simpleDateFormat.format(khachHang.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/view/khach-hang/update.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            Date ngaySinh;
            try {
                ngaySinh = simpleDateFormat.parse(request.getParameter("ngaySinh"));
            }catch (ParseException e){
                throw new RuntimeException(e);
            }
            KhachHang kh = new KhachHang();
            kh.setMa(ma);
            kh.setTen(ten);
            kh.setTenDem(tenDem);
            kh.setHo(ho);
            kh.setSdt(sdt);
            kh.setDiaChi(diaChi);
            kh.setThanhPho(thanhPho);
            kh.setQuocGia(quocGia);
            kh.setMatKhau(matKhau);
            kh.setNgaySinh(ngaySinh);
            khachHangRepository.add(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        }else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            System.out.println("id: " + id);
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            Date ngaySinh;
            try {
                ngaySinh = simpleDateFormat.parse(request.getParameter("ngaySinh"));
            }catch (ParseException e){
                throw new RuntimeException(e);
            }
            KhachHang kh = new KhachHang(id,ma, ten, tenDem, ho,ngaySinh, sdt, diaChi, thanhPho, quocGia, matKhau);
            khachHangRepository.update(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }
}
