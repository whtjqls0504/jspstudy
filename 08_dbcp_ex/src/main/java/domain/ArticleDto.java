package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleDto {

  private int article_no;
  private String title;
  private String content;
  private String editor;
  private int hit;
  private Date lastmodified;
  private Date created;
  
}
