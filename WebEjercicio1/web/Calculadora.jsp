<%-- 
    Document   : Calculadora
    Created on : 12/03/2016, 05:55:12 PM
    Author     : Upao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%!
            //DECLARACION DE VARIABLE
            int n=3;
            public final static int MAX =3;
        %>
        <%
            //Scriptles
            String hola = "Upao";
            
        %>
        <h1>Resultado: <%=n%></h1>
        <form action="ServletEjemplo" method="POST">
            Numero 1: <input type="text" name="n1"/>
            Numero 2: <input type="text" name="n2"/>
            <select name="operador">
                <option>+</option>
                <option>-</option>
                <option>*</option>
                <option>/</option>
            </select>
            <input type ="submit" value="Calcular"/>
        </form>
    </body>
</html>
