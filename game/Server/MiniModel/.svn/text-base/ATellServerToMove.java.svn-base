package jc82_yw31.Server.MiniModel;

import java.io.Serializable;

/**
 * If someone of the game answer right oen question, he will send this packet to tell server
 * @author Junren
 *
 */
public class ATellServerToMove implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6679921214205107052L;
	private int TeamNO;
	private int distance;
	
	/**
	 * constructor
	 * @param distance
	 * @param TeamNO
	 */
	public ATellServerToMove(int distance, int TeamNO){
		this.distance = distance;
		this.TeamNO = TeamNO;
	}
	
	/**
	 * get teamNO
	 * @return teamNo
	 */
	public int getTeamNO(){
		return TeamNO;
	}
	
	/**
	 * get distance
	 * @return number of right question
	 */
	public int getdistance(){
		return distance;
	}
}
