package kz.bitlab.G114crm.db;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.G114crm.models.ApplicationRequest;
import lombok.Getter;

public class DBManager {
  @Getter
  private static List<ApplicationRequest> arList = new ArrayList<>();

  static {
    arList.add(new ApplicationRequest(1L, "Ильяс Ж.", "Spring Boot", "скок стоит", "+7-708-545-14-89", false));
    arList.add(new ApplicationRequest(2L, "Назгуль", "Spring Boot", "изучаю", "+7-708-545-14-89", false));
    arList.add(new ApplicationRequest(3L, "Асылжан", "Spring Boot", "изи", "+7-708-545-14-89", true));
    arList.add(new ApplicationRequest(4L, "Алдияр", "Spring Boot", "не совсем все понимаю", "+7-708-545-14-89", false));
    arList.add(new ApplicationRequest(5L, "Аян", "Spring Boot", "изучаю", "+7-708-545-14-89", false));
  }

}
