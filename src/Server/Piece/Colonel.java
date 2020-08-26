package Server.Piece;

import Server.MoveHandlers.NormalMoveValidator;
import Protocol.SquarePacket;

public class Colonel extends APiece {
    public Colonel(SquarePacket squarePacket) {
        super("Colonel", 8, new NormalMoveValidator(), squarePacket);
    }
}
