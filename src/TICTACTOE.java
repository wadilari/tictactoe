import java.util.Objects;
import java.util.Scanner;

public class TICTACTOE {

    String[] feld = new String[9];
    String[] spieler = new String[2];
    Scanner sc= new Scanner(System.in);
    boolean running;

    public TICTACTOE(){
        spieler[0] = "x";
        spieler[1] = "o";

        this.reset();
    }

    public static void main(String[] args) {
        TICTACTOE spiel = new TICTACTOE();
        boolean stop = false;
        while (stop==false){
            if (spiel.run()==false){
                stop = true;
            }
        }
    }

    public boolean run(){
        this.running  = true;
        int aktSpieler = 2;
        int winner;
        String a ="ja";
        spielfeld();
        while(running){
            aktSpieler = 3-aktSpieler;
            System.out.println("Spieler "+aktSpieler+ " ist dran.");
            System.out.println("Auf welches Feld möchtest du setzen?");
            int eingabe = sc.nextInt();
            feld[eingabe-1] = spieler[aktSpieler-1];
            spielfeld();
            winner = this.winner();
            if(winner == 4){
                running = false;
                System.out.println("Unentschieden!!!!");
                System.out.println("Wollt ihr eine Revange?");
                String antwort = sc.next();
                if(Objects.equals(antwort, a)){
                    this.reset();
                    return true;
                }
                return false;
            }
            else if(winner ==2 ){
                running = false;
                System.out.println("Spieler "+spieler[0]+" hat gewonnen. Herzlichen Glückwunsch!");
                System.out.println("Wollt ihr eine Revange?");
                String antwort = sc.next();
                if(Objects.equals(antwort, a)){
                    this.reset();
                    return true;
                }
                return false;
            }
            else if(winner ==3 ){
                running = false;
                System.out.println("Spieler "+spieler[1]+" hat gewonnen. Herzlichen Glückwunsch!");
                System.out.println("Wollt ihr eine Revange?");
                String antwort = sc.next();
                if(Objects.equals(antwort, a)){
                    this.reset();
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public int winner(){
        String standderdinge = "";
        if (feld[0].equals(feld[1]) && feld[0].equals(feld[2])) standderdinge = feld[0];
        if (feld[0].equals(feld[3]) && feld[0].equals(feld[6])) standderdinge = feld[0];
        if (feld[0].equals(feld[4]) && feld[0].equals(feld[8])) standderdinge = feld[0];

        if (feld[8].equals(feld[5]) && feld[8].equals(feld[2])) standderdinge = feld[8];
        if (feld[8].equals(feld[7]) && feld[8].equals(feld[6])) standderdinge = feld[8];

        if (feld[2].equals(feld[4]) && feld[2].equals(feld[6])) standderdinge = feld[2];

        if (feld[3].equals(feld[4]) && feld[3].equals(feld[5])) standderdinge = feld[3];
        if (feld[1].equals(feld[4]) && feld[1].equals(feld[7])) standderdinge = feld[1];

        boolean  found_number = false;
        if (standderdinge == "") {
            for (int i = 0; i < feld.length; i++) {
                if (!feld[i].equals(spieler[0]) && !feld[i].equals(spieler[1])) {
                    found_number = true;
                }
            }
        }

        if(standderdinge == spieler[0]){
            return 2;
        }
        else if(standderdinge == spieler[1]){
            return 3;
        }
        else if (found_number == false){
            return 4;
        }
        else{
            return 1;
        }
    }

    public void reset(){
        feld[0] = "1";
        feld[1] = "2";
        feld[2] = "3";
        feld[3] = "4";
        feld[4] = "5";
        feld[5] = "6";
        feld[6] = "7";
        feld[7] = "8";
        feld[8] = "9";
    }

    public void spielfeld(){
        System.out.println();
        System.out.println("Spielfeld:");
        System.out.println("+---+---+---+");
        int index = 0;
        for(int i = 0 ; i<3 ; i++){
            for(int j = 0 ; j<3 ; j++){
                System.out.print("| "+feld[index]+" ");
                index++;
            }
            System.out.println("|");
            System.out.println("+---+---+---+");
        }
    }

}
