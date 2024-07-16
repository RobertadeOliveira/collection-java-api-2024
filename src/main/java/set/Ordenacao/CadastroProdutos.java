package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
  //atributo
  private Set<Produto> produtoSet;

  public CadastroProdutos() {
    this.produtoSet = new HashSet<>();
  }

  public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
    produtoSet.add(new Produto(cod, nome, preco, quantidade));
  }

  public Set<Produto> exibirProdutosPorNome() {
    Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
    if (!produtoSet.isEmpty()) {
      return produtosPorNome;
    } else {
      throw new RuntimeException("O conjunto está vazio!");
    }
  }

  public Set<Produto> exibirProdutosPorPreco() {
    Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
    if (!produtoSet.isEmpty()) {
      produtosPorPreco.addAll(produtoSet);
      return produtosPorPreco;
    } else {
      throw new RuntimeException("O conjunto está vazio!");
    }
  }

  public static void main(String[] args) {
    // Criando uma instância do CadastroProdutos
    CadastroProdutos cadastroProdutos = new CadastroProdutos();

    // Adicionando produtos ao cadastro
    cadastroProdutos.adicionarProduto(1L, "Batedeira", 1900d, 10);
    cadastroProdutos.adicionarProduto(2L, "Laminadora", 1500d, 5);
    cadastroProdutos.adicionarProduto(3L, "Bowl", 30d, 20);
    cadastroProdutos.adicionarProduto(4L, "Forma", 50d, 15);

    // Exibindo todos os produtos no cadastro
    System.out.println(cadastroProdutos.produtoSet);

    // Exibindo produtos ordenados por nome
    System.out.println(cadastroProdutos.exibirProdutosPorNome());

    // Exibindo produtos ordenados por preço
    System.out.println(cadastroProdutos.exibirProdutosPorPreco());
  }
}
