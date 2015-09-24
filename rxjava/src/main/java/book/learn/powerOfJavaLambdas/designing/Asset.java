package book.learn.powerOfJavaLambdas.designing;

public class Asset {

	public enum AssetType {
		BOND, STOCK
	};

	private final AssetType type;
	private final int value;

	public Asset (final AssetType assetType, final int assetValue) {
		this.type = assetType;
		this.value = assetValue;
	}

	public AssetType getType() {
		return type;
	}

	public int getValue() {
		return value;
	}

}
