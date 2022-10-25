package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    @OneToMany(mappedBy = "products")
    private List<MemberProduct> memberProducts = new ArrayList<>();


}
