package com.fcy.test03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test07 {
	public static void main(String[] args) throws ParseException {
		String exAppKey = GameAppKey.getExAppKeyByGame("abc");
		System.out.println(exAppKey);
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").parse("2015-07-31 00:00:00");
		System.out.println(date.getTime());
		System.out.println(System.currentTimeMillis());
	}
	
	
}

enum GameAppKey {
	/**
	 * 命名统一用大写
	 */
	ABC("ABCdef"),
	DWCS("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi2KXYuNLBP2DmOXsDVi2WDqIEfn+QbJo4oxXCSngkgpOvG+XhNfeoMmJ/+GNLBtb7LWKUK8wJtBraFr1UdLhECo7qrDAt5KKXQ+GmI14yDpAeXpuVIuSWqw2oqT55eIUcN7bMuKNSc7GxJeLRxuRvoy2BDNEy7HpypZq9x6a76vb5LXCx+eV9b4i/FpoHRGZLHi+3UUyDaHYVtrgSVre+Dji36qgy4QP6OW5e/45YTlKLCzfKUJtRyiDwDeLGOFkfiIaqMO+yJRDY38D+4FisEijrBgb1gdadKFAoTB+dpDfxDD+vOsG2K8BQ6OzpUMCUAgRd/HWeDuxB8XGLMGEwQIDAQAB");
	
	private String exAppKey;
	
	private GameAppKey(String exAppKey){
		this.exAppKey = exAppKey;
	}
	
	private String getExAppKey(){
		return this.exAppKey;
	}
	
	/**
	 * 对外方法
	 * @param game
	 * @return
	 */
	public static String getExAppKeyByGame(String game) {
		return valueOf(game.toUpperCase()).getExAppKey();
	}
	
}
