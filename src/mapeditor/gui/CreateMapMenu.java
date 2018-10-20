package mapeditor.gui;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapeditor.Continent;
import mapeditor.ILoadedMap;
import mapeditor.IMapLoader;
import mapeditor.MapLoader;
import mapeditor.Verification;
import javax.swing.JOptionPane;
import mapeditor.IContinent;
import mapeditor.ITerritory;
import mapeditor.Territory;

public class CreateMapMenu extends JFrame {

    static ArrayList<Continent> continents;

    static void setAuthor(String authorParameter) {
        author = authorParameter;
    }
    private String path;
    public ILoadedMap loadedMapObj;
    public String pathSelected;
    static String author = "";

    public CreateMapMenu(String pathSelectedCons, ILoadedMap loadedMapObjCons) {
        pathSelected = pathSelectedCons;
        loadedMapObj = loadedMapObjCons;
        continents = new ArrayList<Continent>();
        path = pathSelected;
        initUI();
    }

    private void initUI() {

        //ImageIcon saveIcon = new ImageIcon("src/main/resources/save.png");
        //ImageIcon homeIcon = new ImageIcon("src/main/resources/home.png");
        JButton basicBtn = new JButton("Basic Properties");
        JButton contiBtn = new JButton("Continents");
        JButton terrBtn = new JButton("Territories");
        JButton veriBtn = new JButton("Verify and Save");
        JButton quitBtn = new JButton("Quit");
        JLabel pathVerification = new JLabel("");

        basicBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                EventQueue.invokeLater(() -> {
                    Author bp = new Author();
                    bp.setVisible(true);
                });

            }
        });

        contiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                EventQueue.invokeLater(() -> {
                    Continents ct = new Continents(loadedMapObj);
                    ct.setVisible(true);
                });

            }
        });

        terrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                EventQueue.invokeLater(() -> {
                    Territories ter = new Territories(loadedMapObj);
                    ter.setVisible(true);
                });

            }
        });

        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                quitBtn.addActionListener((event) -> System.exit(0));

            }
        });

        veriBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                EventQueue.invokeLater(() -> {

                    Verification verificationObj = new Verification();
                    IMapLoader mapLoaderObj = new mapeditor.MapLoader(pathSelected, 2);
                    ILoadedMap saveTest = mapLoaderObj.getLoadedMap();
                    saveTest.setAuthor(loadedMapObj.getAuthor());
                    if (!author.isEmpty()) {
                        saveTest.setAuthor(author);
                    }
                    ArrayList<IContinent> continents = Continent.getContinents();
                    for (IContinent cont : continents) {
                        saveTest.addContinent(cont);
                    }
                    ArrayList<ITerritory> territories = Territory.getTerritories();
                    for (ITerritory ter : territories) {
                        saveTest.addTerritory(ter);
                    }
                    Boolean rightPath = verificationObj.verifyMap(saveTest, path);
                    if (rightPath) {
                    } else {
                    }
                });

            }
        });

        createLayout(basicBtn, contiBtn, terrBtn, veriBtn, quitBtn, pathVerification);

        setTitle("Create Map Menu");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4]));

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4]));

        gl.linkSize(arg[0], arg[1], arg[2], arg[3], arg[4]);

        pack();
    }

}
