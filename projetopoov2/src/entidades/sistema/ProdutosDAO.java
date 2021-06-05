package entidades.sistema;

import java.util.List;

public interface ProdutosDAO {
    void adicionar(Produtos p);
    List<Produtos> pesquisarPorTipo(String Tipo);
    void apagarPorId(long id);
    void atualizar(long id, Produtos p);
}
