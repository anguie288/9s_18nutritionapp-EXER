import java.io.*;
import java.util.*;


/*
download and import json jar
download and import json simple jar
 */

// https://jar-download.com/artifacts/org.glassfish/javax.json/1.0.4/source-code
// https://stackoverflow.com/questions/47022653/provider-org-glassfish-json-jsonproviderimpl-not-found-at-javax-json-spi-jsonpro

//import org.json.*;
/*import org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;  */






public class Main {

    public static void main(String[] args) throws Exception {


        recipe one = new recipe();
        System.out.println(one.s);
        one.scanning();
        one.parts();
        one.write();
        one.retrive();

        int count = one.countwords(one.farecipe);
        System.out.println();
        System.out.println("Number of ingredients: "+count);
        System.out.println();


        //one.readjson();



    }
}



class recipe  {


    public String s =
            "\nPublic variable Hello, World! ";


    public static ArrayList<String> lst;
    public static ArrayList <String> mid;
    public static String fapart1, fapart2, fapart3, fapart4, fapart5, farecipe;
    public static String sre;



    public recipe() throws Exception {


        /*     Read recipes and print     */

        File rec = new File("recipes.txt");
        BufferedReader br = new BufferedReader(new FileReader(rec));
        String str;

        while ((str = br.readLine()) != null ) {

            String s = str;
            System.out.println(s);
        }
    }




    public static void scanning() throws Exception{


        /*     Read recipes and create sublist     */

        Scanner s = new Scanner(new File("recipes.txt"));

        lst = new ArrayList<String>();


        while (s.hasNextLine()) {
            lst.add(s.next());

        }


        mid = new ArrayList<String>(lst.subList(33, 51));
        //ArrayList<String> head = new ArrayList<String>(lst.subList(0, 33));
        //ArrayList<String> last = new ArrayList<String>(lst.subList(51, 81));

        s.close();


        System.out.println();
        System.out.println("Printed favorite part");
        System.out.println(Arrays.toString(mid.toArray())+"\nFor each print favorite part");
        mid.forEach((String value) -> System.out.print(value+" "));

        System.out.println();


    }

    public static void parts(){

        /*     Print sublist     */

        fapart1 = mid.get(0)+" "+mid.get(1);
        fapart2 = mid.get(2);
        fapart3 = mid.get(3)+" "+mid.get(4)+" "+mid.get(5)+" "+mid.get(6);
        fapart4 = mid.get(7)+" "+mid.get(8)+" "+mid.get(9)+" "+mid.get(10)+" "+mid.get(11)+" "+mid.get(12);
        fapart5 = mid.get(13)+" "+mid.get(14)+" "+mid.get(15)+" "+mid.get(16)+" "+mid.get(17);
        farecipe = " "+fapart1+"\n"+" "+fapart2+"\n"+" "+fapart3+"\n"+" "+fapart4+"\n"+" "+fapart5;
        System.out.println();
        System.out.println("Favorite Recipe Organized\n"+farecipe);



    }

    public static void write(){

        try {
            String text = farecipe;
            BufferedWriter out = new BufferedWriter(new FileWriter("write.txt"));
            out.write(text);
            out.close();
        }
        catch (IOException e)
        {
            System.out.println("Exception ");
        }

        return ;

    }



    public static void retrive () throws Exception {


        /*     Retrieve sublist     */


        // Reading data from file

        File f1=new File("write.txt");   // formats "Root/retr.txt" "src/retr.txt"
        FileReader fr=new FileReader(f1);
        BufferedReader br=new BufferedReader(fr);

        sre = br.readLine();

        // Writing data

        File f2=new File("retr.txt");
        FileWriter fw=new FileWriter(f2);
        BufferedWriter bw=new BufferedWriter(fw);

        while(sre != null)
        {
            bw.write(sre);
            bw.newLine();
            //System.out.println(sre);
            sre=br.readLine();

        }

        bw.flush();
        bw.close();


    }

    public static int countwords(String input) {

        String red = input.substring(35);

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] words = red.split("\\n");
        return words.length;

    }

    
    /*
    //@SuppressWarnings("unchecked")

    public static void readjson() throws Exception {

        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("src/rec.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        // getting firstName and lastName
        String firstName = (String) jo.get("firstName");

        System.out.println("The first name is: "+ firstName);


        // getting address
        Map address = ((Map)jo.get("ingredients"));

        // iterating address Map
        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }


    }
    */

    //@Override
    public String toString()
    {
        return "recipe read";
    }



}
