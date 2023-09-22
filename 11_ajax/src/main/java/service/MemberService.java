package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.MemberDto;

public interface MemberService {

  // 응답은 하지만, 반환하지 않는다. 
  // 직접 응답하는 형태이다.
  // ()안에 들어가는 것은 reponse forwarding도 X
  
  // 그리고 뒤에 throws를 붙이는 이유:
  // 기존 response 앞에 들어가는 printWriter 대신. 
  public void getMemberList(HttpServletResponse response) throws IOException;
  public void memberAdd(HttpServletRequest request, HttpServletResponse  response) throws IOException;
  public void memberEmailCheck(HttpServletRequest request, HttpServletResponse  response) throws IOException;
  public void memberDetail(HttpServletRequest request, HttpServletResponse  response) throws IOException;
  
}
  


