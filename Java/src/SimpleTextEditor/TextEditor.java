import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TextEditor {
    private static BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws Exception {
        class State {
            State previousState;
            String presentState;

            State(State state, String newState){
                previousState=state;
                presentState=newState;
            }

            State(){
                previousState=null;
                presentState="";
            }

            public State append(String text){
                return new State(this, presentState+text);
            }

            public State delete(int number){
                return new State(this, presentState.substring(0,presentState.length()-number));
            }

            public void print(int number){
                System.out.println(presentState.charAt(number-1));
            }

            public State undo(){
                return previousState;
            }
        }


        State text = new State();

        int cases = Integer.parseInt(bi.readLine());

        for(int i=0;i<cases;i++){
            String line = bi.readLine();

            String[] splitString=line.split("\\s");

            if(splitString[0].equals("1")) {
                text = text.append(splitString[1]);
            }
            else if(splitString[0].equals("2")) {
                text = text.delete(Integer.parseInt(splitString[1]));
            }
            else if(splitString[0].equals("3")) {
                text.print(Integer.parseInt(splitString[1]));
            }
            else if(splitString[0].equals("4")) {
                text = text.undo();
            }
        }
    }

}