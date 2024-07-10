/*
    Isabelly Barbosa Gonçalves CB3021467
    Lucas Aragão Almeida CB3013146
*/

package br.com.isabellycomex.tp02.product.database;

import br.com.isabellycomex.tp02.product.models.Produtos;

import java.util.ArrayList;
import java.util.List;

public final class Database {
    private static Database instance;
    private final List<Produtos> produtos;
    private Integer sequentialKey;

    private Database(List<Produtos> produtos, Integer sequentialKey) {
        this.produtos = produtos;
        this.sequentialKey = sequentialKey;
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database(new ArrayList<>(), 1);
        }

        return instance;
    }

    public List<Produtos> getProducts() {
        return produtos;
    }

    public Produtos getProductById(Integer id) {
        for (Produtos produtos : this.produtos) {
            if (produtos.getId().equals(id)) {
                return produtos;
            }
        }

        return null;
    }

    public Produtos addProduct(Produtos produtos) {
        produtos.setId(sequentialKey++);

        this.produtos.add(produtos);

        return produtos;
    }

    public Produtos updateProduct(Produtos produtos) {
        for (int i = 0; i < this.produtos.size(); i++) {
            if (this.produtos.get(i).getId().equals(produtos.getId())) {
                this.produtos.set(i, produtos);
                break;
            }
        }

        return produtos;
    }

    public void removeProduct(Integer id) {
        produtos.removeIf(produtos -> produtos.getId().equals(id));
    }
}
