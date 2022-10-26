package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    protected Member() {
    }

    //기간 Period
    @Embedded
    private Period workPeriod;

    //주소
    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "city",
                    column = @Column(name = "work_city")),
            @AttributeOverride(name = "street",
                    column = @Column(name = "work_street")),
            @AttributeOverride(name = "zipcode",
                    column = @Column(name = "work_zipcode"))
})
private Address workAddress;

public Long getId(){
        return id;
        }

public void setId(Long id){
        this.id=id;
        }

public String getUsername(){
        return username;
        }

public void setUsername(String username){
        this.username=username;
        }

public Team getTeam(){
        return team;
        }

public void setTeam(Team team){
        this.team=team;
        }

public List<MemberProduct> getMemberProducts(){
        return memberProducts;
        }

public void setMemberProducts(List<MemberProduct> memberProducts){
        this.memberProducts=memberProducts;
        }

public Period getWorkPeriod(){
        return workPeriod;
        }

public void setWorkPeriod(Period workPeriod){
        this.workPeriod=workPeriod;
        }

public Address getHomeAddress(){
        return homeAddress;
        }

public void setHomeAddress(Address homeAddress){
        this.homeAddress=homeAddress;
        }
        }
