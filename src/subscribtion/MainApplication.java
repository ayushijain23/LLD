package subscribtion;

import subscribtion.model.*;
import subscribtion.service.CategoryService;

public class MainApplication {
    public static void main(String[] args) {
        User user1 = new User("101", "Rahul");
        User user2 = new User("102", "Rohit");


        Category scienceCategory = new Science(1, "Science");
        Category techCategory = new Technology(2, "Technology");

        CategoryService categoryService = new CategoryService();
        categoryService.addCategory(scienceCategory);
        categoryService.addCategory(techCategory);

        Category category = categoryService.searchCategory("Science");
        System.out.println(category.getName());

        NewsLetter newsLetter1 = new NewsLetter(1000, scienceCategory, "ScienceNewLetter");
        NewsLetter newsLetter2 = new NewsLetter(2000, techCategory, "TechNewsLetter");
        Subscription subscriptionUser1 = new Monthly();
        subscriptionUser1.subscribe(newsLetter1, user1, 100);
        subscriptionUser1.subscribe(newsLetter2, user1, 200);
        //when there is update
        //search category

        subscriptionUser1.notifyUsers();














    }

}
