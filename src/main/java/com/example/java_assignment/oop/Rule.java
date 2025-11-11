package com.example.java_assignment.oop;

public class Rule extends BaseEntity {
    private String ruleName;

    public Rule(Long id, String ruleName) {
        super(id);
        this.ruleName = ruleName;
    }

    @Override
    public void printInfo() {
        System.out.println("Rule Id:  " + getId());
        System.out.println("Rule name: " + ruleName);
    }
}
