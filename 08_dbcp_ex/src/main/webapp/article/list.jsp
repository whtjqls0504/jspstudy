<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
  .article span {
    margin-right: 20px;
  }
</style>
<script>

  $(function(){
    fnCheckbox();
  })

  function fnCheckbox(){
    $('#chk_all').click(function(){
      $('.chk_each').prop('checked', $(this).prop('checked'));
    })
    $('.chk_each').click(function(){
      let total = 0;
      $.each($('.chk_each'), function(i, elem){
        total += elem.checked;
      })
      $('#chk_all').prop('checked', total === $('.chk_each').length);
    })
  }

  function fnArticleDelete() {
    
    // 진짜 누른게 맞는지 확인하는 제어문
    if(!confirm('선택한 기사들을 삭제할까요?')){
    	// 아래의 코드 실행x
      return;
    }
    
    let array = [];
    
    // 이걸 만들었으면 click 이벤트를 만들 필요가 없다.
    // $.each(배열, function(인덱스, 요소){})
    $.each($('.chk_each'), function(i, elem){
			if($(elem).is(':checked')){
				array.push($(elem).val());	  
			}
    })
    location.href = '${contextPath}/deleteArticle.do?articles=array.join(',');
    //array === ['1', '2', '3']
    //array.join(',') === ['1,2,3']
  }
  
</script>
</head>
<body>

  <div>
    <a href="${contextPath}/writeArticle.do">기사작성하러가기</a>
    <a href="javascript:fnArticleDelete()">선택한 기사 삭제하기</a>
  </div>

  <hr>
  
  <div>
    <input type="checkbox" id="chk_all">
    <label for="chk_all">전체선택</label>
  </div>

  <hr>
  
  <div>
  <c:if test="${empty articleList}">
    <div>작성된 기사가 없습니다.</div>
  </c:if>
  <c:if test="${not empty articleList}">
    <c:forEach items="${articleList}" var="article">
      <div class="article">
        <input type="checkbox" class="chk_each" value="${article.article_no}">
        <span>${article.article_no}</span>
        <span><a href="${contextPath}/plusHit.do?article_no=${article.article_no}">${article.title}</a></span>
        <span>${article.hit}</span>
        <span>${article.created}</span>
      </div>
    </c:forEach>
  </c:if>
  </div>
  
  <div>${paging}</div>

</body>
</html>