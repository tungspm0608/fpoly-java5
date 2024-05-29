package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Ví dụ: kiểm tra xem người dùng đã đăng nhập hay chưa
        NhanVien nv = (NhanVien) request.getSession().getAttribute("nhanvien");
        if (nv == null) {
            // Người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập
            response.sendRedirect("/no-login");
            return false;
        }

        String uri = request.getRequestURI();
        if (uri.contains("hoa-don") || uri.contains("hoa-don-chi-tiet") || uri.contains("nhan-vien")) {
            if (nv.getTrangThai() == 0) {
                System.out.println("check");
                response.sendRedirect("/no-role");
                return false;
            }
        }
        // Tiếp tục xử lý yêu cầu
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//        // Thực hiện logic sau khi xử lý xong yêu cầu
//        System.out.println("Interceptor: postHandle method is called for URL: " + request.getRequestURI());
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        // Thực hiện logic sau khi hoàn thành xử lý yêu cầu
//        System.out.println("Interceptor: afterCompletion method is called for URL: " + request.getRequestURI());
//    }
}
