package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
  private Map<String, String> dicionario;

  public Dicionario() {
    this.dicionario = new HashMap<>();
  }

  public void adicionarPalavra(String palavra, String definicao) {
    dicionario.put(palavra, definicao);
  }

  public void removerPalavra(String palavra) {
    if (!dicionario.isEmpty()) {
      dicionario.remove(palavra);
    } else {
      System.out.println("O dicionário está vazio.");
    }
  }

  public String pesquisarPorPalavra(String palavra) {
    String definicao = dicionario.get(palavra);
    if (definicao != null) {
      return definicao;
    }
    return "Palavra não encontrada no dicionário.";
  }

  public void exibirPalavras() {
    if (!dicionario.isEmpty()) {
      System.out.println(dicionario);
    } else {
      System.out.println("O dicionário está vazio.");
    }
  }

  public static void main(String[] args) {
    Dicionario dicionario = new Dicionario();

    // Adicionar palavras (Palavras de programação)
    dicionario.adicionarPalavra("fermento", "Agente (uma enzima, um organismo) capaz de provocar a fermentação; levedura.");
    dicionario.adicionarPalavra("farinha", "Pó obtido pela moagem de certos cereais.");
    dicionario.adicionarPalavra("manteiga", "Produto alimentar, gorduroso, que se obtém batendo a nata do leite.");

    // Exibir todas as palavras
    dicionario.exibirPalavras();

    // Pesquisar palavras
    String definicaoJava = dicionario.pesquisarPorPalavra("fermento");
    System.out.println("Definição do elemento 'fermento': " + definicaoJava);

    String definicaoCSharp = dicionario.pesquisarPorPalavra("margarina");
    System.out.println(definicaoCSharp);

    // Remover uma palavra
    dicionario.removerPalavra("manteiga");
    dicionario.exibirPalavras();
  }
}