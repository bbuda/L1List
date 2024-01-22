public class L1List<T>{
    public Node<T> getFirst() {
        return first;
    }

    private Node<T> first;

    public Node<T> getLast() {
        return last;
    }

    private Node<T> last;
    private int size;
    public L1List(){
        first = last = null;
        size = 0;
    }
    //Добавить элемент в конец списка.
    public void append(Node<T> node){
        node.next = null;
        if(first == null)
            first = node;
        if(last != null)
            last.next = node;
        last = node;
        size++;
    }
    //Возвращение позиции узла списка
    public int find(Node<T> node) throws Exception{
        Node<T> iterable_node = first;
        for (int i = 0; i < size; i++) {
            if (iterable_node == node){
                return i;
            }
            iterable_node = iterable_node.next;
        }
        throw new IllegalArgumentException("Узел не найден в списке");
    }
    //Вставка элемента в произвольную позицию списка
    public void insert(Node<T> node, int location){
        if (first == null && location == 0){
            node.next = null;
            first = node;
            last = node;
            size++;
            return;

        }
        else if (first != null && location == 0){
            node.next = first;
            first = node;
            size++;
            return;

        }
        Node<T> pred = first;
        Node<T> current = pred.next;
        int lenght = size;
        for (int i = 1; i <= lenght; i++) {
            if (location ==  i){
                pred.next = node;
                if (pred.next.next == null){
                    node.next = null;
                }
                else{
                    node.next = current;
                }
                size += 1;
                return;

            }
            pred = current;
            current = current.next;
        }


    }
    //Удалить все элементы списка
    public void remove (int location){
        Node<T> node = first;
        Node<T> pred = null;
        int lenght = size;
        for (int i = 0; i < lenght; i++) {
            if (location == 0){
                first = node.next;
                node = null;
                size = size -  1;
                break;
            }
            else {
                if (location == i){
                    pred.next = node.next;
                    size -= 1;
                    break;

                }
            }
            pred = node;
            node = node.next;
        }
    }
    public int lenght(){
        return size;
    }

    //Вывести весь список
    public void print(){
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            System.out.println(node.value);
            node = node.next;
        }
    }
    public Node<T> last(){
        return last;
    }


}
