/*
	Isabelly Barbosa Gonçalves CB3021467
	Lucas Aragão Almeida CB3013146
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/Bookstore";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "12345678";
	
	static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load MySQL driver", e);
        }
    }

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	public void addBook(Book book) {
		String query = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setFloat(3, book.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Book getBook(int id) {
		String query = "SELECT * FROM books WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getFloat("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		String query = "SELECT * FROM books";

		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				books.add(
						new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getFloat("price")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return books;
	}

	public void updateBook(Book book) {
		String query = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setFloat(3, book.getPrice());
			pstmt.setInt(4, book.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(int id) {
		String query = "DELETE FROM books WHERE id = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}