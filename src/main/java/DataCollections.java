import javax.sql.rowset.Predicate;
import javax.xml.crypto.Data;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.*;

/**
 * @author gwitczak
 */
public class DataCollections {

    private static final String[] surnames = {"Wójcicki", "Czernek", "Bogusz", "Dyga", "Uliński", "Kuś", "Basiak", "Michałkiewicz", "Piecha", "Ziemiański", "Szwarc", "Kudliński", "Wojtala", "Nikiel", "Kozera", "Szala", "Kalina", "Wojnarowski", "Krzempek", "Chowaniec", "Lesiński", "Szumski", "Kępczyński", "Sałaciński", "Kuc", "Chełmiński", "Migdał", "Szreder", "Paszkowski", "Chuda", "Krysiak", "Makuła", "Jarząb", "Nawrot", "Kościuk", "Hołub", "Bućko", "Kawa", "Bukała", "Gurgul", "Nowek", "Ołdakowski", "Trzeciak", "Gałkowski", "Łazowski", "Kabat", "Pawelski", "Gruszecki", "Cymerman", "Wojtczak", "Mucha", "Taras", "Tryba", "Woźnica", "Dyrcz", "Naruszewicz", "Wrzesiński", "Prusaczyk", "Kasperek", "Koziarski", "Gnat", "Bielawski", "Błaszczak", "Smółka", "Szkudlarek", "Rostkowski", "Cwynar", "Górowski", "Kulka", "Burdzy", "Ciach", "Binkowski", "Rękawek", "Majek", "Sułkowski", "Rolnik", "Piekarz", "Andrzejewski", "Durak", "Rejman", "Pacak", "Wojcieszek", "Koliński", "Dulski", "Janiczek", "Andrzejczyk", "Andrzejczuk", "Kacprzyk", "Majkut", "Adamus", "Wąs", "Radecki", "Czerski", "Byrski", "Maciążek", "Nalepka", "Bojar", "Dziadek", "Mikucki", "Wodnicki", "Franek", "Żabicki", "Kokociński", "Deska", "Głąb", "Michałowicz", "Wojtecki", "Ludwig", "Ołdak", "Gołębiewski", "Pawlas", "Kurzeja", "Suchomski", "Podbielski", "Stręk", "Lisiecki", "Świtoń", "Siekierski", "Dolny", "Wycisk", "Korytkowski", "Solarski", "Wrześniewski", "Pajewski", "Szyszka", "Kociołek", "Iskra", "Zientek", "Jadach", "Marcol", "Kurzyński", "Podolak", "Kuczkowski", "Jamka", "Kot", "Konkel", "Dobrosielski", "Stachyra", "Kotwicki", "Magdziarz", "Czok", "Mroczka", "Formela", "Karpiuk", "Kamiński", "Pisarczyk", "Kulpa", "Koczur", "Raczek", "Borkowski", "Kardas", "Sokalski", "Szpakowski", "Chodkiewicz", "Frankowski", "Głażewski", "Szura", "Konarzewski", "Sierpiński", "Bijak", "Pisarski", "Gawor", "Zdun", "Sielicki", "Pudełko", "Ilczuk", "Kozerski", "Klimiuk", "Sobol", "Kocemba", "Barszcz", "Koszyk", "Musioł", "Tarasiuk", "Pietrzykowski", "Gazda", "Tymiński", "Łopatka", "Konior", "Batko", "Walkowicz", "Szaniawski", "Wandzel", "Krzewiński", "Aftyka", "Skrok", "Działak", "Pluciński", "Gruda", "Nicpoń", "Kiełpiński", "Federowicz", "Pędzich", "Makówka", "Klawikowski", "Respondek", "Piechowski", "Dłużniewski", "Brudnicki", "Majka", "Całka", "Luty", "Grzesiuk", "Misiura", "Miłosz", "Juszczyk", "Mrugała", "Tylkowski", "Zielonka", "Oleś", "Rakowski", "Nawrocki", "Sieroń", "Pietrucha", "Dobosz", "Stachurski", "Walaszczyk", "Spyrka", "Gach", "Jeżewski", "Bączek", "Drożdż", "Tworek", "Wantuch", "Marczewski", "Kurek", "Guzy", "Gorzkiewicz", "Łupiński", "Igielski", "Janiak", "Stojek", "Koźmiński", "Mieszczak", "Truszczyński", "Chabowski", "Zysk", "Konopa", "Dawidowicz", "Bogdan", "Malina", "Firlej", "Gołąbek", "Żaczek", "Maruszewski", "Czerw", "Matras", "Jurkiewicz", "Pater", "Próchniak", "Spychała", "Ścisłowski", "Suwała", "Paterek", "Kluczyński", "Jung", "Cebula", "Smolik", "Rzeszutek", "Stawiarz", "Pasierb", "Przywara", "Rygielski", "Dąbrowski", "Głodek", "Żółtowski", "Banasik", "Chrobot", "Domachowski", "Seremak", "Rykała", "Karasiewicz", "Sawczuk", "Rogiński", "Ferens", "Łukaszuk", "Majewski", "Kryński", "Kurzawski", "Małkiewicz", "Kułakowski", "Górna", "Czechowski", "Kądziołka", "Kobus", "Maćkowiak", "Ratajski", "Rygiel", "Podleśny", "Waszkiewicz", "Wilkowski", "Czubiński", "Deptuła", "Gawrysiak", "Sobkowicz", "Żak", "Połomski", "Bobowski", "Dawidziuk", "Ciupiński"};

