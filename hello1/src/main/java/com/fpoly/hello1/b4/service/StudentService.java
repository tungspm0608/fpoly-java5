package com.fpoly.hello1.b4.service;

import com.fpoly.hello1.b4.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> list = new ArrayList<Student>();

    public StudentService() {
        list.add(new Student("ID01","Nguyen Duc Manh",19,"Ha Noi",true));
        list.add(new Student("ID02","Nguyen Duc Manh",19,"Ha Noi",true));
        list.add(new Student("ID03","Nguyen Duc Manh",19,"Ha Noi",true));
        list.add(new Student("ID04","Nguyen Duc Manh",19,"Ha Noi",true));
        list.add(new Student("ID05","Nguyen Duc Manh",19,"Ha Noi",true));
    }

    public List<Student> getAll() {
        return list;
    }

    public Student findById(String id) {
        for (Student s: list) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public void add(Student s) {
        list.add(s);
        System.out.println("Them");
    }
    public void update(Student s) {
        for (Student a: list) {
            if (a.getId().equalsIgnoreCase(s.getId())) {
                list.set(list.indexOf(a),s);
                System.out.println("Sua");
                return;
            }
        }
    }

    public void delete(String id) {
        List<Student> delList = new ArrayList<Student>();
        for (Student a: list) {
            if (a.getId().equalsIgnoreCase(id)) {
                delList.add(list.get(list.indexOf(a)));
                System.out.println("Xoa");
            }
        }
        list.removeAll(delList);
    }

}
