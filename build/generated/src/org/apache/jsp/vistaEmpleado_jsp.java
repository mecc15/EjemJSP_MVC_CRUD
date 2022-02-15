package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import empre.Entidades.*;
import java.util.*;

public final class vistaEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

              if(request.getAttribute("emple")==null)
                 response.sendRedirect("ControlEmpleado?m1=1");
        
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"jquery.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"sweetalert2.all.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>CRUD EMPLEADOS!</h1>\n");
      out.write("        \n");
      out.write("        <div class=\"col-md-5\"> \n");
      out.write("        <form name=\"f1\" action=\"ControlEmpleado\">\n");
      out.write("            Id<input type=\"text\" name=\"id_emp\" id=\"id_emp\" value=\"\" class=\"form-control\" />\n");
      out.write("            Nombre<input type=\"text\" name=\"nombre\" id=\"nombre\" value=\"\" class=\"form-control\" />\n");
      out.write("            Telefono<input type=\"text\" name=\"telefono\" id=\"telefono\" value=\"\" class=\"form-control\" />\n");
      out.write("            Departamento<select name=\"id_depto\" id=\"id_depto\" class=\"form-control\">\n");
      out.write("                ");

                    List<Departamento> dep=new ArrayList<Departamento>();
                    dep.addAll((Collection)request.getAttribute("depto"));
                    for(Departamento d:dep){
                       out.println("<option value='"+d.getId_depto()+"'>"+
                               d.getNombre()+"</option>");
                    
                    }
                
      out.write("\n");
      out.write("            </select><br>\n");
      out.write("            <input type=\"reset\" onclick=\"$('#g').attr('disabled',false)\" value=\"Nuevo\" name=\"nuevo\" class=\"btn btn-success\"/>\n");
      out.write("            <input type=\"submit\" disabled=\"true\" id=\"g\" value=\"Guardar\" name=\"insertar\" class=\"btn btn-success\"/>\n");
      out.write("            <input type=\"submit\" value=\"Modificar\" name=\"modificar\" class=\"btn btn-success\"/>\n");
      out.write("            <input type=\"submit\" value=\"Eliminar\" name=\"eliminar\" class=\"btn btn-success\"/>\n");
      out.write("        </form>\n");
      out.write("            <table class=\"table table-success\">\n");
      out.write("                <tr><th>ID</th><th>Nombre</th><th>Tel</th><th>Depto</th><th>Accion</th></tr>\n");
      out.write("                ");

                  List<Empleado> em=new ArrayList<Empleado>();
                  em.addAll((Collection)request.getAttribute("emple"));
                  for(Empleado e:em){
                    out.println("<tr><td>"+e.getId_emp()+"</td><td>"
                            + ""+e.getNombre()+"</td><td>"+e.getTelefono()+"</td>"
                            + "<td>"+e.getDepto().getNombre()+"</td><td>"
                            + "<input value='Editar' class='btn btn-warning'"
                            + " type='button' onclick=$('#id_emp').val('"+e.getId_emp()+"');"
                            + "$('#nombre').val('"+e.getNombre().replace(" ","&nbsp;")+"');"
                            + "$('#telefono').val('"+e.getTelefono()+"')"
                            + ";$('#id_depto').val('"+e.getDepto().getId_depto()+"')></td><tr>");
                  }
                
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("        </div>    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
