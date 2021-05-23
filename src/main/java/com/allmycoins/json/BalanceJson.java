package com.allmycoins.json;

public final class BalanceJson {

	private final String asset;
	private final float qty;
	private final String src;

	public BalanceJson(String asset, float qty, String src) {
		this.asset = asset;
		this.qty = qty;
		this.src = src;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BalanceJson other = (BalanceJson) obj;
		if (asset == null) {
			if (other.asset != null)
				return false;
		} else if (!asset.equals(other.asset))
			return false;
		if (Float.floatToIntBits(qty) != Float.floatToIntBits(other.qty))
			return false;
		if (src == null) {
			if (other.src != null)
				return false;
		} else if (!src.equals(other.src))
			return false;
		return true;
	}

	public String getAsset() {
		return asset;
	}

	public float getQty() {
		return qty;
	}

	public String getSrc() {
		return src;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asset == null) ? 0 : asset.hashCode());
		result = prime * result + Float.floatToIntBits(qty);
		result = prime * result + ((src == null) ? 0 : src.hashCode());
		return result;
	}

}
