package Behaviors;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;


public class OpenMessage extends WakerBehaviour {

    public String function;

    public OpenMessage(Agent a, long timeout, String function) {
        super(a,timeout);
        this.function=function;
    }
    @Override
    protected void onWake() {
        System.out.println(getAgent().getLocalName()+ ", я готов");
        if(getAgent().getLocalName().equals("Line")) {
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            msg.addReceiver(new AID("Qua", false));
            msg.setContent("= Я закончил");
            System.out.println(getAgent().getLocalName() + " отправил " + msg.getContent());
            getAgent().send(msg);
            getAgent().addBehaviour(new ExseptionBehavior(getAgent(), 3000, function));
        }
        if(getAgent().getLocalName().equals("Qua")){
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            msg.addReceiver(new AID("Sin", false));
            msg.setContent("= Я закончил");
            System.out.println(getAgent().getLocalName() + " отправил х= " + msg.getContent());
            getAgent().send(msg);
            getAgent().addBehaviour(new ExseptionBehavior(getAgent(), 3000, function));
        }
        if(getAgent().getLocalName().equals("Sin")){
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            msg.addReceiver(new AID("Line", false));
            msg.setContent("= Я закончил");
            System.out.println(getAgent().getLocalName() + " отправил х= " + msg.getContent());
            getAgent().send(msg);
            getAgent().addBehaviour(new ExseptionBehavior(getAgent(), 3000, function));
        }
    }
}
