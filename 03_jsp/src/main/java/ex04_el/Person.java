package ex04_el;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 인수가 없는 생성자.
@NoArgsConstructor
// 인수가 있는 매개변수 생성자
@AllArgsConstructor

// Getter, Setter 설정
@Getter
@Setter

public class Person {

  // field
  private String name;
  private int age;

  
}
