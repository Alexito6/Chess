import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class King extends Piece {
    private boolean vivo;
    public King(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
        vivo=true;
    }

    @Override
    public Set<Coordinate> getNextMovements() {

        Coordinate position = getCell().getCoordinate();
        Set<Coordinate> posicionesCandidatas = new HashSet<>();

        if (canAddToNextMovements(position.up()))
            posicionesCandidatas.add(position.up());

        if (canAddToNextMovements(position.up().right()))
            posicionesCandidatas.add(position.up().right());

        if (canAddToNextMovements(position.right()))
            posicionesCandidatas.add(position.right());

        if (canAddToNextMovements(position.down().right()))
            posicionesCandidatas.add(position.down().right());

        if (canAddToNextMovements(position.down()))
            posicionesCandidatas.add(position.down());

        if (canAddToNextMovements(position.down().left()))
            posicionesCandidatas.add(position.down().left());

        if (canAddToNextMovements(position.left()))
            posicionesCandidatas.add(position.left());

        if (canAddToNextMovements(position.up().left()))
            posicionesCandidatas.add(position.up().left());

        return posicionesCandidatas;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_KING), WHITE(Piece.Type.WHITE_KING);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
    public void setVivo(){
        vivo=false;
    }
}
