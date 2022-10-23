package subscribtion.service;

import subscribtion.model.Category;
import java.util.ArrayList;
import java.util.List;


public class CategoryService {
    List<Category> categoryList = new ArrayList<>();
    public void addCategory(Category category){
        categoryList.add(category);
    }

    public Category searchCategory(String param){
        for(Category cat : categoryList){
            if(cat.getName().equals(param)){
                return cat;
            }
        }
        return null;
    }


}
