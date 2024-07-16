package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
  //atributo
  private Map<String, Integer> palavras;

  public ContagemPalavras() {
    this.palavras = new HashMap<>();
  }

  public void adicionarPalavras(String palavra, Integer contagem) {
    palavras.put(palavra, contagem);
  }

  public void removerPalavra(String palavra) {
    if (!palavras.isEmpty()) {
      palavras.remove(palavra);
    } else {
      System.out.println("O Map está vazio.");
    }
  }

  public int exibirContagemPalavras() {
    int contagemTotal = 0;
    for (int contagem : palavras.values()) {
      contagemTotal += contagem;
    }
    return contagemTotal;
  }

  public String encontrarPalavrasMaisFrequente() {
    String palavraMaisFrequente = null;
    int maiorContagem = 0;
    for (Map.Entry<String, Integer> entry : palavras.entrySet()) {
      if (entry.getValue() > maiorContagem) {
        maiorContagem = entry.getValue();
        palavraMaisFrequente = entry.getKey();
      }
    }
    return palavraMaisFrequente;
  }

  public static void main(String[] args) {
    ContagemPalavras contagemPalavras = new ContagemPalavras();

    // Adiciona Palavras e suas contagens
    contagemPalavras.adicionarPalavras("Batedeira", 8);
    contagemPalavras.adicionarPalavras("Forma", 3);
    contagemPalavras.adicionarPalavras("Bowl", 1);
    contagemPalavras.adicionarPalavras("Laminadora", 6);

    // Exibe a contagem total de Palavras
    System.out.println("Existem " + contagemPalavras.exibirContagemPalavras() + " palavras.");

    // Encontra e exibe a palavra mais frequente
    String palavraMaisFrequente = contagemPalavras.encontrarPalavrasMaisFrequente();
    System.out.println("A palavra mais frequente é: " + palavraMaisFrequente);
  }
}
