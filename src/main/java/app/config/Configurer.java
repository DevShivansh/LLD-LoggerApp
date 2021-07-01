package app.config;

public interface Configurer<K, V> {

	public void addConfig(K key, V value);
	
	public ConfigType getConfigType();
}
