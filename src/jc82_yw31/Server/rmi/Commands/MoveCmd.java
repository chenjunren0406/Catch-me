package jc82_yw31.Server.rmi.Commands;

import java.rmi.RemoteException;

import comp310f13.rmiChat.IStatusOk;
import jc82_yw31.GameApi.GameController;
import jc82_yw31.Server.MiniModel.MoveSteps;
import jc82_yw31.Server.MiniModel.StatusOK;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import provided.mixedData.MixedDataKey;

/**
 * This is cmd to move your sign one step forward in the map
 * @author Junren
 *
 */
public class MoveCmd extends ADataPacketAlgoCmd<ADataPacket, MoveSteps, Void>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2210576602498333568L;
	
	private transient ICmd2ModelAdapter cmd2ModelAdapter;
	@Override
	public ADataPacket apply(Class<?> index, DataPacket<MoveSteps> host,
			Void... params) {
		MixedDataKey<GameController> gamecontrol = null;
		try {
			gamecontrol = new MixedDataKey<GameController>(
					host.getSender().getUUID(), "gameController", GameController.class);
		} catch (RemoteException e) {
			System.err.println("can not generate mixdatakey: gamecontrol in movecmd");
			e.printStackTrace();
		}
		cmd2ModelAdapter.getDataDict().get(gamecontrol).getFrame().getMap().move(
				host.getData().getTeamNO(),host.getData().getdistance());
		return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
	
		this.cmd2ModelAdapter = cmd2ModelAdpt;
	}

}
