package CreateXML;

public class XmlMain {

    public static void main(String[] args) {
        //Линейное
        Fun line = new Fun();
        line.setFunction("+2*x+5");
        XmlHelper.marshalAny(line, "Line.xml");
        //Квадратичное
        Fun qua = new Fun();
        qua.setFunction("-x*x+1");
        XmlHelper.marshalAny(qua, "Qua.xml");
        //Синусоидальное
        Fun sin = new Fun();
        sin.setFunction("-2*sin(-x)");
        XmlHelper.marshalAny(sin, "Sin.xml");
//        String will = "S://Project//LR2//Line.xml";
//        LineaFun line = XmlHelper.unMarshalAny(LineaFun.class, will);
//        System.out.println();
    }
}
