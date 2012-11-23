package com.novaemu.habbo.catalog.types;

import java.util.List;

	public class CatalogPage
    {
        public int Id;
        public String Caption;
        public int Icon;
        public int Colour;
        public int MinRank;
        public String Template;
        public int ParentId;

        public List<CatalogItem> Items;

        public String[] Headlines;
        public String[] Teasers;

        public CatalogPage(int Id, String Caption, int Icon, int Colour, int MinRank, String Template, int ParentId, List<CatalogItem> Items, String[] Headlines, String[] Teasers)
        {
            this.Id = Id;
            this.Caption = Caption;
            this.Icon = Icon;
            this.Colour = Colour;
            this.MinRank = MinRank;
            this.Template = Template;

            this.ParentId = ParentId;

            this.Items = Items;

            this.Headlines = Headlines;
            this.Teasers = Teasers;
        }
    }
