import java.util.Objects;
import java.util.Stack;

public class Product {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        return getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType);
    }

    protected ProductType productType ;
}
