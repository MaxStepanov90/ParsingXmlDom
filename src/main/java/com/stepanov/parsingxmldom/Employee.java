package com.stepanov.parsingxmldom;

public class Employee {

    private String department;
    private Integer number;
    private String name;
    private Integer age;
    private Salary salary = new Salary();

    public static class Salary{
        private Double value;
        private String currency;

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Salary getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary.getValue() + " " + salary.getCurrency() +
                '}';
    }
}
