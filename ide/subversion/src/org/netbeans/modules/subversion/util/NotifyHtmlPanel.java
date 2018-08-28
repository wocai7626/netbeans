/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.subversion.util;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import javax.swing.UIManager;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import org.netbeans.modules.subversion.Subversion;
import org.openide.awt.HtmlBrowser;

/**
 *
 * @author ondra
 */
public class NotifyHtmlPanel extends javax.swing.JPanel {

    /**
     * Creates new form SwitchToCliPanel
     */
    public NotifyHtmlPanel () {
        initComponents();
        Document doc = msgPanel.getDocument();
        if (doc instanceof HTMLDocument) { // Issue 185505
            HTMLDocument htmlDoc = (HTMLDocument)doc;
            Font font = UIManager.getFont("Label.font"); // NOI18N
            String bodyRule = "body { font-family: " + font.getFamily() + "; " // NOI18N
                + "color: " + SvnUtils.getColorString(msgPanel.getForeground()) + "; " //NOI18N
                + "font-size: " + font.getSize() + "pt; }"; // NOI18N
            htmlDoc.getStyleSheet().addRule(bodyRule);
        }
        msgPanel.setOpaque(false);
        msgPanel.setBackground(new Color(0,0,0,0)); // windows and nimbus workaround see issue 145826
    }

    public void setText (String text) {
        msgPanel.setText(text);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        msgPanel = new javax.swing.JTextPane();

        msgPanel.setBackground(new Color(0, 0, 0, 0));
        msgPanel.setContentType("text/html"); // NOI18N
        msgPanel.setEditable(false);
        msgPanel.setOpaque(false);
        msgPanel.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                msgPanelHyperlinkUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(msgPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void msgPanelHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_msgPanelHyperlinkUpdate
        if(evt.getEventType() != HyperlinkEvent.EventType.ACTIVATED) return;
        URL url = evt.getURL();
        HtmlBrowser.URLDisplayer displayer = HtmlBrowser.URLDisplayer.getDefault ();
        if (displayer != null) {
            displayer.showURL (url);
        } else {
            Subversion.LOG.info("No URLDisplayer found.");
        }
    }//GEN-LAST:event_msgPanelHyperlinkUpdate

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane msgPanel;
    // End of variables declaration//GEN-END:variables
}