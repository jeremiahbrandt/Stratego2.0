package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Protocol.SquarePacket;

public class Captain extends APiece {
    public Captain(SquarePacket squarePacket) {
        super("Captain", 6, new NormalMoveValidator(), squarePacket);
    }
}
