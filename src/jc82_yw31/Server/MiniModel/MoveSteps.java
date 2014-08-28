package jc82_yw31.Server.MiniModel;

import java.io.Serializable;

public class MoveSteps implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8970624820871818029L;
	private int distance;
	private int teamNO;
	
	public MoveSteps(int distance, int teamNO){
		this.distance = distance;
		this.teamNO = teamNO;
	}
	
	public int getdistance(){
		return distance;
	}
	public int getTeamNO(){
		return teamNO;
	}
}

