package com.novaemu.habbo.catalog.types;

import com.novaemu.habbo.items.Item;
import com.novaemu.utils.Logging;
import com.novaemu.novaEmu;
public class CatalogItem {

	public int Id;
    public int ItemId;
    public String DisplayName;
    public int CostCredits;
    public int CostPixels;
    public int CostOther;
    public int Amount;
    public boolean Vip;

    public Item def;
	
    public CatalogItem(int id, int itemId, String displayName, int costCredits, int costPixels, int costOther, int amount, boolean vip) {
		this.Id = id;
		this.ItemId = itemId;
		this.DisplayName = displayName;
		this.CostCredits = costCredits;
		this.CostPixels = costPixels;
		this.CostOther = costOther;
		this.Amount = amount;
		this.Vip = vip;		
		
		if(novaEmu.getServer().getItemManager() == null) {
			Logging.Write("item manager is null");
		}
		
		this.def = novaEmu.getServer().getItemManager().getItem(this.ItemId);
	}
    
    public Item getDefinition() {
    	return this.def;
    }
}
