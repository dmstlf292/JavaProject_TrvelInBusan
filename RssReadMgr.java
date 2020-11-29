package tib;

import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class RssReadMgr {

	private String rssFeed = "http://www.kma.go.kr/wid/queryDFS.jsp?gridx=%s&gridy=%s";
	TibMapMgr mgr = null;
	String MAIN_TITLE = null;

	public RssReadMgr() {
		mgr = new TibMapMgr();
	}

	public WeatherBean getTownForecast(int UC_SEQ) {
		WeatherBean wbean = new WeatherBean();
		try {
			SAXBuilder parser = new SAXBuilder();
			parser.setIgnoringElementContentWhitespace(true);

			TravelBean bean =  mgr.getTravel(UC_SEQ);
			this.MAIN_TITLE = bean.getMAIN_TITLE();
			String url = String.format(rssFeed, bean.getGRIDX()+"", bean.getGRIDY()+"");
			Document doc = parser.build(url);
			Element root = doc.getRootElement();

			Element channel = root.getChild("body");
			List<Element> list = channel.getChildren("data");

			Element el = (Element) list.get(0);

			wbean.setMAIN_TITLE(MAIN_TITLE);
			wbean.setTemp(el.getChildTextTrim("temp"));
			wbean.setWfKor(el.getChildTextTrim("wfKor"));
			wbean.setSky(el.getChildTextTrim("sky"));
			wbean.setPty(el.getChildText("pty"));

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wbean;
	}
}