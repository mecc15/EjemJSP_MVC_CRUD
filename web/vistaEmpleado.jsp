<%-- 
    Document   : vistaEmpleado
    Created on : 24-Jan-2020, 10:26:31
    Author     : mecc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="empre.Entidades.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="jquery.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="sweetalert2.all.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
        <script>
            $(document).ready(function(){
                $('#del').click(function(){
                    Swal.fire({
                        type:"warning",
                        title:"Eliminar Registro",
                        text:"Despues de eliminar no se podra recuperar registro",
                        showCancelButton:true,
                        cancelButtonColor:"red",
                        cancelButtonText:"Cancelar",
                        confirmButtonText:"Si, Eliminar",
                        confirmButtonColor:"green"
                   }).then((result)=>{
                       if(result.value){
                           $('#ht').append("<input type='hidden' name='eliminar'>");
                           $('#f1').submit();
                       }
                   });
                });
                
            });
        </script>
    </head>
    <body>
        <h1>CRUD EMPLEADOS!</h1>
        <%
              if(request.getAttribute("emple")==null)
                 response.sendRedirect("ControlEmpleado?m1=1");
              else{
        %>
        <div class="col-md-5"> 
            <form name="f1" id="f1" action="ControlEmpleado"><div id="ht"></div>
            Id<input type="text" name="id_emp" id="id_emp" value="" class="form-control" />
            Nombre<input type="text" name="nombre" id="nombre" value="" class="form-control" />
            Telefono<input type="text" name="telefono" id="telefono" value="" class="form-control" />
            Departamento<select name="id_depto" id="id_depto" class="form-control">
                <%
                    List<Departamento> dep=new ArrayList<Departamento>();
                    dep.addAll((Collection)request.getAttribute("depto"));
                    for(Departamento d:dep){
                       out.println("<option value='"+d.getId_depto()+"'>"+
                               d.getNombre()+"</option>");
                    
                    }
                %>
            </select><br>
            <input type="reset" onclick="$('#g').attr('disabled',false)" value="Nuevo" name="nuevo" class="btn btn-success"/>
            <input type="submit" disabled="true" id="g" value="Guardar" name="insertar" class="btn btn-success"/>
            <input type="submit" value="Modificar" name="modificar" class="btn btn-success"/>
            <input type="button" id="del" value="Eliminar" name="eliminar" class="btn btn-success"/>
        </form>
            <table class="table table-success">
                <tr><th>ID</th><th>Nombre</th><th>Tel</th><th>Depto</th><th>Accion</th></tr>
                <%
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
                 
                %>
                
                
            </table>
        </div>   
                <% }

                  if(request.getAttribute("r")!=null)
                     out.println("<script>Swal.fire('Confirmacion','"+request.getAttribute("r")+"','info')</script>");
                  if(request.getAttribute("error")!=null)
                     out.println("<script>Swal.fire('Error','"+request.getAttribute("error")+"','info')</script>");
                
                %>
    </body>
</html>
