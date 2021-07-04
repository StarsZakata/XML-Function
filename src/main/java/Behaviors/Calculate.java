package Behaviors;


import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;

public class Calculate extends Behaviour {


    public boolean stopBehavior = false;
    public String function;

    public static double x=-5;
    public static double delta=2.0;

    public static double yline=0;
    public static double yqua=0;
    public static double ysin=0;

    public Calculate(Agent a, String function) {
        this.function = function;
    }

    @Override
    public void action() {
        System.out.println(getAgent().getLocalName() + " решаю задачу");
        System.out.println();
        if (getAgent().getLocalName().equals("Line")) {

            double ymin = Parser.parserLine(this.x-this.delta, function);
            double ysred = Parser.parserLine(this.x, function);
            double ymax = Parser.parserLine(this.x+this.delta, function);
            System.out.println();
            System.out.println("Min= "+ymin);
            System.out.println("Sred= "+ysred);
            System.out.println("Mxax= "+ymax);
            System.out.println();
            if(ymin > ysred && ymin>ymax){
                this.yline=ymin;
                this.x=this.x-this.delta;
            }
            if(ysred > ymin && ysred>ymax){
                this.yline=ysred;
                this.delta=delta/2;
            }
            if(ymax > ysred && ymax>ymin){
                this.yline=ymax;
                this.x=this.x+this.delta;
            }
            System.out.println();
            System.out.println("Дельта= "+delta);
            System.out.println("x= "+x);
            System.out.println("yline= "+yline);
            System.out.println();
            if(this.delta<0.001){
                getAgent().addBehaviour(new OneShotBehaviour(){
                    @Override
                    public void action() {
                        System.out.println("Получили значение y= "+(yqua+yline+ysin));
                        System.out.println("Получил значение х=" +x);
                    }
                });
                stopBehavior = true;
            }

            System.out.println("Перехожу в режим ожидания");
            getAgent().addBehaviour(new OpenMessage(getAgent(), 2000, function));
            stopBehavior = true;
        }
        if (getAgent().getLocalName().equals("Qua")) {

            double ymin = Parser.parserQua(this.x-this.delta, function);
            double ysred = Parser.parserQua(this.x, function);
            double ymax = Parser.parserQua(this.x+delta, function);
            System.out.println();
            System.out.println("Min= "+ymin);
            System.out.println("Sred= "+ysred);
            System.out.println("Mxax= "+ymax);
            System.out.println();

            if(ymin > ysred && ymin>ymax){
                this.yqua=ymin;
                this.x=this.x-this.delta;
            }
            if(ysred > ymin && ysred>ymax){
                this.yqua=ysred;
                this.delta=delta/2;
            }
            if(ymax > ysred && ymax>ymin){
                this.yqua=ymax;
                this.x=this.x+this.delta;
            }
            System.out.println();
            System.out.println("Дельта= "+delta);
            System.out.println("x= "+x);
            System.out.println("yqua= "+yqua);
            System.out.println();
            if(this.delta<0.001){
                getAgent().addBehaviour(new OneShotBehaviour(){
                    @Override
                    public void action() {
                        System.out.println("Получили значение y= "+(yqua+yline+ysin));
                        System.out.println("Получил значение х=" +x);
                    }
                });
                stopBehavior = true;
            }
            System.out.println("Перехожу в режим ожидания");
            getAgent().addBehaviour(new OpenMessage(getAgent(), 2000, function));
            stopBehavior = true;
        }
        if (getAgent().getLocalName().equals("Sin")) {

            double ymin = Parser.parserSin(this.x-this.delta, function);
            double ysred = Parser.parserSin(this.x, function);
            double ymax = Parser.parserSin(this.x+delta, function);
            System.out.println();
            System.out.println("Min= "+ymin);
            System.out.println("Sred= "+ysred);
            System.out.println("Mxax= "+ymax);
            System.out.println();

            if(ymin > ysred && ymin>ymax){
                this.ysin=ymin;
                this.x=this.x-this.delta;
            }
            if(ysred > ymin && ysred>ymax){
                this.ysin=ysred;
                this.delta=delta/2;
            }
            if(ymax > ysred && ymax>ymin){
                this.ysin=ymax;
                this.x=this.x+this.delta;
            }
            System.out.println();
            System.out.println("Дельта= "+delta);
            System.out.println("x= "+x);
            System.out.println("ysin= "+ysin);
            System.out.println();
            if(this.delta<0.001){
                getAgent().addBehaviour(new OneShotBehaviour(){
                    @Override
                    public void action() {
                        System.out.println("Получили значение y= "+(yqua+yline+ysin));
                        System.out.println("Получил значение х=" +x);
                    }
                });
                stopBehavior = true;
            }
            System.out.println("Перехожу в режим ожидания");
            getAgent().addBehaviour(new OpenMessage(getAgent(), 2000, function));
            stopBehavior = true;
        }
    }
    @Override
    public boolean done() {
        return stopBehavior;
    }
}
