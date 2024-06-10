package com.DAS.Entity;
//Make by Bình An || AnLaVN || KatoVN

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DanhgiaId implements java.io.Serializable {

	@Column(name = "USERNAME", nullable = false, length = 64)
	private String username;
	
	@Column(name = "IDKH", nullable = false, length = 20)
	private String idkh;

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DanhgiaId))
			return false;
		DanhgiaId castOther = (DanhgiaId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
				&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getIdkh() == castOther.getIdkh()) || (this.getIdkh() != null && castOther.getIdkh() != null
						&& this.getIdkh().equals(castOther.getIdkh())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getIdkh() == null ? 0 : this.getIdkh().hashCode());
		return result;
	}

}