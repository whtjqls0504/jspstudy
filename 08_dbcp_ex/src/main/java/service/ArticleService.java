package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public interface ArticleService {

  public ActionForward register(HttpServletRequest request);
  public ActionForward getArticleList(HttpServletRequest request);
  public ActionForward getArticleDetail(HttpServletRequest request);
  public ActionForward editArticle(HttpServletRequest request);
  public ActionForward modifyArticle(HttpServletRequest request);
  public ActionForward deleteArticle(HttpServletRequest request);

 
  
}
