import java.util.*;

public class Capitallist {
    public static void main(String[] args) {
            String country , capital;
            LinkedHashMap<String, String> capitals = new LinkedHashMap<>();
            Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 country names with their capitals: ");
            for(int i = 0 ; i < 5 ; i++)
            {
                System.out.println("Enter country name :");
                country = sc.nextLine();
                System.out.println("Enter it's capital :");
                capital = sc.nextLine();
                capitals.put(country,capital);
            }
            Map<String, String> result = sortMap(capitals);

            for (Map.Entry<String, String> entry : result.entrySet())
            {
                System.out.print("Key: " + entry.getKey());
                System.out.println(" Value: " + entry.getValue());
            }
        }

        public static LinkedHashMap<String, String> sortMap(LinkedHashMap<String, String> map) {
            List<Map.Entry<String, String>> capitalList = new LinkedList<>(map.entrySet());

            Collections.sort(capitalList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

            LinkedHashMap<String, String> result = new LinkedHashMap<>();
            for (Map.Entry<String, String> entry : capitalList)
            {
                result.put(entry.getKey(), entry.getValue());
            }

            return result;
        }

}
