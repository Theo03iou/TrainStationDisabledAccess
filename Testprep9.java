import java.util.Scanner;

class station {
    String name = "";
    boolean access = false;
}

public class Testprep9 {
    public static void main(String[] args) {
        start();
    }

    private static void start() {

        System.out.println("How many stations do you want to enter?");
        Scanner scanner = new Scanner(System.in);
        int stationLeng = scanner.nextInt();
        station [] newStation = new station[stationLeng];

        for (int i = 0; i < stationLeng; i++) {
            newStation[i] = new station();

            System.out.println("Enter the name of an underground station:\nEnter 'stop' to go to the next stage");
            String stationName2 = scanner.nextLine();
            String stationName = scanner.nextLine();

            setName(stationName, i, newStation);

            System.out.println("Does " + stationName + " have step-free access?\nJust enter true or false");
            boolean stepFree = scanner.nextBoolean();

            setAccess(stepFree, i, newStation);
            
        }
        nextStage(newStation);
    }
    
    
    private static void nextStage(station[] newStation) {
        for (int i = 0; i < newStation.length; i++) {
            String name = getName(newStation, i);
            boolean access = getAccess(newStation, i);
            System.out.println(name + " Station has step-free access: " + access);

        }
        System.exit(0);
    }
    
    
    private static void setAccess(boolean stepFree, int i, station[] newStation) {
        newStation[i].access = stepFree;
     }

    private static void setName(String stationName, int i, station newStation[]) {
        newStation[i].name = stationName;
    }
    
    private static boolean getAccess(station[] newStation, int i) {
        return newStation[i].access;
    }

    private static String getName(station[] newStation, int i) {
        return newStation[i].name;
    }
 
}
