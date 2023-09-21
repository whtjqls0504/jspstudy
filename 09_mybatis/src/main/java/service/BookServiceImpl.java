package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import domain.BookDto;
import oracle.sql.INTERVALDS;
import repository.BookDao;
import util.PageVo;

public class BookServiceImpl implements BookService {
  
  private BookDao dao = BookDao.getDao();
  private PageVo pageVo = new PageVo();
  
  // 책 리스트.
  @Override
  public ActionForward bookList(HttpServletRequest request) {
    Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
    int page = Integer.parseInt(opt.orElse("1"));
    int total = dao.bookCount();
    int display = 10;
    pageVo.setPaging(page, total, display);
    // 게시글 목록을 가져올 때 사용할 변수들을 Map으로 만든다.
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("begin", pageVo.getBegin());
    map.put("end", pageVo.getEnd());
    List<BookDto> bookList = dao.bookList(map);
    request.setAttribute("bookList", bookList);
    request.setAttribute("paging", pageVo.getPaging(request.getContextPath() + "/book/list.do"));
    return new ActionForward("/book/list.do", false);
  }



  @Override
  public ActionForward bookDetail(HttpServletRequest request) {
    // bookNo의 번호를 가져온다.
    Optional<String> opt = Optional.ofNullable(request.getParameter("bookNo"));
    int bookNo = Integer.parseInt(opt.orElse("0"));
    BookDto book = dao.bookDetail(bookNo);
    
    request.setAttribute("book", book);
    
    return new ActionForward("/book/detail.jsp", false);
  }

  
  // 책 추가
  @Override
  public ActionForward bookAdd(HttpServletRequest request) {
      

    return null;
  }

  @Override
  public ActionForward bookModify(HttpServletRequest request) {
    return null;
  }

  @Override
  public ActionForward bookDelete(HttpServletRequest request) {
    Optional<String> opt = Optional.ofNullable(request.getParameter("bookNo"));

    return null;
  }

}
