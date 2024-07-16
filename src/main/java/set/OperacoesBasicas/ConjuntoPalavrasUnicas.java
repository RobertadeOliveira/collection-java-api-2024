package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
  //atributos
  private Set<String> palavrasUnicasSet;

  public ConjuntoPalavrasUnicas() {
    this.palavrasUnicasSet = new HashSet<>();
  }

  public void adicionarPalavra(String palavra) {
    palavrasUnicasSet.add(palavra);
  }

  public void removerPalavra(String palavra) {
    if (!palavrasUnicasSet.isEmpty()) {
      if (palavrasUnicasSet.contains(palavra)) {
        palavrasUnicasSet.remove(palavra);
      } else {
        System.out.println("Palavra não encontrada no conjunto!");
      }
    } else {
      System.out.println("O conjunto está vazio!");
    }
  }

  public boolean verificarPalavra(String palavra) {
    return palavrasUnicasSet.contains(palavra);
  }

  public void exibirPalavrasUnicas() {
    if(!palavrasUnicasSet.isEmpty()) {
      System.out.println(palavrasUnicasSet);
    } else {
      System.out.println("O conjunto está vazio!");
    }
  }

  public static void main(String[] args) {
    // Criando uma instância da classe ConjuntoPalavrasUnicas
    ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

    // Adicionando linguagens únicas ao conjunto
    conjuntoLinguagens.adicionarPalavra("Água");
    conjuntoLinguagens.adicionarPalavra("Farinha");
    conjuntoLinguagens.adicionarPalavra("Fermento");
    conjuntoLinguagens.adicionarPalavra("Manteiga");
    conjuntoLinguagens.adicionarPalavra("Açúcar");
    conjuntoLinguagens.adicionarPalavra("Leite");

    // Exibindo as linguagens únicas no conjunto
    conjuntoLinguagens.exibirPalavrasUnicas();

    // Removendo uma linguagem do conjunto
    conjuntoLinguagens.removerPalavra("Leite");
    conjuntoLinguagens.exibirPalavrasUnicas();

    // Removendo uma linguagem inexistente
    conjuntoLinguagens.removerPalavra("Luva");

    // Verificando se uma linguagem está no conjunto
    System.out.println("A linguagem 'Água' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Água"));
    System.out.println("A linguagem 'Farinha' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Farinha"));

    // Exibindo as linguagens únicas atualizadas no conjunto
    conjuntoLinguagens.exibirPalavrasUnicas();
  }
}
