package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BusinessFilterConditionsPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4654113193974015053L;

	@Column(name = "bf_id", nullable = false)
	private Long bfId;

	@Column(name = "filter_id", nullable = false)
	private Long filterId;

	public Long getBfId() {
		return bfId;
	}

	public void setBfId(Long bfId) {
		this.bfId = bfId;
	}

	public Long getFilterId() {
		return filterId;
	}

	public void setFilterId(Long filterId) {
		this.filterId = filterId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bfId == null) ? 0 : bfId.hashCode());
		result = prime * result + ((filterId == null) ? 0 : filterId.hashCode());
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
		BusinessFilterConditionsPK other = (BusinessFilterConditionsPK) obj;
		if (bfId == null) {
			if (other.bfId != null)
				return false;
		} else if (!bfId.equals(other.bfId))
			return false;
		if (filterId == null) {
			if (other.filterId != null)
				return false;
		} else if (!filterId.equals(other.filterId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusinessFilterConditionsPK [bfId=" + bfId + ", filterId=" + filterId + "]";
	}
}
