/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Dao;
import model.Filme;
import model.Locacao;

/**
 *
 * @author adao
 */
@WebServlet(name = "Servlet01", urlPatterns = {"/Servlet01"})
public class Servlet01 extends HttpServlet {
    Dao dao = new Dao();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"pt-br\">");
            out.println("<head>");
            out.println("<title>Locadora</title>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<style>\n" +
                        "      .tela{\n" +
                        "        position:absolute;\n" +
                        "        left:50%;\n" +
                        "        top:50%;\n" +
                        "        height:50px;\n" +
                        "        width:225px;\n" +
                        "        text-align:center;\n" +
                        "        padding:10px 0px 0px 0px;\n" +
                        "        margin:-115px 0px 0px -112px;\n" +
                        "      }\n" +
                        "\n" +
                        "      .btn1{\n" +
                        "        height: 30px;\n" +
                        "        width: 200px;\n" +
                        "      }\n" +
                        "\n" +
                        "      #novaLocacao{\n" +
                        "        display: none;\n" +
                        "      }\n" +
                        "\n" +
                        "      #paginaInicial{\n" +
                        "        display: block;\n" +
                        "      }\n" +
                        "\n" +
                        "      #consulta{\n" +
                        "        display: none;\n" +
                        "      }\n" +
                   "    </style>");
            
            out.println("<body>");
            out.println("<div class=\"tela\" id=\"paginaInicial\">\n" +
                        "      <h1 id=\"tituloPaginaInicial\">Netflix</h1>\n" +
                        "      <p><button class=\"btn1\" type=\"button\" name=\"novaLocação\" onclick=\"novaLocacao()\">Nova Locação</button></p>\n" +
                        "      <p><button class=\"btn1\" type=\"button\" name=\"consultas\" onclick=\"consultarLocacoes()\">Consultar Locaçoes</button></p>\n" +
                        "    </div>\n" +
                        "    <div class=\"tela\" id=\"novaLocacao\">\n" +
                        "      <h1>Nova Locacao</h1>\n" +
                        "      <form  action=\"\" method=\"get\">\n" +
                        "           <p>ID do cliente: <input type=\"text\" required=\"required\" name=\"idDoCliente\" pattern=\"[0-9]+$\" />\n" +
                        //"           <button type=\"submit\" class=\"localizar\">localizar</button>\n" +
                        "           </p>\n" +
                        //"       </form>" +
                        "\n" +
                        //"        <p><span id=\"nomeDoCliente\"></span></p><!--implementar metodo que retorna o cliente-->\n" +
                        "\n" +
                        "        <p>ID do filme: <input type=\"text\" required=\"required\" name=\"idDoFilme\" pattern=\"[0-9]+$\" />\n" +
                        //"          <button type=\"button\" class=\"localizar\">localizar</button>\n" +
                        "        </p>\n" +
                        "\n" +
                        //"        <p><span id=\"nomeDoFilme\"></span></p><!--implementar metodo que retorna o filme-->\n" +
                        "\n" +
                        "        <button type=\"submit\" name=\"concluir\">Registrar locação</button>\n" +
                        "      </form>\n" +
                        "    </div>\n" +
                        "    <div class=\"tela\" id=\"consulta\">\n" +
                        "      <h1>consultas</h1>\n" +
                        //listar locacoes
                        "    </div>");
            out.println("<script>\n" +
                        "      function novaLocacao(){\n" +
                        //"        alert(\"nova locacao\");\n" +
                        "        mudaDePagina(\"paginaInicial\", \"novaLocacao\");\n" +
                        "      }\n" +
                        "\n" +
                        "      function consultarLocacoes(){\n" +
                        "        mudaDePagina(\"paginaInicial\", \"consulta\");\n" +
                        //"        alert(\"consultas\");\n" +
                        "      }\n" +
                        "\n" +
                        "      function mudaDePagina(atual, nova){\n" +
                        "        document.getElementById(atual).style.display = 'none';\n" +
                        "        document.getElementById(nova).style.display = 'block';\n" +
                        "      }\n" +
                        "" +
                        "" +
                        "" +
                        "    </script>");
            out.println("");
            out.println("");
            out.println("");
            out.println("");
            int idCliente = Integer.parseInt(request.getParameter("idDoCliente"));
            Cliente c = dao.findClient(idCliente);
            int idFilme = Integer.parseInt(request.getParameter("idDoFilme"));
            Filme f = dao.findFilme(idFilme);
            Locacao l = new Locacao(c, f);
            dao.registraLocacao(l);
            /*
            String procuraCliente(){
                // recupera o conteúdo digitado na caixa de texto
                int id = Integer.parseInt(request.getParameter("idDoCliente"));
                String x = "não encontrado";
                //out.println(String.format("Olá, %s, seja bem-vindo!", strTexto));
                if (dao.findClient(id)!=null){
                    Cliente z = dao.findClient(id);
                    x = z.getNome();
                }
                return x;
            }
            */
            
            
            out.println("</body>");
            out.println("</html>");
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
