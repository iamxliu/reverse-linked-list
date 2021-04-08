package com.github.hcsp.datastructure;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;

        print(node1);
        print(reverse(node1));
    }

    // 原地翻转一个单链表
    // 传递的参数是原始链表的头节点
    // 返回翻转后的链表的头节点
    public static Node reverse(Node head) {
        // 单一链表为空或者只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }
        // 当前节点
        Node currentNode = head;
        // prior保存前一个节点
        Node prior = null;
        // next保存后一个节点
        Node next;
        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = prior;
            prior = currentNode;
            currentNode = next;
        }
        return prior;
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
    }
}
