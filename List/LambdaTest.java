package List;

import java.util.function.Function;
import List.Compositum.English.DataNode;
import List.Compositum.English.Human;
import List.Compositum.English.MyListComp;
import List.Compositum.English.Node;

public class LambdaTest {
    
    public static void main(String[] args) {
        doSum(5, (Integer e) -> e + 1);
        System.out.println();
        MyListComp test = new MyListComp();
        test.append(new Human("Alice", 18));
        test.append(new Human("Bob", 25));
        test.printList();
        System.out.println();
        map(test, LambdaTest::ageUp);
        test.printList();
        System.out.println();
        map(test, ((Human h) -> {h.setAge(h.getAge() + 1); return h;}));
        test.printList();
        System.out.println();
        map(test, LambdaTest::giveTitle);
        test.printList();

    }

    public static Human ageUp(Human human) {
        human.setAge(human.getAge() + 1);
        return human;
    }

    public static Human giveTitle(Human human){
        human.setName("Dr. " + human.getName());
        return human;
    }

    public static void map(MyListComp test, Function<Human, Human> func) {
        Node tmp = test.getRoot();
        while(tmp instanceof DataNode){
            func.apply((Human) tmp.getData());
            tmp = tmp.getNext();
        }  
    }

    public static void doSum(int value, Function<Integer,Integer> inc){
        System.out.println(inc.apply(value));
    }
}
