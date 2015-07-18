package com.fcy.ioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;

/**
 * <p>ClassName: TestObjSerializeAndDeserialize<p>
 * <p>Description: 测试对象的序列化和反序列<p>
 * @author xudp
 * @version 1.0 V
 * @createTime 2014-6-9 下午03:17:25
 */
public class TestObjSerializeAndDeserialize {

    public static void main(String[] args) throws Exception {
    	Person person = new Person();
        person.setName("gacl");
        person.setAge(25);
        person.setSex("男");
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/Person.txt")));
        oo.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oo.close();
        System.out.println("Person: " + person);
        System.out.println("===========对象反序列化===========");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("E:/Person.txt")));
        Person person2 = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        System.out.println("person2: " + person2);
        System.out.println("person与person2比较：" + (person == person2));
        System.out.println("===========对象反序列化2===========");
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(new File("E:/Person.txt")));
        Person person3 = (Person) ois2.readObject();
        System.out.println("Person对象反序列化成功！");
        System.out.println("person2: " + person3);
        System.out.println("person与person2比较：" + (person3.equals(person2)));
    }
    
    /**
     * MethodName: SerializePerson 
     * Description: 序列化Person对象
     * @author xudp
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void SerializePerson() throws FileNotFoundException,
            IOException {
        Person person = new Person();
        person.setName("gacl");
        person.setAge(25);
        person.setSex("男");
        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/Person.txt")));
        oo.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

    /**
     * MethodName: DeserializePerson 
     * Description: 反序列Perons对象
     * @author xudp
     * @return
     * @throws Exception
     * @throws IOException
     */
    public static Person DeserializePerson() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("E:/Person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return person;
    }

}