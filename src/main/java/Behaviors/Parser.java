package Behaviors;

import static java.lang.StrictMath.sin;

public  class Parser {
    //+k*x+b
    //+k*x-b
    //-k*x-b
    //-k*x+b
    public static double parserLine(double x, String function) {

        double res = 0;

        function.replaceAll(" ", "");
        function.toLowerCase();

        if (function.charAt(0) == '+' && function.charAt(4) == '+') {
            String delete = function.substring(0, 1);
            String newfun = function.substring(1, 6);
            String[] parst = newfun.split("\\+");
            String strkx = parst[0];
            String strB = parst[1];
            Double b = Double.parseDouble(strB);
            String[] kxParts = strkx.split("\\*");
            String strk = kxParts[0];
            Double k = Double.parseDouble(strk);
            res = +k * x + b;
        } else if (function.charAt(0) == '-' && function.charAt(4) == '-') {
            String delete = function.substring(0, 1);
            String newfun = function.substring(1, 6);
            String[] parst = newfun.split("\\-");
            String strkx = parst[0];
            String strB = parst[1];
            Double b = Double.parseDouble(strB);
            String[] kxParts = strkx.split("\\*");
            String strk = kxParts[0];
            Double k = Double.parseDouble(strk);
            res = -k * x - b;
        } else if (function.charAt(0) == '+' && function.charAt(4) == '-') {
            String[] parst = function.split("\\-");
            String strkx = parst[0];
            String strB = parst[1];
            Double b = Double.parseDouble(strB);
            String[] kxParts = strkx.split("\\*");
            String strk = kxParts[0];
            Double k = Double.parseDouble(strk);
            res = +k * x - b;
        } else if (function.charAt(0) == '-' && function.charAt(4) == '+') {
            String[] parst = function.split("\\+");
            String strkx = parst[0];
            String strB = parst[1];
            Double b = Double.parseDouble(strB);
            String[] kxParts = strkx.split("\\*");
            String strk = kxParts[0];
            Double k = Double.parseDouble(strk);
            res = k * x + b;
        }
        return res;
    }
    //+x*x+b
    //-x*x-b
    //+x*x-b
    //-x*x+b
    public static double parserQua(double x, String function) {
        //+x*x+b
        //-x*x-b
        //+x*x-b
        //-x*x+b
        double res = 0;

        function.replaceAll(" ", "");
        function.toLowerCase();

        if (function.charAt(0) == '+' && function.charAt(4) == '+') {
            String delete = function.substring(0, 1);
            String newfun = function.substring(1, 6);
            String[] parst = newfun.split("\\+");
            String strB = parst[1];
            Double b = Double.parseDouble(strB);
            res = +x * x + b;
        } else if (function.charAt(0) == '-' && function.charAt(4) == '-') {
            String delete = function.substring(0, 1);
            String newfun = function.substring(1, 6);
            String[] parst = newfun.split("\\-");
            String strB = parst[1];
            Double b = Double.parseDouble(strB);
            res = -x * x - b;
        } else if (function.charAt(0) == '+' && function.charAt(4) == '-') {
            String[] parst = function.split("\\-");
            String strB = parst[1];
            Double b = Double.parseDouble(strB);
            res = +x * x - b;
        } else if (function.charAt(0) == '-' && function.charAt(4) == '+') {
            String[] parst = function.split("\\+");
            String strB = parst[1];
            Double b = Double.parseDouble(strB);
            res = -x * x + b;
        }
        return res;
    }
    //+b*sin(+x)
    //-b*sin(-x)
    //-b*sin(+x)
    //+b*sin(-x)
    public static double parserSin(double x, String function) {
        //+b*sin(+x)
        //-b*sin(-x)
        //-b*sin(+x)
        //+b*sin(-x)
        double res = 0;

        function.replaceAll(" ", "");
        function.toLowerCase();

        if ((function.charAt(0) == '+' && function.charAt(7) == '+') | (function.charAt(0) == '-' && function.charAt(7) == '-')) {
            String[] parst = function.split("\\*");
            String strB = parst[0];
            if(strB.contains("-")){
                Double b = Double.parseDouble(strB);
                res = -b * sin(x);
            }else{
                Double b = Double.parseDouble(strB);
                res = +b * sin(x);
            }
        } else if ((function.charAt(0) == '+' && function.charAt(7) == '-') | (function.charAt(0) == '-' && function.charAt(7) == '+')) {
            String[] parst = function.split("\\*");
            String strB = parst[0];
            Double b = Double.parseDouble(strB);
            res = b * sin(-x);
        }
        return res;
    }

    //(e^x-e^-x)/b
    public static double giper(double x, String function){
        double res=0;
        function.replaceAll(" ", "");
        function.toLowerCase();
        String[] parst = function.split("\\/");
        String strB = parst[1];
        Double b = Double.parseDouble(strB);
        res = (2.71*x+2.71*-x)/b;
        return res;
    }
}
