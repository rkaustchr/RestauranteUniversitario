package roteiros;

import java.util.ArrayList;
import entidades.Consumidor;
import gateway.ConsumidorGateway;

public class RoteiroListarConsumidor  {

	public ArrayList<Consumidor> executar() throws Exception {
		ConsumidorGateway gConsumidor = new ConsumidorGateway();
		
		return gConsumidor.listarConsumidores();
		
	}

}
