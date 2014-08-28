package jc82_yw31.Server.rmi.Commands;

import java.rmi.RemoteException;

import comp310f13.rmiChat.IStatusOk;
import jc82_yw31.GameApi.GameController;
import jc82_yw31.Server.MiniModel.StatusOK;
import jc82_yw31.Server.MiniModel.TeamWinPacket;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import provided.mixedData.MixedDataKey;

/**
 * this cmd will pop up an window to show who win the game
 * @author chen
 *
 */
public class WinOrLoseCmd extends ADataPacketAlgoCmd<ADataPacket,TeamWinPacket , Void>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5674704554885870490L;
	private transient ICmd2ModelAdapter cmd2ModelAdapter;
	
	@Override
	public ADataPacket apply(Class<?> index, final DataPacket<TeamWinPacket> host,
			Void... params) {
		
		new Thread(){
			public void run(){
				MixedDataKey<GameController> gamecontrol = null;
				try {
					gamecontrol = new MixedDataKey<GameController>(
							host.getSender().getUUID(), "gameController", GameController.class);
				} catch (RemoteException e) {
					System.err.println("can not generate mixdatakey: gamecontrol in movecmd");
					e.printStackTrace();
				}
				cmd2ModelAdapter.getDataDict().get(gamecontrol).getFrame().ShowWhichTeamWin(host.getData().getWinTeamNo());
			}
		}.start();
	
		return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		
		this.cmd2ModelAdapter = cmd2ModelAdpt;
	}

}
