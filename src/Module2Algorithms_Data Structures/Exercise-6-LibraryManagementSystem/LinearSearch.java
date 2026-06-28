public class LinearSearch {

    public static Book search(Book[] books, String title) {
        if (books == null || books.length == 0 || title == null) {
            return null;
        }

        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];

            if (currentBook != null && currentBook.getTitle().equalsIgnoreCase(title)) {
                return currentBook;
            }
        }

        return null;
    }
}
