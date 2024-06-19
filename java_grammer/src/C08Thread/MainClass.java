package C08Thread;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 스레드 생성방법
         * 1) 스레드 상속 방식
         * 2) 런어블 구현 방식
         *
         * 스레드 동시성 이슈 해결방법
         * 1) syncronized
         * 2) join()
         */

        /*// 스레드 생성방식
        // (1) 스레드 상속방식
        Thread t1 = new Thread1();
        // start 메서드가 상속되어 있고, 이 메서드를 통해 run 메서드 실행
        t1.start();
        Thread t2 = new Thread1();
        t2.start();

        // (2) Runnable 구현한 객체를 Thread 클래스에 주입하는 방식
        Thread t3 = new Thread(new Thread2());
        t3.start(); // Thread2 실행 시작
        new Thread(new Thread2()).start();
        new Thread(() ->System.out.println("익명 Runnable 객체 주입 후 실행 Thread")) // run밖에 없어서 run메서드가 실행됨
                 .start(); // 익명 Runnable 객체 주입 후 실행 Thread

        */
        // Thread 동시성 이슈 테스트
        // 단일 스레드 사용 -> 동시성 이슈 발생 x (그거 테스트)
        /*for (int i = 0; i < 105; i++){ // 단일 스레드 = 책 주문 키오스크 한 대
            Library.borrow();
        }*/
        //System.out.println("최종적으로 남은 수량 " + Library.bookCount);

        // 멀티 스레드
        /*for (int i = 0; i < 50000; i++) {
            new Thread(() -> {
                try {
                    Library.borrow();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        System.out.println("최종적으로 남은 수량 " + Library.bookCount);*/
        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(() -> {
                Library.borrow();
            });
            t1.start();

            // 동시성 이슈 해결 방법 첫번쩨 => join()
            // join() : 다른 스레드의 완료전까지 새로운 스레드가 실행되지 않음
            t1.join();
        }



    }
}
