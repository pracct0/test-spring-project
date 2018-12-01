<%@ page contentType="text/html; charset=Big5"
    import="java.sql.*"%>

<html>
   <head><title>Hello World</title></head>
   
   <body>
      Hello World!<br/>
      <%
         out.println("Your IP address is " + request.getRemoteAddr());
      %>
   </body>
</html>
