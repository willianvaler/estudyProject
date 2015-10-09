<%-- 
    Document   : doUploadWithJsp
    Created on : 07/10/2015, 18:46:05
    Author     : willian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload de Arquivos</title>
    </head>
    <body>
        <jsp:useBean id="upl" scope="page" class="myPackage.UploadBean"/>
        <jsp:setProperty name="upl" property="diretorio" value="arquivos"/>
        <%
            if ( upl.doFilePost(request, application))
                {
                    out.print(upl.getFilename());
                }
        %>
        
        <form method="post" action="doUploadWithJsp.jsp" enctype="multipart/form-data" >
            Arquivo: <input type="file" name="file" /><br/>
            <input type="submit" name="submit" value="enviar"/>
        </form>
    </body>
</html>
