package jc82_yw31.GameApi;

import comp310f13.rmiChat.IUser;
/**
 * Game controller which control the game for every client
 * @author Junren
 *
 */
public class GameController {
	private GameFrame gameFrame;
	private GameModel gameModel;
	/**
	 * The constructor of GameController
	 * @param serverStub the server stub
	 * @param clientStub the client stub
	 * new a game model using a game view adapter
	 * new a game frame using a game model adapter
	 * in the game view adapter, rewrite the method  of append
	 * in the game model adapter, rewrite the method of send a answer to server
	 * popnew questions, get answer,and get team number
	 * 
	 */
	public GameController(IUser serverStub,IUser clientStub){
		gameModel = new GameModel(new GameViewAdpt() {

			public void append(String s) {
				gameFrame.append(s);
				
			}
		},serverStub) {
		};
		gameFrame = new GameFrame(new GameModelAdpt() {
			
			@Override
			public String getNewQuestion() {
				
				return null;
			}
			
			public boolean check(int selection) {
				
				return gameModel.check(selection);
			}

			@Override
			public void sendAnswerToServer(int distance) {
				gameModel.sendAnswerToServer(distance);
				
			}


			public String popNewQuestion(int index) {
				return gameModel.popNewQuestion(index);
			}

			public int getAnswer(int index) {
				return gameModel.getAnswer(index);
			}


			public int getEnd() {
				return gameModel.getEnd();
			}

			@Override
			public int getTeamNo() {
				return gameModel.getTeamNo();
			}

			@Override
			public void answerOneQuestion() {
				
				gameModel.alreadyAnsweredQuestion();
			}
		});
		

	}
	
	/**
	 * get the view
	 * @return the game frame
	 */
	public GameFrame getFrame(){
		return gameFrame;
	}
	
	/**
	 * get the model
	 * @return the game model
	 */
	public GameModel getModel(){
		return gameModel;
	}
	/**
	 * the start method 
	 * in this start method, start the game model
	 * start the game frame
	 */
	public void start(){
		gameModel.start();
		gameFrame.start();
	}
}
