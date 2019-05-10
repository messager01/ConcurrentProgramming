package com.xdclass.atomic.demo3;


import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/*
*
*      AtomicLongFieldUpdater
* */
public class AtomicLongFieldUpdater {


    public static void main(String[] args) {
        java.util.concurrent.atomic.AtomicLongFieldUpdater<Student> longFieldUpdater =
                java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(Student.class, "id");
        Student student = new Student(1L, "史沛鑫");
        longFieldUpdater.compareAndSet(student,1L,100L);
        System.out.println(student.id);


        AtomicReferenceFieldUpdater<Student, String> referenceFieldUpdater
                = AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");
        referenceFieldUpdater.compareAndSet(student, "史沛鑫", "哈哈");
        System.out.println(student.name);

    }

}
class Student{
     volatile long  id;
    volatile String name;

    public Student(Long id,String name){
        this.name  = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}