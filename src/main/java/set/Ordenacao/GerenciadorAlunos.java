package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
  //atributos
  private Set<Aluno> alunosSet;

  public GerenciadorAlunos() {
    this.alunosSet = new HashSet<>();
  }

  public void adicionarAluno(String nome, Long matricula, double media) {
    alunosSet.add(new Aluno(nome, matricula, media));
  }

  public void removerAlunoPorMatricula(long matricula) {
    Aluno alunoParaRemover = null;
    if (!alunosSet.isEmpty()) {
      for (Aluno a : alunosSet) {
        if (a.getMatricula() == matricula) {
          alunoParaRemover = a;
          break;
        }
      }
      alunosSet.remove(alunoParaRemover);
    } else {
      throw new RuntimeException("O conjunto está vazio!");
    }

    if (alunoParaRemover == null) {
      System.out.println("Matricula não encontrada!");
    }
  }

  public void exibirAlunosPorNome() {
    Set<Aluno> alunosPorNome = new TreeSet<>(alunosSet);
    if (!alunosSet.isEmpty()) {
      System.out.println(alunosPorNome);
    } else {
      System.out.println("O conjunto está vazio!");
    }
  }

  public void exibirAlunosPorNota() {
    Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorNota());
    if (!alunosSet.isEmpty()) {
      alunosPorNota.addAll(alunosSet);
      System.out.println(alunosPorNota);
    } else {
      System.out.println("O conjunto está vazio!");
    }
  }

  public static void main(String[] args) {
    // Criando uma instância do GerenciadorAlunos
    GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

    // Adicionando alunos ao gerenciador
    gerenciadorAlunos.adicionarAluno("João", 123487L, 7.5);
    gerenciadorAlunos.adicionarAluno("Milena", 123488L, 6.0);
    gerenciadorAlunos.adicionarAluno("Carlos", 123489L, 8.0);
    gerenciadorAlunos.adicionarAluno("Kamila", 123490L, 5.8);

    // Exibindo todos os alunos no gerenciador
    System.out.println("Alunos no gerenciador:");
    System.out.println(gerenciadorAlunos.alunosSet);

    // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
    gerenciadorAlunos.removerAlunoPorMatricula(000L);
    gerenciadorAlunos.removerAlunoPorMatricula(123487L);
    System.out.println(gerenciadorAlunos.alunosSet);

    // Exibindo alunos ordenados por nome
    gerenciadorAlunos.exibirAlunosPorNome();

    // Exibindo alunos ordenados por nota
    gerenciadorAlunos.exibirAlunosPorNota();
  }
}
