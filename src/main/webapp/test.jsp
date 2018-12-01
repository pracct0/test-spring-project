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
%>

<TABLE  bgcolor=DodgerBlue>
    <TR  bgcolor=SkyBlue>
    <TD><B>Column 1</B></TD>
    <TD><B>Column 2</B></TD>
    <TD><B>Column 3</B></TD>
    <TD><B>Column 4</B></TD>
    <TD><B>Column 5</B></TD>
    <TD><B>Column 6</B></TD>
    </TR>   
    <%
    while (rs.next())
    {
        %>
        <TR bgcolor=LightGoldenrodYellow>
        <TD><B><%= rs.getString(1) %></B></TD>
        <TD><B><%= rs.getString(2) %></B></TD>
        <TD><B><%= rs.getString(3) %></B></TD> 
        <TD><B><%= rs.getString(4) %></B></TD> 
        <TD><B><%= rs.getString(5) %></B></TD> 
        <TD><B><%= rs.getString(6) %></B></TD> 
        </TR>
        <%
    }
</TABLE>

<%
rs.close();
stmt.close();
conn.close();

out.println("End");
         
      %>
   </body>
</html>
