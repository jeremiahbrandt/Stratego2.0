package Client;

import Client.Views.BoardView;
import Client.Views.GameView;
import Protocol.BoardPacket;
import Protocol.GameStatus;
import Protocol.Message;
import Protocol.Packet;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Listener implements Runnable {
    private GameView gameView;
    private ObjectInputStream in;
    private boolean listening;

    public Listener(GameView gameView, ObjectInputStream in) {
        this.gameView = gameView;
        this.in = in;
    }

    @Override
    public void run() {
        listening = true;
        while (listening) {
            try {
                Packet res = (Packet) in.readObject();
                if(res instanceof BoardPacket) {
                    gameView.displayBoard((BoardPacket) res);
                } else if (res instanceof Message) {
                    gameView.displayMessage((Message) res);
                } else if (res instanceof GameStatus) {
                    gameView.displayGameStatus((GameStatus) res);
                }
                System.out.println(res + " received " + in + ".");
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
                listening = false;
            }
        }
    }
}
