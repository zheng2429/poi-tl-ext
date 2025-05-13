package org.ddr.poi.html.tag;

import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.ddr.poi.html.ElementRenderer;
import org.ddr.poi.html.HtmlConstants;
import org.ddr.poi.html.HtmlRenderContext;
import org.jsoup.nodes.Element;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;

import java.util.List;

public class CatalogRenderer implements ElementRenderer {
    private static final String[] TAGS = new String[]{HtmlConstants.TAG_CATALOG};

    public CatalogRenderer() {
    }

    public boolean renderStart(Element element, HtmlRenderContext context) {
        IBody container = context.getContainer();
        List<XWPFParagraph> paragraphs = container.getParagraphs();
        if (paragraphs.size() > 0) {
            XWPFParagraph xwpfParagraph = (XWPFParagraph)paragraphs.get(paragraphs.size() - 1);
            XWPFParagraph newParagraph = container.insertNewParagraph(xwpfParagraph.getCTP().newCursor());
            CTSimpleField ctSimpleField = newParagraph.getCTP().addNewFldSimple();
            ctSimpleField.setInstr("TOC \\o \"1-3\" \\h \\z \\u");
        }

        return true;
    }

    public String[] supportedTags() {
        return TAGS;
    }

    public boolean renderAsBlock() {
        return false;
    }
}
