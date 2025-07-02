<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Consultar disponibilidad por fecha</title>
    <link rel="stylesheet" href="/ips_unipersonal/css/styles.css">
</head>
<body>
    <header>
        <h1>IPS Salud Integral</h1>
        <p>Atención profesional, ética y personalizada en el cuidado de tu salud</p>
    </header>
    <div class="container">
        <section>
            <h2>Consultar disponibilidad por fecha</h2>
            <p>Selecciona una fecha para ver los horarios disponibles y agendar tu cita.</p>
            <form action="/ips_unipersonal/Disponibilidad" method="post">
                <label for="fecha">Fecha:</label><br><br>
                <input type="date" id="fecha" name="fecha" required><br><br>
                <button type="submit" class="boton">Consultar disponibilidad</button>
            </form>

            <%@ page import="java.util.ArrayList" %>
            <%
                ArrayList<String> lista = (ArrayList) request.getAttribute("horarios");
                if (lista != null) {
            %>
            <div style="background:#f0f8ff; border:1.5px solid #00b4db; border-radius:8px; max-width:620px; margin:2rem auto; padding:2rem; box-shadow:0 2px 8px rgba(0,180,219,0.08); text-align:center;">
                <p style="font-size:1.15rem; color:#0083b0; margin-bottom:2rem;">
                    Horarios disponibles para la fecha seleccionada:<br><br>
                    <%
                    for (String h : lista) {
                    %>
                        - <%= h %><br>
                    <%
                        }
                    %>
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