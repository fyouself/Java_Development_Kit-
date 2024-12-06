package lesson1.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientGUI extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    private ServerWindow server;
    private boolean connected;
    private String name;

    JTextField jtLogin, tfMessage;

    JTextArea log;

    JButton btnLogin, btnSend;


    JPanel headPanel;


    public ClientGUI(ServerWindow server) {
        this.server = server;

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");

        setLocation(server.getX() - 100, server.getY());
        createPanel();
        setVisible(true);

    }

    private void appendLog(String text) {
        log.append(text + "\n");
    }


    public void message() {
        if (connected) {
            String text = tfMessage.getText();
            if (!text.equals("")) {
                server.message(name + ": " + text);
                tfMessage.setText("^_^");
            }
        } else {
            appendLog("Нет подключения к серверу");
        }
    }

    public void answer(String text){
        appendLog(text);
    }

    private void connectToServer() {
        if (server.connectUser(this)){
            appendLog("Вы успешно подключились!\n");
            headPanel.setVisible(false);
            connected = true;
            name = jtLogin.getText();
//            String log = server.getLog();
//            if (log != null){
//                appendLog(log);
//            }
        } else {
            appendLog("Подключение не удалось");
        }
    }

    private void createPanel() {

        log = new JTextArea();
        log.setEditable(false);
        add(log);
        add(createHeadPanel(), BorderLayout.NORTH);
        add(createFooter(), BorderLayout.SOUTH);


    }

    private Component createHeadPanel() {
        headPanel = new JPanel(new GridLayout(1, 3));
        jtLogin = new JTextField("Aноним");
        btnLogin = new JButton("Подключиться");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectServer();
            }
        });

        headPanel.add(jtLogin);
        headPanel.add(new JPanel());
        headPanel.add(btnLogin);

        return headPanel;
    }

    private Component createFooter() {
        JPanel panel = new JPanel(new BorderLayout());

        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    message();
                }
            }
        });
        btnSend = new JButton("send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });
        panel.add(tfMessage);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;

    }

    private void connectServer() {

        if(server.connectUser(this)){
            appendLog("Вы подключлись");
            connected = true;
            name = jtLogin.getText();
            headPanel.setVisible(false);
        } else {
            appendLog("Не удалось подключится");
        }

    }


}
