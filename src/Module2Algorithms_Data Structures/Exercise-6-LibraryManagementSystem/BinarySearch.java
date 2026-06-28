public class BinarySearch {

    public static Book search(Book[] books, String title) {
        if (books == null || books.length == 0 || title == null) {
            return null;
        }

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Book midBook = books[mid];

            if (midBook == null) {
                return null;
            }

            int comparison = midBook.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return midBook;
            }

            if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}
