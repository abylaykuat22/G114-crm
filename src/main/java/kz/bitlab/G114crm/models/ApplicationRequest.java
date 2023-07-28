package kz.bitlab.G114crm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
  private Long id;
  private String userName;
  private String courseName;
  private String commentary;
  private String phone;
  private boolean handled; //обработано или нет
}
