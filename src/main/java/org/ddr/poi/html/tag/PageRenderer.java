package org.ddr.poi.html.tag;

import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.ddr.poi.html.ElementRenderer;
import org.ddr.poi.html.HtmlConstants;
import org.ddr.poi.html.HtmlRenderContext;
import org.jsoup.nodes.Element;

import java.util.List;

public class PageRenderer implements ElementRenderer {
    private static final String[] TAGS = new String[]{HtmlConstants.TAG_PAGE};

    public PageRenderer() {
    }

    public boolean renderStart(Element element, HtmlRenderContext context) {
        IBody container = context.getContainer();
        List<XWPFParagraph> paragraphs = container.getParagraphs();
        if (paragraphs.size() > 0) {
            XWPFParagraph xwpfParagraph = (XWPFParagraph)paragraphs.get(paragraphs.size() - 1);
            XWPFParagraph newParagraph = container.insertNewParagraph(xwpfParagraph.getCTP().newCursor());
            newParagraph.setPageBreak(true);
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
