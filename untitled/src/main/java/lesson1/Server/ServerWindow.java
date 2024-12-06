package lesson1.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {
    private final int HIEGHT = 400;
    private final int WIDTH = 300;
    public static final String LOG_PATH = "src/server/main/java/lesson1/Server/log.txt";
    JButton btnStart, btnStop;
    JTextArea log;

    List<ClientGUI> clientGUIList;
    boolean work;

    public void message(String text){
        if (!work){
            return;
        }
        text += "";
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }
    private void appendLog(String text){
        log.append(text + "\n");
    }
    private void answerAll(String text){
        for (ClientGUI clientGUI: clientGUIList){
            clientGUI.answer(text);
        }
    }

    private void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean connectUser(ClientGUI clientGUI){
        if (!work){
            return false;
        }
        clientGUIList.add(clientGUI);
        return true;
    }

    public ServerWindow() {
        clientGUIList = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HIEGHT);
        setTitle("Server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);


    }


    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButton(), BorderLayout.SOUTH);



    }


    private Component createButton() {
        JPanel panel = new JPanel(new GridLayout(1,2));
        btnStart = new JButton("Start");
        btnStop =  new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(work){

                } else {
                    work = true;
                    log.append("Подключено");

                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!work){

                } else {
                    work =false;
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);

        return panel;

    }




}
