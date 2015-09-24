package book.learn.powerOfJavaLambdas.designing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import book.learn.powerOfJavaLambdas.designing.Asset.AssetType;

public class AssetUtil {
	
	public static void main(String[] args) {
		final List<Asset> assets = Arrays.asList(
				new Asset(Asset.AssetType.BOND, 1000),
				new Asset(Asset.AssetType.BOND, 2000),
				new Asset(Asset.AssetType.STOCK, 3000),
				new Asset(Asset.AssetType.STOCK, 4000)
				);	
		
		System.out.println("Total of all assets is: " + totalAssetValue(assets, as -> true));
		
		System.out.println("Total BOND assets is: " + totalAssetValue(assets, as -> as.getType() == AssetType.BOND));
		
		System.out.println("Total STOCK assets is: " + totalAssetValue(assets, as -> as.getType() == AssetType.STOCK));
	}
	
	public static int totalAssetValue(List<Asset> assets, Predicate<Asset> assetType) {
		return assets.stream()
				.filter(assetType)
				.mapToInt(Asset::getValue).sum();		
	}

}
