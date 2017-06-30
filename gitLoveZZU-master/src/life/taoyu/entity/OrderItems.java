package life.taoyu.entity;

import org.springframework.stereotype.Component;

@Component(value = "orderitems")
public class OrderItems {// ���Ķ���ʵ����

	private Integer items_id;// ������id
	private Integer goods_id;// ��Ʒid
	private int count;// ��Ʒ����
	// ��OO_id ���ά��������
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getItems_id() {
		return items_id;
	}

	public void setItems_id(Integer items_id) {
		this.items_id = items_id;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderItems [ goods_id=" + goods_id + ", count=" + count +",items_id="+items_id
				+ "]";
	}

}
