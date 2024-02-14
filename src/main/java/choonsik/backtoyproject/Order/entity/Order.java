package choonsik.backtoyproject.Order.entity;


import choonsik.backtoyproject.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {

    private Member member;
    private String itemName;
    private int itemPrice;
    private int discountPrice;


    public int calculatePrice() {
        return itemPrice - discountPrice;
    }


    @Override
    public String toString() {
        return "Order{" +
                "name=" + member.getName() +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
