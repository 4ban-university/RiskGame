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

        Player player1 = new Player("Player 1", Color.BLUE);
        Player player2 = new Player("Player 2", Color.PINK);
        Player player3 = new Player("Player 3", Color.CYAN);
        Player player4 = new Player("Player 3", Color.GREEN);

        Color[] playerColor = new Color[4];

        playerColor[0] = Color.BLUE;
        playerColor[1] = Color.PINK;
        playerColor[2] = Color.CYAN;
        playerColor[3] = Color.GREEN;

        Player[] playerList = new Player[players];

        int[] countriesPerPlayer = new int[players];
        for (int i=0; i<players; i++) {
            playerList[i] = new Player("Player " + (i + 1), playerColor[i]);
            countriesPerPlayer[i] = 0;
        }

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean flag = false;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                if (flag) {
                    String[] countryDetails = line.split(",");
                    countries.add(new Country(countryDetails[0], Integer.parseInt(countryDetails[1]), Integer.parseInt(countryDetails[2]), RADIUS, playerList[0]));
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

            //TODO Create countries and assign player via random get from additional player array
            //countries.add(new Country("RRRRR", 130, 100, RADIUS, player1));

            //Create neighbour via getting the country from country array
            //neighbours.add(new Neighbour(countries.get(0), countries.get(1)));

            //-------------------------------------------------------------------
            // Temporary map example


//            countries.add(new Country("Canada", 100, 100, RADIUS, player1));
//            countries.add(new Country("USA", 100, 300, RADIUS, player1));
//            countries.add(new Country("England", 300, 100, RADIUS, player2));
//            countries.add(new Country("France", 300, 200, RADIUS, player2));
//            countries.add(new Country("Mexico", 150, 400, RADIUS, player2));
//            countries.add(new Country("China", 400, 450, RADIUS, player3));
//            countries.add(new Country("Japan", 400, 300, RADIUS, player3));

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
