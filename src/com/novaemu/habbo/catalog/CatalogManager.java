package com.novaemu.habbo.catalog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.novaemu.novaEmu;
import com.novaemu.habbo.catalog.types.CatalogItem;
import com.novaemu.habbo.catalog.types.CatalogPage;
import com.novaemu.utils.Logging;

public class CatalogManager {

	private Map<Integer, CatalogPage> ShopPages;
	
	public CatalogManager() {
		
		this.ShopPages = new HashMap<Integer, CatalogPage>();
	}
	
	public void loadPages() {
		try {
			
			ResultSet page = novaEmu.getServer().getStorage().readTable("SELECT * FROM catalog_pages");
			
			while(page.next()) {
				
				List<CatalogItem> items = this.loadItems(page.getInt("id"));
				
				String[] headlines = new String[] {
						page.getString("page_headline"),
						page.getString("page_teaser"),
						page.getString("page_special")
				};
				
				String[] teasers = new String[] {
						page.getString("page_text1"),
						page.getString("page_text2"),
						page.getString("page_text_details"),
						page.getString("page_text_teaser"),
						page.getString("page_link_description")
				};
				
				CatalogPage p = new CatalogPage(page.getInt("id"), page.getString("caption"), page.getInt("icon_image"), page.getInt("icon_color"), page.getInt("min_rank"), page.getString("page_layout"), page.getInt("parent_id"), items, headlines, teasers);
				this.getPages().put(p.Id, p);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CatalogItem> loadItems(int pageId) throws SQLException {
		ArrayList<CatalogItem> items = new ArrayList<CatalogItem>(); 
		ResultSet item = novaEmu.getServer().getStorage().readTable("SELECT * FROM catalog_items WHERE page_id = " + pageId);
		
		while(item.next()) {
			CatalogItem i = new CatalogItem(item.getInt("id"), item.getInt("item_ids"), item.getString("catalog_name"), item.getInt("cost_credits"), item.getInt("cost_pixels"), item.getInt("cost_snow"), item.getInt("amount"), false);
			
			items.add(i);
		}
		
		return items;
	}
	
	public CatalogPage getPage(int id) {
		if(this.getPages().containsKey(id)) {
			return this.getPages().get(id);
		}
		
		Logging.Write("Failed to get the catalog page: " + id);
		return null;
	}
	
	public Map<Integer, CatalogPage> getPages() {
		return this.ShopPages;
	}
	
}





