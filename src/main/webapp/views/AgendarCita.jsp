<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Agendar cita</title>
    <link rel="stylesheet" href="/ips_unipersonal/css/styles.css">
</head>
<body>
    <header>
        <h1>IPS Salud Integral</h1>
        <p>Atención profesional, ética y personalizada en el cuidado de tu salud</p>
    </header>
    <div class="container">
        <section>
            <h2>Agendar Cita</h2>
            <p>Ingresa tus datos para agendar la cita.</p>
            <form action="/ips_unipersonal/Agendar" method="post">
                <label for="nombre">Nombre:</label><br><br>
                <input type="text" id="nombre" name="nombre" required><br><br>

                <label for="cedula">Cédula:</label><br><br>
                <input type="text" id="cedula" name="cedula" required><br><br>

                <label for="telefono">Teléfono:</label><br><br>
                <input type="text" id="telefono" name="telefono" required><br><br>

                <label for="hora">Hora de la cita:</label><br><br>
                <select id="hora" name="hora" required>
                    <%@ page import="java.util.ArrayList" %>
                    <%
                        ArrayList<String> lista = (ArrayList) request.getAttribute("horarios");
                        for (String h : lista) {
                    %>
                        <option value="<%= h %>"><%= h %></option>
                    <%
                        }
                    %>

                </select><br><br>
                <%
                    String fecha = (String) request.getAttribute("fecha");
                %>
                <input type="date" id="fecha" name="fecha" value="<%= fecha %>"style="display:none;" required>
                <label for="servicio">Seleccione el servicio que requiere:</label><br><br>
                <select id="servicio" name="servicio" required>
                    <option value="Consulta medica general">Consulta médica general</option>
                    <option value="Control de enfermedades cronicas">Control de enfermedades crónicas</option>
                    <option value="Certificado medico">Certificado médico</option>
                    <option value="Teleconsulta">Teleconsulta</option>
                </select><br><br>

                <label for="email">Email:</label><br><br>
                <input type="text" id="email" name="email"><br><br>

                <button type="submit" class="boton">Agendar cita</button>
            </form>
            <br><br>
            <a href="/ips_unipersonal/AgendarFecha.jsp"  class="boton">
                Volver
            </a>
            <br><br>
        </section>
    </div>
    <footer>
        &copy; 2025 IPS Salud Integral. Todos los derechos reservados.
    </footer>
</body>
</html>