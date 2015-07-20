package gateway;

import java.util.ArrayList;

public interface IFinder {
	public ArrayList<IGateway> findAll();
	public IGateway find(String id);
}
