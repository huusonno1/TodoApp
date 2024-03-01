package todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import todoapp.model.Todo;
import todoapp.utils.JDBCUtils;

public class TodoDaoImpl implements TodoDao{
	
	private static final String INSERT_TODOS_SQL = "INSERT INTO todos" 
					+ " (title, username, description, target_date, is_done) VALUES " + " (?, ?, ?, ?, ?);";
	
	private static final String SELECT_ALL_TODOS = "select * from todos";
	
	private static final String DELETE_TODO_BY_ID = "delete from todos where id = ?;";
	
	public TodoDaoImpl() {
		
	}

	@Override
	public void insertTodo(Todo todo) throws SQLException {
		
		System.out.println(INSERT_TODOS_SQL);
		
		try (Connection connection = JDBCUtils.getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODOS_SQL)) {
			preparedStatement.setString(1, todo.getTitle());
			preparedStatement.setString(2, todo.getUsername());
			preparedStatement.setString(3, todo.getDescription());
			preparedStatement.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
			preparedStatement.setBoolean(5, todo.isStatus());
			
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Todo selectTodo(long todoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Todo> selectAllTodos() {
		List<Todo> todos = new ArrayList<Todo>();
		
		try (Connection connection = JDBCUtils.getConnection();
						PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS)) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String username = rs.getString("username");
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				boolean isDone = rs.getBoolean("is_done");
				todos.add(new Todo(id, title, username, description, targetDate, isDone));
			}
			
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return todos;
	}

	@Override
	public boolean deleteTodo(int id) throws SQLException {
		boolean rowDeleted ;
		try (Connection connection = JDBCUtils.getConnection();
						PreparedStatement statement = connection.prepareStatement(DELETE_TODO_BY_ID)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} 
		return rowDeleted;
	}

	@Override
	public boolean updateTodo(Todo todo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
