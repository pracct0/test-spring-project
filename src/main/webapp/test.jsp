<%@ page import="java.sql.*" %>

<HTML>
    <HEAD>
        <TITLE>Creating a Table</TITLE>
    </HEAD>

    <BODY>
        <H1>Creating a Table</H1>
        
        <%  
        out.println("Testing 123.");
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useUnicode=true&characterEncoding=big5", "root", "Icp3VBDabFPqkKym");

                Statement statement = connection.createStatement();
                String command = "CREATE TABLE Tree (ID INTEGER, Name CHAR(50));";
                out.println('hi hi');
                out.println(statement.executeUpdate(command));
                out.println('hi hi 2');
            } catch (Exception e) {
                out.println("An error occurred.");
            }
        %>
        
        The Employees table was created.
    </BODY>
</HTML>
