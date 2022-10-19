package java_Imp_Concepts;

public class SingletonClass {
    private static SingletonClass obj = null;
    private String str;
    private SingletonClass(){
         str = "abcd";
    }

    public static SingletonClass getInstance(){
        if(obj == null){
            synchronized(SingletonClass.class){
                if(obj == null){
                    obj = new SingletonClass();
                }
            }
        }

        return obj;
    }

    public static void main(String[] args) {
        SingletonClass x = SingletonClass.getInstance();
        SingletonClass y = SingletonClass.getInstance();

        System.out.println(x.str);
        System.out.println(y.str);

        x.str = x.str.toUpperCase();

        System.out.println(x.str);
        System.out.println(y.str);


    }
}
