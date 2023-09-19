package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import domain.BoardDto;

public class BoardServiceImpl implements BoardService {

  @Override
  public ActionForward register(HttpServletRequest request) {

    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    // 제목 + 내용 -> BoardDto 객체
    // builder은
    BoardDto dto = BoardDto.builder()
                           .title(title)
                           .content(content)
                           .build();
     
    System.out.println(dto);
    
    return null;
  }

}
