package subscribtion.model;

public class Technology implements Category{
    private int categoryId;
    private String categoryName;

    public Technology(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public String getName() {
        return categoryName;
    }
}
