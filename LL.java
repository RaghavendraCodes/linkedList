public class LL {
    private Node head; 
    private Node tail; 
    private int size;
    public LL next;
    public int val; 

    
    private class Node {
        private int value; 
        private Node next; 

        public Node(int value) {
            this.value = value; 
        }

        public Node(int value, Node next) {
            this.value = value; 
            this.next = next; 
        } 
    }
    
    public LL() {
        this.size = 0; 
    }

    public void insertFirst(int val) {
        Node node = new Node(val); 
        node.next = head; 
        head = node; 
        /*if(tail == null) {
            tail = head; 
        }*/
        size += 1; 
    }

    public void display() {
        Node temp = head; 
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next; 
        }
        System.out.print("END");
    }

    /*public void insertLast(int val) {
        if(tail == null) {
            insertFirst(val);
            return; 
        }

        Node node = new Node(val); 
        tail.next = node; 
        tail = node; 
        size++; 
    }*/

    public void insertLast(int val) {
        Node node = new Node(val);
        if(head == null) { 
            head = node;  
            return; 
        }
        Node temp = head; 
        while(temp.next != null){
            temp = temp.next; 
        }
        temp.next = node; 
        node = null; 
    }


    public void insert(int val, int index) {
        if(index == 0) {
            insertFirst(val);
        return; 
        }
        if(index == 0) {
            insertLast(val);
        return; 
        }
        Node temp = head; 
        for(int i=1; i<index; i++) {
            temp = temp.next; 
        }
        Node node = new Node(val, temp.next); 
        temp.next = node; 
        size++;
    }

    public int deleteFirst() {
        int val = head.value; 
        head = head.next; 
        if(head == null) {
            tail = null; 
        }
        size--; 
        return val; 
    }

    public Node find(int value) {
        Node node = head; 
        while(node != null) {
            if(node.value == value) {
                return node; 
            }
            node = node.next; 
        }
        return null; 
    }

    public Node get(int index) {
        Node node = head; 
        for(int i=0; i<index; i++){
            node = node.next; 
        }
        return node; 
    }

    public void insertRec(int val, int index) {
        head = insertRec(val, index, head); 
    }

    private Node insertRec(int val, int index, Node node) {
        if(index == 0) {
            Node temp = new Node(val, node);
            size++; 
            return temp;  
       }

       node.next = insertRec(val, index -= 1, node.next);
       return node; 
    }

    public int deleteLast() {
        if(size <= 1) {
            return deleteLast(); 
        }
        Node secondLast = get(size-2); 
        int val = tail.value; 
        tail = secondLast; 
        tail.next = null; 
        return val; 
    }

    public int delete(int index) {
        if(index == 0) {
            return deleteFirst(); 
        }
        if(index == size - 1) {
            return deleteLast(); 
        }
        Node prev = get(index - 1); 
        int val = prev.next.value; 
        prev.next = prev.next.next; 
        return val;  
    }


    // questions. 

    // 1. remove duplicates. 
    public void duplicates() {
        Node node = head; 
        while(node.next != null) {
            if(node.value == node.next.value) {
                node.next = node.next.next; 
                size--; 
            } else {
                node = node.next; 
            }
        }
            tail = node; 
            tail.next = null; 
    }

    // 2. merge two sorted linked list.
    public static LL merge(LL first, LL second) {
        Node f = first.head; 
        Node s = second.head; 
        LL ans = new LL(); 
        while(f != null  && s != null) {
            if(f.value < s.value) {
                ans.insertLast(f.value); 
                f = f.next; 
            } else {
                ans.insertLast(s.value);
                s = s.next; 
            }
        }

        while(f != null) {
            ans.insertLast(f.value);
            f = f.next; 
        }

        while(s != null) {
            ans.insertLast(s.value);
            s  = s.next; 
        }
        return ans; 
    }

    // find length of the cycle. 
    public int lengthCycle(Node head) {
        Node fast = head; 
        Node slow = head; 

        while(fast != null && fast.next != null) {
            fast = fast.next.next; 
            slow = slow.next; 
            if(fast == slow) {
                Node temp = slow.next; 
                int length = 1; 
                while(temp != fast) {
                    temp = temp.next; 
                }
                return length; 
            }
        }
        return 0; 
    }

    public Node detectCycle(Node head) {
        int length = 0; 
        Node fast = head; 
        Node slow = head; 
        while(fast != null && slow != null) {
            fast = fast.next.next; 
            slow = slow.next; 
            if(fast == slow) {
                length = lengthCycle(slow);  
                break;
            }
        }
        if (length == 0) {
            return null;
        }
        // find start node. 
        Node f = head; 
        Node s = head;
        while(length > 0) {
            s = s.next; 
            length--;
        }
        while(f != s) {
            f = f.next; 
            s = s.next;
        }
        return s; 
    }

    // recursion reversal

    private void reverse(Node node) {
        if(node == tail) {
            tail = head;
            return;
        }
        reverse(node.next);
        tail.next = node; 
        tail = node; 
        tail.next = null; 
    }

    public void reversal() {
        if(head == null) {
            return; 
        }
        Node prev = null; 
        Node present = head; 
        Node next = present.next; 

        while(present != null) {
            present.next = prev; 
            prev = present; 
            present = next; 
            if(next != null) {
                next = next.next; 
            }
            head = prev; 
        }
    }

    public static void main(String[] args) {

        // LL list = new LL(); 
        // list.insertLast(1);
        // list.insertLast(1);
        // list.insertLast(1);
        // list.insertLast(2);
        // list.insertLast(2);
        // list.insertLast(4);
        // list.duplicates();
        // list.display();

        LL first = new LL(); 
        LL second = new LL(); 
        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);
        second.insertLast(2);
        second.insertLast(4);
        second.insertLast(6);
        second.insertLast(7);
        LL ans = LL.merge(first, second); 
        ans.display();
    }
}