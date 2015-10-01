package lan.training.gwt.shared.dto;

import java.io.Serializable;

/**
 * Abstract data transfer object
 * @author nik-lazer  01.10.2015   11:11
 */
public abstract class AbstractDto implements Serializable {
	private Integer uid;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}
