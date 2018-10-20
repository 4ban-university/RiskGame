import mapeditor.StartEditor;
import game.utils.MapLoader;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


/**
 * The main menu class, needed for displaying the menu window.
 * @author Dmitry Kryukov, Ksenia Popova
 * @see MapLoader
 */
public class MainMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private int width, height;

    /**
     * The constructor of the class.
     * Creates the window and put the buttons on there.
     * @param title of the window
     * @param width of the window
     * @param height of the window
     */
    public MainMenu(String title, int width, int height) {
        super(title);
        this.width = width;
        this.height = height;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(this.width, this.height);
        setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(file());
        menuBar.add(mapEditor());
        menuBar.add(exit());
        setJMenuBar(menuBar);

        getContentPane().add(startButtons());

        // pack(); // ignore sizing
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Method generate the button for menu bar with calling additional functionality
     * Such: testing continent bonus with 4 players
     * @return file object to attach to the menu bar panel
     */
    private JMenu file() {
        JMenu file = new JMenu("File");
        JMenuItem continentBonus = new JMenuItem("test: Continent bonus with 4 players");
        file.add(continentBonus);

        continentBonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("DEBUG: Testing continent bonus with 4 players\n ------------------------ \n");
                int players = 4;
                String filePath = filePath();
                new MapLoader(players, filePath, true);
            }
        });
        return file;
    }

    /**
     * Method generates the button for menu bar with calling map editor
     * @return mapEditor object to attach it to the menu bar panel
     */
    private JMenu mapEditor() {
        JMenu mapEditor = new JMenu("Map Editor");
        JMenuItem editorCLI = new JMenuItem("Open map editor with CLI");
        mapEditor.add(editorCLI);
        JMenuItem editorGUI = new JMenuItem("Open map editor with GUI");
        mapEditor.add(editorGUI);

        editorCLI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("DEBUG: Launch CLI Map Editor\n ------------------------ \n");
                StartEditor editor = new StartEditor();
            }
        });
        editorGUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("DEBUG: Launch GUI Map Editor\n ------------------------ \n");
            }
        });
        return mapEditor;
    }

    /**
     * Method generates the button for menu bar with calling exit
     * @return exit object to attach it to the menu bar panel
     */
    private JMenu exit() {
        JMenu exit = new JMenu("Exit");
        JMenuItem quit = new JMenuItem(new ExitAction());
        exit.add(quit);
        return exit;
    }

    /**
     * Method generates the buttons for menu bar with calling start game with different number of players
     * @return startButtons object to attach the buttons to the window
     */
    private JPanel startButtons() {
        JPanel buttonPanel = new JPanel();
        JPanel startButtons = new JPanel();

        buttonPanel.setPreferredSize(new Dimension(350, 200));
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,5,0,0);
        JButton player2 = new JButton(("2 Players"));
        JButton player3 = new JButton(("3 Players"));
        JButton player4 = new JButton(("4 Players"));

        buttonPanel.add(player2, gbc);
        buttonPanel.add(player3, gbc);
        buttonPanel.add(player4, gbc);

        startButtons.add(buttonPanel);

        player2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("DEBUG: Chosen 2 players\n ------------------------ \n");
                int players = 2;
                String filePath = filePath();
                MapLoader loader = new MapLoader(players, filePath, false);
            }
        });
        player3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("DEBUG: Chosen 3 players\n ------------------------ \n");
                int players = 3;
                String filePath = filePath();
                MapLoader loader = new MapLoader(players, filePath, false);
            }
        });
        player4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("DEBUG: Chosen 4 players\n ------------------------ \n");
                int players = 4;
                String filePath = filePath();
                MapLoader loader = new MapLoader(players, filePath,false);
            }
        });
        return startButtons;
    }

    /**
     * Exit functionality
     */
    class ExitAction extends AbstractAction {
        private static final long serialVersionUID = 1L;
        ExitAction() {
            putValue(NAME, "Quit");
        }
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    /**
     * The method which returns the filepath of the map
     * @return filepath path to the map file
     * or
     * @return default.map default map file
     */
    private String filePath() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        System.out.println("DEBUG: Using the default map!\n---------------------------------------\n");
        return "default.map";
    }
}