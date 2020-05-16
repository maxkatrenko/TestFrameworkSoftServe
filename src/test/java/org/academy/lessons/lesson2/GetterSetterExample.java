package org.academy.lessons.lesson2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetterSetterExample {
    public int someInt;
    public String someString;
}

class ImplGetterSetter {
    public static void main(String[] args) {
        GetterSetterExample gse = new GetterSetterExample();
        gse.setSomeInt(5);
        gse.setSomeString("Hello String");

        System.out.println("String is ".concat(gse.getSomeString()));
        System.out.println("Integer is " + gse.getSomeInt());
    }
}
