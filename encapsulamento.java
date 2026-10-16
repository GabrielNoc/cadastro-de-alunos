import java.util.Scanner;


class Aluno {
    private String nome;
    private double[] notas;

    public Aluno(String nome, double[] notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public double calcularMedia() {
        if (notas.length == 0) return 0;
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public String situacao() {
        double media = calcularMedia();
        if (media >= 7.0) return "Aprovado";
        if (media >= 5.0) return "Recuperação";
        return "Reprovado";
    }

    private String notasFormatadas() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < notas.length; i++) {
            sb.append(String.format("%.1f", notas[i]));
            if (i < notas.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format(
                "Aluno: %-15s | Notas: %-25s | Média: %.2f | Situação: %s",
                nome, notasFormatadas(), calcularMedia(), situacao()
        );
    }
}

public class encapsulamento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" REGISTRO DE NOTAS ESCOLARES ");

        System.out.print("Quantos alunos existem? ");
        int qtdAlunos = sc.nextInt();
        sc.nextLine();

        Aluno[] alunos = new Aluno[qtdAlunos];

        for (int i = 0; i < qtdAlunos; i++) {
            System.out.println("\n Cadastro do " + (i + 1) + "º aluno ");

            System.out.print("Nome do aluno: ");
            String nome = sc.nextLine();

            System.out.print("Quantas provas foram realizadas? ");
            int qtdProvas = sc.nextInt();

            double[] notas = new double[qtdProvas];
            for (int j = 0; j < qtdProvas; j++) {
                System.out.print("Nota da " + (j + 1) + "ª prova: ");
                notas[j] = sc.nextDouble();
            }
            sc.nextLine();

            alunos[i] = new Aluno(nome, notas);
        }

        System.out.println("\n RESUMO DOS ALUNOS ");
        double somaMedias = 0;
        for (int i = 0; i < alunos.length; i++) {
            System.out.println((i + 1) + ") " + alunos[i]);
            somaMedias += alunos[i].calcularMedia();
        }

        double mediaGeral = alunos.length > 0 ? somaMedias / alunos.length : 0;
        System.out.printf("%nMédia geral da turma: %.2f%n", mediaGeral);

        sc.close();
    }
}