package jc82_yw31.GameApi;
/**
 * game model adapter 
 * using for communicate between the client and the server
 * @author Administrator
 *
 */
public interface GameModelAdpt {
	/**
	 * check the answer of the client
	 * @param selection is the selection the client choose
	 * @return
	 */
	public boolean check(int selection);
	/**
	 * get new question 
	 * @return the new question to clients
	 */
	public String getNewQuestion();
	/**
	 * client send answer to server 
	 * @param distance 
	 */
	public void sendAnswerToServer(int distance);
	/**
	 * pop new question to client 
	 * @param index is the index of the new question 
	 * @return
	 */
	public String popNewQuestion(int index);
	/**
	 * get answer of the question 
	 * @param index of the question clients want to get answer
	 * @return
	 */
	public int getAnswer(int index);
	/**
	 * get the end of the problem set
	 * @return the size of the problem set
	 */
	public int getEnd();
	/**
	 * get the team number of the team 
	 * @return the team number
	 */
	public int getTeamNo();
	/**
	 * answer the question 
	 */
	public void answerOneQuestion();
}
