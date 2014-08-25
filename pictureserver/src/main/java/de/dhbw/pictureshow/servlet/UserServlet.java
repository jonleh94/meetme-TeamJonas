package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
  private static final Logger log = LoggerFactory.getLogger(UserServlet.class);

  @Inject UserDao userDao;
  @Inject Transaction transaction;


  @PostConstruct
  public void initDb() {
    log.debug("Hallo Servlet");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    log.error("Hallo get");

    User user = new User();
    user.setName("User1");
    transaction.begin();
    userDao.persist(user);
    transaction.commit();

    response.setContentType("text/html");
    response.setBufferSize(8192);
    try (PrintWriter out = response.getWriter()) {
      out.println("<html lang=\"en\"><head><title>Servlet Hello</title></head>");

      // then write the data of the response
      out.println("<body  bgcolor=\"#ffffff\">"
          + "<h2>Hello World!</h2>" + userDao.list());

      String username = request.getParameter("username");
      if (username != null && username.length() > 0) {
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher("/response");

        if (dispatcher != null) {
          dispatcher.include(request, response);
        }
      }
      out.println("</body></html>");
    }
  }

}
