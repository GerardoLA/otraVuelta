package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Parcela;
import modelo.ParcelaModelo;
import modelo.Reserva;
import modelo.ReservaModelo;

/**
 * Servlet implementation class ConfirmarReserva
 */
@WebServlet("/AlmacenarReserva")
public class AlmacenarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlmacenarReserva() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO implementar la funcionalidad de almacenar reserva
		//se abrirá la vista infoReserva
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ReservaModelo rm = new ReservaModelo();
	Reserva reserva = new Reserva();
	reserva.setNombre_usuario(request.getParameter("nombre_usuario"));
	reserva.setApellido_usuario(request.getParameter("apellido_usuario"));
	reserva.setDni_usuario(request.getParameter("dni_usuario"));
	reserva.setNumero_usuarios(Integer.parseInt(request.getParameter("numero_usuarios")));
	Date inicio_reserva=null;
	Date fin_reserva=null;
	try {
		inicio_reserva = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("inicio_reserva"));
		fin_reserva = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fin_reserva"));
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	reserva.setInicio_reserva(inicio_reserva);
	reserva.setFin_reserva(fin_reserva);
	if (request.getParameter("luz")==null) {
		reserva.setLuz(false);
	}else {
		reserva.setLuz(true);
	}
	rm.insertarReserva(reserva);

	}
	
}