    private static final String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed fermentum justo in nunc facilisis, nec pellentesque sapien viverra. Praesent tristique sollicitudin sapien a imperdiet. Pellentesque tincidunt nec mi a fringilla. Duis rhoncus odio vitae dui fringilla viverra. Ut tristique in diam fermentum placerat. Vivamus viverra vel magna vitae sodales. Maecenas interdum iaculis sodales. Integer consequat molestie justo a finibus. Aenean facilisis lectus odio. Donec non sapien ac dolor pellentesque porttitor. Nunc sit amet pretium ex, et aliquam velit. Duis venenatis leo sit amet magna venenatis, ac iaculis mi dictum. Nunc a tellus sit amet est consectetur consequat et sed lectus. Sed et imperdiet metus, congue malesuada enim. Pellentesque vitae elit in nulla porttitor maximus a nec nisi. " +
            "Fusce id euismod nisl. Praesent vel eros nec justo mattis ultricies. Sed vestibulum a nunc vehicula finibus. Suspendisse pharetra cursus massa, ac varius sapien ultricies quis. Nunc velit mi, vehicula ac porttitor sed, viverra ut tellus. Duis at lorem vel eros tincidunt finibus. Mauris ultricies tempor arcu a laoreet. Nam rutrum, odio sagittis maximus posuere, mi ante mattis magna, eu laoreet ligula mauris eget odio. Mauris egestas magna ac eros condimentum dignissim. Maecenas ac interdum ex, sit amet mollis odio. " +
            "In vel nibh semper, rutrum dolor id, auctor purus. Maecenas imperdiet tristique libero eget vulputate. Fusce eu mi vitae orci sagittis condimentum. Nam ut magna dui. Curabitur in consequat urna. Mauris id mattis massa, a viverra risus. Vestibulum hendrerit malesuada mi. Suspendisse ullamcorper ipsum et ex varius, vitae aliquam nibh vulputate. Duis scelerisque finibus ante luctus scelerisque. Suspendisse in massa at ante pretium ultricies at placerat leo. " +
            "Donec lobortis, elit id tempor consequat, tortor eros mollis lorem, vel feugiat dui metus nec tortor. Donec at rutrum risus, id condimentum tortor. Phasellus et pulvinar urna. Pellentesque vitae augue massa. Nunc vestibulum sapien in nunc suscipit vulputate. Ut id porta neque, vel gravida eros. Donec at auctor orci, ac posuere sem. In hac habitasse platea dictumst. Etiam finibus lacus in fringilla lobortis. Nulla sodales efficitur nisi id vulputate. Morbi neque mi, tincidunt quis quam ac, varius posuere massa. Ut massa leo, fringilla fermentum viverra nec, semper at lorem. Proin id mattis ex, a varius eros. " +
            "Praesent eu consectetur arcu. Sed tincidunt dapibus urna, a tincidunt turpis scelerisque eu. Integer in aliquet sem, fringilla maximus orci. Ut erat velit, auctor vel magna accumsan, convallis efficitur velit. Morbi et aliquet felis. Duis semper sapien ut eros dictum, et lobortis tortor vehicula. Integer ut elementum mauris. Sed pharetra lorem vel dolor elementum, sed suscipit libero pretium. Vivamus viverra turpis a nisi tincidunt elementum. Quisque aliquet pretium diam, in fringilla eros gravida tincidunt. Ut at ullamcorper eros. Cras consectetur est a vehicula dictum. Etiam commodo est vel libero suscipit, ac porttitor quam fermentum. Donec nibh nulla, consectetur et hendrerit ac, varius sed neque. In magna sem, bibendum non dui eu, mollis condimentum tortor. Nunc erat nulla, sagittis tempus fermentum at, faucibus in arcu. " +
            "Donec vitae fermentum dolor. Morbi vitae nisl at nisl ultrices faucibus. Quisque vitae pellentesque ante. Pellentesque metus dui, venenatis sed ultrices quis, cursus vel risus. Nullam finibus interdum augue, non tincidunt massa efficitur sit amet. Aenean ac tortor congue, tincidunt nisl sit amet, accumsan turpis. Nam scelerisque et purus sit amet posuere. Donec suscipit ac duos magna a hendrerit. In hac habitasse platea dictumst. Nulla ex dolor, lacinia sed accumsan quis, congue ac tellus. Cras tempus eros eget leo euismod, vel venenatis nibh elementum. Pellentesque semper vel magna nec luctus. Integer pretium odio sit amet molestie fringilla. Nulla vulputate faucibus laoreet. Aenean ac laoreet nisi. " +
            "Quisque sed nisl finibus, hendrerit felis sit amet, varius dolor. In facilisis imperdiet metus ut vestibulum. Phasellus fermentum nisl a ex porttitor ultricies. Proin eget libero et quam suscipit fermentum. Morbi rutrum risus ut viverra venenatis. Donec commodo sapien sit amet risus maximus consectetur. Cras dictum dictum gravida. Aliquam erat volutpat. Mauris ultrices mi massa, et ornare nisl aliquam eu. Morbi egestas quis dui et condimentum. Vestibulum nulla libero, suscipit ut tellus a, vehicula hendrerit ipsum. Quisque convallis egestas purus, id mattis orci tincidunt vel. Ut volutpat tortor sed ornare eleifend. Proin ipsum sapien, rutrum nec massa in, mollis finibus orci. Duis et mi mauris. " +
            "Aliquam rutrum erat a mauris scelerisque maximus. Aenean ullamcorper sed sem ac sodales. Nulla facilisi. Donec interdum consectetur quam, quis facilisis elit venenatis eget. Fusce accumsan consequat vehicula. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nullam at velit et lorem porta ultrices id vitae risus. Aliquam felis leo, vehicula id malesuada a, efficitur eget felis. Nunc posuere ultricies sapien, vel ornare turpis accumsan ut. Vestibulum in tempor turpis, a semper massa. Vestibulum egestas mauris metus, ultricies lobortis erat ornare quis. " +
            "Phasellus at porttitor nulla. Curabitur placerat pulvinar dignissim. In sodales mauris at fringilla molestie. Phasellus at arcu a ligula interdum bibendum et vitae felis. Aenean id fringilla velit, eget mollis massa. Aliquam convallis ligula vitae enim consequat, porta maximus enim gravida. In sodales feugiat lectus, a feugiat orci lobortis eget. Cras ut pretium mi. Aenean elementum maximus diam, in hendrerit quam sagittis lobortis. Fusce vel elit ac eros tempor mollis at ut ex. " +
            "Quisque euismod lacus et augue luctus tristique. Vestibulum suscipit augue erat, id imperdiet eros fermentum quis. Quisque nulla felis, dictum eu ornare et, ornare quis magna. Phasellus a nibh dignissim ex rutrum suscipit quis vel tortor. Vivamus non risus faucibus elit luctus aliquet. Vestibulum imperdiet enim id tortor facilisis ullamcorper. In a egestas sapien. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed commodo elit felis, non tincidunt mauris sagittis et. Vivamus bibendum tincidunt lacinia. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Curabitur et auctor felis.";

