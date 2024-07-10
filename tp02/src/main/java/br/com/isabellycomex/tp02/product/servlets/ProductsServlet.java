/*
    Isabelly Barbosa Gonçalves CB3021467
    Lucas Aragão Almeida CB3013146
*/

package br.com.isabellycomex.tp02.product.servlets;

import br.com.isabellycomex.tp02.product.database.Database;
import br.com.isabellycomex.tp02.product.models.Produtos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products/*")
public class ProductsServlet extends HttpServlet {
    private Database database;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        database = Database.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String action = req.getPathInfo();

        if (action.equals("/add-product")) {
            final String name = req.getParameter("name");
            final Integer quantity = Integer.valueOf(req.getParameter("quantity"));
            final String description = req.getParameter("description");
            final Double monthlyExpectedQuantity = Double.valueOf(req.getParameter("monthlyExpectedQuantity"));
            final Double maxBoughtPrice = Double.valueOf(req.getParameter("maxBoughtPrice"));

            Produtos produtos = new Produtos();
            produtos.setNome(name);
            produtos.setUnidadeCompra(quantity);
            produtos.setDescricao(description);
            produtos.setQtdPrevistoMes(monthlyExpectedQuantity);
            produtos.setPrecoMaxComprado(maxBoughtPrice);

            database.addProduct(produtos);

            resp.sendRedirect("/tp02_war_exploded/products");

            return;
        }

        if (action.equals("/update-product")) {
            final String id = req.getParameter("id");
            final String name = req.getParameter("name");
            final Integer quantity = Integer.valueOf(req.getParameter("quantity"));
            final String description = req.getParameter("description");
            final Double monthlyExpectedQuantity = Double.valueOf(req.getParameter("monthlyExpectedQuantity"));
            final Double maxBoughtPrice = Double.valueOf(req.getParameter("maxBoughtPrice"));

            Produtos produtos = new Produtos();
            produtos.setId(Integer.valueOf(id));
            produtos.setNome(name);
            produtos.setUnidadeCompra(quantity);
            produtos.setDescricao(description);
            produtos.setQtdPrevistoMes(monthlyExpectedQuantity);
            produtos.setPrecoMaxComprado(maxBoughtPrice);

            database.updateProduct(produtos);

            resp.sendRedirect("/tp02_war_exploded/products");

            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String action = req.getPathInfo();

        if (action == null) {
            showAllProducts(req, resp);
            return;
        }

        switch (action) {
            case "/new":
                showNewFormProduct(req, resp);
                break;
            case "/edit":
                showUpdateFormProduct(req, resp);
                break;
            case "/delete":
                deleteProduct(req, resp);
                break;
            default:
                break;
        }
    }

    private void showAllProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Produtos> products = database.getProducts();

        req.setAttribute("products", products);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/products.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewFormProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void showUpdateFormProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Integer id = Integer.valueOf(req.getParameter("id"));
        final Produtos product = database.getProductById(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productForm.jsp");

        req.setAttribute("product", product);

        dispatcher.forward(req, resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Integer id = Integer.valueOf(req.getParameter("id"));
        database.removeProduct(id);
        resp.sendRedirect("/tp02_war_exploded/products");
    }
}
