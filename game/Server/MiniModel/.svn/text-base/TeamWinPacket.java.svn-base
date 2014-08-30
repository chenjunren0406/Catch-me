package jc82_yw31.Server.MiniModel;

import java.io.Serializable;

/**
 * when there is team win, server will send these packet to all other client
 * @author Junren
 *
 */
public class TeamWinPacket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2030595811821341403L;
	
	/**
	 * which team win
	 */
	private int teamwin;
	
	/**
	 * constructor
	 * @param teamwin which team win
	 */
	public TeamWinPacket(int teamwin){
		this.teamwin = teamwin;
	}
	
	/**
	 * get the win teamNO
	 * @return teamNO
	 */
	public int getWinTeamNo(){
		return teamwin;
	}
}