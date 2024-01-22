import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        L1List<String> list = new L1List<>();
        while (true) {
            String string = sc.nextLine();
            if (string.startsWith("Run ")) {
                list.insert(new Node<String>(string.substring(4)), 0);
                System.out.println(list.getFirst().value);

            } else if (string.startsWith("Alt+Tab")) {
                String[] s = string.split("\\+");
                int counter = s.length - 1;
                Node<String> pred = list.getFirst();
                while (counter != 0) {
                    if (pred.next == null ){
                        pred = list.getFirst();
                        if (counter == 1){
                            break;
                        }
                        counter -= 1;
                        continue;

                    }
                    pred = pred.next;
                    counter -= 1;
                }
                String value = pred.value;
                list.remove(list.find(pred));
                pred = list.getFirst();
                list.insert(new Node<>(value), 0);
                System.out.println(value);
            } else if (string.startsWith("Alt+Delete")) {
                String[] s = string.split("\\+");
                int counter = s.length - 1;
                while (counter != 0) {
                    list.remove(list.find(list.getFirst()));
                    counter -= 1;
                }
            }

        }
    }
}
