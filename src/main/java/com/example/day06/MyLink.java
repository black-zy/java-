package com.example.day06;

public class MyLink {
    Node head = null;

    class Node{
        Node next = null;
        int data;
        public Node(int data){
            this.data= data;
        }
    }

    public void addNode(int d){
        Node newNode= new Node(d);
        if(head == null){
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public boolean deleteNode(int index){
        if(index<1 || index > length()){
            return false;
        }
        if (index == 1){
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null){
            if(i == index){
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    private int length() {
        int lenght = 0;
        Node tmp = head;
        while (tmp != null){
            lenght++;
            tmp = tmp.next;
        }
        return lenght;
    }

    public boolean deleteNode11(Node n ){
        if(n == null || n.next == null){
            return false;
        }
        int tmp = n.data;
        n.data = n.next.data;
        n.next.data = tmp;
        n.next = n.next.next;
        System.out.println("删除成功");
        return true;
    }

    public void printList(){
        Node tmp = head;
        while (tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
    public static void main(String[] args) {
        MyLink list = new MyLink();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.head.data);
        list.printList();
        list.deleteNode(4);
        System.out.println("After deleteNode(4):");
        list.printList();
    }
}
