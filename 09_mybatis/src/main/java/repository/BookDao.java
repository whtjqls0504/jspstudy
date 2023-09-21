package repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.BookDto;

public class BookDao {

  // mybatis의 SqlSession을 만들 수 있는 SqlSessionFactory 선언
  private SqlSessionFactory factory;
  
  // Singleton Pattern
  // Dao 타입의 객체를 만들자.
  
  private static BookDao dao = new BookDao();
  
  private BookDao() {
    // SqlSessionFactory 생성
    try {
      String resource = "mybatis/config/mybatis-config.xml";
      InputStream in = Resources.getResourceAsStream(resource);
      factory = new SqlSessionFactoryBuilder().build(in);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  public static BookDao getDao() {
    return dao;
  }
  
  // 매퍼의 namespace
  private final String NS = "mybatis.mapper.book.";
  
  
  // 전체 개수 반환 메소드
  // Book.xml -> Count(*)를 반환해야함.
  public int bookCount() {
    SqlSession ss = factory.openSession();
    int count = ss.selectOne("mybatis.mapper.book.bookCount");
    // 세션을 명시적으로 닫아야한다. (캐시 및 정보 등등..)
    ss.close();
    return count;
  }
  
  // 목록 반환 메소드
  public List<BookDto> bookList(Map<String, Object> map){
    SqlSession ss = factory.openSession();
    // mapper의 namespace를 복사하고 select id를 각각 지정해준다. map을 보내야 하니, 뒤에 map을 붙임.
    List<BookDto> list = ss.selectList(NS + "bookList", map);
    ss.close();
    return list;
  }
  
  // 상세 반환 메소드
  public BookDto bookDetail(int bookNo) {
    SqlSession ss = factory.openSession();
    BookDto dto = ss.selectOne(NS + "bookDetail", bookNo);
    ss.close();
    return dto;
  }
  
  
  // 등록 메소드
  public int bookAdd(BookDto dto) {
    SqlSession ss = factory.openSession(false);   // 내가 알아서 커밋하겠다는 뜻. (openSession auto Commit은 자동 커밋이다.)
    int addResult = ss.insert(NS +"bookAdd", dto);
    if(addResult == 1) {
      // result 값이 1일때, commit
      ss.commit();
    }
    ss.close();
    return addResult;
  }
  
  // 수정 메소드
  public int bookModify(BookDto dto) {
    SqlSession ss = factory.openSession(false);
    int modifyResult = ss.update(NS + "bookModify", dto);
    if(modifyResult == 1) {
      ss.commit();
    }
    ss.close();
    return modifyResult;
  }
  
  // 삭제 메소드
  public int bookDelete(BookDto dto) {
    SqlSession ss = factory.openSession(false);
    int deleteResult = ss.delete(NS + "bookDelete", dto);
    if(deleteResult == 1) {
      ss.commit();
    }
    ss.close();
    return deleteResult;
  }
  
  
}
