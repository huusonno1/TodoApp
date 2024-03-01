package todoapp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todoapp.dao.TodoDao;
import todoapp.dao.TodoDaoImpl;
import todoapp.model.Todo;


@WebServlet("/")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoDao todoDao;
	
	public void init() {
		todoDao = new TodoDaoImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertTodo(request, response);
				break;
			case "/delete":
				deleteTodo(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateTodo(request, response);
				break;
			case "/list":
				listTodo(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

	private void listTodo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Todo> listTodo = todoDao.selectAllTodos();
		request.setAttribute("listTodo", listTodo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
		dispatcher.forward(request, response);
	}

	private void updateTodo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void insertTodo(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, SQLException {
		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String description = request.getParameter("description");
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateTarget = LocalDate.parse(request.getParameter("targetDate"), df);
		
		boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
		
		Todo newTodo = new Todo(title, username, description, dateTarget, isDone);
		todoDao.insertTodo(newTodo);
	
		response.sendRedirect("list");
	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		todoDao.deleteTodo(id);
		response.sendRedirect("list");	
	}

	

}
