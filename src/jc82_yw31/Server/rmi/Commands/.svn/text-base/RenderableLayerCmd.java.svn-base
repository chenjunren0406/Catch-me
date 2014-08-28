package jc82_yw31.Server.rmi.Commands;

import jc82_yw31.Server.MiniModel.StatusOK;

import comp310f13.rmiChat.IStatusOk;

import gov.nasa.worldwind.layers.RenderableLayer;
import map.MapPanel;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;

public class RenderableLayerCmd extends ADataPacketAlgoCmd<ADataPacket, RenderableLayer, Void>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4240318566418918124L;
	private transient ICmd2ModelAdapter cmd2ModelAdapter;
	public RenderableLayerCmd(){
		
	}
	public ADataPacket apply(Class<?> index, DataPacket<RenderableLayer> host,
			Void... params) {
		MapPanel panel = new MapPanel();
		panel.addMapLayer(host.getData());
		cmd2ModelAdapter.addComponent("Junren", panel);
		return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter =  cmd2ModelAdpt;		
		
	}

}
