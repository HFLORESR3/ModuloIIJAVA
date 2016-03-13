/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upao.controller;

import com.upao.dto.Producto;
import com.upao.dto.Usuario;
import com.upao.service.CarritoService;
import com.upao.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Upao
 */
//Mapeo de URL en un SERVLETS
@WebServlet({"/Login","/GetLista","/AddProducto","/mno"})
public class AppController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String path=request.getServletPath();
        
        switch(path){
            case "/Login":
                login(request, response);
                break;
            case "/AddProducto":
                addProducto(request, response);
                break;
        }
    }
    
    protected void addProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Datos Producto
        Producto prod=new Producto();
        prod.setNombre(request.getParameter("nombre"));
        prod.setPrecio(Double.parseDouble(request.getParameter("precio")));
        prod.setCant(Integer.parseInt(request.getParameter("cant")));
        
        //Obtener carrito sesion
        HttpSession session=request.getSession();
        session.getId();
        CarritoService carrito;
        if(session.getAttribute("carrito")!=null){
            carrito=(CarritoService)session.getAttribute("carrito");
        }else{
            carrito=new CarritoService();
        }
        //Agregar producto a carrito
        carrito.agregar(prod);
        //Guardar el carrito
        session.setAttribute("carrito", carrito);
        
        //forward (1) - sendRedirect(2)- Mecanismos de como comunicar
        //Servlet-Servlet, Servlet-JSP
        RequestDispatcher rd;
        rd=request.getRequestDispatcher("addProducto.jsp");
        request.setAttribute("mensaje", "Proceso ok.");
        rd.forward(request, response);        
    }
    
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destino;
        try {
            //Datos
            Usuario usuario=new Usuario();
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setNombre(request.getParameter("apellido"));
            //Validar
            UsuarioService service=new UsuarioService();
            service.validar(usuario);
            HttpSession session=request.getSession();
            session.setAttribute("usuario", usuario);
            //Destino
            destino="main.jsp";
            
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destino="index.jsp";
        }
        RequestDispatcher rd;
        rd=request.getRequestDispatcher(destino);        
        rd.forward(request, response);   
        
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
