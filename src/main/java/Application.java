import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Application {
    static String[] names;
    static ArrayList<Car> cars = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean inputEx = false;

        while (!inputEx) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
            try {
                inputName();
                inputEx = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
            
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int play = sc.nextInt();

        System.out.println("실행 결과");
        printRace(play);
            
        winner();

    }

    /* 자동차 이름 입력 */
    public static void inputName(){
        
        String input = sc.nextLine();
        names = input.split(",");

        for (int i = 0; i<names.length; i++){
            if (names[i].length() > 5)
                throw new IllegalArgumentException("자동차 이름은 5글자 이하입니다.");
            cars.add(new Car(names[i]));
        }

    }

    /* 난수로 자동차 진행 */
    public static void step(){
        Random rand = new Random();
        for (Car car : cars){
            int go = rand.nextInt(10);
            if ( go >= 4 ){
                car.go++;
            }
        }
    }

    /* 자동차 진행 출력 */
    public static void printRace(int play){
        for (int i = 0; i < play; i++) {
            step();
            printStep();
        }
    }
    public static void printStep(){
        for (Car car : cars){
            System.out.printf(car.name + " : " );
            printGo(car);
        }
        System.out.println();
    }
    public static void printGo(Car c){
        for (int i=0; i<c.go; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    /* 승부 */
    public static void winner(){
        ArrayList<Car> winners = new ArrayList<>();

        int maxGo = 0;
        /* maxGo 정의 */
        for (Car car : cars){
            if (car.go > maxGo){
                maxGo = car.go;
            }
        }

        /* maxGo와 비교해 winner에 넣음 */
        for (Car car : cars){
            if (car.go == maxGo){
                winners.add(car);
            }
        }

        System.out.printf("최종 우승자 : ");
        for (int i=0; i<winners.size(); i++){
            if (i > 0){
                System.out.printf(", ");
            }
            System.out.printf(winners.get(i).name);
        }
    }

}

class Car {
    String name;
    int go = 0;

    Car(String name){
        this.name = name;
    }
}