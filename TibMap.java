package tib;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class TibMap{
	
	TibMapMgr mgr;

	public TibMap(int UC_SEQ) {
		
		mgr = new TibMapMgr();
		TravelBean bean = mgr.getTravel(UC_SEQ);
		
        EngineOptions options =
                EngineOptions.newBuilder(HARDWARE_ACCELERATED).build();
        
        Engine engine = Engine.newInstance(EngineOptions.newBuilder(RenderingMode.OFF_SCREEN)
        	    .licenseKey("1BNDHFSC1FXBCBVT3KQ1M0OKJ9BV2KQPCL0XRXMWQFZF5550AB5YA6031U4SH9QSFLK2E2").build());
        
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            // Creating and displaying Swing app frame.
            JFrame frame = new JFrame("Hello World");
            // Close Engine and onClose app window
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			String url = "http://jspstudy.co.kr/tib/map.jsp?";
			url+="&uc_seq="+UC_SEQ;
			url+="&main_title="+bean.getMAIN_TITLE();
			url+="&lat="+bean.getLAT();
			url+="&lng="+bean.getLNG();
			url+="&main_img_thumb="+bean.getMAIN_IMG_THUMB();
			url+="&addr1="+bean.getADDR1();
			url+="&homepage_url="+bean.getHOMEPAGE_URL();
			url+="&cntct_tel="+bean.getCNTCT_TEL();
            JTextField addressBar = new JTextField(url);
            addressBar.addActionListener(e ->
                    browser.navigation().loadUrl(addressBar.getText()));
            frame.add(addressBar, BorderLayout.NORTH);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            browser.navigation().loadUrl(addressBar.getText());
        });
    }

}
