package subscribtion.model;

public class NewsLetter {
    private int newsLetterid;
    private Category category;
    private String title;


    public NewsLetter(int newsLetterid, Category category, String title) {
        this.newsLetterid = newsLetterid;
        this.category = category;
        this.title = title;
    }


    public int getNewsLetterid() {
        return newsLetterid;
    }

    public void setNewsLetterid(int newsLetterid) {
        this.newsLetterid = newsLetterid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
