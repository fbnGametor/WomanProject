package application;

import model.entities.Man;
import model.enums.EyeColor;
import model.enums.HairColor;
import model.entities.Woman;
import model.entities.Person;

import java.util.*;


public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("|******************************|");
        System.out.println("      Avaliador de Pessoas");
        System.out.println("|******************************|");

        System.out.print("Quantas pessoas vc deseja avaliar: ");
        int n = sc.nextInt();

        List<Woman> mulheres = new ArrayList<>();
        List<Man> homens = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            System.out.println("Pessoa #" + i);
            System.out.print("Quer analisar um homem ou uma mulher (h/m): ");
            char check = sc.next().charAt(0);

            if(check == 'm') {
                System.out.print("Nome: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Idade: ");
                int age = sc.nextInt();
                System.out.print("Altura [ cm ]: ");
                int height = sc.nextInt();
                System.out.print("Peso: ");
                double weight = sc.nextDouble();
                System.out.println("Tipos de cabelos: ");
                System.out.println("[ 1 ] Careca\n[ 2 ] Muito Curto\n[ 3 ] Curto\n[ 4 ] Medio\n[ 5 ] Longo\n[ 6 ] Passando Da Bunda");
                System.out.print("Tamanho do cabelo: ");
                int hairLenght = sc.nextInt();
                System.out.println("Cores de cabelo: ");
                System.out.println("PRETO\nMARROM\nLOIRO\nRUIVO\nBRANCO\nCINZA\nAZUL\nVERDE\nLUZES\nFELIPE_NETO");
                System.out.print("Cor do cabelo: ");
                HairColor hairColor = HairColor.valueOf(sc.next().toUpperCase());
                System.out.println("Cor dos olhos:");
                System.out.println("MARROM\nAZUL\nVERDE\nHAZEL");
                System.out.print("Cor dos olhos: ");
                EyeColor eyeColor = EyeColor.valueOf(sc.next().toUpperCase());
                System.out.println("Tipo do corpo: ");
                System.out.println("[ 1 ] Thais Carla\n[ 2 ] Magerrima\n[ 3 ] Magra\n[ 4 ] Gorda\n[ 5 ] Normal\n[ 6 ] Gostosa\n[ 7 ] Nave");
                System.out.print("Corpo: ");
                int hotness = sc.nextInt();
                System.out.println("[ 1 ] Normal\n[ 2 ] Autismo\n[ 3 ] Sindrome de Down\n[ 4 ] Nanismo\n[ 5 ] Leandrinha vibes\n[ 6 ] Psicopatia");
                int problem = sc.nextInt();
                mulheres.add(new Woman(name, age, height, weight, hairLenght, hairColor, eyeColor, hotness, problem));
                people.add(new Woman(name, age, height, weight, hairLenght, hairColor, eyeColor, hotness, problem));
                System.out.println("Mulher adcionada na lista de comparacao");

            } else if(check == 'h') {
                System.out.print("Nome: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Idade: ");
                int age = sc.nextInt();
                System.out.print("Altura [ cm ]: ");
                int height = sc.nextInt();
                System.out.print("Peso: ");
                double weight = sc.nextDouble();
                System.out.println("Tipos de cabelos: ");
                System.out.println("[ 1 ] Careca\n[ 2 ] Buzz Cut\n[ 3 ] Corte Social\n[ 4 ] Americano\n[ 5 ] Low Fade\n[ 6 ] Mid Fade\n[ 7 ] High Fade\n[ 8 ] Mullet\n[ 9 ] Moica Trem\n[ 10 ] Medio\n[ 11 ] Longo\n[ 12 ] Tigelinha");
                System.out.print("Estilo do cabelo: ");
                int hairLenght = sc.nextInt();
                System.out.println("Cores de cabelo: ");
                System.out.println("PRETO\nMARROM\nLOIRO\nRUIVO\nBRANCO\nCINZA\nAZUL\nVERDE\nLUZES\nFELIPE_NETO");
                System.out.print("Cor do cabelo: ");
                HairColor hairColor = HairColor.valueOf(sc.next().toUpperCase());
                System.out.println("Cor dos olhos:");
                System.out.println("MARROM\nAZUL\nVERDE\nHAZEL");
                System.out.print("Cor dos olhos: ");
                EyeColor eyeColor = EyeColor.valueOf(sc.next().toUpperCase());
                System.out.println("Tipo do corpo: ");
                System.out.println("[ 1 ] Thaiso Carlo\n[ 2 ] Magrelo\n[ 3 ] Magro\n[ 4 ] Gordo\n[ 5 ] Gordinho\n[ 6 ] Normal\n[ 7 ] Fortinho\n[ 8 ] Sheipado\n[ 9 ] Fortasso\n[ 10 ] CBum");
                System.out.print("Corpo: ");
                int body = sc.nextInt();
                System.out.println("Qual o salario: ");
                double balance = sc.nextDouble();
                System.out.println("Tem algum problema listado abaixo:");
                System.out.println("[ 1 ] Normal\n[ 2 ] Autismo\n[ 3 ] Sindrome de Down\n[ 4 ] Nanismo\n[ 5 ] Leandrinha vibes\n[ 6 ] Psicopatia");
                int problem = sc.nextInt();
                homens.add(new Man(name, age, height, weight, hairLenght, hairColor, eyeColor, body, balance, problem));
                people.add(new Man(name, age, height, weight, hairLenght, hairColor, eyeColor, body, balance, problem));
                System.out.println("Homem adcionado na lista de comparacao");
            }
        }

        Collections.sort(mulheres, Comparator.comparingInt(Person::getPoints).reversed());
        Collections.sort(homens, Comparator.comparingInt(Person::getPoints).reversed());
        Collections.sort(people, Comparator.comparingInt(Person::getPoints).reversed());

        System.out.println("Rank de Mulheres 0-100:");
        System.out.println("|***********************************************|");
        for(Woman woman : mulheres) {
            System.out.print("    " + woman.getName() + ", " + "Rank: ");
            System.out.println(woman.getPoints() + " Points");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
        System.out.println("|***********************************************|");

        System.out.println("\n\n");

        System.out.println("Rank de Homens 0-100:");
        System.out.println("|***********************************************|");
        for(Man man : homens) {
            System.out.print("    " + man.getName() + ", " + "Rank: ");
            System.out.println(man.getPoints() + " Points");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
        System.out.println("|***********************************************|");

        System.out.println("\n\n");

        System.out.println("Rank de Pessoas 0-100:");
        System.out.println("|***********************************************|");
        for(Person person : people) {
            System.out.print("    " + person.getName() + ", " + "Rank: ");
            System.out.println(person.getPoints() + " Points");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
        System.out.println("|***********************************************|");

        sc.close();
    }
}
