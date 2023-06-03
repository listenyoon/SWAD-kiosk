import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Kiosk extends JFrame {
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JButton hamburgerButton;
    private JButton sideButton;
    private JButton drinkButton;

    private JPanel hamburgerPanel;
    private JButton bulgogiButton;
    private JButton shrimpButton;
    private JButton chickenButton;

    private JPanel sidePanel;
    private JButton friesButton;

    private JPanel drinkPanel;
    private JButton colaButton;
    private JButton ciderButton;

    Kiosk() {
        setTitle("키오스크");
        setLayout(new BorderLayout(20,20));

        title();
        startOrder();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 500);
        setVisible(true);
    }

    void title() {
        JPanel panel = new JPanel();

        JLabel label = new JLabel("[ 키오스크 ]");
        Font font = new Font("나눔고딕", Font.BOLD, 16);
        label.setFont(font);
        label.setBorder(BorderFactory.createEmptyBorder(20,10,0,10));
        panel.add(label);

        add(panel, BorderLayout.NORTH);
    }

    void startOrder() {
        JPanel panel = new JPanel();

        JButton startOrderBtn = new JButton("주문하기");
        startOrderBtn.setPreferredSize(new Dimension(250,350));
        Font font = new Font("나눔고딕", Font.BOLD, 20);
        startOrderBtn.setFont(font);
        startOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startOrderBtn.setVisible(false);
                startOrderBtn.setEnabled(false);
                panel.setVisible(false);
                panel.setEnabled(false);

                // 메인 화면으로 넘어가게 설정
//                Front.touchScreen();
                selectMenu();
                setCart();
            }
        });
        panel.add(startOrderBtn);
        add(panel, BorderLayout.CENTER);
    }

    void selectMenu() {
        // 메뉴 패널
        mainPanel = new JPanel(new BorderLayout());
        menuPanel = new JPanel(new GridLayout(1, 3, 5, 5));

        hamburgerButton = new JButton("햄버거");
        hamburgerButton.setPreferredSize(new Dimension(100,30));
        hamburgerButton.setBackground(Color.WHITE);
        hamburgerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // 버튼 색 변경도 필요함
                hamburgerPanel.setVisible(true);
                hamburgerPanel.setEnabled(true);
                hamburgerButton.setBackground(Color.LIGHT_GRAY);
                sidePanel.setVisible(false);
                sidePanel.setEnabled(false);
                sideButton.setBackground(Color.WHITE);
                drinkPanel.setVisible(false);
                drinkPanel.setEnabled(false);
                drinkButton.setBackground(Color.WHITE);
            }
        });
        menuPanel.add(hamburgerButton);

        sideButton = new JButton("사이드");
        sideButton.setPreferredSize(new Dimension(100,30));
        sideButton.setBackground(Color.WHITE);
        sideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hamburgerPanel.setVisible(false);
                hamburgerPanel.setEnabled(false);
                hamburgerButton.setBackground(Color.WHITE);
                sidePanel.setVisible(true);
                sidePanel.setEnabled(true);
                sideButton.setBackground(Color.LIGHT_GRAY);
                drinkPanel.setVisible(false);
                drinkPanel.setEnabled(false);
                drinkButton.setBackground(Color.WHITE);
            }
        });
        menuPanel.add(sideButton);

        drinkButton = new JButton("음료");
        drinkButton.setPreferredSize(new Dimension(100,30));
        drinkButton.setBackground(Color.WHITE);
        drinkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hamburgerPanel.setVisible(false);
                hamburgerPanel.setEnabled(false);
                hamburgerButton.setBackground(Color.WHITE);
                sidePanel.setVisible(false);
                sidePanel.setEnabled(false);
                sideButton.setBackground(Color.WHITE);
                drinkPanel.setVisible(true);
                drinkPanel.setEnabled(true);
                drinkButton.setBackground(Color.LIGHT_GRAY);
            }
        });
        menuPanel.add(drinkButton);

        mainPanel.add(menuPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        //////////////////////////////

        JPanel menuListPanel = new JPanel(new FlowLayout());

        // 1. 햄버거 패널
        hamburgerPanel = new JPanel(new FlowLayout());

        // 불고기버거
        bulgogiButton = new JButton("불고기버거");
        bulgogiButton.setPreferredSize(new Dimension(100,50));
        // bulgogi 버튼을 누를 때의 동작 구현
        bulgogiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: 불고기 버거를 선택한 경우의 동작 구현


            }
        });
        hamburgerPanel.add(bulgogiButton);

        // 새우버거
        shrimpButton = new JButton("새우버거");
        shrimpButton.setPreferredSize(new Dimension(100,50));
        // shrimp 버튼을 누를 때의 동작 구현
        shrimpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: 새우 버거를 선택한 경우의 동작 구현
            }
        });
        hamburgerPanel.add(shrimpButton);

        // 치킨버거
        chickenButton = new JButton("치킨버거");
        chickenButton.setPreferredSize(new Dimension(100,50));
        // chicken 버튼을 누를 때의 동작 구현
        chickenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: 치킨 버거를 선택한 경우의 동작 구현
            }
        });
        hamburgerPanel.add(chickenButton);

        menuListPanel.add(hamburgerPanel);


        // 2. 사이드 패널
        sidePanel = new JPanel(new FlowLayout());

        // 감자튀김
        friesButton = new JButton("감자튀김");
        friesButton.setPreferredSize(new Dimension(100,50));
        // fries 버튼을 누를 때의 동작 구현
        friesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: 감자튀김을 선택한 경우의 동작 구현
            }
        });
        sidePanel.add(friesButton);

        menuListPanel.add(sidePanel);


        // 3. 음료 패널
        drinkPanel = new JPanel(new FlowLayout());

        // 콜라
        colaButton = new JButton("콜라");
        colaButton.setPreferredSize(new Dimension(100,50));
        // cola 버튼을 누를 때의 동작 구현
        colaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: 콜라를 선택한 경우의 동작 구현
            }
        });
        drinkPanel.add(colaButton);

        // 사이다
        ciderButton = new JButton("사이다");
        ciderButton.setPreferredSize(new Dimension(100,50));
        // cider 버튼을 누를 때의 동작 구현
        ciderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: 사이다를 선택한 경우의 동작 구현
            }
        });
        drinkPanel.add(ciderButton);

        menuListPanel.add(drinkPanel);
        mainPanel.add(menuListPanel, BorderLayout.CENTER);


        // 개수 & 사이즈 입력 받기
        JPanel optionPanel = new JPanel(new BorderLayout());
        JPanel countPanel = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("개수 :");
        label1.setBorder(BorderFactory.createEmptyBorder(0,50,0,10));
        JTextField t1 = new JTextField(10);

        countPanel.add(label1);
        countPanel.add(t1);


        JPanel sizePanel = new JPanel(new FlowLayout());
        JLabel label2 = new JLabel("사이즈 :");
        JButton sizeBtn1 = new JButton("소");
        JButton sizeBtn2 = new JButton("중");
        JButton sizeBtn3 = new JButton("대");

        sizePanel.add(label2);
        sizePanel.add(sizeBtn1);
        sizePanel.add(sizeBtn2);
        sizePanel.add(sizeBtn3);

        optionPanel.add(countPanel, BorderLayout.NORTH);
        optionPanel.add(sizePanel, BorderLayout.CENTER);
        mainPanel.add(optionPanel, BorderLayout.SOUTH);

        // 초기에는 햄버거 패널을 보이도록 설정
        hamburgerPanel.setVisible(true);
        sidePanel.setVisible(false);
        drinkPanel.setVisible(false);
    }

    void setCart() {
        // 장바구니 패널
        JPanel panel = new JPanel(new BorderLayout());
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("[ 장바구니 ]"));
        panel.add(titlePanel, BorderLayout.NORTH);

        JPanel cartPanel = new JPanel(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("  상품명            단가                수량           금액      "));
        cartPanel.add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        JTextArea area = new JTextArea(5, 30);
        area.setText("주문 내역");
        area.setEditable(false);
        panel2.add(area);
        cartPanel.add(panel2, BorderLayout.CENTER);
        panel.add(cartPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton orderBtn = new JButton("주문하기");
        orderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuPanel.setVisible(false);
                menuPanel.setEnabled(false);
                mainPanel.setVisible(false);
                mainPanel.setEnabled(false);
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 주문 내역 확인 창으로 이동
                showOrder();
            }
        });
        btnPanel.add(orderBtn);
        panel.add(btnPanel, BorderLayout.SOUTH);

        add(panel, BorderLayout.SOUTH);
    }

    void showOrder() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("[ 주문 내역 ]"));
        panel.add(titlePanel, BorderLayout.NORTH);

        JPanel cartPanel = new JPanel(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("  상품명            단가                수량           금액      "));
        cartPanel.add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        JTextArea area = new JTextArea(5, 30);
        area.setText("주문 내역");
        area.setEditable(false);
        panel2.add(area);
        cartPanel.add(panel2, BorderLayout.CENTER);
        panel.add(cartPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton orderBtn = new JButton("결제");
        orderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 결제 진행 창으로 이동
                selectPaymentMethod();
            }
        });
        btnPanel.add(orderBtn);
        panel.add(btnPanel, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);
    }

    void selectPaymentMethod() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("결제 방법을 선택하세요");
        label.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        titlePanel.add(label);
        panel.add(titlePanel, BorderLayout.NORTH);

        JPanel methodPanel = new JPanel();
        JButton btn1 = new JButton("카드");
        btn1.setPreferredSize(new Dimension(80, 50));
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 카드 선택 창으로 이동
                payWithCard();
            }
        });

        JButton btn2 = new JButton("바코드");
        btn2.setPreferredSize(new Dimension(80, 50));
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 바코드 결제 창으로 이동
                payWithBarcode();
            }
        });

        methodPanel.add(btn1);
        methodPanel.add(btn2);
        panel.add(methodPanel, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
    }

    void payWithCard() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("결제할 카드를 입력해주세요");
        label.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        titlePanel.add(label);
        panel.add(titlePanel, BorderLayout.NORTH);

        JPanel cardPanel = new JPanel(new GridLayout(2,2, 5, 5));
        JButton btn1 = new JButton("농협 카드");
        btn1.setPreferredSize(new Dimension(80, 50));
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 영수증 출력 여부 선택 창으로 이동
                selectReceipt();
            }
        });

        JButton btn2 = new JButton("국민 카드");
        btn2.setPreferredSize(new Dimension(80, 50));
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 영수증 출력 여부 선택 창으로 이동
                selectReceipt();
            }
        });

        JButton btn3 = new JButton("신한 카드");
        btn3.setPreferredSize(new Dimension(80, 50));
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 영수증 출력 여부 선택 창으로 이동
                selectReceipt();
            }
        });

        JButton btn4 = new JButton("카카오 뱅크");
        btn4.setPreferredSize(new Dimension(80, 50));
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 영수증 출력 여부 선택 창으로 이동
                selectReceipt();
            }
        });

        cardPanel.add(btn1);
        cardPanel.add(btn2);
        cardPanel.add(btn3);
        cardPanel.add(btn4);
        panel.add(cardPanel, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
    }

    void payWithBarcode() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("결제할 바코드를 스캔해주세요");
        label.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        titlePanel.add(label);
        panel.add(titlePanel, BorderLayout.NORTH);

        JPanel cardPanel = new JPanel(new GridLayout(2,2, 10, 10));
        JButton btn1 = new JButton("2000원 할인 쿠폰");
        btn1.setPreferredSize(new Dimension(80, 50));
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 영수증 출력 여부 선택 창으로 이동
                selectReceipt();
            }
        });

        JButton btn2 = new JButton("10% 할인 쿠폰");
        btn2.setPreferredSize(new Dimension(80, 50));
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 영수증 출력 여부 선택 창으로 이동
                selectReceipt();
            }
        });

        JButton btn3 = new JButton("20% 할인 쿠폰");
        btn3.setPreferredSize(new Dimension(80, 50));
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 영수증 출력 여부 선택 창으로 이동
                selectReceipt();
            }
        });

        JButton btn4 = new JButton("30% 할인 쿠폰");
        btn4.setPreferredSize(new Dimension(80, 50));
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 영수증 출력 여부 선택 창으로 이동
                selectReceipt();
            }
        });

        cardPanel.add(btn1);
        cardPanel.add(btn2);
        cardPanel.add(btn3);
        cardPanel.add(btn4);
        panel.add(cardPanel, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
    }

    void selectReceipt() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("영수증을 출력하시겠습니까?");
        label.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        titlePanel.add(label);
        panel.add(titlePanel, BorderLayout.NORTH);

        JPanel methodPanel = new JPanel();
        JButton btn1 = new JButton("예");
        btn1.setPreferredSize(new Dimension(80, 50));
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 영수증 출력 창으로 이동
                printReceipt();
            }
        });

        JButton btn2 = new JButton("아니오");
        btn2.setPreferredSize(new Dimension(80, 50));
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 종료 창으로 이동
                end();
            }
        });

        methodPanel.add(btn1);
        methodPanel.add(btn2);
        panel.add(methodPanel, BorderLayout.CENTER);

        add(panel, BorderLayout.CENTER);
    }

    void printReceipt() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("[ 영수증 ]"));
        panel.add(titlePanel, BorderLayout.NORTH);

        JPanel cartPanel = new JPanel(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("  상품명            단가                수량           금액      "));
        cartPanel.add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        JTextArea area = new JTextArea(5, 30);
        area.setText("영수증 내역");
        area.setEditable(false);
        panel2.add(area);
        cartPanel.add(panel2, BorderLayout.CENTER);
        panel.add(cartPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton orderBtn = new JButton("다음");
        orderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel.setEnabled(false);
                // TODO: 종료 창으로 이동
                end();
            }
        });
        btnPanel.add(orderBtn);
        panel.add(btnPanel, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);
    }

    void end() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel titlePanel = new JPanel();
        JLabel label = new JLabel("결제가 완료되었습니다.");
        label.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        titlePanel.add(label);
        panel.add(titlePanel, BorderLayout.NORTH);

        JPanel orderNumberPanel = new JPanel();
        JLabel orderNumber = new JLabel("주문 번호 : "); // TODO : 주문 번호 숫자 같이 써주어야 함
        orderNumber.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        orderNumberPanel.add(orderNumber);
        panel.add(orderNumberPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton orderBtn = new JButton("종료");
        orderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnPanel.add(orderBtn);
        panel.add(btnPanel, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);
    }

    public static void main(String args[]){
       new Kiosk();
//         boolean status = true;
//         while (status) {
// //            new Kiosk();

//             System.out.println("키오스크 주문을 시작합니다.");
//             Front.touchScreen();
//             Front.selectMenu();
//             Front.accept();
//             Front.selectOrderInfo();
//             Front.insertCard();
//             Front.printReceipt();
//             System.out.println("주문 및 결제 완료\n");
//         }
    }
}
