import java.util.*;

public class VendorMachine {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorMachine that = (VendorMachine) o;
        return productHashMap.equals(that.productHashMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productHashMap);
    }
    private Command command;
    public HashMap<ProductType,HashMap<Product, Stack<Product>>> productHashMap;

    public void initCommand(Command command){
        this.command = command;
    }

    public void fillMachne(Product product){
        if(product.equals(new Cola()) || product.equals(new Fanta()) || product.equals(new Sprite()))
            product.productType = new Drink();
        if(product.equals(new Leys()) || product.equals(new Doritos()) || product.equals(new Pringles()))
            product.productType = new Chips();
        if(product.equals(new Mars()) || product.equals(new Twix()) || product.equals(new KitKat()))
            product.productType = new Chocolate();

        if(productHashMap == null)
            productHashMap = new HashMap<>();
        if(!productHashMap.containsKey(product.productType)){
            productHashMap.put(product.productType,new HashMap<Product, Stack<Product>>());
        }
        if(productHashMap.containsKey(product.productType) && !productHashMap.get(product.productType).containsKey(product)){
            productHashMap.get(product.productType).put(product,new Stack<Product>());
            productHashMap.get(product.productType).get(product).push(product);
        }
        else if(productHashMap.containsKey(product.productType) && productHashMap.get(product.productType).containsKey(product)){
            productHashMap.get(product.productType).get(product).push(product);
            System.out.println(productHashMap.get(product.productType).get(product).peek());
        }
    }
    public ArrayList<Product> getProduct(){
        Product product = new Product();

        if (command.productType == 'A') {
            if (command.productID == 1)
                product = new Cola();
            if (command.productID == 2)
                product = new Fanta();
            if (command.productID == 3)
                product = new Sprite();
            product.productType = new Drink();
        }
        if (command.productType == 'B') {
            if (command.productID == 1)
                product = new Leys();
            if (command.productID == 2)
                product = new Doritos();
            if (command.productID == 3)
                product = new Pringles();
            product.productType = new Chips();
        }
        if (command.productType == 'C') {
            if (command.productID == 1)
                product = new Twix();
            if (command.productID == 2)
                product = new Mars();
            if (command.productID == 3)
                product = new KitKat();
            product.productType = new Chocolate();
        }

        Stack<Product> stack = productHashMap.get(product.productType).get(product);
        ArrayList<Product> productList = new ArrayList<Product>(Collections.nCopies(command.count,null));
        if(command.count <= stack.size()) {
            for (int i = 0; i < command.count; i++) {
                productList.set(i, stack.pop());
            }
        }
        else{
            productList = new ArrayList<Product>(Collections.nCopies(stack.size(),null));
            for (int i = 0; i < command.count; i++) {
                productList.set(i, stack.pop());
            }
        }

        return productList;
    }
}
