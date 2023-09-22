package repository;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.eclipse.jdt.internal.compiler.apt.model.Factory;


public class MemberDao {

  private SqlSessionFactory factory;
  private static MemberDao dao = new MemberDao();
  
  private MemberDao() {
    try {
      
      // SqlSessionFactory의 객체?
      String resource = "config/mybatis-config.xml";  
      InputStream in = Resources.getResourceAsStream(resource);   // mybatis-config의 입력스트림이다. 
      factory = new SqlSessionFactoryBuilder().build(in);
      
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }

  public static MemberDao getDao() {
    return dao;
  }
  
}
