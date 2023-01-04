import java.util.Scanner;

class station {
    String name;
    boolean accessibility;
}

public class stationProgram {
    public static void main(String[] args) {
        start();
    }

    private static void start() {

        System.out.println("How many stations do you want to enter?");
        Scanner scanner = new Scanner(System.in);
        int numStations = scanner.nextInt();
        station[] newStation = new station[numStations];

        for (int i = 0; i <= numStations; i++) {
            int j = i + 1;
            if (j <= numStations) {
                newStation[i] = new station();

                System.out.println("Station " + j + "/" + numStations);
                System.out.println("Enter the name of the station");
                String dwad = scanner.nextLine();
                String stationName = scanner.nextLine();

                if (stationName.equals("stop")) {
                    nextStage(newStation);
                    System.exit(0);
                }
                
                System.out.println("Does the station have step-free access?");
                boolean stepFree = scanner.nextBoolean();

                setStation(stationName, stepFree, i, newStation);
            }
        }
        nextStage(newStation);
    }

    private static void nextStage(station[] newStation) {
        System.out.println("Choose from the following:\n[1]: Exit the program\n[2]: Find a specific station's step-free access\n[3] Print all with step-free access");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();

        if (userChoice == 2) {
            System.out.println("What station access would you like to find out?");
            for (int i = 0; i < newStation.length; i++) {
                String currentStation = "[" + (i + 1) + "]: " + getStationName(newStation, i);
                System.out.println(currentStation);
            }
            int stationChoice = scanner.nextInt();

                if (stationChoice > 0 && stationChoice <= newStation.length) {
                    System.out.println(getStationName(newStation, userChoice - 1) + " station has disabled access: " + getStationAccess(newStation, userChoice - 1));
                } else {
                    System.out.println("This station does not exist, please choose from 1 to " + newStation.length);
                }
            
        } else if (userChoice == 3) {
            for (int i = 0; i < newStation.length; i++) {
                if (newStation[i].accessibility == true) {
                    System.out.println(getStationName(newStation, i) + " station has disabled access: " + getStationAccess(newStation, i));
                }
            }
        }
    }

    private static String getStationName(station[] newStation, int i) {
        String stationName = newStation[i].name;
        return stationName;
    }

    private static boolean getStationAccess(station[] newStation, int i) {
        boolean stationAccess = newStation[i].accessibility;
        return stationAccess;
    }


    private static void setStation(String stationName, boolean stepFree, int i, station[] newStation) {
        newStation[i].name = stationName;
        newStation[i].accessibility = stepFree;
    }

}

