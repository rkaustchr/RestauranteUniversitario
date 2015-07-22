package gateway;

import controladores.exceptions.CpfAlreadyExistsException;

public interface IGateway {
		/**
		 *  Substituir retornos para boolean e remover delete
		 * @return TODO
		 * 
		 */
		public boolean insert();
		public void delete();
		public void update();
}
