package jc82_yw31.Server.MiniModel;

import java.util.UUID;

/**
 * The adapter the minimodel uses to communicate witht the main model.
 * 
 * @author Yunhao
 */
public interface MainModelAdapter {
	/**
	 * calls back to the main model to access the UUID of the local machine
	 * @return UUID of the local machine
	 */
	public UUID getUUID();
	/**
	 * calls back to the main model to access the name of the local machine
	 * @return the name of the local machine
	 */
	public String getName();

}
