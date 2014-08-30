package jc82_yw31.Server.rmi.Commands;

import java.rmi.RemoteException;

import comp310f13.rmiChat.IStatusOk;

import jc82_yw31.GameApi.GameController;
import jc82_yw31.Server.MiniModel.SetTeamNo;
import jc82_yw31.Server.MiniModel.StatusOK;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import provided.mixedData.MixedDataKey;

/**
 * this is cmd is used to set teamNo to each player in the game
 * @author junren
 *
 */
public class SetTeamNoCmd extends ADataPacketAlgoCmd<ADataPacket, SetTeamNo, Void> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8835648878382653902L;
	private transient ICmd2ModelAdapter cmd2ModelAdapter;

	public SetTeamNoCmd(){
		
	}
	@Override
	public ADataPacket apply(Class<?> index, DataPacket<SetTeamNo> host,
			Void... params) {
		MixedDataKey<GameController> gamecontrol = null;
		try {
			gamecontrol = new MixedDataKey<GameController>(
					host.getSender().getUUID(), "gameController", GameController.class);
		} catch (RemoteException e) {
			System.err.println("can not generate mixdatakey: gamecontrol in movecmd");
			e.printStackTrace();
		}
		cmd2ModelAdapter.getDataDict().get(gamecontrol).getModel().setTeamNO(host.getData().getTeamNo());
		cmd2ModelAdapter.getDataDict().get(gamecontrol).getFrame().setTeamNo(host.getData().getTeamNo());
		return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		cmd2ModelAdapter = cmd2ModelAdpt;
		
	}

}
