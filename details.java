import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/details")
public class details extends HttpServlet {     
    @Override
    protected void doPost(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {String city=request.getParameter("city");
   String name=request.getParameter("name");
   String aadhar=request.getParameter("aadhar");
   String mobile=request.getParameter("mobile");  
   String currentLocation=request.getParameter("Current Location");
   String homeLocation=request.getParameter("Home Location");  
   String fever=request.getParameter("fever");
   String cough=request.getParameter("cough");
   String familyMember=request.getParameter("familyMember");
      
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/corona_info","root","root");
              Statement st= conn.createStatement();
  ResultSet rt;
  int i =st.executeUpdate("insert into corona_info(name,aadhar,mobile,currentLocation,homeLocation,fever,cough,familyMember) values ('"+name+"','"+aadhar+"','"+mobile+"','"+currentLocation+"','"+homeLocation+"','"+fever+"','"+cough+"','"+familyMember+"')");
  RequestDispatcher rs= request.getRequestDispatcher("/index.jsp");
             rs.forward(request, response);
             
        } catch (SQLException ex) {
           out.print("error");
        } 
    }
}