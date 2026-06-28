public class LibraryManagementTest {

    public static void main(String[] args) {
        Book[] books = {
            new Book(401, "Atomic Habits", "James Clear"),
            new Book(402, "Deep Work", "Cal Newport"),
            new Book(403, "Ikigai", "Hector Garcia"),
            new Book(404, "Rich Dad Poor Dad", "Robert Kiyosaki"),
            new Book(405, "The Lean Startup", "Eric Ries")
        };

        System.out.println("========= LIBRARY BOOKS =========");
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
            if (i < books.length - 1) {
                System.out.println();
                System.out.println("----------------------------");
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("===============================");
        System.out.println();

        System.out.println("========= LINEAR SEARCH =========");
        System.out.println();
        System.out.println("Searching: Ikigai");
        System.out.println();
        Book result1 = LinearSearch.search(books, "Ikigai");
        if (result1 != null) {
            System.out.println("Book Found");
            System.out.println();
            System.out.println(result1);
        } else {
            System.out.println("Book Not Found.");
        }
        System.out.println();
        System.out.println("===============================");
        System.out.println();

        System.out.println("========= BINARY SEARCH =========");
        System.out.println();
        System.out.println("Searching: Rich Dad Poor Dad");
        System.out.println();
        Book result2 = BinarySearch.search(books, "Rich Dad Poor Dad");
        if (result2 != null) {
            System.out.println("Book Found");
            System.out.println();
            System.out.println(result2);
        } else {
            System.out.println("Book Not Found.");
        }
        System.out.println();
        System.out.println("===============================");
        System.out.println();

        System.out.println("Searching: Wings of Fire");
        System.out.println();
        Book result3 = BinarySearch.search(books, "Wings of Fire");
        if (result3 != null) {
            System.out.println("Book Found");
            System.out.println();
            System.out.println(result3);
        } else {
            System.out.println("Book Not Found.");
        }
    }
}
