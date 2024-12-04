package lesson1.TicToc;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    public static final String BTN_START = "Start new game";
    public static final String LABEL_CHOICE_MODE = "Выберите режим игры";
    public static final String BTN_HUMAN_VERSUS_AI = "Человек против компьютера";
    public static final String BTN_HUMAN_VERSUS_HUMAN = "Человек против человека";
    public static final String SIZE_PREFIX = "Установленный размер поля: ";
    public static final String WIN_LENGTH_PREFIX = "Установленная длина: ";
    public static final String LABEL_CHOICE_SIZE = "Выберите размеры поля";
    public static final String LABEL_CHOICE_WIN_LENGTH = "Выберите длину для победы";
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 10;
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;
    JButton btnStart = new JButton(BTN_START);
    JRadioButton humanVHuman, humanVAI;
    Label labelCurSize, labelWinLength;
    JSlider sizeSlider, winSlider;


    SettingWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, 3, 3, 3);
                setVisible(false);
            }
        });
        add(btnStart);


    }

}

