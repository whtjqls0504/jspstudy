package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public class ArticleServiceImpl implements ArticleService {

  // 모든 서비스가 공동으로 사용하는 ArticleDao, PageVo 객체 가져오기.
  
  @Override
  public ActionForward register(HttpServletRequest request) {
    
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
    // 제목 + 내용 -> ArticleDto 객체
    ArticleDto dto = 
    return null;
  }

  @Override
  public ActionForward getArticleList(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward getArticleDetail(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward editArticle(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward modifyArticle(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward deleteArticle(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

}
