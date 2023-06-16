package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChucVu;
import repository.ChucVuRepository;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuServlett", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/delete",
        "/chuc-vu/detail",
        "/chuc-vu/view-update",
        "/chuc-vu/update",


})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<ChucVu> listChucVu = chucVuRepository.getAll();
            request.setAttribute("listChucVu", listChucVu);
            request.getRequestDispatcher("/view/chuc-vu/hien-thi.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu cv = chucVuRepository.getById(id);
            request.setAttribute("chucVu", cv);
            request.getRequestDispatcher("/view/chuc-vu/detail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu = chucVuRepository.getById(id);
            chucVuRepository.delete(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        }else if(uri.contains("view-update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu cv = chucVuRepository.getById(id);
            request.setAttribute("chucVu", cv);
            request.getRequestDispatcher("/view/chuc-vu/update.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu cv = new ChucVu();
            cv.setMa(ma);
            cv.setTen(ten);
            chucVuRepository.add(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        }else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu cv = new ChucVu(id, ma, ten );
            chucVuRepository.update(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}
