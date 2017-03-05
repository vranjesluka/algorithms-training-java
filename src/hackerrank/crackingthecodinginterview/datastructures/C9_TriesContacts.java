package hackerrank.crackingthecodinginterview.datastructures;

import java.util.*;

/**
 * Created by vranjesluka on 05/03/2017.
 */
public class C9_TriesContacts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie contactBook = new Trie();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
                contactBook.addContact(contact);
            } else {
                System.out.println(contactBook.find(contact));
            }
        }
    }

    private static class Trie {

        private Node head = new Node();

        private void addContact(String contact) {
            Node currentNode = head;
            int i = 0;
            char currentChar = contact.charAt(i);
            while (currentNode.children.containsKey(currentChar)) {
                currentNode = currentNode.children.get(currentChar);
                i++;
                currentChar = contact.charAt(i);
            }
            for (; i < contact.length(); i++) {
                currentChar = contact.charAt(i);
                Node newNode = new Node();
                currentNode.children.put(currentChar, newNode);
                currentNode = newNode;
            }
            currentNode.isAContact = true;
        }

        private int find(String search) {
            Node currentNode = head;
            int i = 0;
            char currentChar = search.charAt(i);
            while (currentNode.children.containsKey(currentChar)) {
                i++;
                if (i >= search.length()) {
                    break;
                }
                currentNode = currentNode.children.get(currentChar);
                currentChar = search.charAt(i);
            }
            if (!currentNode.children.containsKey(currentChar)) {
                return 0;
            }
            int numberOfContacts = 0;
            List<Node> children = new ArrayList<>();
            children.add(currentNode);
            while (!children.isEmpty()) {
                currentNode = children.remove(children.size() - 1);
                if (currentNode.isAContact) {
                    numberOfContacts++;
                }
                children.addAll(currentNode.children.values());
            }
            return numberOfContacts;
        }

        private class Node {
            Map<Character, Node> children = new HashMap<>();
            boolean isAContact;
        }
    }
}
