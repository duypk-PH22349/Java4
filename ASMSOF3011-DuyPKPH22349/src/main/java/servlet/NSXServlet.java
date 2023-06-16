package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NSX;
import model.NhanVien;
import repository.NSXRepository;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {
        "/nsx/hien-thi",
        "/nsx/delete",
        "/nsx/view-update",
        "/nsx/detail",
        "/nsx/update",
})
public class NSXServlet extends HttpServlet {
    private NSXRepository  nsxRepository = new NSXRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<NSX> ctnsx = nsxRepository.getAll();
            request.setAttribute("listHienThi", ctnsx);
            request.getRequestDispatcher("/view/nsx/hien-thi.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getById(id);
            request.setAttribute("nsx", nsx);
            request.getRequestDispatcher("/view/nsx/detail.jsp").forward(request, response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getById(id);
            nsxRepository.delete(nsx);
            response.sendRedirect("/nsx/hien-thi");
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getById(id);
            request.setAttribute("nsx", nsx);
            request.getRequestDispatcher("/view/nsx/update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX();
            nsx.setMa(ma);
            nsx.setTen(ten);
            nsxRepository.add(nsx);
            response.sendRedirect("/nsx/hien-thi");
        }else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX(id, ma, ten);
            nsxRepository.update(nsx);
            response.sendRedirect("/nsx/hien-thi");
        }
    }
}
