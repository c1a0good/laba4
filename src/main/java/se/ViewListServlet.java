package se;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        @SuppressWarnings("unchecked")
        Collection<MyObject> objects = (Collection<MyObject>)req.getAttribute("objects");
        Double earningsSum = (Double)req.getAttribute("earningsSum");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter w = resp.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("      content=\"text/html; charset=UTF-8\">");
        w.println("<TITLE>Тест</TITLE>");
        w.println("<STYLE>");
        w.println("TABLE {");
        w.println("border-collapse: collapse;");
        w.println("}");
        w.println("TH, TD {");
        w.println("border: 1px solid black;");
        w.println("padding: 5px 30px 5px 10px;");
        w.println("}");
        w.println("</STYLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<FORM action=\"delete.html\" method=\"post\">");
        w.println("<TABLE>");
        w.print("<TR>");
        w.print("<TH>&nbsp;</TH>");
        w.print("<TH>Код сотрудника</TH>");
        w.print("<TH>Отдел</TH>");
        w.print("<TH>Фамилия</TH>");
        w.print("<TH>Имя</TH>");
        w.print("<TH>Отчество</TH>");
        w.print("<TH>Дата начала отпуска</TH>");
        w.print("<TH>Дата окончания отпуска</TH>");
        w.print("<TH>Заработная плата</TH>");
        w.print("<TH>Размер отпускных</TH>");
        w.println("</TR>");
        for(MyObject object : objects) {
            w.print("<TR>");
            w.printf("<TD>");
            w.printf("<INPUT type=\"checkbox\" name=\"id\" value=\"%d\">",
                    object.getId());
            w.printf("</TD>");
            w.printf("<TD><A href=\"edit.html?id=%d\">%d</A></TD>",
                    object.getId(), object.getEmployeeID());
            w.printf("<TD>%s</TD>", object.getDepartment());
            w.printf("<TD>%s</TD>", object.getLastName());
            w.printf("<TD>%s</TD>", object.getFirstName());
            w.printf("<TD>%s</TD>", object.getMiddleName());
            w.printf("<TD>%s</TD>", object.getStartDate());
            w.printf("<TD>%s</TD>", object.getEndDate());
            w.printf("<TD>%.2f</TD>", object.getSalary());
            w.printf("<TD>%.2f</TD>", object.getEarnings());
            w.println("</TR>");
        }
        w.println("</TABLE>");
        w.println("<P>");
        w.printf("Сумма отпускных: %.2f</P>", earningsSum);
        w.println("<P>");
        w.println("<A href=\"edit.html\">Добавить</A>");
        w.println("<BUTTON type=\"submit\">Удалить</BUTTON>");
        w.println("</P>");
        w.println("<TABLE>");
        w.print("<TR>");
        w.print("<TH>Отдел</TH>");
        w.print("<TH>Кол-во отсутствующих сотрудников</TH>");
        w.print("<TH>Начало промежутка</TH>");
        w.print("<TH>Конец промежутка</TH>");
        w.println("</TR>");
        for(DepartmentEmployees d: DepartmentManager.manage()){
            w.print("<TR>");
            w.printf("<TD>%s</TD>", d.getDepartment());
            w.printf("<TD>%s</TD>", d.getEmployees());
            w.printf("<TD>%s</TD>", d.getStartDate());
            w.printf("<TD>%s</TD>", d.getEndDate());
            w.println("</TR>");
        }
        w.println("</TABLE>");
        w.println("</FORM>");
        w.println("</BODY>");
        w.println("</HTML>");
    }
}