    private DataCollections() {
    }

    public static List<String> getSurnames() {
        return Arrays.asList(surnames);
    }

    public static List<Integer> getNumbers(int size) {
        final Random random = new Random(548621895);
        final ArrayList<Integer> integers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            integers.add(random.nextInt(100_000));
        }
        return integers;
    }

    public static List<String> getLoremIpsum() {
        return Arrays.asList(loremIpsum.split(" "));
    }


    public static void main(String[] args) {
        //1) Wszystkie nazwiska o długości co najwyżej 4 znaków, zapisane wielkimi literami

        List<String> list = new ArrayList<>();
        Function<String, String> mapper = s -> null;
        for (String nazwisko : DataCollections.getSurnames()) {
            if (nazwisko.length() <= 4) {
                String s2 = mapper.apply(nazwisko);
                list.add(s2);
            }
        }
        //System.out.println(list);

        //2) Wszystkie nazwiska zaczynające się na literę 'B'
        List<String> list2 = DataCollections.getSurnames().stream()
                .filter(nazwisko -> nazwisko.startsWith("B"))
                .collect(toList());
        //System.out.println(list2);

        //3) Początkowe trzy litery wszystkich nazwisk, bez powtórzeń, z małych liter
        List<String> list3 = DataCollections.getSurnames().stream()
                .map(s -> s.toLowerCase().substring(0, 3))
                .collect(Collectors.toList());
        //System.out.println(list3);

        //4) 10 najdłuższych nazwisk, posortowanych malejąco według długości
        List<String> list4 = DataCollections.getSurnames().stream()
                .sorted((o1, o2) -> o2.length() - o1.length())
                .limit(10)
                .collect(Collectors.toList());
        //System.out.println(list4);

//      5) 20 najkrótszych nazwisk, posortowanych według ostatniej litery
        List<String> list5 = DataCollections.getSurnames().stream()
                .sorted(Comparator.comparingInt(String::length))
                .limit(20)
                .map(nazwisko -> new StringBuilder(nazwisko).reverse().toString())
                .sorted(String::compareTo)
                .map(nazwisko -> new StringBuilder(nazwisko).reverse().toString())
                .collect(Collectors.toList());

        System.out.println(list5); // nie wierzę ale chyba działą !!!!!


        //6) Odwróć kolejność liter we wszystkich nazwiskach i pozstaw jedynie te,
        // które mają literę 'A' wsród pierwszych trzech liter (odwróconego nazwiska)
        List<String> list6 = DataCollections.getSurnames().stream()
                .map(nazwisko -> new StringBuilder(nazwisko).reverse().toString())   //robimy StringBuildera zeby dostac sie do metody reverse
                .filter(nazwisko -> {
                    String trzyLiterki = nazwisko.substring(0, 3).toLowerCase();
                    return trzyLiterki.contains("a") || trzyLiterki.contains("b");
                })
                .collect(Collectors.toList());
        // System.out.println(list6);

//        7) Policz, ile jest nazwisk zaczynających się na każdą z liter alfabetu (rezultat jako Map<Character, Integer>)
        Map<Character, Integer> result = new TreeMap<>();
//        List<String> list7 = DataCollections.getSurnames().stream()
//                .filter(nazwisko -> {
//                    char[] litera = nazwisko.substring(0,0).toCharArray();
//                    return litera;
//                        });

        System.out.println();




        //Liczby:
        //1) Ile jest liczb parzystych?

        long ileParzystych = DataCollections.getNumbers(100_000).stream()
                .filter(liczba -> liczba % 2 == 0)
                .count();
//        System.out.println(ileParzystych);

        //2) Ile jest liczb pięciocyfrowych?
        long ilePieciocyfrowychg = DataCollections.getNumbers(100_000).stream()
                .filter(liczba -> liczba >= 10_000 && liczba < 100_000)
                .count();
//        System.out.println(ilePieciocyfrowychg);

        //3) Jaka jest największa i najmniejsza liczba?
        Optional najwieksza = DataCollections.getNumbers(100_000).stream()
                .max(Integer::compareTo);
//        System.out.println(najwieksza.get());
        //4) Jaka jest różnica między największa a najmniejszą liczbą?
        Integer najmniejsza = DataCollections.getNumbers(100_000).stream()
                .min(Integer::compareTo).get();
        Integer najwieksza2 = DataCollections.getNumbers(100_000).stream()
                .max(Integer::compareTo)
                .get();
//        System.out.print("Różnica max min: ");
//        System.out.println(najwieksza2 - najmniejsza);


        //5) Jaka jest średnia wszystkich liczb?
        Double averenge = DataCollections.getNumbers(100_000).stream()
                .mapToDouble(Integer::doubleValue).average().getAsDouble();
//        System.out.println("Srednia " + averenge);
        //6*) Jaka jest mediana wszystkich liczb?
//        DoubleStream mediana = DataCollections.getNumbers(100_000).stream()
//                .sorted(Integer::compareTo)
//                .filter(n -> n.)
//                ;
//        System.out.println((mediana.iterator()));


        //7*) Jaka cyfra pojawia się najczęściej we wszystkcih liczbach?

//        Map<Character, Integer> najczesciejWystepuje = DataCollections.getNumbers(100_000).stream()
//                .iterator()
//                .toString()
//                .toCharArray()
//                .
        //8*) Ile jest wystąpień każdej cyfry (rezultat jako Map<Integer, Integer> z kluczami od 0 do 9)
        //9) Wypisz wszystkie liczby pierwsze, posortowane rosnąco
    }
}



