public class DVD extends LibraryItem {
    private int duration;

    public DVD() {
        super();
    }

    public DVD(String title, String author, int year, boolean isAvailable, int duration) {
        super(title, author, year, isAvailable);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String getInfo() {
        return String.format("DVD(%s by %s, %d) - %d minutes", title, author, year, duration);
    }

    @Override
    public double calculateLateFee(int days) {
        double baseFee = 2000;
        if (duration > 120) baseFee *= 1.3;
        else if (duration < 90) baseFee *= 0.9;
        return baseFee * days;
    }

    @Override
    public String toString() {
        return String.format("DVD[title=%s,author=%s,year=%d,available=%b,duration=%d]",
                title, author, year, isAvailable, duration);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DVD)) return false;
        DVD other = (DVD) obj;
        return title.equals(other.title) &&
                author.equals(other.author) &&
                year == other.year &&
                duration == other.duration;
    }
}
