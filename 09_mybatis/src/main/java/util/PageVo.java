package util;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PageVo {

  private int page;     // 현재 페이지 번호
  private int total;     // 전체 항목의 개수
  private int display;  // 한 페이지에 표시할 항목의 개수 
  private int begin;    // 한 페이지에 표시되는 항목의 시작 번호 
  private int end;      // 한 페이지에 표시되는 항목의 종료 번호.
  
  private int totalPage;          // 전체 페이지 갯수.
  private int pagePerBlock  = 5;  // 한 블록에 표시되는 페이지의 갯수.
  private int beginPage;          // 한 블록에 표시되는 페이지의 시작 번호
  private int endPage;            // 한 블록에 표시되는 페이지의 종료 번호.
  
  // Setter
  public void setPaging(int page, int total, int display) {
    this.page = page;
    this.total = total;
    this.display = display;
    
    begin  = (page - 1) * display + 1;
    end = begin + display - 1;
    
    //if문을 사용한 계산한 정보 저장.
    if(end > total) {
      // end값이 total보다 크면 end와 total의 값을 동일하게 하라?
      end = total;
    }
    
    // 전체 페이지를 나타낼 때 필요한 정보 값
    totalPage = (int)Math.ceil((double) total / display);
    
    // 각 블록의 시작 페이지와 종료 페이지 계산
    // 
    beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
    endPage = beginPage + pagePerBlock - 1;
    
    if(endPage > totalPage) {
      endPage = totalPage;
    }
        
  }
  
  // Getter?
  public String getPaging(String url) {
    StringBuilder sb = new StringBuilder();
    sb.append("<div>");
    
    // 이전 블록
    if(beginPage == 1) {
      // 시작 페이지의 값이 1일 경우, <span>이전</span>만들기.
      sb.append("<span>이전</span>");
    } else {
      // 이전 페이지로 이동하기.
      sb.append("<a href=\"" + url + "?page=" + (beginPage - 1) + "\">이전</a>");
    }
    
    // 페이지번호
    for(int p=beginPage; p<=endPage; p++) {
      if(p == page) {
        sb.append("<span>" + p + "</span>");
      } else {
        sb.append("<a href=\"" + url + "?page=" + p + "\">" + p + "</a>");
      }
    }
    
    // 다음블록
    if(endPage == 1) {
      sb.append("<span>다음</span>");
    } else {
      sb.append("<a href=\"" + url +"?page=" + (endPage + 1) + "\">다음</a>");
    }
    sb.append("</div>");
    
    return sb.toString();
  }
  
}
