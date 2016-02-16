package lan.training.spring.web.dto;

/**
 * Created by nik-lazer on 2/15/2016.
 */
public abstract class AbstractDto {
    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer id) {
        this.uid = id;
    }
}
