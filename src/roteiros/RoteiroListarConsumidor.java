package roteiros;

import java.util.ArrayList;
import entidades.Consumidor;
import gateway.GatewayConsumidor;

public class RoteiroListarConsumidor  {

	public ArrayList<Consumidor> executar() throws Exception {
		GatewayConsumidor gConsumidor = new GatewayConsumidor();
		
		return gConsumidor.listarConsumidores();
		
	}

}
