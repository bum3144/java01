package basic.exam05.step06.homework;

public class Student {
  String name;
  int age;
  String tel;
  String email;
  String address;
  String teacher;
  String startDate;
  String endDate;
  String room;
  String adm;

  public static Student fromCSV(String value) {
    String[] data = value.split(",");

    Student obj = new Student();
    obj.name = data[0];
   // obj.age = Integer.parseInt(data[1]);
   // obj.tel = data[2];
   // obj.email = data[3];
   // obj.address = data[4];
    obj.teacher = data[1];
    obj.startDate = data[2];
    obj.endDate = data[3];
    obj.room = data[4];
    obj.adm = data[5];
    
    return obj;
  }

  
  
  
  @Override
  public String toString() {
    return name + "," + teacher + "," + startDate + "," + endDate + "," + room
        + "," + adm;
  }

}
