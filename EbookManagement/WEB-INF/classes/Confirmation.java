import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Confirmation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<!DOCTYPE html><html><head><title>EbookManagement</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><link rel=\"stylesheet\" href=\"style.css\"/></head><body><header><h class=\"header-head\">Order Confirmed</h></header></body></html>");
    }
}