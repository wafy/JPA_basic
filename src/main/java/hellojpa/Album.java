package hellojpa;

import net.bytebuddy.utility.nullability.MaybeNull;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value = "A")
public class Album extends Item {

    private String artist;

}
