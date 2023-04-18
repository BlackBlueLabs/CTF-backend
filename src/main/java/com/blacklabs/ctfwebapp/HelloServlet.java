package com.blacklabs.ctfwebapp;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String massage;

    public void init() {
        message = "Hello World!";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Execute the command
        String inp  = request.getParameter("command");

        if(!(inp.equals("-h") || (inp.equals("-l") || (inp.equals("-f"))))){
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<head>\n" +
            "<meta http-equiv = \"refresh\" content = \"2; url = https://hacking-ctf0x1-fils.herokuapp.com/CTF-WebApp-1.0-SNAPSHOT/\" />" +
                        "<title>CTF Hacking the command</title>\n" +
                        "</head>");
            out.println("<h1>Invalid input</h1>");


            return;
        }

        String commands = "ls " + inp;
        String output = "";
        try {
            Process p = Runtime.getRuntime().exec(commands);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<head>\n" +
                        "<title>CTF Hacking the command</title>\n" +
                        "</head>");
            out.println("<h1>Output</h1>");
            String line = "";
            while ((line = reader.readLine()) != null) {
                out.println(line + " ");
                // New line
                out.println("<br>");
            }
            out.println("</body></html>");
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<head>\n" +
                        "<title>CTF Hacking the command</title>\n" +
                        "</head>");

            out.println("<h1>Output Error</h1>");
            out.println(e.getMessage());
            out.println("</body></html>");
        }
    }

    public void doOptions(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "do options" + "</h1>");
        out.println("</body></html>");
    }

    public void doHead(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        massage = "xxx.com/xxx";
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<a href=\""+massage+"\">" + massage + "</a>");
        out.println("</body></html>");
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "do options" + "</h1>");
        out.println("</body></html>");
    }

    public void doTrace(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" +"Trace" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}