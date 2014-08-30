package jc82_yw31.GameApi;

import java.rmi.RemoteException;
import java.util.ArrayList;

import provided.datapacket.DataPacket;
import jc82_yw31.Server.MiniModel.ATellServerToMove;
import jc82_yw31.Server.MiniModel.AnswerQuestionPacket;
import comp310f13.rmiChat.IUser;
/**
 * the game model class
 * the model class has a game frame adapter
 * the model class has a arraylist of questions
 * the model class has a serverstub
 * the model class has a team number	
 * @author Administrator
 *
 */
public class GameModel {
	@SuppressWarnings("unused")
	private GameViewAdpt gameFrameAdpt;
    @SuppressWarnings("unused")
	private ArrayList<String> questions = new ArrayList<String>();
    private IUser serverStub;
    private ArrayList<Problem> problemSet = new ArrayList<Problem>();
    private int teamNO;
    /**
     * constructor
     * @param gameFrameAdpt is the game frame adapter
     * @param serverstub is the server stub
     */
    public GameModel(GameViewAdpt gameFrameAdpt,IUser serverStub){
    	this.gameFrameAdpt = gameFrameAdpt;
    	this.serverStub = serverStub;
    	Init();
    }
    
    /**
     * the initial method 
     * initialize the problem set(which is the arraylist of problems)
     */
    public void Init(){
    	String problemContent1 = new String("what's the name of the president of America" + "\n" + "1.Barack Hussein Obama II" + "\n" +  "2.Abraham Hussein Obama II" + "\n" + "3.Barack Benjamin Obama III" + "\n" + "4.Joseph Benjamin Obama III");
    	int answer1 = 1;
    	Problem problem1 = new Problem(problemContent1, answer1);
    	this.problemSet.add(problem1);
    	
    	String problemContent2 = new String("which is not a design pattern" + "\n" + "1.Proxy Pattern" + "\n" + "2.Singleton Pattern" + "\n" + "3.ArrayList Pattern" + "\n" + "4.Decorator Pattern");
    	int answer2 = 3;
    	Problem problem2 = new Problem(problemContent2, answer2);
    	this.problemSet.add(problem2);
    	
    	String problemContent3 = new String("Dandelion mainly seeds based on which kind of power ? ");
    	problemContent3 = problemContent3.concat("\n" + "1.water" + "\n" + "2.wind");
    	problemContent3 = problemContent3.concat("\n" + "3.human" + "\n" + "4.butterfly");
    	int answer3 = 2;
    	Problem problem3 = new Problem(problemContent3, answer3);
    	this.problemSet.add(problem3);
    	
    	String problemContent4 = new String("Who is Venus?");
    	problemContent4 = problemContent4.concat("\n" + "1.Roman goddess of the moon" + "\n" + "2. Roman god of war");
    	problemContent4 = problemContent4.concat("\n" + "3.Roman goddess of love and beauty" + "\n" + "4.Roman god of the sun");
    	int answer4 = 3;
    	Problem problem4 = new Problem(problemContent4, answer4);
    	this.problemSet.add(problem4);
    	
    	String problemContent5 = new String("The first aging organ in human body?");
    	problemContent5 = problemContent5.concat("\n" + "1.Thymus" + "\n" + "2.Stomach");
    	problemContent5 = problemContent5.concat("\n" + "3.Eye" + "\n" + "4.Brain");
    	int answer5 = 1;
    	Problem problem5 = new Problem(problemContent5, answer5);
    	this.problemSet.add(problem5);
    	
    	String problemContent6 = new String("The first country in the world who promulgated Pharmacopoeia?");
    	problemContent6 = problemContent6.concat("\n" + "1.India" + "\n" + "2.Japan");
    	problemContent6 = problemContent6.concat("\n" + "3.Egypt" + "\n" + "4.China");
    	int answer6 = 4;
    	Problem problem6 = new Problem(problemContent6, answer6);
    	this.problemSet.add(problem6);
    	
    	String problemContent7 = new String("Who wrote the Tragedy of Othello?");
    	problemContent7 = problemContent7.concat("\n" + "1.Alexandre Dumas" + "\n" + "2. William Shakespeare");
    	problemContent7 = problemContent7.concat("\n" + "3.Nikolai Ostrovsky" + "\n" + "4.Charles Dickens");
    	int answer7 = 2;
    	Problem problem7 = new Problem(problemContent7, answer7);
    	this.problemSet.add(problem7);
    	
    	String problemContent8 = new String("Where is the Little Mermaid now located?");
    	problemContent8 = problemContent8.concat("\n" + "1.Oslo" + "\n" + "2.Berlin");
    	problemContent8 = problemContent8.concat("\n" + "3.Roma" + "\n" + "4.Copenhagen");
    	int answer8 = 4;
    	Problem problem8 = new Problem(problemContent8, answer8);
    	this.problemSet.add(problem8);
    	
    	String problemContent9 = new String("which is the largest archipelago (group of islands)?");
    	problemContent9 = problemContent9.concat("\n" + "1.Hawaiian Islands" + "\n" + "2.Malaysia Islands");
    	problemContent9 = problemContent9.concat("\n" + "3.Indonesia Islands" + "\n" + "4.Philippine Islands");
    	int answer9 = 2;
    	Problem problem9 = new Problem(problemContent9, answer9);
    	this.problemSet.add(problem9);
    	
    	String problemContent10 = new String("which is the most tortuous channel in the world?");
    	problemContent10 = problemContent10.concat("\n" + "1.The English Channel" + "\n" + "2.Strait of Hormuz");
    	problemContent10 = problemContent10.concat("\n" + "3.Strait of Magellan" + "\n" + "4.Mozambique Channel");
    	int answer10 = 3;
    	Problem problem10 = new Problem(problemContent10, answer10);
    	this.problemSet.add(problem10);
    	
    	String problemContent11 = new String("what is the mascot of Rice ");
    	problemContent11 = problemContent11.concat("\n" + "1.Mice" + "\n" + "2.Dog");
    	problemContent11 = problemContent11.concat("\n" + "3.Owl" + "\n" + "4.squirrel");
    	int answer11 = 3;
    	Problem problem11 = new Problem(problemContent11, answer11);
    	this.problemSet.add(problem11);
    	
    	String problemContent12 = new String("where is West Indians Island?");
    	problemContent12 = problemContent12.concat("\n" + "1.Pacific Ocean" + "\n" + "2.Atlantic Ocean");
    	problemContent12 = problemContent12.concat("\n" + "3.Indian Ocean" + "\n" + "4.Arctic ocean");
    	int answer12 = 2;
    	Problem problem12 = new Problem(problemContent12, answer12);
    	this.problemSet.add(problem12);
    	
    	String problemContent13 = new String("How long is a light-year?");
    	problemContent13 = problemContent13.concat("\n" + "1. 9460 Billion kM" + "\n" + "2. 7800 Billion kM");
    	problemContent13 = problemContent13.concat("\n" + "3. 8700 Billion kM" + "\n" + "4. 8650 Billion kM");
    	int answer13 = 1;
    	Problem problem13 = new Problem(problemContent13, answer13);
    	this.problemSet.add(problem13);
    	
    	String problemContent14 = new String("How many levels in maslow's hierarchy?");
    	problemContent14 = problemContent14.concat("\n" + "1. 4" + "\n" + "2. 5");
    	problemContent14 = problemContent14.concat("\n" + "3. 6" + "\n" + "4. 7");
    	int answer14 = 2;
    	Problem problem14 = new Problem(problemContent14, answer14);
    	this.problemSet.add(problem14);
    	
    	String problemContent15 = new String("Where is the birthplace of basketball?");
    	problemContent15 = problemContent15.concat("\n" + "1. America" + "\n" + "2. England");
    	problemContent15 = problemContent15.concat("\n" + "3. Germany" + "\n" + "4. China");
    	int answer15 = 1;
    	Problem problem15 = new Problem(problemContent15, answer15);
    	this.problemSet.add(problem15);
    	
    	String problemContent16 = new String("Where is the Pyramid of the Sun?");
    	problemContent16 = problemContent16.concat("\n" + "1. America" + "\n" + "2. Eygpt");
    	problemContent16 = problemContent16.concat("\n" + "3. Greece" + "\n" + "4. Mexico");
    	int answer16 = 4;
    	Problem problem16 = new Problem(problemContent16, answer16);
    	this.problemSet.add(problem16);
    	
    	String problemContent17 = new String("what kind of things is invented by Nobel?");
    	problemContent17 = problemContent17.concat("\n" + "1. TNT" + "\n" + "2. Battery");
    	problemContent17 = problemContent17.concat("\n" + "3. Gun Powder" + "\n" + "4. Computer");
    	int answer17 = 1;
    	Problem problem17 = new Problem(problemContent17, answer17);
    	this.problemSet.add(problem17);
    	
       	String problemContent18 = new String("Why we have four seasons ?");
    	problemContent18 = problemContent18.concat("\n" + "1. Earth Rotation" + "\n" + "2. Earth Revolution");
    	problemContent18 = problemContent18.concat("\n" + "3. Sun Revolution" + "\n" + "4. Earth Rotation");
    	int answer18 = 2;
    	Problem problem18 = new Problem(problemContent18, answer18);
    	this.problemSet.add(problem18);
    	
    	String problemContent19 = new String("which country invent tank ?");
    	problemContent19 = problemContent19.concat("\n" + "1. America" + "\n" + "2. Gremany");
    	problemContent19 = problemContent19.concat("\n" + "3. Enland" + "\n" + "4. France");
    	int answer19 = 3;
    	Problem problem19 = new Problem(problemContent19, answer19);
    	this.problemSet.add(problem19);
    	
    	String problemContent20 = new String("If one stock goes down for 20%, how many percent should this stocks rise up later to equal to orignal price ?");
    	problemContent20 = problemContent20.concat("\n" + "1. 30%" + "\n" + "2. 25%");
    	problemContent20 = problemContent20.concat("\n" + "3. 20%" + "\n" + "4. 40%");
    	int answer20 = 2;
    	Problem problem20 = new Problem(problemContent20, answer20);
    	this.problemSet.add(problem20);
    	
    	String problemContent21 = new String("what is the cycle of eyesBrow ?");
    	problemContent21 = problemContent21.concat("\n" + "1. one month" + "\n" + "2. two month");
    	problemContent21 = problemContent21.concat("\n" + "3. three month" + "\n" + "4. One and half month");
    	int answer21 = 2;
    	Problem problem21 = new Problem(problemContent21, answer21);
    	this.problemSet.add(problem21);
    	
    	String problemContent22 = new String("How long is perimeter of football?");
    	problemContent22 = problemContent22.concat("\n" + "1. 40cm " + "\n" + "2. 50cm");
    	problemContent22 = problemContent22.concat("\n" + "3. 60cm" + "\n" + "4. 70cm");
    	int answer22 = 3;
    	Problem problem22 = new Problem(problemContent22, answer22);
    	this.problemSet.add(problem22);
    	
    	String problemContent23 = new String("what is place of origin of coffee?");
    	problemContent23 = problemContent23.concat("\n" + "1. Asia " + "\n" + "2. Europe");
    	problemContent23 = problemContent23.concat("\n" + "3. South America" + "\n" + "4. Africa");
    	int answer23 = 4;
    	Problem problem23 = new Problem(problemContent23, answer23);
    	this.problemSet.add(problem23);
    	
    	String problemContent24 = new String("what is largest palace in the world?");
    	problemContent24 = problemContent24.concat("\n" + "1. Forbidden City " + "\n" + "2. White House");
    	problemContent24 = problemContent24.concat("\n" + "3. Buckingham Palace" + "\n" + "4. Elysee Palace");
    	int answer24 = 1;
    	Problem problem24 = new Problem(problemContent24, answer24);
    	this.problemSet.add(problem24);
    	
    	String problemContent25 = new String("How many days will the Olympic Games last for ?");
    	problemContent25 = problemContent25.concat("\n" + "1. 14 " + "\n" + "2. 16");
    	problemContent25 = problemContent25.concat("\n" + "3. 20" + "\n" + "4. 21");
    	int answer25 = 2;
    	Problem problem25 = new Problem(problemContent25, answer25);
    	this.problemSet.add(problem25);
    	
    	String problemContent26 = new String("which country is called kingdom of education ?");
    	problemContent26 = problemContent26.concat("\n" + "1. America " + "\n" + "2. China");
    	problemContent26 = problemContent26.concat("\n" + "3. Japan" + "\n" + "4. Israel");
    	int answer26 = 4;
    	Problem problem26 = new Problem(problemContent26, answer26);
    	this.problemSet.add(problem26);
    	
    	String problemContent27 = new String("what season will the mirage happens ?");
    	problemContent27 = problemContent27.concat("\n" + "1. spring " + "\n" + "2. summer");
    	problemContent27 = problemContent27.concat("\n" + "3. autumn" + "\n" + "4. winter");
    	int answer27 = 2;
    	Problem problem27 = new Problem(problemContent27, answer27);
    	this.problemSet.add(problem27);
    	
    	String problemContent28 = new String("when invent the computer ?");
    	problemContent28 = problemContent28.concat("\n" + "1. 1943 " + "\n" + "2. 1944");
    	problemContent28 = problemContent28.concat("\n" + "3. 1945" + "\n" + "4. 1946");
    	int answer28 = 4;
    	Problem problem28 = new Problem(problemContent28, answer28);
    	this.problemSet.add(problem28);
    	
    	String problemContent29 = new String("What is Pulitzer Prizes for ?");
    	problemContent29 = problemContent29.concat("\n" + "1. Sport " + "\n" + "2. Entertainment");
    	problemContent29 = problemContent29.concat("\n" + "3. News" + "\n" + "4. Peace");
    	int answer29 = 3;
    	Problem problem29 = new Problem(problemContent29, answer29);
    	this.problemSet.add(problem29);
    	
    	String problemContent30 = new String("Where is capital of China ?");
    	problemContent30 = problemContent30.concat("\n" + "1. Shanghai " + "\n" + "2. Beijin");
    	problemContent30 = problemContent30.concat("\n" + "3.Guangzhou" + "\n" + "4. Xi'an");
    	int answer30 = 2;
    	Problem problem30 = new Problem(problemContent30, answer30);
    	this.problemSet.add(problem30);
    	
    	String problemContent31 = new String("How long will marathon player run in every match?");
    	problemContent31 = problemContent31.concat("\n" + "1. 42195m " + "\n" + "2. 38965m");
    	problemContent31 = problemContent31.concat("\n" + "3.45655m" + "\n" + "4. 56435m");
    	int answer31 = 1;
    	Problem problem31 = new Problem(problemContent31, answer31);
    	this.problemSet.add(problem31);
    	
    	String problemContent32 = new String("who is the author of <<Impression, soleil>>?");
    	problemContent32 = problemContent32.concat("\n" + "1. Picasso " + "\n" + "2. Michelangelo");
    	problemContent32 = problemContent32.concat("\n" + "3. Van Gogh" + "\n" + "4. Monet");
    	int answer32 = 4;
    	Problem problem32 = new Problem(problemContent32, answer32);
    	this.problemSet.add(problem32);
    	
    	String problemContent33 = new String("which country holds Cannes International Film Festival every year?");
    	problemContent33 = problemContent33.concat("\n" + "1. England " + "\n" + "2. Michelangelo");
    	problemContent33 = problemContent33.concat("\n" + "3. Van Gogh" + "\n" + "4. Monet");
    	int answer33 = 4;
    	Problem problem33 = new Problem(problemContent33, answer33);
    	this.problemSet.add(problem33);
    	
    	String problemContent34 = new String("How many strings in guitar?");
    	problemContent34 = problemContent34.concat("\n" + "1. 5 " + "\n" + "2. 6");
    	problemContent34 = problemContent34.concat("\n" + "3. 7" + "\n" + "4. 8");
    	int answer34 = 2;
    	Problem problem34 = new Problem(problemContent34, answer34);
    	this.problemSet.add(problem34);
    	
    	String problemContent35 = new String("How many chess pieces in chess?");
    	problemContent35 = problemContent35.concat("\n" + "1. 30 " + "\n" + "2. 32");
    	problemContent35 = problemContent35.concat("\n" + "3. 34" + "\n" + "4. 36	");
    	int answer35 = 2;
    	Problem problem35 = new Problem(problemContent35, answer35);
    	this.problemSet.add(problem35);
    	
    	String problemContent36 = new String("which country produce cotton first in history?");
    	problemContent36 = problemContent36.concat("\n" + "1. China " + "\n" + "2. England");
    	problemContent36 = problemContent36.concat("\n" + "3. India" + "\n" + "4. Japan	");
    	int answer36 = 3;
    	Problem problem36 = new Problem(problemContent36, answer36);
    	this.problemSet.add(problem36);	
    	
    	String problemContent37 = new String("Where opera comes from?");
    	problemContent37 = problemContent37.concat("\n" + "1. France " + "\n" + "2. Greece");
    	problemContent37 = problemContent37.concat("\n" + "3. Italy" + "\n" + "4. Gremany");
    	int answer37 = 3;
    	Problem problem37 = new Problem(problemContent37, answer37);
    	this.problemSet.add(problem37);	
    	
    	String problemContent38 = new String("What is Thales think as the origin of everything?");
    	problemContent38 = problemContent38.concat("\n" + "1. Water " + "\n" + "2. Fire");
    	problemContent38 = problemContent38.concat("\n" + "3. Wind" + "\n" + "4. Atom");
    	int answer38 = 1;
    	Problem problem38 = new Problem(problemContent38, answer38);
    	this.problemSet.add(problem38);	
    	
    	String problemContent39 = new String("Who is the first resident of NY?");
    	problemContent39 = problemContent39.concat("\n" + "1. British " + "\n" + "2. Frence");
    	problemContent39 = problemContent39.concat("\n" + "3. Spainish" + "\n" + "4. Nederlanders");
    	int answer39 = 1;
    	Problem problem39 = new Problem(problemContent39, answer39);
    	this.problemSet.add(problem39);	
    	
    	String problemContent40 = new String("Who is instructor of Comp 510?");
    	problemContent40 = problemContent40.concat("\n" + "1. S.A.Wong " + "\n" + "2. S.B.Wong");
    	problemContent40 = problemContent40.concat("\n" + "3. S.C.Wong" + "\n" + "4. S.D.Wong");
    	int answer40 = 2;
    	Problem problem40 = new Problem(problemContent40, answer40);
    	this.problemSet.add(problem40);	
    }
    /**
     * popNew questions 
     * @param index is the index of the question wanted in the arraylist of questions
     * @return the poped new question
     */
    public String popNewQuestion(int index){
    	return this.problemSet.get(index).getProblemContent();
    }
    /**
     * get answer of the question 
     * @param index is the index of the question 
     * @return the answer of the index questions
     */
    public int getAnswer(int index){
    	return this.problemSet.get(index).getAnswer();
    }
   
