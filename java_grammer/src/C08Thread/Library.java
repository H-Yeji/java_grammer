package C08Thread;

public class Library {

    static int bookCount = 100; // 재고

    // 책 빌리기
    /*public static void borrow() throws InterruptedException {
        if (bookCount > 0) {
            try {
                //Thread.sleep(1000);
            } catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
            bookCount -= 1;
            System.out.println("대출 완료되었습니다. [남은 수량 : " + bookCount + "]");
        } else {
            System.out.println("책이 부족합니다. [대출 불가]");
        }

    }*/

    // synchronized 키워드를 통해 해당 메서드에 한해서 lock 걸도록 설정
    public static synchronized void borrow() {
        if (bookCount > 0) {
            try {
                Thread.sleep(300);
            } catch(IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bookCount -= 1;
            System.out.println("대출 완료되었습니다. [남은 수량 : " + bookCount + "]");
        } else {
            System.out.println("책이 부족합니다. [대출 불가]");
        }

    }
}
