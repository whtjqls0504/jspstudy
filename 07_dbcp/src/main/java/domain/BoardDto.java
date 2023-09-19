package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
// @Builder은? 클래스 안에 클래스를 또 넣어 처리하는 방식이다. 
public class BoardDto {
  private int board_no;
  private String title;
  private String content;
  private Date modified_at;
  private Date created_at;
}
