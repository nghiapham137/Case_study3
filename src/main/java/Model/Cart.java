package Model;

import Service.Service;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    Service service = new Service();
    private List<Inline_item> cart = new ArrayList<>();

    public Cart(List<Inline_item> cart) {
        this.cart = cart;
    }

    public Cart() {
        super();
    }

    public List<Inline_item> getCart() {
        return cart;
    }

    public void setCart(List<Inline_item> cart) {
        this.cart = cart;
    }

    public void addItem(Inline_item item) {
        if (cart.contains(item)) {
            Inline_item it = cart.get(cart.indexOf(item));
            it.setAmount(it.getAmount() + item.getAmount());
        } else {
            cart.add(item);
        }
    }

    public boolean deleteProduct(Inline_item item) {
        if (cart.contains(item)) {
            cart.remove(item);
            return true;
        }
        return false;
    }

    public float getTotalPrice(){
        float price = 0;
        for (Inline_item item : cart) {
            price += item.getUnitPrice() * item.getAmount();
        }
        return price;
    }

    public int getTotalItemInCard() {
        int total = 0;
        for (Inline_item item : cart) {
            total += item.getAmount();
        }
        return total;
    }

    public Inline_item getItemByProductId(int id) {
        for (Inline_item item : cart) {
            if (id == item.getProduct().getProductId()) {
                return item;
            }
        }
        Inline_item items = new Inline_item();
        items.setProduct(service.getProductById(id));
        items.setAmount(0);
        items.setUnitPrice(service.getProductById(id).getPrice());
        cart.add(items);
        return items;
    }
}
