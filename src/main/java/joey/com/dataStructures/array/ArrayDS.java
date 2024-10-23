package joey.com.dataStructures.array;


import java.util.Arrays;
import java.util.Scanner;

public class ArrayDS {
    // Um array é uma coleção de elementos que armazenam múltiplos valores de um mesmo tipo em uma única variável.
    // tipo[] nomeDoArray;

    public void arrayEx () {

        int[] num = new int[5]; // init Array with 5 positions
        int[] num2 = {1, 2, 3, 4, 5}; // init
        int firstEl = num2[0]; // getting items from array
        int arrayLength = num.length;


        // iterando items
        // for
        for (int i = 0; i < arrayLength; i++) {
            num[i] = i; // modify item
        }

        // for ... of
        for (int numero : num2) {
            System.out.println(numero);
        }
    }

    // Arrays Multidimensionais
    // Java também suporta arrays multidimensionais (por exemplo, matrizes).
    public void multDimeArray () {

        String[][] matriz = new String[3][3]; // Matriz 3x3
        //   [
        //      ['a', 'b', 'c'],
        //      ['d', 'e', 'f'],
        //      ['g', 'h', 'i']
        //   ]

        String elemento = matriz[1][2]; // Acessa o valor 6 (linha 1, coluna 2)


        int[][] matriz2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }

    class Aluno {
        String nome;
        int idade;

        Aluno(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        @Override
        public String toString() {
            return "Name: " + this.nome + "Age: " + this.idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }
    }

    public void customArray () {
        Aluno[] alunos = {
                new Aluno("Ana", 20),
                new Aluno("Bruno", 22),
                new Aluno("Carlos", 19)
        };
    }

    private Aluno[] alunos = new Aluno[5];

    // Desafio é fazer um CRUD com Array
    public void arrayDesafio () {
        // create
        this.create();
        this.create();
        this.create();
        this.create();

        // read
        this.readByIndex((int) (Math.random() * 4));
        this.readByIndex((int) (Math.random() * 4));
        this.readByIndex((int) (Math.random() * 4));

        // read name
        this.readByName("Aluno - 2");
        this.readByName("Aluno - 0");
        this.readByName("Aluno - 1");

        // read by age
        this.readByAge(20);
        this.readByAge(21);
        this.readByAge(23);

        // update
        this.update(2, new Aluno("Novo nome 0", 17));
        this.update(1, new Aluno("Novo nome 2", 22));

        // delete
        this.delete(0);
        this.delete(3);

    }

    private void create() {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] == null) {
                alunos[i] = new Aluno("Aluno - " + i, 20 + i);
            }
        }
        this.showArray();
    }

    private Aluno readByIndex(int index) {
        for (int i = 0; i < alunos.length; i++) {
            if (i == index) {
                return alunos[i];
            }
        }
        return null;
    }

    private void readByName(String name) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(name)) {
                System.out.println("Reading " + name + ": " + aluno.toString());
            }
        }
    }

    private void readByAge(int age) {
        for (Aluno aluno : alunos) {
            if (aluno.getIdade() == age) {
                System.out.println("Reading aluno with age" + age + ": " + aluno.toString());
            }
        }
    }

    private void update(int index, Aluno novoAluno) {
//        Aluno aluno = this.readByIndex(index);
//        aluno = novoAluno;
        for (int i = 0; i < alunos.length; i++) {
            if (i == index) {
                alunos[i] = novoAluno;
            }
            showArray();
        }
    }

    private void delete(int index) {
        for (int i = 0; i < alunos.length; i++) {
            if (i == index) {
                alunos[i] = null;
            }
            showArray();
        }
    }

    private void showArray() {
        for (int i = 0; i < alunos.length; i++) {
            System.out.println("Array in [" + i + "] - " + alunos[i].toString());
        }
    }
}
