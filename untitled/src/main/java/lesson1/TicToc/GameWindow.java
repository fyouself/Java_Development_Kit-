package lesson1.TicToc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WIDTH = 555;
    private static final int HEIGHT = 507;

    Map map;

    SettingWindow settingWindow;

    JButton btnStart, btnExit;

    public GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Крестики нолики");
        btnStart = new JButton("New Game");
        btnExit = new JButton("Exit");

        map = new Map();
        settingWindow = new SettingWindow(this);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true);
            }
        });

        JPanel panButton = new JPanel(new GridLayout(1, 2));
        panButton.add(btnStart);
        panButton.add(btnExit);

        add(panButton, BorderLayout.SOUTH);
        add(map);
        setVisible(true);


    }

    void startNewGame(int mode, int sizeX, int sizeY, int winLen){
        map.startNewGame(mode, sizeX, sizeY, winLen);
        repaint();
    }

}
