import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PanTadeusz {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src\\main\\resources\\pan-tadeusz.txt"));

        Map<String, Integer> words = new TreeMap<String, Integer>();

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            line = line.toLowerCase();
//            line = line.replaceAll(",", "");
//            line = line.replaceAll("\\.", "");
//            line = line.replaceAll(";", "");
//            line = line.replaceAll("[(]", "");
//            line = line.replaceAll("[)]", "");
//            line = line.replaceAll("[\"]", "");
//            line = line.replaceAll("!", "");
//            line = line.replaceAll("\\?", "");
//            line = line.replaceAll("-", "");
//            line = line.replaceAll("\\*", "");
//            line = line.replaceAll(":", "");
//            line = line.replaceAll("»", "");
//            line = line.replaceAll("«", "");
            line = line.replaceAll("[^a-zęóąśłżźć ]",""); //wyrazenie regularne do sprawdzenia w necie


            String splitLine[] = line.split(" ");
            for (int i = 0; i < splitLine.length; i++){
                if (words.containsKey(splitLine[i])){
                    words.put(splitLine[i], words.get(splitLine[i])+1);
                }
                else if (!splitLine[i].isEmpty()){
                    words.put(splitLine[i], 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList(words.entrySet()); //z mapy wybieramy set wpisow, zeby go posortowac po wartosci wg swojego comparatora
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                return o2.getValue()-o1.getValue();
            }
        });
        System.out.println(entries);



        //System.out.println(words);
    }
}
