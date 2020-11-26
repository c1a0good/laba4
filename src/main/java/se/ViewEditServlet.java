package se;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MyObject object = (MyObject)req.getAttribute("object");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter w = resp.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("      content=\"text/html; charset=UTF-8\">");
        w.println("<TITLE>Тест</TITLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<FORM action=\"save.html\" method=\"post\">");
        if(object != null) {
            w.printf("<INPUT type=\"hidden\" name=\"id\" value=\"%d\">\n",
                    object.getId());
        }
        w.println("<P>Код сотрудника:</P>");
        w.printf("<INPUT type=\"text\" name=\"EmployeeID\" value=\"%d\">\n",
                object != null ? object.getEmployeeID() : null);
        w.println("<P>Отдел:</P>");
        w.printf("<INPUT type=\"text\" name=\"Department\" value=\"%s\">\n",
                object != null ? object.getDepartment() : "");
        w.println("<P>Фамилия:</P>");
        w.printf("<INPUT type=\"text\" name=\"LastName\" value=\"%s\">\n",
                object != null ? object.getLastName() : "");
        w.println("<P>Имя:</P>");
        w.printf("<INPUT type=\"text\" name=\"FirstName\" value=\"%s\">\n",
                object != null ? object.getFirstName() : "");
        w.println("<P>Отчество:</P>");
        w.printf("<INPUT type=\"text\" name=\"MiddleName\" value=\"%s\">\n",
                object != null ? object.getMiddleName() : "");
        w.println("<P>Дата начала отпуска:</P>");
        w.printf("<INPUT type=\"text\" name=\"StartDate\" value=\"%s\">\n",
                object != null ? object.getStartDate() : "");
        w.println("<P>Дата окончания отпуска:</P>");
        w.printf("<INPUT type=\"text\" name=\"EndDate\" value=\"%s\">\n",
                object != null ? object.getEndDate() : "");
        w.println("<P>Заработная плата:</P>");
        w.printf("<INPUT type=\"text\" name=\"Salary\" value=\"%.2f\">\n",
                object != null ? object.getSalary() : null);
        w.println("<BUTTON type=\"submit\">Сохранить</BUTTON>");
        w.println("<A href=\"index.html\">Назад</A>");
        w.println("</FORM>");
        w.println("</BODY>");
        w.println("</HTML>");
    }
}