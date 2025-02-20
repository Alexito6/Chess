import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Input {
    public static void movePiece(String coordenada,Board board){
        Scanner scanner=new Scanner(System.in);
        while (!Tools.coordenadaCorrecta(coordenada)){
            coordenada=Tools.pedirCoordenada("That is not a coordinate, give me a correct coordinate");
        }
        char letter=coordenada.charAt(0);
        int num=coordenada.charAt(1)-48;
        Coordinate piezaAmover=new Coordinate(letter,num);
        while (board.getCellAt(piezaAmover).isEmpty()){
            coordenada=Tools.pedirCoordenada("There is no piece at that coordinate, try again");
            while (!Tools.coordenadaCorrecta(coordenada)){
                coordenada=Tools.pedirCoordenada("That is not a coordinate, give me a correct coordinate");
            }
            letter=coordenada.charAt(0);
            num=coordenada.charAt(1)-48;
            piezaAmover= new Coordinate(letter,num);
        }
        Set<Coordinate> coordenadasPosibles=new HashSet<>(board.getCellAt(piezaAmover).getPiece().getNextMovements());
        while (coordenadasPosibles.isEmpty()){
            coordenada=Tools.pedirCoordenada("It is not possible to move that piece, please choose another instead");
            while (!Tools.coordenadaCorrecta(coordenada)){
                coordenada=Tools.pedirCoordenada("That is not a coordinate, give me a correct coordinate");
            }
            letter=coordenada.charAt(0);
            num=coordenada.charAt(1)-48;
            piezaAmover= new Coordinate(letter,num);
            coordenadasPosibles=new HashSet<>(board.getCellAt(piezaAmover).getPiece().getNextMovements());
        }
        board.highLight(coordenadasPosibles);
        Output.mostrarTablero(board);
        String newPos=Tools.pedirCoordenada("What coordinate do you want to move this piece?");
        while (!Tools.coordenadaCorrecta(newPos)){
            System.out.println("That is not a coordinate, give me a correct coordinate");
            newPos=scanner.nextLine();
        }
        Coordinate newCoordinate=new Coordinate(newPos.charAt(0),newPos.charAt(1)-48);
        while (!board.getCellAt(piezaAmover).getPiece().canMoveTo(newCoordinate)){
            newPos=Tools.pedirCoordenada("That movement it's impossible, try again");
            newCoordinate=new Coordinate(newPos.charAt(0),newPos.charAt(1)-48);
        }
        if (board.getCellAt(piezaAmover).getPiece().canMoveTo(newCoordinate)){
            board.getCellAt(piezaAmover).getPiece().moveTo(newCoordinate);
        }
        board.removeHighLight(coordenadasPosibles);
        Output.mostrarTablero(board);
    }
}
