package Agents;

import Behaviors.Calculate;
import Behaviors.ExseptionBehavior;
import CreateXML.Fun;
import CreateXML.XmlHelper;
import jade.core.Agent;

public class FunAgent extends Agent {

    public String partsline;
    public String partsqua;
    public String partssin;

    @Override
    protected void setup() {
       System.out.println(this.getLocalName() + " - i was born");
       parseConfig(this.getLocalName());
    }
    private void parseConfig(String NameAgent) {

        if(NameAgent.equals("Line")){
            System.out.println("Линейное уравнение");
            String will = "S://Project//LR2//" + NameAgent + ".xml";
            Fun line = XmlHelper.unMarshalAny(Fun.class, will);
            partsline = line.getFunction();
            addBehaviour(new Calculate(this,partsline));
        }
        if (NameAgent.equals("Qua")) {
             System.out.println("Квадритичное уравнение");
             String qua1 = "S://Project//LR2//" + NameAgent + ".xml";
             Fun qua = XmlHelper.unMarshalAny(Fun.class, qua1);
             partsqua = qua.getFunction();
             addBehaviour(new ExseptionBehavior(this,3000, partsqua));
        }
        if (NameAgent.equals("Sin")) {
            System.out.println("Синусоидальное уравнение");
            String sin1 = "S://Project//LR2//" + NameAgent + ".xml";
            Fun sin = XmlHelper.unMarshalAny(Fun.class, sin1);
            partssin = sin.getFunction();
            addBehaviour(new ExseptionBehavior(this,3000, partssin));
        }
    }

}


