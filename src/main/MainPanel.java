package main;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;


public class MainPanel extends JPanel {
    private JLabel hpLabel;
    private ArrayList<EntiteView> entites;
    private BufferedImage img;
    public MainPanel() {
        importImg();
        hpLabel = new JLabel("Nombre de vies");
        this.add(hpLabel);
        setPanelSize();
        entites = new ArrayList<EntiteView>();
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        System.out.println("Stream: " + is);
        URL url = MainPanel.class.getResource("/player_sprites.png");
        System.out.println("URL: " + url);

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void setPanelSize() {
        Dimension size = new Dimension(1280,800); // images de 32px -> 40 par 25
        setPreferredSize(size);
    }
    protected void paintComponent(Graphics g) { 
        for(EntiteView e: entites)
            e.paint(g);
        g.drawImage(img, 600, 400, null);
    }
    public void addEntiteView(EntiteView entite) {
        this.entites.add(entite);
    }    
}
