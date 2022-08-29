


import java.util.Scanner;

public class HuMan extends Player {

        private String human;
        private Scanner input=new Scanner(System.in);



    public HuMan(String human){
        this.human=human;
    }

    @Override
    public int GetMove(){

        System.out.println("Please enter a valid column number(range:1-7)");
        move=input.nextInt();

        return move;
    }

    @Override
    public String GetPlayer(){return human;}

}
