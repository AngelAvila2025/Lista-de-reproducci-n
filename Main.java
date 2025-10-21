public class Main {
    static class Node {
        String name;
        int duration;
        Node next;

        Node(String name, int duration) {
            this.name = name;
            this.duration = duration;
            this.next = null;
        }
    }

    static class Playlist {
        private Node head;

        public void addSong(String name, int duration) {
            Node newNode = new Node(name, duration);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public void removeSong(String name) {
            if (head == null) {
                System.out.println("La lista está vacía.");
                return;
            }
            if (head.name.equalsIgnoreCase(name)) {
                head = head.next;
                System.out.println("Se eliminó la canción: " + name);
                return;
            }
            Node current = head;
            Node previous = null;
            while (current != null && !current.name.equalsIgnoreCase(name)) {
                previous = current;
                current = current.next;
            }
            if (current == null) {
                System.out.println("La canción '" + name + "' no se encontró.");
                return;
            }
            previous.next = current.next;
            System.out.println("Se eliminó la canción: " + name);
        }

        public void printPlaylist() {
            if (head == null) {
                System.out.println("La lista está vacía.");
                return;
            }
            Node current = head;
            int index = 1;
            System.out.println("Lista actual:");
            while (current != null) {
                System.out.println(index + ". " + current.name + " (" + current.duration + " s)");
                current = current.next;
                index++;
            }
            System.out.println("Duración total: " + getTotalDuration() + " s");
        }

        public int getTotalDuration() {
            int total = 0;
            Node current = head;
            while (current != null) {
                total += current.duration;
                current = current.next;
            }
            return total;
        }
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong("Yesterday", 150);
        playlist.addSong("Imagine", 180);
        playlist.addSong("Hey Jude", 210);
        playlist.printPlaylist();
        System.out.println("\nEliminando 'Imagine'...\n");
        playlist.removeSong("Imagine");
        playlist.printPlaylist();
    }
}