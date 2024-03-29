package application;

import model.entities.Man;
import model.enums.EyeColor;
import model.enums.HairColor;
import model.entities.Woman;
import model.entities.Person;
import model.exceptions.AvaliatorException;

import java.io.*;
import java.util.*;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        startOfProgram();

        List<Woman> mulheres = new ArrayList<>();
        List<Man> homens = new ArrayList<>();
        List<Person> people = new ArrayList<>();

        avaliadorPessoa(mulheres, homens, people, sc);

        rankeamentoLista(mulheres);
        rankeamentoLista(homens);
        rankeamentoLista(people);

        printRanks(mulheres, homens, people);

        while(true) {
            System.out.println("\n\n");
            System.out.print("Deseja avaliar mais pessoas (s/n): ");
            String sCheck = sc.next().strip().toLowerCase();
            char cCheck = sCheck.charAt(0);
            System.out.println();

            if (cCheck == 's') {

                avaliadorPessoa(mulheres, homens, people, sc);

                rankeamentoLista(mulheres);
                rankeamentoLista(homens);
                rankeamentoLista(people);

                printRanks(mulheres, homens, people);

            } else if (cCheck == 'n') {
                break;
            } else {
                AvaliatorException e = new AvaliatorException("Confirmacao de repeticao invalida!");
                System.out.println("Error: " + e.getMessage());
            }
        }

        try {
            System.out.print("Deseja salvar o rank (s/n): ");
            String sCheck = sc.next().strip().toLowerCase();
            char check = sCheck.charAt(0);

            if(check == 's') {
                writeFile(mulheres, homens, people, sc);
            }
        } catch(InputMismatchException e) {
            AvaliatorException a = new AvaliatorException("InputMismatchException error!");
            System.out.println("Error: " + a.getMessage());
        }

        endOfProgram();

        sc.close();
    }

    private static Woman womanScan(Scanner sc) {
        Woman woman = null;
        try {
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
            HairColor hairColor;
            if(hairLenght == 1) {
                hairColor = HairColor.valueOf("SEM_CABELO");
            } else {
                System.out.println("Cores de cabelo: ");
                System.out.println("PRETO | CASTANHO\nLOIRO | RUIVO\nBRANCO | CINZA\nAZUL | VERDE\nLUZES | FELIPE_NETO");
                System.out.print("Cor do cabelo: ");
                hairColor = HairColor.valueOf(sc.next().strip().toUpperCase());
            }
            System.out.println("Cor dos olhos:");
            System.out.println("CASTANHO | AZUL\nVERDE | HAZEL");
            System.out.print("Cor dos olhos: ");
            EyeColor eyeColor = EyeColor.valueOf(sc.next().strip().toUpperCase());
            System.out.println("Tipo do corpo: ");
            System.out.println("[ 1 ] Thais Carla\n[ 2 ] Magerrima\n[ 3 ] Magra\n[ 4 ] Gorda\n[ 5 ] Normal\n[ 6 ] Gostosa\n[ 7 ] Nave");
            System.out.print("Corpo: ");
            int hotness = sc.nextInt();
            System.out.println("Tem algum problema listado abaixo:");
            System.out.println("[ 1 ] Normal\n[ 2 ] Autismo\n[ 3 ] Sindrome de Down\n[ 4 ] Nanismo\n[ 5 ] Leandrinha vibes\n[ 6 ] Psicopatia");
            System.out.print("Tem problema: ");
            int problem = sc.nextInt();
            System.out.println("Mulher adcionada na lista de comparacao");
            woman = new Woman(name, age, height, weight, hairLenght, hairColor, eyeColor, hotness, problem);
        } catch(InputMismatchException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return woman;
    }

    private static Man manScan(Scanner sc) {
        Man man = null;
        try {
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
            System.out.println("[ 1 ] Careca | [ 2 ] Buzz Cut\n[ 3 ] Corte Social | [ 4 ] Americano\n[ 5 ] Low Fade | [ 6 ] Mid Fade\n[ 7 ] High Fade | [ 8 ] Mullet\n[ 9 ] Moica Trem | [ 10 ] Medio\n[ 11 ] Longo | [ 12 ] Tigelinha");
            System.out.print("Estilo do cabelo: ");
            int hairLenght = sc.nextInt();
            HairColor hairColor;
            if(hairLenght == 1) {
                hairColor = HairColor.valueOf("SEM_CABELO");
            } else {
                System.out.println("Cores de cabelo: ");
                System.out.println("PRETO | CASTANHO\nLOIRO | RUIVO\nBRANCO | CINZA\nAZUL | VERDE\nLUZES | FELIPE_NETO");
                System.out.print("Cor do cabelo: ");
                hairColor = HairColor.valueOf(sc.next().strip().toUpperCase());
            }
            System.out.println("Cor dos olhos:");
            System.out.println("CASTANHO | AZUL\nVERDE | HAZEL");
            System.out.print("Cor dos olhos: ");
            EyeColor eyeColor = EyeColor.valueOf(sc.next().toUpperCase());
            System.out.println("Tipo do corpo: ");
            System.out.println("[ 1 ] Thaiso Carlo\n[ 2 ] Magrelo | [ 3 ] Magro\n[ 4 ] Gordo | [ 5 ] Gordinho\n[ 6 ] Normal | [ 7 ] Fortinho\n[ 8 ] Sheipado | [ 9 ] Fortasso\n[ 10 ] CBum");
            System.out.print("Corpo: ");
            int body = sc.nextInt();
            System.out.print("Qual o salario: R$ ");
            double balance = sc.nextDouble();
            System.out.println("Tem algum problema listado abaixo:");
            System.out.println("[ 1 ] Normal\n[ 2 ] Autismo\n[ 3 ] Sindrome de Down\n[ 4 ] Nanismo\n[ 5 ] Leandrinha vibes\n[ 6 ] Psicopatia");
            System.out.print("Tem problema: ");
            int problem = sc.nextInt();
            System.out.println("Homem adcionado na lista de comparacao");

            man = new Man(name, age, height, weight, hairLenght, hairColor, eyeColor, body, balance, problem);
        } catch(InputMismatchException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return man;
    }

    private static void rankeamentoLista(List list) {
        Collections.sort(list, Comparator.comparingInt(Person::getPoints).reversed());
    }

    private static void startOfProgram() {
        System.out.println("|******************************|");
        System.out.println("      Avaliador de Pessoas");
        System.out.println("|******************************|");
    }

    private static void endOfProgram() {
        System.out.println("\n");
        System.out.println("|************************|");
        System.out.println("      End of Program");
        System.out.println("|************************|");
        System.out.println("\n\n");
        System.out.println("Obrigado por utilizar o avaliador de pessoas");
    }

    private static void avaliadorPessoa(List mulheres, List homens, List people, Scanner sc) {
        System.out.print("Quantas pessoas vc deseja avaliar: ");
        int n = sc.nextInt();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.println("Pessoa #" + i);
            System.out.print("Quer analisar um homem ou uma mulher (h/m): ");
            String sCheck = sc.next().strip().toLowerCase();
            char check = sCheck.charAt(0);

            if (check == 'm') {
                Woman woman = womanScan(sc);
                mulheres.add(woman);
                people.add(woman);

            } else if (check == 'h') {
                Man man = manScan(sc);
                homens.add(man);
                people.add(man);
            } else {
                throw new AvaliatorException("Tipo de pessoa invalida!");
            }
        }
    }

    private static void printRanks(List<Woman> mulheres, List<Man> homens, List<Person> people) {
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
    }

    private static void writeFile(List<Woman> mulheres, List<Man> homens, List<Person> people, Scanner sc) {

        System.out.print("Qual o caminho que quer guardar o rank: ");
        sc.nextLine();
        String path = sc.nextLine();

        boolean success = new File(path).mkdir();
        System.out.print("Quer chama-lo como: ");
        String fileName = sc.nextLine();

        path = path + File.separator + fileName + ".txt";

        File file = new File(path);
        System.out.println("O seu arquivo " + fileName + " esta em: " + file.getParent());

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Rank de Mulheres 0-100:");
            bw.newLine();
            bw.write("|***********************************************|");
            bw.newLine();

            for(Woman woman : mulheres) {
                bw.write("    " + woman.getName() + ", " + "Rank: ");
                bw.write(woman.getPoints() + " Points");
                bw.newLine();
                bw.write("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                bw.newLine();
            }
            bw.write("|***********************************************|");
            bw.newLine();
            bw.newLine();
            bw.newLine();

            bw.write("Rank de Homens 0-100:");
            bw.newLine();
            bw.write("|***********************************************|");
            bw.newLine();

            for(Man man : homens) {
                bw.write("    " + man.getName() + ", " + "Rank: ");
                bw.write(man.getPoints() + " Points");
                bw.newLine();
                bw.write("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                bw.newLine();
            }
            bw.write("|***********************************************|");
            bw.newLine();
            bw.newLine();
            bw.newLine();

            bw.write("Rank de Pessoas 0-100:");
            bw.newLine();
            bw.write("|***********************************************|");
            bw.newLine();

            for(Person person : people) {
                bw.write("    " + person.getName() + ", " + "Rank: ");
                bw.write(person.getPoints() + " Points");
                bw.newLine();
                bw.write("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                bw.newLine();
            }
            bw.write("|***********************************************|");

        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
     }
}
