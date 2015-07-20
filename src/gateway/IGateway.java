package gateway;

import entidades.Curso;

public interface IGateway {
		/**
		 *  Substituir retornos para boolean e remover delete
		 */
		public void insert();
		public void delete();
		public void update();
}
