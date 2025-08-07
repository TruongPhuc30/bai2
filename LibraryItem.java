public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected int year;
    protected boolean isAvailable;

    public LibraryItem() {}

    public LibraryItem(String title, String author, int year, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract String getInfo();

    public abstract double calculateLateFee(int days);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        LibraryItem item = (LibraryItem) obj;
        return title.equals(item.title) &&
                author.equals(item.author) &&
                year == item.year;
    }

    @Override
    public String toString() {
        return String.format("LibraryItem[title=%s,author=%s,year=%d,available=%b",
                title, author, year, isAvailable);
    }
}
