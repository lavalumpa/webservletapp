package it.engineering.web.test.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "mesto")
public class Mesto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pttBroj;
	private String naziv;
	
	
	public Mesto() {
	}
	
	public Mesto( String pttBroj, String naziv) {
		super();
		this.pttBroj = pttBroj;
		this.naziv = naziv;
	}
	public Mesto(Long id, String pttBroj, String naziv) {
		super();
		this.id = id;
		this.pttBroj = pttBroj;
		this.naziv = naziv;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPttBroj() {
		return pttBroj;
	}
	public void setPttBroj(String pttBroj) {
		this.pttBroj = pttBroj;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Mesto [id=" + id + ", pttBroj=" + pttBroj + ", naziv=" + naziv + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((pttBroj == null) ? 0 : pttBroj.hashCode());
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
		Mesto other = (Mesto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (pttBroj == null) {
			if (other.pttBroj != null)
				return false;
		} else if (!pttBroj.equals(other.pttBroj))
			return false;
		return true;
	}


	
	
	
	
}
