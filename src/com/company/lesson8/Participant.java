package com.company.lesson8;

public abstract class Participant implements Runable, Jumpable {

    public String name;
    public int runLimit;
    public double jumpLimit;

    public Participant(String name) {
        this.name = name;
    }

    public Participant(String name, int runLimit, double jumpLimit) {
        this.name = name;
        setRunLimit(runLimit);
        setJumpLimit(jumpLimit);
    }

    public void setRunLimit(int runLimit) {
        if (runLimit > 0) {
            this.runLimit = runLimit;
        } else {
            System.out.println("Укажите реальный предел пробега");
        }
    }

    public void setJumpLimit(double jumpLimit) {
        if (jumpLimit > 0) {
            this.jumpLimit = jumpLimit;
        } else {
            System.out.println("Укажите реальный предел прыжка");
        }
    }

    public String getName() {
        return name;
    }

    public int getRunLimit() {
        return runLimit;
    }

    public double getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public void run() {
        System.out.println(getName() + " побежал...");
    }

    @Override
    public void jump() {
        System.out.println(getName() + " прыгнул...");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Участник {");
        builder.append("имя: ").append(getName());
        builder.append(", предел пробега: ").append(getRunLimit());
        builder.append(", предел прыжка: ").append(getJumpLimit());
        builder.append("}").append(System.lineSeparator());

        return builder.toString();
    }

}
