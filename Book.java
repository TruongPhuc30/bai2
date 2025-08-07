public class Book extends LibraryItem {
    private int pages;

    public Book() {
        super();
        this.pages = 1;
    }

    public Book(String title, String author, int year, boolean isAvailable, int pages) {
        super(title, author, year, isAvailable);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String getInfo() {
        return String.format("Book(%s by %s, %d) - %d pages", title, author, year, pages);
    }

    @Override
    public double calculateLateFee(int days) {
        double baseFee = 1000;
        if (pages > 500) baseFee *= 1.5;
        else if (pages < 200) baseFee *= 0.8;
        return baseFee * days;
    }

    @Override
    public String toString() {
        return String.format("Book[title=%s,author=%s,year=%d,available=%b,pages=%d]",
                title, author, year, isAvailable, pages);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        return title.equals(other.title) &&
                author.equals(other.author) &&
                year == other.year &&
                pages == other.pages;
    }
}
