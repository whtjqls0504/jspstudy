/**
 * 본문을 모두 읽은 뒤 JavaScript를 수행할 수 있도록 load 이벤트를 발생시킨다.
 방법1. window.onload = function(){
 방법2. $(document).ready(function(){})
 방법3. $(function(){})
}
 */
 
 $(function(){	
	
// 마우스 갖다 댔을때 ~^^
 $('.gnb a').mouseover(function () {
			$(this).css('background-color', 'silver');	
	  })
	  $('.gnb a').mouseout(function () {
      $(this).css('background-color', '');      

})
    
    // js파일은 당연히 jsp인 <%=contextPath%> 쓸수 없다.
  var img = new Image();
  $(img).attr('src', getContextPath() + '/resource/image/naver.png');
  $(img).css('width', '150px');
  $('.logo').html(img);


})

// 컨텍스트 패스를 반환하는 함수
function getContextPath(){
	// location.href === http://localhost:8080/jsp/ex03_layout/main1.jsp
	// location.host === location:8080
  var begin = location.href.indexOf(location.host) + location.host.length;
  var end = location.href.indexOf('/', begin + 1);
  return location.href.substring(begin, end);
	// '/' 인덱스를 반환하는데 begin 값 : 8080/jsp 다음으로 찾으라는 뜻.

	
}