import java.util.ArrayList;
import java.util.List;
import com.diogonunes.jcolor.Attribute;
import static com.diogonunes.jcolor.Ansi.colorize;
public class DeletedPieceManagerListImp{
    List<Piece> pieceList;
    public DeletedPieceManagerListImp(){
        pieceList=new ArrayList<>();
    }
    public List<Piece> getPieceList(){
        return pieceList;
    }
    public void setPieceList(List<Piece> pieceList){
        this.pieceList=pieceList;
    }
    public int count(Piece.Type pieceType){
        int counterPieces=0;
        for (Piece p:pieceList){
            if (p.getType()==pieceType){
                counterPieces++;
            }
        }
        return counterPieces;
    }
    public String cajaBorradas(){
        String cajaArribaBlanca=Piece.Type.WHITE_PAWN.getShape()+" "+Piece.Type.WHITE_ROOK.getShape()+" "+Piece.Type.WHITE_BISHOP.getShape()+
                " "+Piece.Type.WHITE_KING.getShape()+" "+Piece.Type.WHITE_KNIGHT.getShape()+" "+Piece.Type.WHITE_QUEEN.getShape();
        String cajaArribaNegra=" "+Piece.Type.BLACK_PAWN.getShape()+" "+Piece.Type.BLACK_ROOK.getShape()+" "+Piece.Type.BLACK_BISHOP.getShape()+
                " "+Piece.Type.BLACK_KING.getShape()+" "+Piece.Type.BLACK_KNIGHT.getShape()+" "+Piece.Type.BLACK_QUEEN.getShape();
        cajaArribaNegra=colorize(cajaArribaNegra,Attribute.TEXT_COLOR(0,0,0));
        String cajaCompleta=cajaArribaBlanca+cajaArribaNegra;
        cajaCompleta=colorize(cajaCompleta,Attribute.BACK_COLOR(100,100,100));
        int peonBlanco = 8,torreBlanca=2,alfilBlanco=2,reyBlanco=1,caballoBlanco=2,reinaBlanca=1,peonNegro=8,torreNegra=2,alfilNegro=2,reyNegro=1,caballoNegro=2,reinaNegra=1;
        peonBlanco-=count(Piece.Type.WHITE_PAWN);
        torreBlanca-=count(Piece.Type.WHITE_ROOK);
        alfilBlanco-=count(Piece.Type.WHITE_BISHOP);
        reyBlanco-=count(Piece.Type.WHITE_KING);
        caballoBlanco-=count(Piece.Type.WHITE_KNIGHT);
        reinaBlanca-=count(Piece.Type.WHITE_QUEEN);
        peonNegro-=count(Piece.Type.BLACK_PAWN);
        torreNegra-=count(Piece.Type.BLACK_ROOK);
        alfilNegro-=count(Piece.Type.BLACK_BISHOP);
        reyNegro-=count(Piece.Type.BLACK_KING);
        caballoNegro-=count(Piece.Type.BLACK_KNIGHT);
        reinaNegra-=count(Piece.Type.BLACK_QUEEN);
        String cajaAbajo=peonBlanco+" "+torreBlanca+" "+alfilBlanco+" "+reyBlanco+" "+caballoBlanco+" "+reinaBlanca+
                " "+peonNegro+" "+torreNegra+" "+alfilNegro+" "+reyNegro+" "+caballoNegro+" "+reinaNegra;
        cajaAbajo=colorize(cajaAbajo,Attribute.BACK_COLOR(180,180,180));
        cajaAbajo=colorize(cajaAbajo,Attribute.TEXT_COLOR(0,0,0));
        return "DELETED PIECES:"+"\n"+cajaCompleta+"\n"+cajaAbajo;
    }
    public String cajaRestantes(){
        String cajaArribaBlanca=Piece.Type.WHITE_PAWN.getShape()+" "+Piece.Type.WHITE_ROOK.getShape()+" "+Piece.Type.WHITE_BISHOP.getShape()+
                " "+Piece.Type.WHITE_KING.getShape()+" "+Piece.Type.WHITE_KNIGHT.getShape()+" "+Piece.Type.WHITE_QUEEN.getShape();
        String cajaArribaNegra=" "+Piece.Type.BLACK_PAWN.getShape()+" "+Piece.Type.BLACK_ROOK.getShape()+" "+Piece.Type.BLACK_BISHOP.getShape()+
                " "+Piece.Type.BLACK_KING.getShape()+" "+Piece.Type.BLACK_KNIGHT.getShape()+" "+Piece.Type.BLACK_QUEEN.getShape();
        cajaArribaNegra=colorize(cajaArribaNegra,Attribute.TEXT_COLOR(0,0,0));
        String cajaCompleta=cajaArribaBlanca+cajaArribaNegra;
        cajaCompleta=colorize(cajaCompleta,Attribute.BACK_COLOR(100,100,100));
        int peonBlanco,torreBlanca,alfilBlanco,reyBlanco,caballoBlanco,reinaBlanca,peonNegro,torreNegra,alfilNegro,reyNegro,caballoNegro,reinaNegra;
        peonBlanco=count(Piece.Type.WHITE_PAWN);
        torreBlanca=count(Piece.Type.WHITE_ROOK);
        alfilBlanco=count(Piece.Type.WHITE_BISHOP);
        reyBlanco=count(Piece.Type.WHITE_KING);
        caballoBlanco=count(Piece.Type.WHITE_KNIGHT);
        reinaBlanca=count(Piece.Type.WHITE_QUEEN);
        peonNegro=count(Piece.Type.BLACK_PAWN);
        torreNegra=count(Piece.Type.BLACK_ROOK);
        alfilNegro=count(Piece.Type.BLACK_BISHOP);
        reyNegro=count(Piece.Type.BLACK_KING);
        caballoNegro=count(Piece.Type.BLACK_KNIGHT);
        reinaNegra=count(Piece.Type.BLACK_QUEEN);
        String cajaAbajo=peonBlanco+" "+torreBlanca+" "+alfilBlanco+" "+reyBlanco+" "+caballoBlanco+" "+reinaBlanca+
                " "+peonNegro+" "+torreNegra+" "+alfilNegro+" "+reyNegro+" "+caballoNegro+" "+reinaNegra;
        cajaAbajo=colorize(cajaAbajo,Attribute.BACK_COLOR(180,180,180));
        cajaAbajo=colorize(cajaAbajo,Attribute.TEXT_COLOR(0,0,0));
        return "REMAINING PIECES:"+"\n"+cajaCompleta+"\n"+cajaAbajo;

    }
}
