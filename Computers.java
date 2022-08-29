

import java.util.Random;

public class Computers extends Player{

    private String ComputerPlayer;
    Random rand=new Random();



    public Computers(String ComputerPlayer){
        this.ComputerPlayer=ComputerPlayer;

    }

    @Override
    public int GetMove(){
            move= 1+rand.nextInt(7);
        return move;
    }
    public String GetPlayer(){return ComputerPlayer;}

}
