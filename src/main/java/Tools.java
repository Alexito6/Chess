import java.util.Scanner;

public class Tools {
    public static boolean coordenadaCorrecta(String coordenada){
        coordenada=coordenada.toUpperCase();
        if (coordenada.length()!=2 || (coordenada.charAt(0)<65 || coordenada.charAt(0)>90) || (coordenada.charAt(1)-48>8 || coordenada.charAt(0)-48<1)){
            return false;
        }
        return true;
    }
    public static String pedirCoordenada(String peticion){
        Scanner scanner=new Scanner(System.in);
        System.out.println(peticion);
        String coordenada=scanner.nextLine();
        coordenada=coordenada.toUpperCase();
        while (!coordenadaCorrecta(coordenada)){
            System.out.println("That is not a coordinate, give me a correct coordinate");
            coordenada=scanner.nextLine();
        }
        return coordenada;
    }
}
