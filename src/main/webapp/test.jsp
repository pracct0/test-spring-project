<%@ page contentType="text/html; charset=Big5"
    import="java.sql.*"%>

<html>
   <head><title>Hello World</title></head>
   
   <body>
      Hello World!<br/>
      <%
         out.println("Your IP address is " + request.getRemoteAddr());
         
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useUnicode=true&characterEncoding=big5","root", "Icp3VBDabFPqkKym");

conn.close();

out.println("End");
         
      %>
   </body>
</html>
