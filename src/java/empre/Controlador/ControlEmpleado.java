/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empre.Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import empre.Entidades.*;
import empre.Modelo.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author mecc
 */
public class ControlEmpleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           RequestDispatcher res;
           DaoEmpleado de=new DaoEmpleado();
           DaoDepartamento dt=new DaoDepartamento();
           Empleado emp;
           Departamento dep;
           
           if(request.getParameter("m1")!=null){
               try {
                  request.setAttribute("emple",de.mostrar()); 
                  request.setAttribute("depto",dt.mostrar()); 
               } catch (Exception e) {
                   request.setAttribute("error", e.getMessage());
               }
               
           }
           
            if(request.getParameter("insertar")!=null){
               try {
                  dep=new Departamento(Integer.valueOf(request.getParameter("id_depto")));
                  emp=new Empleado(request.getParameter("nombre"),
                          request.getParameter("telefono"), dep);
                  if(de.insertar(emp)>0)
                      request.setAttribute("r","Registro guardado Correctamente");
                  else
                      request.setAttribute("r","Fallo guardar registro");
                  request.setAttribute("emple",de.mostrar()); 
                  request.setAttribute("depto",dt.mostrar()); 
               } catch (Exception e) {
                   request.setAttribute("error", e.getMessage());
               }
               
           }
            
           if(request.getParameter("modificar")!=null){
               try {
                  dep=new Departamento(Integer.valueOf(request.getParameter("id_depto")));
                  emp=new Empleado(Integer.valueOf(request.getParameter("id_emp")),
                          request.getParameter("nombre"),
                          request.getParameter("telefono"), dep);
                  if(de.modificar(emp)>0)
                      request.setAttribute("r","Registro modificado Correctamente");
                  else
                      request.setAttribute("r","Fallo modificar registro");
                  request.setAttribute("emple",de.mostrar()); 
                  request.setAttribute("depto",dt.mostrar()); 
               } catch (Exception e) {
                   request.setAttribute("error", e.getMessage());
               }
               
           }
           
           if(request.getParameter("eliminar")!=null){
               try {
                  emp=new Empleado(Integer.valueOf(request.getParameter("id_emp")));
                  if(de.eliminar(emp)>0)
                      request.setAttribute("r","Registro eliminado Correctamente");
                  else
                      request.setAttribute("r","Fallo eliminar registro");
                  request.setAttribute("emple",de.mostrar()); 
                  request.setAttribute("depto",dt.mostrar()); 
               } catch (Exception e) {
                   request.setAttribute("error", e.getMessage());
               }
               
           }
           
           res=request.getRequestDispatcher("vistaEmpleado.jsp");
           res.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
