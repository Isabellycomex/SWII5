/*
	Isabelly Barbosa Gonçalves CB3021467
	Lucas Aragão Almeida CB3013146
 */

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/books/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		bookDAO = new BookDAO();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		try {
			switch (action) {
			case "/add-book":
				insertBook(request, response);
				break;
			case "/update-book":
				updateBook(request, response);
				break;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		try {
			if (action == null)
				action = "/";

			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBook(request, response);
				break;
			case "/delete":
				deleteBook(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBook(request, response);
				break;
			default:
				showAllBooks(request, response);
				break;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private void showAllBooks(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		final List<Book> books = bookDAO.getAllBooks();

		request.setAttribute("books", books);

		request.getRequestDispatcher("/book-list.jsp").forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/book-form.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Book existingBook = bookDAO.getBook(id);
		
		request.setAttribute("book", existingBook);
		request.getRequestDispatcher("/book-form.jsp").forward(request, response);

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Book newBook = new Book(title, author, price);
		bookDAO.addBook(newBook);
		
		response.sendRedirect("/Bookstore/books");
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));

		Book book = new Book(id, title, author, price);
		bookDAO.updateBook(book);
		
		response.sendRedirect("/Bookstore/books");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		bookDAO.deleteBook(id);
		
		response.sendRedirect("/Bookstore/books");

	}
}