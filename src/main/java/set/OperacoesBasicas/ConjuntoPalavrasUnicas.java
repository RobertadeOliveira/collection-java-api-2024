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
    ConjuntoPalavrasUnicas conjuntoPalavras = new ConjuntoPalavrasUnicas();

    // Adicionando Palavras únicas ao conjunto
    conjuntoPalavras.adicionarPalavra("Água");
    conjuntoPalavras.adicionarPalavra("Farinha");
    conjuntoPalavras.adicionarPalavra("Fermento");
    conjuntoPalavras.adicionarPalavra("Manteiga");
    conjuntoPalavras.adicionarPalavra("Açúcar");
    conjuntoPalavras.adicionarPalavra("Leite");

    // Exibindo as Palavras únicas no conjunto
    conjuntoPalavras.exibirPalavrasUnicas();

    // Removendo uma palavra do conjunto
    conjuntoPalavras.removerPalavra("Leite");
    conjuntoPalavras.exibirPalavrasUnicas();

    // Removendo uma palavra inexistente
    conjuntoPalavras.removerPalavra("Luva");

    // Verificando se uma palavra está no conjunto
    System.out.println("A palavra 'Água' está no conjunto? " + conjuntoPalavras.verificarPalavra("Água"));
    System.out.println("A palavra 'Farinha' está no conjunto? " + conjuntoPalavras.verificarPalavra("Farinha"));

    // Exibindo as Palavras únicas atualizadas no conjunto
    conjuntoPalavras.exibirPalavrasUnicas();
  }
}
