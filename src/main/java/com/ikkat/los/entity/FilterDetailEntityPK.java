package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FilterDetailEntityPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String filterid_h;
	private String filterid_d;
	public String getFilterid_h() {
		return filterid_h;
	}
	public void setFilterid_h(String filterid_h) {
		this.filterid_h = filterid_h;
	}
	public String getFilterid_d() {
		return filterid_d;
	}
	public void setFilterid_d(String filterid_d) {
		this.filterid_d = filterid_d;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filterid_d == null) ? 0 : filterid_d.hashCode());
		result = prime * result + ((filterid_h == null) ? 0 : filterid_h.hashCode());
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
		FilterDetailEntityPK other = (FilterDetailEntityPK) obj;
		if (filterid_d == null) {
			if (other.filterid_d != null)
				return false;
		} else if (!filterid_d.equals(other.filterid_d))
			return false;
		if (filterid_h == null) {
			if (other.filterid_h != null)
				return false;
		} else if (!filterid_h.equals(other.filterid_h))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FilterDetailEntityPK [filterid_h=" + filterid_h + ", filterid_d=" + filterid_d + "]";
	}
}
