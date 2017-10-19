/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidaSesionesServlet extends HttpServlet {
   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

      response.setContentType("text/html");
      HttpSession sesion = request.getSession();
      String titulo = null;

      //Pedimos el atributo, y verificamos si existe
      String claveSesion = (String) sesion.getAttribute("claveSesion");
      PrintWriter out = response.getWriter();
      if(claveSesion.equals("emmanueloropeza")){
        titulo = "llave correcta continua la sesion";
        out.println("<a href=\"/EjemploSession/exito.html\"> Continuar  </a><br>");
      }
      else
      {
        titulo = "llave incorrecta inicie nuevamente sesion";
        out.println("<a href=\"/EjemploSession/error.html\"> Continuar  </a><br>");
      }


      //Mostramos los  valores en el cliente
     
      out.println("¿Continua la Sesion y es valida?: " + titulo);
      out.println("<br>");
      out.println("ID de la sesi&oacute;n JSESSIONID: " + sesion.getId());
  
    }

}
