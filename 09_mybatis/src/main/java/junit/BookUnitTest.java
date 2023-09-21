package junit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import domain.BookDto;
import repository.BookDao;

/*
 * 1. JUnit4 단위 테스트 수행 방법
 *  1) JUnit Test Case 파일 추가
 *  2) @Test 애너테이션이 추가된 테스트 메소드 작성
 *  3) [Run As] - [JUnit Test]
 *  
 *  2. JUnit4 단위 테스트 주요 애너테이션
 *    1) @Test      : 실제 테스트 수행
 *    2) @Before    : @Test 이전에 수행
 *    3) @BeforeAll : JUnit Test Case(BookUnitTest.java) 수행 이전, static 필수
 *    4) @After     : @Test 이후에 수행
 *    5) @AfterAll  : JUnit Test Case(BookUnitTest.java) 수행 이후, static 필수
 *    
 *  3. JUnit5 단위 테스트 주의사항
 *    1) 영속 계층(Dao)을 테스트 한다.
 *    2) WAS(Tocat)의 개입이 없으므로 WAS가 필요한 코드는 테스트 불가하다.
 *    3) 메소드 이름을 한글로 작성해도 상관없다.
 */

public class BookUnitTest {

    // Dao
    private BookDao dao = BookDao.getDao();
    
    
    // @Test
    public void 책_등록_테스트() {
      // 등록할 BookDto 생성
      BookDto dto = BookDto.builder()
                     .title("테스트제목")
                     .author("테스트저자")
                     .price(99999)
                     .build();
    
    // BookDto 등록
    int addResult = dao.bookAdd(dto);
    
    // 등록 결과 확인.
    assertEquals(1, addResult);
    
    }

    
    //@Test
    public void 책_조회_테스트() {
      
      // 조회할 책 번호
      int bookNo = 1;
      
      // 조회
      BookDto dto = dao.bookDetail(bookNo);
      
      // 조회 결과 확인
      assertNotNull(dto);
    }
    
    @Test
    public void 책_목록_테스트() {
      
      
      // begin end를 가진 Map 생성
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("begin", 1);
      map.put("end", 20);
      
      
      // 목록 가져오기
      List<BookDto> list = dao.bookList(map);
      
      // 결과 확인
      assertEquals(1, list.size());
    }
    
    //@Test
    public void 책_수정_테스트() {
      
    }
    
    //@Test
    public void 책_삭제_테스트() {
      
    }
    
}