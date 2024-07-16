package main.java.map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
  private Map<String, Livro> livros;

  public LivrariaOnline() {
    this.livros = new HashMap<>();
  }

  public void adicionarLivro(String link, Livro livro) {
    livros.put(link, livro);
  }

  public void removerLivro(String titulo) {
    List<String> chavesRemover = new ArrayList<>();
    for (Map.Entry<String, Livro> entry : livros.entrySet()) {
      if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
        chavesRemover.add(entry.getKey());
      }
    }
    for (String chave : chavesRemover) {
      livros.remove(chave);
    }
  }

  public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
    List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());

    Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());

    Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

    for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
      livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
    }

    return livrosOrdenadosPorPreco;
  }

  public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
    List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livros.entrySet());

    Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());

    Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

    for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
      livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
    }

    return livrosOrdenadosPorAutor;
  }

  public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
    Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
    for (Map.Entry<String, Livro> entry : livros.entrySet()) {
      Livro livro = entry.getValue();
      if (livro.getAutor().equals(autor)) {
        livrosPorAutor.put(entry.getKey(), livro);
      }
    }
    return livrosPorAutor;
  }

  public List<Livro> obterLivroMaisCaro() {
    List<Livro> livrosMaisCaros = new ArrayList<>();
    double precoMaisAlto = Double.MIN_VALUE;

    if (!livros.isEmpty()) {
      for (Livro livro : livros.values()) {
        if (livro.getPreco() > precoMaisAlto) {
          precoMaisAlto = livro.getPreco();
        }
      }
    } else {
      throw new NoSuchElementException("A livraria está vazia!");
    }

    for(Map.Entry<String, Livro> entry: livros.entrySet()) {
      if(entry.getValue().getPreco() == precoMaisAlto) {
        Livro livroComPrecoMaisAlto = livros.get(entry.getKey());
        livrosMaisCaros.add(livroComPrecoMaisAlto);
      }
    }
    return livrosMaisCaros;
  }

  public List<Livro> obterLivroMaisBarato() {
    List<Livro> livrosMaisBaratos = new ArrayList<>();
    double precoMaisBaixo = Double.MAX_VALUE;

    if (!livros.isEmpty()) {
      for (Livro livro : livros.values()) {
        if (livro.getPreco() < precoMaisBaixo) {
          precoMaisBaixo = livro.getPreco();
        }
      }
    } else {
      throw new NoSuchElementException("A livraria está vazia!");
    }

    for(Map.Entry<String, Livro> entry: livros.entrySet()) {
      if(entry.getValue().getPreco() == precoMaisBaixo) {
        Livro livroComPrecoMaisBaixo = livros.get(entry.getKey());
        livrosMaisBaratos.add(livroComPrecoMaisBaixo);
      }
    }
    return livrosMaisBaratos;
  }

  public static void main(String[] args) {
    LivrariaOnline livrariaOnline = new LivrariaOnline();
    // Adiciona os livros à livraria online
    livrariaOnline.adicionarLivro("https://acesse.one/E5j0P", new Livro("A Biblioteca da Meia-Noite", " Matt Haig", 28.34d));
    livrariaOnline.adicionarLivro("https://acesse.one/aGjFz", new Livro("A paciente silenciosa", "Alex Michaelides", 27.54d));
    livrariaOnline.adicionarLivro("https://acesse.one/KbjiG", new Livro("O Hobbit", "J.R.R. Tolkien", 29.85d));
    livrariaOnline.adicionarLivro("https://l1nk.dev/olR23", new Livro("Quarta asa: Edição Especial Limitada ", "Rebecca Yarros", 80.33d));
    livrariaOnline.adicionarLivro("https://acesse.one/9eeFG", new Livro("Mais esperto que o Diabo: O mistério revelado da liberdade e do sucesso", "Napoleon Hill", 18.43d));
    livrariaOnline.adicionarLivro("https://acesse.one/Mldn0", new Livro("O manuscrito original: As leis do triunfo e do sucesso de Napoleon Hill", "Napoleon Hill", 27.54d));

    // Exibe todos os livros ordenados por preço
    System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

    //Exibe todos os livros ordenados por autor
    System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

    // Pesquisa livros por autor
    String autorPesquisa = "Josh Malerman";
    livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

    // Obtém e exibe o livro mais caro
    System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

    // Obtém e exibe o livro mais barato
    System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

    // Remover um livro pelo título
    livrariaOnline.removerLivro("1984");
    System.out.println(livrariaOnline.livros);

  }
}
