package it.engineering.web.test.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "producer")
public class Producer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pib;
	private String maticniBroj;
	private String adresa;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Mesto")
	private Mesto mesto;
	
	public Producer() {
	}
	
	public Producer(String pib, String maticniBroj, String adresa, Mesto mesto) {
		super();
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		this.adresa = adresa;
		this.mesto = mesto;
	}

	public Producer(Long id, String pib, String maticniBroj, String adresa, Mesto mesto) {
		super();
		this.id = id;
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		this.adresa = adresa;
		this.mesto = mesto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	@Override
	public String toString() {
		return "Production [id=" + id + ", pib=" + pib + ", maticniBroj=" + maticniBroj + ", adresa=" + adresa
				+ ", mesto=" + mesto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresa == null) ? 0 : adresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maticniBroj == null) ? 0 : maticniBroj.hashCode());
		result = prime * result + ((mesto == null) ? 0 : mesto.hashCode());
		result = prime * result + ((pib == null) ? 0 : pib.hashCode());
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
		Producer other = (Producer) obj;
		if (adresa == null) {
			if (other.adresa != null)
				return false;
		} else if (!adresa.equals(other.adresa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maticniBroj == null) {
			if (other.maticniBroj != null)
				return false;
		} else if (!maticniBroj.equals(other.maticniBroj))
			return false;
		if (mesto == null) {
			if (other.mesto != null)
				return false;
		} else if (!mesto.equals(other.mesto))
			return false;
		if (pib == null) {
			if (other.pib != null)
				return false;
		} else if (!pib.equals(other.pib))
			return false;
		return true;
	}


	
}
