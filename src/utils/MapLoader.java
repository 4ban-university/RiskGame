package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.util.Random;

import ui.Main;
import game.Game;
import model.Country;
import model.Neighbour;
import model.Player;

public class MapLoader {
    public static int RADIUS = 20;
    public static List<Country> countries = new ArrayList<>();
    public static List<Country> countriesTemp = new ArrayList<>();
    public static List<Neighbour> neighbours = new ArrayList<>();

    public MapLoader(int players, String filePath) {
        String line;
        Color[] playerColor = new Color[4];

        playerColor[0] = Color.BLUE;
        playerColor[1] = Color.ORANGE;
        playerColor[2] = Color.CYAN;
        playerColor[3] = Color.GRAY;

        Player[] playerList = new Player[players];

        int[] countriesPerPlayer = new int[players];
        for (int i=0; i<players; i++) {
            playerList[i] = new Player("Player " + (i + 1), playerColor[i]);
            countriesPerPlayer[i] = 0;
        }

        List<String> neighboursList = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean flag = false;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                if (flag) {
                    String[] countryDetails = line.split(",");
                    countries.add(new Country(countryDetails[0], Integer.parseInt(countryDetails[1]), Integer.parseInt(countryDetails[2]), RADIUS, playerList[0]));
                    String neighbour = "";
                    for (int i=3; i<countryDetails.length; i++) {
                        neighbour += countryDetails[i];
                        if (i!=countryDetails.length-1)
                            neighbour += ",";
                    }
                    neighboursList.add(neighbour);
                }
                if (line.equals("[Territories]"))
                    flag = true;
                //TODO load the map into structure
            }
            bufferedReader.close();

            int playerDistrib = countries.size() / playerList.length;
            int changeDistrib = playerDistrib * players;
            Random rand = new Random();

            for (int i=0; i<countries.size(); i++) {
                int newPlayer = rand.nextInt(players);
                if (i+1 <= changeDistrib) {
                    while (countriesPerPlayer[newPlayer] >= playerDistrib)
                        newPlayer = rand.nextInt(players);
                }
                countries.get(i).setPlayer(playerList[newPlayer]);
                countriesPerPlayer[newPlayer]++;
            }
            //String str = ""
            for (int i=0; i < countries.size(); i++) {
                String[] str = neighboursList.get(i).split(",");
                for (int j=0; j<str.length; j++) {
                    for (int k=0; k<countries.size(); k++)
                        if (str[j].equals(countries.get(k).getName()))
                            neighbours.add(new Neighbour(countries.get(i), countries.get(k)));
                }
                //System.out.println(str);

            }

            //neighbours.add(new Neighbour(countries.get(0), countries.get(1)));
           // neighbours.add(new Neighbour(countries.get(1), countries.get(2)));
//            neighbours.add(new Neighbour(countries.get(1), countries.get(4)));
//            neighbours.add(new Neighbour(countries.get(2), countries.get(3)));
//
//            neighbours.add(new Neighbour(countries.get(5), countries.get(6)));
//            neighbours.add(new Neighbour(countries.get(3), countries.get(5)));
//            neighbours.add(new Neighbour(countries.get(2), countries.get(6)));
//            neighbours.add(new Neighbour(countries.get(1), countries.get(6)));

            //---------------------------------------------------------------------
            // Create the instance of the game class and send it to Main
            Game game = new Game();
            new Main(game);
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + filePath + "'");
            ex.printStackTrace();
        }
    }
}
