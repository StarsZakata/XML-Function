package Behaviors;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class ExseptionBehavior extends Behaviour {

    public boolean complete;
    public String function;

    public ExseptionBehavior(Agent a, long timeout, String function) {
        this.function=function;
    }
    @Override
    public void action() {
        System.out.println(getAgent().getLocalName()+ ", готов к получению информации");
        ACLMessage receive = getAgent().receive();
        if (receive != null){
            System.out.println(getAgent().getLocalName() + " получил данные = " + receive.getContent());
            getAgent().addBehaviour(new Calculate(getAgent(),function));
            complete=true;
        } else {
            block();
        }
    }
    @Override
    public boolean done() {
        return complete;
    }
}
