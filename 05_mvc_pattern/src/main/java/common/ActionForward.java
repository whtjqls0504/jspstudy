package common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
// @Data는 Getter와 Setter 둘다 포함
public class ActionForward {

  private String path;  // 어디로 갈래
  private boolean isRedirect; // redirect는 true, forward는 false
  
  
}
