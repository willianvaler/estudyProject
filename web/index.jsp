<%-- 
    Document   : index
    Created on : 04/10/2015, 14:44:46
    Author     : willian
--%>

<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1" info="Write by WAV" 
         import="java.util.*" import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/hhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title> Trabalhando com JavaServer Pages </title>
    </head>
    <body>
        Usando diretiva <strong>page</strong>
        <br/>
        <%
            Date hoje = new Date();
            SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yy" );
        %>
        <br/>
        A data de  hoje é : <strong> <%= formato.format(hoje)%> </strong>
        <br/>
        <%@include file="rodape.html" %>
    </body>
</html>