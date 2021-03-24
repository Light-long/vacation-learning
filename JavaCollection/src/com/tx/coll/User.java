package com.tx.coll;

import java.util.Objects;

public class User implements Comparable{
    private String name;
    private Integer age;

    public User() {}
    public User(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(name, user.name)) return false;
        return Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }


    @Override
    // 按照名字从小到大，年龄从大到小
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            int compare = this.name.compareTo(user.name);
            if (compare != 0) {
                return compare;
            } else {
                return -Integer.compare(this.age,user.age);
            }
        }
        throw new RuntimeException("不是此类对象，不能比较");
    }
}