    /**
     * check whether the result is right or not
     * @param result is the answer the client put
     * @return
     */
    public boolean check(int result){
    	return true;
 
    }
    /**
     * start method 
     */
    public void start(){
    	
    }
    /**
     * get end method 
     * @return the preblem set's size
     */
    public int getEnd(){
    	return this.problemSet.size();
    }
    
    /**
     * To tell the server how much step they should move
     * @param distance is the client's step moved
     * But we input is server's stub, not client
     */
    public void sendAnswerToServer(int distance){
    	
    	ATellServerToMove tellserver = new ATellServerToMove(distance, teamNO);
    	DataPacket<ATellServerToMove> dp = new DataPacket<ATellServerToMove>(ATellServerToMove.class, serverStub, tellserver);
    	try {
			serverStub.receiveData(dp);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    /**
     * set the team number of the team 
     * @param teamNo is the number of the team 
     */
    public void setTeamNO(int teamNo){
    	this.teamNO = teamNo;
    }
    /**
     * get the team number of the client
     * @return the team number
     */
    public int getTeamNo(){
    	return teamNO;
    }
    
    /**
     * tell server one player answer one question
     */
    public void alreadyAnsweredQuestion(){
    	AnswerQuestionPacket answerQuestionPacket = new AnswerQuestionPacket();
    	DataPacket<AnswerQuestionPacket> dp = new DataPacket<AnswerQuestionPacket>(AnswerQuestionPacket.class, serverStub, answerQuestionPacket);
    	try {
			serverStub.receiveData(dp);
		} catch (RemoteException e) {
		
			e.printStackTrace();
		}
    }
}
