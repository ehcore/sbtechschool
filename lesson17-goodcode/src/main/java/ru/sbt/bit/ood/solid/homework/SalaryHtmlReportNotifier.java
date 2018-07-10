package ru.sbt.bit.ood.solid.homework;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryHtmlReportNotifier {

    private Connection connection;
    private final String SQL = "select emp.id as emp_id, emp.name as amp_name, sum(salary) as salary from employee emp left join" +
            "salary_payments sp on emp.id = sp.employee_id where emp.department_id = ? and" +
            " sp.date >= ? and sp.date <= ? group by emp.id, emp.name";

    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;
    }

    public void /*generateAndSendHtml*/ makeSalaryReport(String departmentId, DateRange dateRange, String recipients) {
        try {
            ResultSet results = getQueryResult(departmentId,dateRange);
            StringBuilder resultingHtml = getHtml(results);
            sendReport(resultingHtml,recipients);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private ResultSet getQueryResult(String departmentId, DateRange dateRange)throws SQLException{
        // prepare statement with sql
        PreparedStatement ps = connection.prepareStatement(SQL);
        // inject parameters to sql
        ps.setString(1, departmentId);
        ps.setDate(2, new java.sql.Date(dateRange.getDateFrom().toEpochDay()));
        ps.setDate(3, new java.sql.Date(dateRange.getDateTo().toEpochDay()));
        // execute query and get the results
        ResultSet results = ps.executeQuery();
        return results;
    }

    private StringBuilder getHtml(ResultSet results) throws SQLException{
        // create a StringBuilder holding a resulting html
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        while (results.next()) {
            // process each row of query results
            resultingHtml.append("<tr>"); // add row start tag
            resultingHtml.append("<td>").append(results.getString("emp_name")).append("</td>"); // appending employee name
            resultingHtml.append("<td>").append(results.getDouble("salary")).append("</td>"); // appending employee salary for period
            resultingHtml.append("</tr>"); // add row end tag
            totals += results.getDouble("salary"); // add salary to totals
        }
        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");
        return resultingHtml;
    }

    private void sendReport(StringBuilder resultingHtml, String recipients) throws MessagingException{
        // now when the report is built we need to send it to the recipients list
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // we're going to use google mail to send this message
        mailSender.setHost("mail.google.com");
        // construct the message
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipients);
        // setting message text, last parameter 'true' says that it is HTML format
        helper.setText(resultingHtml.toString(), true);
        helper.setSubject("Monthly department salary report");
        // send the message
        mailSender.send(message);
    }

}
