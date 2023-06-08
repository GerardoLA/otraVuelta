package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Parcela;
import modelo.ParcelaModelo;

/**
 * Servlet implementation class IniciarReserva
 */
@WebServlet("/IniciarReserva")
public class IniciarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarReserva() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString= request.getParameter("id");
		
		if(idString != null) {//azterketako iniciar reserva
			ParcelaModelo pm = new ParcelaModelo();
			Parcela parcela = pm.getParcela(Integer.parseInt(idString));
			
			request.setAttribute("parcela", parcela);
			request.getRequestDispatcher("formReserva.jsp").forward(request, response);
			
		}else {//iniciar reserva berria
			request.getRequestDispatcher("formReservaSinParcela.jsp").forward(request, response);
		}


//		ParcelaModelo pm = new ParcelaModelo();
//		Parcela parcela = pm.getParcela(id);
//		
//		request.setAttribute("parcela", parcela);
//		request.getRequestDispatcher("formReserva.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
