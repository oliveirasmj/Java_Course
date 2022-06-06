package zTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Mike"));
        pessoas.add(new Pessoa("Ana"));
        pessoas.add(new Pessoa("Joao"));
        pessoas.add(new Pessoa("Tiago"));

        Collections.sort(pessoas);

        for(Pessoa p : pessoas){
            System.out.println(p);
        }
    }
}
