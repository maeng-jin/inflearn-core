package hello.core.order;

/**
 * 주문 서비스 - 인터페이스
 */
public interface OrderService {
    /**
     * 주문 생성 요청
     * @param memberId 회원 id
     * @param itemName 상품명
     * @param itemPrice 상품 가격
     * @return 생성 주문 정보
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
