<%@ page contentType="text/html; charset=Big5"
    import="java.sql.*"%>

<html>
   <head><title>Hello World</title></head>
   
   <body>
      Hello World!<br/>
      <%
         out.println("Your IP address is " + request.getRemoteAddr());
         
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://10.130.57.49:3306/sampledb?useUnicode=true&characterEncoding=big5","root", "Icp3VBDabFPqkKym");

Statement stmt = conn.createStatement();

	  ResultSet rs = stmt.executeQuery("SELECT * FROM information_schema.tables");

while (rs.next()) {

   out.println(resultSet.getString(1));
}
rs.close();
stmt.close();
conn.close();

out.println("End");
         
      %>
   </body>
</html>
