<%-- 
    Document   : reporte
    Created on : 29-Jan-2020, 08:11:33
    Author     : mecc
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="empre.Modelo.Conexion" %>
<!DOCTYPE html>
<%
   String nom=request.getParameter("nom"); 
   Conexion c=new Conexion();
   File f=new File(application.getRealPath("report1.jasper"));
   Map p=new HashMap();
   p.put("n",nom);
   byte[] bytes=JasperRunManager.runReportToPdf(f.getPath(),p, c.con());
   response.setContentType("application/pdf"); 
   response.setContentLength(bytes.length);
   ServletOutputStream ou=response.getOutputStream();
   ou.write(bytes,0,bytes.length);
   ou.flush();
   ou.close();

%>
