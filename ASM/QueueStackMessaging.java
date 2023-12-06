package ASM;

import java.util.Scanner;

public class QueueStackMessaging {
    public static void main(String[] args) {
        Queue<String> messageQueue = new Queue<>();
        Stack<String> messageStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Tùy chọn menu:");
            System.out.println("1. Tin nhắn đầu vào");
            System.out.println("2. Gửi tin nhắn");
            System.out.println("3. Xem tin nhắn đã gửi");
            System.out.println("4. Exit");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nhập tin nhắn (mỗi dòng một tin nhắn). Nhấn Enter với tin nhắn trống để hoàn tất:");
                    String inputMessage;
                    do {
                        inputMessage = scanner.nextLine();
                        if (!inputMessage.isEmpty()) {
                            if (inputMessage.length() <= 250) {
                                messageQueue.enqueue(inputMessage);
                                System.out.println("Tin nhắn được xếp hàng thành công.");
                            } else {
                                System.out.println("Độ dài tin nhắn vượt quá giới hạn tối đa (250 ký tự).");
                            }
                        }
                    } while (!inputMessage.isEmpty());
                    break;
                case 2:
                    try {
                        String sentMessage = messageQueue.dequeue();
                        messageStack.push(sentMessage);
                        System.out.println("Tin nhắn đã gửi: " + sentMessage);
                    } catch (IllegalStateException e) {
                        System.out.println("Hàng đợi tin nhắn trống. Không thể gửi tin nhắn.");
                    }
                    break;
                case 3:
                    System.out.println("Xem tin nhắn đã gửi:");
                    while (!messageStack.isEmpty()) {
                        System.out.println(messageStack.pop());
                    }
                    break;
                case 4:
                    System.out.println("Đang thoát khỏi chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một tùy chọn hợp lệ.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}