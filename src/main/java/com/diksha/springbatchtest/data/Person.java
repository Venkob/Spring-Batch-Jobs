package com.diksha.springbatchtest.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
 
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Person {
 
  private String firstName;
  private String lastName;
}