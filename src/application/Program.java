package application;

import model.enums.EyeColor;
import model.enums.HairColor;
import model.entities.Woman;

import java.util.*;


public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("|*****************************|");
        System.out.println("    Avaliador de Mulheres");
        System.out.println("|*****************************|");

        System.out.print("Quantas mulheres vc deseja avaliar: ");
        int n = sc.nextInt();

        List<Woman> mulheres = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            System.out.println("Mulher #" + i);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Idade: ");
            int age = sc.nextInt();
            System.out.print("Altura [ cm ]: ");
            int height = sc.nextInt();
            System.out.print("Peso: ");
            double weight = sc.nextDouble();
            System.out.println("[ 1 ] Careca\n[ 2 ] Muito Curto\n[ 3 ] Curto\n[ 4 ] Medio\n[ 5 ] Longo\n[ 6 ] Passando Da Bunda");
            System.out.print("Tamanho do cabelo: ");
            int hairLenght = sc.nextInt();
            System.out.println("BLACK\nBROWN\nBLOND\nRED\nWHITE\nGRAY\nBLUE\nGREEN\nLIGHTS\nFELIPE_NETO");
            System.out.print("Cor do cabelo: ");
            HairColor hairColor = HairColor.valueOf(sc.next().toUpperCase());
            System.out.println("BROWN\nBLUE\nGREEN\nHAZEL");
            System.out.print("Cor dos olhos: ");
            EyeColor eyeColor = EyeColor.valueOf(sc.next().toUpperCase());
            System.out.println("[ 1 ] Thais Carla\n[ 2 ] Magerrima\n[ 3 ] Magra\n[ 4 ] Gorda\n[ 5 ] Normal\n[ 6 ] Gostosa\n[ 7 ] Nave");
            System.out.print("Corpo: ");
            int hotness = sc.nextInt();
            mulheres.add(new Woman(name, age, height, weight, hairLenght, hairColor, eyeColor, hotness));
            System.out.println("Mulher adcionada na lista de comparacao");
        }

        Collections.sort(mulheres, Comparator.comparingInt(Woman::getPoints).reversed());

        System.out.println("Rank 0-100:");
        for(Woman woman : mulheres) {
            System.out.print(woman.getName() + ", " + "Rank: ");
            System.out.println(woman.getPoints() + " Points");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
    }
}
