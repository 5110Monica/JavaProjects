package PracticeOOP.TollManagement;

import java.util.ArrayList;
public class Highway {
    Node head;
    Node tail;
    public void insert(char val){
        Node node = new Node(val);
        if(head==null){
            head=node;
            tail=node;
        }
        tail.next=node;
        node.prev=tail;
        node.next=head;
        head.prev=node;
        tail=node;
    }
   public  ArrayList<Character> findShortestPath(char start, char end) {
       if (start == end) {
           throw new IllegalArgumentException("Invalid start and end");
       }

       Node s = findNode(start);
       Node e = findNode(end);

       ArrayList<Character> rightPath = findPath(s, e, true);
       ArrayList<Character> leftPath = findPath(s, e, false);

       return (leftPath.size() < rightPath.size()) ? leftPath : rightPath;
   }

    private Node findNode(char val) {
        Node temp = head;
        do {
            if (temp.val == val) {
                return temp;
            }
            temp = temp.next;
        } while (temp != null);

        throw new IllegalArgumentException("Node with value " + val + " not found");
    }

    private ArrayList<Character> findPath(Node start, Node end, boolean isRight) {
        ArrayList<Character> path = new ArrayList<>();
        path.add(start.val);
        Node current = start;

        do {
            if ((isRight && current.next == end) || (!isRight && current.prev == end)) {
                path.add(isRight ? current.next.val : current.prev.val);
                break;
            }
            current = isRight ? current.next : current.prev;
            path.add(current.val);
        } while (current != start);

        return path;
    }
    public void display() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.val + " <-> ");
                node = node.next;
            } while (node != head);
        }
        System.out.println("HEAD");
    }
    private class Node{
        char val;
        Node prev;
        Node next;
        public Node(char val) {
            this.val = val;
        }
        public Node(char val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    public static ArrayList<Character>   route(char start, char end){
        Highway highway = new Highway();
        highway.insert('A');
        highway.insert('B');
        highway.insert('C');
        highway.insert('D');
        highway.insert('E');
        highway.insert('F');
       return highway.findShortestPath(start,end);
    }

    public static ArrayList<Character> tollsCrossed(ArrayList<Character> path) {
        ArrayList<Character> tollsCrossed = new ArrayList<>();

            if(path.contains('A') && path.contains('F')){
                tollsCrossed.add('c');
            }if(path.contains('C') && path.contains('D')){
                tollsCrossed.add('b');
            }if(path.contains('B') && path.contains('C')) {
            tollsCrossed.add('a');
        }

        return  tollsCrossed;
    }
}
