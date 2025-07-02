<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Consulta de citas por cédula</title>
    <link rel="stylesheet" href="/ips_unipersonal/css/styles.css">
</head>
<body>
    <header>
        <h1>IPS Salud Integral</h1>
        <p>Atención profesional, ética y personalizada en el cuidado de tu salud</p>
    </header>
    <div class="container">
        <section>
            <h2>Consulta de citas por cédula</h2>
            <p>Ingresa un número de cédula para verificar las citas agendadas.</p>
            <form action="/ips_unipersonal/BuscarCedula" method="post">
                <label for="cedula">Cédula:</label><br><br>
                <input type="text" id="cedula" name="cedula" required><br><br>
                <button type="submit" class="boton">Consultar citas</button>
            </form>
            <%@ page import="com.ips.model.Citas" %>
            <%@ page import="java.util.ArrayList" %>
            <%
                ArrayList<Citas> lista = (ArrayList) request.getAttribute("citas");
                if (lista != null) {
            %>
            <div style="background:#f0f8ff; border:1.5px solid #00b4db; border-radius:8px; max-width:620px; margin:2rem auto; padding:2rem; box-shadow:0 2px 8px rgba(0,180,219,0.08); text-align:center;">
                <p style="font-size:1.15rem; color:#0083b0; margin-bottom:2rem;">
                    Citas agendadas para la cédula ingresada:<br><br>
                    <table>
                        <tr>
                            <th> # </th>
                            <th>Fecha</th>
                            <th>Hora</th>
                            <th>Servicio</th>
                        </tr>
                    <%
                    Integer i=0;
                    for (Citas c : lista) {
                        i+=1;
                        String h = c.getHora();
                        String f = c.getFecha().toString();
                        String s = c.getServicio();
                    %>
                    <tr>
                       <td><%= i.toString() %></td>
                       <td><%= f %></td>  
                       <td><%= h %></td> 
                       <td><%= s %></td>
                    </tr>
                    <%
                        }
                    %>
                    </table><br><br>
                </p>
            </div>
            <%
                }
             
                String msj = (String) request.getAttribute("mensaje");
                if (msj != null) {
            %>
            <div style="background:#f0f8ff; border:1.5px solid #00b4db; border-radius:8px; max-width:620px; margin:2rem auto; padding:2rem; box-shadow:0 2px 8px rgba(0,180,219,0.08); text-align:center;">
                <p style="font-size:1.15rem; color:#0083b0; margin-bottom:2rem;">
                     <%= msj %>
                </p>
            </div>
            <%
                }
            %>
            <br><br>
            <a href="/ips_unipersonal/index.html" class="boton">
                Volver al inicio
            </a>
            <br><br>
        </section>
    </div>
    <footer>
        &copy; 2025 IPS Salud Integral. Todos los derechos reservados.
    </footer>
</body>
</html>