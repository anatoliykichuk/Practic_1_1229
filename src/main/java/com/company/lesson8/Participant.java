package com.company.lesson8;

public abstract class Participant implements Runable, Jumpable {

    public String name;
    public int runLimit;
    public double jumpLimit;
    public boolean isDroppOut;

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

    public int getRunLimit() {
        return runLimit;
    }

    public double getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Участник {");
        builder.append("имя: ").append(name);
        builder.append(", предел пробега: ").append(getRunLimit());
        builder.append(", предел прыжка: ").append(getJumpLimit());
        builder.append("}").append(System.lineSeparator());

        return builder.toString();
    }

    @Override
    public void run(Obstacle treadmill) {
        if (!(treadmill instanceof Treadmill) || isDroppOut) return;

        if (treadmill.isPossibly(getRunLimit())) {
            System.out.println(name + " побежал...");
        } else {
            isDroppOut = true;
            System.out.println(name + " не в силах больше бежать...");
        }
    }

    @Override
    public void jump(Obstacle wall) {
        if (!(wall instanceof Wall) || isDroppOut) return;

        if (wall.isPossibly(getJumpLimit())) {
            System.out.println(name + " прыгнул...");
        } else {
            isDroppOut = true;
            System.out.println(name + " не в силах больше прыгать...");
        }

    }

}
