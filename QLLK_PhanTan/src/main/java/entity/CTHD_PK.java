package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CTHD_PK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5131803261804232869L;
	private String HoaDon;
	private String linhKien;

	public CTHD_PK() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((HoaDon == null) ? 0 : HoaDon.hashCode());
		result = prime * result + ((linhKien == null) ? 0 : linhKien.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CTHD_PK other = (CTHD_PK) obj;
		if (HoaDon == null) {
			if (other.HoaDon != null)
				return false;
		} else if (!HoaDon.equals(other.HoaDon))
			return false;
		if (linhKien == null) {
			if (other.linhKien != null)
				return false;
		} else if (!linhKien.equals(other.linhKien))
			return false;
		return true;
	}

}
