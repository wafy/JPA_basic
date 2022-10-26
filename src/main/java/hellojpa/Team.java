package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    /**
     * 반대편에서 정의되어 있는 변수 team
     * 주인이 아니면 mappedBy 속석으로 주인 지정
     * 팀에 의해서 관리가 된다는 의미이다
     * 조회만 할 수 있다. (수정삭제가 불가능)
     * 외래키가 있는 곳을 주인으로 정해라
     */
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();


    protected Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
